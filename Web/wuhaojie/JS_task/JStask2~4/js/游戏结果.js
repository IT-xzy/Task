var day = JSON.parse(sessionStorage.getItem('dayTime'));
var allPlayers = JSON.parse(sessionStorage.getItem("allPlayers"));
var n = JSON.parse(sessionStorage.getItem('n'));
var deadNums = JSON.parse(sessionStorage.getItem('deadNums'));
var playNum = window.sessionStorage.getItem('playBar');
var result = JSON.parse(sessionStorage.getItem("result"));
var playBoy = JSON.parse(sessionStorage.getItem('playerRoleTrans'));

//取得最后一次杀死玩家的号码并放到n数组中
n.push(deadNums[deadNums.length - 1]);

n.splice(0,1);
console.log(n); //游戏结束后，死亡玩家的number，而且带有杀人的先后顺序

var killers = new Number();
for (var x = 0,len = allPlayers.length; x < len; x++) {
    if(allPlayers[x].id === '杀手'){
        killers++;
    }
}
console.log(killers);
//根据sessionStorage传输过来的result
// result是1,平民胜利
// else杀手胜利
// 对应弹出不同的结果页
if (result === 1) {
    $('.main-img').append('<img src="img/farmer-win.png">');
    $('.main-title').append('<h2>平民胜利!</h2>');
    $('.main-text').append('<span>本次游戏共计用时0小时25分钟</span>'
        +'<br />'
        +'<span>'
        +'杀手：'
        + killers
        +'人'
        +'</span>'
        +'<span>'
        +'平民：'
        + (playNum - killers)
        +'人'
        +'</span>'
    );

} else {
    $('.main-img').append('<img src="img/killer-win.png">');
    $('.main-title').append('<h2>杀手的胜利!</h2>');
    $('.main-text').append('<span>本次游戏用时0小时25分钟</span>'
        +'<br />'
        +'<span>'
        +'杀手：'
        + killers
        +'人'
        +'</span>'
        +'<span>'
        +'平民：'
        + (playNum - killers)
        +'人'
        +'</span>'
    );
}

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
            +'<div class="hour">'
            +'<span>'
            +'0小时07分'
            +'</span>'
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
            +'<div class="hour">'
            +'<span>'
            +'0小时07分'
            +'</span>'
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

function restartGame() {
    if (confirm('确定要重玩么？')) {
        sessionStorage.removeItem(
            'result','c1',
            'deadNums','deadNums',
            'role','allPlayers',
            'playerRoleTrans',
            'playBar','dayTime',
            'roleTime','allPeople',
            'myArr'
        );
        window.location.href = '玩家选择游戏页面.html';
    }
}