var getMain = document.getElementById("main");
var getBox = document.getElementsByClassName("box");

var inputIdentity = document.getElementsByClassName("identity");
var inputIdentityNum = document.getElementsByClassName("identityNum");
var identityInfoArray; /* 身份数组 */
var cardNum = "initial"; /* cardNum设置一个状态 */
var newArray = []; /* 存放身份、号码、状态的数组 */
var identity; /* 身份 */
var number; /* 身份号码 */
var state; /* 身份状态 */

window.onload = initial(); /* 载入页面初始化 */

function previous() {
    setsession();
    window.location.href = "lookIdentity.html";
} /* 在法官查看页返回上一页后跳转至查看身份一号页面，要把接收到的号码和数组角标号码清除 */

function setsession() {
    sessionStorage.removeItem("cardNum");
    sessionStorage.removeItem("identityindex");
    cardNum = JSON.stringify(cardNum);
    sessionStorage.setItem("cardNum", cardNum); /* 重新给cardNum一个状态 */
}
/* __________ */


function getIdentity() {
    identityInfoArray = JSON.parse(sessionStorage.getItem("identity"));
    console.log(identityInfoArray);
    console.log("array.length=" + identityInfoArray.length);
} /* 获取身份数组 */

function assignment() {
    var a = 1;
    getIdentity(); /* 获取身份数组 */
    for (var i = 0; i < identityInfoArray.length; i++) {
        newArray.push({
            number: a,
            identity: identityInfoArray[i],
            state: true
        });
        a++;
    }
} /* 把号码牌和身份信息储存至数组 */

function initial() {
    assignment();
    for (var i = 0; i < newArray.length; i++) {
        // console.log(i);
        getMain.appendChild(getBox[i].cloneNode(true)); /* 复制方块 */
        inputIdentity[i].innerHTML = newArray[i].identity;
        inputIdentityNum[i].innerHTML = newArray[i].number;
        console.log("传入对象后的数组号码：" + newArray[i].number);
        console.log("传入对象后的数组身份：" + newArray[i].identity);
        console.log("状态" + newArray[i].state);
    }
    getMain.removeChild(getMain.lastChild);
} /* 载入页面复制格子、给格子内容赋值 */
console.log(getBox);

function nextPage() {
    window.location.href = "judgeScript.html";
}

/* assignment 赋值 */