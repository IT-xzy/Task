//获取存储缓存json字符串并转换为数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
//获取玩家数量并转换为number
var players = +sessionStorage.getItem("players");
//选择的玩家
var choosePlayer;
//存储玩家存活状态
var playerLife;
//获取平民数
var villager = sessionStorage.getItem("villager");
if (sessionStorage.getItem("playerLife") != null) {
    playerLife = JSON.parse(sessionStorage.getItem("playerLife"));
} else {
    playerLife = new Array(players);
}
//声明杀死数组
if (sessionStorage.getItem("killDead")) {
    var killDead = JSON.parse(sessionStorage.getItem("killDead"));
} else {
    var killDead = [];
}
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
    }
    //获取点击选择对象 
    $(".player").click(function () {
        //每次点击初始化
        $(".select").css("visibility", "hidden")
        //获取点击下角标
        choosePlayer = $(this).index();
        //显示图标
        $(".select").eq($(this).index()).css("visibility", "visible");
    })
    $(".kill").click(function () {
        if (choosePlayer == undefined) {
            alert("必须选择杀死一个玩家")
        } else if (playersArray[choosePlayer] == 1) {
            alert("不能杀死自己人")
        } else if (playerLife[choosePlayer] == "死亡") {
            alert("这货死了，不能再杀了")
        } else if (villager == 1) {
            //存储平民数量，并跳转页面
            villager = 0;
            var temp = (choosePlayer + 1) + "号被杀手杀死，真实身份是平民";
            killDead.push(temp);
            sessionStorage.setItem("killDead", JSON.stringify(killDead));
            sessionStorage.setItem("villager", villager);
            location.href = "gameOver.html";
        } else {
            //存储玩家状态
            playerLife[choosePlayer] = "死亡";
            //减去死亡平民
            villager = villager - 1;
            var temp = (choosePlayer + 1) + "号被杀手杀死，真实身份是平民";
            killDead.push(temp);
            sessionStorage.setItem("killDead", JSON.stringify(killDead));
            console.log(playerLife);
            //页面跳转
            location.href = "startGame.html";
            //进行json字符串转换，并进行存储
            var temp = JSON.stringify(playerLife);
            sessionStorage.setItem("playerLife", temp);
            sessionStorage.setItem("villager", villager);
            sessionStorage.setItem("choose", choosePlayer);
            console.log(villager)
        }
    })
})