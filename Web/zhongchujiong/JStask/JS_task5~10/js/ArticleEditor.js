angular.module('zcjApp').controller('ArticleEditor', ['bigPicture', 'FileUploader', '$scope', '$http', '$stateParams', '$rootScope', '$state', function (bigPicture, FileUploader, $scope, $http, $stateParams, $rootScope, $state) {
  //类型下拉框
  $scope.Type = Type;
  //行业大图的子下拉框
  $scope.bigPicture = bigPicture;
  //富文本编辑器
  var E = window.wangEditor;
  var editor = new E('#editor');
  editor.create();

  //渲染数据
  if ($stateParams.id) {      //编辑页面
    $scope.Arti = '编辑';
    $scope.data = {
      method: 'get',
      url: "/carrots-admin-ajax/a/article/" + $stateParams.id,
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    };
    $http($scope.data).then(function (response) {
      $scope.titleName = response.data.data.article.title;
      $scope.bigPictureType = response.data.data.article.industry;
      $scope.zheType = response.data.data.article.type;
      editor.txt.html = response.data.data.article.content;
      $scope.gotoLink = response.data.data.article.url;
      $scope.PicUrl = response.data.data.article.img;
    });
  } else {               //新增页面
    $scope.Arti = '新增';
  }

  //点击上线/草稿
  $scope.gotoline = function (zcj) {
    $scope.line = (zcj == 1) ? '存为草稿?' : '立即上线?';
    bootbox.confirm({
        title: "操作提示",
        message: "是否" + $scope.line,
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

          if (result) {
            if ($scope.zheType != 3) {
              $scope.bigPictureType = '';
            }
            $scope.fanhuidate = {
              title: $scope.titleName,
              type: $scope.zheType,
              content: editor.txt.text(),
              url: $scope.gotoLink,
              status: zcj,
              industry: $scope.bigPictureType,
              img: $scope.PicUrl
            };
            if ($stateParams.id) {        //判断是编辑页面还是新增页面
              $scope.tata = {
                method: 'put',
                url: "/carrots-admin-ajax/a/u/article/" + $stateParams.id,
                params: $scope.fanhuidate,
                headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
                }
              };
            } else {
              $scope.tata = {
                method: 'post',
                url: "/carrots-admin-ajax/a/u/article/",
                params: $scope.fanhuidate,
                headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
                }
              };
            }
            $http($scope.tata).then(function (response) {
              bootbox.alert('编辑成功!');
              $state.go('backstage.ArticleList', {size: 10, page: 1}, {reload: true});
            });
          }

        }
      }
    );
  };
  //上传图片插件
  var uploader = $scope.uploader = new FileUploader({
    url: '/carrots-admin-ajax/a/u/img/3',
    queueLimit: 1
  });
  uploader.filters.push({
    name: 'imageFilter',
    fn: function (item, options) {
      var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
      return '|jpg|png |jpeg|bmp|gif|'.indexOf(type) !== -1;
    }
  });
  uploader.onSuccessItem = function (fileItem, response) {
    $scope.PicUrl = response.data.url;           //将返回的图片地址存入变量
  };
}]);