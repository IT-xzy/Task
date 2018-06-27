//取上一个页面保存的玩家分配信息
//获取总人数状态
var peoplerelstate = JSON.parse(sessionStorage.getItem('peoplerelstate'));
console.log(peoplerelstate);
//玩家总人数
var peoplerel = JSON.parse(sessionStorage.getItem('peoplerel'));
//玩家死亡数
var deathnum = JSON.parse(sessionStorage.getItem('deathnum'));
//天数days
var days = JSON.parse(sessionStorage.getItem('days'));
console.log(days);
//被杀死的玩家
var akiller = JSON.parse(sessionStorage.getItem('akiller'));
//被投死的玩家
var avoter = JSON.parse(sessionStorage.getItem('avoter'));
//平民人数
people = JSON.parse(sessionStorage.getItem('people'));
//杀手人数
killer = JSON.parse(sessionStorage.getItem('killer'));

 var  death=JSON.parse(sessionStorage.getItem('death'));

// var death = peoplerelstate.filter(function (peoplerelstate, index, array) {
//     return (peoplerelstate.status === 'die');
// });
// console.log(death);

//
// sessionStorage.setItem('death', JSON.stringify(death));

$(document).ready(function () {

    var contentlist = [];
    for (var h = 0; h < days; h++) {
        contentlist.push(
            '<div class="box">' +
            '<div class="top" id="day">第' + (h + 1) + '天</div>' +
            '<div class="mid">' +
            '<div class="right" id="menu">' +
            '<p class="step1" id="tokill">杀手杀人</p>' +
            '<div class="eer"></div>' +
            '<p class="step2" id="towords">亡灵发表遗言</p>' +
            '<p class="step3" id="tospeak">玩家依次发言</p>' +
            '<p class="step4" id="tovote">全民投票</p>' +
            '<div class="eef"></div>' +
            '<div class="moon"></div>' +
            '<div class="sun"></div>' +
            '</div>' +
            '</div>' +
            '</div>'
        );

    }

    $("main").html(contentlist.join(''));

    //给页面添加杀人  投票信息

    for (var p = 0; p < days; p++) {
        if (akiller.length !== 0) {
            if (akiller[p]) {
                console.log(p);
                $('.eer').eq(p).text('昨夜' + akiller[p].num + '号被杀死,' + '身份是' + akiller[p].id);
                $('.step1').eq(p).toggleClass('death');
            }
        }
        if (avoter.length !== 0) {
            if (avoter[p]) {
                console.log(p);
                $('.eef').eq(p).text('昨夜' + (avoter[p].num) + '号被投死,' + '身份是' + (avoter[p].id));
                $('.step2').eq(p).toggleClass('death');
                $('.step3').eq(p).toggleClass('death');
                $('.step4').eq(p).toggleClass('death');
            }
        }
    }


    //点击滑动下拉框效果
    $('.mid').hide();
    $('.top:last').next().show();
    $(".top").click(function () {
        $(this).next().slideToggle("slow");
    });

//点击退后按钮会返回上一页面
    $('.top-left').click(function () {
        window.location.href = '查看身份.html';
    });


    //结束游戏按钮
    $('.over').click(function () {
        window.localStorage.clear();
        window.sessionStorage.clear();
        window.location.href = '捉鬼游戏.html';
    });
    //法官日志按钮
    $('.back').click(function () {
        window.location.href = '法官日志.html';
    })


});

//点击杀手杀人
$(document).ready(function () {
    var fsm = {
        state: sessionStorage.getItem('move'),
        onStep1: function () {
            switch (fsm.state) {
                case  'none':
                    alert('你准备好了吗？');
                    fsm.state = 'kill';
                    sessionStorage.setItem('move', fsm.state);
                    $('.step1').removeClass('step');
                    $('.step1').addClass('death');
                    location.href = '杀手杀人.html';

                    break;
                case 'speak':
                    alert('请按步骤来');
                    break;
                case 'vote':
                    alert('请按步骤来');
                    break;
                case 'kill':
                    alert('请不要重复点击');
                    break;
            }
        },
        onStep2: function () {
            switch (fsm.state) {
                case 'kill':
                    alert("请亡灵发表言论");
                    fsm.state = 'speak';
                    sessionStorage.setItem('move', 'speak');
                    $('.step2').removeClass('step');
                    $('.step2').addClass('death');
                    break;
                case 'speak':
                    alert('请不要重复点击');
                    break;
                case 'none':
                case 'vote':
                    alert('请按步骤来');
                    break;

            }
        },
        onStep3: function () {
            switch (fsm.state) {
                case 'speak':
                    fsm.state = 'vote';
                    sessionStorage.setItem('move', 'vote');
                    $('.step3').removeClass('step');
                    $('.step3').addClass('death');
                    alert("玩家依次发言");

                    break;
                case 'vote':
                    alert('请不要重复点击');
                    break;
                case 'none':
                case 'kill':
                    alert('按步骤来');
                    break;
            }
        },

        onStep4: function () {
            switch (fsm.state) {
                case 'vote':
                    alert("全民投票");
                    fsm.state = 'none';
                    sessionStorage.setItem('move', 'none');
                    location.href = '投票页.html';
                    $('.step4').removeClass('step');
                    $('.step4').addClass('death');
                    break;
                case 'none':
                case 'words':
                    alert('按步骤来');
                    break;
            }
        }
    };


    $('.step1').click(function () {
        if ($(this).hasClass('death')) {
            alert('请不要重复点击');
        } else {
            fsm.onStep1();
        }
    });
    $('.step2').click(function () {
        if ($(this).hasClass('death')) {
            alert('请不要重复点击');
        } else {
            fsm.onStep2();
        }
    });
    $('.step3').click(function () {
        if ($(this).hasClass('death')) {
            alert('请不要重复点击');
        } else {
            fsm.onStep3();
        }
    });
    $('.step4').click(function () {
        if ($(this).hasClass('death')) {
            alert('请不要重复点击');
        } else {
            fsm.onStep4();
        }
    });
});

