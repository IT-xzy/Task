angular.module("app").controller("articleCtrl",
  function ($scope,$q, $location, $state, $ocLazyLoad,saveSession,myHttp,pageService) {
    //总条
    $scope.totalSize;
    $scope.pageSize = 5;
    $scope.totalPage;
    $scope.pageArray;
    $scope.displayPages = [];
    // 上架状态
    $scope.status = [1, 2];
    // 图片类型
    $scope.type = [0, 1, 2, 3];
    // 图片类型为3时，必须选择industry
    $scope.industry = [0, 1, 2, 3, 4, 5, 6];
    // 用于保存图片multipartFile
    $scope.imgFile;
    // 返回的图片URL
    $scope.imgSrc = null;
    // 图片大小
    $scope.imgSize = null;
    //图片名称
    $scope.imgName = null;
    $scope.url = null;
    $scope.title = null;
    $scope.content = null;
    $scope.selectedType = null;
    $scope.list = null;
    $scope.selectedStartTime = undefined;
    $scope.selectedEndTime = undefined;
    $scope.selectedStatus = undefined;
    $scope.uploadStatus = 2;
    //选中的页数，默认值为1
    $scope.selectedPage = 1;
    $scope.selectedIndustry = null;
    $scope.progressWidth = 0;
    $scope.editItem;

    $scope.expander = [{
        title: '信息管理',
        list: ['公司列表', '职位管理']
      },
      {
        title: 'Article管理',
        list: ['Article列表', '文章管理', '文章管理']
      },
      {
        title: '用户管理',
        list: ['用户列表']
      }
    ];
    $scope.init = function () {
      if (saveSession.get('params')) {

        let params = saveSession.get('params');
        // console.log(params);

        $scope.selectedStartTime = (new Date(params.startAt))
        $scope.selectedEndTime = (new Date(params.endAt))
        $scope.selectedType = params.type;
        $scope.selectedStatus = params.status;
        params.size = $scope.pageSize;
        $scope.selectedPage = parseInt(params.page);
        // $scope.$apply();
        myHttp.getArticle(params).then(
          (data) => {
            $scope.list = data;
          },
          (err) => {
            console.error(err);
          }
        ).then(
          () => {
            $scope.totalSize = $scope.list.data.data.total;
            $scope.totalPage = Math.ceil($scope.totalSize / $scope.pageSize);
            $scope.displayPages = pageService.getDisplayPages($scope.totalPage);
          }
        );
      } else {
        myHttp.getArticle({size:$scope.pageSize}).then(
          (data) => {
            $scope.list = data;
          },
          (err) => {
            console.err(err);
          }
        ).then(
          () => {
            $scope.totalSize = $scope.list.data.data.total;
            $scope.totalPage = Math.ceil($scope.totalSize / $scope.pageSize);
            $scope.displayPages = pageService.getDisplayPages($scope.totalPage);
          }
        );
      }
    }
    $scope.search = function (selectedPage) {
      let selectedStartTime = Date.parse($scope.selectedStartTime);
      let selectedEndTime = Date.parse($scope.selectedEndTime);
      $scope.selectedPage = selectedPage;
      $location.search("type", $scope.selectedType);
      $location.search("startAt", selectedStartTime);
      $location.search("endAt", selectedEndTime);
      $location.search("status", $scope.selectedStatus);
      $location.search("page", selectedPage);
      params = {
        startAt: selectedStartTime ? selectedStartTime : null,
        endAt: selectedEndTime ? selectedEndTime : null,
        type: $scope.selectedType,
        status: $scope.selectedStatus,
        page: selectedPage,
        size: $scope.pageSize
      }
      myHttp.getArticle(params).then(
        (data) => {
          $scope.list = data;
        },
        (err) => {
          console.error(err);
        }
      ).then(() => {
        if ($scope.totalSize != $scope.list.data.data.total) {
          $scope.totalSize = $scope.list.data.data.total;
          $scope.totalPage = Math.ceil($scope.totalSize / $scope.pageSize);
          $scope.displayPages = pageService.getDisplayPages($scope.totalPage);
        }
        saveSession.save('params', $location.search());

      })
    }

    $scope.deleteInServer = function (id) {
      myHttp.delete(id).then((data)=>{
        if(data.data.code >= 0){
          alert("删除成功！");
        }
        $scope.search($scope.selectedPage);
      })
    }
    $scope.modifyStatus = function (id, status) {
        myHttp.modifyStatus(id,status).then((data)=>{
          console.log(data);
          $scope.search($scope.selectedPage)
        })
    }

    $scope.edit = function (index) {
      // saveSession.save('params',JSON.stringify($location.search()));
      $state.go('editArticle', {
        id: $scope.list.data.data.articleList[index].id
      });
    }
    $scope.clear = function () {
      $scope.selectedStartTime = $scope.selectedEndTime = $scope.selectedType = $scope.selectedStatus = undefined;
    }
    let asynLoad = function () {
      let defferd = $q.defer();
      let message = $ocLazyLoad.load('./controller/newArticle.js');
      console.log(message.$$state.status);

      defferd.resolve('OK');
      return defferd.promise;
    }
    // $scope.newArticle = function () {
    //   let promise = new asynLoad();
    //   promise.then((data)=>{
    //     $ocLazyLoad.load('./controller/newArticle.js');
    //   }).then(()=>{
    //     $state.go('articleDetails');
    //   })
    //   // setTimeout(() => {
    //   //   $state.go('articleDetails');
    //   // }, 500);

    // }
    $scope.init();
  })