app.directive('myPageButton', function () {
  return {
    restrict: 'EA',
    // template: '<h1>{{pageSize}}</h1>',
    templateUrl: './view/myPageButton.html',
    scope: {
      totalPage: '=',
      selectedPage: '=',
      pageSize: '=',
      search: '=',
      // displayPages: '='
    },
    // scope:true,
    link: function (scope, elemnt, attr) {},
    controller: function ($scope, $http,$location,saveSession) {
      $scope.active = {
        myActive: {
          myActive: false
        }
      }
      $scope.totalPage = undefined;
      let params = saveSession.get('params');
      // console.log(params);
      $scope.directPage ;
      $scope.detectPage = function () {
        if($scope.directPage > $scope.totalPage){
          $scope.directPage = $scope.totalPage;
        }
      }
      $http({
        method: 'GET',
        url: '/carrots-admin-ajax/a/article/search',
        params: params,
      }).then((data) => {
        $scope.totalPage = Math.ceil(data.data.data.total / $scope.pageSize);
        // console.log(data);
        // console.log($scope.totalPage);
      }).then(() => {
        // console.log($scope.displayPages);
        // $scope.pageCount = Math.ceil($scope.totalPage / $scope.pageSize);
        // if ($scope.totalPage > 5) {
        //   let firstPage;
        //   if($scope.selectedPage > $scope.totalPage - $scope.displayPages.length){
        //     firstPage = $scope.totalPage - $scope.displayPages.length + 1;
        //   }
        //   else{
        //     firstPage = $scope.selectedPage;
        //   }

        //   $scope.displayPages = [{
        //       index: firstPage,
        //       isActive: {
        //         'myActive': false,
        //       }
        //     },
        //     {
        //       index: firstPage +1,
        //       isActive: {
        //         'myActive': false
        //       }
        //     },
        //     {
        //       index: firstPage +2,
        //       isActive: {
        //         'myActive': false
        //       }
        //     },
        //     {
        //       index: firstPage +3,
        //       isActive: {
        //         'myActive': false
        //       }
        //     },
        //     {
        //       index: firstPage +4,
        //       isActive: {
        //         'myActive': false
        //       }
        //     },
        //   ];
        // } else {
        //   for (let i = 0; i < $scope.totalPage; i++) {
        //     $scope.displayPages[i] = {
        //       index: i + 1,
        //       isActive: {
        //         'myActive': false
        //       }
        //     };
        //   }
        // }
        // for(let i in $scope.displayPages){
        //   if($scope.displayPages[i].index == $scope.selectedPage){
        //     $scope.displayPages[i].isActive.myActive = true;
        //   }
        // }
      })
      $scope.directSelect = function (page) {
        $scope.search(page);
        $scope.selectedPage = page;
        // console.log($scope.selectedPage);

        let diff = page - $scope.displayPages[0].index;
        if (page < $scope.totalPage - 5) {

          for (let i = 0; i < $scope.displayPages.length; i++) {
            $scope.displayPages[i].index += diff;
            $scope.displayPages[i].isActive.myActive = false;
          }
          $scope.displayPages[0].isActive.myActive = true;
        } else if (page >= $scope.totalPage - 5 && page <= $scope.totalPage) {
          for (let i = 0; i < $scope.displayPages.length; i++) {
            $scope.displayPages[i].index = $scope.totalPage - $scope.displayPages.length + 1 + i;
            $scope.displayPages[i].isActive.myActive = false;
          }
          $scope.displayPages[$scope.displayPages.length - $scope.totalPage + page - 1].isActive.myActive = true;
        }
        // console.log(sessionStorage.params);
        sessionStorage.params = JSON.stringify($location.search());
      }
      $scope.nextPage = function () {
        let selectedPage;
        if ($scope.selectedPage >= $scope.totalPage - $scope.displayPages.length + 1 || $scope.total < 5) {
          for (let i = 0; i < $scope.displayPages.length; i++) {
            if ($scope.displayPages[i].isActive.myActive == true) {
              selectedPage = i;
              console.log($scope.selectedPage);
              break;
            }
          }
          $scope.displayPages[selectedPage].isActive.myActive = false;
          $scope.displayPages[selectedPage + 1].isActive.myActive = true;
          $scope.selectedPage++;
          $scope.search($scope.selectedPage);
          // console.log(1);
        } else {
          // console.log(2);

          for (let i = 0; i < $scope.displayPages.length; i++) {
            $scope.displayPages[i].index += 1;
          }
          $scope.selectedPage = $scope.displayPages[0].index;
          // console.log($scope.selectedPage);
          $scope.search($scope.displayPages[0].index);
        }
        sessionStorage.params = JSON.stringify($location.search());

      }
      $scope.prevPage = function () {
        let selectedPage;
        if ($scope.selectedPage > $scope.totalPage - $scope.displayPages.length + 1) {
          for (let i = 0; i < $scope.displayPages.length; i++) {
            if ($scope.displayPages[i].isActive.myActive == true) {
              selectedPage = i;
              break;
            }
          }
          $scope.displayPages[selectedPage].isActive.myActive = false;
          $scope.displayPages[selectedPage - 1].isActive.myActive = true;
          $scope.selectedPage--;
          $scope.search($scope.selectedPage);

        } else {
          for (let i = 0; i < $scope.displayPages.length; i++) {
            $scope.displayPages[i].index -= 1;
          }
          for (let i = 0; i < $scope.displayPages.length; i++) {
            $scope.displayPages[i].isActive.myActive = false;
          }
          $scope.displayPages[0].isActive.myActive = true;
          $scope.selectedPage = $scope.displayPages[0].index;
          // console.log($scope.selectedPage);
          $scope.search($scope.displayPages[0].index);
        }
        saveSession.save('params',$location.search());
        // console.log(saveSession.get('params'));
//
      }
      $scope.head = function () {
        for (let i = 0; i < $scope.displayPages.length; i++) {
          $scope.displayPages[i].index = i + 1;
        }
        for (let i = 0; i < $scope.displayPages.length; i++) {
          $scope.displayPages[i].isActive.myActive = false;
        }
        $scope.displayPages[0].isActive.myActive = true;
        $scope.search(1);
        saveSession.save('params',$location.search());
      }
      $scope.tail = function () {

        for (let i = 0; i < $scope.displayPages.length; i++) {
          $scope.displayPages[$scope.displayPages.length - i - 1].index = $scope.totalPage - i;
        }
        for (let i = 0; i < $scope.displayPages.length; i++) {
          $scope.displayPages[i].isActive.myActive = false;
        }
        $scope.displayPages[$scope.displayPages.length - 1].isActive.myActive = true;
        $scope.selectedPage = $scope.totalPage;
        // console.log($scope.selectedPage);
        $scope.search($scope.totalPage);
        saveSession.save('params',$location.search());
      }
      $scope.$watch('totalPage', function (newValue, oldValue) {
        // console.log($scope.totalPage);
        // console.log(1);

        $scope.displayPages = [];
        if ($scope.totalPage > 5) {
          let firstPage;
          // console.log('selectedPage:' + $scope.selectedPage);
          // console.log('totalPage:' + $scope.totalPage);

          if($scope.selectedPage >= $scope.totalPage - $scope.displayPages.length){
            $scope.displayPages = [1,2,3,4,5];
            firstPage = $scope.totalPage - $scope.displayPages.length + 1;
            // console.log('selectedPage2:' + $scope.selectedPage);
            // console.log('firstPage:' + firstPage);
          }
          else{
            firstPage = $scope.selectedPage;
          }

          $scope.displayPages = [{
              index: firstPage,
              isActive: {
                'myActive': false
              }
            },
            {
              index: firstPage +1,
              isActive: {
                'myActive': false
              }
            },
            {
              index: firstPage +2,
              isActive: {
                'myActive': false
              }
            },
            {
              index: firstPage + 3,
              isActive: {
                'myActive': false
              }
            },
            {
              index: firstPage +4,
              isActive: {
                'myActive': false
              }
            },
          ];
          for(let i in $scope.displayPages){
            if($scope.displayPages[i].index == $scope.selectedPage){
              $scope.displayPages[i].isActive.myActive = true;
            }
          }
        } else {
          for (let i = 0; i < $scope.totalPage; i++) {
            $scope.displayPages[i] = {
              index: i + 1,
              isActive: {
                'myActive': false
              }
            };
          }
          if($scope.displayPages[0]){
            $scope.displayPages[0].isActive.myActive = true;
          }
        }

      })

      $scope.$watch('selectedPage',function () {

      });
    }

  }
});