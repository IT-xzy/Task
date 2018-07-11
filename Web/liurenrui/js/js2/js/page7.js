console.log("js文件");

var Num = sessionStorage.getItem("Num"); //上一页面输入人数
var playArr = JSON.parse(sessionStorage.getItem("playArr")); //上一页面身份数组
var x = sessionStorage.getItem('x'); //判断杀人页面还是投票页面
console.log('页面状态：' + x + "页面");
var kiNum = sessionStorage.getItem('kiNum'); //杀手人数
var ciNum = sessionStorage.getItem('ciNum'); //平民人数
var deadArr = JSON.parse(sessionStorage.getItem("deadArr")); //死亡玩家数组    这里换个页面寸 这里要取出数组
var identity; //选中身份
var n; //选中的玩家数组角标
var y = sessionStorage.getItem('y') * 1; //天数
var chooseNum;

var playbox = $('.play-box');
for (var i = 0; i < Num; i++) {
    playbox.append(
        `<div class="player">
            <div class="play-t">` +
        playArr[i] +
        `</div>
            <div class="play-b">` +
        (i + 1) +
        `号</div>
        </div>`);
} //生成角色模块

var playerArr = $('.play-t'); //角色盒子数组
bgcolor();

function bgcolor() {
    for (var i = 0; i < playerArr.length; i++) {
        playerArr[i].style.background = "#fbb435";
    } //全部重置颜色
    for (var i = 0; i < deadArr.length; i++) {
        playerArr[deadArr[i]].style.background = "red";
    } //已死亡玩家背景红色
}; //重置背景颜色


window.onload = function () {
    if (x === "杀人") {
        $('header').text('杀手杀人');
        $('.mtt').html('杀手请睁眼<br>杀手请选择要杀的对象');
        $('.mtb').html('<span class="jiao"></span>点击下方玩家头像，对被击杀的玩家进行标记')
        $('#playgame').text('确定');
        kill();
    } else if (x === "投票") {
        $('header').text('玩家投票');
        $('.mtt').text('发言讨论结束，请大家投票');
        $('.mtb').html('<span class="jiao"></span>点击得票数量最多人的头像')
        $('#playgame').text('投死');
        vote();
    };
} //顶部文字和底部按钮文字

var outbox = document.getElementById('play-box');

function kill() { //杀人页面执行
    outbox.addEventListener('click', function (ev) {
        var ev = ev || window.event;
        var target = ev.target || ev.srcElement;
        while (target !== outbox) {
            if (target.className == 'player') {
                if (target.innerText.length == 7) {
                    n = target.innerText.substring(3, 5) - 1; //玩家序号
                } else if (target.innerText.length == 6) {
                    n = target.innerText.substring(3, 4) - 1; //玩家序号
                }
                bgcolor();
                console.log('玩家数组角标：' + n);
                if (playerArr[n].style.background != "red") {
                    if (target.innerText.substring(0, 2) == "杀手") {
                        alert("请选择平民"); //杀手只能杀平民
                    } else {
                        bgcolor();
                        playerArr[n].style.background = "red"; //点击的平民变色
                    }
                }else{
                    alert('请不要重复点击');
                }
                break;
            }
            target = target.parentNode;
        }
    })
} //杀手杀人

function vote() { //投票页面执行
    outbox.addEventListener('click', function (ev) {
        var ev = ev || window.event;
        var target = ev.target || ev.srcElement;
        while (target !== outbox) {
            if (target.className == 'player') {
                if (target.innerText.length == 7) {
                    n = target.innerText.substring(3, 5) - 1; //玩家序号
                } else if (target.innerText.length == 6) {
                    n = target.innerText.substring(3, 4) - 1; //玩家序号
                }
                bgcolor();
                console.log('玩家数组角标：' + n);
                if (playerArr[n].style.background != "red") {
                    playerArr[n].style.background = "red"; //点击的平民变色
                    if (target.innerText.substring(0, 2) == "杀手") {
                        identity = "杀手";
                    } else if (target.innerText.substring(0, 2) == "平民") {
                        identity = "平民";
                    }
                } else {
                    alert('请不要重复点击');
                }
                break;
            }
            target = target.parentNode;
        }
    })
} //玩家投票

$('#playgame').on('click', function () {
    chooseNum = 0;
    for (var i = 0; i < playerArr.length; i++) {
        if (playerArr[i].style.background == "red") {
            chooseNum = chooseNum + 1;
        }
    }
    console.log(chooseNum)
    console.log(deadArr.length)
    if (chooseNum > deadArr.length) {
        var noteArr = JSON.parse(sessionStorage.getItem("noteArr")); //法官笔记
        var cixuhao = sessionStorage.getItem('cixuhao') * 1
        switch (x) {
            case '杀人':
                ciNum = ciNum - 1; //平民减少一人   
                noteArr.push('第' + (y + 1) + '天晚上：' + (cixuhao + 1) + "号玩家被杀手杀死，" + (cixuhao + 1) + "号玩家的身份是平民。")
                break;
            case "投票":
                if (identity == "杀手") {
                    kiNum = kiNum - 1; //杀手减少一人             
                } else if (identity == "平民") {
                    ciNum = ciNum - 1; //平民减少一人
                }
                noteArr.push('第' + (y + 1) + '天白天：' + (cixuhao + 1) + "号玩家被投死，" + (cixuhao + 1) + "号玩家的身份是" + playArr[cixuhao])
                break;
        }
        sessionStorage.noteArr = JSON.stringify(noteArr);
        deadArr.push(n);
        sessionStorage.deadArr = JSON.stringify(deadArr);
        sessionStorage.cixuhao = n;
        sessionStorage.ciNum = ciNum;
        sessionStorage.kiNum = kiNum;
        gameover();
    } else {
        console.log('请选择玩家');
    }
});

function gameover() {
    if (kiNum <= 0) {
        sessionStorage.end = "平民胜利";
        alert('平民胜利');
        location.assign('page8.html')
    } else if (kiNum >= ciNum) {
        sessionStorage.end = "杀手胜利";
        alert('杀手胜利');
        location.assign('page8.html')
    } else {
        location.assign('page6.html');
    }
} //胜负判定