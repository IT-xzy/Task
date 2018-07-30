//获取存储缓存json字符串并转换为数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
//获取玩家数量并转换为number
var players = +sessionStorage.getItem("players");

$(function () {
    console.log(players);
    console.log(playersArray);
    //进行元素克隆、默认有一个，只需要克隆数量-1个
    for (var i = 0; i < players - 1; i++) {
        $("div.player").clone().appendTo("div.players");
    };
})
$("#startBox").click(function () {
    location.href = "#";
})