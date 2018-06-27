// 获取前面页面的数据
var identifyIfo = JSON.parse(sessionStorage.getItem("playerIdentify"));
var num = sessionStorage.getItem("playerNums");
var playersifo = JSON.parse(sessionStorage.getItem('playersifo'));
var bg = JSON.parse(sessionStorage.getItem('bg1'));
var deadMan = JSON.parse(sessionStorage.getItem('deadMan'));
var deadManNum = JSON.parse(sessionStorage.getItem('deadManNum'));
var dayTime = JSON.parse(sessionStorage.getItem('dayTime'));
var day = JSON.parse(sessionStorage.getItem('day'));

console.log(identifyIfo);
console.log(num);
console.log(playersifo);
console.log(deadMan);
console.log(deadManNum);
console.log(bg);
console.log(dayTime);
console.log(day);
// 更改时间
$('.day-time').html('第' + day + '天');

// 需要统计死亡人数来判断是否是新的一天
if (deadMan.length == 0) {
    console.log('这是没有死人的情况下才会出来的')
} else {
    deadManNum.push(deadMan[0])
}
sessionStorage.setItem('deadManNum', JSON.stringify(deadManNum));
console.log(deadManNum);
// 对playersifo中人物状态的查看,算出挂掉任务的数值
var deadpersonNum = 0;
playersifo.forEach(function(value, index, array) {
    console.log(value);
    if (value.state === 0) {
        deadpersonNum++
    }
    // return deadpersonNum
});
console.log(deadpersonNum)
    // 根据是否完成投票来决定按钮的显示色

if (deadpersonNum % 2 == 0) {
    console.log('投票完成')
} else {
    $('.game-step1').css({
        'backgroundColor': '#eaeaea',
        'pointerEvents': 'none',
        'cursor': 'notAllowed'
    })

    console.log('杀手杀人完成')
}

// 进入杀人界面
function killerFarmer() {
    var dayTime = 0;
    var bg = $('.game-step1').css('backgroundColor');
    $('.game-step1').css({
        'backgroundColor': '#eaeaea',
        'pointerEvents': 'none',
        'cursor': 'notAllowed'
    })
    sessionStorage.setItem('bg1', JSON.stringify(bg));
    sessionStorage.setItem('dayTime', JSON.stringify(dayTime));
    window.location.href = "./杀人页面.html";
    // 杀手是在晚上杀人所以杀手杀完人跳回日志时,时间是第二天的白昼
    day++
    sessionStorage.setItem('day', JSON.stringify(day));
    return day;
}

// 进入亡灵发表遗言环节
$('.game-step2').on('click', function() {
    if ($('.game-step1').css('backgroundColor') === 'rgb(41, 189, 224)') {
        alert('请完成上一步')
    } else {
        alert('请亡灵发表遗言');
        $('.game-step2').css({
            'backgroundColor': '#eaeaea',
            'pointerEvents': 'none',
            'cursor': 'notAllowed'
        })
    }

})

// 进入玩家轮流投票环节
$('.game-step3').on('click', function() {
    if ($('.game-step2').css('backgroundColor') === 'rgb(41, 189, 224)') {
        alert('请完成上一步')
    } else {
        alert('请玩家互相投票');
        $('.game-step3').css({
            'backgroundColor': '#eaeaea',
            'pointerEvents': 'none',
            'cursor': 'notAllowed'
        })
    }
})

// 进入全民投票环节
$('.game-step4').on('click', function() {
    if ($('.game-step2').css('backgroundColor') === 'rgb(41, 189, 224)') {
        alert('请完成上一步')
    } else {
        var dayTime = 1;
        $('.game-step3').css({
            'backgroundColor': '#eaeaea',
            'pointerEvents': 'none',
            'cursor': 'notAllowed'
        })
        sessionStorage.setItem('dayTime', JSON.stringify(dayTime));
        window.location.href = "./杀人页面.html";
    }
})


$('.stop-game').on('click', function() {
    if (window.confirm('你确定要结束游戏吗？')) {
        //alert("确定");

        window.location.href = './task2首页.html'
        return true;
        // 这个地方需要清空缓存
    } else {
        //alert("取消");
        return false;
    }
})
$('.diary').on('click', function() {
    window.location.href = './大法官的日记本.html'
})

// 反复查看deadManNum会有重复的数组
// 先定义一个新的数组
var newArr = [];
// 遍历数组
for (i = 0; i < deadManNum.length; i++) {
    if (newArr.indexOf(deadManNum[i]) < 0) {
        //判断在s数组中是否存在，不存在则push到s数组中
        newArr.push(deadManNum[i]);
    }
    console.log(newArr);
}
sessionStorage.setItem('newArr', JSON.stringify(newArr));