var app = angular.module('myApp', []);

app.controller('myCtrl', function ($scope, sidebar) {
    $scope.title=sessionStorage.getItem('index');
    $scope.content=sessionStorage.getItem('z');
    $scope.sidebar = sidebar;
    $scope.go = function (index) {
        $scope.title = ($scope.title == index) ? undefined : index;
        console.log($scope.title);
    };
    $scope.goo = function (z, index) {
        $scope.content = z;
        sessionStorage.setItem('index', index),
            sessionStorage.setItem('z', z)
    }
});
app.constant('sidebar', [
    {
        sidebartitle: '信息管理',
        sidebarcontent: [
            {sidebarName: '公司列表', url: ''},
            {sidebarName: '公司职位', url: ''}
        ]

    },
    {
        sidebartitle: '内容管理',
        sidebarcontent: [
            {sidebarName: '内容列表', url: ''},
            {sidebarName: '内容详情', url: ''}
        ]

    },
    {
        sidebartitle: '文章管理',
        sidebarcontent: [
            {sidebarName: '文章列表', url: ''},
            {sidebarName: '文章详情', url: ''}
        ]

    }
]);