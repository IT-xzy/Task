
//获取之前页面储存的玩家号码，角色，并用到这个页面
var playNum = window.sessionStorage.getItem('playBar');
var day = JSON.parse(sessionStorage.getItem('dayTime'));
var c1 = JSON.parse(sessionStorage.getItem('c1'));
var deadNums = JSON.parse(sessionStorage.getItem('deadNums'));
var deadNum = JSON.parse(sessionStorage.getItem('deadNum'));
var allPlayers=JSON.parse(sessionStorage.getItem('allPlayers'));
// var playBoy = JSON.parse(sessionStorage.getItem('playerRoleTrans'));
// console.log(playBoy);

console.log(playNum);
console.log(day);
// console.log(c1);
console.log(deadNums);
// console.log(deadNum);

if (deadNums === null) {
    console.log('Grrrrr');
} else {
    deadNum.push(deadNums[deadNums.length - 1]);
}
//最简单的数组去重方法
var n = []; //这是一个新的临时数组
function unique1(array) {
    //遍历当前数组
    for (var i = 0; i < array.length; i++) {
        //如果当前数组的第i项已经保存进了临时数组，那么就跳过执行
        //否则把当前项push到临时数组里
        if (n.indexOf(array[i]) === -1) {
            n.push(array[i]);
        }
    }
    return n;
}
unique1(deadNum);

sessionStorage.setItem('n',JSON.stringify(n));
sessionStorage.setItem("deadNum",JSON.stringify(deadNum));
console.log(deadNum);

$('.day-by-day').html('第' + day + '天');
// console.log(day);
//
//forEach遍历数组，打印死亡人数
var deadPerson = 0;

allPlayers.forEach(function (item,index) {
    console.log(item.state);
    if (item.state === 0) {
        deadPerson++;
    }
});
console.log(deadPerson);
//判断死亡人数是否能被整除，能整除是刚投了票，保持蓝色；不能整除就是刚杀了人，保持灰色
if (deadPerson % 2 === 0) {
    console.log('能整除是投了票，可以进入下一天了！');
} else {
    if (c1 === 'rgb(42, 188, 223)') {  //蓝色
        $('#killerAction').css({
            'backgroundColor' : '#eaeaea',  //变灰色
            'pointerEvents' : 'none',   //元素永远不会成为鼠标事件的目标
            'cursor' : 'notAllowed'     //一个红色的圈加一个斜杠,不可点击
        });
    }
    console.log('不能整除就是刚杀了人，杀手按钮保持灰色');
}

//点击后进入杀手杀人界面
function Click1() {
    var role = 0;
    var c = $('#killerAction').css('backgroundColor');
    window.sessionStorage.setItem('roleTime', role);
    $('#killerAction').css({
        'backgroundColor' : '#eaeaea',
        'pointerEvents' : 'none',   //元素永远不会成为鼠标事件的目标
        'cursor' : 'notAllowed'     //一个红色的圈加一个斜杠,不可点击
    });
    sessionStorage.setItem('c1', JSON.stringify(c));
    console.log(c);
    window.location.href = '杀人页面.html';
}

var afterKill = JSON.parse(sessionStorage.getItem('allPlayers'));
console.log(afterKill);


//点击后请亡灵发言
function Click2() {
    if ($('#killerAction').css('background-color') === 'rgb(42, 188, 223)') {
        alert('请完成上一步操作');
    } else {
        console.log($('#killerAction').css('backgroundColor') );
        $('#deadSpeak').css({
            'backgroundColor' : '#eaeaea',
            'pointerEvents' : 'none',   //元素永远不会成为鼠标事件的目标
            'cursor' : 'notAllowed'     //一个红色的圈加一个斜杠,不可点击
        });
        alert('出局玩家请发言');
    }
}
//点击后请剩余玩家发言
function Click3() {
    if ($('#deadSpeak').css('backgroundColor') === 'rgb(42, 188, 223)') {
        alert('请完成上一步操作');
    } else {
        $('#aliveSpeak').css({
            'backgroundColor' : '#eaeaea',
            'pointerEvents' : 'none',   //元素永远不会成为鼠标事件的目标
            'cursor' : 'notAllowed'     //一个红色的圈加一个斜杠,不可点击
        });
        alert('请活着的玩家发言');
    }
}

//将杀手杀死的平民state：0传递到本页面
// var killed = JSON.parse(sessionStorage.getItem('myArr'));
// console.log(killed);
//点击后进入全民投票环节
function Click4() {
    var role = 1;
    if ($('#aliveSpeak').css('backgroundColor') === 'rgb(42, 188, 223)') {
        alert('请完成上一步操作');
    } else {
        window.location.href = '玩家投票页面.html';
        window.sessionStorage.setItem('roleTime',role);
        $('#playerVote').css({
            'backgroundColor' : '#eaeaea',
            'pointerEvents' : 'none',   //元素永远不会成为鼠标事件的目标
            'cursor' : 'notAllowed'     //一个红色的圈加一个斜杠,不可点击
        });
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
function logNote() {
    window.location.href = '法官查看日志.html';
}
