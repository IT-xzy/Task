// var playerNum = document.getElementById("playerNum"),
//     identityKing = document.getElementById("identityKing"),
//     content = document.getElementById("content")
//     identityPlyaer = document.getElementById("identityPlayer"),
//     passBtn = document.getElementById("passBtn");
//
// var players = sessionStorage.getItem("player").split(",");
// var i = 1;
// passBtn.addEventListener("click",clickCounter,false);
// function clickCounter() {
//     if (passBtn.clickcount) {
//         passBtn.clickcount = Number(passBtn.clickcount) + 1;
//     }else {
//         passBtn.clickcount = 1;
//     }
//     var num = passBtn.clickcount;
//     if (num<players.length * 2) {
//         if (num % 2 == 1) {
//             changeContent();
//             passBtn.textContent = "隐藏并传递给"+(i+1)+"号";
//             if (playerNum.textContent == players.length) {
//              passBtn.textContent = "法官查看";
//             }
//         }else if (num % 2 == 0) {
//             playerNum.textContent = ++i;
//             returnContent();
//             passBtn.textContent = "查看" + i + "号身份";
//         }
//     } else if (num == (players.length*2)) {
//         window.location.href = "1234.html";
//     }
//
//     function changeContent() {
//         var playersText = document.createElement("p");
//         playersText.textContent = players[(i-1)];
//         playersText.className = "identity-text";
//         content.appendChild(playersText);
//         identityKing.style.display = "none";
//         identityPlyaer.style.display = "block";
//     }
//     function returnContent() {
//         content.removeChild(content.lastChild);
//         identityPlyaer.style.display = "none";
//         identityKing.style.display = "block";
//     }
// }

var backBtn = document.getElementById("backBtn"),
    closeBtn = document.getElementById("closeBtn"),
    container = document.getElementById("container"),
    playerNum = document.getElementById("playerNum"),
    identityKing = document.getElementById("identityKing"),
    identityPlyaer = document.getElementById("identityPlayer"),
    passBtn = document.getElementById("passBtn");

//获取玩家匹配页面传来的参数，并转换成数组；
var players = sessionStorage.getItem("player").split(",");

//给顶部两个按钮设置点击事件
backBtn.addEventListener("click", function () {
    window.history.back(-1);
}, false);

closeBtn.addEventListener("click", function () {
    if (confirm("是否结束本轮游戏")) {
        window.location.href = "version-selection.html";
        sessionStorage.clear();
    }
}, false);

//给传递按钮添加事件
var i = 1;
passBtn.addEventListener("click", clickCounter, false);

function clickCounter() {
    if (passBtn.clickcount) {
        passBtn.clickcount = Number(passBtn.clickcount) + 1;
    } else {
        passBtn.clickcount = 1;
    }
    var num = passBtn.clickcount;
    if (num < players.length * 2) {
        if (num % 2 == 1) {
            changeContent();
            passBtn.textContent = "隐藏并传递给" + (i + 1) + "号";
            if (playerNum.textContent == players.length) {
                passBtn.textContent = "法官查看";
            }
        } else if (num % 2 == 0) {
            playerNum.textContent = ++i;
            return Content();
            passBtn.textContent = "查看" + i + "号身份";
        }
    } else if (num == (players.length * 2)) {
        window.location.href = "judge-log.html";
    }

    function changeContent() {
        var playersText = document.createElement("p");
        playersText.textContent = players[(i - 1)];
        playersText.className = "identity-text";
        container.appendChild(playersText);
        identityKing.style.display = "none";
        identityPlyaer.style.display = "block";
    }

    function returnContent() {
        container.removeChild(container.lastChild);
        identityPlyaer.style.display = "none";
        identityKing.style.display = "block";


    }
}