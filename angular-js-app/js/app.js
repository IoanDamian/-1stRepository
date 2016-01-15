/*var app = angular.module('blog', [ ]);

app.controller('ClientController', function($scope,$http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  
 var url = "http://localhost:8080/client";
  $http.get(url).success(function(response) {
  	$scope.clienti = response;
  	console.log($scope.clienti);
  });
});*/


var app = angular.module('blog', []);

app.controller('ClientController', ['$scope', '$http', function ($scope, $http) {

    //$scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/client';

    $scope.clienti = [];
    $scope.fields = [];
    $scope.clienti = {};


    $scope.client = {};
    $scope.editClient = {};



    $http.get(url).then(function successCallback(response) {

        $scope.clienti = response;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.clienti);
        //console.log($scope.fields);

    });
    

    $scope.addClient = function(client) {
        client.id = parseInt(client.id);
        console.log(client.id);
        $http({
            method: 'POST',
            url: url,
            data: client
        }).then(function successCallback(response) {
            console.log(response);
            $scope.clienti.push(client);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteClient = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.clienti = $scope.clienti.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateClient = function(client) {
        $scope.editClient = client;
    };


    $scope.setUpdateClient = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editClient
        }).then(function successCallback(response) {
            $scope.editClient = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editClient = {};
            console.log(response);
        });
    };

}]);

app.controller('BonController', ['$scope', '$http', function ($scope, $http) {

    //$scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/bon';

    $scope.bonuri = [];
    $scope.fields = [];
    $scope.bonuri = {};


    $scope.bon = {};
    $scope.editBon = {};



    $http.get(url).then(function successCallback(response) {

        $scope.bonuri = response;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.bonuri);
        //console.log($scope.fields);

    });
    

    $scope.addBon = function(bon) {
        bon.id = parseInt(bon.id);
        console.log(bon.id);
        $http({
            method: 'POST',
            url: url,
            data: bon
        }).then(function successCallback(response) {
            console.log(response);
            $scope.bonuri.push(bon);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteBon = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.bonuri = $scope.bonuri.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateBon = function(bon) {
        $scope.editBon = bon;
    };


    $scope.setUpdateBon = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editBon
        }).then(function successCallback(response) {
            $scope.editBon = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editBon = {};
            console.log(response);
        });
    };

}]);

app.controller('ProdusController', ['$scope', '$http', function ($scope, $http) {

    //$scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/produs';

    $scope.produse = [];
    $scope.fields = [];
    $scope.produse = {};


    $scope.produs = {};
    $scope.editProdus = {};



    $http.get(url).then(function successCallback(response) {

        $scope.produse = response;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.produse);
        //console.log($scope.fields);

    });
    

    $scope.addProdus = function(produs) {
        produs.id = parseInt(produs.id);
        console.log(produs.id);
        $http({
            method: 'POST',
            url: url,
            data: produs
        }).then(function successCallback(response) {
            console.log(response);
            $scope.produse.push(produs);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteProdus = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.produse = $scope.produse.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateProdus = function(bon) {
        $scope.editProdus = produs;
    };


    $scope.setUpdateBon = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editProdus
        }).then(function successCallback(response) {
            $scope.editProdus = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editProdus = {};
            console.log(response);
        });
    };

}]);