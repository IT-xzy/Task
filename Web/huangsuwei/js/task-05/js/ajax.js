var idEnter = document.getElementById("idEnter");
idEnter.onclick = function () {
    var user = document.getElementById('name').value;
    var psw = document.getElementById('code').value;
    console.log(user);
    console.log(psw);
    var xmlhttp;
    if (window.XMLHttpRequest){
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP")
    }
    xmlhttp.open('POST','/carrots-admin-ajax/a/login',true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send('name=' + user + '&pwd=' + psw);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4) {
            if (xmlhttp.status === 200) {
                var jsons = JSON.parse(xmlhttp.responseText);
                console.log(jsons);
                if (jsons.code === 0) {
                    window.location.href = "http://dev.admin.carrots.ptteng.com/#/dashboard"
                } else {
                    alert(jsons.message)
                }
            }
        }

    }
};