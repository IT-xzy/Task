// 缓存cache状态第四部用
ab = JSON.parse(window.sessionStorage.getItem('cache'));
if (ab == null) {
    var all = JSON.stringify(ab);
    all = sessionStorage.ab;
    var ab = JSON.parse(all);
}   

// 玩家包含身份序号数组
// 循环遍历玩家数组
for (a = 0; a < ab.length; a++) {
    $("main").append('<div class="item"><p class="id"><span>' + ab[a].role + '</span></p><p class="number">' + (a + 1) + '号</p><p class="choose"><img src="./img/kill.png" alt=""></p></div>');
    if (ab[a].state == "dead") {
        $(".id").eq(a).addClass("another");
    }
}

if (sessionStorage.getItem('killed') == undefined) {
    // 死人数组
    var killed = [];
} else {
    var killed = JSON.parse(sessionStorage.getItem('killed')); // 本地存储中已经存储了天数
}


// 获取游戏步骤杀手杀人按钮传递的参数
var gameother = window.sessionStorage.getItem('game');
// console.log(gameother);

// 判断1为杀手杀人页面
if (gameother == "1") {
    $(".item").click(function (e) {
        // 重置所有的id背景色
        // 为什么自己会想着覆盖类名，添加css样式，直接清除another类就可以
        for (m = 0; m < ab.length; m++) {
            if (ab[m].state !== "dead") {
                $(".id").eq(m).removeClass("another");
            }
        }
        // 点击的盒子的索引
        var q = $(".item").index($(this));
        // 这里的item是盒子的最外层类名，如果填入id,index将不起作用，具体原因百度也不知道
        //  :eq() 选择器选取带有指定 index 值的元素。
        // 输出结果为选取的元素的下标
        if (ab[q].role == "平民" && ab[q].state !== "dead") {
            // this指向的问题
            $(".id").eq(q).addClass("another");
            console.log((q + 1) + "号被选中");
            // 死者的序号
            sessionStorage.setItem("diemoon", q + 1);
        } else {
            alert("自己人！杀平民啊！");
        }
    })
}

// 判断4为投票页面
if (gameother == "4") {
    $("header").find("p").text("全民投票");
    $(".please").text("发言讨论结束，大家请投票");
    $(".item").click(function (e) {
        // 重置所有的id背景色
        // 为什么自己会想着覆盖类名，添加css样式，直接清除another类就可以
        for (m = 0; m < ab.length; m++) {
            $(".id").eq(m).removeClass("another");
            if (ab[m].state == "dead") {
                $(".id").eq(m).addClass("another");
            }
        }
        // 点击的盒子的索引
        var q = $(".item").index($(this));
        if (ab[q].state !== "dead") {
            $(".id").eq(q).addClass("another");
            sessionStorage.setItem("diesun", q + 1);
        } else {
            alert("你不能选择已死之人！")
        }
        console.log((q + 1) + "号被选中");
    })
}

$(".confirm").click(function () {
    var diemoon = window.sessionStorage.getItem("diemoon");
    // var diemoon = parseInt(sessionStorage.getItem("diemoon"));
    killed.push(parseInt(diemoon));

    ab[diemoon - 1].state = "dead";
    if (sessionStorage.getItem('diesun') !== null) {
        // var diesun = parseInt(sessionStorage.getItem("diesun"));
        var diesun = window.sessionStorage.getItem("diesun");
        killed.push(parseInt(diesun));
        ab[diesun - 1].state = "dead";
    }
    // es6一句去重
    killed = Array.from(new Set(killed));
    console.log(killed);
    // 缓存死人
    window.sessionStorage.setItem('killed', JSON.stringify(killed));
    // 缓存变化的数组
    window.sessionStorage.setItem('cache', JSON.stringify(ab));
    // 步骤跳转
    window.location.href = "task4-1.html";
    window.sessionStorage.setItem('gameother', gameother);

    var killerLive = 0, //杀手人数
        civilianLive = 0; //平民人数
    for (var f = 0; f < ab.length; f++) {
        if (ab[f].role === '杀手' && ab[f].state === 'alive') {
            killerLive++;
        } else if (ab[f].role === '平民' && ab[f].state === 'alive') {
            civilianLive++;
        }
    }
    // 循环进行之后再存储
    sessionStorage.setItem("civilianLive", civilianLive);
    sessionStorage.setItem("killerLive", killerLive);
    if (killerLive >= civilianLive || killerLive === 0) {
        var win = (killerLive === 0) ? '平民胜利' : '杀手胜利';
        sessionStorage.setItem("win", win);
        console.log(win);
        window.location.href = 'task4-3.html';
    }
})