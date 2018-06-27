// var s1="some text";
// var s2=s1.substring(2);
// console.log(s2);

//区别就是生存期

// var s1="some text";
// s1.color="red";
// console.log(s1.color);

//
// var value="25";
// var number= Number(value);
// console.log(typeof number);
//
// var obj=new Number(value);
// console.log(typeof obj);

//
// var num=10.000;
// console.log(num.toFixed(5));
//
// var num=10000;
// console.log(num.toExponential(2));
//
// var num=99;
// console.log(num.toPrecision(3));

// var stringValue="hello world";
// console.log(stringValue.charAt(7));

// var stringvalue="dadal awea l;d apd la;d;la adawrdaretgr rgd;pwqda"
// var position=[];
// var pos=stringvalue.indexOf("a");
//
// while(pos>-1){
//     position.push(pos);
//     pos=stringvalue.indexOf("a",pos+1);
// }
// console.log(position);

// var string = "dad dasd asda";
// var matt=string.toUpperCase();
// console.log(matt);

// var text="cat,bat,sat,fat";
// var patter=/.at/;
//
// var matches=text.match(patter);
// console.log(matches);

// var text="css,bat,sat,fat";
// var pos=text.search(/at/);
// console.log(pos);
//
// replace();
// //
// // //
// //  var a=10;
// // var b=20;
// //   a=b;
// // console.log(a);
// var value="hello world";
// console.log(value.slice(3));
// console.log(value.substr(3));
// console.log(value.substring(3));
// var value="hello world";
// console.log(value.slice(1,3));
// console.log(value.substr(1,3));
// console.log(value.substring(1,3));
// angular.module('myApp').controller('loginController',function($scope,$http,$state){
//     $scope.login=function(){
//         $http({
//             url:'/carrots-admin-ajax/a/login',
//             method:'POST',
//             params: $scope.pt,
//             header:{'Content-Type':'application/x-www-form-urlencoded'}//表头
//         }).then(function (response){
//             if(response.data.message == "success"){
//                 $state.go('dashboard');
//             } else {
//                 $(".text-danger").text(response.data.message);
//             }
//         })
//     }
//
// })
// <!DOCTYPE html>
// <html data-ng-app="myApp">
//     <head>
//     <!--<base href="/"/>-->
//     <meta charset="UTF-8">
//     <title>萝卜多后台管理系统</title>
//     <meta name="viewport" content="width=device-width">
//     <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
//     <link rel="stylesheet" href="css/login.css" />
//     <link rel="stylesheet" href="css/dashboard.css" />
//     <link rel="stylesheet" href="css/articleList.css" />
//     </head>
//     <body>
//     <div data-ui-view=""></div>
//     <script type="text/javascript" src="js/jquery-3.2.1.min.js" ></script>
//     <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
//     <script type="text/javascript" src="js/angular.min.js" ></script>
//     <script type="text/javascript" src="js/angular-ui-router.min.js" ></script>
//     <script src="http://cdn.bootcss.com/angular-ui-bootstrap/2.2.0/ui-bootstrap-tpls.js"></script>
//     <script src="https://cdn.bootcss.com/angular-i18n/1.5.8/angular-locale_zh-cn.js"></script>
//     <script type="text/javascript" src="js/bootbox.min.js" ></script>
//     <script src="https://cdn.bootcss.com/oclazyload/1.1.0/ocLazyLoad.js"></script>
//     <script type="text/javascript" src="js/app.js" ></script>
//     <script type="text/javascript" src="js/filter.js" ></script>
//     <script type="text/javascript" src="js/login.js" ></script>
//     <!--<script src="js/sidebar.js"></script>-->
//     <script type="text/javascript" src="js/dashboard.js" ></script>
//
//     <!--<script src="js/directive/accordion.js"></script>-->
//     <script type="text/javascript" src="js/articleList.js" ></script>
//     <script src="js/ueditor/ueditor.config.js"></script>
//     <script src="js/ueditor/ueditor.all.js"></script>
//     <script src="js/ueditor/angular-ueditor.min.js"></script>
//     <script src="js/imgLoad.js"></script>
//     </body>
//     </html>

// //appjs
// var myApp = angular.module("myApp",["ui.router","ui.bootstrap","oc.lazyLoad","ng.ueditor"]);
// myApp.config(function ($stateProvider, $urlRouterProvider,$ocLazyLoadProvider,$locationProvider) {
// //	$locationProvider.html5Mode(true); //去掉#
//     var _lazyLoad = function (loaded) {
//         return function ($ocLazyLoad) {
//             return $ocLazyLoad.load(loaded, {serie: true});
//         }
//     };
//
//     $urlRouterProvider.otherwise("/login");
//     $stateProvider
//         .state("login",{
//             url:"/login",
//             templateUrl: "login.html"
//         })
//         .state("dashboard",{
//             url:"/dashboard",
//             templateUrl: "dashboard.html"
//         })
//         .state("dashboard.articleDetail",{
//             url:"/articleDetail?id",
//             templateUrl: "articleDetail.html",
//             controller: 'articleDetail',
//             resolve: {
//                 loadMyFile:_lazyLoad(['js/articleDetail.js'])
//             },
//             params:{
//                 'id':null
//             }
//         })
//         .state("dashboard.company",{
//             url: "/company",
//             templateUrl:"company.html"
//         })
//         .state("dashboard.job",{
//             url: "/job",
//             templateUrl:"job.html"
//         })
//         .state("dashboard.text",{
//             url: "/text",
//             template:"文章管理"
//         })
//         .state("dashboard.articleList",{
//             url: "/articleList?startAt&endAt&type&status&size&page",
// //             templateUrl:"articleList.html",
// //             controller: 'articleListCtrl'
// //         });
// //
// // });
// var app = angular.module('myApp');
// app.controller('articleListCtrl', function($scope, $http,$state,$stateParams,Type,Status,Industry) {
//     $scope.infoParams = {};
//     $scope.infoParams.type = $stateParams.type;
//     $scope.infoParams.status = $stateParams.status;
//     $scope.infoParams.page = $stateParams.page;
//     $scope.infoParams.size = $stateParams.size;
//     $scope.Type = Type;
//     $scope.Status = Status;
//     $scope.Industry = Industry;
//     console.log($stateParams.page);
//     http();
//     //封装传参
//     $scope.carryout = function() {
//
//         $state.go('dashboard.articleList',{
//             'startAt' : $scope.dt1?Date.parse($scope.dt1):'',
//             'endAt' : $scope.dt2?Date.parse($scope.dt2):'',
//             'type' : $scope.type,
//             'status' : $scope.status,
//             'page' : $scope.jump,
//             'size' : $scope.size
//         },{reload:true});
//     };
//     $scope.dt1 = new Date(parseInt($stateParams.startAt)); //转化成对象
//     $scope.dt2 = new Date(parseInt($stateParams.endAt));
//     $scope.status = $stateParams.status;
//     $scope.type = $stateParams.type;
//     $scope.size = $stateParams.size;
//     //if判断如果无法正确显示日期(时间为空)则赋值为空，否则会NaN，也可以判断
//     if ($scope.dt1 == "Invalid Date") {
//         $scope.dt1 = '';
//     }
//     if ($scope.dt2 == "Invalid Date") {
//         $scope.dt2 = '';
//     }
//     //传递参数
//
//     //请求数据
//     function http(){
//         $scope.infoParams.startAt = $stateParams.startAt;
//         $scope.infoParams.endAt =$stateParams.endAt;
//         $http({
//             method: "GET",
//             url: "/carrots-admin-ajax/a/article/search",
//             params: $scope.infoParams,
//             header:{'Content-Type':'application/x-www-form-urlencoded'}//表头
//         }).then(
//             function (response) {
//                 var data = response.data.data.articleList;
//                 $scope.list = data;
//                 $scope.totalItems = response.data.data.total;
//                 $scope.currentPage = response.data.data.page;
//                 $scope.items = response.data.data.size;
//
//                 console.log(response.data.data.size);
//                 console.log(data);
//                 console.log($scope.infoParams);
//             }
//         )
//     };
//     //加载datepicker
//     /*$scope.datepickerOptions1 = {
//                 minDate:$scope.dt2,
//                 showWeeks:false,
//                 startingDay:1
//             };
//             $scope.datepickerOptions2={
//                 maxDate:$scope.dt1,
//                 showWeeks:false,
//                 startingDay:1
//             };*/
//     //打开popup
//     $scope.pop1={
//         opened:false
//     };
//     $scope.pop2={
//         opened:false
//     };
//     $scope.openpop1=function(){
//         $scope.pop1.opened=!$scope.pop1.opened;
//     };
//     $scope.openpop2=function(){
//         $scope.pop2.opened=!$scope.pop2.opened;
//     };
//
//     //监听dt1 和dt2 如果dt1 变化就设置 datepickeroptions.mindate就变化
//     /*
//   $scope.$watch('dt1',function(newValue,oldValue){
//       $scope.datepickerOptions2.minDate=newValue;
//   });
//   $scope.$watch('dt2',function(newValue,oldValue){
//       $scope.datepickerOptions1.maxDate=newValue;
//   });*/
//     /*手动输入限制 使用表单验证
//     *datepicker输入限制 使用maxDate minDate
//     *startPopup   最小时间  没有限制 最大时间 endTime
//     *endPopup 最小时间 startTime 最大时间 today
//     */
//
//
//     //清空
//     $scope.clear = function () {
//         console.log("清空");
//         $scope.dt1 = '';
//         $scope.dt2 = '';
//         $scope.status = '';
//         $scope.type = '';
//         $scope.jump = 1;
//         $scope.size = 10;
//         $scope.carryout();
//     };
//
//     //搜索
//     $scope.search = function (){
//         console.log($scope.type);
//         $scope.infoParams.type = $scope.type;
//         $scope.infoParams.status = $scope.status;
//         $scope.infoParams.page = $scope.currentPage;
//         $scope.infoParams.size = $scope.size;
//         $scope.infoParams.startAt = Date.parse($scope.dt1);
//         $scope.infoParams.endAt = Date.parse($scope.dt2);
//         //转化时间戳后，需要把结束时间延长到当天的最后1毫秒
//         if ( $stateParams.endAt === undefined) {
//             console.log($stateParams.endAt);
//             $scope.infoParams.endAt = $scope.infoParams.endAt + 1000*60*60*24 - 1;
//         }
//         //避免时间赋值为空，否则发送NaN，会报错
//         if(isNaN($scope.infoParams.startAt)){
//             $scope.infoParams.startAt = ""
//         }
//         if(isNaN($scope.infoParams.endAt)){
//             $scope.infoParams.endAt = ""
//         }
//         console.log($scope.infoParams);
//         $state.go('dashboard.articleList',$scope.infoParams,{reload:true});
//     };
//     //删除
//     $scope.delData = function (id) {
//         bootbox.confirm("确认删除本条数据？",
//             function (result) {
//                 if (result) {
//                     $http({
//                         method: "delete",
//                         url: "/carrots-admin-ajax/a/u/article/" + id
//                     }).then(function (response) {
//                             console.log(response);
//                             if (response.data.code === 0) {
//                                 bootbox.alert({
//                                     message: "成功删除！",
//                                     size: "small"
//                                 });
//                                 http();
//                             }
//                         },function errorCallback(response) {
//                             bootbox.alert("请求失败！" + response.data.message);
//                         }
//                     );
//                 }
//             }
//         );
//     };
//     //翻页
//     $scope.asdfg = function () {
//         console.log($scope.currentPage);
//         $state.go('dashboard.articleList',{
//             page: $scope.currentPage,
//         },{reload:true});
//     }
//     //确定上传
//     $scope.OK111 = function () {
//         $scope.carryout();
//     }
//     //改变上下线
//     $scope.changeStatus = function (id, status) {
//         console.log("改变状态");
//         if (status == 1) {
//             bootbox.confirm("是否执行上线操作?",function (result){
//                 if (result) {
//                     status = 2;
//                     $http({
//                         method: "PUT",
//                         url: "/carrots-admin-ajax/a/u/article/status",
//                         params: {
//                             id : id,
//                             status : status
//                         }
//                     }).then(
//                         function (response) {
//                             if (response.data.code === 0) {
//                                 bootbox.alert({
//                                     message: "上线成功",
//                                     size: "small"
//                                 });
//                                 http();
//                             } else {
//                                 bootbox.alert("上线失败" + response.data.message);
//                             }
//                         }
//                     );
//                 }
//             });
//         } else {
//             bootbox.confirm("是否执行下线操作？",function (result){
//                 if (result) {
//                     status = 1;
//                     $http({
//                         method: "PUT",
//                         url: "/carrots-admin-ajax/a/u/article/status",
//                         params: {
//                             id : id,
//                             status : status
//                         }
//                     }).then(
//                         function (response) {
//                             if (response.data.code === 0) {
//                                 bootbox.alert({
//                                     message: "成功下线！",
//                                     size: "small"
//                                 });
//                                 http();
//                             } else {
//                                 bootbox.alert("注入失败！" + response.data.message);
//                             }
//                         }
//                     );
//                 }
//             });
//         }
//     };
//
//     //分页
//     $scope.maxSize = 2;
//     console.log($scope.total);
//
//     //$scope.currentPage = $stateParams.page;
//
//     //
// });
// app.filter('typeFilter',function(){
//     return function (inputData){
//         switch (inputData){
//             case 1:
//                 return "找职位Banner";
//             case 3:
//                 return "行业大图";
//             case 0:
//                 return "首页Banner";
//             case 2:
//                 return "找精英Banner";
//         }
//     }
// })
//     .filter('stateFilter',function(){
//         return function (inputData1){
//             switch (inputData1){
//                 case 1:
//                     return "草稿";
//                 case 2:
//                     return "上线";
//             }
//         }
//     })
//     .filter('stateFilter1',function(){
//         return function (inputData1){
//             switch (inputData1){
//                 case 2:
//                     return "下线";
//                 case 1:
//                     return "上线";
//             }
//         }
//     })
// /*var app = angular.module('myApp');
// app.controller('articleListCtrl',function($scope){
// 	$scope.firstName = "John";
//     $scope.lastName = "Doe";
//     $scope.fullName = function() {
//         return $scope.firstName + " " + $scope.lastName;
//     }
// });*/
//风琴菜单
// var app = angular.module("myApp");
// app.controller('dashboard',function ($scope,$state,sidebar) {
//     $scope.state = $state; //因为原本没有state，所以在控制器中定义state
//     $scope.sidebar = sidebar; //从全局变量constant注入到controller中
//     //侧边栏的手风琴效果
//     $scope.openList = function(ele){ //点击父系侧边栏时的点击事件
//         console.log(ele); //查看当前点击的选项
//         $scope.sidebar.forEach(function (item){ //遍历侧边栏
//             if (ele.firstList === item.firstList){ //如何当前点击的父系选项是现在
//                 ele.isShow = !ele.isShow;
//             } else {
//                 item.isShow = false;
//             }
//         })
//     };
//     console.log($scope.sidebar);
//     angular.forEach($scope.sidebar,function(item){
//         item.secondList.some(function(items){
//             console.log(items.url);
//             if($state.includes(items.urls)){
//                 item.isShow = true;
//                 return true;
//                 console.log("true");
//             } else {
//                 item.isShow = false;
//                 return false;
//                 console.log("false");
//             }
//         })
//     })
// });
