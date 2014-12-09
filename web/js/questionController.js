/**
 * Created by rafaganabreu on 07/12/14.
 */

// API multiple selector: http://loudev.com/#demos
// API image uploader: http://plugins.krajee.com/file-input/demo


$("#figure").fileinput({
    previewFileType: "image",
    browseClass: "btn btn-success",
    browseLabel: "Pick Image",
    browseIcon: '<i class="glyphicon glyphicon-picture"></i>',
    removeClass: "btn btn-danger",
    removeLabel: "Delete",
    removeIcon: '<i class="glyphicon glyphicon-trash"></i>',
    uploadClass: "btn btn-info",
    uploadLabel: "Upload",
    uploadIcon: '<i class="glyphicon glyphicon-upload"></i>'
});

$(".kv-fileinput-upload").hide();

$('.searchable').multiSelect({
    selectableHeader: "<input type='text' class='search-input' autocomplete='off' placeholder='Pesquisar'>",
    selectionHeader: "<input type='text' class='search-input' autocomplete='off' placeholder='Pesquisar'>",
    selectableOptgroup: true
});

function questionController($scope, $http) {
    $scope.qTypeV = 0;
    $("#questionType").prop("selectedIndex", -1);
    $scope.error = false;
    $scope.success = false;
    $scope.description = "";
    $scope.errorMessage = "";
    $scope.loading = false;

    $scope.onChangeQuestionType = function() {
        $scope.qTypeV = questionType.selectedIndex;
    };

    $scope.onClickSubmit = function() {
        var qStr = questionType == 0 ? "multiple_choice" : "true_or_false";
        var requestStr = "localhost:8080/aabe/api/questions/"+qStr;
        //var requestStr = "http://rafagan.com.br/aabe/api/questions/"+qStr;

        var json = {
            figure : $scope.figure,
            statement: statement.value,
            categories: []
        };

        switch(questionType) {
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
}

onFigureLoaded = function() {
    var file = $("#figure").prop("files")[0];

    if(!file) return;

    var reader = new FileReader();

    reader.onload = (function(inputHtmlFileData) {
        return function(e) {
            var $scope = angular.element($('#questionController')).scope();
            $scope.figure = dataURItoBlob(e.target.result, inputHtmlFileData.type);
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