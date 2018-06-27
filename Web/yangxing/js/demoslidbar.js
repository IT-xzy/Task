var myApp = angular.module('myApp', []);
myApp.directive("superman", function ($log) {
    return {
        scope: {},
        restrict: 'AEMC',
        controller: function ($scope) {
            $scope.abilities = [];
            this.addStrength = function () {
                $scope.abilities.push("力大无穷");
            };
            this.addSee = function () {
                $scope.abilities.push("千里眼");
            };
            this.addsteel = function () {
                $scope.abilities.push("刀枪不入");
            };
            this.addfire = function () {
                $scope.abilities.push("能吐火");
            };
            this.addwater = function () {
                $scope.abilities.push("能吐水");
            };
            this.addinvisible = function () {
                $scope.abilities.push("能隐身");
            };
            this.addhulu = function () {
                $scope.abilities.push("有个宝葫芦");
            };
        },
        link: function ($scope, element, attrs) {
            element.addClass('btn btn-primary');
            element.bind("click", function () {
                $("p").html($scope.abilities);
            })

        }

    }
});
myApp.directive("dawa", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addStrength();
        }
    }
});
myApp.directive("erwa", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addSee();
        }
    }
});
myApp.directive("sanwa", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addsteel();
        }
    }
});
myApp.directive("liuwa", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addinvisible();
        }
    }
});
myApp.directive("siwa", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addfire();
        }
    }
});
myApp.directive("wuwa", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addwater();
        }
    }
});
myApp.directive("qiwa", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addhulu();
        }
    }
});


myApp.directive("hello", function () {
    return {
        restrict: "AE",
        scope: {},
        template: '<div><input type="text" ng-model="userName"/>{{userName}}</div>',
        replace: true
    }
});


myApp.controller('myCtrl3', function ($scope) {
    $scope.ctrlFlavor = '9度';
});
myApp.directive("drink", function () {
    return {
        restrict: 'AE',
        template: "<div>{{flavor}}</div>",
        link: function (scope, element, attrs) {
            scope.flavor = attrs.flavor;
        }
    }
});


myApp.controller('myCtrl4', function ($scope) {
    $scope.sayHello = function (name) {
        bootbox.alert("Hello" + name);
    }
});
myApp.directive("greeting", function () {
    return {
        restrict: 'AE',
        scope: {
            greet: '&'
        },
        template: '<input type="text" ng-model="userName"/><br/>' + '<button class="btn btn-default" ng-click="greet({name:userName})">Greeting</button>'
    }
});


myApp.controller('TestFormMoudule', function ($scope) {
    $scope.user = {
        userName: 'bradmatt',
        password: ''
    };
    $scope.save = function () {
        bootbox.alert("保存数据");
    }
});

myApp.directive('expander', function () {
    return {
        restrict: 'EA',
        replace: 'true',
        transclude: true,
        scope: {
            title: '=expanderTitle'
        },
        template: '<div>' + '<div class="title" ng-click="toggle()">{{title}}</div>' +
        '<div class="body" ng-show="showMe" ng-transclude></div> ' + '</div>',
        link: function (scope, element, attrs) {
            scope.showMe = false;
            scope.toggle = function () {
                scope.showMe = !scope.showMe;
            }
        }
    }
});

myApp.controller('someCtrl', function ($scope) {
    $scope.title = "点击展开";
    $scope.text = "这里是内容";
});

myApp.factory("locals", [
    "$window",
    function($window) {
        return {
            //存储单个属性
            set: function(key, value) {
                $window.localStorage[key] = value;
            }, //读取单个属性
            get: function(key, defaultValue) {
                return $window.localStorage[key] || defaultValue;
            }, //存储对象，以JSON格式存储
            setObject: function(key, value) {
                $window.localStorage[key] = JSON.stringify(value); //将对象以字符串保存
            }, //读取对象
            getObject: function(key) {
                return JSON.parse($window.localStorage[key] || "{}"); //获取字符串并解析成对象
            }
        };
    }
]);
// session 刷新还存在 退出浏览器不存在
myApp.factory("session", [
    "$window",
    function($window) {
        return {
            //存储单个属性
            set: function(key, value) {
                $window.sessionStorage[key] = value;
            }, //读取单个属性
            get: function(key, defaultValue) {
                return $window.sessionStorage[key] || defaultValue;
            }, //存储对象，以JSON格式存储
            setObject: function(key, value) {
                $window.sessionStorage[key] = JSON.stringify(value); //将对象以字符串保存
            }, //读取对象
            getObject: function(key) {
                return JSON.parse($window.sessionStorage[key] || "{}"); //获取字符串并解析成对象
            }
        };
    }
]);
// 这是js文件
// myApp.config(function($stateProvider,$urlRouterProvider){
//
//
//
// });
// myApp.controller('myCtrl',function($scope,$state,locals,session){
//     var status = session.get("login");
//     if(session.get("login")==0){
//         console.log("存在登录状态")
//     }else{
//         $state.go('login',{},{reload:true});
//     }
//
//     $scope.atflick=locals.get("atflick");
//     $scope.atlight=locals.get("atlight");
//     $scope.sidedata=[
//         {
//             "x":"业务管理",
//             "y":[
//                 "用户管理",
//                 "债权管理",
//                 "产品管理",
//                 "交易管理"
//             ]
//         },
//         {
//             "x":"运营管理",
//             "y":[
//                 "内容管理",
//                 "消息管理",
//                 "银行管理",
//                 "意见反馈"
//             ],
//         },
//         {
//             "x":"后台管理",
//             "y":[
//                 "模块管理",
//                 "角色管理",
//                 "帐号管理",
//                 "修改密码"
//             ]
//         }
//     ];
// // $scope.atflick=locals.get("atflick");
// // $scope.atlight=locals.get("atlight");
// // console.log($scope.atflick);
//
//     $scope.flick=function(x){
//         $scope.atflick=x;
//         locals.set("atflick", $scope.atflick);
//         // myValue.atflick=x;
//     }
//     $scope.clickstate= function(x){
//         $scope.atlight=x;
//         locals.set("atlight", $scope.atlight);
//         // myValue.atlight=x;
//
//         switch(x){
//             case "用户管理":
//                 $state.go('home.user',{},{reload:true});
//                 break;
//             case "债权管理":
//                 $state.go('home.claims',{},{reload:true});
//                 break
//             case "产品管理":
//                 $state.go('home.product',{},{reload:true});
//                 break;
//             case "交易管理":
//                 $state.go('home.transaction',{},{reload:true});
//                 break;
//             case "内容管理":
//                 $state.go('home.content',{},{reload:true});
//                 break;
//             case "消息管理":
//                 $state.go('home.news',{},{reload:true});
//                 break
//             case "银行管理":
//                 $state.go('home.bank',{},{reload:true});
//                 break;
//             case "意见反馈":
//                 $state.go('home.opinion',{},{reload:true});
//                 break;
//             case "模块管理":
//                 $state.go('home.modules',{},{reload:true});
//                 break;
//             case "角色管理":
//                 $state.go('home.character',{},{reload:true});
//                 break
//             case "帐号管理":
//                 $state.go('home.accountnumber',{},{reload:true});
//                 break;
//             case "修改密码":
//                 $state.go('home.changePsd',{},{reload:true});
//                 break;
//         }
//     }
// });

