// 捕捉父级节点以便删除白痴和守卫
var main = document.getElementsByClassName("mian");
// 捕捉守卫节点,每次影藏守卫
var shouwei = document.getElementsByClassName("shouwei")[0];
// 捕捉白痴节点，每次影藏白痴
var baichi = document.getElementsByClassName("baichi")[0];
// 捕捉狼人和村民数量的span方便给与赋值
var langNum = document.getElementsByClassName("langNum")[0];
var cunNum = document.getElementsByClassName("cunNum")[0];
// 定义捕捉input的值
var num;
// 定义狼人人数和村民人数
var lang;
var ming;
// 定义正则限定字数
var numInput = document.getElementById("num");
numInput.addEventListener("input", function () {
    this.value = this.value.replace(/[^\d]/g, '');
})
// 页面载入运行一次人数分配函数
people();
//  捕捉input设置keypress事件
var input = document.getElementById("num")
input.addEventListener("input", people);

function people() {
    // 捕捉input的值
    num = document.getElementById("num").value;
    // 影藏白痴和守卫节点
    shouwei.style = "display:none";
    baichi.style = "display:none";
    //    情况狼人和村民的数量
    langNum.innerHTML = "";
    cunNum.innerHTML = "";
    switch (true) {
        //  人数9.10的时候分配
        case num == 10 || num == 9:
            nine()
            // console.log(9);
            break;
        case num == 11:
            eleven();
            break;
        case num == 12:
            twelve();
            break;
        case num == 13 || num == 16:
            thirteen();
            break;
        case num == 14 || num == 15:
            fourteen();
            break;
    }
}
// 9.10人数分配
function nine() {
    ming = Math.ceil(num / 3);
    lang = Math.floor(num / 3);
    //console.log(num);
    langNum.innerHTML = lang;
    cunNum.innerHTML = ming;
}
// 11的时候人数分配
function eleven() {
    ming = 4;
    lang = 3;
    // console.log(num);
    langNum.innerHTML = lang;
    cunNum.innerHTML = ming;
    // 换出白痴牌
    baichi.style = "display:flex;"
}
//12的时候人数分配
function twelve() {
    ming = 4;
    lang = 4;
    // console.log(num);
    langNum.innerHTML = lang;
    cunNum.innerHTML = ming;
    // 换出白痴牌
    baichi.style = "display:flex;"
}
//13,16的时候人数分配
function thirteen() {
    lang = Math.floor(num / 3);
    ming = num - 5 - lang;
    //console.log(ming)

    langNum.innerHTML = lang;
    cunNum.innerHTML = ming;
    // 换出白痴牌
    baichi.style = "display:flex;"
    // 换出守卫牌
    shouwei.style = "display:flex;"
}
//14,15的时候人数分配
function fourteen() {
    lang = Math.ceil(num / 3);
    ming = num - 5 - lang;
    console.log(ming)
    // console.log(num);
    langNum.innerHTML = lang;
    cunNum.innerHTML = ming;
    // 换出白痴牌
    baichi.style = "display:flex;"
    // 换出守卫牌
    shouwei.style = "display:flex;"
}

// 捕捉去发牌并定义点击事件
var footer = document.getElementsByTagName("footer")[0];
footer.addEventListener("click", examine);

function examine() {
    // 捕捉input的值
    var num = document.getElementById("num").value;
    // 进行判断
    switch (true) {
        // 人数不符合就弹窗
        case num < 13 || num > 16:
            open();
            //    console.log(1);
            break;
            //    符合就运行乱序分配身份
        default:
            out();
            window.location.href = "dome1.6.html"
    }
}
// 乱序分配身份
function out() {
    // 创建rank数组
    let rank = ["预言家", "女巫", "猎人"];
    for (let i = 0; i < lang; i++) {
        rank.push("狼人")
    }
    for (let i = 0; i < ming; i++) {
        rank.push("村民")
    }
    switch (true) {
        case num == 11 || num == 12:
            rank.push("白痴");
            break;
        case num > 12 && num <= 16:
            rank.push("白痴");
            rank.push("守卫");
            break;
    }
    // 进行乱序
    for (let i = 0; i < num - 1; i++) {
        let randomX = Math.floor(Math.random() * (num - 1 - i));
        let randomValue = rank[randomX];
        rank[randomX] = rank[num - 1 - i];
        rank[num - 1 - i] = randomValue;
    }
    console.log(rank);
    // 给数组rank转json
    let value = JSON.stringify(rank);
    // 设置一个变量number数字并转json
    let number = 0;
    let numberValue = JSON.stringify(number)
    // 保存数据到本地
    var outOject = []; //清空对象数组
    var night = []; //清空夜晚日志
    var dayTime = []; //清空白天日志；
    var flowNumber = []; //清空流程
    localStorage.setItem("outValue", value);
    localStorage.setItem("outNumber", numberValue);
    localStorage.setItem("outOject", JSON.stringify(outOject));
    localStorage.setItem("night", JSON.stringify(night));
    localStorage.setItem("dayTime", JSON.stringify(dayTime));
    localStorage.setItem("flowNumber", JSON.stringify(flowNumber))
    var madicine = new Object(); //重置药水
    madicine.save = 1;
    madicine.dead = 1;
    localStorage.setItem("madicine",JSON.stringify(madicine));

}
// 捕捉弹窗div
var tanchuang = document.getElementsByClassName("tanchuang")[0];
// 弹窗函数
function open() {
    tanchuang.style = " visibility:visible;";
}
// 取消弹窗
var p = document.getElementsByClassName("tanchuang")[0].getElementsByTagName("div")[0].getElementsByTagName("p");
//console.log(p);
p[0].addEventListener("click", close);
p[1].addEventListener("click", close);

function close() {
    tanchuang.style = "visibility:hidden;"
}