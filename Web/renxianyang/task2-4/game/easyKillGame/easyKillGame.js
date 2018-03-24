angular.module('app').controller('easyKillGame', ['$scope', '$rootScope', 'softHeader', '$state', function ($scope, $rootScope, softHeader, $state) {
    $rootScope.softHeader = softHeader.setPlayerNumber;
    var vm = this;
    vm.editBtn = {
        flag: true,
        disabled: false,
    }
    vm.roles = {
        //default配置
        all: 6,
    };
    vm.checkValue = function () {
        //检测人数范围
        if ((vm.roles.kill + vm.roles.men) > 18 || (vm.roles.kill + vm.roles.men) < 4) {
            alert('人数范围是4-18哦！');
            vm.editBtn.disabled = true;
            vm.roles.all = 6;
            return;
        } else {
            vm.editBtn.disabled = false;
            vm.roles.all = vm.roles.kill + vm.roles.men;
        }
    }
    vm.submit = function () {
        var res = [];
        for (var i = 0; i < vm.roles.kill; i++) {
            res.push({
                type: "杀手",
                isLive: 'true'
            });
        }
        for (var i = 0; i < vm.roles.men; i++) {
            res.push({
                type: "水民",
                isLive: 'true'
            });
        }
        res.sort(function () {
            return 0.5 - Math.random();
        });
        //每次发牌都置为空对象，不写会报错
        $rootScope.deskGame.histroyGame['easyKillGame'] = {};
        $rootScope.deskGame.histroyGame['easyKillGame']['data'] = res;
        //杀人、投票页面判断
        $rootScope.deskGame.histroyGame['easyKillGame']['isKill'] = true;
        //历史
        $rootScope.deskGame.histroyGame['easyKillGame']['gameLog'] = [{
            kill: {
                content: '杀手杀人',
                isChecked: false,
            },
            speakByDie: {
                content: '亡灵发表遗言',
                isChecked: false,
            },
            speakByLive: {
                content: '玩家依次发言',
                isChecked: false,
            },
            vote: {
                content: '全民投票',
                isChecked: false,
            }
        }];
        $rootScope.deskGame.histroyGame['easyKillGame']['gameLogInfo'] = [];
        //数量
        $rootScope.deskGame.histroyGame['easyKillGame']['roles'] = vm.roles;
        $rootScope.saveDeskGame();
        $state.go('checkSelf');
    }
    vm.$watch = $scope.$watch('vm.roles.all', function (New) {
        switch (true) {
            case New >= 4 && New < 6:
                vm.roles.kill = 1;
                break;
            case New >= 6 && New < 11:
                vm.roles.kill = 2;
                break;
            case New >= 11 && New < 13:
                vm.roles.kill = 3;
                break;
            case New >= 13 && New <= 18:
                vm.roles.kill = 5;
                break;
            default:
                break;
        }
        vm.roles.men = New - vm.roles.kill;
    });
}])