$(document).ready(function () {
    var aKilled = JSON.parse(sessionStorage.getItem("aKilled")),
        aVoted = JSON.parse(sessionStorage.getItem("aVoted")),
        killerNum = parseInt(sessionStorage.getItem("killerNum")),  // 取出保存在killerNum中杀手人数
        civilianNum = parseInt(sessionStorage.getItem("civilianNum")),
        days = JSON.parse(sessionStorage.getItem("days"));

    $(".killer span").text(killerNum);
    $(".civilian span").text(civilianNum);

    for (var i = 0; i < days - 1; i++) {
        var day = i + 1;
        if (!aVoted[i]) {   // 直接从杀人界面跳转过来的话是没有当天投票数据的
            var html = "<div class=\"message\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"day\">第" + day + "天</div>\n" +
                "        </div>\n" +
                "        <div class=\"night\">晚上：" + aKilled[i].num + "号被杀手杀死，真实身份是" + aKilled[i].role + "</div>\n" +
                "    </div>";
        } else {
            var html = "<div class=\"message\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"day\">第" + day + "天</div>\n" +
                "        </div>\n" +
                "        <div class=\"night\">晚上：" + aKilled[i].num + "号被杀手杀死，真实身份是" + aKilled[i].role + "</div>\n" +
                "        <div class=\"daytime\">白天：" + aVoted[i].num + "号被投票投死，真实身份是" + aVoted[i].role + "</div>\n" +
                "    </div>";
        }
        // 为页面添加html结构
        $(".bd").append(html);
        if (aKilled[i].num === "NoOneDied") {
            $(".night").eq(i).text("晚上：没有人被杀");
        }
    }

    if (killerNum === 0) {
        $(".text").text("平民胜利");
    } else {
        $(".text").text("杀手胜利");
    }
    $(".home-btn").click(function () {
        var a = confirm("确定要返回到游戏主页吗？");
        if (a === true) {
            sessionStorage.clear();
            location.href = "task2-1.html";
        }
    })
    $(".again").click(function () {
        var a = confirm("要不要再玩一局？");
        if (a === true) {
            sessionStorage.clear();
            location.href = "task2-2.html";
        }
    })
})