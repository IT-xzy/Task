var app = angular.module("myApp", ['ui.router', 'ui.bootstrap', 'angularFileUpload']);
//导航列表显示隐藏切换
app.controller("nav-list", function($scope) {
  $scope.return=function(){
    sessionStorage.clear();
    location.href="js3-2.html"
  }
  sessionStorage.show?$scope.listToggle = true:$scope.listToggle = false;

  // $scope.listToggle = false;

  $scope.toggle = function() {
    $scope.listToggle = !$scope.listToggle;
    sessionStorage.show=1;
  }
})
//列表渲染
app.config(function($stateProvider) {
  $stateProvider
  $stateProvider.state({
    name: 'new',
    url: '/new/:title',
    templateUrl: 'js3-3.html'

  }).state({
    name: 'list',
    url: '/list/:page/:status/:type/:startAt/:endAt',
    templateUrl: "js3-4.html"
  })
})

//自定义服务
app.factory('dataFactory', function($http) {
  var factory = {};
  factory.getlist1 = function(params) {
    return $http({
      url: "/carrots-admin-ajax/a/u/article/",
      method: "POST",
      params: params
    })
  };
  factory.getlist = function(params) {
    return $http({
      url: "/carrots-admin-ajax/a/article/search/",
      method: "GET",
      params: params
    })
  };
  return factory;
});
//控制器
app.controller("myCtrl", function($scope, $http, $state, $stateParams, dataFactory, $log) {
  $scope.params = $stateParams;
  $scope.maxSize = 5;
  $scope.bigTotalItems = 175;
  $scope.bigCurrentPage = 1;
  //分页结束

  //输入页数
  $scope.goTo = function() {
    $state.go($state.current, $scope.params, {
      reload: true
    })
  }

  //输入页数结束
  //初始渲染
  $scope.getlist = function() {
    dataFactory.getlist($scope.params).
    then(function(response) {
      $scope.pagination = response.data.data;
      $scope.items = response.data.data.articleList;

      if ($scope.params.startAt) {
        var start = $scope.params.startAt
        $scope.params.startAt = Number(start)
      }
      if ($scope.params.endAt) {
        var end = $scope.params.endAt
        $scope.params.endAt = Number(end)
      }

      console.log($scope.params);

    })
  }
  $scope.getlist();
  // 搜索
  $scope.search = function() {
    console.log($scope.params);
    $scope.params.startAt = $scope.params.startAt.valueOf();
    $scope.params.endAt = $scope.params.endAt.valueOf();

    $state.go($state.current, $scope.params, {
      reload: true
    })
    //
    // $scope.params.endAt=$scope.params.endAt.valueOf();
  }
  //清空搜索
  $scope.reset = function() {
    $state.go($state.current, {
      "type": null,
      "status": null,
      "startAt": null,
      "endAt": null
    })
  }

  //上线/草稿
$scope.status=function(id,status){
  if(status==1){
    status=2;
  }else{
    status=1;
  }
bootbox.confirm("确定修改吗？", function(result){
if(result){
  $http({
    method: 'PUT',
    url: '/carrots-admin-ajax/a/u/article/status?id='+id+"&status="+status
  }).then(function(response) {
    $scope.data = response.data;
    bootbox.alert({
size: "small",
title: "萝卜多后台管理系统",
message: "修改成功",
callback: function(){ /* your callback code */ }
})
    $state.go("list",{},{reload:true})
  },function(errResponse){
    bootbox.alert({
size: "small",
title: "萝卜多后台管理系统",
message: "修改失败",
callback: function(){ /* your callback code */ }
})
    console.log(errResponse)
  })
}
 /* your callback code */

})

}

  //删除功能
  $scope.remove = function(id) {
bootbox.confirm("确定要删除吗", function(result){
 /* your callback code */
if (result) {
  $http({
    method: 'delete',
    url: '/carrots-admin-ajax/a/u/article/' + id
  }).then(function(response) {
    $scope.data = response.data;
    console.log($scope.data)
    $state.go("list", {}, {
      reload: true
    })
  })

}



})

  }

  $scope.change=function(title){
console.log(1);
    $state.go("new",{title:title})
  }
  //日历插件

  // $scope.dat2 = new Date();



  // $scope.dat1 =$scope.params.startAt;

  // console.log($scope.params.startAt )
  // console.log($scope.dat1);
  $scope.format = "yyyy/MM/dd";
  $scope.altInputFormats = ['yyyy/M!/d!'];

  $scope.popup1 = {
    opened: false
  };
  $scope.open1 = function() {
    $scope.popup1.opened = true;

  };

  $scope.popup2 = {
    opened: false
  };
  $scope.open2 = function() {
    $scope.popup2.opened = true;


  };
  //日历插件结束
})








app.filter("typeChange", function() {
  return function(type) {
    switch (type) {
      case 0:
        return "首页banner ";
        break;
      case 1:
        return "找职位banner";
        break;
      case 2:
        return "找精英banner";
        break;
      case 3:
        return "行业大图";
        break;
    }
  }
})
app.filter("statusChange", function() {
  return function(status) {
    switch (status) {
      case 1:
        return "草稿";
        break;
      case 2:
        return "上线";
        break;
    }
  }
})
app.filter("statusChange1", function() {
  return function(status) {
    switch (status) {
      case 1:
        return "上线";
        break;
      case 2:
        return "草稿";
        break;
    }
  }
})
app.filter("upNumber", function() {
  return function(total) {
    console.log();
    return Math.ceil(total / 10)
  }

})
//路由







app.controller("myCtrl1", function($scope, dataFactory,$state, $http, FileUploader, $stateParams) {
  console.log($stateParams);
  $scope.params = $stateParams;
  if($stateParams.title){
    var a=$stateParams.title
    $scope.new="编辑Artical"
  }else{
    $scope.new="新增Artical"
  }

  console.log(a);
  //
  var E = window.wangEditor
  var editor = new E('#div1','#div2')
  editor.create()



  //
  var uploader = $scope.uploader = new FileUploader({
    url: 'carrots-admin-ajax/a/u/img/test'
  });
  $scope.submit = function(status) {
    var r=confirm("确认上传？")
    if(r==true){
      $scope.params.content=editor.txt.text();
      $scope.params.type = Number($scope.params.type)
      console.log($scope.params.type);
      $scope.params.img = $scope.imgUp;
      $scope.params.status = status;
      dataFactory.getlist1($scope.params).then(function(response) {
        console.log(response.data);
        console.log($scope.params);
        console.log($scope.content);
        if(response.data.code==0){
          bootbox.alert({
      size: "middle",
      title: "萝卜多后台管理系统",
      message: "保存成功",
    })
          $state.go("list", $scope.params, {
            reload: true
          })
        }else{
          bootbox.alert({
      size: "small",
      title: "萝卜多后台管理系统",
      message: "保存失败",
      callback: function(){ /* your callback code */ }
    })
        }

    })

  }

  }

  uploader.onSuccessItem = function(fileItem, response, status, headers) {
    console.info('onSuccessItem', response);
    console.log(response.data.url);
    $scope.imgUp = response.data.url;

  };

});
