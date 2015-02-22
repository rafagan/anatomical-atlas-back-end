/**
 * Created by rafaganabreu on 20/02/15.
 */

//jquery.asmselect: https://code.google.com/p/jquery-asmselect/

// TODO: Implementar sistema para visualizar questões que vem do servidor
// TODO: Verificar se as informações de envio para o servidor estão sendo validadas no JS

function insertQuizTestController($scope, $http, $timeout) {
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

            var prototype = $("#questionPrototype");

            $.each(response.questions, function(index, value) {
                prototype.append(new Option(value.statement, value.id));
            });

            prototype.asmSelect({
                animate: true,
                hideWhenAdded: true,
                removeLabel: "",
                selectClass: "form-control questionSelect",
                listItemClass: "form-control listItemCustom"
            });
        }).error(function(response){
            $scope.error = true;
            $scope.loading = false;
            $scope.errorMessage = "Houve problemas para baixar as questões públicas no servidor. Contate o administrador.";
        });

    $scope.onClickSubmit = function() {

        // TODO: Considerar depois que nem todo quiz test é público

        $scope.loading = true;
        $scope.success = false;
        $scope.error = false;
        var requestStr = "http://rafagan.com.br/api/v1/quiztests/"

        var json = {
            title : quizTitle.value,
            difficult : quizLevel.value,
            maxQuestions: maxQuestions.value,
            automatic: isAutomatic.checked,
            questions: []
        };

        if(!isAutomatic.checked) {
            $("#questionPrototype").find("option:selected").each(function (index, value) {
                json.questions.push(value.value);
            });
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
                    "Houve algum problema no servidor ao adicionar o quiz test. Contate o administrador.";
            });
    };

    $scope.onChangedPublicCheckbox = function() {
        $scope.success = false;
    }

    $scope.onQuestionValueChanged = function() {
        $scope.success = false;
    }
}