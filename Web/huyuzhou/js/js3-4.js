//
// var app = angular.module("myApp", ['ui.router']);
// //列表渲染
// app.config(function($stateProvider){
//   $stateProvider
//   $stateProvider.state(
//     {
//       name:'new',
//       url:'/new',
//       templateUrl:'js3-3.html'
//
//     }
//   ).state(
//     {
//       name:'list',
//       url:'/list/:page/:type',
//       templateUrl:"js3-4.html"
//     }
//   )
// })
// //自定义服务
// app.factory('dataFactory', function ($http){
//     var factory = {};
//     factory.getlist = function(params) {
// console.log(params)
//             return $http({
//                 url: "/carrots-admin-ajax/a/article/search/",
//                 method: "GET",
//                 params:params
//             })
//       };
//         return factory;
// });
// //控制器
// app.controller("myCtrl", function($scope,$http,$state,$stateParams,dataFactory) {
//   $scope.maxSize = 5;
//   $scope.totalItems = 175;
//   $scope.currentPage = 1;
//
//     $scope.dataFactory.getlist().then(function successCallback(response) {
//       $scope.pagination=response.data.data;
//       $scope.items=response.data.data.articleList;
//         console.log(response);
//     });
//     //输入页数
//         $scope.goTo=function(){
//           ($scope.goPage=="")?$scope.goPage="":$scope.goPage;
//           var page=$scope.goPage;
//           dataFactory.getlist({"page":page}).then(function successCallback(response) {
//             console.log(response.data);
//             $scope.items=response.data.data.articleList;
//             $state.go("list",{"page":page})
//         })
//       }
//     //搜索功能
//       $scope.search=function(stat,type){
//         dataFactory.getlist({"status":stat,"type":type}).
//           then(function successCallback(response) {
//                 $scope.pagination=response.data.data;
//                 $scope.items=response.data.data.articleList;
//                 console.log(response.data);
//                 $state.go("list",{"status":stat,"type":type})
//               })
//             }
//     //重置搜索
//     $scope.reset=function(){
//       dataFactory.getlist({"status":"","type":""}).
//       then(function successCallback(response) {
//             $scope.pagination=response.data.data;
//             $scope.items=response.data.data.articleList;
//             console.log(response.data);
//             $state.go("list",{"status":null,"type":null})
//           })
//     }
//
//       //删除功能
//       $scope.remove=function(id){
//         $http({
//             method: 'delete',
//             url: '/carrots-admin-ajax/a/u/article/'+id
//         }).then(function successCallback(response) {
//           $scope.data = response.data;
//           console.log($scope.data)
//           $state.go("list",{},{reload:true})
//         })
//       }
//   }
//
//
//
// )
//
// app.filter("typeChange",function(){
//   return function(type){
//     switch (type) {
//       case 0:
//       return "首页banner ";
//         break;
//       case 1:
//        return "找职位banner";
//        break;
//       case 2:
//       return "找精英banner";
//       break;
//       case 3:
//         return "行业大图";
//         break;
//     }
//   }
// })
// app.filter("statusChange",function(){
//   return function(status){
//     switch (status) {
//       case 1:
//        return "草稿";
//        break;
//       case 2:
//       return "上线";
//       break;
//     }
//   }
//   })
// app.filter("upNumber",function(){
//   return function(total){
//       console.log();
//       return Math.ceil(total/10)
//   }
//
// })
// //路由
//
// //导航列表显示隐藏切换
// app.controller("nav-list",function($scope){
//   $scope.listToggle=false;
//   $scope.toggle=function(){
//     $scope.listToggle=!$scope.listToggle;
//   }
// })
