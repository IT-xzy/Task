var resultNum = JSON.parse(sessionStorage.getItem("orderkey"));
var result = JSON.parse(sessionStorage.getItem("aliveColorB"));
var dieArr = JSON.parse(sessionStorage.getItem("dieArr"));//死亡人员数组
var dieNum = JSON.parse(sessionStorage.getItem("dieNum"));//死亡人员位置
var dieNumA = JSON.parse(sessionStorage.getItem("dieNumA"));//死亡人员位置数组


console.log(result);
console.log(resultNum);
console.log(dieArr);
console.log(dieNum);
console.log(dieNumA);

var log = document.getElementById("log");

var compare = {};
resultNum.join().replace(/(\w{1})/g, function ($1) {
    compare[$1] ? compare[$1] += 1 : compare[$1] = 1;
});

console.log(compare[1]);

$("#kill").append(compare[1]);
$("#people").append(compare[2]);

function goback() {
    sessionStorage.clear();
    location.href = "home.html";
}

//自动生成日志
var logArr = [];//全部人的数组
var dieArrLength = Math.ceil(dieArr.length/2); //向上取整得到天数
for (var i = 0; i < dieArrLength; i++) {
    var a = i + 1;
    var numA = a*2 -2;
    var numB = a*2 -1;
    if ( dieNumA[numB] === undefined){
        logArr[i] = "<li class=\" thr-row3 bc999\" ><span class=\"fl bc000\">第"+a+"天</span><span class=\"float-r\"></span><p class=\"pt1\">晚上："+dieNumA[numA]+"号被杀手杀死，真实身份是"+dieArr[numA]+"</p></li>";
    }else{
        logArr[i] = "<li class=\" thr-row3 bc999\" ><span class=\"fl bc000\">第"+a+"天</span><span class=\"float-r\"></span><p class=\"pt1\">晚上："+dieNumA[numA]+"号被杀手杀死，真实身份是"+dieArr[numA]+"</p><p >白天："+dieNumA[numB]+"号被全民投票投死，真实身份是"+dieArr[numB]+"</p></li>";
    }
}
var logBrr = logArr.join("");//转换成字符串
log.innerHTML = logBrr;//自动显示日志
