s = sessionStorage.totalArr;
totalArr = JSON.parse(s);

var killNum = parseInt(sessionStorage.getItem('killNum'));
var peopleNum = parseInt(sessionStorage.getItem('peopleNum'));
var k = killNum;
var p = peopleNum;
var isKill = parseInt(sessionStorage.getItem('isKill'));
console.log(isKill);
var Index;
var dieNum = null;
var dieList = null;
console.log(k);
console.log(p);



var title = sessionStorage.getItem('title');
var killMan = sessionStorage.getItem('killer');
var kill = document.getElementById('kill');
kill.innerHTML = title;
var x = document.getElementById('killMan');
x.innerHTML = killMan;

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
    k=killNum;
}
if(sessionStorage.getItem('P')){
    p=JSON.parse(sessionStorage.getItem('P'));
}else {
    p=peopleNum;
}

//存储已死亡玩家的数组
sessionStorage.setItem('dieNum',JSON.stringify(dieNum));

var container=[];
var identity;
for (var i = 0; i < totalArr.length; i++) {
    identity = '<div class="newClass">' + '<div class="casting">' + totalArr[i] +
        '</div>' + '<div class="num">' + (i + 1) + "号" + '</div>' + '</div>';
    container.push(identity);
}
document.getElementById("diary").innerHTML=container.join('');

$(document).ready(function () {
    $(".newClass").click(function () {
        var people = $(this).find(".casting").text();
        var index = $(this).index();
        Index = index;
        var D = $(this).find(".casting").css("background-color");

        if(D === "rgb(140, 140, 140)"){
            alert("亡者已逝,请杀活着的玩家");
            $('.casting').removeClass("down");
        }else {
            if(isKill === 1){
                if(people === "杀手"){
                    alert("队长!别开枪!!是我!!!");
                    $('.casting').removeClass("down");
                    Index = null;
                }else {
                    $(".casting").removeClass("down");
                    $(this).find('.casting').addClass('down');
                }
            }else {
                $(".casting").removeClass("down");
                $(this).find('.casting').addClass('down');
            }
        }
    })
});


function rendar() {
    for(var k=0; k<totalArr.length; k++){
        for(var r=0; r<dieNum.length; r++){
            if(dieNum[r]===k){
                $('.casting').eq(k).addClass('down1')
            }
        }
    }
}
rendar();


$("#startGame").click(function () {
    if(totalArr[Index]==="平民"){
        p--;
        sessionStorage.setItem('P',p);
    }
    if(totalArr[Index]==="杀手") {
        k--;
        sessionStorage.setItem('K', k);
    }
        if(p === k){
            alert("杀手胜利");
            sessionStorage.setItem('victory',"杀手胜利");
            sessionStorage.setItem('win',0);
            location.href = "end.html";
        }else if(k===0){
            alert("平民胜利");
            sessionStorage.setItem('victory',"平民胜利");
            location.href = "end.html";
        }else if(Index==null){
            alert("风过留声,雁过留影!请壮士杀完人再走!!");
            return dieNum;
        }else location.href = "game.html";

    dieNum.push(Index);
    dieList.push((Index+1)+"号"+totalArr[Index]);
    sessionStorage.setItem('dieNum',JSON.stringify(dieNum));
    sessionStorage.setItem('dieList',JSON.stringify(dieList));
});
console.log(k);
console.log(p);
sessionStorage.setItem('killer', k);
sessionStorage.setItem('gamePlay', p);
function finish() {
    alert("");
    window.location.href = "home.html";
}

