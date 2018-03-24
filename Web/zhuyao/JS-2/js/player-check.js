var a3 = sessionStorage.getItem("playerArr").split(",");
var players = [];
var back = document.getElementsByClassName("icon-back")[0];
var front = document.getElementsByClassName("icon-front")[0];
var btn = document.getElementsByClassName("check-btn")[0];
var playerNum = document.getElementsByClassName("player-number")[0];
var playerCont = document.getElementById("playerCont");
var i = 1, j = 1, m = 2;

//截取字符串
for(var n = 0;n < a3.length; n++){
    players[n] = a3[n].substring(19,22);
}
sessionStorage.setItem("players",players);
console.log(players);

//点击翻拍查看角色身份
btn.addEventListener("click", look, false);
function look(){
    if(i < players.length * 2) {
        if(i % 2 !== 0){
            change();
            if ( i === players.length * 2 - 1 ) {
                btn.value = "法官查看";
            } else {
                btn.value = "隐藏并传递给" + m + "号";
            }
            j++;
            m++;
        }else {
            changeAgain();
        }
        i++;
        console.log(i);
    }
    else {
        window.location.href = "Judges-log.html";
    }
}

//隐藏显示切换
function change() {
    playerCont.textContent = players[j-1];
    playerCont.style.display = "block";
    back.style.display = "none";
    front.style.display = "block";
    playerNum.textContent = j;
}

//隐藏显示切换
function changeAgain() {
    playerCont.style.display = "none";
    playerNum.textContent = j;
    back.style.display = "block";
    front.style.display = "none";
    btn.value = "查看" + j + "号身份";
}