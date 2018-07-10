console.log("JS文件");

var divwait=document.getElementById("waitbox");//等待查看页面
var seebox=document.getElementById("seebox");//身份页面
var btnsee=document.getElementById("btn-see");//查看身份按钮
var btnnext=document.getElementById("btn-next")//隐藏传递按钮
var btnjudge=document.getElementById("judge-see");//法官查看按钮
var bsnum=document.getElementById("btn-see-num");//查看什么按钮数字
var bnnum=document.getElementById("btn-next-num");//隐藏传递按钮数字
var Num=sessionStorage.getItem("Num"); //上一页面输入人数
var playArr = JSON.parse(sessionStorage.getItem("playArr"));//上一页面身份数组
var ciword =sessionStorage.getItem("ciword");//上一页面水民词汇
var kiword = sessionStorage.getItem("kiword");//上一页面杀手词汇
console.log(ciword);
console.log(kiword);

console.log(playArr);
var n=0;//n为页面显示玩家序号

function back(){
    history.back();
}//左上角返回按钮

function off(){
    var choose=confirm("是否结束本轮游戏？");
    if (choose){
        location.replace("page2.html");
    }
}//右上角X按钮

function see(){
    divwait.style.display="none";//隐藏  等待界面
    seebox.style.display="block";//显示  身份界面
    btnsee.style.display="none";//隐藏  查看按钮
    btnnext.style.display="block"//显示  隐藏查看按钮
    topnum();//玩家序号
}//查看按钮

function topnum(){
    var numbox=document.getElementById("numbox");  
    if (n==(Num-1)){
        btnnext.style.display="none";
        btnjudge.style.display="block";
    }//查看最后一个身份是隐藏按钮，查看法官视角
    role();//玩家角色
    words();//词组
    bnnum.innerText=n+2;//隐藏查看按钮数字
    bsnum.innerText=n+2;//查看身份按钮数字
    n=n+1;
    console.log(n)   
}//玩家序号累加

function role(){
    var role=document.getElementById("role");
    numbox.innerText=n+1;//顶部玩家序号
    role.innerHTML=playArr[n];
}//玩家角色

function words(){
    var word=document.getElementById("word");
    if (playArr[n]=="平民"){
        word.innerText=ciword;
    }else if (playArr[n]=="杀手"){
        word.innerText=kiword;
    }
}

function next(){ 
    divwait.style.display="block";//显示  等待界面
    seebox.style.display="none";//隐藏  身份界面
    btnsee.style.display="block";//显示  查看按钮
    btnnext.style.display="none"//隐藏  隐藏查看按钮
    numbox.innerText=n+1;
}//隐藏传递按钮

function judge(){
    location.assign("page5.html");
}

