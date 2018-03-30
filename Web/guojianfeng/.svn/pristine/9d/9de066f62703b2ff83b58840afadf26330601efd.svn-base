/**
 * Created by guojianfeng on 2017/10/25.
 **/
var m; //声明一个变量用来取数组下标

//接收本地存储数据
var player = window.sessionStorage.getItem("play");
var roles = JSON.parse(player);
var x = window.sessionStorage.getItem("x");
var y = window.sessionStorage.getItem("y");
var h = JSON.parse(sessionStorage.getItem("h")); //记录天数
var w;//设置变量存放被选择玩家的数组下标
var toHome = document.getElementById("back");
var gamePlayer = window.sessionStorage.getItem("gamePlayer");
var voted = JSON.parse(sessionStorage.getItem("voted"));
gamePlayer = JSON.parse(gamePlayer);
console.log(gamePlayer);
var role = [];
x = JSON.parse(x);
y = JSON.parse(y);
var play = document.getElementsByClassName("play");

function aaa() {
    for (var i = 0; i < roles.length; i++) {
        var a = i + 1;
        role[i] = "<li class=\"item\">" +
            "<p class=\"play\">" + roles[i] + "</p>" +
            "<p class=\"number\">" + a + "号</p>" +
            "<div class=\"content\">" + "</div>" + "</li>";
    }
    $("ul").append(role);
    for (var o = 0; o < roles.length; o++) {
        if (gamePlayer[o].life === "death" || gamePlayer[o].life === "voted") {
            play[o].style.backgroundColor = "#000";
        }
    }
}
aaa();

$(".item").click(function () {
    w = $(this).index();//获取玩家在数组的下标
    //限制不能选择已死亡的玩家
    if (gamePlayer[w].life === "death" || gamePlayer[w].life === "voted") {
        alert("他已经死了");
        $("li div").eq(n).hide();//隐藏匕首
        w = null; //用于点击了死亡玩家后清除下标
    }
    else {
        for (var n = 0; n < gamePlayer.length; n++) {
            if (gamePlayer[n].life === "alive") {
                $(".play").eq(n).css("background-color", "#f5c97b");//回复颜色
                $("li div").eq(n).hide();//隐藏匕首
            }
        }
        console.log(w);
        $($(this).find(".play")).css("background-color", "#000");//改变颜色
        $(this).find("div").show();//展示匕首
    }
});
$("#btn").click(function () {
    if (confirm('真的要投票这名玩家吗？')) {
        //alert("确定");
        if (w === null || w === undefined) {
            confirm("请投票后再点确定");
            return false;
        }
        else {
            gamePlayer[w].life = "voted"; //改变被选择玩家的生死状态
            sessionStorage.setItem("gamePlayer", JSON.stringify(gamePlayer));
            window.location.href = "../html/daily.html";
            var visited = 0;
            sessionStorage.setItem("visited", JSON.stringify(visited));
            h++;
            voted.unshift(gamePlayer[w]);
            sessionStorage.setItem("h", JSON.stringify(h));
            sessionStorage.setItem("voted", JSON.stringify(voted));
            if (gamePlayer[w].role === "狼人") {
                x = x + 1;
                sessionStorage.setItem("x", JSON.stringify(x));
            } else {
                y = y + 1;
                sessionStorage.setItem("y", JSON.stringify(y));
            }
        }
    } else {
        //alert("取消");
        return false;
    }
});

// 返回上一页
toHome.onclick = function () {
    window.history.back(-1);
};
