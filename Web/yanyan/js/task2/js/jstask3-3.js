var result = JSON.parse(sessionStorage.getItem("orderkey"));
console.log(result);
var main = document.getElementById("main");


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

var boxbrr = boxarr.join("");//转换成字符串
main.innerHTML = boxbrr;//自动显示数量



