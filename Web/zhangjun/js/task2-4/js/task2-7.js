$(document).ready(function () {
    var aPlayerRole = JSON.parse(sessionStorage.getItem("aPlayerRole")),  // 把取出来的字符串转换为数组
        aPlayerStatus = JSON.parse(sessionStorage.getItem("aPlayerStatus"));
    for (var i = 0; i < aPlayerRole.length; i++) {
        var num = i + 1; // 角色号数
        // html结构
        var gridHtml = "<div class=\"grid-wrap\">\n" +
            "            <div class=\"grid\">\n" +
            "                <div class=\"role\">" + aPlayerRole[i] + "</div>\n" +
            "                <div class=\"number\">" + num + "号</div>\n" +
            "            </div>\n" +
            "        </div>"
        // 为页面添加html结构
        $(".main").append(gridHtml);
    }
    // 为被杀和被投死角色添加样式

    for (var i = 0; i < aPlayerRole.length; i++) {
        if (aPlayerStatus[i].status === "killed" || aPlayerStatus[i].status === "voted") {
            var index = aPlayerStatus[i].num - 1;  // 获取被杀角色的下标
            $(".role").eq(index).css("background-color","#83b09a");
        }
    }
    // 为返回按钮添加点击事件
    $(".back-btn").click(function () {
        location.href="task2-5.html";
    })
})