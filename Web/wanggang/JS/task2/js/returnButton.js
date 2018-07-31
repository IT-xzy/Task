//关闭按钮
$("a.returnButton").click(
    function () {
       sessionStorage.clear();
        location.href = "playerDistribution.html"
    }
)