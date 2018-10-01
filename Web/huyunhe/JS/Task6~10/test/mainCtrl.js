let myTest = angular.module('myTest',['ui.router']);
myTest.controller('mainCtrl',function () {

})

myTest.controller('producersCtrl',function ($scope,$state) {
  $scope.toPage2 = function (id) {
    $state.go('producer',{id: id});
  }
})

myTest.controller('producerCtrl',function ($scope,$stateParams) {
  console.log($stateParams.id);

})