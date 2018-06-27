// 取出数组
var identifyIfo = JSON.parse(sessionStorage.getItem("playerIdentify"));
var num = sessionStorage.getItem("playerNums");
console.log(identifyIfo);
console.log(num);
var words = JSON.parse(sessionStorage.getItem("gameWords1"));
console.log(words);
// 数据传输成功

// 返回上一页
function backFirst() {
    window.location.href = "设置页面.html";
}
// bc是号码
var a = 0;
var b = 1;
var c = 1;
var d = num - 1
    // 人数是从0开始计，所以人数要减去一来计数，不然会出现设置4个人，但是实际是五个人的情形
    // 获取要操作元素的所以dom节点
var cardIcon = document.getElementsByClassName("card-icon");
var roleCardIcon = document.getElementsByClassName("role-card-icon");
var btn1 = document.getElementById("btn1");
var btn2 = document.getElementById("btn2");
var btn3 = document.getElementById("btn3");
var num1 = document.getElementById("num1");
var num2 = document.getElementById("num2");
var num3 = document.getElementById("num3");
var role = document.getElementsByClassName("identify-info");
var playerifo = document.getElementById("playerifo");
var wordsInfo = document.getElementById("words-info");
// 通过dom节点更改样式初始
playerifo.style.cssText = "font-size:.2rem;color:#29bde0;font-weight:700;"
wordsInfo.parentNode.style.cssText = "font-size:.2rem;color:#f56b81;font-weight:700;"
btn2.style.display = "none"
btn3.style.display = "none"
num1.innerHTML = b;
num1.style.cssText = "padding-top:.05rem;vertical-align:middle;color:#f56b81;"

// 点击按钮弹出身份界面，并将从第一页取的数据赋值显示出来
function checkIdentity() {
    if (a < d) {
        num1.innerHTML = b;
        b++;
        role[0].innerHTML = identifyIfo[a];
        checkedWords();
        a++;
        c++;
        num2.innerHTML = c;
        cardIcon[0].style.cssText = "display:none;"
        roleCardIcon[0].style.cssText = "display:block;"
        btn1.style.cssText = "display:none;"
        btn2.style.cssText = "display:block;"
        num3.innerHTML = c;
    }
    //  设定最后一个人的身份信息（需要单独设置）
    else {
        btn1.style.cssText = "display:none;"
        btn2.style.cssText = "display:none;"
        btn3.style.cssText = "display:block;"
        roleCardIcon[0].style.cssText = "display:block;"
        cardIcon[0].style.cssText = "display:none;"
            // 给最后一个人身份，需重新赋值不然其身份是num-1的值
        checkedWords();
        role[0].innerHTML = identifyIfo[a];
    }
}
// 点击弹出翻牌界面
function sendIdentity() {
    num1.innerHTML = b;
    cardIcon[0].style.cssText = "display:block;"
    roleCardIcon[0].style.cssText = "display:none;"
    btn1.style.cssText = "display:block;"
    btn2.style.cssText = "display:none;"
    console.log(b)
}

function nextPage() {
    window.location.href = "大法官视角.html";
}

function checkedWords() {
    if (identifyIfo[a] == "杀手") {
        wordsInfo.innerHTML = words[1]
    } else {
        wordsInfo.innerHTML = words[0]
    }
}