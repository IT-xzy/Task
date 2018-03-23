/**
 * Created by Administrator on 2018/1/27.
 */
angular.module ('app')
.controller('pg3Controller',function ($scope,$state,$http) {
    $scope.params={};
    $(document).ready (function () {
        $scope.get($scope.params);
    });
    $scope.get=function (data) {
        $.ajax({
            type:'GET',
            url: '/carrots-admin-ajax/a/article/search',
            datatype:'json',
            data:$scope.params,
            success:function (data) {
                dataa =JSON.parse(data);
                // console.log(dataa);
                console.log(dataa.data.total);
                $scope.totalItems=dataa.data.total;
                console.log($scope.totalItems);
                $scope.itemsPerpage=10;
                $scope.totalPage= Math.ceil($scope.totalItems/$scope.itemsPerpage) ;
                $scope.maxSize = 5;
                if(dataa.code=='0'){
                    $state.go('page.page3');
                    console.log(dataa);
                    $scope.abc=dataa.data.articleList;
                    // $scope.$apply();
                    console.log($scope.abc);
                }
            }
        })
    };

    $scope.clean =  function (data) {
        $state.go('page.page3',{},{reload:true});
    };
    $scope.delete =function ($index) {
        console.log($index);
        id=$scope.abc[$index].id;
        console.log(id);
        $http({
            method:'delete',
            url:'/carrots-admin-ajax/a/u/article/'+id,
            params:{}
        }).then(function(responce){
//响应成功
            if (responce.data.code==0) {
                $scope.get($scope.params);
            }
        })
    };
    $scope.delt=function ($index) {
        console.log($index);
        bootbox.confirm("是否确定删除", function (result) {
            if (result) {
                // alert('点击了确认按钮');
                $scope.delete($index);
            } else {
                // alert('');
            }
        })
    };


    $scope.redact=function($index,$state){
        console.log($index);
        id=$scope.abc[$index].id;
        console.log(id);
    };


    $scope.currentPage = 1;
    $scope.page=function (page) {
        console.log(page);
        $scope.params.page = page;
        $scope.currentPage=page;
        console.log($scope.params);
        $scope.get($scope.params);
    };
    $scope.dat ='';
    $scope.enddat='';
    // $scope.dat =new Date();
    // $scope.enddat=new Date();
    $scope.format = "yyyy/MM/dd";
    $scope.altInputFormats = ['yyyy/M!/d!'];
    $scope.popup1 = {
        opened: false
    };
    $scope.start = function () {
        $scope.popup1.opened = true;
    };
    $scope.popup2 = {
        opened: false
    };
    $scope.end = function () {
        $scope.popup2.opened = true;
    };

    $scope.search=function (search) {
        console.log($scope.type);
        // console.log($scope.dat);
        console.log($scope.enddat.valueOf());
        console.log($scope.params);
        $scope.params.startAt =$scope.dat.valueOf();
        $scope.params.endAt = $scope.enddat.valueOf();
        $scope.params.type=$scope.type;
        $scope.params.status=$scope.status;
        $scope.get($scope.params);
    };
    $scope.params={};

    $scope.change=function ($index) {
        id=$scope.abc[$index].id;
        status=$scope.abc[$index].status;
        $scope.params.id=id;
        $scope.params.status=status;
        console.log($scope.params.id);
        console.log($scope.params.status);
        if(status==1)
        {$scope.params.status=2}
        else {
            $scope.params.status=1;
        }
        console.log($scope.params.status);
        $http({
            method:'put',
            url:'/carrots-admin-ajax/a/u/article/status/',
            params:$scope.params
        }).then(function (responce) {
            if (responce.data.code==0) {
                $scope.params={};
                $scope.get($scope.params);
            }
        });
    };
    $scope.changeline=function ($index) {
        bootbox.confirm("是否执行操作", function (result) {
            if(result) {
                // alert('点击了确认按钮');
                $scope.change($index)

            } else {
                // alert('点击了取消按钮');
            }
        });
    };

});