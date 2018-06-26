var app = angular.module('myApp', ['ui.router', 'ui.bootstrap']);

app.filter('reverse', function () { //可以注入依赖co
    return function (text) {
        if (text === 1) {
            return "草稿"

        } else if (text === 2) {
            return "上线  "
        }
    }
});
//用filter渲染页面的状态，页面传过来的是数据利用数字去渲染页面，上下一样。
app.filter('else', function () { //可以注入依赖co
    return function (character) {
        if (character === 0) {
            return '首页banner'
        } else if (character === 1) {
            return "找职位banner"

        } else if (character === 2) {
            return "找精英banner"
        } else if (character === 3) {
            return "行业大图"
        }
    }
});
//定义的第一个控制器。
app.controller('myOne', function ($scope, $http, $state, $stateParams) {
    $scope.params={
        page:$stateParams.page,
        startAt:$stateParams.startAt= (new Date()).valueOf(),
        endAt:$stateParams.endAt= (new Date()).valueOf()
    };
    function  ssasas() {
        //进入页面发送http请求获取接口给的参数。
        $http({
            method: 'get',
            url: 'http://localhost//carrots-admin-ajax/a/article/search',
            headers: {
                "Content-Type": "application/x-www-form-urlencoded;"
            },
            params: {
                params: $scope.params
            }
            //给currentPage赋值，保存需要第几页的数据。
        }).then(function fn(omg) {
            //分页总共分几页。
            $scope.totalItems = omg.data.data.total;
            //给datum赋值数据，用datum去页面上渲染数据。
            $scope.datum = omg.data.data.articleList;
            console.log(omg.data.data.articleList)
        });
    }
    //go路由传参。
    $scope.one = function () {
        console.log("current page=" + $scope.currentPage);
        $state.go('two', {
            page: $scope.params
        }, {reload: true});
    };
    ssasas();
    //侧边栏手风琴
    $scope.myVar = true;
    $scope.toggle = function () {
        $scope.myVar = !$scope.myVar
    };
    //日期插件。
    $scope.format = "yyyy/MM/dd";
    $scope.altInputFormats = ['yyyy/M!/d!'];
    $scope.popup1 = {
        opened: false
    };
    $scope.open1 = function () {
        $scope.popup1.opened = true;
    };
    //日历第二个。
    $scope.popup2 = {
        opened: false
    };
    $scope.open2 = function () {
        $scope.popup1.opened2 = true;
    };

});
//路由跳转
//路由接受参数
app.config(['$stateProvider', function ($stateProvider) {
    $stateProvider
        .state('one', {
            url: '/one',
            template: '<h1>Welcome</h1>'
        })
        .state('two', {
            url: '/two/:page/:startAt/:endAt/:type/:status',
            templateUrl: 'JS6-2.html'
        })
        .state('three', {
            url: '/three',
            templateUrl: 'JS6-3.html'
        })
}]);
