/**
 * Created by guojianfeng on 2017/10/22.
 **/

$(document).ready(function () {
    // 解析sessionStorage
    var f = parseInt(window.sessionStorage.getItem("f"));
    var player = window.sessionStorage.getItem("play");
    var roles = JSON.parse(player);
    var x = JSON.parse(window.sessionStorage.getItem("x"));
    var y = JSON.parse(window.sessionStorage.getItem("y"));
    var h = JSON.parse(sessionStorage.getItem("h")); //记录天数
    var w;//设置变量存放被选择玩家的数组下标
    var toHome = document.getElementById("back");
    var gameRoler = [];//创建新的数组分别放置不同角色的玩家；
    var gamePlayer;
    var role = [];
    var visited;
    var death = JSON.parse(sessionStorage.getItem("death"));
    var play = document.getElementsByClassName("play");
    console.log(roles);
    //创建杀手和平民的对象数组


    for (var j = 0; j < roles.length; j++) {
        if (roles[j] === "村民") {
            gameRoler[j] = {};
            gameRoler[j].number = j + 1; //玩家的序号
            gameRoler[j].role = "村民"; //玩家当前的身份
            gameRoler[j].life = "alive"; //玩家的生死状态，活着（alive）、被杀死（death）、被投死（voted）
            gameRoler[j].data = h;
        }
        else if (roles[j] === "狼人") {
            gameRoler[j] = {};
            gameRoler[j].number = j + 1;
            gameRoler[j].role = "狼人";
            gameRoler[j].life = "alive";
            gameRoler[j].data = h;
        }
    }

    //如果未杀过人，玩家生死状态就未变化，f初始值为0
    if (f === 0) {
        gamePlayer = JSON.parse(JSON.stringify(gameRoler));//为0就取初始状态的玩家对象数组
    } else {
        gamePlayer = JSON.parse(sessionStorage.getItem("gamePlayer"));//不为零就取传送过来的gamePlayer
    }
    console.log(f);
    console.log(gamePlayer);

    //遍历生成盒子
    for (var i = 0; i < roles.length; i++) {
        var a = i + 1;
        role[i] = "<li class=\"item\">" +
            "<p class=\"play\">" + roles[i] + "</p>" +
            "<p class=\"number\">" + a + "号</p>" +
            "<div class=\"content\">" + "</div>" + "</li>";
    }
    $("ul").append(role);
    for (var o = 0; o < roles.length; o++) {
        if (gamePlayer[o].life === "death" || gamePlayer[o].life === "voted") {
            play[o].style.backgroundColor = "#000";
        }
    }
    //点击选择玩家
    $(".item").click(function () {
        w = $(this).index();//获取玩家在数组的下标
        if (gamePlayer[w].life === "death" || gamePlayer[w].life === "voted") {
            alert("他已经死了");
            $("li div").eq(n).hide();//隐藏匕首
            w = null; //用于点击了死亡玩家后清除下标
        } else if (gamePlayer[w].role === "狼人") {
            alert("狼人不可自杀");
            $("li div").eq(n).hide();//隐藏匕首
            w = null; //用于点击了狼人后清除下标
        } else {
            for (var n = 0; n < gamePlayer.length; n++) {
                if (gamePlayer[n].life === "alive") {
                    $(".play").eq(n).css("background-color", "#f5c97b");//回复颜色
                    $("li div").eq(n).hide();//隐藏匕首
                }
            }
            console.log(w);
            $($(this).find(".play")).css("background-color", "#000");//改变颜色
            $(this).find("div").show();//展示匕首
        }
    });
    //点击确认杀人
    $("#btn").click(function () {
        if (w === null || w === undefined) {
            confirm("请杀人后再点确定");
            return false;
        }
        if (confirm('真的要杀死这名玩家吗？')) {
            //alert("确定");
            gamePlayer[w].life = "death"; //改变被选择玩家的生死状态
            sessionStorage.setItem("gamePlayer", JSON.stringify(gamePlayer));
            visited = 1;
            sessionStorage.setItem("visited", JSON.stringify(visited));
            window.location.href = "../html/daily.html";
            f = 1;
            sessionStorage.setItem("f", JSON.stringify(f));
            death.unshift(gamePlayer[w]);
            sessionStorage.setItem("death", JSON.stringify(death));
            if (gamePlayer[w].role === "狼人") {
                x = x + 1;
                sessionStorage.setItem("x", JSON.stringify(x));
            } else {
                y = y + 1;
                sessionStorage.setItem("y", JSON.stringify(y));
            }
        }
        else {
            //alert("取消");
            return false;
        }
    });

// 返回上一页
    toHome.onclick = function () {
        window.history.back(-1);
    };

});
