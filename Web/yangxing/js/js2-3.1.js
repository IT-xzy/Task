

//实现加减按钮与滑动条的联动
document.getElementById("add").onclick = function () {
    document.getElementById("nn").value = (document.getElementById("nn").value) * 1 + 1;
    document.getElementById("overall").value = (document.getElementById("overall").value) * 1 + 1;
    overall();
};

document.getElementById("sub").onclick = function () {
    document.getElementById("nn").value = (document.getElementById("nn").value) * 1 - 1;
    document.getElementById("overall").value = (document.getElementById("overall").value) * 1 - 1;
    overall();
};

var flag = true;

function setVal() {
    document.getElementById("overall").value = document.getElementById('nn').value;
    overall();
}


//实现点击设置 出现与消失的效果
function hum() {
    var div = document.getElementById("hum-1");
    if (flag) {
        div.style.display = "block";
    } else {
        div.style.display = "none";
    }
    flag = !flag;
}

// 输入人数，自动分配好平民人数和杀手人数
var killer = [];
var people = [];

function overall() {
    var overall = document.getElementById("overall").value;
    killer = Math.floor(overall / 4);
    people = overall - killer;
    console.log(killer);

    //检测人数如果在4-18那么输入数字就会自动出现设置框
    if (overall >= 4 && overall <= 18) {
        document.getElementById("hum-1").style.display = "block";
    } else {
        document.getElementById("hum-1").style.display = "none";
    }
    document.getElementById("people").value = people;
    document.getElementById("killer").value = killer;
    document.getElementById("overall").value = overall;

}

//判断是不是输入在4-18之内的数字，是就跳转下一页，不是就提示错误
var txt = "";

function uuu() {
    var x;
    x = document.getElementById("overall").value;
    if (isNaN(x) || x < 4 || x > 18) {
        txt = "请输入4-18的数字" + "\n\n";
        alert(txt);

    } else if (killer.length !== 0) {
        sessionStorage.setItem("player", people);
        sessionStorage.setItem("killernum", killer);
        window.location.href = "查看身份.html";
    }

    else {
        alert("请输入正确的数字")

    }
}


$(document).ready(function () {
    //点击退后三角跳转前一个页面
    $('.topleft').click(function () {
        window.location.href='捉鬼游戏.html';
    });

    //跳转帮助页面
    $('.topright').click(function () {
        window.location.href='帮助.html';
    });

});






















