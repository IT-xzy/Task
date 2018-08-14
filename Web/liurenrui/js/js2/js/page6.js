console.log("js文件");

var n = 0; //点击次数
var y = 0;//天数
var playArr = JSON.parse(sessionStorage.getItem("playArr")); //上一页面身份数组

$('#back').on('click', function () {
    alert('返回就乱了');
}); //左上角返回按钮
$('#close').on('click', close); //右上角关闭按钮
function close() {
    var message = confirm("是否结束本轮游戏？"); //是否确定
    if (message) {
        location.replace('page2.html'); //返回首页
    }
}

window.onload = function () {
    var x = sessionStorage.getItem("x");
    y = Number(sessionStorage.getItem('y'));
    $('.dayNum').html('第'+(y+1)+'天');
    var cixuhao = sessionStorage.getItem('cixuhao') *1
    if (x == "杀人") {
        $('.p1').addClass('p5');
        $('.jiao1').addClass('jiao5');   
        n=1;
        $('#record1').text('第'+(y+1)+'天晚上：'+(cixuhao+1)+"号玩家被杀手杀死，"+(cixuhao+1)+"号玩家的身份是平民。" );
    } else if (x == "投票") {
        y = Number(sessionStorage.getItem('y'));
        $('.dayNum').html('第'+(y+1)+'天');
        $('#record2').text('第'+(y+1)+'天白天：'+(cixuhao+1)+"号玩家被投死，"+(cixuhao+1)+"号玩家的身份是"+playArr[cixuhao] )
    }
}

$('.p1').on('click', function () {
    $('.p1').addClass('p5');
    $('.jiao1').addClass('jiao5');
    sessionStorage.x = "杀人";
    sessionStorage.y=y;
    n++;
    location.assign('page7.html');
    console.log(n);
}); //杀手杀人

$('.p2').on('click', function () {
    if (n === 1) {
        $('.p2').addClass('p5');
        $('.jiao2').addClass('jiao5');
        n++;
        console.log(n);
        alert("请亡灵发表遗言！");
    } else {
        alert("请按顺序进行！");
    }
}) //亡灵发表遗言

$('.p3').on('click', function () {
    if (n === 2) {
        $('.p3').addClass('p5');
        $('.jiao3').addClass('jiao5');
        n++;
        console.log(n);
        alert("请玩家依次发言！");
    } else {
        alert("请按顺序进行！");
    }
}) //玩家依次投票

$('.p4').on('click', function () {
    if (n === 3) {
        $('.p4').addClass('p5');
        $('.jiao4').addClass('jiao5');
        sessionStorage.x = "投票";
        sessionStorage.y=y+1;
        n++;
        console.log(n);
        location.assign('page7.html');
    } else {
        alert("请按顺序进行！");
    }
}) //全体玩家投票

$('#finish').on('click', close); //下面关闭游戏按钮
function close() {
    var message = confirm("是否结束本轮游戏？"); //是否确定
    if (message) {
        location.replace('page2.html'); //返回首页
    }
}
$('#note').on('click',function(){
    location.assign('page9.html');
})