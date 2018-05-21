
allPeople = JSON.parse(localStorage.getItem('allPeople'));
arr = JSON.parse(localStorage.getItem('arr'));
var arrD = [];
arrD.push(-1);
localStorage.setItem('arrD', JSON.stringify(arrD)); //传递 n 号
//播放控件
function play() {
    var audio = document.getElementById('music');
    if (audio.paused) {
        audio.play(); //audio.play();// 音乐播放
    } else {
        audio.pause(); // 暂停
    }
};

var oC = 1;

function tianji() {
    var oDiv1 = document.getElementById("TT");   //获取
    var oDiv2 = document.createElement("div");  //创建 div标签             
    oDiv2.className = "player";                 //赋值class
    var oDiv3 = document.createElement("div");  //创建 div标签
    oDiv3.className = "play";                       //赋值class
    var oP1 = document.createElement("p");      //创建 p标签
    oP1.innerText = allPeople[arr[oC - 1]];             //输入玩家角色
    oP1.id = "text";
    var oP2 = document.createElement("p");        //创建 p标签
    oP2.innerText = " " + oC + "号";
    var oImg = document.createElement("div");                //输入玩家编号
    oDiv1.appendChild(oDiv2);
    oDiv2.appendChild(oDiv3);
    oDiv2.appendChild(oImg);
    oDiv3.appendChild(oP1);              //各种div p嵌套
    oDiv3.appendChild(oP2);

}
var oC = 1;
while (oC < arr.length + 1) {
    tianji();                           //循环生成多个
    oC++;
}
var arrZ = [];
arrZ.push(1); //确定 n 号
localStorage.setItem('arrZ', JSON.stringify(arrZ));
var arrX = [];
localStorage.setItem('arrX', JSON.stringify(arrX));
var arrV = [];
localStorage.setItem('arrV', JSON.stringify(arrV));
var arrKill1 = [];
localStorage.setItem('arrKill1', JSON.stringify(arrKill1));
var arrKill2 = [];
localStorage.setItem('arrKill2', JSON.stringify(arrKill2));

