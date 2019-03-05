var get = sessionStorage.arr;
var arr = JSON.parse(get);
var data = sessionStorage.data;
var change = JSON.parse(data);
var Oplayer = JSON.parse(sessionStorage.player);
console.log(Oplayer);
var initial = sessionStorage.initial;
var num = JSON.parse(sessionStorage.num);
console.log(num);
var headerSpan = document.getElementsByTagName("header")[0].getElementsByTagName("span")[0];
var newUl = document.getElementsByTagName("ul")[0];
var ul_lis = newUl.getElementsByTagName('li');
var bBtn = document.getElementsByTagName("footer")[0].getElementsByTagName("button")[0];
var clue1 = document.getElementById("clue1");
var clue2 = document.getElementById("clue2");

if (sessionStorage.killed) {
    var killed = JSON.parse(sessionStorage.killed);
} else {var killed = [];}

if (sessionStorage.byvote) {
    var byvote = JSON.parse(sessionStorage.byvote);
} else {var byvote = [];}
var j;

function insert(i) {
    var newLi = document.createElement("li");
    var newstrong = document.createElement("strong");
    var newspan = document.createElement("span");
    var newi = document.createElement("i");
    newstrong.innerHTML = arr[i];
    newspan.innerHTML = (i + 1) + "号";
    newLi.appendChild(newstrong);
    newLi.appendChild(newspan);
    newLi.appendChild(newspan);
    newLi.appendChild(newi);
    newUl.appendChild(newLi);
    li = document.getElementsByTagName("li");
}

function exit() {
    alert("要退出游戏吗");
    sessionStorage.clear();
    location = "homepage.html";
}


for (var i = 0; i < arr.length; i++) {
    insert(i);
}
for (var i = 0; i < ul_lis.length; i++) {
    if (Oplayer[i].state == "die") {
        ul_lis[i].style.cssText = "border-color: #999; background: #999";
    }
}

for (var i = 0; i < ul_lis.length; i++) {
    ul_lis[i].index = i;
    ul_lis[i].onclick = function () {
        for (var i = 0; i < ul_lis.length; i++) {
            if (Oplayer[i].state == "survival") {
                ul_lis[i].style.borderColor = "#fff";
                ul_lis[i].getElementsByTagName("i")[0].style.display = "none";
            }
        }
        j = this.index;

        console.log(j);
        if (Oplayer[j].state == "survival") {
            ul_lis[j].style.borderColor = "#999";
            ul_lis[j].getElementsByTagName("i")[0].style.display = "inline-block";
        }
    }
}
if (initial == "vote") {
    headerSpan.innerHTML = "投票";
    clue1.innerHTML = "发言讨论结束";
    clue2.innerHTML = "点击得票数最多的人的头像";
    bBtn.onclick = function () {
        if (!(j == undefined)) {
            if (Oplayer[j].state == "die") {
                alert("请选择一个目标");
            } else {
                Oplayer[j].state = "die";
                Oplayer[j].ady = num;
                byvote.push(Oplayer[j]);
                ul_lis[j].style.background = "#999";
                var playered = JSON.stringify(Oplayer);
                sessionStorage.player = playered;
                sessionStorage.byvote = JSON.stringify(byvote);
                sessionStorage.j = JSON.stringify(j);
                var filterOplayer1 = Oplayer.filter(function (item, index, array) {
                    return (item.role == "平民" && item.state == "die");
                });
                var filterOplayer2 = Oplayer.filter(function (item, index, array) {
                    return (item.role == "杀手" && item.state == "die");
                });
                if (filterOplayer1.length == change[1] || filterOplayer2.length == change[0]) {
                    location = "result.html";
                } else {
                    console.log(filterOplayer1.length == change[1] || filterOplayer2.length == change[0]);
                    num++;
                    sessionStorage.num = JSON.stringify(num);
                    sessionStorage.initial = "murder";
                    location = "vote.html";
                }
            }
        } else {
            alert("选择一个玩家")
        }
    }
} else {
    bBtn.onclick = function () {
        if (!(j == undefined)) {
            if (Oplayer[j].role == "杀手") {
                alert("不能杀死自己");


            } else if (Oplayer[j].state == "die") {
                alert("请选择一个目标");
            } else {
                Oplayer[j].state = "die";
                Oplayer[j].ady = num;
                killed.push(Oplayer[j]);
                ul_lis[j].style.background = "#999";
                sessionStorage.num = JSON.stringify(num);
                var playered = JSON.stringify(Oplayer);
                sessionStorage.player = playered;
                sessionStorage.j = JSON.stringify(j);
                sessionStorage.killed = JSON.stringify(killed);
                var filterOplayer1 = Oplayer.filter(function (item, index, array) {
                    return (item.role == "平民" && item.state == "die");
                });
                var filterOplayer2 = Oplayer.filter(function (item, index, array) {
                    return (item.role == "杀手" && item.state == "die");
                });
                if (filterOplayer1.length == change[1] || filterOplayer2.length == change[0]) {
                    location = "result.html";
                } else {
                    console.log(filterOplayer1.length == change[1] || filterOplayer2.length == change[0]);
                    sessionStorage.initial = "words";
                    location = "vote.html";
                }
            }
        } else {
            alert("选择一个玩家")
        }
    }
}