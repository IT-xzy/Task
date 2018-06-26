var killsInit = JSON.parse(localStorage.getItem('killInit'));
var kills = JSON.parse(localStorage.getItem('kills'));
var deadmen = JSON.parse(localStorage.getItem(('dead')));
var day = JSON.parse(localStorage.getItem(('day')));
var gameprocess = JSON.parse(localStorage.getItem(('gameprocess')));
//定义天数

//0 杀人 1 投票
function jump() {
    window.location.href = "kill-record.html?page=0";
}

//跳转到杀人页面
function jumptovote() {
    window.location.href = "task4-vote.html";
}


function showpage() {
    $(document).ready(function () {
        for (i = 0; i < day; i++) {
            var strHtml = [];
            strHtml.push(
                '<h1>第' + (i + 1) + '天</h1>' +
                '<ul>' + '<li>' + '<img src="img/moon.png">' + '<button class="step1">' + "杀手杀人" +
                '</button>' + '</li>' + '<li>' + '<img src="img/sun.png">' + '<div class="step2">' + "亡灵请发表遗言" +
                '</div>' + '</li>' + '<li>' + '<div class="step3">' + "玩家依次发言" +
                '</div>' + '</li>' + '<li>' + '<button class="step4">' + "投票" +
                '</button>' + '</li>' + '</ul>'
            );
            $("main").append(strHtml);
        }
    });
}

showpage();

//根据天数显示相应的选择器
function show() {
    switch (day) {
        case 1:
            $(document).ready(function () {
                $("body").find("ul").eq(0).show();
            });
            break;
        case 2:
            $(document).ready(function () {
                $("body").find("ul").eq(1).show();
            });
            break;
        case 3:
            $(document).ready(function () {
                $("body").find("ul").eq(2).show();
            });
            break;
        case 4:
            $(document).ready(function () {
                $("body").find("ul").eq(3).show();
            });
            break;
        case 5:
            $(document).ready(function () {
                $("body").find("ul").eq(4).show();
            });
            break;
        case 6:
            $(document).ready(function () {
                $("body").find("ul").eq(5).show();
            });
            break;
        case 7:
            $(document).ready(function () {
                $("body").find("ul").eq(6).show();
            });
            break;
        case 8:
            $(document).ready(function () {
                $("body").find("ul").eq(7).show();
            });
            break;
        case 9:
            $(document).ready(function () {
                $("body").find("ul").eq(8).show();
            });
            break;
        default:
            alert("9999");
    }
}

show();
//状态机
$(document).ready(function () {
    var fsm = {
        //   初始化
        state: JSON.parse(localStorage.getItem(('step'))),
        timetokill: function () {
            switch (fsm.state) {
                case"none":
                    console.log(fsm.state);
                    fsm.state = "kill";
                    $(".step1").addClass("after");
                    alert("天黑请闭眼");
                    localStorage.setItem('step', JSON.stringify(fsm.state));
                    window.location.href = "task4-kill.html";
                    break;
                case"kill":
                    alert("请勿重复点击");
                    break;
                case"speak":
                case"vote":
                    alert("请按照步骤来");
                    break;
            }
        },
        timetospeak: function () {
            switch (fsm.state) {
                case"kill":
                    fsm.state = "speak";
                    $(".step2").addClass("after");
                    alert("亡灵发表遗言");
                    break;
                case"speak":
                    alert("请勿重复点击");
                    break;
                case"none":
                case"vote":
                    alert("请按照步骤来");
                    break;
            }
        },
        timetotalk: function () {
            switch (fsm.state) {
                case"speak":
                    fsm.state = "vote";
                    $(".step3").addClass("after");
                    alert("玩家依次发言");
                    break;
                case"none":
                case"kill":
                    alert("请按照步骤来");
                    break;
                case"vote":
                    alert("请勿重复点击");
                    break;
            }
        },
        timetovote: function () {
            switch (fsm.state) {
                case"vote":
                    fsm.state = "none";
                    $(".step4").addClass("after");
                    alert("请投票");
                    window.location.href = "task4-vote.html";
                    break;
                case"speak":
                case"kill":
                case"none":
                    alert("请按照步骤来");
                    break;
            }
        }


    };
    $(".step1").click(function () {
        if ($(this).hasClass("after")) {
            alert("请别乱玩兄dei~")
        } else {
            fsm.timetokill();
        }
    });
    $(".step2").click(function () {
        if ($(this).hasClass("after")) {
            alert("请别乱玩兄dei~")
        } else {
            fsm.timetospeak();
        }
    });
    $(".step3").click(function () {
        if ($(this).hasClass("after")) {
            alert("请别乱玩兄dei~")
        } else {
            fsm.timetotalk();
        }
    });
    $(".step4").click(function () {
        if ($(this).hasClass("after")) {
            alert("请别乱玩兄dei~")
        } else {
            fsm.timetovote();
        }
    });

});
//点击显示具体的天数
$(document).ready(function () {
    $("h1").click(function () {
        $("ul").hide();
        $(this).next().show();
    })
});

function count() {
    $(document).ready(function () {
        for (i = 0; i < deadmen.length; i++) {
            switch (deadmen[i].ktime) {
                case 1:
                    if (deadmen[i].kmode === "killdead") {
                        var txt1 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt1).addClass("after");
                    }
                    else {
                        var txt2 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt2).addClass("after");
                        $("ul").eq(0).find("div").addClass("after");
                    }
                    break;
                case 2:
                    if (deadmen[i].kmode === "killdead") {
                        var txt3 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt3).addClass("after");
                    }
                    else {
                        var txt4 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt4).addClass("after");
                        $("ul").eq(1).find("div").addClass("after");
                    }
                    break;
                case 3:
                    if (deadmen[i].kmode === "killdead") {
                        var txt5 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt5).addClass("after");
                    }
                    else {
                        var txt6 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt6).addClass("after");
                        $("ul").eq(2).find("div").addClass("after");
                    }
                    break;
                case 4:
                    if (deadmen[i].kmode === "killdead") {
                        var txt7 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt7).addClass("after");
                    }
                    else {
                        var txt8 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt8).addClass("after");
                        $("ul").eq(3).find("div").addClass("after");
                    }
                    break;
                case 5:
                    if (deadmen[i].kmode === "killdead") {
                        var txt9 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt9).addClass("after");
                    }
                    else {
                        var txt10 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt10).addClass("after");
                        $("ul").eq(4).find("div").addClass("after");
                    }
                    break;
                case 6:
                    if (deadmen[i].kmode === "killdead") {
                        var txt11 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt11).addClass("after");
                    }
                    else {
                        var txt12 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt12).addClass("after");
                        $("ul").eq(5).find("div").addClass("after");
                    }
                    break;
                case 7:
                    if (deadmen[i].kmode === "killdead") {
                        var txt13 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt13).addClass("after");
                    }
                    else {
                        var txt14 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt14).addClass("after");
                        $("ul").eq(6).find("div").addClass("after");
                    }
                    break;
                case 8:
                    if (deadmen[i].kmode === "killdead") {
                        var txt15 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt15).addClass("after");
                    }
                    else {
                        var txt16 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt16).addClass("after");
                        $("ul").eq(7).find("div").addClass("after");
                    }
                    break;
                case 9:
                    if (deadmen[i].kmode === "killdead") {
                        var txt17 = $("<p></p>").text("昨天晚上被杀手杀死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt17).addClass("after");
                    }
                    else {
                        var txt18 = $("<p></p>").text("昨天晚上大家投死的是" + deadmen[i].number + "号玩家，他的身份是" + deadmen[i].identity);
                        $("body").find("button").eq(i).after(txt18).addClass("after ");
                        $("ul").eq(8).find("div").addClass("after");
                    }
                    break;
                default:
                    alert(999)
            }
        }

    })
}

count();

