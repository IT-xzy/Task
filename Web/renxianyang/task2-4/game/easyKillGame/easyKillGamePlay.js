angular.module('app').controller('easyKillGamePlay', ['$scope', '$rootScope', 'softHeader', '$state', function ($scope, $rootScope, softHeader, $state) {
    $rootScope.softHeader = softHeader.easyKillGamePlay;
    //返回按钮
    $rootScope.softHeader.left.uiSref = $rootScope.deskGame.preGame.uiSref;
    var vm = this;
    //当前玩的
    vm.gameData = $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref];
    vm.data = {
        //dom数据
        domData: vm.gameData.data,
    }
    vm.flag = {
        //是否杀人页面
        isKill: vm.gameData.isKill,
        //是否选择了目标
        isChoose: undefined,
    }
    vm.submitInfo = {
        btnText: vm.flag.isKill ? '杀手杀人' : '投票',
        uiSref: $rootScope.deskGame.preGame.uiSref,
        submit: null,
    }
    vm.ways = {
        choose: function ($index) {
            //这个加1必须，$index等于0 ng-show有bug
            vm.flag.isChoose = $index + 1;
        },
        isKill: function () {
            //这是一个自运行函数，判断杀人还是投票
            vm.submitInfo.submit = function () {
                var target = vm.data.domData[vm.flag.isChoose - 1];
                if (!target['isLive']) {
                    alert('玩家已经死亡！');
                    return;
                }
                //死亡统计
                if (target['type'] === '杀手') {
                    if (vm.flag.isKill) {
                        alert('不能杀死同类哦！');
                        return;
                    }
                    vm.gameData['roles']['kill']--;
                } else if (target['type'] === '水民') {
                    vm.gameData['roles']['men']--;
                }
                //修改状态--重要勿动
                target['isLive'] = false;
                //判断杀人投票
                if (!vm.flag.isKill) {
                    //白天投票log
                    $rootScope.deskGame.histroyGame[
                        $rootScope.deskGame.preGame.uiSref]['gameLog'][$rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['gameLog'].length - 1
                        ]['vote']['log'] = '白天' + vm.flag.isChoose + '号玩家死亡，其身份是' + target.type;
                } else {
                    //晚上杀人Log
                    $rootScope.deskGame.histroyGame[
                        $rootScope.deskGame.preGame.uiSref]['gameLog'][$rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['gameLog'].length - 1
                        ]['kill']['log'] = '黑夜' + vm.flag.isChoose + '号玩家死亡，其身份是' + target.type;
                }
                //胜利判断
                if (vm.gameData['roles']['men'] === 0) {
                    vm.ways.exportLog('杀手胜利<br/>');
                } else if (vm.gameData['roles']['kill'] === 0) {
                    vm.ways.exportLog('水民胜利<br/>');
                } else {
                    if (!vm.flag.isKill) {
                        $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['gameLog'].push({
                            kill: {
                                content: '杀手杀人',
                                isChecked: false,
                                log: '',
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
                                log: '',
                            }
                        })
                    }
                    $state.go('easyKillGameLog');
                }
                //写在最后
                $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref] = vm.gameData;
                $rootScope.saveDeskGame();
            }
            return '判断杀人投票完成！';
        }(),
        exportLog: function (win) {
            //输出日志的函数
            var log = $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref]['gameLog'];
            // var days = log.length % 2 === 0 ? log.length / 2 : (log.length + 1) / 2;这个算错了
            var res = win;
            for (var i = 0; i < log.length; i++) {
                res += '第' + (i + 1) + '天：<br/>' + log[i]['kill']['log'] + '!<br/>' + log[i]['vote']['log'] + '!<br/>';
            }
            //清除，游戏结束
            $rootScope.deskGame.histroyGame[$rootScope.deskGame.preGame.uiSref] = {};
            $rootScope.saveDeskGame();
            document.writeln(res);
        },
    }
}
])