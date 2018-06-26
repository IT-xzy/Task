var lookNum = document.getElementById("lookNumber"); /* 查看身份号码 */
var clickIdentity = document.getElementById("lookIdentity"); /* 查看身份 点击按钮 */
var cardNum; /* 身份号码 */
var identityindex;


window.onload = initial();

function initial() {
    getCardNum();
    console.log("页面一载入后cardnum=" + cardNum);
    if (cardNum == null || cardNum == "initial") {
        cardNum = 1;
    }
    console.log("赋值后" + cardNum);
    inputHtml();
    console.log(identityindex);
}; /* 初始样式 */

function previous() {
    if (cardNum == 1) {
        window.location.href = "playerRatio.html";
        return;
    }
    getCardNum();
    cardNum -= 1;
    setCardnum();
    history.go(-1);

} /* 点击上一页，表头号码 -1 重新储存sessionStorage */

function nextPage() {
    setCardnum();
    setIndex();
    window.location.href = "lookIdentity-two.html";
} /* 点击下一下跳转 */

function setCardnum() {
    cardNum = JSON.stringify(cardNum);
    sessionStorage.setItem("cardNum", cardNum); /* 表头号码，转json格式储存到本地 */
}

function getCardNum() {
    cardNum = JSON.parse(sessionStorage.getItem("cardNum")); /* 获取localstorage 传来的值，查看身份 号码 */
} /* 获取表头号码 */


function inputHtml() {
    lookNum.innerHTML = cardNum;
    clickIdentity.innerHTML = "查看" + cardNum + "号身份";
} /* 输入号码 */


function setIndex() {
    getIndex();
    if (identityindex == undefined || cardNum == "initial") {
        identityindex = 0;
    } else {
        identityindex += 1;
    }
    identityindex = JSON.stringify(sessionStorage.setItem("identityindex", identityindex));
}

function getIndex() {
    identityindex = JSON.parse(sessionStorage.getItem("identityindex"));
}