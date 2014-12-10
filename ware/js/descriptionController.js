/**
 * Created by rafaganabreu on 26/11/14.
 */

function descriptionController($scope, $http) {
    $scope.error = false;
    $scope.success = false;
    $scope.description = "";
    $scope.errorMessage = "";
    $scope.loading = false;
    $scope.names = [];
    $scope.queryResult = {};

    $scope.onChangeKnowledgeArea = (function(){
        $scope.loading = true;
        $scope.success = false;

        switch(knowledgeArea.selectedIndex) {
            case 0:
                $http.get("http://rafagan.com.br/api/boneparts")
                    .success(function(response) {
                        $scope.names = [];
                        $scope.queryResult = response.result;

                        $.each(response.result, function(index, value) {
                            $scope.names.push(value.name);
                        });

                        $scope.error = false;
                        $scope.loading = false;
                    }).error(function(response) {
                        $scope.error = true;
                        $scope.loading = false;
                        $scope.errorMessage = "Houve problemas para acessar as partes de ossos no servidor. Contate o administrador.";
                    });
                break;
            case 1:
                $http.get("http://rafagan.com.br/api/bonesets")
                    .success(function(response) {
                        $scope.names = [];
                        $scope.queryResult = response.result;

                        $.each(response.result, function(index, value) {
                            $scope.names.push(value.category);
                        });

                        $scope.error = false;
                        $scope.loading = false;
                    }).error(function(response) {
                        $scope.error = true;
                        $scope.errorMessage = "Houve problemas para acessar os conjuntos de ossos no servidor. Contate o administrador.";
                        $scope.loading = false;
                    });
                break;
            case 2:
                $http.get("http://rafagan.com.br/api/bones")
                    .success(function(response) {
                        $scope.names = [];
                        $scope.queryResult = response.result;

                        $.each(response.result, function(index, value) {
                            $scope.names.push(value.name);
                        });

                        $scope.error = false;
                        $scope.loading = false;
                    }).error(function(response) {
                        $scope.error = true;
                        $scope.errorMessage = "Houve problemas para acessar os ossos no servidor. Contate o administrador.";
                        $scope.loading = false;
                    });
                break;
        }
    });

    $scope.onChangeStructureSelection = (function(){
        $scope.success = false;
        $scope.description = $scope.queryResult[structureSelection.selectedIndex].description;
    });

    $scope.onClickSubmit = (function() {
        $scope.loading = true;
        $scope.success = false;

        var id = structureSelection.selectedIndex+1;

        switch(knowledgeArea.selectedIndex) {
            case 0:
                $http.put("http://rafagan.com.br/api/boneparts/"+id+"/description", {description: $scope.description})
                    .success(function(response) {
                        $scope.error = false;
                        $scope.loading = false;
                        $scope.success = true;
                        $scope.queryResult[id-1] = $scope.description;
                    }).error(function(response) {
                        $scope.error = true;
                        $scope.loading = false;
                        $scope.errorMessage = "Não foi possível atualizar a descrição. Contate o administrador.";
                    });
                break;
            case 1:
                $http.put("http://rafagan.com.br/api/bonesets/"+id+"/description", {description: $scope.description})
                    .success(function(response) {
                        $scope.error = false;
                        $scope.loading = false;
                        $scope.success = true;
                        $scope.queryResult[id-1] = $scope.description;
                    }).error(function(response) {
                        $scope.error = true;
                        $scope.loading = false;
                        $scope.errorMessage = "Não foi possível atualizar a descrição. Contate o administrador.";
                    });
                break;
            case 2:
                $http.put("http://rafagan.com.br/api/bones/"+id+"/description", {description: $scope.description})
                    .success(function(response) {
                        $scope.error = false;
                        $scope.loading = false;
                        $scope.success = true;
                        $scope.queryResult[id-1] = $scope.description;
                    }).error(function(response) {
                        $scope.error = true;
                        $scope.loading = false;
                        $scope.errorMessage = "Não foi possível atualizar a descrição. Contate o administrador.";
                    });
                break;
        }
    });

    $("#knowledgeArea").prop("selectedIndex", -1);
    $("#structureSelection").prop("selectedIndex", -1);
}