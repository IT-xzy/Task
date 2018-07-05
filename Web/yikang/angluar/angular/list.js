angular.module('app')
    .controller("listCtrl", ["$scope", "$state",
        function ($scope, $state, $http, LocalStorageService) {
            $scope.articleList = [
                {
                    id: 1,
                    title: '策略',
                    two:{
                        title:'一货',
                        three:{
                            title:'梦想'
                        }
                    }
                }, {
                    id: 2,
                    title: '谋略',
                    two:{
                        title:'二货',
                        three:{
                            title:'理想'
                        }
                    }
                }, {
                    id: 3,
                    title: '智障',
                    two:{
                        title:'三货',
                        three:{
                            title:'遥远'
                        }
                    }
                }, {
                    id: 4,
                    title: '智障',
                    two:{
                        title:'四货',
                        three:{
                            title:'太遥远'
                        }
                    }
                }, {
                    id: 5,
                    title: '儿童',
                    two:{
                        title:'五货',
                        three:{
                            title:'太太太遥远'
                        }
                    }
                }];
            console.log($scope.articleList)
            if (!localStorage.infoShowIndex) {
                $scope.infoShowIndex;
                $scope.ShowIndex;
                $scope.info=false;
                $scope.info1=false;
            } else {
                var obj=localStorage.getItem("obj");
                obj = JSON.parse(obj);
                $scope.infoShowIndex = parseInt(localStorage.infoShowIndex);
                $scope.ShowIndex = obj.ShowIndex;
                $scope.info= obj.info;
                $scope.info1=obj.info1;
            }
            $scope.goo = function (index) {
                if ($scope.infoShowIndex == index) {
                    $scope.infoShowIndex = undefined;
                    localStorage.infoShowIndex = undefined;
                } else {
                    $scope.infoShowIndex = index;
                    localStorage.infoShowIndex = index;
                }
            }

            $scope.go = function (index) {
                if ($scope.ShowIndex == index) {
                    $scope.ShowIndex = undefined;
                    $scope.info=false;
                    $scope.info1=true;
                    $scope.obj ={
                        ShowIndex:undefined,
                        info:$scope.info,
                        info1:$scope.info1
                    }
                    localStorage.setItem('obj',JSON.stringify($scope.obj))
                } else {
                    $scope.ShowIndex = index;
                    $scope.info=true;
                    $scope.info1=false;
                    $scope.obj ={
                        ShowIndex:index,
                        info:$scope.info,
                        info1:$scope.info1
                    }
                    localStorage.setItem('obj',JSON.stringify($scope.obj))
                }
            }
        }]);
