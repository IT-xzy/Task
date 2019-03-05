var on = document.getElementsByClassName("on")[0];
var draw = document.getElementsByClassName("draw")[0];
var dNone = document.getElementsByClassName("name")[0];
var headerSpan = document.getElementsByTagName("header")[0].getElementsByTagName("span")[0];
var main = document.getElementsByTagName("main")[0];
var pass = document.getElementById("pass");
var get = sessionStorage.data;
var change = JSON.parse(get);
var arr = shuffle(change[1], change[0]);
var num = 0;
function shuffle(Plebs, killer) {
    var arr = [];
    for (var i = Plebs; i--;) {
        arr.push("平民");
    }

    for (var i = killer; i--;) {
        arr.push("杀手");
    }

    for (var m = arr.length; m;) {
        var i = Math.floor(Math.random() * m--);
        var t = arr[m];
        arr[m] = arr[i];
        arr[i] = t;
    }
    return arr;
} 
function exit() {
    alert("要退出游戏吗");
    location = "homepage.html";
}
function insert(i) {
    var newLi = document.createElement("li");
    var newstrong = document.createElement("strong");
    var newspan = document.createElement("span");
    newstrong.innerHTML = arr[i];
    newspan.innerHTML = (i + 1) + "号";
    newLi.appendChild(newstrong);
    newLi.appendChild(newspan);
    newLi.appendChild(newspan);
    newUl.appendChild(newLi);
}

pass.onclick = function () {
    if (num > arr.length) {
        if (num == arr.length + 1) {
            var Oplayer = [];
            newUl = document.createElement("ul");
            main.parentNode.replaceChild(newUl, main);
            for (var i = 0; i < arr.length; i++) {
                insert(i);
                player = {
                    ady:null,
                    role: arr[i],
                    num: i + 1,
                    state: "survival"
                }
                Oplayer.push(player);
            }
            headerSpan.innerHTML = "法官日记"
            pass.innerHTML = "开始游戏";
            num++;
            var playered = JSON.stringify(Oplayer);
            sessionStorage.player = playered;
            var send = JSON.stringify(arr);
            sessionStorage.arr = send;
        } else {
            location = "vote.html";
        }
    } else {
        if (dNone.className == "name d-none") {
            draw.className = "draw status";
            dNone.className = "name";
            dNone.innerHTML = arr[num++];
            if (num == arr.length) {
                pass.innerHTML = "法官查看";
                num++;
            } else {
                pass.innerHTML = "隐藏并传递给" + (num + 1) + "号";
            }
        } else {
            on.innerHTML = num + 1;
            draw.className = "draw";
            dNone.className = "name d-none";
            pass.innerHTML = "查看" + (num + 1) + "号身份";
        }
    }
}