angular.module('app').controller('editArticleCtrl', function ($scope, $http, $rootScope, $location, saveSession, myHttp) {
  // $scope.editItem = $rootScope.editItem;
  // console.log($location.search());
  $scope.type = [0, 1, 2, 3];
  // 图片类型为3时，必须选择industry
  $scope.industry = [0, 1, 2, 3, 4, 5, 6];
  //用于表单验证
  $scope.selectedIndustry;
  $scope.changeTitle = false;
  $scope.typeChange = false;
  $scope.industryChange = false;
  $scope.urlChange = false;
  $scope.fileChange = false;
  $scope.monitorProgress = {
    width: $scope.progressWidth
  }
  let params = $location.search();

  $scope.init = function () {

    myHttp.getSingleArticle(params.id).then((data) => {
      let result = data.data.data.article;
      $scope.title = result.title;
      $scope.selectedType = result.type;
      $scope.selectedIndustry = result.industry;
      $scope.content = result.content;
      $scope.url = result.url;
      $scope.img = result.img;
      $scope.createAt = result.createAt;
      $scope.selectedStatus = result.status;
      // console.log($scope.content);
      editor.txt.html($scope.content);
    })
  }();

  $scope.upload = function () {
    let id = params.id
    let updateParams = {
      title: $scope.title,
      status: $scope.selectedStatus,
      img: $scope.img,
      content: editor.txt.html(),
      url: $scope.url,
      industry: $scope.selectedIndustry,
      createAt: $scope.createAt,
      type: $scope.selectedType,
    };
    myHttp.updateArticle(id, updateParams).then((data) => {
        $scope.message = data.data.code;
        console.log(data);
      },
      (err) => {
        console.error(err);
      }).then(() => {
      if ($scope.message >= 0) {
        let params = saveSession.get('params');
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
      $scope.img = data.data.data.url;
    }).then(() => {
      clearTimeout(raf);
      // console.log('complete');
      $scope.progressWidth = 100;
    })
  }
  $scope.delete = function () {
    angular.element("#upload")[0].value = null;
    console.log(angular.element("#upload"));
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
  $scope.$watch('progressWidth', function () {
    $scope.monitorProgress = {
      width: $scope.progressWidth
    }
  });
})