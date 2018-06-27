var get = sessionStorage.getItem("send");
console.log(get);
var send = JSON.parse(get);
console.log(send);
var getd = sessionStorage.getItem("de");
var dead = JSON.parse(getd);
var checkstep = sessionStorage.getItem("checkStep");
var day = sessionStorage.getItem("countDay");
var arr = [];
for (i = 0; i < (send.length); i++) { //把之前的数组转化为另一个数组，方便这个页面使用
    console.log(send[i]);
    if (send[i] == "平  民 1 人") {
        arr.push("平民");
    } else {
        arr.push("杀手");
    }
}
console.log(arr);
$(function () {
    for (var i = 0; i < arr.length; i++) {
        var j = i + 1;
        $(".content").append('<div class="grid">\n' +
            '<div class="grid-main">\n' +
            '<span class="grid-main-top">\n' + arr[i] + '</span>' +
            '<span class="grid-main-bottom">\n' + j + "号" + '</span>' +
            '</div>\n' +
            '</div>\n')
    }
    console.log(day);
    console.log(checkstep);
    console.log(dead);
    if (day != undefined) {
        $(".header-left").remove();
        $(".header-right").remove();
        $(".vote").remove(".vote");
        $("footer").append(
            '<a href="./day.html" class="vote">' +
            '返回' +
            '</a>'
        )
        if (checkstep != undefined) {
            for (i = 0; i < dead.length; i++) {
                var dedai = dead[i];
                $(".grid-main-top").eq(dedai).css("background-color", "#83b09a")
            }
        } else {

        }
    }

    $(".header-right").click(function () {
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