/**
 * Created by rafaganabreu on 07/12/14.
 */

// API multiple selector: http://loudev.com/#demos
// API image uploader: http://plugins.krajee.com/file-input/demo


$("#figure").fileinput({
    previewFileType: "image",
    browseClass: "btn btn-success",
    browseLabel: "Escolha a imagem",
    browseIcon: '<i class="glyphicon glyphicon-picture"></i>',
    removeClass: "btn btn-danger",
    removeLabel: "Delete",
    removeIcon: '<i class="glyphicon glyphicon-trash"></i>',
    uploadClass: "btn btn-info",
    uploadLabel: "Upload",
    uploadIcon: '<i class="glyphicon glyphicon-upload"></i>'
});

$(".kv-fileinput-upload").hide();

function loadStructuresToCategories($scope, $http) {
    $scope.loading = true;
    var cat = $('#custom-headers');

    $http.get("http://rafagan.com.br/api/bonesets")
        .success(function(response1) {
            $.each(response1.result, function(index, value) {
                cat.multiSelect('addOption',{
                    value: value.idBoneSet,
                    text: value.category ,
                    index: 0,
                    nested: 'Conjuntos de ossos'
                });
                $scope.categories[value.category] = value.idBoneSet;
            });

            $http.get("http://rafagan.com.br/api/bones")
                .success(function(response2) {
                    $.each(response2.result, function(index, value) {
                        cat.multiSelect('addOption', {
                            value: value.idBone + response1.result.length,
                            text: value.name,
                            index: 0,
                            nested: 'Ossos'
                        });
                        $scope.categories[value.name] = value.idBone;
                    });

                    //Temporário até haver suporte a bones
                    $.each($(".ms-optgroup-container + .ms-optgroup-container ul > li"), function(index, value) {
                        value.className = value.className + " disabled";
                    });

                    $http.get("http://rafagan.com.br/api/boneparts")
                        .success(function(response3) {
                            $.each(response3.result, function (index, value) {
                                cat.multiSelect('addOption', {
                                    value: value.idBonePart  + response1.result.length + response2.result.length,
                                    text: value.name,
                                    index: 0,
                                    nested: 'Partes de um osso'
                                });
                                $scope.categories[value.name] = value.idBonePart;
                            });

                            //Temporário até haver suporte a bones
                            $.each($(".ms-optgroup-container + .ms-optgroup-container + .ms-optgroup-container ul > li"), function(index, value) {
                                value.className = value.className + " disabled";
                            });
                        }).error(function(response) {
                            $scope.loading = false;
                            $scope.error = true;
                            $scope.errorMessage = "Houve problemas para carregar as categorias do servidor. Contate o administrador.";
                        });
                    $scope.loading = false;
                }).error(function(response) {
                    $scope.loading = false;
                    $scope.error = true;
                    $scope.errorMessage = "Houve problemas para carregar as categorias do servidor. Contate o administrador.";
                });
        }).error(function(response) {
            $scope.loading = false;
            $scope.error = true;
            $scope.errorMessage = "Houve problemas para carregar as categorias do servidor. Contate o administrador.";
        });
}

function QuestionController($scope, $http) {
    $scope.qTypeV = 0;
    $("#questionType").prop("selectedIndex", -1);
    $scope.error = false;
    $scope.success = false;
    $scope.errorMessage = "";
    $scope.loading = false;
    $scope.categories = {};

    $scope.onChangeQuestionType = function() {
        $scope.qTypeV = questionType.selectedIndex;
        $scope.success = false;
    };

    $scope.onClickSubmit = function() {
        $scope.loading = true;

        var qStr = questionType == 0 ? "multiple_choice" : "true_or_false";
        var requestStr = "http://rafagan.com.br/api/questions/"+qStr;

        var json = {
            figure : $scope.figure,
            statement: statement.value,
            categories: []
        };

        $(".ms-selected").each(function(){
            var text = $(this).text();

            if($scope.categories[text] != undefined)
                json.categories.push($scope.categories[text]);
        });

        switch($scope.qTypeV) {
            case 0:
                json["correctAnswer"] = answer.value;
                json["answerA"] = assertion1.value;
                json["answerB"] = assertion2.value;
                json["answerC"] = assertion3.value;
                json["answerD"] = assertion4.value;
                json["answerE"] = assertion5.value;
                break;
            case 1:
                json["correctAnswer"] = $("#option1").prop("checked");
                break;
        }

        $http.post(requestStr, json)
            .success(function(response) {
                $scope.error = false;
                $scope.loading = false;
                $scope.success = true;
            }).error(function(response) {
                $scope.error = true;
                $scope.loading = false;
                $scope.errorMessage =
                    "Houve algum problema no servidor ao adicionar a questão. Contate o administrador.";
            });
    };

    loadStructuresToCategories($scope, $http);
}

onFigureLoaded = function() {
    var file = $("#figure").prop("files")[0];
    if(!file) return;
    var reader = new FileReader();

    reader.onload = (function(inputHtmlFileData) {
        return function(e) {
            var $scope = angular.element($('#QuestionController')).scope();
            $scope.figure = e.target.result.split(',')[1];
            //$scope.figure = dataURItoBlob(e.target.result, inputHtmlFileData.type);
            //saveAs(dataURItoBlob($scope.figure, inputHtmlFileData.type), "figure.jpg");
        };
    })(file);

    reader.onerror = function(event) {
        $scope.error = true;
        $scope.errorMessage =
            "Não foi possivel ler a imagem com o formato especificado. " +
            "Utilize um formato conhecido (JPEG, PNG). Erro: " + event.target.error.code;
    };

    // Read in the image file as a data URL.
    reader.readAsDataURL(file);
};


function dataURItoBlob(dataURI, dataTYPE) {
    var binary = atob(dataURI.split(',')[1]), array = [];
    for(var i = 0; i < binary.length; i++) array.push(binary.charCodeAt(i));
    return new Blob([new Uint8Array(array)], {type: dataTYPE});
}


$('#custom-headers').multiSelect({
    selectableHeader: "<input type='text' class='search-input' autocomplete='off' placeholder='Pesquisar' ng-model='selectableText'>",
    selectionHeader: "<input type='text' class='search-input' autocomplete='off' placeholder='Pesquisar' ng-model='selectionText'>",
    cssClass: "categoriesStyle",
    afterInit: function(ms){
        var that = this,
            $selectableSearch = that.$selectableUl.prev(),
            $selectionSearch = that.$selectionUl.prev(),
            selectableSearchString = '#'+that.$container.attr('id')+' .ms-elem-selectable:not(.ms-selected)',
            selectionSearchString = '#'+that.$container.attr('id')+' .ms-elem-selection.ms-selected';

        that.qs1 = $selectableSearch.quicksearch(selectableSearchString)
            .on('keyup', function(e){
                if (e.which === 40){
                    that.$selectableUl.focus();
                    return false;
                }

                var $scope = angular.element($('#QuestionController')).scope();

                $(".ms-elem-selectable").each(function(){
                    var text = $(this).text();
                    (text.indexOf($scope.selectableText) != -1) ? $(this).show() : $(this).hide();
                });
            });

        that.qs2 = $selectionSearch.quicksearch(selectionSearchString)
            .on('keyup', function(e){
                if (e.which === 40){
                    that.$selectionUl.focus();
                    return false;
                }

                var $scope = angular.element($('#QuestionController')).scope();

                $(".ms-selected").each(function(){
                    var text = $(this).text();
                    (text.indexOf($scope.selectionText) != -1) ? $(this).show() : $(this).hide();
                });
            });
    },
    afterSelect: function(){
        this.qs1.cache();
        this.qs2.cache();
    },
    afterDeselect: function(){
        this.qs1.cache();
        this.qs2.cache();
    }
});