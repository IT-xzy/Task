/**
 * Created by guojianfeng on 2017/10/16.
 */
// 提取玩家人数与顺序
var player = document.cookie.split(";")[0].split("=")[1];
var roles = JSON.parse(player);
console.log(roles);
var h = 1;//记录天数
var x = 0;//用于存放狼人死亡人数
sessionStorage.setItem("x", JSON.stringify(x));
var y = 0;//用于存放村民死亡人数
sessionStorage.setItem("y", JSON.stringify(y));
var death = []; //用于后面存放被杀死的平民
sessionStorage.setItem("death", JSON.stringify(death));
var voted = []; //用于后面存放被投死的玩家
sessionStorage.setItem("voted", JSON.stringify(voted));

var toHome = document.getElementById("back");
var role = [];
for (var i = 0; i < roles.length; i++) {
    var a = i + 1;
    role[i] = "<li class=\"item\">" +
        // "<img class='pic' src=\"../images/ptt.png\">" +
        "<p class=\"play\">" + roles[i] + "</p>" +
        "<p class=\"number\">" + a + "号</p>" + "</li>";
}


$(document).ready(function () {
    $("ul").append(role);
    //
    // $("li").click(function () {
    //     $(this).find(".pic").toggle();
    // });
});
sessionStorage.setItem("h", JSON.stringify(h));
var visited = 0;
sessionStorage.setItem("visited", JSON.stringify(visited));
var f = 0;
sessionStorage.setItem("f", JSON.stringify(f));

$("#btn").click(function () {
    sessionStorage.setItem('play', JSON.stringify(roles));
    window.location.href = "../html/daily.html";
});
// 返回上一页
toHome.onclick = function () {
    window.history.back(-1);
};



