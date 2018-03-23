
s = sessionStorage.TotalArr;
//重新转换为数组
TotalArr = JSON.parse(s);
var killnum=parseInt(sessionStorage.getItem("killnum"));
var peoplenum=parseInt(sessionStorage.getItem("peoplenum"));
var k=killnum;
var p=peoplenum;
var Index;
var dieNum =null;
var dieList = null;

if(sessionStorage.getItem('dieNum')){
    dieNum=JSON.parse(sessionStorage.getItem('dieNum'));
}else {
    dieNum=[]
}
if(sessionStorage.getItem('dieList')){
    dieList=JSON.parse(sessionStorage.getItem('dieList'));
}else {
    dieList=[]
}
if(sessionStorage.getItem('K')){
   k=JSON.parse(sessionStorage.getItem('K'));
}else {
    k=killnum;
}
if(sessionStorage.getItem('P')){
    p=JSON.parse(sessionStorage.getItem('P'));
}else {
    p=peoplenum;
}

//定义一个死亡玩家的空数组，并存储，便于在其他页面增加死亡玩家号码；
sessionStorage.setItem("dieNum",JSON.stringify(dieNum));

// 复制参数
var container=[];
var identity;
for (var i = 0; i < TotalArr.length; i++) {
    identity = '<div class="option">' + '<div class="people">' + TotalArr[i] +
        '</div>' + '<div class="number"> ' + (i + 1) + "号" + '</div>' + '</div>';

    container.push(identity);
}
document.getElementById("diary").innerHTML=container.join('');

// 杀手杀人和全民投票页面的判断
var isKill=sessionStorage.getItem("isKill");
if(isKill==1){
    $("h2").text('杀手杀人');
    $(".words").text("黑夜降临，杀手请睁眼杀人");
}else{
    $("h2").text('全民投票');
    $(".words").text("白天到了，请所有玩家投票");
}

$(document).ready(function () {

    $(".option").click(function () {
        var people = $(this).find(".people").text();                       //获取点击的玩家身份
        var index = $(this).index();                                    //获取死亡人的下标
        Index=index;
        D = $(this).find(".people").css("background-color");

        if(D === "rgb(255, 0, 0)"){                                     //通过背景颜色来判断死活
            alert("亡者已逝，请杀活着的人");
        }else{
            if(isKill==1){
                //杀手杀人页面
                if (people === "杀手") {
                    alert("刀下留情！！！去杀平民");
                    $(".people").removeClass("down");
                    Index=null;
                }else {
                    $(".people").removeClass("down");
                    $(this).find('.people').addClass('down');
                }
            }
                //全民投票页面
            else {
                $(".people").removeClass("down");
                $(this).find('.people').addClass('down');
            }
        }
    });
});


//从存储的东西里找到第几个是死人，然后渲染变色，每次进来后就执行一次
function rendar() {
    for(var k=0;k<TotalArr.length;k++){
        for(var r=0;r<dieNum.length;r++){
            if(dieNum[r]==k){
                $('.people').eq(k).addClass('down1')
            }
        }
    }
}
rendar();


$("#start").click(function () {
    if(TotalArr[Index]==="平民"){
       p--;
        sessionStorage.setItem('P',p);
    }
    if(TotalArr[Index]==="杀手"){
        k--;
        sessionStorage.setItem('K',k);
    }
    if(p===k){
        alert("杀手胜利");
        sessionStorage.setItem("win",0);
        location.href="js-The game results.html"
    }else if(k===0){
        alert("平民胜利");
        location.href="js-The game results.html"
    }
    else{
        if(Index==null){            //下标是空的,还没有杀人，给出提示
            alert("请杀人再走");
            return dieNum;
        }
        else {
            location.href="js-The judge this.html";
        }
    }

    dieNum.push(Index);               //存入下标
    dieList.push((Index+1)+"号"+TotalArr[Index]);        //存入死亡列表
    sessionStorage.setItem("dieNum", JSON.stringify(dieNum));
    sessionStorage.setItem("dieList", JSON.stringify(dieList));
});



