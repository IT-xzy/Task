//提取数据
var civilian = +sessionStorage.getItem("civilian"); //平民
var killer = +sessionStorage.getItem("killer"); //杀手
var days = sessionStorage.getItem("days"); //天数
var killDead = JSON.parse(sessionStorage.getItem("killDead")); //杀死数组
var voteDead = JSON.parse(sessionStorage.getItem("voteDead")); //投死数组
var daysArray = JSON.parse(sessionStorage.getItem("daysArray")); //天数数组
console.log(daysArray)
console.log(killDead)
console.log(voteDead)
console.log(civilian)
console.log(killer)
console.log(days)
//获取节点
var day = document.getElementsByClassName("day");
var sourceNode = document.getElementsByTagName("ul");
var sha = document.getElementsByClassName("sha");
var tou = document.getElementsByClassName("tou");
var picture = document.getElementsByClassName("picture")[0];
document.getElementsByTagName("p")[0].innerHTML = "剩余玩家:" + (killer + civilian);
document.getElementsByTagName("span")[0].innerHTML = "杀手" + killer + "人";
document.getElementsByTagName("span")[1].innerHTML = "平民" + civilian + "人";
for (let i = 1; i < days; i++) {
    var cloneNode = sourceNode[0].cloneNode(true); //克隆源节点
    sourceNode[0].parentNode.appendChild(cloneNode); //排列
}
if (killer >= civilian) {
    picture.style.background = "url(../img/nannongmin.png)";
}
for (let i = 0; i < days; i++) {
    day[i].innerHTML = daysArray[i + 1];
    if (killDead[i] == undefined) {
        sha[i].innerHTML = "黑夜：";
    } else {
        sha[i].innerHTML = "黑夜：" + killDead[i];
    }
    if (voteDead[i] == undefined) {
        tou[i].innerHTML = "白天：";
    } else {
        tou[i].innerHTML = "白天 : " + voteDead[i];
    }
    console.log(killDead[i])
    console.log(voteDead[i])
}
//再来一局
var go = document.getElementsByTagName("button")[0];
go.onclick = function () {
    sessionStorage.clear();
    location.href = ("player.html");
}