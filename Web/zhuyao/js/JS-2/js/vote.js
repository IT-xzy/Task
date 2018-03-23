var players = sessionStorage.getItem("players").split(",");
var main = document.getElementsByTagName("main")[0];
var playerConts = document.getElementsByClassName("player-cont");
var btn = document.getElementById("determine");

//用对象来存储角色状态，然后保存在一个数组里
var person = [];
for (i = 0; i < players.length; i++) {
    person[i] = {
        id: players[i],
        num: i,
        state: true,
        deadWay: ""
    };
}

//为页面添加角色框
for (var i = 1; i <= players.length; i++) {
    var div = document.createElement("div");
    var identity = document.createElement("p");
    var num = document.createElement("p");
    div.className = "player-cont";
    identity.className = "player-details";
    num.className = "player-num";
    main.appendChild(div);
    div.appendChild(identity);
    div.appendChild(num);
    identity.textContent = players[i - 1];
    num.textContent = i + "号";
}

//利用事件委托添加点击事件，点击角色图框出现小刀图标
main.addEventListener('click', function (e) {
    var et = e.target, ec = e.currentTarget;
    if (et !== ec) {
        for (var i = 0; i < playerConts.length; i++) {
            playerConts[i].classList.remove("knife");
        }
    }
    if (e.target && e.target.parentNode.tagName.toLowerCase() === "div" && !e.target.parentNode.classList.contains("dead-color")) {
        e.target.parentNode.classList.add("knife");
    }
}, false);

//得到有杀人标记的角色的对应数字
var getNum = function () {
    for (i = 1; i < playerConts.length + 1; i++) {
        if (playerConts[i - 1].classList.contains("knife")) {
            return i;
        }
    }
};

//给死亡玩家设置样式
if (sessionStorage.getItem("people")) {
    var people = JSON.parse(sessionStorage.getItem("people"));
    for (i = 0; i < people.length; i++) {
        if (!people[i].state) {
            playerConts[i].classList.add("dead-color");
        }
    }
}

//创建一个获取session参数的函数
function getInformation(a,b,m) {
    if (sessionStorage.getItem(a)) {
        return JSON.parse(sessionStorage.getItem(a));
    } else {
        return b;
    }
}

//给确定按钮绑定点击事件
btn.addEventListener('click', function () {
    var j = getNum();
    var killState = "click";
    var night = [], day = [];
    var killWay = sessionStorage.getItem("killWay");

    if (sessionStorage.getItem("day")) {
        day = JSON.parse(sessionStorage.getItem("day"));
    } else {
        day = [];
    }
    if (sessionStorage.getItem("night")) {
        night = JSON.parse(sessionStorage.getItem("night"));
    } else {
        night = [];
    }

    //获取保存的数组信息
    if (sessionStorage.getItem("people")) {
        people = JSON.parse(sessionStorage.getItem("people"));
    } else {
        people = person;
    }

    //杀手杀人和全员投票
    if(killWay === "killer"){
        if (!j) {
            alert("请选择杀人");
        } else if (people[j - 1].id === "杀 手"){
            alert("别动手，自己人");
        } else {
            night.push(j - 1);
            people[j - 1].state = false;
            killState = "unClick";
            sessionStorage.setItem("night",JSON.stringify(night));
            sessionStorage.setItem("killState", killState);
            judgment();
        }
    } else {
        if (!j) {
            alert("请选择杀人");
        } else {
            day.push(j - 1);
            people[j - 1].state = false;
            killState = "Click";
            sessionStorage.setItem("day",JSON.stringify(day));
            sessionStorage.setItem("killState", killState);
            judgment();
        }
    }
}, false);


//获取存活人数，判断胜负
function judgment() {
    var killerNum = 0;
    var civilianNum = 0;
    var gameResult = "";
    for (i = 0; i < people.length; i++) {
        if (people[i].id === "杀 手" && people[i].state) {
            killerNum++;
        } else if (people[i].id === "平 民" && people[i].state) {
            civilianNum++;
        }
    }
    if (killerNum === 0) {
        gameResult = "平民胜利";
        window.location.href = "gameover.html";
        sessionStorage.setItem("gameResult", gameResult);
    } else if (killerNum === civilianNum) {
        gameResult = "杀手胜利";
        window.location.href = "gameover.html";
        sessionStorage.setItem("gameResult", gameResult);
    } else {
        //sessionStorage.setItem("day", parseInt(sessionStorage.day) + 1);
        window.location.href = "game.html";
    }
    sessionStorage.setItem("people", JSON.stringify(people));
}