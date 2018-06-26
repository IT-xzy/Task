$(function () {
    var log = console.log;
    var daynum = 0; /* 天数变量 */
    var days = ['第一天', '第二天', '第三天', '第四天', '第五天', '第六天', '第七天', '第八天', '第九天', '第十天'];
    var fsm = new StateMachine({
        init: "none",
        transitions: [{
                name: 'kill',
                from: 'none',
                to: 'killStep'
            }, /* 杀手杀人 */
            {
                name: 'police',
                from: 'killStep',
                to: 'policeStep'
            }, /* 警察验人 */
            {
                name: 'sharp',
                from: 'policeStep',
                to: 'sharpStep'
            }, /* 狙击狙人 */
            {
                name: 'doctor',
                from: 'sharpStep',
                to: 'doctorStep'
            }, /* 医生救人 */
            {
                name: 'ghost',
                from: 'doctorStep',
                to: 'ghostSay'
            }, /* 亡灵发表遗言 */
            {
                name: 'player',
                from: 'ghostSay',
                to: 'playerSay'
            }, /* 玩家依次发言 */
            {
                name: 'vote',
                from: 'playerSay',
                to: 'none'
            }, /* 全民投票 */
        ],
        methods: {
            /* 如果状态转换不能正常转换就会触发下面的错误处理机制 */
            onInvalidTransition: function (transition, from, to) {
                switch (from) {
                    case "none":
                        alert("请点击杀手杀人");
                        break;
                    case "killStep":
                        alert("请点击警察验人");
                        break;
                    case "policeStep":
                        alert("请点击狙击手狙人");
                        break;
                    case "sharpStep":
                        alert("请点击医生救人");
                        break;
                    case "doctorStep":
                        alert("请点击亡灵发表遗言");
                        break;
                    case "ghostSay":
                        alert("请点击玩家依次发言");
                        break;
                    case "playerSay":
                        alert("请点击全民投票");
                        break;
                    default:
                        alert("请点击下一天的操作");
                }
            },
        }
    }) /* 创建一个状态机 */

    var
        // collapse = $('.dayNum'),
        /* 折叠 */
        // getBox = $('.box'),
        /* 包含导引的块 */
        getkiller = $('.killer'),
        getPolice = $('.police'),
        getSharp = $('.sharpShoot'),
        getDoctor = $('.doctor'),
        getGhost = $('.ghostSay'),
        getPlayer = $('.playerSay'),
        getVote = $('.allVote');
    /* 以上获取的是每个导引栏的节点 */

    $('.back').click(function () {
        window.location.href = "judgeDiary.html";
    }) /* 返回法官日记 */

    $('.header-close').click(function () {
        sessionStorage.clear();
        window.location.href = "playerRatio.html";
    }) /* 点击关闭按钮 */

    var step = JSON.parse(sessionStorage.getItem('step')); /* 这个变量是为了判断运行到第几步了 */
    log(step);

    function nextPage() {
        // step = JSON.parse(sessionStorage.getItem('step'));
        if (step == undefined) {
            step = 1;
        } else {
            step += 1;
        }
        sessionStorage.setItem("step", JSON.stringify(step));
        window.location.href = "operationPage.html";
    } /* 每执行下一页，代表已经进行了一个步骤了，通过step在changeClicked方法中进行判断操作 */

    var identityInfoArray = JSON.parse(sessionStorage.getItem("identity")); /* 获取身份数组，这个是在第一个页面生成的 */
    var clickedIndex = JSON.parse(sessionStorage.getItem('clickedIndex')); /* 获取被操作的身份角标 */
    var killedIndex = JSON.parse(sessionStorage.getItem('killedIndex'));
    var policeIndex = JSON.parse(sessionStorage.getItem('policeIndex'));
    var sharpIndex = JSON.parse(sessionStorage.getItem('sharpIndex'));
    var doctorIndex = JSON.parse(sessionStorage.getItem('doctorIndex'));
    var voteIndex = JSON.parse(sessionStorage.getItem('voteIndex'));

    daynum = JSON.parse(sessionStorage.getItem('dayNum'));
    log("第几天" + daynum);

    if (step == 7) {
        // daynum = JSON.parse(sessionStorage.getItem('dayNum'));
        daynum += 1;
        sessionStorage.setItem('dayNum', JSON.stringify(daynum));
        step = 0;
        sessionStorage.setItem('step', JSON.stringify(step));
    } /* 如果step为7代表已经走完了一天的流程，天数增加，储存到本地 */

    if (daynum > 0) {
        for (var j = 0; j < daynum; j++) {
            $('main').append($('.bigBox').eq(j).clone());
            $('.box').eq(j).find('span').css("backgroundColor", "#888");
            $('.box').eq(j).find('i').css("borderRightColor", "#888");

            $('.box').eq(j).on('click', function () {
                alert('请点击下一天的操作');
            })
        } /* daynum 大于零 克隆节点 */
    }
    log(typeof daynum);

    $('.dayNum').click(function () {
        $(this).next('.box').toggle();
    });
    //  点击每一天后折叠

    for (var i = 0; i <= daynum; i++) {
        $('.word-day').eq(i).text(days[i]); /*  */

        if (killedIndex != undefined) {
            if (killedIndex[i] != undefined) {
                $('.sunBox').eq(i).append('<p>' + (killedIndex[i] + 1) + '号被杀手杀死了，真实身份是' + identityInfoArray[killedIndex[i]] + '</p>');
            }
        }
        if (policeIndex != undefined) {
            if (policeIndex[i] != undefined) {
                $('.sunBox').eq(i).append('<p>' + (policeIndex[i] + 1) + '号被警察查看身份，真实身份是' + identityInfoArray[policeIndex[i]] + '</p>');
            }
        }
        if (sharpIndex != undefined) {
            if (sharpIndex[i] != undefined) {
                $('.sunBox').eq(i).append('<p>' + (sharpIndex[i] + 1) + '号被狙击手狙杀，真实身份是' + identityInfoArray[sharpIndex[i]] + '</p>');
            }
        }
        if (doctorIndex != undefined) {
            if (doctorIndex[i] != undefined) {
                $('.sunBox').eq(i).append('<p>' + (doctorIndex[i] + 1) + '号被医生治疗，真实身份是' + identityInfoArray[doctorIndex[i]] + '</p>');
            }
        }
        if (voteIndex != undefined) {
            if (voteIndex[i] != undefined) {
                $('.moonBox').eq(i).append('<p>' + (voteIndex[i] + 1) + '号被投死了，真实身份是' + identityInfoArray[voteIndex[i]] + '</p>');
            }
        }
    }
    /* 动态添加P标签文本 */


    newArray = JSON.parse(sessionStorage.getItem('newArray'));
    log(newArray);


    function deliver(state) {
        sessionStorage.setItem("deliverStep", JSON.stringify(state));
    } /* 传递状态至下一个页面 */

    $('.killer').eq(daynum).click(function () {
        if (fsm.can("kill")) {
            deliver("kill");
            nextPage();
        }
        fsm.kill();
    }) /* 点击杀手杀人执行的操作 */

    $('.police').eq(daynum).click(function () {
        if (fsm.can("police")) {
            deliver("police");
            nextPage();
        }
        fsm.police();
    }) /* 点击警察验人执行的操作 */

    $('.sharpShoot').eq(daynum).click(function () {
        if (fsm.can("sharp")) {
            deliver("sharp");
            nextPage();
        }
        fsm.sharp();
    }) /* 点击狙击执行的操作 */

    $('.doctor').eq(daynum).click(function () {
        if (fsm.can("doctor")) {
            deliver("doctor");
            nextPage();
        }
        fsm.doctor();
    }) /* 点击医生执行的操作 */

    $('.ghostSay').eq(daynum).click(function () {
        if (fsm.can("ghost")) {
            alert('请亡灵发表遗言');
            step += 1;
            $(this).css("backgroundColor", "#888");
            $(this).find("i").css("borderRightColor", "#888"); /* 点击后背景颜色会改变 */
        }
        fsm.ghost();
    }) /* 点击亡灵发表遗言 */

    $('.playerSay').eq(daynum).click(function () {
        if (fsm.can("player")) {
            alert('请玩家依次发言');
            step += 1;
            sessionStorage.setItem("step", JSON.stringify(step));
            $(this).css("backgroundColor", "#888");
            $(this).find("i").css("borderRightColor", "#888"); /* 点击后背景颜色会改变 */
        }
        fsm.player();
    }) /* 点击玩家依次发言 */

    $('.allVote').eq(daynum).click(function () {
        if (fsm.can("vote")) {
            deliver("vote");
            log(step);
            nextPage();
        }
        fsm.vote();
    }) /* 点击头票 */



    console.log("执行完了几步：" + step);
    switch (step) {
        case 1:
            fsm.kill();
            changeColor($('.killer'));
            break;
        case 2:
            fsm.kill();
            fsm.police();
            changeColor($('.killer'));
            changeColor($('.police'));
            break;
        case 3:
            fsm.kill();
            fsm.police();
            fsm.sharp();
            changeColor($('.killer'));
            changeColor($('.police'));
            changeColor($('.sharpShoot'));
            break;
        case 4:
            fsm.kill();
            fsm.police();
            fsm.sharp();
            fsm.doctor();
            changeColor($('.killer'));
            changeColor($('.police'));
            changeColor($('.sharpShoot'));
            changeColor($('.doctor'));
            break;
        case 7:
            fsm.kill();
            fsm.police();
            fsm.sharp();
            fsm.doctor();
            fsm.ghost();
            fsm.player();
            fsm.vote();
            changeColor($('.killer'));
            changeColor($('.police'));
            changeColor($('.sharpShoot'));
            changeColor($('.doctor'));
            changeColor($('.ghostSay'));
            changeColor($('.playerSay'));
            changeColor($('.allVote'));
            break;
    }

    function changeColor(temple) {
        temple.css("backgroundColor", "#888");
        temple.find("i").css("borderRightColor", "#888"); /* 点击后背景颜色会改变 */
    }

}) /* jQuery文档就绪事件结束 */








// for (var m = 0; m < step; m++) {
//     $(loop[m]).css("backgroundColor", "#888");
//     $(loop[m]).find("i").css("borderRightColor", "#888"); /* 点击后背景颜色会改变 */
// }
// } /* 从杀人页面返回来的时候状态和颜色会改变 */
// changeClicked();

// function changeClicked() {
// var loop = [getkiller, getPolice, getSharp, getDoctor, getGhost, getPlayer, getVote];
// step = JSON.parse(sessionStorage.getItem('step'));












// $('.police').eq(i).css("backgroundColor", "#888");
// $('.police').eq(i).find("i").css("borderRightColor", "#888"); /* 点击后背景颜色会改变 */
// fsm.kill();
// fsm.police();





// $('.killer').eq(i).css("backgroundColor", "#888");
// $('.killer').eq(i).find("i").css("borderRightColor", "#888"); /* 点击后背景颜色会改变 */
// fsm.kill();




// step = JSON.parse(sessionStorage.getItem('step'));
// if (step != undefined) {
//     for (var i = 0; i < clickedIndex.length; i++) {
//         var b = clickedIndex[i] + 1;
//         if (i == 0) {
//             $('.sunBox').append('<p>' + b + '号被杀手杀死了，真实身份是' + identityInfoArray[clickedIndex[i]] + '</p>');
//         }
//         if (i == 1) {
//             $('.sunBox').append('<p>' + b + '号被警察查看身份，真实身份是' + identityInfoArray[clickedIndex[i]] + '</p>');
//         }
//         if (i == 2) {
//             $('.sunBox').append('<p>' + b + '号被狙击手狙杀，真实身份是' + identityInfoArray[clickedIndex[i]] + '</p>');
//         }
//         if (i == 3) {
//             $('.sunBox').append('<p>' + b + '号被医生治疗，真实身份是' + identityInfoArray[clickedIndex[i]] + '</p>');
//         }
//         if (i == 4) {
//             $('.moonBox').append('<p>' + b + '号被投死了，真实身份是' + identityInfoArray[clickedIndex[i]] + '</p>');
//         }
//     }
// }


// case 5:
//     fsm.kill();
//     fsm.police();
//     fsm.sharp();
//     fsm.doctor();
//     fsm.ghost();
//     break;
// case 6:
//     fsm.kill();
//     fsm.police();
//     fsm.sharp();
//     fsm.doctor();
//     fsm.ghost();
//     fsm.player();
//     break;

// var obj = {
//     a: fsm.kill(),
//     b: fsm.police()
// }

// var a = fsm.kill();
// var b = fsm.police();
// var stateMethod = [a, b]
// stateMethod[0];

// var stateMethod = [fsm.kill(), fsm.police(), fsm.sharp(), fsm.doctor(), fsm.ghost(), fsm.player(), fsm.vote()]
// stateMethod[0];
/* —————————————————————————— */
// var a;
// var gettext = $('#text');
// log(sessionStorage.getItem("a"));
// a = JSON.parse(sessionStorage.getItem('a'));
// if (a != null) {
//     gettext.html("测试文字" + a);
// }





// log(fsm.state);
// fsm.kill();
// log(fsm.state);
// fsm.police();
// log(fsm.state);
// fsm.sharp();
// log(fsm.state);
// fsm.doctor();
// log(fsm.state);
// fsm.ghost();
// log(fsm.state);
// fsm.player();
// log(fsm.state);
// fsm.vote();
// log(fsm.state);