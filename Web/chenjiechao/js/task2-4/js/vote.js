$(function () {
    var get = sessionStorage.getItem("send");
    var send = JSON.parse(get); //获得前面页面的数组
    console.log(send);
    var getp = sessionStorage.getItem("pe");
    var peopleNum = JSON.parse(getp);
    var getk = sessionStorage.getItem("ki");
    var killNum = JSON.parse(getk);
    var getd = sessionStorage.getItem("de");
    var dead = JSON.parse(getd);
    var checkStep = sessionStorage.getItem("checkStep"); //获得day页面的进行步骤
    console.log(checkStep);

    if (checkStep == "status1") { //判断进行到的步骤，来渲染页面头部内容
        $(function () {
            sessionStorage.removeItem("y"); //如果页面为杀人页，则清除数据Y
            $("header").prepend('<p class="header-middle">\n' +
                '杀手杀人' +
                '</p>');
            $(".main-top").prepend('<span>\n' +
                '杀手请睁眼，杀手请选择要杀的对象' +
                '</span>');
            $(".div-click").prepend('<p class="click">\n' +
                '点击下方玩家头像，对被杀的玩家进行标记' +
                '<p>')
        })
    } else { //不为杀手页面，则为投票页面
        $("header").prepend('<p class="header-middle">\n' +
            '全民投票' +
            '</p>');
        $(".main-top").prepend('<span>\n' +
            '发言讨论结束，大家请投票' +
            '</span>');
        $(".div-click").prepend('<p class="click">\n' +
            '点击得票数最多的人的头像' +
            '<p>')
    }
    var arr = [];
    for (i = 0; i < (send.length); i++) { //把之前的数组转化为另一个数组，方便这个页面使用

        if (send[i] == "平  民 1 人") {
            arr.push("平民");
        } else {
            arr.push("杀手");
        }
    }
    console.log(arr);
    var initial = JSON.stringify(arr);
    sessionStorage.setItem("initial", initial);
    for (var i = 0; i < arr.length; i++) { //添加身份格子
        var j = i + 1;
        $(".content").append('<div class="grid">\n' +
            '<div class="grid-main">\n' +
            '<span class="grid-main-top">\n' + arr[i] + '</span>' +
            '<span class="grid-main-bottom">\n' + j + "号" + '</span>' +
            '</div>\n' +
            '<img class="logo" src="img/knife.png"/>' +
            '</div>\n')
    }

    sessionStorage.removeItem("x"); //清除之前的选定格子x
    $(".grid").click(function () {
        $(".grid-main").css("border-color", "#fff"); //在下一次点击之前，删除之前的样式
        $(".logo").css("opacity", "0");
        var x = $(this).index(); //获取当前点击格子的序号
        console.log(x);
        $(".grid-main").eq(x).css("border-color", "red"); //
        $(".logo").eq(x).css("opacity", "1");
        sessionStorage.setItem("x", x);
    })


    // 得到天数，判定时否要添加杀手或平民数组
    var day = sessionStorage.getItem("countDay");
    console.log(day);
    if ((day == 1) && (checkStep == "status1")) {
        var peopleNum = [];
        var killNum = [];
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == "平民") {
                peopleNum.push(i); //得到平民序号数组
            } else {
                killNum.push(i); //得到杀手序号数组
            }
        }
        console.log(peopleNum);
        console.log(killNum);
        var dead = [];
    } else { //不是第一天第一步的话，就获取死人序号，改变死人序号状态

        sessionStorage.getItem("dead");
        console.log(dead);
        for (i = 0; i < dead.length; i++) {
            $(".grid-main-top").eq(dead[i]).css("background-color", "#83b09a") //改变死者的身份格子颜色
        }
    }




    $(".vote").click(function () {
        if (checkStep == "status1") {
            var y = sessionStorage.getItem("x");
            console.log(y);
            //some为数组中有符合条件的即输出true
            var iskillNum = killNum.some(function (item, index, array) {
                return (item == y); //如果存活杀手数组中有与点击格子的序号相等的，则输出true
            })
            console.log(iskillNum);
            var isdead = dead.some(function (item, index, array) {
                return (item == y); //如果死者数组中有与点击格子的序号相等的，则输出true
            })
            console.log(isdead);
            if (iskillNum == true) {
                alert("是不是傻，不能自杀");
            } else if (isdead == true) {
                alert("此人已死，无需再杀");
            }
            for (i = 0; i < peopleNum.length; i++) {
                if (y == peopleNum[i]) { //for循环判断数组中是否有值与点击值相等
                    dead.push(peopleNum[i]); //将死的人加入到死者数组
                    peopleNum.splice(i, 1); // 将死的人从存活平民数组删除
                    window.location.href = "./day.html";
                }
            }
            //下面是for循环方法
            // // for (i = 0; i < killNum.length; i++) {
            // //     console.log(killNum[i]);
            //     if (y == killNum[i]) {
            //         
            //     } else {}
            // // }
            // for (i = 0; i < dead.length; i++) {
            //     if (y == dead[i]) {
            //         alert("此人已死，无需再杀")
            //     }
            // }
            // for (i = 0; i < peopleNum.length; i++) {
            //     console.log(peopleNum[i]);
            //     if (y == peopleNum[i]) {
            //         dead.push(peopleNum[i]);
            //         peopleNum.splice(i, 1);
            //         console.log(peopleNum);
            //         window.location.href = "./day.html";
            //     }
            // }
        } else {
            var y = sessionStorage.getItem("x");
            console.log(y);
            console.log(dead);
            for (i = 0; i < dead.length; i++) {
                if (y == dead[i]) {
                    alert("此人已死，无需再杀")
                }
            }
            for (i = 0; i < killNum.length; i++) {
                console.log(killNum[i]);
                if (y == killNum[i]) {
                    dead.push(killNum[i]);
                    killNum.splice(i, 1);
                    console.log(killNum);
                    window.location.href = "./day.html";
                }
            }

            for (i = 0; i < peopleNum.length; i++) {
                console.log(peopleNum[i]);
                if (y == peopleNum[i]) {
                    dead.push(peopleNum[i]);
                    peopleNum.splice(i, 1);
                    console.log(peopleNum);

                    window.location.href = "./day.html";
                }
            }
        }
        var pe = JSON.stringify(peopleNum);
        sessionStorage.setItem("pe", pe);
        var ki = JSON.stringify(killNum); //将平民序号数组和杀手序号数组存储到本地
        sessionStorage.setItem("ki", ki);
        var de = JSON.stringify(dead);//将死者数组存储到本地
        sessionStorage.setItem("de", de); //
        sessionStorage.setItem("y", y); //将死亡序号储存至本地
        console.log(y);
        if (y == null) {
            alert("请选择一个人杀");
        }
        //判断胜利条件
        if (peopleNum.length == killNum.length) {
            var gameover = "killwin";
            sessionStorage.setItem("gameOver", gameover);
            window.location.href = "./over.html";
        } else if (killNum.length == 0) {
            var gameover = "peoplewin";
            sessionStorage.setItem("gameOver", gameover);
            window.location.href = "./over.html";
        } else {}
    })
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