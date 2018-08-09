//游戏进行天数
var day = +sessionStorage.getItem("day");
if (day == 0) {
    var day = 1;
}
sessionStorage.setItem("day", day);
//存储状态机状态;
var stateMachine;
//获取存储缓存json字符串并转换为数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
//天数数组
var dayArray = ["十", "一", "二", "三", "四", "五", "六", "七", "八", "九"];
//切换天数。根据天数生成
for (let i = 1; i < day; i++) {
    $("#day1").clone().attr("id", "day" + (i + 1)).appendTo("main");
    let a = "#day" + (i + 1);
    $(a).find(".dayNumber").text(dayArray[i + 1]);
}
//创建执行顺序状态机
//状态数组
var state = ["kill", "lastWords", "playerSpeak", "vote"]
var order = new StateMachine({
    init: "kill",
    transitions: [{
            name: "killing",
            from: "kill",
            to: "lastWords"
        },
        {
            name: "lastSpeaking",
            from: "lastWords",
            to: "playerSpeak"
        }, {
            name: "playerSpeaking",
            from: "playerSpeak",
            to: "vote"
        }, {
            name: "voting",
            from: "vote",
            to: "kill"
        }
    ],
    methods: {
        /* 如果状态转换不能正常转换就会触发下面的错误处理机制 */
        onInvalidTransition: function (transitions, from, to) {
            switch (from) {
                case "kill":
                    alert("请点击杀手杀人");
                    break;
                case "lastWords":
                    alert("请点击亡灵发表遗言");
                    break;
                case "playerSpeak":
                    alert("请点击玩家依次发言");
                    break;
                case "vote":
                    alert("请点击请点击全民投票");
                    break;
            }
        }
    }
})
//获取状态机状态
//并更改样式
$(function () {
    if (sessionStorage.getItem("stateMachine")) {
        stateMachine = +sessionStorage.getItem("stateMachine");
        console.log(stateMachine);
        //根据状态更改颜色
        //更改前几天样式
        if (day > 1) {
            var lastDay = day - 1;
            for (; lastDay > 0; lastDay--) {
                var lastDayTemp = "#day" + lastDay + " .textBox";
                var after = "<style>#day" + lastDay + " .order .textBox::after{border-right: 13px solid #1fba6e !important;}</style>"
                $(lastDayTemp).css("background", "#1fba6e");
                $(lastDayTemp).append(after);
                $("#day" + lastDay).find(".gameOrder").hide();
                $("#day" + lastDay).find(" .textBox").click(function () {
                    alert("请执行下一项操作")
                })
            }
        }
        //更改当天样式
        if (stateMachine != 0) {
            for (let i = 0; i < stateMachine; i++) {
                var dayTemp = "#day" + day + " .textBox";
                var after = "<style>#day" + day + " .order .choose:nth-child(" + (i + 1) + ") .textBox::after{border-right: 13px solid #1fba6e !important;}</style>"
                $(dayTemp).eq(i).css("background", "#1fba6e");
                $(dayTemp).eq(i).append(after);
            }
        }
        //页面判断切换状态机
        switch (stateMachine) {
            case 1:
                order.killing();
                break;
            case 2:
                order.killing();
                order.lastSpeaking();
                break;
            case 3:
                order.killing();
                order.lastSpeaking();
                order.playerSpeaking();
                break;
        }

    }
    //获取被杀人
    var dead;
    if (sessionStorage.getItem("choose")) {
        dead = +sessionStorage.getItem("choose");
        //获取杀死数组
        if (sessionStorage.getItem("killDead")) {
            var killDead = JSON.parse(sessionStorage.getItem("killDead"));
            for (let i = 0; i < killDead.length; i++) {
                var killTemp = "#day" + (i + 1) + " #killed";
                var a = i;
                $(killTemp).text(killDead[a]);
                $(killTemp).css("display", "inline-block")
            }
        }

    }
    //获取被投死
    if (sessionStorage.getItem("chooseVote")) {
        var voteChoose = +sessionStorage.getItem("chooseVote");
        if (sessionStorage.getItem("voteDead")) {
            var voteDead = JSON.parse(sessionStorage.getItem("voteDead"));
            for (let i = 0; i < voteDead.length; i++) {
                var voteTemp = "#day" + (i + 1) + " #voted";
                var b = i;
                $(voteTemp).text(voteDead[b]);
                $(voteTemp).css("display", "inline-block");
            }
        }
    }
    //每天按钮隐藏
    $(".title").click(function () {
        $(this).next().toggle();
    })
})

//绑定事件
//杀手杀人
var orderButtonTemp = "#day" + day + " .textBox";
$(orderButtonTemp).eq(0).on("click", function () {
    if (order.can("killing")) {
        stateMachine = 1;
        sessionStorage.setItem("stateMachine", stateMachine);
        location.href = "killing.html";
    }
    order.killing();
})
//尸体发言
$(orderButtonTemp).eq(1).on("click", function () {
    if (order.can("lastSpeaking")) {
        stateMachine = 2;
        sessionStorage.setItem("stateMachine", stateMachine);
        alert("请死者亮明身份并且发表遗言");
    }
    order.lastSpeaking();
    if (stateMachine) {
        var after = "<style>.order .choose:nth-child(" + stateMachine + ") .textBox::after{border-right: 13px solid #1fba6e !important;}</style>"
        $(orderButtonTemp).eq(stateMachine - 1).css("background", "#1fba6e");
        $(orderButtonTemp).append(after);
    }

})
//玩家发言
$(orderButtonTemp).eq(2).on("click", function () {
    if (order.can("playerSpeaking")) {
        stateMachine = 3;
        sessionStorage.setItem("stateMachine", stateMachine);
        alert("玩家依次发言讨论");
    }
    order.playerSpeaking();
    if (stateMachine) {
        var after = "<style>.order .choose:nth-child(" + stateMachine + ") .textBox::after{border-right: 13px solid #1fba6e !important;}</style>"
        console.log(after)
        $(orderButtonTemp).eq(stateMachine - 1).css("background", "#1fba6e");
        $(orderButtonTemp).append(after);
    }


})
//投票
$(orderButtonTemp).eq(3).on("click", function () {
    if (order.can("voting")) {
        stateMachine = 0;
        sessionStorage.setItem("stateMachine", stateMachine);
        location.href = "vote.html";
    }
    order.voting();

});
//footer按钮
$("#closeBox").on("click", function () {
    var closeClick = confirm("结束本轮游戏吗？")
    if (closeClick) {
        location.href = "gameOver.html"
    }
})
$("#diary").on("click", function () {
    location.href = "diary.html"
})