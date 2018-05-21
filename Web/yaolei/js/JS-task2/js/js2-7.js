var player = JSON.parse(localStorage.getItem('object'));
console.log(player);
var d = JSON.parse(sessionStorage.getItem('data3'));
var i = 0;
//当投票时候未选中玩家
var n = '';
//当杀手时候未选中玩家
var m = '';
//获取URL数据
var url = location.search,
    str = url.substr(1);
console.log(str);
//创建一个按钮
var e =
    '<div class="child" >' +
    '<button class="hover1"></button>' +
    '</div>';
//生成玩家格子
var base = (function () {
    for (var i = 0; i < player.length; i++) {
        $(".main2").append(d);
        ab = document.getElementsByClassName('div8');
        cd = document.getElementsByClassName('div9');
        ab[i].innerHTML = player[i].name;
        cd[i].innerHTML = Number(i + 1) + '号';
        $('body').css('backgroundColor', '#29bde0');
    }
    $('.button2').after(e);
})();
//控制刀的显示和玩家格子的DOM
var child = document.getElementsByClassName('child');
var role = document.getElementsByClassName('role');
//杀手杀人页头
function killSkip(){
    var killPage = "<div class=tip><p class=top>杀手请睁眼，杀手请选择要杀的对象</p><div class=downsj></div><p class=bot>点击下方玩家头像，对被杀的玩家进行标记</p></div>";
    $("header").append(killPage);
    $(".game").text("确定");
}
//玩家投票页头
function voteSkip(){
    var votePage = "<div class=tip><p class=top>发言讨论结束，大家请投票</p><div class=downsj></div><p class=bot>点击得票数最多的人的头像</p></div>";
    $("header").append(votePage);
    $(".game").text("投他一票");
}
function page() {
    //杀手步骤
    if (str === 'kill') {
        //加载页头
        killSkip();
        for (var i = 0; i < player.length; i++) {
            //如果参数名为kill则开始判断玩家状态，state不为true的渲染死亡状态颜色
            if (player[i].state === false) {
                ab[i].style.backgroundColor = '#8ab09a';
            }
            (function (i) {
                role[i].onclick = function () {
                    if (player[i].state === false) {
                        alert('你口味真重');
                    } else if (player[i].name === '杀手') {
                        alert('他是你亲哥！');
                    }
                    else {
                        for (var j = 0; j < player.length; j++) {
                            $('.child').hide();
                            player[j].click = 0;
                            child[i].style.display = 'block';
                            player[i].click = 1;
                            console.log(player[i]);
                            console.log(player[j]);
                            m = j;
                        }
                    }
                }
            })(i)
        }
    }
    //投票
    else if (str === 'vote') {
        //加载投票页眉
        voteSkip();
        for (var i = 0; i < player.length; i++) {
            //重置底色
            if (player[i].state === false) {
                ab[i].style.backgroundColor = '#8ab09a';
            }
            (function (i) {
                role[i].onclick = function () {
                    if (player[i].state === false) {
                        alert('雅蠛蝶');
                    } else {
                        for (var j = 0; j < player.length; j++) {
                            $('.child').hide();
                            player[j].click = 0;
                            child[i].style.display = 'block';
                            player[i].click = 1;
                            console.log(player[j]);
                            n = j;
                        }
                    }
                }
            })(i);
        }
    }
}page();
//统计杀手和平民存活数
var manNum = Number(JSON.parse(sessionStorage.getItem('manNum')));
var killerNum = Number(JSON.parse(sessionStorage.getItem('killerNum')));
//杀人页面确定按钮
$('.play-game').click(function () {
    //杀手操作
    if (str === 'kill') {
        if(m !== ''){//判断是否点击玩家图标
            for (var i = 0; i < player.length; i++){
                for (var j = 0; j < player.length; j++) {
                    if (player[j].click === 1) {
                        player[j].state = false;
                        player[j].dead = str;
                        player[j].deathDay = Number(sessionStorage.getItem('day'));
                        console.log(player[i]);
                        var one = JSON.stringify(player);
                        localStorage.object = one;
                    }
                }
                //判定存活数量判断是否胜利
                if(player[i].state === false && player[i].name === '平民' && player[i].click === 1){
                    manNum = manNum - 1;
                    sessionStorage.setItem('manNum',manNum);
                    if(manNum === 0){
                        window.location.href = 'js2-8.html?killerWin'
                    }
                    else {window.location.href = 'js2-6.html?vote'
                    }
                }
            }
        }else {window.location.href = 'js2-6.html?noKill'}//没有点击页面,上传参数跳转
    }
    else if(str === 'vote') {
        var day1 = Number(sessionStorage.getItem('day'));
        if(n !== '') {//判断是否点击
            for (var j = 0; j < player.length; j++) {
                if (player[j].click === 1 && player[j].deathDay === 0) {
                    player[j].state = false;
                    player[j].dead = str;
                    player[j].deathDay = Number(day1);
                    var one = JSON.stringify(player);
                    localStorage.object = one;
                }
            }
        }else {alert('必须投票')}
        for (var i = 0; i < player.length; i++) {
            //先判断是否有点击并且有玩家死亡
            if (player[i].state === false && n !== ''){
                //有则判定谁被点击,被点击即被杀，人数-1
                if(player[i].name === '平民' && player[i].click === 1) {
                    manNum = manNum - 1;
                    sessionStorage.setItem('manNum', manNum);
                    //如果平民人数=0则判定杀手胜利并且跳转
                    if (manNum === 0) {
                        window.location.href = 'js2-8.html?killerWin'
                    } else {
                        //人数不为0则跳回天数页循环
                        day1 = day1 + 1;
                        sessionStorage.setItem('day', day1);
                        window.location.href = 'js2-6.html'
                    }
                }
                else if (player[i].name === '杀手' && player[i].click === 1) {
                    killerNum = killerNum - 1;
                    sessionStorage.setItem('killerNum', killerNum);
                    //杀手=0则平民胜利并跳转
                    if (killerNum === 0) {
                        window.location.href = 'js2-8.html?peopleWin'
                    } else {
                        //人数不为0则跳回天数页循环
                        day1 = day1 + 1;
                        sessionStorage.setItem('day', day1);
                        window.location.href = 'js2-6.html'
                    }
                }
            }
        }
    }
});
$('.back').click(function () {
    window.location.href = 'js2.html'
});


