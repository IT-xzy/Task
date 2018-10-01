//获取平民数
var villager = sessionStorage.getItem("villager");
//获取杀手数
var killer = sessionStorage.getItem("killer");
//获取当前天数
var day = +sessionStorage.getItem("day", day);
//获取投死数组
var voteDead = JSON.parse(sessionStorage.getItem("voteDead"));
//获取杀死数组
var killDead = JSON.parse(sessionStorage.getItem("killDead"));
//根据天数克隆相应log框
for (let i = 0; i < day - 1; i++) {
    $("#day1").clone().attr("id", "day" + (i + 2)).appendTo(".text-all");
}
$(function () {
    $(".killer").text(killer);
    $(".villager").text(villager);
    for (let i = 0; i < day; i++) {
        var dayTemp = "#day" + (i + 1);
        $(dayTemp).find(".dayNumber").text(i + 1);
        $(dayTemp).find(".killLog").text(killDead[i]);
        $(dayTemp).find(".voteLog").text(voteDead[i]);
    }
})
//返回主页按钮
$(".hall").click(
    function () {
        sessionStorage.clear();
        location.href = "playerDistribution.html"
    }
)
//再来一次按钮
$("#again").click(
    function () {
        sessionStorage.clear();
        location.href = "playerDistribution.html"
    }
)