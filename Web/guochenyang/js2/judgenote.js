// //上一页玩家人数
var Num = sessionStorage.getItem("Num");
//上一页身份数组
var playerpeople = JSON.parse(sessionStorage.getItem("playerpeople"));
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
for (var i = 0; i < playerpeople.length; i++) {
    //创建div
    $("main").append('<div class="cont1"></div>');
    //给div添加身份p标签
    $(".cont1").eq(i).append('<p class="text1"></p>');
    //给身份p标签添加内容
    $(".text1").eq(i).html(playerpeople[i]);
    //给div添加玩家号数p标签
    $(".cont1").eq(i).append('<p class="text2"></p>');
    //给玩家号数p标签添加对应数字
    $(".text2").eq(i).html((i + 1) + "号");
}
//跳转至游戏页面
function Start() {
    var y = [];
    for (var x = 0; x < Num; x++) {
        if (playerpeople[x] == "平民") {
            y.push({ name: "平民", death: true })
        } else {
            y.push({ name: "杀手", death: true })
        }
    }
    sessionStorage.playerpeople=JSON.stringify(y);
    window.location.href = "startgame.html"
}
