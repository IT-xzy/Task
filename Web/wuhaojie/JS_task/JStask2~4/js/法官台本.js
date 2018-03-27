//获取上一个页面的数据并用到这个页面
var playBoy = JSON.parse(sessionStorage.getItem('playerRoleTrans'));        //获取玩家角色属性  object
var playNum = window.sessionStorage.getItem('playBar');               //获取玩家号码属性   string
console.log(playBoy);   //玩家加色属性
console.log(playNum);   //玩家号码属性

var gameRole = '';
for (var x in playBoy) {
    gameRole
        += '<div class="content-box1">'
        + '<p class="content1">'
        + playBoy[x]
        + '</p>'
        + '<p class="number1">'
        + (++x)
        + '号'
        + '</p>'
        + '</div>'
}
$(".content-box").eq(0).html(gameRole);

var day = 1;

var allPlayers = [];//全部玩家的状态
//定义一个空数组,数组中的每一项都是对象,对象里放置玩家的号码,角色与生死的键值对

for (var a = 0; a < playNum; a++) {
    allPlayers[a] = {};
    allPlayers[a].number = a + 1;
    allPlayers[a].id = playBoy[a];
    allPlayers[a].state = 1;
}

sessionStorage.setItem('allPlayers', JSON.stringify(allPlayers));
var deadNums = [];//多个
sessionStorage.setItem('deadNums' ,JSON.stringify(deadNums));
var deadNum = [];//单个
sessionStorage.setItem('deadNum' ,JSON.stringify(deadNum));

function nextOne() {
    window.location = "玩家配比页面.html";
}
function nextPaeg() {
    window.location = "法官日志.html";
    sessionStorage.setItem('dayTime' ,JSON.stringify(day));
}   //传递天数
console.log(allPlayers);

