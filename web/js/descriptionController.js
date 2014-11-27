/**
 * Created by rafaganabreu on 26/11/14.
 */

function descriptionController($scope, $http) {
    $scope.error = false;
    $scope.description = "Descrição atual";

    $http.get("http://www.w3schools.com/website/Customers_JSON.php")
        .success(function(response) {
            $scope.names = response;});

    $scope.onChangeKnowledgeArea = (function(){
        switch(knowledgeArea.selectedIndex) {
            case 0:
                $http.get("http://rafagan.com.br/AABE/api/boneparts")
                    .success(function(response) {$scope.names = response;});
                break;
            case 1:
                $http.get("http://rafagan.com.br/AABE/api/bonesets")
                    .success(function(response) {$scope.names = response;});
                break;
            case 2:
                $http.get("http://rafagan.com.br/AABE/api/bones")
                    .success(function(response) {$scope.names = response;});
                break;
        }
    });

    $scope.onClickSubmit = (function() {
        console.log($scope.description);
    });

    $("#knowledgeArea").prop("selectedIndex", -1);
    $("#structureSelection").prop("selectedIndex", -1);
}