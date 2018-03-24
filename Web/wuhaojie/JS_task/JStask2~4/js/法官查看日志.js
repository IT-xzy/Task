function nextOne() {
    window.location = "法官日志.html";
}

var day = JSON.parse(sessionStorage.getItem('dayTime'));
var allPlayers = JSON.parse(sessionStorage.getItem("allPlayers"));
var n = JSON.parse(sessionStorage.getItem('n'));
var deadNums = JSON.parse(sessionStorage.getItem('deadNums'));
var playNum = window.sessionStorage.getItem('playBar');
var result = JSON.parse(sessionStorage.getItem("result"));
var playBoy = JSON.parse(sessionStorage.getItem('playerRoleTrans'));

n.push(deadNums[deadNums.length - 1]);
n.splice(0, 1);
n.splice((n.length - 1), 1);
console.log(n); //游戏结束后，死亡玩家的number，而且带有杀人的先后顺序

var m = Math.round(n.length / 2);
for (var date = 0; date < m; date++) {
    if (date === parseInt(n.length / 2) && (n.length % 2 === 1)) {
        $('.main-course').append (
            '<div class="main-time">'
            +'<div class="day">'
            +'第'
            +(date + 1)
            + '天'
            +'</div>'
            +'</div>'

            +'<div class="main-day">'
            +'<span>'
            +'晚上：'
            + n[date * 2]
            +'号被杀手杀死，'
            + n[date * 2]
            +'号是平民'
            +'</span>'
            +'</div>'
        );
    } else {
        $('.main-course').append (
            '<div class="main-time">'
            +'<div class="day">'
            +'第'
            +(date + 1)
            + '天'
            +'</div>'
            +'</div>'

            +'<div class="main-day">'
            +'<span>'
            +'晚上：'
            + n[date * 2]
            +'号被杀手杀死，'
            + n[date * 2]
            +'号是平民'
            +'</span>'
            +'</div>'

            +'<div class="main-night">'
            +'<span>'
            +'白天：'
            + n[date * 2 + 1]
            +'号被全民投死，'
            + n[date * 2 + 1]
            +'号是'
            +allPlayers[n [date * 2 + 1] - 1].id
            +'</span>'
            +'</div>'
        );
    }
}