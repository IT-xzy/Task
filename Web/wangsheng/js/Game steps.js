var backBtn = document.getElementById("backBtn"),
    closeBtn = document.getElementById("closeBtn"),
    lastDay = document.getElementById("lastDay"),
    flowChart = document.getElementById("flowChart"),
    kill = document.getElementById("kill"),
    lastWords = document.getElementById("lastWords"),
    speak = document.getElementById("speak"),
    vote = document.getElementById("vote"),
    gameOver = document.getElementById("gameOver"),
    judgeLog = document.getElementById("judgeLog");

//添加天数到storage中
var day = 1;
if (!sessionStorage.day) {
    sessionStorage.setItem("day", day);
} else {
    day = sessionStorage.day;
}
//添加天数循环的内容
var wrap = document.getElementById("wrap");
var container = document.getElementById("container");
var num1, //每天被杀玩家的序号
    num2; //每天被投死玩家的序号
if (Boolean(sessionStorage.array)) {
    for (var i = 0; i < JSON.parse(sessionStorage.array).length; i++) {
        if (JSON.parse(sessionStorage.array)[i].state == "dead" && JSON.parse(sessionStorage.array)[i].how == "kill") {
            num1 = JSON.parse(sessionStorage.array)[i].num;
            console.log(num1);
        }
        if (JSON.parse(sessionStorage.array)[i].state == "dead" && JSON.parse(sessionStorage.array)[i].how == "vote") {
            num2 = JSON.parse(sessionStorage.array)[i].num;
            console.log(num2);
        }
    }
}

for (var i = 1; i < day; i++) {
    var article = document.createElement("article");
    var num__kill,
        num__vote,
        identity__kill,
        identity__vote;
    for (var j = 0; j < JSON.parse(sessionStorage.array).length; j++) {
        if (JSON.parse(sessionStorage.array)[j].date == i && JSON.parse(sessionStorage.array)[j].state == "dead" && JSON.parse(sessionStorage.array)[j].how == "kill") {
            num__kill = JSON.parse(sessionStorage.array)[j].num;
            identity__kill = JSON.parse(sessionStorage.array)[j].identity;
        }
        if (JSON.parse(sessionStorage.array)[j].date == i && JSON.parse(sessionStorage.array)[j].state == "dead" && JSON.parse(sessionStorage.array)[j].how == "vote") {
            num__vote = JSON.parse(sessionStorage.array)[j].num;
            identity__vote = JSON.parse(sessionStorage.array)[j].identity;
        }
    }
    if (num__kill) {
        article.innerHTML = '<article class="container">' +
            '<section class="date">' +
            '<p class="day">第' + i + '天</p>' +
            '</section>' +
            '<main class="main">' +
            '<ul class="time-line">' +
            '<li class="night-time"></li>' +
            '<li class="shortLine"></li>' +
            '<li class="day-time"></li>' +
            '<li class="longLine"></li>' +
            '</ul>' +
            '<ul class="event-line">' +
            '<li class="item__unClickable">杀手杀人</li>' +
            '<li class=result>' + num__kill + '号被杀死，真实身份是' + identity__kill + '</li>' +
            '<li class="item__unClickable">亡灵发表遗言</li>' +
            '<li class="item__unClickable">玩家依次发言</li>' +
            '<li class="item__unClickable">全民投票</li>' +
            '<li class="result">' + num__vote + '号被投票投死了，真实身份是' + identity__vote + '</li>' +
            '</ul>' +
            '</main>' +
            '</article>';
        wrap.appendChild(article);
        num__kill = NaN;
    } else {
        article.innerHTML = '<article class="container">' +
            '<section class="date">' +
            '<p class="day" id="day">第' + i + '天</p>' +
            '</section>' +
            '<main class="main" id="flowChart' + i + '">' +
            '<ul class="time-line">' +
            '<li class="night-time"></li>' +
            '<li class="shortLine"></li>' +
            '<li class="day-time"></li>' +
            '<li class="longLine"></li>' +
            '</ul>' +
            '<ul class="event-line">' +
            '<li class="item__unClickable">杀手杀人</li>' +
            '<li class=result>' + '杀手没有杀人' + '</li>' +
            '<li class="item__unClickable">亡灵发表遗言</li>' +
            '<li class="item__unClickable">玩家依次发言</li>' +
            '<li class="item__unClickable">全民投票</li>' +
            '<li class="result">' + num__vote + '号被投票投死了，真实身份是平民' + '</li>' +
            '</ul>' +
            '</main>' +
            '</article>';
        wrap.appendChild(article);
    }

}
days = document.querySelectorAll(".day");
mains = document.querySelectorAll(".main");
for (var i = 0; i < day; i++) {
    (function (i) {
        days[i].onclick = function () {
            var style = mains[i].style;
            style.display = style.display == "flex" ? "none" : "flex";
        };
    })(i);
}

if (sessionStorage.killResult) {
    var killResult = document.createElement("li");
    killResult.classList.add("result");
    killResult.textContent = JSON.parse(sessionStorage.getItem("killResult"));
    document.getElementById("eventLine").insertBefore(killResult, lastWords);
    document.getElementById("shortLine").style.height = "64px";
}


//头部按钮设置点击事件
backBtn.addEventListener("click", function () {
    window.location.href = "judge.html";
    sessionStorage.back = "back";
}, false);

closeBtn.addEventListener("click", function () {
    if (confirm("确定关闭？")) {
        window.location.href = "type of play.html";
        sessionStorage.clear();
    }
}, false);

lastDay.textContent = "第" + day + "天";
flowChart.style.display = "flex";

//  设置流程按钮点击事件

var killState = sessionStorage.getItem("killState");
if (killState === "unClickable") {
    kill.className = "item__unClickable";
}
kill.addEventListener("click", function () {
    if (killState === "unClickable") {
        alert("请点击下一项");
    } else {
        window.location.href = "kill.html";
        var page = "kill";
        sessionStorage.setItem("page", page);
    }
}, false);

var lastwordsState = "clickable";
lastWords.addEventListener("click", function () {
    if (killState !== "unClickable") {
        alert("请按顺序点击");
    } else if (lastwordsState === "unClickable") {
        alert("请点击下一项");
    } else {
        lastWords.className = "item__unClickable";
        lastwordsState = "unClickable";
        alert("亡灵请发表遗言");
    }
}, false);

var speakState = "clickable";
speak.addEventListener("click", function () {
    if (lastwordsState !== "unClickable") {
        alert("请按顺序点击");
    } else if (speakState === "unClickable") {
        alert("请点击下一项");
    } else {
        speak.className = "item__unClickable";
        speakState = "unClickable";
        alert("请玩家依次发言");
    }
}, false);

vote.addEventListener("click", function () {
    if (speakState !== "unClickable") {
        alert("请按顺序点击");
    } else {
        sessionStorage.setItem("page", "vote");
        window.location.href = "kill.html";
    }

}, false);
judgeLog.addEventListener("click", function () {
    window.location.href = "judge.html";
    sessionStorage.removeItem("back");
}, false);

gameOver.addEventListener("click", function () {
    if (confirm("确定关闭？")) {
        window.location.href = "type of play.html";
        sessionStorage.clear();
    }
}, false);