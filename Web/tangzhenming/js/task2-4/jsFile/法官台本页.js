/*
 * @Author: 汤镇铭Michael 
 * @Date: 2018-01-20 14:14:49 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-21 15:08:47
 */
// -------------------------------------------------------------------------------------------
var sumState = JSON.parse(sessionStorage.getItem('sumRandom'));// 数据传递
console.log(sumState);

var stepDay = document.getElementById('day');// 流程天数

var kill = document.getElementsByClassName('kill');// 获取杀人按钮
var testament = document.getElementsByClassName('testament');// 获取亡灵发表遗言按钮
var talk = document.getElementsByClassName('talk');// 获取玩家依次发言按钮
var vote = document.getElementsByClassName('vote')// 获取投票按钮
var triangle = document.getElementsByClassName('triangle');// 获取按钮前三角形

var close = document.getElementsByClassName('close');// 获取结束游戏按钮

var fsm = new StateMachine({// 生成实例
    transitions: [// 创建生命周期
        { name: 'trans1', from: 'none', to: 'skill' },// 绑定事件，设定状态转化
        { name: 'trans2', from: 'skill', to: 'stestament' },
        { name: 'trans3', from: 'stestament', to: 'stalk' },
        { name: 'trans4', from: 'stalk', to: 'svote' },
        { name: 'trans5', from: 'svote', to: 'none' },
        { name: 'goto', from: '*', to: function (state) { return state } }
    ],
    methods: {
        onTrans1: function () {
            var state1 = fsm.state;// 保存状态
            sessionStorage.setItem('state1', state1);
            window.location.href = 'https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/06.%E6%9D%80%E6%89%8B%E6%9D%80%E4%BA%BA%E9%A1%B5.html';
        },
        onTrans2: function () {
            var state2 = fsm.state;// 保存状态
            sessionStorage.setItem('state2', state2);
        },
        onTrans3: function () {
            var state3 = fsm.state;// 保存状态
            sessionStorage.setItem('state3', state3);
        },
        onTrans4: function () {
            vote[0].style.backgroundColor = 'gray';
            triangle[3].style.borderRightColor = 'gray';
            var state4 = fsm.state;// 保存状态
            sessionStorage.setItem('state4', state4);
            window.location.href = 'https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/07.%E6%8A%95%E7%A5%A8%E9%A1%B5.html';
        },     
    }
});
// ------------------------------------------------------------------------------------------
if (sessionStorage.getItem('day') == null) {// 本地存储中还未存储天数
    var day = 1;// 声明天数
    sessionStorage.setItem('day', day);
} else {
    var day = sessionStorage.getItem('day');// 本地存储中已经存储了天数
}
stepDay.innerHTML = day; // 根据当前天数，把天数写入页面
// --------------------------------------------------------------------------------------
$('.kill').click(function () {// 杀手杀人
    fsm.trans1();
});
if (sessionStorage.getItem('state1') == 'skill') {
    kill[0].style.backgroundColor = 'gray';
    triangle[0].style.borderRightColor = 'gray';
    fsm.goto('skill');
}

$('.testament').click(function () {// 亡灵发表遗言
    fsm.trans2();
    alert('亡灵发表遗言');
    testament[0].style.backgroundColor = 'gray';
    triangle[1].style.borderRightColor = 'gray';
    fsm.goto('stestament');
});

$('.talk').click(function () {// 玩家依次发言
    fsm.trans3();
    alert('玩家依次发言');
    talk[0].style.backgroundColor = 'gray';
    triangle[2].style.borderRightColor = 'gray';
    fsm.goto('stalk');
});

$('.vote').click(function () {// 全民投票
    fsm.trans4();
});
if (sessionStorage.getItem('state4') == 'svote') {
    fsm.goto('svote');
    fsm.goto('none');
}

sessionStorage.removeItem('state1');
sessionStorage.removeItem('state2');
sessionStorage.removeItem('state3');
sessionStorage.removeItem('state4');

console.log(fsm.state);// 打印状态
// ---------------------------------------------------------------------------------------
close[0].onclick = function () {// 结束游戏
    window.location.href = 'https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/01.%E9%A6%96%E9%A1%B5.html';
    sessionStorage.clear();
}