$(document).ready(function () {
    var aKilled = JSON.parse(sessionStorage.getItem("aKilled")),
        aVoted = JSON.parse(sessionStorage.getItem("aVoted")),
        days = JSON.parse(sessionStorage.getItem("days"));
    $(".days").text("第" + days + "天");
    if (days > 1) {
        for (var i = 0; i < days - 1; i++) {
            var day = i + 1;
            var html = "<div class=\"row\">\n" +
                "        <div class=\"days\">第" + day + "天</div>\n" +
                "        <div class=\"wrap-1\">\n" +
                "            <div class=\"step-wrap\">\n" +
                "                <div class=\"steps killer-1\">\n" +
                "                    <div class=\"triangle-1\"></div>\n" +
                "                    <div class=\"icon\"><img src=\"images/moon@1x.png\"></div>\n" +
                "                    <div class=\"step-text-1\">杀手杀人</div>\n" +
                "                </div>\n" +
                "                <div class=\"message message-top-1\">\n" +
                "                    <span></span>号被杀手杀死，真实身份是<span></span>\n" +
                "                </div>\n" +
                "                <div class=\"steps dead-1\">\n" +
                "                    <div class=\"icon\"><img src=\"images/sun@1x.png\"></div>\n" +
                "                    <div class=\"triangle-1\"></div>\n" +
                "                    <div class=\"step-text-1\">亡灵发表遗言</div>\n" +
                "                </div>\n" +
                "                <div class=\"steps speak-1\">\n" +
                "                    <div class=\"triangle-1\"></div>\n" +
                "                    <div class=\"step-text-1\">玩家依次发言</div>\n" +
                "                </div>\n" +
                "                <div class=\"steps vote-1\">\n" +
                "                    <div class=\"triangle-1\"></div>\n" +
                "                    <div class=\"step-text-1\">全民投票</div>\n" +
                "                </div>\n" +
                "                <div class=\"message message-bottom-1\">\n" +
                "                    <span></span>号被投票投死，真实身份是<span></span>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>";
            // 为页面添加html结构
            $(".row").eq(-1).before(html);
            $(".row .wrap-1").hide();
            if (aKilled[i].num === "NoOneDied") {
                $(".message-top-1").eq(i).text("昨晚没有人被杀");
            } else {
                $(".message-top-1").eq(i).text(aKilled[i].num + "号被杀手杀死，真实身份是" + aKilled[i].role);
            }
            $(".message-bottom-1").eq(i).text(aVoted[i].num + "号被投票投死，真实身份是" + aVoted[i].role);
        }
    }
    // 为日期添加点击事件
    $(".days").click(function () {
        $(this).next().toggle("normal");
    });
    // 游戏步骤状态机
    var fsm = {
        state: sessionStorage.getItem("step"),
        killStep: function () {
            switch (fsm.state) {
                case "none":
                    sessionStorage.setItem("step", "killer");
                    location.href = "task2-6.html";
                    break;
                case "dead":
                    alert("请勿重复操作");
                    break;
                case "speak":
                case "vote":
                    alert("请按照游戏步骤进行");
                    break;
            }
        },
        deadStep: function () {
            switch (fsm.state) {
                case "none":
                case "killer":
                case "vote":
                    alert("请按照游戏步骤进行");
                    break;
                case "speak":
                    alert("请勿重复操作");
                    break;
                case "dead":
                    alert("请死者亮明身份并发表遗言");
                    fsm.state = "speak";
                    sessionStorage.setItem("step", fsm.state);
                    $(".dead .step-text").css("background-color", "#83b09a");
                    $(".dead .triangle").css("border-right-color", "#83b09a");
                    console.log(fsm.state);
                    break;
            }
        },
        speakStep: function () {
            switch (fsm.state) {
                case "none":
                case "kill":
                case "dead":
                    alert("请按照游戏步骤进行");
                    break;
                case "vote":
                    alert("请勿重复操作");
                    break;
                case "speak":
                    alert("请玩家依次发言讨论");
                    fsm.state = "vote";
                    sessionStorage.setItem("step", fsm.state);
                    $(".speak .step-text").css("background-color", "#83b09a");
                    $(".speak .triangle").css("border-right-color", "#83b09a");
                    console.log(fsm.state);
                    break;
            }
        },
        voteStep: function () {
            switch (fsm.state) {
                case "none":
                case "kill":
                case "dead":
                case "speak":
                    alert("请按照游戏步骤进行");
                    break;
                case "vote":
                    location.href = "task2-6.html";
                    break;
            }
        }
    };
    // 点击杀手杀人
    $(".killer .step-text").click(function () {
        fsm.killStep();
    })
    // 点击亡灵发言
    $(".dead .step-text").click(function () {
        fsm.deadStep();
    })
    // 点击玩家发言
    $(".speak .step-text").click(function () {
        fsm.speakStep();
    })
    // 点击投票
    $(".vote .step-text").click(function () {
        fsm.voteStep();
    })

    // 设置高亮函数
    function highLight(a, b) {
        a.css("background-color", "#83b09a");
        b.css("border-right-color", "#83b09a");
    }

    // 改变高亮刷新后高亮也不会变
    switch (sessionStorage.getItem("step")) {
        case "dead":
            highLight($(".killer .step-text"), $(".killer .triangle"));
            $(".message-top").removeClass("hide");  // 显示被杀者的信息
            if (aKilled.slice(-1)[0].num === "NoOneDied") {
                $(".message-top").text("昨晚没有人被杀");
            } else {
                $(".message-top span:first").text(aKilled.slice(-1)[0].num).next("span").text(aKilled.slice(-1)[0].role);
            }
            break;
        case "speak":
            highLight($(".killer .step-text"), $(".killer .triangle"));
            highLight($(".dead .step-text"), $(".dead .triangle"));
            $(".message-top").removeClass("hide");
            if (aKilled.slice(-1)[0].num === "NoOneDied") {
                $(".message-top").text("昨晚没有人被杀");
            } else {
                $(".message-top span:first").text(aKilled.slice(-1)[0].num).next("span").text(aKilled.slice(-1)[0].role);
            }
            break;
        case "vote":
            highLight($(".killer .step-text"), $(".killer .triangle"));
            highLight($(".dead .step-text"), $(".dead .triangle"));
            highLight($(".speak .step-text"), $(".speak .triangle"));
            $(".message-top").removeClass("hide");
            if (aKilled.slice(-1)[0].num === "NoOneDied") {
                $(".message-top").text("昨晚没有人被杀");
            } else {
                $(".message-top span:first").text(aKilled.slice(-1)[0].num).next("span").text(aKilled.slice(-1)[0].role);
            }
            break;
    }
    // 为返回按钮添加点击事件
    $(".back-btn").click(function () {
        location.href = "task2-4.html";
    })
    // 为关闭按钮添加点击事件
    $(".close-btn").click(function () {
        var a = confirm("结束本轮游戏吗?");
        if (a === true) {
            sessionStorage.clear(); // 退出游戏清空所有储存在本地的数据
            location.href = "task2-1.html";
        }
    })
    // 点击结束游戏
    $(".end").click(function () {
        var a = confirm("本轮游戏是否已经结束?");
        if (a === true) {
            sessionStorage.clear();
            location.href = "task2-1.html";
        }
    })
    // 点击法官日记
    $(".diary").click(function () {
        location.href = "task2-7.html";
    })
})


