//获取玩家数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
console.log(playersArray);
//获取玩家数量
var players = sessionStorage.getItem("players");
//提取存活的平民
var civilian = sessionStorage.getItem("civilian");
console.log(civilian);
//选择的玩家
var choosePlayer;
//获取克隆的节点
var sourceNode = document.getElementById('players1');
//提取死掉的玩家号码数组
if (sessionStorage.getItem("dieNumber")) {
    var dieNumber = JSON.parse(sessionStorage.getItem("dieNumber"));
} else {
    var dieNumber = [];
}    
console.log(dieNumber);
//提取死亡数组
if (sessionStorage.getItem("killDead")) {
    var killDead = JSON.parse(sessionStorage.getItem("killDead"));
} else {
    var killDead = [];
}
window.onload = function () {
    //console.log(sourceNode);
    //获取玩家名字节点
    var name = document.getElementsByClassName("name");
    //获取玩家数字节点
    var number = document.getElementsByClassName('number');
    var a = 0;
    var q = document.getElementsByClassName("player"); //获取游戏盒子节点
    // console.log(playersArray.length);
    for (let i = 2; i < playersArray.length + 1; i++) {
        var cloneNode = sourceNode.cloneNode(true);
        cloneNode.setAttribute("id", "players" + i); // 修改一下id 值，避免id 重复 
        sourceNode.parentNode.appendChild(cloneNode);
    }
    for (let i = 0; i < playersArray.length; i++) {
        if (playersArray[a] == 0) {
            name[i].innerHTML = "平民";
            a++;
        } else if (playersArray[a] == 1) { //判断杀手修改玩家名字
            name[i].innerHTML = "杀手";
            a++;
        }
        number[i].innerHTML = i + 1 + "号"; //修改玩家号码
        q[i].index = i; //这里index相当于形参
        q[i].onclick = function () { //玩家盒子点击事件
            for (let i = 0; i < q.length; i++) {
                q[i].getElementsByTagName("i")[0].style.display = "none"; //每次点击时所有的匕首隐藏
            }
            choosePlayer = q[i].index; //获取被选择的玩家
            console.log(choosePlayer);
            q[i].getElementsByTagName("i")[0].style.display = "inline-block"; //被点击的盒子显示匕首
            // console.log(q[i]);
        }
    }
    for (var i = 0; i < dieNumber.length; i++) {
        name[dieNumber[i] - 1].style.background = "red";
    }
    //获取确定按钮的节点
    var button = document.getElementsByTagName("button")[0];
    button.onclick = function () {
        if (choosePlayer == undefined) {
            alert("请选择要杀死的平民");
        }else if(name[choosePlayer].style.background == "red"){
            alert("不能杀已死亡的玩家");
        } else if (playersArray[choosePlayer] == 1) {
            alert("杀手不能杀死自己");
        } else {
            // //被杀死的平民定义死亡
            // playerLife[choosePlayer] = "死亡";
            //存储存活平民的数量
            civilian = civilian - 1;
            sessionStorage.setItem("civilian", civilian);
            //存储被杀死的平民信息
            var temp = (choosePlayer + 1) + "号被杀死,真实身份是平民";
            killDead.push(temp);
            sessionStorage.setItem("killDead", JSON.stringify(killDead));
            //存储被杀的平民号码
            dieNumber.push(choosePlayer + 1);
            sessionStorage.setItem("dieNumber", JSON.stringify(dieNumber));
            //记录步骤数
            var step = 1;
            sessionStorage.setItem("step", step);
            //跳转法官台本
            location.href = ('version.html');
        }
    }
}
var close = document.getElementsByTagName("div")[0];
close.onclick = function () {
    if (confirm("确定退出游戏么？")) {
        sessionStorage.clear();
        location.href = ("homepage.html");
    }
}