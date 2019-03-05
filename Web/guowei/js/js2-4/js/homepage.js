var listbot = document.getElementsByClassName("listbot")[0];
var lasttime = document.getElementsByClassName("lasttime")[0];
if (localStorage.link) {
    lasttime.innerHTML = "上次游戏: 杀人游戏" + localStorage.link;
    lasttime.classList.toggle("d-none");
    switch (localStorage.link) {
        case "简化版":
            lasttime.onclick = function () {
                location = "players.html";
            }
            break;
        case "猜词版":
            lasttime.onclick = function () {
                location = "vote.html";
            }
            break;
        case "炼狱版":
        lasttime.onclick = function () {
            location = "www.baidu.com";
        }
    }
}
listbot.onclick = function () {
    var tem = event.target;
    if (tem.tagName == "BUTTON") {
        localStorage.link = tem.innerHTML;
    }
}

console.log(localStorage.link);
