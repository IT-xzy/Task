// var anotherApp = angular.module('myApp', []);
//     anotherApp.directive('myPage', function () {
//       return {
//         restrict: 'EA',
//         replace: true,
//         transclude: true, //是否将元素内容转移到模版中
//         scope: {
//             title: "=pageTitle"
//         },
//         template: [
//             '<div class="panel panel-info">',
//                 '<div class="panel-heading" ng-click="toggle();">',
//                     '<h3 class="panel-title" >{{title}}</h3>',
//                 '</div>',
//                 '<div class="panel-body" ng-show="showMe" ng-transclude></div>',
//             '</div>'
//         ].join(""),
//         link: function (scope, element, attrs) {
//             scope.showMe = false;
//             scope.$parent.addExpander(scope); //保存所有菜单
//             scope.toggle = function toggle() {
//                 scope.showMe = !scope.showMe; //隐藏显示
//                 scope.$parent.goToExpander(scope);
//             }
//         }
//     };
// })

// app.controller('myCtrl', function ($scope) {
//     $scope.expanders = [{
//         title: 'AngularJS',
//         text: 'AngularJS  诞生于2009年，由Misko Hevery 等人创建，后为Google所收购。是一款优秀的前端JS框架，已经被用于Google的多款产品当中。AngularJS有着诸多特性，最为核心的是：MVVM、模块化、自动化双向数据绑定、语义化标签、依赖注入等等。'
//     }, {
//         title: 'jQuery',
//         text: 'JQuery是继prototype之后又一个优秀的Javascript库。它是轻量级的js库 ，它兼容CSS3，还兼容各种浏览器（IE 6.0+, FF 1.5+, Safari 2.0+, Opera 9.0+），jQuery2.0及后续版本将不再支持IE6/7/8浏览器。jQuery使用户能更方便地处理HTML（标准通用标记语言下的一个应用）、events、实现动画效果，并且方便地为网站提供AJAX交互。jQuery还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。jQuery能够使用户的html页面保持代码和html内容分离，也就是说，不用再在html里面插入一堆js来调用命令了，只需要定义id即可。'
//     }, {
//         title: 'Bootstrap',
//         text: 'Bootstrap，来自 Twitter，是目前很受欢迎的前端框架。Bootstrap 是基于 HTML、CSS、JAVASCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。 它由Twitter的设计师Mark Otto和Jacob Thornton合作开发，是一个CSS/HTML框架。Bootstrap提供了优雅的HTML和CSS规范，它即是由动态CSS语言Less写成。Bootstrap一经推出后颇受欢迎，一直是GitHub上的热门开源项目，包括NASA的MSNBC（微软全国广播公司）的Breaking News都使用了该项目。 国内一些移动开发者较为熟悉的框架，如WeX5前端开源框架等，也是基于Bootstrap源码进行性能优化而来。'
//     }];
//     var expanders = []; //记录所有菜单
//     $scope.addExpander = function (expander) {
//         expanders.push(expander);
//     };
//     $scope.goToExpander = function (selectedExpander) {
//         expanders.forEach(function (item, index) {
//             if (item != selectedExpander) { //隐藏非当前选项卡
//                 item.showMe = false;
//             }
//         })
//     }
// });