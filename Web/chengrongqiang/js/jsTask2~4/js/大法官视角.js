// 获取数据
var identifyIfo = JSON.parse(sessionStorage.getItem("playerIdentify"));
var num = sessionStorage.getItem("playerNums");
console.log(identifyIfo);
console.log(num);
// 返回首页
function backFirst() {
    window.location.href = "设置页面.html";
}
// 生成数据即玩家的身份信息的排列
var a = 0
var c = 1
var x = '';
for (a = 0; a < num; a++) {
    c = a + 1;
    x = '<div class="player">' +
        '<div class="p-top">' +
        identifyIfo[a] +
        '</div>' +
        '<div class="p-down">' +
        c +
        '号' +
        '</div>' +
        '</div>'
    $('.player-box').append(x);
}
// $('.player-box').html(x)

// 设置玩家的身份、编号、生死状态这里采用数组加对象的方式去做
var playersifo = new Array();
for (var b = 0; b < num; b++) {
    playersifo[b] = new Object();
    playersifo[b].num = b + 1;
    playersifo[b].identify = identifyIfo[b];
    playersifo[b].state = 1;
}
console.log(playersifo);
// 将玩家信息存储并传递到下个页面
sessionStorage.setItem('playersifo', JSON.stringify(playersifo));

// 定义新数组用于放置死去的角色
// 每次到这个页面时初始化死亡人数数组
var deadMan = [];
sessionStorage.setItem('deadMan', JSON.stringify(deadMan));
var deadManNum = [];
sessionStorage.setItem('deadManNum', JSON.stringify(deadManNum));
// 天数的重置
var day = 1;
sessionStorage.setItem('day', JSON.stringify(day));


// 切换到大法官日志页面
function nextPage() {
    window.location.href = "./大法官的日志.html"
}