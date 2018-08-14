function login() {
    var name = $("input").eq(0).val();
    var pwd = $("input").eq(1).val();
    if (name == "") {
        $(".prompt").text("用户名不能为空");
        $(".prompt").css("color", "red");
        return false;
    }
    if (pwd == "") {
        $(".prompt").text("密码不能为空");
        $(".prompt").css("color", "red");
        return false;
    }
    $(".prompt").css("color", "black");
    var userTemp = "name=" + name + "&pwd=" + pwd;
    console.log(userTemp);
    $.ajax({
        type: "POST",
        url: "/carrots-admin-ajax/a/login",
        data: userTemp,
        dataType: "json",
        success: function (result, status, xhr) {
            if (result.message == "success") {
                $(".prompt").text("登陆成功");
                location.href = "http://dev.admin.carrots.ptteng.com/a/login"
            } else {
                $(".prompt").text(result.message);
            }
        },
        error: function (xhr) {
            alert(xhr.status);
        }
    })
}

$(function () {
    $(".login").on("click", login)
})