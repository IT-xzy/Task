angular.module('app').controller('easyKillGameLog', ['$rootScope', '$scope', '$state', 'softHeader', function ($rootScope, $scope, $state, softHeader) {
    $rootScope.softHeader = softHeader.easyKillGameLog;
    //返回按钮
    $rootScope.softHeader.left.uiSref = $rootScope.deskGame.preGame.uiSref;
    var vm = this;
    //当前玩的
    vm.domData = $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['gameLog'];
    vm.handle = function ($event, $index) {
        var self = $($event.target);
        var index = self.index();
        if (self[0].nodeName.toLowerCase() === 'li') {
            //事件委托开始
            //&& 优先级大于 || 所以
            if (index != 0 && self.prev().attr('class').indexOf('checked') === (-1)) {
                alert('流程不对哦!')
            } else if (self.attr('class').indexOf('checked') != (-1)) {
                alert('看看下面的流程吧!')
            } else {
                //写着没有好的办法了。。只能这样
                switch (index) {
                    case 0:
                        vm.domData[$index]['kill']['isChecked'] = true;
                        $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['isKill'] = true;
                        $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['gameLog'] = vm.domData;
                        $rootScope.saveDeskGame();
                        break;
                    case 1:
                        ~function () {
                            var instance = confirm('玩家依次发言！');
                            instance.then(function (resolved) {
                                vm.domData[$index]['speakByDie']['isChecked'] = true;
                                $rootScope.saveDeskGame();
                            }, function (rejected) {
                            })
                        }();
                        return;
                    case 2:
                        ~function () {
                            var instance = confirm('玩家依次发言！');
                            instance.then(function (resolved) {
                                vm.domData[$index]['speakByLive']['isChecked'] = true;
                                $rootScope.saveDeskGame();
                            }, function (rejected) {
                            })
                        }();
                        return;
                    case 3:
                        vm.domData[$index]['vote']['isChecked'] = true;
                        $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['isKill'] = false;
                        $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['gameLog'] = vm.domData;
                        $rootScope.saveDeskGame();
                        break;
                }
                //放在最后
                $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['gameLog'] = vm.domData;
                $rootScope.saveDeskGame();
                $state.go('easyKillGamePlay');
            }
        }
    }

}])