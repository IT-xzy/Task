// var myapp = angular.module('myapp',[])
// .factory('greeter',function () {
//     return{
//         greet:function (msg) {
//             alert(msg);
//         }
//     }
// })
// .controller('myCtrl',function ($scope,greeter) {
//     $scope.sayHello=function () {
//         greeter.greet("Fuck you angular! you are too fucking hard for me!")
//     };
// });
//当AngularJS实例化这个模块时，会查找greeter并自然而然地把对它的引用传递进去


//service服务 服务提供了一种能在应用的整个生命周期内保持数据的方法，它能够在控制器之间进行通信，并且能保证数据的一致性。

angular.module('myApp.services', [])
