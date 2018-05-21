var civ=sessionStorage.getItem('all');
var kil=sessionStorage.getItem('status');
var playcover=document.getElementById('playcover');
var players=document.getElementById('players');
var playern=document.getElementById('playern');
var tran=document.getElementById('transmit');
var watch=document.getElementById('look');
var pn=0;
var pg= [];
function look() {
    pn=pn+1;
    pg[1]=pn-1;
    if ('stats'.indexOf(pg[1])>= 0){
        players.innerHTML=players.innerHTML.replace(/(平民|杀手)/,'杀手')
    }else {
        players.innerHTML=players.innerHTML.replace(/(平民|杀手)/,'平民')
    }
    if (pn<civ){
        tran.innerHTML = "隐藏传递给"+(pn+1)+"号";

    }else if(pn=civ){
        tran.innerHTML= '查看法官日志';
    }
    playcover.classList.remove('identity-z');
}
function transmit() {
    playern.innerHTML= (pn + 1);
    if (pn<civ){
        watch.innerHTML= "查看"+(pn+1)+"号身份";
    }
    if(pn===civ){
        window.location.href="./task-0204.html";
    }
    playcover.classList.add('identity-z');
}
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