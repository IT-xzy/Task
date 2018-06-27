var xhr = new XMLHttpRequest();
function ip() {
    var name = $("#name").val();
    var code = $("#code").val();
// 指定通信过程中状态改变时的回调函数
    xhr.open("post", "/carrots-admin-ajax/a/login",true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("name=" + name + "&pwd=" + code);
    xhr.onreadystatechange = function () {

        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                if (JSON.parse(xhr.responseText).code >= 0) {
                    window.location.href = "http://dev.admin.carrots.ptteng.com/";
                } else {
                    $(".alert").html("该用户不存在或密码不正确");
                }
            }
        }
    };
}

$(function () {
    $("#summit").click(function () {
        var name = $("#name").val();
        var code = $("#pwd").val();
        $.ajax({
            type: "POST",
            url: "/carrots-admin-ajax/a/login",
            data: {
                "name": name,
                "pwd": code
            },
            // beforeSend: function(xhr){xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");},
            datatype:"json",
            success: function (data) {
                console.log(data);
                if (JSON.parse(data).code==0) {
                    alert(JSON.parse(data).message);
                }
                else {
                    alert(JSON.parse(data).message)
                }
            }
        })
    })
});
// $.post("/carrots-admin-ajax/a/login",{
//     name:$("#name").val(),
//     pwd:$("#pwd").val()
// },function(data,textStatus){
//     console.log(data);
//     if (JSON.parse(data).code==0) {
//         alert(JSON.parse(data).message);
//     }
//     else {
//         alert(JSON.parse(data).message)
//     }
// });