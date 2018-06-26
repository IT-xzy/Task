var xhr = new XMLHttpRequest();
function message() {
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


function confirm(){
    function message() {
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
}