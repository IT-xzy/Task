angular.module('app').controller('newArticleCtrl', function ($scope, $http, $location, $rootScope, myHttp, saveSession, pageService) {
  $scope.type = [0, 1, 2, 3];
  // 图片类型为3时，必须选择industry
  $scope.industry = [0, 1, 2, 3, 4, 5, 6];
  $scope.uploadStatus = 2;
  //用于表单验证
  $scope.change = false;
  $scope.typeChange = false;
  $scope.urlChange = false;
  $scope.fileChange = false;
  $scope.monitorProgress = {
    width: $scope.progressWidth
  }
  $scope.$watch('progressWidth', function () {
    $scope.monitorProgress = {
      width: $scope.progressWidth
    }
  });
  $scope.upload = function () {
    let form = new FormData();
    form.append("img", $scope.imgSrc);
    form.append("title", $scope.title);
    form.append('type', $scope.selectedType);
    form.append('status', $scope.uploadStatus);
    form.append('url', $scope.url);
    form.append('content', editor.txt.html());
    if ($scope.selectedIndustry) {
      form.append('industry', $scope.selectedIndustry);
    }

    myHttp.uploadArticle(form).then((data) => {
        console.log(data);
        $scope.message = data.data.code;
      },
      (err) => {
        console.error(err);
      }).then(() => {
      console.log("complete");
    }).then(() => {
      if ($scope.message >= 0) {
        let params = saveSession.get('params');
        console.log(saveSession.get('params'));
        $location.url('/articleList');
        $location.search(params);
      }
    })
  }
  $scope.draft = function () {
    $scope.uploadStatus = 1;
    $scope.upload();
  }

  $scope.uploadImg = function () {
    //在服务器返回成功之前对进度条不断填充
    let raf;

    function fillProgress() {
      $scope.progressWidth += 10;
      raf = setTimeout(() => {
        fillProgress()
      }, 100);
    }
    fillProgress();

    let formImg = new FormData();
    formImg.append('file', $scope.imgFile);
    myHttp.uploadPicture(formImg).then((data) => {
      $scope.imgSrc = data.data.data.url;
    }).then(() => {
      clearTimeout(raf);
      console.log('complete');
      $scope.progressWidth = 100;
    })
  }
  $scope.delete = function () {
    angular.element('#upload')[0].value = null;
    $scope.imgFile = undefined;
    $scope.imgSize = null;
    $scope.imgName = null;
    $scope.imgSrc = '/';
    $scope.progressWidth = 0;
  }
  $scope.cancel = function () {
    let params = saveSession.get('params');
    $location.url('/articleList');
    $location.search(params);
  }
})