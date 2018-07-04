var identifyIfo = JSON.parse(sessionStorage.getItem("playerIdentify"));
var num = sessionStorage.getItem("playerNums");
var playersifo = JSON.parse(sessionStorage.getItem('playersifo'));
var deadMan = JSON.parse(sessionStorage.getItem('deadMan'));
var deadManNum = JSON.parse(sessionStorage.getItem('deadManNum'));

console.log(identifyIfo);
console.log(num);
// 杀人和投票在一个页面,二者之间的区别是,二者的电击事件源
var dayTime = JSON.parse(sessionStorage.getItem('dayTime'));

console.log(dayTime);
if (dayTime === 0) {
    $('header p').html('杀手请杀人');
    $('.kill-farmer').html('杀死平民');
    // 杀手杀完人后就是第二天

} else if (dayTime === 1) {
    $('header p').html('全民投票');
    $('.kill-farmer').html('确认投票');
}
// 添加身份
for (a = 0; a < num; a++) {
    var b = a + 1;
    // if (identifyIfo[a] == '平民') {
    //     x = '<div class="player">' +
    //         '<div class="p-top">' +
    //         '待宰的羊' +
    //         '</div>' +
    //         '<div class="p-down">' +
    //         b +
    //         '</div>' +
    //         '</div>';
    //     $('.player-box').append(x);
    // } else {
    x = '<div class="player">' +
        '<div class="p-top">' +
        identifyIfo[a] +
        '</div>' +
        '<div class="p-down">' +
        b +
        '</div>' +
        '</div>';
    $('.player-box').append(x);
    // 关键，此时我们重新获取一组数组，通过对状态属性的更改来判定颜色的变化
    // 在加载的过程中就对状态进行判定，如果处于死的状态就改变颜色加载进来
    var players = $('.p-top');

    // 这里新建数组是为了和状态保持一致去操作
    // console.log(players)
    console.log(typeof(players))
    if (playersifo[a].state == 0) {
        $(players[a]).css({ 'background': 'red' })
    }

}
// }
for (var i = 0; num > i; i++) {
    $(".p-top").attr('id', i)
}
// 开始杀人
// 思想逻辑是对players这个数组中的包含的是对象;既然是对象就可以进行属性的操作,例如task1中更改背景色一样
// 但是task1中是对  对象更改属性(即属性是存在的情况下),但是除了更改属性;我们也可以创造属性如同attr和prop(jq中的方法;原生就是直接添加属性即可)

for (var i = 0; i < num; i++) {
    // 添加一个新的index属性
    // players[i].index = i;
    $(players[i]).prop('index', i);

    var last = 'abc';
    // 点击事件不发生的话last=abc
    // last如果内置的话, 每次都会重新声明
    players[i].onclick = function() {

        if (dayTime === 0) {
            if (playersifo[this.index].state === 0 || playersifo[this.index].identify === '杀手') {
                if (playersifo[this.index].state === 0) {
                    alert('他已经死了!!!')
                } else {
                    alert('本是同根生,相煎何太急!!!')
                }
            } else {
                var deadMan = []
                    // 此时的this指的是触发click事件的那个对象
                deadMan.push(playersifo[this.index].num);
                console.log(deadMan);
                sessionStorage.setItem('deadMan', JSON.stringify(deadMan));
                // deadman指的是被杀的那个人的编号
                // 此时deadMan里面包含了最后一个点击的人
                // 需要将deadMan传递出去

                // 现将现在点击的人杀了
                $(players[this.index]).css({ 'background': 'red' });
                playersifo[this.index].state = 0;
                // 再将之前的目标点击的救活(任务4做完测试一下task1这种思想去改变)
                if (last !== 'abc') {
                    $(players[last]).css({ 'background': '#f5c97b' });
                    playersifo[last].state = 1;
                }
                last = this.index;
                // 将本次循环的this.index保存起来,用于下次点击时改变其状态

            }
        } else if (dayTime === 1) {
            if (playersifo[this.index].state === 0) {
                alert('他已经死了!!!')
            } else {
                var deadMan = []
                    // 此时的this指的是触发click事件的那个对象
                deadMan.push(playersifo[this.index].num);
                console.log(deadMan);
                sessionStorage.setItem('deadMan', JSON.stringify(deadMan));
                // deadman指的是被杀的那个人的编号
                // 此时deadMan里面包含了最后一个点击的人
                // 需要将deadMan传递出去
                // 现将现在点击的人杀了

                $(players[this.index]).css({ 'background': 'red' });
                playersifo[this.index].state = 0;
                // 再将之前的目标点击的救活(任务4做完测试一下task1这种思想去改变)
                if (last !== 'abc') {
                    $(players[last]).css({ 'background': '#f5c97b' });
                    playersifo[last].state = 1;
                }
                last = this.index;
                // 将本次循环的this.index保存起来,用于下次点击时改变其状态
            }
        }
    }
}
// 判断游戏进程是否结束,当杀手人数大于等于农民人数时杀手胜利,当杀手人数等于0时农民胜利
// 此时就是要统计人数
var killer = 0;
var farmer = 0;

$('.kill-farmer').on('click', function() {
    sessionStorage.setItem('playersifo', JSON.stringify(playersifo));
    // 此时人物状态已经改变需要将其重新储存
    for (var i = 0; i < num; i++) {
        if (playersifo[i].identify === '杀手' && playersifo[i].state === 1) {
            killer++;
        }
        if (playersifo[i].identify === '平民' && playersifo[i].state === 1) {
            farmer++
        }
    }
    console.log(killer);
    console.log(farmer);
    sessionStorage.setItem('killer', JSON.stringify(killer));
    sessionStorage.setItem('farmer', JSON.stringify(farmer));
    if (last === "abc") {
        // 此时没杀人也可进行下一步骤,需要进行判断
        alert('你确定不杀人吗');
    } else {
        if (killer === 0) {
            alert('平民胜利');
            window.location.href = './task2结果.html';
        } else if (killer >= farmer) {
            alert('杀手胜利');
            window.location.href = './task2结果.html';
        } else {
            window.location.href = './大法官的日志.html';
        }
    }

})