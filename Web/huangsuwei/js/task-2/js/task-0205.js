/**
 * Created by Administrator on 2017/11/30.
 */
var civ=sessionStorage.getItem('all');
var kil=JSON.parse(sessionStorage.getItem('stats'));
var container=[];
var TotalArr=[];
var allPlayers=[];
var identity;

for( var i = 0;i < civ;i++){
    if(kil.indexOf(i)>= 0){
        TotalArr.push('杀手')
    }else {
        TotalArr.push('平民')
    }
}
console.log(TotalArr);
for (var q = 0; q <civ; q++) {
    identity = '<div class="player-box1">'+ '<div class="player-status">' + TotalArr[q] +
        '</div>' +'<div class="player-number"> ' + (q + 1) + "号" + '</div>'+'</div>' ;
    container.push(identity);
}
document.getElementById("diary").innerHTML=container.join('');
for (var w = 0 ; w < civ ; w++){
    allPlayers[w]={};
    allPlayers[w].number=w+1;
    allPlayers[w].status=TotalArr[w];
    allPlayers[w].state=1;
}
var start=document.getElementById("start");
start.onclick=function () {
    sessionStorage.setItem('step','none');
    sessionStorage.setItem('allP',JSON.stringify(allPlayers));
    location.href="./task-0205.html";
};
var clo=document.getElementById("close");
clo.onclick=function () {
    var close = confirm("确定离开");
    if(close === true){
        location.href='./index.html';
        sessionStorage.clear();
    }
};
var bre=document.getElementById("break");
bre.onclick=function () {
    var close = confirm("返回配置界面？");
    if(close === true){
        location.href='./task-0202.html';
        sessionStorage.clear();
    }
};