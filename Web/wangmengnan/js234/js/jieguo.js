function fhkill() {
    window.location.assign('./kill.html');
}
arrEz = JSON.parse(localStorage.getItem('arrEz'));
arrX = JSON.parse(localStorage.getItem('arrX'));
arrKill1 = JSON.parse(localStorage.getItem('arrKill1'));
arrKill2 = JSON.parse(localStorage.getItem('arrKill2'));

var zh = [ "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二", "十三"];
var oC = 0;

function tianji() {
    var oDiv1 = document.getElementById("content"); //获取
    var oDiv2 = document.createElement("div"); //创建 div标签             
    oDiv2.className = "process"; //赋值class
    var oDiv3 = document.createElement("div");
    oDiv3.className = "process1";
    var oP1 = document.createElement("p"); //创建 p标签
    oP1.innerText = "第"+ zh[oC] +"天"; //输入玩家角色
    var oP2 = document.createElement("p"); //创建 p标签
    oP2.innerText = "0小时07分";
    oP2.className = "timed"
    // var oP3 = document.createElement("p"); //创建 p标签
    // oP3.innerText = "晚上：" + arrX[oC] + "号被杀手杀死，" + "真实身份是平民";
    // var oP4 = document.createElement("p"); //创建 p标签
    // oP4.innerText = "白天：" + arrX[oC+1] + "号被全民投票投死，" + "真实身份是" + arrEz[arrX[oC]- 1];
    oDiv1.appendChild(oDiv2);
    oDiv2.appendChild(oDiv3);
    oDiv3.appendChild(oP1);
    oDiv3.appendChild(oP2);
    // oDiv3.appendChild(oP3); //各种div p嵌套
    // oDiv3.appendChild(oP4);

}
var oC = 0;

while (oC < arrKill1.length) {
    tianji(); //循环生成多个
    oC++;
}
arrV = JSON.parse(localStorage.getItem('arrV'));
$(".victory p").text(arrV);

function yanshi() {
    function dayone2() {
        var oDiv7 = document.getElementsByClassName("process1")
        var oP7 = document.createElement("p");
        oP7.className = "night";
        oP7.innerHTML = arrKill2[oG];
        oDiv7[oG].appendChild(oP7);
    }

    function dayone() {
        var oDiv7 = document.getElementsByClassName("process1");
        var oP6 = document.createElement("p");
        oP6.className = "daytime";
        oP6.innerHTML = arrKill1[oV];
        oDiv7[oV].appendChild(oP6);
    }
    var oV = 0;
    while (oV < arrKill1.length) {
        dayone();  
        oV++;
    }
    var oG = 0;
    while (oG < arrKill2.length) {
        dayone2();   
        oG++;
    }
}
setTimeout("yanshi()", 20);

