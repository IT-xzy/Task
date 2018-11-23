// 获取发牌时保存的数据
var data = JSON.parse(localStorage.getItem('key'));

var backhome = document.getElementById("backhome");
// 返回按钮返回到发牌页面
backhome.onclick = function () {
    location.href = "../html/js2-2.html";
}

var off = document.getElementById("off");
// 关闭按钮返回到主页面
off.onclick = function () {
    // 点击关闭弹出提示窗口
    if (confirm("是否要退出游戏返回到主页面")) {
        location.href = "../html/js2-1.html"; //点击确定返回到主页面
    } else {
        return false; //点击取消停留在当前页面
    }
}


// 获取玩家数量dom节点
var count = document.getElementById("count");
// 获取背面图片dom节点
var verso = document.getElementById("verso");
// 获取正面图片角色盒子dom节点
var front = document.getElementById("circle-box");
// 获取角色描述dom节点
var player = document.getElementById("player");
// 获取button按钮dom节点
var check = document.getElementsByTagName("button")[0];

var arr = data; //把获取到本地的数据传到数组里
console.log(arr)

var i = 0;
var n = 2;
var m = 0;
check.onclick = function () {
    if (m == arr.length) {// 等于数组长度跳转
        location.href = "../html/js3-1.html";
        return
    }
console.log(i,n,m)
    if (i == 0) {
        //隐藏反面图片
        verso.style.display = "none";
        //显示正面图片和玩家描述盒子
        front.style.display = "block";
        player.style.display = "block";
        // 获取数组内容
        player.innerText = (arr[m]);
        console.log(player)
        // 修改button的内容
        check.innerText = ("隐藏并传递" + n + "号");
        i = i + 1;
        m = m + 1;
        console.log(i,n,m)
    } else {
        // 隐藏正面图片和玩家描述盒子
        front.style.display = "none";
        player.style.display = "none";
         // 显示反面图片
         verso.style.display = "block";
         // 修改顶部玩家数值
        count.innerText = n ;
        // 修改button内容
        check.innerText = ("查看" + n + "号身份");
        i = i - 1;
        n = n + 1;
        console.log(i,n,m)
    }

    if (m == arr.length ) {
        // 等于数组长度修改button按钮值
        check.innerText = ("法官查看");
    }

    
}