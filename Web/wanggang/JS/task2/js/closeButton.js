//关闭按钮
$("a.closeButton").click(
    function () {
        var closeClick = confirm("结束本轮游戏吗？")
        if (closeClick) {
            sessionStorage.clear();
            location.href = "hall.html"
        }
    }
)