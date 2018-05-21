// var urlstr = location.href;


// var urlstatus = false;

// $("#menu a").each(function () {

//     if ((urlstr + '/').indexOf($(this).attr('href')) > -1 && $(this).attr('href') != '') {

//         $(this).addClass('cur');
//         urlstatus = true;

//     } else {

//         $(this).removeClass('cur');

//     }

// });

// if (!urlstatus) {
//     $("#menu a").eq(0).addClass('cur');
// }
var num = JSON.parse(sessionStorage.getItem("people")); //取身份数组
var kills = JSON.parse(sessionStorage.getItem("kills")); //取死亡名单
if (kills == undefined) {
    kills = [];
}
var ii = JSON.parse(sessionStorage.getItem("ii")); //取死人身份
if (ii == undefined) {
    ii = 1;
}
console.log(num);
console.log("杀死的是" + kills + "号，" + "身份" + ii);
var btn = JSON.parse(sessionStorage.getItem("btn")); //判断游戏步骤
if (btn == undefined) {
    btn = 1;
}
var day = JSON.parse(sessionStorage.getItem("day")); //游戏天数
if (day == undefined) {
    day = 0;
}
$(document).ready(function () {
    $("#step1").click(function () {
        if (btn == (1 + day * 4)) { //点击数
            window.location.href = "杀人+投票.html";
            btn++;
            sessionStorage.setItem("btn", JSON.stringify(btn)); //存储步骤
        } else {
            alert("请按照步骤点击");
        }
    }); //步骤1
    $("#step2").click(function () {
        if (btn === (2 + day * 4)) {
            $(this).css({
                "background-color": "#f0f0f0"
            });
            $(".triangle2").css({
                "border-right": "15px solid #f0f0f0"
            });
            alert("请进入下一环节");
            btn++;
        } else {
            alert("请按照步骤点击");
        }
    }); //步骤2
    $("#step3").click(function () {
        if (btn == (3 + day * 4)) {
            $(this).css({
                "background-color": "#f0f0f0"
            });
            $(".triangle3").css({
                "border-right": "15px solid #f0f0f0"
            });
            alert("请进入下一环节");
            btn++;
        } else {
            alert("请按照步骤点击");
        }
    }); //步骤3
    $("#step4").click(function () {
        if (btn == (4 + day * 4)) {
            $(this).css({
                "background-color": "#f0f0f0"
            });
            $(".triangle4").css({
                "border-right": "15px solid #f0f0f0"
            });
            window.location.href = "杀人+投票.html";
            btn++;
            day++;
            sessionStorage.setItem("day", JSON.stringify(day)); //存储天数
            sessionStorage.setItem("btn", JSON.stringify(btn)); //存储步骤
        } else {
            alert("请按照步骤点击");
        }
    }); //步骤4
});
$(document).ready(function () {
    if (btn == (2 + day * 4)) {
        $("#step1").css({
            "background-color": "#f0f0f0"
        });
        $(".triangle1").css({
            "border-right": "15px solid #f0f0f0"
        });
    } //从杀人页面跳转回来后第一个按钮变灰+死亡信息

    console.log("步骤数" + btn);
    console.log("天数" + day);
    $(".footer-1").click(function () {
        var footer1 = window.confirm("强制退出？");
        if (footer1 == true) {
            window.location.href = "../js2-3/task2-1.html";
        }
        sessionStorage.clear("btn", "btn", "btn3", "kills");
    }); //强制结束游戏
    $(".footer-2").click(function () {
        window.location.href = "法官日志.html";
    }); //跳转法官日志
    $(document).ready(function () { //复制生成块
        for (var w = 0; w <= day; w++) {
            if (w > 0) {
                $(".day").first().clone().prependTo($("main"));
            }
        }
        for (var p = 0; p <= day; p++) {
            $(".day-1").eq(p).html("第" + (p + 1) + "天"); //改变天数
        }
        for (var c = 0; c < kills.length; c++) { //死人号数
            if (kills[c + 1] % 2 == 0) {
                $(".main-2-row-font5").eq(c).text((kills[c] + 1) + "号被投票投死");
            } else {
                $(".main-2-row-font5").eq(c).text((kills[c] + 1) + "号被杀手杀死");
            }
        }
        for (var z = 0; z < ii.length; z++) { //分辨身份
            $(".main-2-row-font6").eq(z).text("身份是" + ii[z]);
        }

        $(".day-2").hide().last().show(); //隐藏
        $(".day-3").hide().last().show();
        $(".day-1").click(function () {
            $(this).siblings().toggle();
        });
        for (var o = 0; o < day; o++) {
            console.log(day, o);
            $(".day").eq(o).find(".column-2").css({
                "background-color": "#f0f0f0"
            });
            $(".day").eq(o).find(".column-1").css({
                "border-right": "15px solid #f0f0f0"
            });
        }
    });



    var m = 0; //杀手
    var n = 0; //平民
    var y = 0; //已死的杀手
    var s = 0; //已死的平民
    for (var q = 0; q <= num.length - 1; q++) { //分辨杀人平民数量
        if (num[q] == 0) {
            m++;
        } else {
            n++;
        }
    }
    for (var g = 0; g <= ii.length - 1; g++) { //分辨已死的杀人平民数量
        if (ii[g] == "杀手") {
            y++;
        } else {
            s++;
        }
    }
    console.log(m, n, y, s);
    if (m == y || n - s == m - y) {
        top.location = '游戏结束.html';
    } //结束游戏并跳转
    sessionStorage.setItem("m", JSON.stringify(m));
    sessionStorage.setItem("n", JSON.stringify(n));
    sessionStorage.setItem("y", JSON.stringify(y));
    sessionStorage.setItem("s", JSON.stringify(s));
});