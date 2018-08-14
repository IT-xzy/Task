angular.module("app").controller('corpCtrl',
function ($scope, $http) {
  // $ocLazyLoad.load('./controller/corpController.js');
  $scope.data = {
    industry: [0, 1, 2, 3, 4, 5, 6],
    type: [0, 1, 2, 3],
    status: [1, 2],
    scale: [0, 1, 2, 3, 4, 5, 6]
  }
  $scope.province;
  $scope.city;
  $scope.area;
  $http.get("./resource/city.json").then((data) => {
      $scope.province = data;
    },
    (err) => {
      console.log(err);
    }).then(() => {
  })

  $scope.onChangeProvince = function (e) {
    $scope.city = $scope.area = null;
    for(let i = 0; i < $scope.province.data.length; i++){
      if($scope.selectedProvince.name === $scope.province.data[i].name){
        $scope.cities = $scope.province.data[i].city;
      }
    }
  }
  $scope.onChangeCity = function () {
    for(let i = 0; i < $scope.cities.length; i++){
      if($scope.selectedCity.name === $scope.cities[i].name){
        $scope.area = $scope.cities[i].area;
      }
    }
  }
});
