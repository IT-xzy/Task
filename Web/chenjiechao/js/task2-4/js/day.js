$(function () {
    var fsm = new StateMachine({
        init: 'begin',
        transitions: [{
                name: 'step1',
                from: 'begin',
                to: 'status1'
            },
            {
                name: 'step2',
                from: 'status1',
                to: 'status2'
            },
            {
                name: 'step3',
                from: 'status2',
                to: 'status3'
            },
            {
                name: 'step4',
                from: 'status3',
                to: 'begin' 
            }
        ],
        methods: {
            onStep1: function () {
                $(".btn-step1").eq(day - 1).css("background", "#83b09a"); //更换颜色
                $(".triangle-left-1").eq(day - 1).css("border-right-color", "#83b09a"); //更换小三角颜色
                sessionStorage.setItem("stepTwo", fsm.state);
                sessionStorage.setItem("checkStep", fsm.state);
            },
            onStep2: function () {
                $(".btn-step2").eq(day - 1).css("background", "#83b09a");
                $(".triangle-left-2").eq(day - 1).css("border-right-color", "#83b09a");
                sessionStorage.setItem("stepTwo", fsm.state);
            },
            onStep3: function () {
                $(".btn-step3").eq(day - 1).css("background", "#83b09a");
                $(".triangle-left-3").eq(day - 1).css("border-right-color", "#83b09a");
                sessionStorage.setItem("stepTwo", fsm.state);
            },
            onStep4: function () {
                sessionStorage.setItem("stepTwo", fsm.state);
                sessionStorage.setItem("checkStep", fsm.state);
            }
        }
    });




    // if(che)
    var day = sessionStorage.getItem("countDay"); //获取天数
    console.log(day);
    if (day == undefined) { //最开始天数没有，赋值为1
        var day = 1;
        sessionStorage.setItem("countDay", day);
    }








    for (i = 1; i < day; i++) {
        $("main").append(
            '<div class="day1">\n' +
            '<button class="day1-tt">' +
            '第' + (i + 1) + '天' +
            '</button>' +
            '<div class="day1-content">' +
            '<div class="triangle-top">' +
            '</div>' +
            '<div class="content-main">' +
            '<div class="main-step s1">' +
            '<img src="img/moon.png">' +
            '<div class="triangle-left-1">' +
            '</div>' +
            '<button class="btn-step1">' +
            '杀手杀人' +
            '</button>' +
            '</div>' +
            '<div class="main-step s2">' +
            '<img src="img/sun.png">' +
            '<div class="triangle-left-2">' +
            '</div>' +
            '<button class="btn-step2">' +
            '亡灵发表遗言' +
            '</button>' +
            '</div>' +
            '<div class="main-step s3">' +
            '<div class="triangle-left-3">' +
            '</div>' +
            '<button class="btn-step3">' +
            '玩家依次发言' +
            '</button>' +
            '</div>' +
            '<div class="main-step s4">' +
            '<div class="triangle-left-4">' +
            '</div>' +
            '<button class="btn-step4">' +
            '全民投票' +
            '</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>'
        )
    }


    var day = sessionStorage.getItem("countDay");
    console.log(day);
    console.log(fsm.state);
    var getd = sessionStorage.getItem("de"); //获取死者
    var dead = JSON.parse(getd);

    var getp = sessionStorage.getItem("pe"); //获取存活平民序号
    var peopleNum = JSON.parse(getp);

    var getk = sessionStorage.getItem("ki"); //获取存活杀手序号
    var killNum = JSON.parse(getk);

    var geta = sessionStorage.getItem("initial"); //获取初始编号
    var arr = JSON.parse(geta); //取得游戏初始数组
    if (dead != undefined) {
        var time = Math.ceil(dead.length / 2);
        console.log(time);

        for (i = 0; i < dead.length; i++) {
            // i=0,eq=0,de=0; 
            // i=1,eq=0,de=1, 
            // i=2,eq=1,de=2,
            // i=3,eq=1,de=3,
            var j = Math.floor(i / 2);
            var h = dead[i] + 1;
            if (i % 2 == 0) {
                $(".s1").eq(j).after(
                    '<p class="sun">' +
                    '晚上：' + h + '号被杀手杀死，' + h + '号是' + arr[dead[i]] +
                    '</p>')

            } else {
                $(".s4").eq(j).after(
                    '<p class="sun">' +
                    '白天：' + h + '号被全民投票投死，' + h + '号是' + arr[dead[i]] +
                    '</p>')
            }
        }
    }
    // console.log(day);
    // var xx = $(".day1-tt");
    //     console.log(xx);

    $(".day1-tt").click(function () {
        var x = $(".day1-tt").index(this); //获得点击的这个元素相对于class名为$(".day1-tt")的位置
        console.log(x);
        // alert($(this).index());
        $(".day1-content").eq(x).toggle(); //使得游戏过程显示或隐藏
    })


    if (day > 1) { //使进入杀人页面或投票页面返回后，已过的天数过程隐藏起来。
        for (t = 0; t < (day - 1); t++)
            $(".day1-content").eq(t).toggle();
    }

    $(".btn-step1").eq(day - 1).click(function () { //点击步骤1
        if (fsm.state == "begin") {
            fsm.step1();
            alert("进入杀人环节");
            window.location.href = "./vote.html";
            console.log(fsm.state);
        } else {
            alert("请按步骤进行");
        }
    });

    $(".btn-step2").eq(day - 1).click(function () { //点击步骤2
        if (fsm.state == "status1") {
            if (confirm("死者请留遗言") == true) {
                fsm.step2();
            } else {}
        } else {
            alert("请按步骤进行");
        }
    });
    $(".btn-step3").eq(day - 1).click(function () { //点击步骤3
        if (fsm.state == "status2") {
            if (confirm("玩家依次发言") == true) {
                fsm.step3();
            } else {}
        } else {
            alert("请按步骤进行");
        }
    });
    $(".btn-step4").eq(day - 1).click(function () { //点击步骤4
        if (fsm.state == "status3") {
            if (confirm("开始投票") == true) {
                fsm.step4();
                window.location.href = "./vote.html";
                if (day == undefined) {
                    var day = 1;
                    console.log(day);
                }
                var day = sessionStorage.getItem("countDay");
                day++;
                console.log(day);
                sessionStorage.setItem("countDay", day);


            } else {}
        } else {
            alert("请按步骤进行");
        }
    });
    var One = sessionStorage.getItem("stepTwo");
    if (One == "status1") {
        fsm.step1();
    }
    // var Two = sessionStorage.getItem("stepThree");
    if (One == "status2") {
        fsm.step1();
        fsm.step2();
    }
    // var Three = sessionStorage.getItem("stepFour");
    if (One == "status3") {
        fsm.step1();
        fsm.step2();
        fsm.step3();
    }
    // if((One == "begin") && (day > 1)){
    //     fsm.step1();
    //     fsm.step2();
    //     fsm.step3();
    //     fsm.step4();
    // }
    // var Four = sessionStorage.getItem("stepFive");
    for (z = 0; z < (day - 1); z++) {
        console.log(z);
        $(".btn-step1").eq(z).css("background", "#83b09a");
        $(".triangle-left-1").eq(z).css("border-right-color", "#83b09a");
        $(".btn-step2").eq(z).css("background", "#83b09a");
        $(".triangle-left-2").eq(z).css("border-right-color", "#83b09a");
        $(".btn-step3").eq(z).css("background", "#83b09a");
        $(".triangle-left-3").eq(z).css("border-right-color", "#83b09a");
        $(".btn-step4").eq(z).css("background", "#83b09a");
        $(".triangle-left-4").eq(z).css("border-right-color", "#83b09a");

    }
    // console.log(fsm.state);
    // if (One == "begin") {
    //     fsm.step4();
    // sessionStorage.removeItem("stepTwo");
    // sessionStorage.removeItem("stepThree");
    // sessionStorage.removeItem("stepFour");
    // $(".btn-step1").eq(day - 1).css("background", "#29bde0");
    // $(".triangle-left-1").eq(day - 1).css("border-right-color", "#29bde0");
    // $(".btn-step2").eq(day - 1).css("background", "#29bde0");
    // $(".triangle-left-2").eq(day - 1).css("border-right-color", "#29bde0");
    // $(".btn-step3").eq(day - 1).css("background", "#29bde0");
    // $(".triangle-left-3").eq(day - 1).css("border-right-color", "#29bde0");
    // $(".btn-step4").eq(day - 1).css("background", "#29bde0");
    // $(".triangle-left-4").eq(day - 1).css("border-right-color", "#29bde0");
    // }
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
    $(".again").click(function () {
        var over = confirm("是否结束游戏");
        console.log(over);
        if (over == true) {
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
            window.location.href = "./task2.html";
        }

    })
})