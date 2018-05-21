angular.module('app').controller('checkSelf', ['$scope', '$rootScope', 'softHeader', '$state', function ($scope, $rootScope, softHeader, $state) {
    $rootScope.softHeader = softHeader.checkSelf;
    var vm = this;
    //正在玩的
    // 游戏数据
    vm.domDate = $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['data'];
    //返回 正在玩的游戏
    $rootScope.softHeader.left.uiSref = $rootScope.deskGame.preGame.uiSref;
    //是否查看身份
    vm.checkFlag = false;
    vm.self = {
        index: 0,
        role: '请点击查看身份!',
    }
    vm.btnText = '点击查看' + (vm.self.index + 1) + '号身份';
    vm.checkSelf = function ($event) {
        vm.checkFlag = !vm.checkFlag;
        if (vm.checkFlag) {
            vm.self.role = vm.domDate[vm.self.index]['type'];
            vm.btnText = '隐藏身份并传递给' + (vm.self.index + 2) + '号';
            if (vm.self.index == vm.domDate.length - 1) {
                vm.btnText = '法官查看';
                vm.checkSelf = function () {
                    $state.go('checkAll');
                };
            }
        } else if (vm.self.index < vm.domDate.length - 1) {
            vm.self.index++;
            vm.self.role = '请点击查看身份!';
            vm.btnText = '点击查看' + (vm.self.index + 1) + '号身份';
        }
    }
}])
