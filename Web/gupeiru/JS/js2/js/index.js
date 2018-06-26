
$(function () {
    $("#simple").on("click", function () {//点击跳转发牌
        window.location.href = "deal.html";
    });
    setTimeout(function () {//启动页消失
        $("#position").css("display", "none");
    }, 1000);
});