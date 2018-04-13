"use strict"
var ab = JSON.parse(sessionStorage.getItem("ab"));
var diemoon = sessionStorage.getItem("diemoon");
var diesun = sessionStorage.getItem("diesun");

//游戏天数
var day = JSON.parse(sessionStorage.getItem("day"));
if (day == undefined) {
    day = 0;
}

// 死者数组
var killed = JSON.parse(sessionStorage.getItem("killed")); //取死亡名单
if (killed == undefined) {
    killed = [];
}

$(document).ready(function () {
    // 有限状态机，控制流程step1-4
    // 创建一个控制流程的参数
    var game = new StateMachine({
        // 初始
        init: 'none',
        transitions: [
            {name: 'step1',from: 'none', to: '1'
            },
            { name: 'step2',from: '1', to: '2'
            },
            {name: 'step3',from: '2',to: '3'
            },
            {name: 'step4', from: '3',to: '4'
            },
            {name: 'reset',from: '4',to: 'none'// ？？？？
            }
        ],

        // 这里只是方法，点击事件要重新写
        methods: {
            onStep1: function () {
                $(".btn").eq(day * 4 - 4).addClass("another");
                $(".trangel").eq(day * 4 - 4).addClass("border-another");
            },
            onStep2: function () {
                $(".btn").eq(day * 4 - 3).addClass("another");
                $(".trangel").eq(day * 4 - 3).addClass("border-another");
            },
            onStep3: function () {
                $(".btn").eq(day * 4 - 2).addClass("another");
                $(".trangel").eq(day * 4 - 2).addClass("border-another");
            },
            onStep4: function () {
                $(".btn").eq(day * 4 - 1).addClass("another");
                $(".trangel").eq(day * 4 - 1).addClass("border-another");
            },
            onAfterStep4: function () {
                sessionStorage.removeItem("gameother");
                sessionStorage.removeItem("game");
                window.location.reload();
                // 页面自动刷新js
            }
        }
    })
    var i = $(".btn").index($(this));
    // 添加点击事件，当点击某一步执行的操作，调用上面的方法
    $(".btn").eq(day * 4 - 4).click(function () {
        game.step1();
        alert("进入杀人环节！");
        window.sessionStorage.setItem('game', '1');
        window.location.href = "task4-2.html";
        window.sessionStorage.getItem('gameother');
    })
    $(".btn").eq(day * 4 - 3).click(function () {
        game.step2();
        window.sessionStorage.setItem('game', "2");
        alert("亡灵发表遗言！");
    })
    $(".btn").eq(day * 4 - 2).click(function () {
        game.step3();
        window.sessionStorage.setItem('game', "3");
        alert("玩家依次发言！")
    })
    $(".btn").eq(day * 4 - 1).click(function () {
        game.step4();
        window.sessionStorage.setItem('game', "4");
        alert("进入投票环节！");
        window.location.href = "task4-2.html";
    })
    // 判断流程状态，存储状态并在跳转页面之后返回另一个值实现    
    var gameother = window.sessionStorage.getItem("gameother");
    if (gameother == "1") {
        game.step1();
    } else if (gameother == "2") {
        game.step1();
        game.step2();
    } else if (gameother == "3") {
        game.step1();
        game.step2();
        game.step3();
    } else if (gameother == "4") {
        game.step1();
        game.step2();
        game.step3();
        game.step4();
    } else {
        game.reset();
    }
})

// 从缓存状态数组中取出活着的杀手和平民人数
// if (sessionStorage.getItem('cache') !== null) {
//     var cache = JSON.parse(sessionStorage.getItem("cache"));
//     var killerLive = 0, //杀手人数
//         civilianLive = 0; //平民人数
//     for (var f = 0; f < cache.length; f++) {
//         if (cache[f].role === '杀手' && cache[f].state === 'alive') {
//             killerLive++;
//             sessionStorage.setItem("killerLive", killerLive);
//         } else if (cache[f].role === '平民' && cache[f].state === 'alive') {
//             civilianLive++;
//             sessionStorage.setItem("civilianLive", civilianLive);
//         }
//     }
// }

// 这下面都是给天数创建条件
// 给天数添加条件
if (killed.length >= 2 * day) {
    day++;
    sessionStorage.setItem("day", day);
}

//根据天数 创建wrap
for (var w = 0; w < day; w++) {
    if (w > 0) {
        $(".wrap").first().clone().prependTo($("main"));
    }
}

// 给之前的wrap加上背景
for (var y = 0; y < (day - 1) * 4; y++) {
    $(".btn").eq(y).addClass("another");
    $(".trangel").eq(y).addClass("border-another");
    // 前n天的隐藏
    $(".process").eq(y).hide();
}

for (var c = 0; c < killed.length; c++) {
    //死人号数
    var p = killed[c];
    if ((c + 1) % 2 === 0) {
        // console.log(ab);
        // console.log(ab[p]);
        $(".info").eq(c).append(p + "号被投票投死，" + "他的身份是" + ab[p - 1].role);
    } else {
        $(".info").eq(c).append(p + "号被杀手杀死，" + "他的身份是" + ab[p - 1].role);
    }
}

//改变天数，添加切换隐藏
for (var p = 0; p <= day; p++) {
    $(".date").eq(p).html("第" + (p + 1) + "天");
}

// 当天的显示
$(".process").eq(day - 1).show();

// 点击切换导航条
$(".date").click(function () {
    $(this).siblings().toggle();
})