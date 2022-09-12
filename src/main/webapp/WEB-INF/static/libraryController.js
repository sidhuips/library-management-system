'use strict';
 
angular.module('myLibraryApp').controller('LibraryController', ['$scope','$attrs', '$http', 'LibraryService', function($scope, LibraryService) {
    var self = this;
    self.book = { id: '', bookName:'', type: '', author:'' }
    self.books = [];

    findAllBooks();
 
    function findAllBooks(){
	console.log('id to be read');
    	LibraryService.findAllBooks()
            .then(
            function(d) {
                self.books = d;
                $scope.books = d;
            },
            function(errResponse){
                console.error('Error while fetching products');
            }
        );
    }       
}]);