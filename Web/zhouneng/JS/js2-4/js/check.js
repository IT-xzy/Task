// 获取发牌时保存的数据
var data = JSON.parse(localStorage.getItem('key'));

var backtrack=document.getElementById("backtrack");
// 返回按钮返回到发牌页面
backtrack.onclick=function() {
    location.href = "../html/Player.html";
} 

var off=document.getElementById("off");
// 关闭按钮返回到主页面
off.onclick=function(){
    // 点击关闭弹出提示窗口
    if (confirm("是否要退出游戏返回到主页面")) {
        location.href = "../html/start.html"; //点击确定返回到主页面
    } else {
        return false; //点击取消停留在当前页面
    }
}

// 获取背面图片dom节点
var verso = document.getElementById("verso");
// 获取正面图片角色盒子dom节点
var front = document.getElementsByClassName("circle-box")[0];
// 获取角色描述dom节点
var player = document.getElementById("player");
// 获取玩家数量dom节点
var count = document.getElementById("count");
// 获取button按钮dom节点
var check = document.getElementsByTagName("button")[0];

var arr = []; //声明一个空数组
var arr = data; //把获取到本地的数据传到数组里

var i = 0;
var m = 2;

check.onclick=function() {
    if (i >= arr.length-0.5) {
        // 大于等于数组长度进入下一个页面
        location.href = "../html/diary.html";
        return;
    }

    if (i % 1 == 0) {
        //隐藏反面图片
        verso.style.display = "none";
        //显示正面图片和玩家描述盒子
        front.style.display = "inline-block";
        // 修改button的内容
        check.innerText = ("隐藏并传递" + m + "号");
        // 获取数组内容
        player.innerText = (arr[i]);
        i = i + 0.5;
        m = m + 1;
        // console.log(arr)
        // console.log(player)
        // console.log(check)
        // console.log(i)
    } else if (i != 0) {
        var number = m - 1;
        // 显示反面图片
        verso.style.display = "inline-block";
        // 隐藏正面图片和玩家描述盒子
        front.style.display = "none";
        // 修改button内容
        check.innerText = ("查看" + number + "号身份");
        // 修改玩家数量值
        count.innerText = m - 1;
        i = i + 0.5;
        // console.log(i)
    }

    if (m > arr.length + 1) {
        // 大于数组长度修改button按钮值
        check.innerText = ("法官查看");
    }
}