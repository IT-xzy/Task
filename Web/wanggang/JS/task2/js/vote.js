//获取存储缓存json字符串并转换为数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
//获取玩家数量并转换为number
var players = +sessionStorage.getItem("players");
//选择的玩家
var choosePlayer;
//存储玩家存活状态
var playerLife = JSON.parse(sessionStorage.getItem("playerLife"));;
//获取平民数
var villager = sessionStorage.getItem("villager");
//获取杀手数
var killer = sessionStorage.getItem("killer");
//获取当前天数
var day = +sessionStorage.getItem("day", day);
//声明投死数组
if (sessionStorage.getItem("voteDead")) {
    var voteDead = JSON.parse(sessionStorage.getItem("voteDead"))
} else {
    var voteDead = [];
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
            alert("必须选择一个玩家")
        } else if (playersArray[choosePlayer] == 1) {
            //投死杀手，杀手数-1
            killer = killer - 1;
            sessionStorage.setItem("killer", killer);
            var voteDeadTemp = (choosePlayer + 1) + "号玩家被投死，真实身份是杀手";
            voteDead.push(voteDeadTemp);
            sessionStorage.setItem("voteDead", JSON.stringify(voteDead));
            playerLife[choosePlayer] = "死亡";
            var temp = JSON.stringify(playerLife);
            sessionStorage.setItem("playerLife", temp);
            sessionStorage.setItem("chooseVote", choosePlayer);
            //判断当杀手数为0游戏结束
            if (killer == 0) {
                location.href = "gameOver.html";
            } else {
                //投票结束天数+1
                day += 1;
                sessionStorage.setItem("day", day);
                location.href = "startGame.html";
            }
        } else if (playerLife[choosePlayer] == "死亡") {
            alert("这货死了，不能投了")
        } else if (villager == 1) {
            location.href = "gameOver.html";
        } else {
            villager = villager - 1;
            playerLife[choosePlayer] = "死亡";
            var voteDeadTemp = (choosePlayer + 1) + "号玩家被投死，真实身份是平民";
            voteDead.push(voteDeadTemp);
            sessionStorage.setItem("voteDead", JSON.stringify(voteDead));
            console.log(playerLife);
            //投票结束天数+1
            day += 1;
            sessionStorage.setItem("day", day);
            location.href = "startGame.html"
            var temp = JSON.stringify(playerLife);
            sessionStorage.setItem("playerLife", temp);
            sessionStorage.setItem("villager", villager);
            sessionStorage.setItem("chooseVote", choosePlayer);
            console.log(villager)
        }
    })
})