//DOM操作
var home = document.getElementById("home"), // 头部按钮
    resultImg = document.getElementById("resultImg"),//图片
    resultText = document.getElementById("resultText"),//黄色文字
    gameAgain = document.getElementById("gameAgain"),//底部按钮
    day = sessionStorage.day;//总共进行的天数
    // console.log(home);
    // console.log(resultImg);
    // console.log(resultText);
    console.log(day);

//头部按钮，返回主页
home.addEventListener("click", function () {
    window.location.href = "type of play.html";
    sessionStorage.clear();
}, false);
//底部按钮，返回主页
gameAgain.addEventListener("click", function () {
    window.location.href = "type of play.html";
    sessionStorage.clear();
}, false);
//解析json数据，并按filter的筛选规则，得到新的数组并取他的数组长度
//array是一个数组，长度是玩家的总人数，数组里存放的是对象
array = JSON.parse(sessionStorage.array);
console.log(array);
//杀手总人数
killNum = array.filter(function (item, index, array) {
    //满足if 执行提前跳出，结束循环，不再执行return 后面的语句，写在函数也如此
    //循环里进行判断某条件  符合的话结束循环
    for (var i = 0; i < array.length; i++) {
        if (item.identity == "杀手") {
            return item;
        }
    }
}).length;
//平民总人数
civilianNum = array.filter(function (item, index, array) {
    for (var i = 0; i < array.length; i++) {
        if (item.identity == "平民") {
            return item;
        }
    }
}).length;

if (sessionStorage.gameResult == "玩家胜利") {
    resultImg.src = "../img/civilianResult.png";
    resultText.textContent = "本轮游戏共抓出杀手" + killNum + "人，共经历了" + day + "个白天，在杀人游戏中击败了67%的玩家";
} else if (sessionStorage.gameResult == "杀手胜利") {
    resultImg.src = "../img/killResult.png";
    resultText.textContent = "太棒了!你知道么？在杀人游戏中只有20%的杀手取得游戏最终的胜利哦";
}
//DOM操作，杀手多少人，平民多少人
document.getElementById("killNum").textContent = "杀手 " + killNum + "人";
document.getElementById("civilianNum").textContent = "平民 " + civilianNum + "人";
//列表部分，列表的全部
var gameProcess = document.getElementById("gameProcess");

//该for循环表示游戏结果，白色部分 全部
for (var i = 1; i < day || i == day; i++) {
    var num__kill,
        num__vote,
        identity__kill,
        identity__vote;
    for (var j = 0; j < JSON.parse(sessionStorage.array).length; j++) {
        //晚上
        if (JSON.parse(sessionStorage.array)[j].date == i && JSON.parse(sessionStorage.array)[j].state == "dead" && JSON.parse(sessionStorage.array)[j].how == "kill") {
            num__kill = JSON.parse(sessionStorage.array)[j].num;
            identity__kill = JSON.parse(sessionStorage.array)[j].identity;
        }
        //白天
        if (JSON.parse(sessionStorage.array)[j].date == i && JSON.parse(sessionStorage.array)[j].state == "dead" && JSON.parse(sessionStorage.array)[j].how == "vote") {
            num__vote = JSON.parse(sessionStorage.array)[j].num;
            identity__vote = JSON.parse(sessionStorage.array)[j].identity;
        }
    }
    //样式部分 DOM操作 动态设置样式
    var processList = document.createElement("ul");
    processList.classList.add("process-list");
    if (num__kill && num__vote) {
        processList.innerHTML = '<li class="time">第' + i + '天<span>0小时07分</span></li>' +
            '<li>晚上：' + num__kill + '号被杀手杀死，' + num__kill + '号是平民</li>' +
            '<li>白天：' + num__vote + '号被全民投票投死，' + num__vote + '号是' + identity__vote + '</li>';
        // num__kill = NaN;
        // num__vote = NaN;
    }
    // else if (!num__kill && num__vote) {
    //     processList.innerHTML = '<li class="time">第' + i + '天<span>0小时07分</span></li>' +
    //         '<li>晚上：没有任何操作</li>' +
    //         '<li>白天：' + num__vote + '号被全民投票投死，' + num__vote + '号是' + identity__vote + '</li>';
    //     num__kill = NaN;
    //     num__vote = NaN;
    // }
    // else if (num__kill && !num__vote) {
    //     processList.innerHTML = '<li class="time">第' + i + '天<span>0小时07分</span></li>' +
    //         '<li>晚上：' + num__kill + '号被杀手杀死，' + num__kill + '号是平民</li>';
    //     num__kill = NaN;
    //     num__vote = NaN;
    // }
    gameProcess.appendChild(processList);
}