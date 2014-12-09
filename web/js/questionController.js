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

    };
}

onFigureLoaded = function() {
    var reader = new FileReader();

    // Closure to capture the file information.
    reader.onload = (function(theFile) {
        return function(e) {
            var $scope = angular.element($('#questionController')).scope();
            $scope.figure = e.target.result;
            console.log($scope.figure);

            $("#teste").prop("src",$scope.figure);
        };
    })(file);

    reader.onerror = function(event) {
        console.error("File could not be read! Code " + event.target.error.code);
    };

    // Read in the image file as a data URL.
    reader.readAsDataURL($("#figure").prop("files")[0]);
};