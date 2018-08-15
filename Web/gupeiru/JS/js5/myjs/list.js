angular.module("myApp")
    .controller("listController", function ($scope, $state) {
        $scope.toggle = function (index) {
            // $(".arrow").eq(index).toggleClass("arrow2");
            // $scope.choose = !$scope.choose;
            // $(".nav-link").eq(index).toggleClass("link-white");
            // $(".navbar-child").eq(index).slideToggle();
            for (let i = 0; i < 3; i++) {
                if (i == index) {
                    $scope.records[i].show = !$scope.records[i].show;
                } else {
                    // $(".navbar-child").eq(i).slideUp();
                    // $(".arrow").eq(i).removeClass("arrow2");
                    // $(".nav-link").eq(i).removeClass("link-white");
                    $scope.records[i].show = false;
                }
            }
        };
        $scope.logout = function () {
            $state.go('login');
        };

        
        $scope.myFilter = function (item) {
            return item.age === 20;
        };
        
        $scope.myArr = [{
            name: 'Tom',
            age: 20
        }, {
            name: 'Tom Senior',
            age: 50
        }, {
            name: 'May',
            age: 21
        }, {
            name: 'Jack',
            age: 20
        }, {
            name: 'Alice',
            age: 22
        }];



        $scope.records = [{
                show: false,
                father: "信息管理",
                child: [
                    "公司列表",
                    "职位列表"
                ],
            },
            {
                show: false,
                father: "Article管理",
                child: {
                    1: "Article列表",
                    2: "文章管理",
                    3: "文章管理"
                }
            },
            {
                show: false,
                father: "用户管理",
                child: [
                    "用户列表",
                ]
            }
        ];
    });