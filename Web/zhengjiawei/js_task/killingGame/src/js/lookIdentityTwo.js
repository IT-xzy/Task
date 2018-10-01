/* 查看身份页面二 */
var lookNum = document.getElementById("lookNumber"); /* 表头 号码 */
var nextNum = document.getElementById("nextNumber"); /* 获取button */
var identityWord = document.getElementById("identityWord"); /* 身份 */
var identityindex; /* 身份信息数组角标 */
var cardNum; /* 表头号码 */
var identityInfoArray; /* 身份信息 */
var nextNumber; /* 隐藏 查看 下一个号码，比表头号码+1 */

window.onload = inputHtml();

function inputHtml() {
    getIdentity(); /* 获取身份数组 */
    // getIdentityIndex(); /* 获取身份数组角标 */
    console.log(identityInfoArray);
    console.log(identityInfoArray.length);
    getCardNum(); /* 获取号码 */
    console.log("cardnum=" + cardNum);
    getNextNumber(); /* 获取下一个号码 */
    lookNum.innerHTML = cardNum; /* 表头号码 */
    if (cardNum == identityInfoArray.length) {
        nextNum.innerHTML = "法官查看";
    }
    else{
        nextNum.innerHTML = "隐藏并传递给" + nextNumber + "号";
    }
    inputIdentityWord();
    console.log("数组角标" + identityindex);
} /* 输入内容 */

function previous() {
    identityindex -= 1;
    setIndex(); /* index -1后，重新把index储存到sessionStorage中 */
    history.go(-1); /* 返回上一页 */
} /* 点击上一页 */

function nextPage() {
    setIndex();
    setCardnum(); /* 点击以后cardnum会+1 */
    if (cardNum - 1 == identityInfoArray.length) {
        window.location.href = "judgeDiary.html";
    } else {
        window.location.href = "lookIdentity.html";
    }
} /* 点击下一页时对号码进行更改 */

function getIdentity() {
    identityInfoArray = sessionStorage.getItem("identity");
    identityInfoArray = JSON.parse(identityInfoArray); /* 获取身份数组 */
} /* 获取身份数组 */

function getCardNum() {
    cardNum = JSON.parse(sessionStorage.getItem("cardNum"));
    return cardNum;
} /* 获取号码信息 */

function getNextNumber() {
    nextNumber = cardNum + 1;
} /* 设置隐藏 查看 下一个号码，比表头号码+1 */


function setCardnum() {
    cardNum = cardNum + 1; /* 点击后表头号码 增加 */
    sessionStorage.setItem("cardNum", cardNum);
} /* 重设定号码 */

function setIndex() {
    sessionStorage.setItem("identityindex", identityindex);
} /* 初始化 储存数据 */

function getIndex() {
    identityindex = JSON.parse(sessionStorage.getItem("identityindex"));
}

function inputIdentityWord() {
    getIndex();
    identityWord.innerHTML = identityInfoArray[identityindex];
} /* 身份 输入 */