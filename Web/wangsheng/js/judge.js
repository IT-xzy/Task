var backBtn = document.getElementById("backBtn"),
    closeBtn = document.getElementById("closeBtn"),
    container = document.getElementById("container"),
    startBtn = document.getElementById("startBtn"),
    players = sessionStorage.getItem("player").split(",");

for (var i = 0; i < players.length; i++) {
    var div = document.createElement("div"),
        text = document.createElement("p"),
        num = document.createElement("p");
    div.className = "wrap";
    text.textContent = players[i];
    text.className = "player__text";
    num.textContent = (i + 1) + "号";
    num.className = "player__num";
    div.appendChild(text);
    div.appendChild(num);
    container.appendChild(div);

}

if (sessionStorage.playerState && !sessionStorage.back) {
    var playerState = JSON.parse(sessionStorage.getItem("playerState"));
    for (var i = 0; i < container.getElementsByClassName("wrap").length; i++) {
        if (playerState[i].state == "dead") {
            container.getElementsByClassName("wrap")[i].classList.add("wrap-unClickable");
        }
    }
    backBtn.parentElement.style.justifyContent = "center";
    backBtn.parentNode.removeChild(backBtn);
    closeBtn.parentNode.removeChild(closeBtn);
    startBtn.textContent = "返回";
    startBtn.addEventListener("click", function () {
        window.history.back(-1);
    }, false);

} else {
    backBtn.addEventListener("click", function () {
        window.history.back(-1);
    }, false);
    closeBtn.addEventListener("click", function () {
        if (confirm("结束本轮游戏吗？")) {
            window.location.href = "type of play.html";
            sessionStorage.clear();
        }
    }, false);
    startBtn.addEventListener("click", function () {
        var value = container.innerHTML;
        sessionStorage.setItem("container", value);
        if (sessionStorage.back) {
            window.history.back(-1);
        }else {
            window.location.href = "Game steps.html";
        }
    }, false);
}
