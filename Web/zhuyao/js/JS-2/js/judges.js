var players = sessionStorage.getItem("players").split(",");
var main = document.getElementsByTagName("main")[0];
console.log(players);

for (var i=1;i<=players.length;i++){
    var div = document.createElement("div");
    var identity = document.createElement("p");
    var num = document.createElement("p");
    div.className = "player-cont";
    identity.className = "player-details";
    num.className = "player-num";
    main.appendChild(div);
    div.appendChild(identity);
    div.appendChild(num);
    identity.textContent = players[i-1];
    num.textContent = i + "号";
}
function begin() {
    window.location.href = "game.html";
}


