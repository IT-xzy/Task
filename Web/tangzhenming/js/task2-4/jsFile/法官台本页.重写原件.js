/*
* @Author: 汤镇铭Michael 
* @Date: 2018-01-14 11:38:19 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-20 16:06:48
*/

/* var sumState = JSON.parse(sessionStorage.getItem('sumRandom'));// 数据传递
console.log(sumState); */

// 设置FSM-------------------------------------------------------------------------
/* var triangle = document.getElementsByClassName('triangle');// 获取选项前三角形 */

/* var FSM = new StateMachine ({// 生成实例
    init: 'initial',
    transitions: [// 创建生命周期
        { name: 'trans1', from: 'initial', to: 'sKill'},// 绑定事件，设定状态转化
        { name: 'trans2', from: 'sKill', to: 'sTestament'},
        { name: 'trans3', from: 'sTestament', to: 'sTalk'},
        { name: 'trans4', from: 'sTalk', to: 'sVote'},
        { name: 'trans5', from: 'sVote', to: 'initial'},
        // { name: 'goto', from: '*', to: function (state) { return state } }
    ],
    methods: {
        onSKill: function () {
            
            
            var state1 = FSM.state;// 保存状态
            // console.log(typeof state1);
            sessionStorage.setItem('state1', state1);
            
        },
        onSTestament: function () {
            testament[0].style.backgroundColor = 'gray';
            triangle[1].style.borderRightColor = 'gray';
            
            var state2 = FSM.state;// 保存状态
            sessionStorage.setItem('state2', state2);
        },
        onSTalk: function () {
            talk[0].style.backgroundColor = 'gray';
            triangle[2].style.borderRightColor = 'gray';
            
            var state3 = FSM.state;// 保存状态
            sessionStorage.setItem('state3', state3);
        },
        onSVote: function () {
            vote[0].style.backgroundColor = 'gray';
            triangle[3].style.borderRightColor = 'gray';
            
            var state4 = FSM.state;// 保存状态
            sessionStorage.setItem('state4', state4);
        },
    }
}); */

// FSM.goto('initial');

// 杀手杀人按钮---------------------------------------------------------------------
/* var kill = document.getElementsByClassName('kill');
$('.kill').click(function () {
    FSM.trans1();
    console.log(FSM.state);
    kill[0].style.backgroundColor = 'gray';
    triangle[0].style.borderRightColor = 'gray';
    window.location.href = 'file:///C:/Users/Administrator/Desktop/mycode/TZM-ITJNS/JavaScript/task2/htmlFile/06.%E6%9D%80%E6%89%8B%E6%9D%80%E4%BA%BA%E9%A1%B5.html';
}); */
// console.log(kill);
// kill[0].onclick = function () {
// }

/* // 亡灵发表遗言、玩家依次发言按钮-----------------------------------------------------
var testament = document.getElementsByClassName('testament');
$('.testament').click(function () {
    FSM.trans2();
    console.log(FSM.state);
    alert('亡灵发表遗言');
});
// testament[0].onclick = function () {
// }
var talk = document.getElementsByClassName('talk');
$('.talk').click(function () {
    FSM.trans3();
    console.log(FSM.state);
    alert('玩家依次发言');
});
// talk[0].onclick = function () {
// } */

/* // 投票按钮--------------------------------------------------------------------------
var vote = document.getElementsByClassName('vote')
$('.vote').click(function () {
    FSM.trans4();
    window.location.href = 'file:///C:/Users/Administrator/Desktop/mycode/TZM-ITJNS/JavaScript/task2/htmlFile/07.%E6%8A%95%E7%A5%A8%E9%A1%B5.html';
    console.log(FSM.state);
}); */
// vote[0].onclick = function () {
// }



/* // 天数-----------------------------------------------------------------------
if (sessionStorage.getItem('day') == null) {// 判断本地存储中是否已经存在天数
    var day = 1;// 声明天数
    sessionStorage.setItem('day', day);
}
var day = sessionStorage.getItem('day');
console.log(day); */

// 天数增加后----------------------------------------------------------------
// var dayNum = document.getElementById('day');
// dayNum.innerHTML = day;
if (day > 1) {
    /* var main = document.getElementsByClassName('main')[0];
    console.log(main);
    var container = document.getElementsByClassName('container')[0];
    console.log(container); */
    /* var cClone = container.cloneNode(true);
    main.appendChild(cClone); */
    $('.main').append($('.container').clone(true));
    // $('.container').first().empty();
    // FSM.trans5(); 
}

if (sessionStorage.getItem('state1') != null) {// 对本地存储中的数据做判断
    // FSM.goto(sessionStorage.getItem('state1'));// 从杀人页面回来之后，重新定位至状态sKill
    FSM.trans1();
}

// 投票后又重新跳转回来初始页面，所以把所有状态再一次重新定位一次，让所有按钮变灰色--------
if (sessionStorage.getItem('state2') != null && sessionStorage.getItem('state3') != null && sessionStorage.getItem('state4') != null) {
    // FSM.goto(sessionStorage.getItem('state2'));
    // FSM.goto(sessionStorage.getItem('state3'));
    // FSM.goto(sessionStorage.getItem('state4'));
    FSM.trans2();
    FSM.trans3();
    FSM.trans4();
}

/* // 结束游戏------------
var close = document.getElementsByClassName('close');
// console.log(close);
close[0].onclick = function () {
    window.location.href = 'file:///C:/Users/Administrator/Desktop/mycode/TZM-ITJNS/JavaScript/task2/htmlFile/01.%E9%A6%96%E9%A1%B5.html';
    sessionStorage.clear();
} */
// console.log(FSM.state); // 打印当前状态