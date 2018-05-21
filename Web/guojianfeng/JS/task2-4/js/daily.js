/**
 * Created by guojianfeng on 2017/10/21.
 */

// 解析sessionStorage
var p = 0;
var winner;
var h = JSON.parse(sessionStorage.getItem("h")); //记录天数
var f = parseInt(window.sessionStorage.getItem("f"));
var visited = parseInt(JSON.parse(sessionStorage.getItem("visited")));//用于判断是否已杀过人
var x = parseInt(JSON.parse(window.sessionStorage.getItem("x")));
var y = parseInt(JSON.parse(window.sessionStorage.getItem("y")));
var gamePlayer = JSON.parse(window.sessionStorage.getItem("gamePlayer"));
var voted = JSON.parse(sessionStorage.getItem("voted"));
console.log(voted);
var death = JSON.parse(sessionStorage.getItem("death"));
console.log(death);
console.log(gamePlayer);
var killerNum = parseInt(JSON.parse(sessionStorage.getItem("killerNum")));
var personNum = parseInt(JSON.parse(sessionStorage.getItem("personNum")));
var toHome = document.getElementById("back");
var day = document.getElementById("day");


$(document).ready(function () {
    day.innerHTML = "第" + h + "天";
    $("#wolf").click(function () {
        if (visited === 1) {
            alert("今天你已经杀过人了"); //一天内不可以多次杀人
        }
        else {
            window.location.href = "../html/kill.html";
            $(this).css("background-color", "#83b09a");
            $($(this).find("span")).css("border-color", "transparent #83b09a transparent transparent");
        }
    });

    $("#last-word").click(function () {
        if (visited === 1 && p === 0) {
            alert("请亡灵发表遗言");
            $(this).css("background-color", "#83b09a");
            $($(this).find("span")).css("border-color", "transparent #83b09a transparent transparent");
            p++;
        }
        else if (visited === 0 || p !== 0) {
            alert("请按流程点击");
        }
    });
    $("#speak").click(function () {
        if (visited === 1 && p === 1) {
            alert("玩家依次发言");
            $(this).css("background-color", "#83b09a");
            $($(this).find("span")).css("border-color", "transparent #83b09a transparent transparent");
            p++;
        }
        else if (visited === 0 || p < 2) {
            alert("请按流程点击");
        }
    });
    $("#vote").click(function () {
        if (visited === 1 && p === 2) {
            window.location.href = "vote.html";
            $(this).css("background-color", "#83b09a");
            $($(this).find("span")).css("border-color", "transparent #83b09a transparent transparent");
        }
        else if (visited === 0 || p < 3) {
            alert("请按流程点击");
        }
    });
    console.log(h);
    if (h > 1) {
        // $("#vote-who").html(voted[0].number + "号被全民投死，" + voted[0].number + "号是" + voted[0].role);
        ppp();
        function ppp() {
            for (var o = 0; o < (h - 1); o++) {
                var note = "<div class=\"parent\">"+
                    "<div class=\"note\">第1天</div>" +
                    "<div class=\"step\">" +
                    "<p class=\"moon\"></p>" +
                    "<p class=\"sun\"></p></div></div>";
                $("#container").append(note);
                var a = $(".note");
                $(a[o]).text("第" + (o + 1) + "天");
            }
            for (var j = 0; j < (h - 1); j++) {
                var b = $(".moon");
                $(b[j]).text("晚上：" + death[j].number + "号被杀手杀死，" + death[j].number + "号是" + death[j].role);
            }
            for (var k = 0; k < (h - 1); k++) {
                var c = $(".sun");
                $(c[k]).text("白天：" + voted[k].number + "号被全民投死，" + voted[k].number + "号是" + voted[k].role);
            }
        }
    }
    $(".parent").click(function () {
        $(this).find(".step").toggle();
    });
    if (visited === 1) {
        $("#wolf").css("background-color", "#83b09a");
        $($("#wolf").find("span")).css("border-color", "transparent #83b09a transparent transparent");
        //visited=1代表杀过人，杀手杀人按钮颜色变化
        $("#who-die").html(death[0].number + "号被狼人杀死，" + death[0].number + "号是" + death[0].role);

    }


    win();
    function win() {
        if ( f === 1) {
            if (killerNum - x === 0) {
                winner = "村民";
                confirm("游戏结束，村民胜利");
                sessionStorage.setItem("winner", JSON.stringify(winner));
                window.location.href = "final.html";
            } else if ((personNum - y) < (killerNum - x)) {
                winner = "狼人";
                confirm("游戏结束，狼人胜利");
                sessionStorage.setItem("winner", JSON.stringify(winner));
                window.location.href = "final.html";
            }
        } else {
            return false;
        }
    }

    // 返回上一页
    toHome.onclick = function () {
        window.history.back(-1);
    };
});