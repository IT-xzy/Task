/**
 * Created by Administrator on 2017/11/30.
 */

s = sessionStorage.TotalArr;
//重新转换为数组
TotalArr = JSON.parse(s);
console.log(TotalArr);
console.log(TotalArr.length);

var container=[];
var identity;
var i;
for (i = 0; i < TotalArr.length; i++) {
    identity = '<div class="option">'+ '<div class="people">' + TotalArr[i] +
        '</div>' +'<div class="number"> ' + (i + 1) + "号" + '</div>'+'</div>' ;

    container.push(identity);

}

document.getElementById("diary").innerHTML=container.join('');

var start=document.getElementById("start");
start.onclick=function () {
    location.href="js-The judge this.html";
};