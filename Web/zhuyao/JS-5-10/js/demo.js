// function Person() {
//     this.name = '齐天大圣';
//     this.生命值 = 9999;
// }
// Person.prototype.run = function (speed) {
//         /*奔跑的齐天大圣*/
//         return speed * 100;
//     };
// Person.prototype.attack = function () {/*闪现平A*/};
// Person.prototype.death = function () {/*潇洒go die*/};
// Person.prototype.defense = function () {/*看我金刚不坏之身*/};
//
// var monkey = new Person();
// console.log(monkey.run(1));
var app = angular.module("myApp", []);
app.factory('myFactory', function () {
   var obj = {};
   var age;
   obj.name = 'zhangsan';
   obj.setAge = function (newAge) {
       age = newAge;
   };
   obj.getAge = function () {
       return age;
   };
   return obj;
});
app.controller('myCtrl', function ($scope, myFactory) {
   myFactory.setAge(20);
   $scope.r = myFactory.getAge();
   console.log(myFactory);
   $scope.age = 15;
});