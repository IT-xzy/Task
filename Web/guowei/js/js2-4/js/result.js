if (sessionStorage.killed) {
    var killed = JSON.parse(sessionStorage.killed);
}

if (sessionStorage.byvote) {
    var byvote = JSON.parse(sessionStorage.byvote);
}

if (sessionStorage.num) {
    var num = JSON.parse(sessionStorage.num);
}
var Oplayer = JSON.parse(sessionStorage.player);
var data = sessionStorage.data;
var change = JSON.parse(data);
var message = document.getElementById("message");
var killer = document.getElementById("killer");
var civilian = document.getElementById("civilian");

function digited(value) {
    var arr = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十"];
    if (value < 10) {
        return arr[value];
    } else {
        return arr[9] + arr[(value - 10)];
    }
}

function eliminate() {
    sessionStorage.clear();
    location = "players.html";
}
var filterOplayer1 = Oplayer.filter(function (item, index, array) {
    return (item.role == "平民" && item.state == "die");
});
var filterOplayer2 = Oplayer.filter(function (item, index, array) {
    return (item.role == "杀手" && item.state == "die");
});

killer.innerHTML = "杀手" + (change[0] - filterOplayer2.length) + "人";
civilian.innerHTML = "平民" + (change[1] - filterOplayer1.length) + "人";
console.log(num);
if (!killed) {
    message.innerHTML = '<div><p>第一天</p>' +
        '<p>白天：</p>' +
        '<p>夜晚：</p></div>';
}
for (var i = 0; i < num + 1; i++) {
    console.log(byvote);
    if (byvote && byvote[i]) {
        message.innerHTML += '<div>' +
            '<p>第' + digited(i) + '天</p>' +
            '<p>白天：' + killed[i].num + '号被杀死了，真实身份是' + killed[i].role + '</p>' +
            '<p>夜晚：' + byvote[i].num + '号被投死了，真实身份是' + byvote[i].role + '</p>' +
            '</div>';
    } else {
        message.innerHTML += '<div>' +
            '<p>第' + digited(i) + '天</p>' +
            '<p>白天：' + killed[i].num + '号被杀死了，真实身份是' + killed[i].role + '</p>' +
            '<p>夜晚：</p>' +
            '</div>';
    }
        // console.log(step.innerHTML);
}