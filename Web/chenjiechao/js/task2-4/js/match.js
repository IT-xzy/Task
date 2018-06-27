var playerNum = document.getElementById("player"); //玩家总人数
var sliderNum = document.getElementById("slider"); //滑块的值
var arr = [];

function on_change() {
    if (playerNum.value >= 6 && playerNum.value < 18) { //if语句判断人数
        sliderNum.value = playerNum.value; //如果相等，则把输入框内的值赋给滑块
    } else {
        alert("请输入6-18以内的玩家人数");
        playerNum.value = 12; //重置人数为12
        sliderNum.value = 12;
    }
}

function moveChange() {
    playerNum.value = sliderNum.value; //把滑块的值赋给输入框
}

function less() {
    playerNum.value--; //按下按钮人数减1
    if (playerNum.value < 6) {
        alert("五个人开黑去");
        playerNum.value = 6;
    } else {
        sliderNum.value = playerNum.value;
    }
}

function plus() {
    playerNum.value++; //按下按钮人数加1
    if (playerNum.value > 18) {
        alert("人这么多你是要搞事情啊")
        playerNum.value = 18;
    } else {
        sliderNum.value = playerNum.value;
    }
}

var c = 0; //定义一个变量为点击match的次数
console.log(playerNum.value);

function matchNum() {
    c++; //每一次点击加1
    console.log(playerNum.value);
    if (c > 1) { //如果点击次数大于1，就需要清除之前的li标签
        var father = document.getElementById("clickMatch"); //获取ul节点
        var childs = father.childNodes; //获取ul节点的子节点
        console.log(childs)
        for (var s = (childs.length) - 1; s >= 0; s--) { //建立for循环删除li节点
            father.removeChild(childs[s]);
        }
    } else {}

    var killerNum = Math.floor(playerNum.value * 0.34); //计算平民的数量
    var peopleNum = playerNum.value - killerNum; //杀手数量等于总数量减平民数量

    var arr = []; //创建一个数组存放需要的杀手及平民数量
    for (i = 0; i < peopleNum; i++) { //将平民加入到arr数组里
        arr.push("平  民 1 人");

    }
    for (i = 0; i < killerNum; i++) { //将杀手加入到arr数组里
        arr.push("杀  手 1 人");

    }
    // console.log(arr);

    for (var i = arr.length; i--;) {
        var j = Math.floor(Math.random() * (i + 1)); //随机一个数值位置j
        // var temp = arr[i]; //创建一个临时变量temp用来存放i位置的值
        // arr[i] = arr[j]; //将j位置的值赋到i位置
        // arr[j] = temp; //将temp的值，也就是原来的i位置的值赋到j位置。完成数值替换
        [arr[i],arr[j]] = [arr[j],arr[i]];//解构赋值

        
        console.log('arr', arr);


            var node = document.createElement("LI"); //定义变量node一个标签li
        if (arr[i] == "平  民 1 人") { //判断数组的第i个值是否为平民
            node.className = "people"; //加上相应class
        } else {
            node.className = "killer";
        }
        var textnode = document.createTextNode(arr[i]); //定义textnode为arr【i】位置的字符串
        console.log(textnode);
        node.appendChild(textnode); //将textnode加入到node标签中
        console.log(node);
        document.getElementById("clickMatch").appendChild(node); //将node标签加入到id为clickMatch的标签下
    }
    var send = JSON.stringify(arr); //定义变量send为转化为字符串的arr数组
    console.log(send);
    // sessionStorage.arr = send;
    sessionStorage.setItem("send", send); //将send存入本地
    // console.log(sessionStorage.arr);  
    console.log(arr.length);
    // return arr;
}

function godraw() { //判断是否可以发牌
    if (playerNum.value == document.getElementsByTagName("li").length) {
        window.location.href = "./draw.html";
    } else {
        alert("请分配位置");
    }
}
$(function () {
    $(".header-right").click(function () {
        sessionStorage.removeItem("checkStep");
        sessionStorage.removeItem("countDay");
        sessionStorage.removeItem("de");
        sessionStorage.removeItem("ki");
        sessionStorage.removeItem("pe");
        sessionStorage.removeItem("send");
        sessionStorage.removeItem("gameOver");
        sessionStorage.removeItem("initial");
        sessionStorage.removeItem("stepTwo");
        sessionStorage.removeItem("x");
        sessionStorage.removeItem("y");
    })
})