"use strict";
var allArray = sessionStorage.getItem("people");

var allNum = sessionStorage.getItem("playerState");
var allNumber = JSON.parse(allNum);

var killse = sessionStorage.getItem("allNum");
var kills = JSON.parse(killse);

//提取标记
var time = sessionStorage.getItem("time");
console.log(time);
var onetime = sessionStorage.getItem("onetime");
console.log("onetime");
console.log(onetime);
//提取状态
var gameother = sessionStorage.getItem("gameother")
console.log("gameother")
console.log(gameother);
if (gameother == "1") {



}

//设置天数变量
var day = 1;
if (onetime >= 2) {
    var day = sessionStorage.getItem("day");


}

//取出天数变量
sessionStorage.setItem("day", day)
console.log(day);

//天数样式
$(".time").text("第" + day + "天")

console.log("day")
console.log(day);
// console.log(allNumber.length)
//显示每天杀人情况
if (gameother == "1") {
    console.log("kills")
    console.log(firstnum)
    var firstnum = kills[0].num;
    var firstid = kills[0].identity;

    $(
        '<p class="hint">' + firstnum + "号被杀死，他的身份是" + firstid + '</p>'
    ).insertBefore("#twostart");

}
if (gameother == "2") {
    console.log("kills")
    console.log(firstnum)
    var firstnum = kills[0].num;
    var firstid = kills[0].identity;

    $(
        '<p class="hint">' + firstnum + "号被杀死，他的身份是" + firstid + '</p>'
    ).insertBefore("#twostart");

}
if (gameother == "3") {
    console.log("kills")
    console.log(firstnum)
    var firstnum = kills[0].num;
    var firstid = kills[0].identity;

    $(
        '<p class="hint">' + firstnum + "号被杀死，他的身份是" + firstid + '</p>'
    ).insertBefore("#twostart");

}

//增加天数html结构
for (let i = 1; i < day; i++) {
    var lastnum1;
    var lastid1;
    var lastnum2;
    var lastid2;

    for (let p = 0; p < allNumber.length; p++) {
        if (allNumber[p].state == "dead" && allNumber[p].how == "sha" && allNumber[p].day == i) {
            lastnum1 = allNumber[p].num;
            lastid1 = allNumber[p].identity;

        }

    }
    for (let p = 0; p < allNumber.length; p++) {
        if (allNumber[p].state == "dead" && allNumber[p].how == "tou" && allNumber[p].day == i) {
            lastnum2 = allNumber[p].num;
            lastid2 = allNumber[p].identity;

        }

    }


    $('<div class="dayafter">' + '<div class="time">' + '第<span>' + i + '</span>' + '天' + '</div>' +
        '<ul>' +
        '<li class="step" id="start">' + '<span class="round">' + '</span>' + '杀手杀人</li>' +
        '<p class="hint">' + lastnum1 + "号被杀死，他的身份是" + lastid1 + '</p>' +
        '<li class="step">' + '<span class="round">' + '</span>' + '亡灵发布言论</li>' +
        '<li class="step">' + '<span class="round">' + '</span>' + '玩家依次发言</li>' +
        '<li class="step">' + '<span class="round">' + '</span>' + '全名投票</li>' +
        '<p class="hint">' + lastnum2 + "号被投死，他的身份是" + lastid2 + '</p>' +


        '</ul>' + '</div>'
    ).insertBefore(".day");



}
// //隐藏页面
$("ul").hide();
// $(".dayafter  p").hide();
$(".day ul").show()
//点击收起点击步骤

$(".time").click(function () {
    var i = $(".time").index(this);
    console.log(i)

    // $(this).css("background","#bbffaa")

    $("ul").eq(i).toggle();
    // $(".hint").toggle();



})


// console.log(killState)
// console.log(kill)
// $("button:eq(0)").click(function () {
//     location.href = "js2-1.html"

// })



console.log(allNumber);
console.table(allNumber);

console.log(kills);

//创建一个有限状态机
var $stage = new StateMachine({
    init: 'ready',
    transitions: [{
            name: 'step1',
            from: 'ready',
            to: 'kill'
        },
        {
            name: 'step2',
            from: 'kill',
            to: 'words'
        },
        {
            name: 'step3',
            from: 'words',
            to: 'speech'
        },
        {
            name: 'step4',
            from: 'speech',
            to: 'vote'
        },
        {
            name: 'reset',
            from: '*',
            to: 'ready'
        }
    ],
    methods: {
        onStep1: function () {
            $(".step").eq(day * 4 - 4).addClass("done");
            $(".round").eq(day * 4 - 4).addClass("do");
        },
        onStep2: function () {
            $(".step").eq(day * 4 - 3).addClass("done");
            $(".round").eq(day * 4 - 3).addClass("do");

        },
        onStep3: function () {
            $(".step").eq(day * 4 - 2).addClass("done");
            $(".round").eq(day * 4 - 2).addClass("do");
        },
        onStep4: function () {
            $(".step").eq(day * 4 - 1).addClass("done");
            $(".round").eq(day * 4 - 1).addClass("do");
        },
        onAfterStep4: function () {
            sessionStorage.removeItem("gameother");
            sessionStorage.removeItem("$stage");
            window.location.reload();
            // 页面自动刷新js
        }
    }
});

var gameother = window.sessionStorage.getItem("gameother");
console.log(gameother)
if (gameother == "1") {
    $stage.step1();
} else if (gameother == "2") {
    $stage.step1();
    $stage.step2();

} else if (gameother == "3") {
    $stage.step1();
    $stage.step2();
    $stage.step3();
} else if (gameother == "4") {
    $stage.step1();
    $stage.step2();
    $stage.step3();
    $stage.step4();
} else {
    $stage.reset();
}

$(".step").eq(day * 4 - 4).click(function () {
    if ($stage.is('ready')) {
        $stage.onStep1();
        alert("杀手杀人");
        sessionStorage.setItem("$stage", "1");
        sessionStorage.getItem("gameother")
        window.location.href = "js2-6.html";


    } else {
        alert("请按照步骤进行游戏");

    }

})


$(".step").eq(day * 4 - 3).click(function () {



    if ($stage.is('kill')) {
        $stage.onStep2();
        $stage.onAfterStep4();

        alert("请亡灵发表遗言");
        sessionStorage.setItem("gameother", "2");
        // sessionStorage.setItem("gameother")
        // window.location.href = "js2-6.html";


    } else {
        alert("请按照步骤进行游戏");

    }


})

$(".step").eq(day * 4 - 2).click(function () {
    if ($stage.is('words')) {
        $stage.onStep3();
        $stage.onAfterStep4();
        alert("请玩家依次发言");
        sessionStorage.setItem("gameother", "3");
        // sessionStorage.getItem("gameother")
        // window.location.href = "js2-6.html";

    } else {
        alert("请按照步骤进行游戏");

    }


})

$(".step").eq(day * 4 - 1).click(function () {
    if ($stage.is('speech')) {
        $stage.onStep4();
        alert("投票杀人");
        sessionStorage.setItem("$stage", "4");
        sessionStorage.getItem("gameother")
        window.location.href = "js2-6.html";

    } else {
        alert("请按照步骤进行游戏");

    }


    // $stage.onStep2();
    // alert("请亡灵发表遗言");
    // sessionStorage.setItem("$stage", "4");
    // sessionStorage.getItem("gameother")
    // window.location.href = "js2-6.html";


})
//返回上一页
$(".left").click(function () {
    window.location.href = "js2-4.html"

})
//进入法官台本
$("button:eq(1)").click(function () {
    location.href = "note.html";
    
})
//重新游戏
$(".right").click(function () {
    // confirm("确定要退出本局游戏么？") ? location.href = "js2-1.html" : x;
    var qd = confirm("确定要退出本局游戏么？")
    if (qd == true) {
        location.href = "js2-1.html"
    }else{
        location.href != "js2-1.html"
        
    }

});


$("button:eq(0)").click(function () {
    // confirm("确定要退出本局游戏么？") ? location.href = "js2-1.html" : x;
    var qd = confirm("确定要退出本局游戏么？")
    if (qd == true) {
        location.href = "js2-1.html"
    }else{
        location.href != "js2-1.html"
        
    }

});
console.log("asssssssssssssssssssssssssd")