var n = document.getElementById("name");
var p = document.getElementById("name-pwd");
var error = document.getElementById("error");
console.log(n.value);

function user() {
    if (n.value==="admin" ||n.length===0 || n.value==="") {
        $("#error").empty();
        console.log(error);
    }else {
        error.innerHTML = "无此用户";
        console.log(error);
    }
}
function login() {
    console.log(n.value);
    console.log(p.value);
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.open("Post","/carrots-admin-ajax/a/login",true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("name=" + n.value + "&pwd=" + p.value);

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState === 4) {
            if (xmlhttp.status === 200) {
                var jsons = JSON.parse(xmlhttp.responseText);
                console.log(jsons);
                if (jsons.code === 0) {
                    window.location.href = "https://www.jnshu.com/"
                } else {
                    alert("账号或密码错误")
                }
            }
        }
    };
}
