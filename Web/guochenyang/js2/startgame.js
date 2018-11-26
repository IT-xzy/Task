// //上一页玩家人数
// var Num = sessionStorage.getItem("Num");
//上一页身份数组
var playerpeople = JSON.parse(sessionStorage.getItem("playerpeople"));
//判断点击的数组
if (JSON.parse(window.sessionStorage.getItem("click"))) {
    x = JSON.parse(window.sessionStorage.getItem("click"));
} else {
    //创建一个空数组
    x = new Array();
}
//返回
function Back(){
    var a = confirm("退回到上一页？");
    if(a == true){
        sessionStorage.clear();
        window.location.href = "task-2.html";
    }
}
//结束游戏
function Off(){
    var b = confirm("是否结束本轮游戏？");
    if (b == true) {
        sessionStorage.clear();
        window.location.href = "zhuoyou.html";
    }
}
//获取天数
if (JSON.parse(window.sessionStorage.getItem("day"))) {
    day = JSON.parse(window.sessionStorage.getItem("day"));
} else {
    //创建一个数组,并让长度为1
    day = [0];
}
//修改天数
for (var z = 1; z <= day.length; z++) {
        $(".day").html("第" + day.length + "天");
}
console.log(day);
//判断背景色
if (JSON.parse(window.sessionStorage.getItem("bgColor"))) {
    bgColor = JSON.parse(window.sessionStorage.getItem("bgColor"));
} else {
    //创建一个空数组
    bgColor = new Array();
}
//死亡人数
if (JSON.parse(window.sessionStorage.getItem("die"))) {
    die = JSON.parse(window.sessionStorage.getItem("die"));
} else {
    //创建一个空数组
    die = new Array();
}
console.log(die);

// 根据是否完成投票来决定按钮的显示色

if (die.length % 2 == 0) {
    console.log('投票完成')
} else {
    $(".day-triangle").eq(0).css("border-right-color", "#c9c9c9");
    $(".day-btn").eq(0).css("background-color", "#c9c9c9");
    console.log('杀手杀人完成')
}
//每次点击必做操作
function Button() {
    //点击次数
    x.push(0);
    //背景色
    bgColor.push(0);
}
function Storage() {
    sessionStorage.setItem("die", JSON.stringify(die));
    sessionStorage.setItem("playerpeople", JSON.stringify(playerpeople));
    sessionStorage.setItem("click", JSON.stringify(x));
    sessionStorage.setItem("bgColor", JSON.stringify(bgColor));
    // sessionStorage.setItem("activation", JSON.stringify(activation));
}
//杀手杀人
$(".day-btn").eq(0).click(function () {
    if (x.length == 0) {
        $(".day-triangle").eq(x.length).css("border-right-color", "#c9c9c9");
        $(".day-btn").eq(x.length).css("background-color", "#c9c9c9");
        alert("杀手杀人！");
        Button();
        Storage();
        window.location.href = "killernote.html";
    } else {
        alert("请按顺序来!");
    }
});
console.log(x.length);
//亡者遗言
$(".day-btn").eq(1).click(function () {
    if (x.length == 1) {
        $(".day-triangle").eq(x.length).css("border-right-color", "#c9c9c9");
        $(".day-btn").eq(x.length).css("background-color", "#c9c9c9");
        alert("亡者遗言！");
        Button();
        Storage();
    } else {
        alert("请按顺序来!");
    }
});
//玩家发言
$(".day-btn").eq(2).click(function () {
    if (x.length == 2) {
        $(".day-triangle").eq(x.length).css("border-right-color", "#c9c9c9");
        $(".day-btn").eq(x.length).css("background-color", "#c9c9c9");
        alert("玩家发言！");
        Button();
        Storage();
    } else {
        alert("请按顺序来!");
    }
});
//投票
$(".day-btn").eq(3).click(function () {
    if (x.length == 3) {
        $(".day-triangle").eq(x.length).css("border-right-color", "#24a7c6");
        $(".day-btn").eq(x.length).css("background-color", "#24a7c6");
        alert("投票！");
        Button();
        Storage();
        sessionStorage.setItem("day", JSON.stringify(day));
        window.location.href = "killernote.html";
    } else {
        alert("请按顺序来!");
    }
});
//日记页面选择
if (JSON.parse(window.sessionStorage.getItem("note"))) {
    note = JSON.parse(window.sessionStorage.getItem("note"));
} else {
    //创建一个空数组
    note = new Array();
    sessionStorage.setItem("note", JSON.stringify(note));
}
//查看日志
$("#gamenote").click(function () {
    Storage();
    note.push(0);
    sessionStorage.setItem("note", JSON.stringify(note));
    window.location.href = "killernote.html";
})