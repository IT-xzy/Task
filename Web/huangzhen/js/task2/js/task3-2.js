var obj = JSON.stringify(player);
obj = sessionStorage.player;
var player = JSON.parse(obj);

// 在这里用对象解决原来的字符串数组
// 定义数组容纳身份
var identity = [];
for (i = 0; i < player.length; i++) {
    var sub = player[i];
    sub = (sub.substring(sub.length - 7, sub.length - 5));
    identity[i] = sub;
}
console.log(identity);

// 对象创建器，a是角色，b是状态死活
function $sta(a, b) {
    this.role = a;
    this.state = b;
}

var ab = [];
for (i = 0; i < identity.length; i++) {
    if (identity[i] == "平民") {
        ab[i] = new $sta("平民", "alive");

    } else {
        ab[i] = new $sta("杀手", "alive");
    }
}

// console.log(ab);

for (a = 0; a < ab.length; a++) {
    $("main").append('<div class="item"><p class="id"><span>' + ab[a].role + '</span></p><p class="number">' + (a + 1) + '号</p><p class="choose"><img src="./img/kill.png" alt=""></p></div>');
    // if (ab[a].state == "dead") {
    //     $(".id").eq(a).addClass("another");
    // }
}

var all = JSON.stringify(ab);
sessionStorage.ab = all;
console.log(all);