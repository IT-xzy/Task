//链接上一页
var playBoy = JSON.parse(sessionStorage.getItem('playerRoleTrans'));  //获取玩家角色属性
var playNum = window.sessionStorage.getItem('playBar'); //获取玩家号码属性
console.log(playBoy);       //玩家角色
console.log(playNum);     //玩家属性号码

var step = 1;      //步骤数
var nn = 1;      //footer里面的号码
var a = 0;
//添加一个顶部的序号
$(".num-x") .html(step);
//添加一个底部的序号
$(".num-y") .html(nn);

$(".card-icon") .css('display', 'block');
$(".card-icon-role") .css('display', 'none');
$("#check") .css('display', 'block');
$("#send") .css('display', 'none');
$("#result") .css('display', 'none');

function checkRole() {
    if (a < playNum - 1) {  //(4~18之间的数字) - 1
        $(".card-icon") .css('display', 'none');
        $(".card-icon-role") .css('display', 'block');
        $("#check") .css('display', 'none');
        $("#send") .css('display', 'block');
        $("#result") .css('display', 'none');

        $('.killer-farmer') .html(playBoy[a]);

        nn++;
        $('.num-z') .html(nn);
        $('.num-y') .html(step);
        step++;
        a++;

        console.log("完");
    } else if (a = playNum) {
        $(".card-icon") .css('display', 'none');
        $(".card-icon-role") .css('display', 'block');
        $("#check") .css('display', 'none');
        $("#send") .css('display', 'none');
        $("#result") .css('display', 'block');
        $('.killer-farmer') .html(playBoy[a - 1]);


    }
}

function sendRole() {
    $(".card-icon") .css('display', 'block');
    $(".card-icon-role") .css('display', 'none');
    $("#check") .css('display', 'block');
    $("#send") .css('display', 'none');
    $("#result") .css('display', 'none');
    $('.num-x') .html(nn);
    $('.num-y') .html(step);
}

function backToSetPage() {
    window.location.href = '法官台本.html';
}
function nextOne() {
    window.location="玩家配比页面.html";
}