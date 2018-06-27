// 取回本地数据
var outValue = JSON.parse(localStorage.getItem("outValue"));
console.log(outValue);
// 捕捉要复制的节点
var boxFLex = document.getElementsByClassName("box-flex");
// 捕捉父级节点
var main = document.getElementsByTagName("main")[0];
//console.log(boxFLex);
// 读取面向对象数组
var outOject = JSON.parse(localStorage.getItem("outOject"));
console.log(outOject)
// 循环创建创建初始信息
function clone() {
    // 创建对应数量的窗口
    for (let i = 0; i < outValue.length - 1; i++) {
        var newNode = boxFLex[0].cloneNode(true);
        main.appendChild(newNode);
    }
    // 赋予对应窗口的身份
    for (let i = 0; i < outValue.length; i++) {
        let num = i + 1;
        boxFLex[i].getElementsByClassName("name")[0].innerHTML = outValue[i];
        boxFLex[i].getElementsByClassName("number")[0].innerHTML = num;
    }
    for (let i = 0; i < outOject.length; i++) {
        if (outOject[i].state == "dead") {
            boxFLex[i].getElementsByTagName("p")[0].style.background = "#83b09a";
            boxFLex[i].getElementsByTagName("p")[1].style.background = "#83b09a";
        }
    }
}
clone();
// 捕捉footer按钮，创建点击事件
var footer=document.getElementsByTagName("footer")[0];
footer.addEventListener("click",link);
function link(){
    window.location.href="dome1.8.html"
}