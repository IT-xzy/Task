var numBtn = document.getElementById("num"),
    killerNum = document.getElementById("killerNum"),
    civilianNum = document.getElementById("civilianNum"),
    rangeBtn = document.getElementById("range"),
    setBtn = document.getElementById("set"),
    subBtn = document.getElementById("sub"),
    addBtn = document.getElementById("add"),
    dealBtn = document.getElementById("deal"),
    backBtn = document.getElementById("back");
// 设置玩家人数
numBtn.onblur = function () {
    if (numBtn.value >= 4 && numBtn.value <= 18) {
        rangeBtn.value = numBtn.value;  // 手动输入玩家数量会同时改变滑块到相应位置
    } else {
        alert("游戏限制人数为4~18人");
        rangeBtn.value = 4;      // 当输入的玩家数量超出范围时，重置玩家数量
        numBtn.value = 4;
    }
}
// 滑块改变玩家人数
rangeBtn.oninput = rangeBtn.onchange = function () {  // 为了兼容IE浏览器
    numBtn.value = rangeBtn.value;  // 拖动滑块后玩家数量会跟着变
}
// 点击设置分配玩家人数
setBtn.onclick = function () {
    var value = parseInt(numBtn.value);
    // 把分配杀手和平民人数的方法进行封装
    function playerNumFun(killer) {
        killerNum.value = killer;
        civilianNum.value = rangeBtn.value - killer;
        killerNum.innerHTML = killer;
        civilianNum.innerHTML = civilianNum.value;
    }
    if (value <= 5) {
        playerNumFun(1);
    } else if (value >= 6 && value <= 8) {
        playerNumFun(2);
    } else if (value >= 9 && value <= 11) {
        playerNumFun(3);
    } else if (value >= 12 && value <= 15) {
        playerNumFun(4);
    } else if (value >= 16 && value <= 18) {
        playerNumFun(5);
    }
    sessionStorage.setItem("killerNum",killerNum.value);  // 保存杀手人数在killerNum中
    sessionStorage.setItem("civilianNum",civilianNum.value); // 保存平民人数在civilianNum中
}
// 点击减号
subBtn.onclick = function () {
    numBtn.value--;
    rangeBtn.value = numBtn.value;
    if (numBtn.value < 4) {
        alert("人数最少为4人");
        numBtn.value = 4;
    }
}
// 点击加号
addBtn.onclick = function () {
    numBtn.value++;
    rangeBtn.value = numBtn.value;
    if (numBtn.value > 18) {
        alert("人数最多为18人");
        numBtn.value = 18;
    }
}
// 点击发牌跳转
dealBtn.onclick = function () {
    var player = killerNum.value + civilianNum.value;
    if (killerNum.innerHTML == 0) { // 如果没有设置游戏人数则弹出提示
        alert("请设置玩家人数后再开始游戏")
    } else if (numBtn.value != player) {  // 点击设置人数后，如果再修改人数并且不点设置则会弹出提示
        alert("请设置正确的玩家人数后再开始游戏")
    } else {
        location.href="task2-3.html";
    }
}
backBtn.onclick = function () {
    var x = confirm("确定要返回首页吗?");
    if (x === true) {
        location.href="task2-1.html";
    }
}





