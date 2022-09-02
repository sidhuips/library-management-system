'use strict';
 
angular.module('myLibraryApp').factory('LibraryService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/library-management-system/';
 
    var factory = {
    	findAllBooks: findAllBooks
    };
 
    return factory;
 
    function findAllBooks() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'books')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching products');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);