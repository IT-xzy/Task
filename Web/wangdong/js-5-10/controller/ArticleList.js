angular.module('App')
    .controller('artCtr',['$scope', '$http', '$stateParams','$state',function ($scope, $http,$stateParams,$state) {
        $scope.searchParams=$stateParams;

//向后台请求article列表
        $http({
            method:'get',
            url:'/carrots-admin-ajax/a/article/search' ,
            params:$scope.searchParams
        })
    .then(function(response){

            if(response.data.code===0){
                $scope.lists=response.data.data.articleList;
                $scope.total = response.data.data.total;

            }

        },function(response){
            //失败时执行
            console.log(response);
        });


//按条件搜索article列表
        $scope.popup1 = {
            opened: false
        };
        $scope.open1 = function () {
            $scope.popup1.opened = true;
        };
        $scope.popup2 = {
            opened: false
        };
        $scope.open2 = function () {
            $scope.popup2.opened = true;
        };
        $scope.params={};

        $scope.params.type=$scope.searchParams.type;
        $scope.params.status=$scope.searchParams.status;
        $scope.params.startAt=new Date(parseInt ($scope.searchParams.startAt));
        $scope.params.endAt=new Date(parseInt ($scope.searchParams.endAt));

        $scope.search=function () {

            if($scope.params.startAt){
                $scope.params.startAt = $scope.params.startAt.valueOf() || undefined;
            }
            if($scope.params.endAt){
                $scope.params.endAt = $scope.params.endAt.valueOf() || undefined;
            }
            $state.go($state.current,$scope.params,{reload:true});
        };


//清空

        $scope.clean=function () {
            angular.forEach($scope.params, function(data,index,array){
                array[index]="";
            });
            $state.go($state.current,$scope.params,{reload:true});
        } ;




//删除列表行
        $scope.delete = function (list) {
            id = list.id;
            bootbox.setLocale("zh_CN");
            bootbox.confirm("确定删除?", function(result) {
                if(result){
                    $http({
                        method: 'delete',
                        url: '/carrots-admin-ajax/a/u/article/' + id,
                        data: $scope.searchParams,
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    })
                        .then(function (data) {
                            if (data.data.code === 0) {
                                $scope.lists.splice($scope.lists.indexOf(list), 1);

                            } else {
                                alert(data.message);
                            }
                        });

                    $state.go($state.current, $scope.params.id, {reload: true});

                }
                else{
                    return;
                }
                })
            };


//新增
        $scope.add=function () {
            $state.go('backstage.AddArt',{id:1});
        };

//编辑
        $scope.edit=function (list) {
            $state.go('backstage.AddArt',{id:list.id})
        };


//改变状态
        $scope.ChangeState=function (list) {
            id = list.id;
            status = list.status;

            if (list.status == 2) {
                bootbox.setLocale("zh_CN");
                bootbox.confirm("下线后该图片将不展示在轮播banner中,是否执行下线操作？", function (result) {
                    if (result) {
                        $http({
                            method: 'PUT',
                            url: '/carrots-admin-ajax/a/u/article/status?id=' + id + "&status=1",
                            params: $scope.searchParams,
                            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                        })
                            .then(function (data) {
                                if (data.data.code === 0) {
                                    $state.go($state.current, {}, {reload: true});
                                } else {
                                    alert(data.message);
                                }
                            });
                    }
                    else {
                        return
                    }

                })}
            else if (list.status == 1) {
                bootbox.setLocale("zh_CN");
                bootbox.confirm('上线后该图片将在轮播banner中展示，是否执行上线操作?',function (result) {
                   if(result) {
                       $http({
                           method: 'PUT',
                           url: '/carrots-admin-ajax/a/u/article/status?id=' + id + "&status=2",
                           params: $scope.searchParams,
                           headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                       })
                           .then(function (data) {
                               if (data.data.code === 0) {
                                   $state.go($state.current, {}, {reload: true});
                               } else {
                                   alert(data.message);
                               }
                           });
                   } else{return}
                   })
                }
        }

    }]);
