angular.module('zcjApp').controller('ArticleCtrl',['$scope','$http','$stateParams','$rootScope','$location','$log','$window','$state','$filter','type','status',function ($scope,$http,$stateParams,$rootScope,$location,$log,$window,$state,$filter,type,status) {
  $scope.type = type;   //类型下拉框
  $scope.status = status;   //状态下拉框

  //上下线操作
  $scope.downline = function (sId,sStatus) {
    $scope.gostatus = (sStatus==1)?"上线":"下线";
    bootbox.confirm({
      title: "操作提示",
      message: "是否执行"+$scope.gostatus+"操作？",
      buttons: {
        confirm: {
          label: '是的',
          className: 'btn-success'
        },
        cancel: {
          label: '不是',
          className: 'btn-danger'
        }
      },
      callback: function (result) {
        if(result){
          $scope.thestatus = (sStatus==1)?2:1;
          //改变状态
          $scope.dowmline = {
            id:sId,
            status:$scope.thestatus
          };
          $scope.thaha = {
            method:'put',
            url:"/carrots-admin-ajax/a/u/article/status",
            params:$scope.dowmline,
            headers: {
              'Content-Type':'application/x-www-form-urlencoded'
            }
          };
          $http($scope.thaha).then(function (response) {
            bootbox.alert($scope.gostatus+'成功！');
            $state.go('backstage.ArticleList',{

            },{reload:true})
          });
        }
      }
    });
  };
  //删除操作
  $scope.deleteLine = function (sId) {
    bootbox.confirm({
      title: "操作提示",
      message: "是否确认删除",
      buttons: {
        confirm: {
          label: '是的',
          className: 'btn-success'
        },
        cancel: {
          label: '不是',
          className: 'btn-danger'
        }
      },
      callback: function (result) {
        if(result){
          $scope.tata = {
            method:'delete',
            url:"/carrots-admin-ajax/a/u/article/"+sId,
            headers: {
              'Content-Type':'application/x-www-form-urlencoded'
            }
          };
          $http($scope.tata).then(function (response) {
            bootbox.alert('删除成功！');
            $state.go('backstage.ArticleList',{
            },{reload:true})
          });
        }
      }
    });
  };
  //时间插件
  $("#startTime").datetimepicker({          //datetimepicker定义格式
    format:'yyyy-mm-dd',
    minView:2
  }).on("click",function(ev){              //on关联两个时间插件
    $("#startTime").datetimepicker("setEndDate", $scope.endTime);
  });
  $("#endTime").datetimepicker({
    format:'yyyy-mm-dd',
    minView:2
  }).on("click", function (ev) {
    $("#endTime").datetimepicker("setStartDate", $scope.startTime);
  });

  //搜索操作
  $scope.zcjj = function () {
    $scope.time1 = Date.parse($scope.startTime);
    $scope.time2 = Date.parse($scope.endTime) + 86399999;
    $scope.time1 = $scope.time1||undefined;    //值为NAN时赋值为undefined
    $scope.time2 = $scope.time2||undefined;    //值为NAN时赋值为undefined
    $state.go('backstage.ArticleList', {
      type: $scope.selecttype,
      status: $scope.selectedStatus,
      startAt: $scope.time1,
      endAt: $scope.time2
    });
    };

  //分页插件
  $scope.totalItems = 1000;
  $scope.currentPage = $stateParams.page;      //当前页数
  $scope.perpage = $stateParams.size;          //每页数量
  $scope.maxSize = 5;
  //当页数变化时
  $scope.pageChanged = function() {          
  $stateParams.page = $scope.currentPage;
  $stateParams.size = $scope.perpage;
  $state.go('backstage.ArticleList',{size:$scope.perpage,page:$scope.currentPage});
  };
  //分页确认键
  $scope.thePage = function () {
    if($scope.firstName){               //去第x页
      $scope.currentPage = $scope.firstName;
    }
    else if($scope.theSize){           //每页显示x条
      $scope.perpage = $scope.theSize;
    }
    $scope.pageChanged();
  };


  //刷新页面自动请求数据
  $scope.date = {
    page:$stateParams.page,       //当前页数
    size:$stateParams.size,        //每页数目
    starAt:$stateParams.starAt,
    endAt:$stateParams.endAt,
    type:$stateParams.type,
    status:$stateParams.status
  };
  $scope.currentPage = $stateParams.page;
  $scope.tata = {
    method:'get',
    url:"/carrots-admin-ajax/a/article/search",
    params:$scope.date
  };
  $http($scope.tata).then(function (response) {
    $rootScope.shuju = response.data.data.articleList;       //将数据渲染到页面
    $scope.totalItems = response.data.data.total;
    $scope.currentPage = $stateParams.page;
    $scope.startTime = $filter('date')($stateParams.startAt,'yyyy-MM-dd');      //渲染开始时间
    $scope.endTime = $filter('date')($stateParams.endAt,'yyyy-MM-dd');         //渲染结束时间
    $scope.selecttype = $stateParams.type;                                      //渲染类型
    $scope.selectedStatus = $stateParams.status;                               //渲染状态
    console.log(response)
    console.log(response.headers())
    console.log(response.headers().date)
  });
}]);