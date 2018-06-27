var button = document.getElementsByTagName("button")[0];



button.addEventListener("click", function () {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    } else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    // 捕获数据
    let ip = document.getElementsByTagName("input")[0].value;
    let id = document.getElementsByTagName("input")[1].value;
    // console.log(ip);
    // console.log(id);
    let admin = "name=" + ip + "&" + "pwd=" + id;
    console.log(admin);

    // 进行一步对接

    xmlhttp.onreadystatechange = function () {

        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            let text = JSON.parse(xmlhttp.responseText);
            console.log(text);
            if (text.message == "success") {
                console.log(text.message + 5555)
                window.location.href = "http://dev.admin.carrots.ptteng.com/";
            } else {
                document.getElementsByTagName("p")[1].innerHTML = text.message;
                console.log(333)
            }
        }
    };
    xmlhttp.open("POST", "../carrots-admin-ajax/a/login", true);
    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlhttp.send(admin);
    // 监听改变
});