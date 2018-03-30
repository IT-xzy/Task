/**
 * Created by guojianfeng on 2017/10/30.
 */
var killerNum = parseInt(JSON.parse(sessionStorage.getItem("killerNum")));
var personNum = parseInt(JSON.parse(sessionStorage.getItem("personNum")));
var voted = JSON.parse(sessionStorage.getItem("voted"));
var death = JSON.parse(sessionStorage.getItem("death"));
var win = document.getElementById("winner");
var killer = document.getElementById("killer");
var people = document.getElementById("people");
var winner = JSON.parse(sessionStorage.getItem("winner"));
var h = JSON.parse(sessionStorage.getItem("h")); //记录天数
var good = document.getElementById("good");
//反转数组
voted.reverse();
death.reverse();
console.log(voted);
console.log(death);

victory();
playerNum();

function victory() {
    if (winner === "狼人") {
        win.innerHTML = "狼人胜利";
        good.innerHTML = "太棒了！你知道么？在杀人游戏中只有20%的" + winner + "取得游戏最终的胜利哦！";
    } else if (winner === "村民") {
        win.innerHTML = "村民胜利";
        good.innerHTML = "太棒了！你知道么？在杀人游戏中只有20%的" + winner + "取得游戏最终的胜利哦！";
    }
}

function playerNum() {
    killer.innerHTML = "狼&emsp;人" + killerNum + "人";
    people.innerHTML = "村&emsp;民" + personNum + "人";
}


$(document).ready(function() {
    for(var i = 0; i < death.length; i++) {
        var n = "<div class=\"list\"><p class=\"data\">第1天</p>"
            + "<p class=\"letter\"></p>"
            + "<p class=\"fate\"></p></div>";
        $("#event").append(n);
        var a = $(".data");
        $(a[i]).text("第" + (i + 1) + "天");
    }
    for(var j = 0; j < death.length; j++) {
        var b = $(".letter");
        $(b[j]).text("晚上：" + death[j].number + "号被杀手杀死，" + death[j].number + "号是" + death[j].role);
    }
    for(var k = 0; k < voted.length; k++) {
        var m = $(".fate");
        $(m[k]).text("白天：" + voted[k].number + "号被全民投死，" + voted[k].number + "号是" + voted[k].role);
    }
});

