// 获取dom
var inputNum = document.getElementById("players");
var rangeNum = document.getElementById("slider");
var words1 = document.getElementById("words1");
var words2 = document.getElementById("words2");
// 获取词汇
function matchWords() {
    gameWords = [words1.value, words2.value];
    if (words1.value != "" && words2.value != "") {
        words1.value = words1.value;
        words2.value = words2.value;
        console.log(gameWords);
    }
    return gameWords;
}
// 返回首页
function backFirst() {
    window.location.href = "./task2首页.html";
}
// 输入框与滑块匹配
function matchNum() {
    if (inputNum.value >= 4 && inputNum.value <= 18) {
        rangeNum.value = inputNum.value;
        setPlayNum();
    } else {
        alert("请输入正确值");
        inputNum.value = 4;
        rangeNum.value = 4;
    }
}
// 滑块匹配输入框
function sliderChange() {
    inputNum.value = rangeNum.value;
    setPlayNum();
}

function reduceNum() {
    rangeNum.value--;
    if (inputNum.value < 4) {
        rangeNum.value = 4;
    } else {
        inputNum.value = rangeNum.value;
        setPlayNum();
    }
}

function increaseNum() {
    rangeNum.value++;
    if (inputNum.value > 18) {
        rangeNum.value = 18;
    } else {
        inputNum.value = rangeNum.value;
        setPlayNum();
    }
}
// 身份乱序
var wolvesKill = [];

function shuffle(arr) {
    var killer = Math.floor(inputNum.value / 3);
    var farmer = inputNum.value - killer;

    // 创建数组
    for (var i = killer; i < inputNum.value; i++) {
        wolvesKill[i] = "平民";
    }
    for (var j = 0; j < killer; j++) {
        wolvesKill[j] = "杀手";
    }
    // 洗牌算法，核心就是取出的元素（随着随机数变化）和当前元素(随着循环变化)的位置互换
    for (var k = inputNum.value; k--; k >= 0) {
        var f = Math.floor(Math.random() * (k + 1));
        var Order_player = wolvesKill[f];
        wolvesKill[f] = wolvesKill[k];
        wolvesKill[k] = Order_player;
    }
    console.log(wolvesKill);
    // 此时身份已经排序完毕
    return wolvesKill;
}
// 运行顺利
// 分配身份
function setPlayNum() {
    var ul = document.getElementById("role-list");
    var identity = shuffle(wolvesKill);
    // 清空所有子元素
    while (ul.hasChildNodes()) {
        ul.removeChild(ul.firstChild);
    }
    // var farmer = document.createElement('li');
    // var farmerNum = inputNum.value - Math.floor(inputNum.value/3);
    //     farmer.innerHTML +='<span class="list-item-style"></span>'+"杀手"+ Math.floor(inputNum.value/3) + "人"
    //     farmer.style.cssText += "float:left;margin:.1rem 0;width:50%;text-align:left;color:#bfbfbf;";
    //     ul.appendChild(farmer);
    // var killer = document.createElement('li');
    //     killer.innerHTML +='<span class="list-item-style"></span>'+"平民"+ farmerNum + "人"
    //     killer.style.cssText += "float:left;margin:.1rem 0;width:50%;text-align:left;color:#bfbfbf;";
    //     ul.appendChild(killer);
    for (i = 0; i < inputNum.value; i++) {
        var li = document.createElement("li");
        li.innerHTML +=
            '<span class="list-item-style" id=i></span>' +
            identity[i] +
            (i + 1) +
            "号";
        li.style.cssText += "width:50%;float:left;text-align:left;color:#bfbfbf;";
        ul.appendChild(li);
    }
}
// 运行成功
function sendingCard() {
    if (
        wolvesKill.length !== 0 &&
        wolvesKill.length == inputNum.value &&
        words1.value != "" &&
        words2.value != ""
    ) {
        // sessionStorage.setItem("key", "value");
        sessionStorage.setItem("playerIdentify", JSON.stringify(wolvesKill));
        sessionStorage.setItem("playerNums", inputNum.value);
        sessionStorage.setItem("gameWords1", JSON.stringify(gameWords));
        window.location.href = "./翻牌页面.html";
    } else if (wolvesKill.length !== 0 && wolvesKill.length == inputNum.value && words1.value == "" && words2.value == "") {
        alert("请设置词汇");
    } else if (wolvesKill.length !== 0 && wolvesKill.length == inputNum.value && words1.value == "" && words2.value != "") {
        alert("请设置平民词汇");
    } else if (wolvesKill.length !== 0 && wolvesKill.length == inputNum.value && words1.value != "" && words2.value == "") {
        alert("请设置卧底词汇");
    } else if (wolvesKill.length !== 0 && wolvesKill.length != inputNum.value && words1.value != "" && words2.value != "") {
        alert("请重新分配玩家身份");
    } else if (wolvesKill.length == 0 && wolvesKill.length == inputNum.value && words1.value != "" && words2.value != "") {
        alert("请输入玩家数量");
    } else {
        alert("请分配玩家身份");
    }
}