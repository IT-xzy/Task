var killerKill = document.getElementsByClassName("process-list")[0];
var deadSpeak = document.getElementsByClassName("process-list")[1];
var playerSpeak = document.getElementsByClassName("process-list")[2];
var vote = document.getElementsByClassName("process-list")[3];
var killState = sessionStorage.getItem("killState");
var killWay = "killer";

//判断按钮是否被点击过
if(killState === "unClick"){
    killerKill.classList.add("bg-gray");
}

//杀手杀人绑定点击事件
killerKill.addEventListener("click", function () {
    if (killState === "unClick") {
        alert("请按顺序点击")
    } else  {
        window.location.href = "player-vote.html";
        sessionStorage.setItem("killWay",killWay);
    }
}, false);

//亡灵遗言
deadSpeak.addEventListener("click", function () {
    if (!killerKill.classList.contains("bg-gray")){
        alert("请按顺序点击")
    } else if (deadSpeak.classList.contains("bg-gray")){
        alert("请按顺序点击")
    } else {
        deadSpeak.classList.add("bg-gray");
        alert("请亡灵发表遗言")
    }
}, false);

//玩家发言
playerSpeak.addEventListener("click", function () {
    if (!deadSpeak.classList.contains("bg-gray")){
        alert("请按顺序点击")
    } else if (playerSpeak.classList.contains("bg-gray")){
        alert("请按顺序点击")
    } else {
        alert("请玩家依次发言");
        playerSpeak.classList.add("bg-gray");
    }
}, false);

//全员投票
vote.addEventListener("click", function () {
    if (!playerSpeak.classList.contains("bg-gray")){
        alert("请按顺序点击")
    } else {
        killWay = "vote";
        window.location.href = "player-vote.html";
        sessionStorage.setItem("killWay", killWay);
    }
}, false);
