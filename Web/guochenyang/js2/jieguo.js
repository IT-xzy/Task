//上一页面存储数据
var win = window.sessionStorage.getItem("win");
var playerpeople = JSON.parse(window.sessionStorage.getItem("playerpeople"));
var die = JSON.parse(window.sessionStorage.getItem("die"));
var day = JSON.parse(window.sessionStorage.getItem("day"));
var lifeNumber = JSON.parse(window.sessionStorage.getItem("lifeNumber"));
var killerNumber = JSON.parse(window.sessionStorage.getItem("killerNumber"));
$(".picture").text(win);
$(".text").eq(1).text('杀手还有' + killerNumber.length + '人 , 平民还有' + (lifeNumber.length - killerNumber.length) + '人');
console.log(day.length);

for (var i = 2; i < day.length; i++) {
    $(".box1").first().clone().prependTo($('.box'))
}
//修改天数
for (var t = 1; t < day.length; t++) {
    $(".day").eq(t - 1).html("第" + t + "天");
}

if (die.length !== 0) {
    for (var s = 0; s < die.length; s++) {
        var b = die[s];
        if ((s + 1) % 2 === 0) {
            $(".note").eq(s).html("白天:" + b + "号被大家投死，他的身份是"+playerpeople[b-1].name);
        } else {
            $(".note").eq(s).html("晚上:" + b + "号被杀手杀死，他的身份是"+playerpeople[b-1].name);
        }
    }
}


function again() {
    var c = confirm("是否再来一局？")
    if (c == true) {
        sessionStorage.clear();
        window.location.href = "zhuoyou.html";
    }
}