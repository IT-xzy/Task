var get = sessionStorage.getItem("send");
console.log(get);
var send = JSON.parse(get);
console.log(send);

var i = 0; //定义按钮点击次数i

function checkStatus() { //按钮点击事件
    console.log(send.length);
    i++;
    console.log(i);
    var j = Math.floor(i / 2) + 1; //计算身份序号值i=0,j=1; i=1;j=1; i=2,j=2; i=3,j=2; i=4,j=3;
    console.log(j);
    var p0 = document.getElementById("drawNum"); //获取页面身份序号值
    console.log(p0);
    var txt = p0.textContent;
    p0.textContent = j;

    //跳转页面 send=1,i=2,send=2,i=4
    if (i == (send.length * 2)) {

        window.location.href = "./diary.html";
    } else {

    }
    if ((i % 2 == 1) && (i < (send.length) * 2)) {//加一个判断，点击次数要小于人数长度的两倍，这样就不会出现一个新的身份页面了
        console.log(send[i - 1]);
        var p1 = document.getElementById("btn-see");
        var x1 = j + 1;

        var hide = "隐藏并传递给" + x1 + "号";
        p1.textContent = hide;
        if (i == (send.length * 2 - 1)) {
            p1.textContent = "法官查看";
        } else {

        }
        if (send[j - 1] == "杀  手 1 人") {
            document.getElementById("drawContent").innerHTML = "<img src='img/head-1.png'/>\n" +
                "<p class='role'>角色：杀手</p>\n" +
                "<p class='word-group'>西伯利亚<p>\n" +
                "<div class='tips'>想办法猜到别人的词，同时要注意不要暴露自己哦！</div>";

        } else {
            document.getElementById("drawContent").innerHTML = "<img src='img/head-2.png'/>\n" +
                "<p class='role'>角色：平民</p>\n" +
                "<p class='word-group'>东伯利亚<p>\n" +
                "<div class='tips'>想办法猜到别人的词，同时要注意不要暴露自己哦！</div>";
        }
    } else if(i < (send.length) * 2){
        document.getElementById("drawContent").innerHTML = "<img src='img/draw-head.png'/>";
        var p1 = document.getElementById("btn-see");
        var check = "查看" + j + "号身份";
        p1.textContent = check;
    }

}
$(function(){
    $(".header-right").click(function(){
    sessionStorage.removeItem("checkStep");
    sessionStorage.removeItem("countDay");
    sessionStorage.removeItem("de");
    sessionStorage.removeItem("ki");
    sessionStorage.removeItem("pe");
    sessionStorage.removeItem("send");
    sessionStorage.removeItem("gameOver");
    sessionStorage.removeItem("initial");
    sessionStorage.removeItem("stepTwo");
    sessionStorage.removeItem("x");
    sessionStorage.removeItem("y");
    })
})