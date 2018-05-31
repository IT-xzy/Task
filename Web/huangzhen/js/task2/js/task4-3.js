"use strict"
var ab = JSON.parse(sessionStorage.getItem("ab"));
var win = sessionStorage.getItem("win");
var killernum = sessionStorage.getItem("killerLive");
var civiliannum = sessionStorage.getItem("civilianLive");

$(".win").text(win);
$(".word").text("太棒了!你知道么？在捉鬼游戏中,只有20%的" + win.substring(0, 2) + "取得游戏最终的胜利哦！");
$(".killernum").text("杀手还剩" + killernum + "人");
$(".civiliannum").text("平民还剩" + civiliannum + "人");



var killed = JSON.parse(sessionStorage.getItem("killed")); //取死亡名单
if (killed == undefined) {
    killed = [];
}

var day = sessionStorage.getItem("day");
for (var w = 0; w < day; w++) {
    if (w > 0) {
        $(".white").first().clone().appendTo($("section"));
    }
}

for (var p = 0; p <= day; p++) {
    $(".date").eq(p).html("第" + (p + 1) + "天");
}


for (var c = 0; c < killed.length; c++) {
    //死人号数
    var p = killed[c];
    if ((c + 1) % 2 === 0) {
        // console.log(ab);
        // console.log(ab[p]);
        $(".infos").eq(c).text(p + "号被投票投死，" + "他的身份是" + ab[p - 1].role);
    } else {
        $(".infos").eq(c).text(p + "号被杀手杀死，" + "他的身份是" + ab[p - 1].role);
    }
}

$(".footer-left").click(function () {
    window.location.href = 'task2-1.html';
})