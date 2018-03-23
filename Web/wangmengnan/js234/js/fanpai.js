allPeople = JSON.parse(localStorage.getItem('allPeople'));
arr = JSON.parse(localStorage.getItem('arr'));

var img1 = document.getElementById("fanpaiimg");
var img2 = document.getElementById("chakanimg");
var ck = document.getElementById("look-sf");
var yc = document.getElementById("chuandi-sf");
var fg = document.getElementById("faguanchakan-sf");
var sf = document.getElementById("peoplenumber");
var xh = document.getElementById("xuhao");
xh.innerHTML = 1;
ck.value = "查看" + xh.innerHTML + "号身份";
yc.value = "隐藏身份并传递给" + [1 + parseInt(xh.innerHTML)] +"号";
function clickChakan() {
    ck.style.display = "none";
    yc.style.display = "block";
    img2.style.display = "inline-block";
    img1.style.display = "none";
    sf.innerHTML = allPeople[arr[-1+ parseInt(xh.innerHTML)] ];
    if (parseInt(xh.innerHTML) === arr.length) {
        xh.innerHTML = xh.innerHTML;
        ck.style.display = "none";
        yc.style.display = "none";
        fg.style.display = "block";
    }
}

function clickYinchang() {
    yc.style.display = "none";
    ck.style.display = "block";
    img1.style.display = "inline-block";
    img2.style.display = "none";
    sf.innerHTML = " ";
    if (parseInt(xh.innerHTML) === arr.length) {
        xh.innerHTML = xh.innerHTML;
        ck.style.display = "none";
        yc.style.display = "none";
        fg.style.display = "block";
    } else {
        xh.innerHTML = parseInt(xh.innerHTML) + 1;
        
    }
    ck.value = "查看" + xh.innerHTML + "号身份";
    yc.value = "隐藏身份并传递给" + [1 + parseInt(xh.innerHTML)] + "号";
}
//原生js 我也不知道怎么就写完了 我也很无奈；；；；；；；；；；；
//就是改变dom 然后通过if判断让数字递增 当他什么时候等于数字的长度的时候 就让两个都none隐藏，
// 只显示法官查看，中间用到字符串转换 别的没了。。。。
function goFapai(){
    window.location.assign('./faguanlook.html')
 }
