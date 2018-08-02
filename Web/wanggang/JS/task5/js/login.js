var xhr;
// window.onload = function () {




if (window.XMLHttpRequest) {
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xhr = new XMLHttpRequest();
} else {
    // IE6, IE5 浏览器执行代码
    xhr = new ActiveXObject("Microsoft.XMLHTTP");
}

function login() {
    //获取输入框数据
    var name = document.getElementsByTagName("input")[0].value;
    var pwd = document.getElementsByTagName("input")[1].value;
    var userTemp = "name=" + name + "&pwd=" + pwd;
    xhr.open("POST", "/carrots-admin-ajax/a/login", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    console.log(userTemp);
    xhr.send(userTemp);
    // event.stopPropagation();
}
xhr.onreadystatechange = function () {
    console.log(xhr.readyState);
    if (xhr.readyState === 4 && xhr.status === 200) {
        var response = JSON.parse(xhr.responseText);
        document.getElementsByClassName("prompt")[0].innerHTML = response.message;
    }
}

document.getElementsByTagName("button")[0].addEventListener("click", login,true);

// }