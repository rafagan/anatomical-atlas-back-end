/**
 * Created by rafaganabreu on 20/02/15.
 */

function insertQuizTestController($scope, $http, $timeout) {
    $("select[multiple]").asmSelect({
        animate: true,
        hideWhenAdded: true,
        removeLabel: "",
        selectClass: "form-control questionSelect",
        listItemClass: "form-control listItemCustom"
    });

    $scope.publicQuestions = [];
    $scope.error = false;
    $scope.success = false;
    $scope.loading = true;

    //Alguém esta mudando o valor do checked e eu não faço ideia quem
    $timeout(function() {
        //Por enquanto, o quiz test sempre será públic
        draw(isPublic, 'checkmark');
        isPublic.checked = true;
        isPublic.disabled = true;
    }, 500);

    $http.get("http://rafagan.com.br/api/v1/questions")
        .success(function(response) {
            $scope.publicQuestions = response.questions;
            $scope.loading = false;

            var questionSelect = $(".questionSelect");
            var prototype = $("select[multiple]");
            $.each(response.questions, function(index, value) {
                var option = new Option(value.statement, value.id);
                questionSelect.append(option);
                console.log(questionSelect);
                prototype.append(option);
            });
        }).error(function(response){
            $scope.error = true;
            $scope.loading = false;
            $scope.errorMessage = "Houve problemas para baixar as questões públicas no servidor. Contate o administrador.";
        });

    $scope.onClickSubmit = function() {

    }

    $scope.onChangedPublicCheckbox = function() {
        console.log(isPublic.checked);
    }
}