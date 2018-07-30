//获取存储缓存json字符串并转换为数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
//获取玩家数量并转换为number
var players = +sessionStorage.getItem("players");
//获取存储缓存json字符串并转换为数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
//存储玩家存活状态
var playerLife = JSON.parse(sessionStorage.getItem("playerLife"));
$("header").css("justify-content", "center")

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
    //对死亡玩家进行样式更改
    if (sessionStorage.getItem("playerLife")) {
        for (var i = 0; i < playerLife.length; i++) {
            if (playerLife[i] == "死亡") {
                var temp = ".name";
                $(temp).eq(i).css("background", "#83b09a");
            }
        }
    };
})



$("#returnBox").click(function () {
    location.href = "startGame.html";
})