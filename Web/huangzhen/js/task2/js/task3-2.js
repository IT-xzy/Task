var obj = JSON.stringify(player);
obj = sessionStorage.player;
var player = JSON.parse(obj);

for (i = 0; i < player.length; i++) {
    var sub = player[i];
    sub = (sub.substring(sub.length - 8, sub.length - 5));
    console.log(sub);
    $("main").append('<div class="item"><p class="id"><span>' + sub + '</span></p><p class="number">' + (i + 1) + '号</p><p class="choose"><img src="./img/kill.png" alt=""></p></div>');
}



