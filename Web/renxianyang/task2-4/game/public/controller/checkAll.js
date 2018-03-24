angular.module('app').controller('checkAll', ['$scope', '$rootScope', 'softHeader', '$stateParams', function ($scope, $rootScope, softHeader, $stateParams) {
    $rootScope.softHeader = softHeader.checkAll;
    var vm = this;
    //当前玩的
    vm.gameData = $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref];
    vm.data = {
        //dom数据
        domData: vm.gameData.data,
    }
    vm.flag = {
        //是否查看
        isCheck: undefined,
    }
}])