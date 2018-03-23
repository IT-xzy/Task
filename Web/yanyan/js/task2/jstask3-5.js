var result ;
if (JSON.parse(sessionStorage.getItem("aliveColorC")) === null) {
    result = JSON.parse(sessionStorage.getItem("aliveColorA"));
}
else {
    result = JSON.parse(sessionStorage.getItem("aliveColorC"));
}
var state = JSON.parse(sessionStorage.getItem("daynum"));//页面1状态数据
sessionStorage.setItem("daykill", JSON.stringify(state));

console.log(result);
console.log(state);
var main = document.getElementById("main");
var orange = document.getElementsByClassName("two-orange");

console.log(result.length);

var boxarr = [];
for (var i=0 ; i<result.length ;i++) {
    var a = i + 1;
    boxarr[i] = "<div class=\"dropdown\"><div class=\"tow-box\"><div class=\"two-orange\" id='some'>水民</div><div" +
        " class=\"two-green\">" + a + "号</div></div><div class=\"two-choice\"></div></div>";
    if (result[i] === 1) {
        boxarr[i] = "<div class=\"dropdown\"><div class=\"tow-box\"><div class=\"two-orange\" id='some'>杀手</div><div" +
            " class=\"two-green\">" + a + "号</div></div><div class=\"two-choice\"></a></div></div>";
    }
}//遍历一个人数盒子数组

console.log(result);

var boxbrr = boxarr.join("");//转换成字符串
main.innerHTML = boxbrr;//自动显示数量

for (var n = 0; n < result.length; n++) {
    if (result[n] === 0) {
        orange[n].style.backgroundColor = "green";
    }
}

function goback() {
    window.history.back();
}
