//获取存储缓存json字符串并转换为数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
//获取玩家数量并转换为number
var players = +sessionStorage.getItem("players");

$(function () {
    console.log(players);
    console.log(playersArray);
    //进行元素克隆、默认有一个，只需要克隆数量-1个
    for (var i = 0; i < players - 1; i++) {
        $("#player1").clone().attr("id", "player" + (i + 2)).appendTo("div.players");
    };
    // 对克隆元素内部进行内容修改
    for (var i = 0; i < players; i++) {
        //更改序号
        var id = "#player" + (i + 1);
        $(id).find("p.number").text((i + 1) + "号");
        //更改身份
        if (playersArray[i] == 1) {
            $(id).find("p.name").text("狼人");
        };
    };
})
$("#startBox").click(function () {
    location.href = "startGame.html";
})
