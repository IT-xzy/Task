$(document).ready(function () {
    var aPlayerRole = JSON.parse(sessionStorage.getItem("aPlayerRole")),  // 把取出来的字符串转换为数组
        aPlayerStatus = [], // 存放玩家状态
        days = 1,  // 初始化为天数
        aKilled =[],  // 存放被杀名单
        aVoted = [];  // 存放被投名单
    sessionStorage.setItem("days",JSON.stringify(days));
    sessionStorage.setItem("aKilled",JSON.stringify(aKilled));
    sessionStorage.setItem("aVoted",JSON.stringify(aVoted));
    sessionStorage.setItem("step","none");
    for (var i = 0; i < aPlayerRole.length; i++) {
        var num = i + 1; // 角色号数
        // html结构
        var gridHtml = "<div class=\"grid-wrap\">\n" +
            "            <div class=\"grid\">\n" +
            "                <div class=\"role\">" + aPlayerRole[i] + "</div>\n" +
            "                <div class=\"number\">" + num + "号</div>\n" +
            "            </div>\n" +
            "        </div>";
        // 为页面添加html结构
        $(".main").append(gridHtml);
        // 为所有角色添加基本状态到 aPlayerStatus 数组中
        aPlayerStatus[i] = {
            role: aPlayerRole[i],
            status: "live",
            num: num
        }
    }
    sessionStorage.setItem("aPlayerStatus",JSON.stringify(aPlayerStatus));
    // 为后退按钮添加点击事件
    $(".back-btn").click(function () {
        var a = confirm("回到上一页会重新分配角色，您确定要返回吗?");
        if (a === true) {
            location.href="task2-3.html";
        }
    });
    // 为关闭按钮添加点击事件
    $(".close-btn").click(function () {
        var a = confirm("确定要退出游戏吗?");
        if (a === true) {
            location.href="task2-1.html";
        }
    });
    // 为开始游戏按钮添加事件
    $(".btn").click(function () {
        location.href="task2-5.html";
    });
})