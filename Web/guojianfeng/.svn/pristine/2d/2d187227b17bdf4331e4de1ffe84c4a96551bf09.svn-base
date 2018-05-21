/**
 * Created by guojianfeng on 2017/10/16.
 */
var btn = document.getElementById("btn");
var number = document.getElementById("number");
var show1 = document.getElementById("show1");
var show2 = document.getElementById("show2");
var role = document.getElementById("role");
var toHome = document.getElementById("back");
var close=document.getElementById('close');
var i = 1;
var z = 1; //使用这个数据为后面进行余数是否为1的判断
// 提取玩家人数与顺序
var player = document.cookie.split(";")[0].split("=")[1];
var roles = JSON.parse(player);
console.log(roles);

btn.onclick = function () {
    if (i <= 2 * roles.length - 2) {
        if (i % 2 === 1) {
            number.innerHTML = z;
            show1.style.display = "none";
            show2.style.display = "block";
            role.innerHTML = roles[z - 1];
            btn.innerHTML = ("隐藏并传递给" + (z + 1) + "号");
        }
        else if (i % 2 === 0) {
            number.innerHTML = z + 1;
            show1.style.display = "block";
            show2.style.display = "none";
            btn.innerHTML = ("查看" + (z + 1) + "身份");
            z++;
        }
    } else if (i === 2 * roles.length - 1) {
        number.innerHTML = z;
        show1.style.display = "none";
        show2.style.display = "block";
        role.innerHTML = roles[z - 1];
        btn.innerHTML = ("法官查看");
    } else if (i === 2 * roles.length) {
        window.location.href = "../html/judge.html"
    }
    i++;
};

toHome.onclick = function () {
    window.history.back(-1);
};

close.onclick=function (){
    if
    (confirm("您确定要退出游戏吗？")){
        window.opener=null;
        window.open('','_self');
        window.location.href = "../html/home-page.html";
    }
    else{}
};
