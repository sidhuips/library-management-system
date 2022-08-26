'use strict';
 
angular.module('myCrudApp').controller('LibraryController', ['$scope', 'LibraryService', function($scope, LibraryService) {
    var self = this;
    self.book = { id: '', bookName:'', type: '', author:'' }
    self.books = [];
 

    findAllBooks();
 
    function findAllBooks(){
    	LibraryService.findAllBooks()
            .then(
            function(d) {
                self.books = d;
            },
            function(errResponse){
                console.error('Error while fetching products');
            }
        );
    }
    
 
}]);