var log = console.log;
// 定义所有初始化变量

var gamersVote = document.getElementById('gamersVote'), //游戏容器
    pageTitle = document.getElementById('result'), //页面标题
    speak = document.getElementById('speak'), //大标题
    smallTitle = document.querySelector('.v-title'), //小标题
    close = document.getElementById('closeBtn'), //关闭按钮
    skip = document.getElementById('btn-skip'), //跳转按钮
    titleContainer = document.querySelector('.audio-container');


//拿到玩家数据//获取上一页玩家信息，这是第一次跳转页面获得的数据
var playerStr = sessionStorage.getItem('playersMsg'),
    playersMsg = JSON.parse(playerStr),
    playersArr = playersMsg.random,
    len = playersArr.length;
//进入杀手杀人页，或者玩家投票页拿到相关数据，第一次的话则赋值为null
var gamersStr = sessionStorage.getItem('gamersMsg') || 'null',
    gamersMsg = JSON.parse(gamersStr),
    gamerNum, //用于存放死亡玩家的序号
    gamerId; //用于存放死亡玩家的身份

log(gamersMsg);
//循环出所有的dom盒子,IIFE的形式，不会造成全局的变量污染。
(function () {
    var domStr = '';
    for (var i = 0; i < len; i++) {
        domStr += ` <div class="vote-container">
                        <div class="gamer">
                            <span class="gamer-id">${playersArr[i]}</span>
                            <span class="gamer-num">${i+1}号</span>
                            <div class="gamer-select">
                                <i class="kill"></i>
                            </div>
                        </div>
                    </div>`;
    }
    gamersVote.innerHTML = domStr;
})();

var voteBox = document.getElementsByClassName('vote-container');
//通过判断玩家数据是否存在渲染相关页面
//分三个状态，第一次进入该页面，按钮是开始游戏，标题是法官日记
//第二个状态就是杀手杀人页面
//第三个状态就是玩家投票页面
if (gamersMsg) {
    //这里按钮值是确定
    skip.innerText = "确定";
    if (gamersMsg.Alldead.length != 0) {
        for (var i = 0; i < gamersMsg.Alldead.length; i++) {
            voteBox[gamersMsg.Alldead[i] - 1].getElementsByClassName('gamer-id')[0].style.background = "red";
        }
    }

    //杀手杀人页面
    if (gamersMsg.kill) {
        //渲染数据
        pageTitle.innerText = "杀手杀人";
        speak.innerText = "杀手请睁眼，选择要杀的对象";
        smallTitle.innerText = "点击下方玩家头像，对被杀的玩家进行标记";
    }
    //玩家投票页面
    if (gamersMsg.vote) {
        //渲染数据
        pageTitle.innerText = "投票";
        speak.innerText = "发言讨论结束，大家请投票";
        smallTitle.innerText = "点击得票数最多的人的头像";
    }
} else {
    //第一次进入页面，渲染数据
    pageTitle.innerText = "法官日记";
    skip.innerText = "开始游戏";
    titleContainer.style.display = "none";
    //建立最初的数据,准备传入到法官台本页
    var initialMsg = {
        days: 1,
        kill: null,
        vote: null,
        killData: {
            total: playersMsg.killers,
            alive: playersMsg.killers,
            dead: 0
        },
        popData: {
            total: playersMsg.pops,
            alive: playersMsg.pops,
            dead: 0
        },
        idArr: playersMsg.random,
        killed: [],
        voted: [],
        Alldead: [],
        canKill: false,
        dead: false
    };
    //使用sessionStorge进行传参
    var initialStr = JSON.stringify(initialMsg);
    sessionStorage.setItem('initialMsg', initialStr);
}




//通过按钮里面的innerText的内容
skip.onclick = function () {
    if (gamersMsg) {
        var days = gamersMsg.days;
        //把取得数据放入gamersMsg中

        if (gamersMsg.dead) {
            alert('此玩家已死，请勿重复选择');
            return;
        }
        //杀手杀人页面
        if (gamersMsg.kill) {
            //确报是今天杀手杀人页面
            for (var i = 0; i < gamersMsg.days; i++) {
                //不选择玩家，则会弹窗
                if (gamerNum == undefined) {
                    alert('请选择杀一个人');
                    return;
                }
                if (i == days - 1) {
                    if (!gamersMsg.canKill) {
                        alert('sorry，杀手不能杀杀手');
                        return;
                    } else {
                        gamersMsg.popData.alive -= 1;
                        gamersMsg.popData.dead += 1;
                        gamersMsg.Alldead.push(gamerNum);
                        gamersMsg.killed.push(gamerNum);
                    }
                }
            }
        }
        //玩家投票页面
        if (gamersMsg.vote) {
            //不选择玩家，则会弹窗
            if (gamerNum == undefined) {
                alert('请投票');
                return;
            }
            gamersMsg.days += 1;
            gamersMsg.voted.push(gamerNum);
            gamersMsg.Alldead.push(gamerNum);
            if (gamerId == '杀手') {
                gamersMsg.killData.alive -= 1;
                gamersMsg.killData.dead += 1;

            } else {
                gamersMsg.popData.alive -= 1;
                gamersMsg.popData.dead += 1;
            }

        }
        var gamersStr = JSON.stringify(gamersMsg);
        sessionStorage.setItem('newGameMsg', gamersStr);
        //判断游戏是否结束
        if (gamersMsg.popData.alive <= gamersMsg.killData.alive || gamersMsg.killData.alive === 0) {
            alert('游戏已经结束');
            window.location.href="result-1.html";
            return;
        }

        log(gamersMsg);
    }

    //跳转页面
    window.location.href = "judePlay.html";
};


// 杀人图标只有在杀人投票页才会出现
$('.gamer').on('click', function () {
    if (gamersMsg) {
        var show = $(this).find('.gamer-select'), //点击本次的小刀图标
            all = $(".gamer-select"); //获取所有小刀图标
        all.css('display', 'none'); //每次点击前重置小刀图标
        show.toggle(); //点击让其出现和消失
        gamerNum = $(this).parent().index() + 1; //获取父级按钮的下表
        //使用find方法依然可以获取玩家次序
        // parseInt($(this).find('.gamer-num').text())

        gamerId = $(this).find('.gamer-id').text(); //获取玩家身份
        if (gamersMsg.Alldead.indexOf(gamerNum) == -1) {
            gamersMsg.dead = false;
        } else {
            gamersMsg.dead = true;
            return;
        }
        //杀人阶段
        if (gamersMsg.kill) {
            if (gamerId === '杀手') {
                gamersMsg.canKill = false;
            } else {
                gamersMsg.canKill = true;
            }

        }
        //投票阶段

    }
});





































//关闭页面
close.addEventListener('click', function () {
    var r = confirm("您确定离开游戏吗？");
    if (r == true) {
        window.location.href = "headerPage.html";
    }
}, false);