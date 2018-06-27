$(document).ready(function () {
    var state = JSON.parse(sessionStorage.getItem('statu')),
        $return = $('header').find('a').eq(0),
        $close = $('header').find('a').eq(1),
        $step = $(".step");
    //给标题写上第几天
    $('.first-day').eq(0).find('h4').text('第'+state.day+'天');
    //当步骤大于1时，显示昨夜被杀的人
    if(state.step>=1) {
        $('.step').eq(0).after('<p>昨夜' + state.bekill[state.bekill.length-1].num + '号被杀死，死者身份为' + state.bekill[state.bekill.length-1].name + '</p>')
    }
    //当天数增加时，记录之前发生的事，并放在所在的天数下，隐藏
    for (i = 1; i < state.day; i++) {
        $('.diary-wrap').eq(i-1).before('  <div class="diary-wrap">\n' +
            '        <div class="first-day">\n' +
            '            <a class="iconfont">&#xe6a6;</a>\n' +
            '            <h4>第'+i+'天</h4>\n' +
            '        </div>\n' +
            '        <div class="day-happen">\n' +
            '            <div class="step2 btn-blue">杀手杀人</div>\n' +
            '<p>昨夜'+state.bekill[i-1].num+'号被杀死，死者身份为'+state.bekill[i-1].name+'</p>'+
            '            <div class="step2 btn-blue">亡灵发表遗言</div>\n' +
            '            <div class="step2 btn-blue">玩家依次发言</div>\n' +
            '            <div class="step2 btn-blue">全民投票</div>\n' +
            '<p>昨夜'+state.bevote[i-1].num+'号被投死，死者身份为'+state.bevote[i-1].name+'</p>'+
            '            <div class="night">\n' +
            '                <i class="iconfont">&#xe603;</i>\n' +
            '            </div>\n' +
            '            <div class="day-time">\n' +
            '                <i class="iconfont">&#xe672;</i>\n' +
            '            </div>\n' +
            '        </div>\n' +
            '    </div>');
        //点击第i天显示该天下的内容，必须放到一个自执行函数里才可以获取正确的i值。则i值总是会等于state.day
        (function (arg) {
            $('.first-day').eq(arg).on('click',function () {
                $('.day-happen').eq(arg).slideToggle('fast')
            });;
        })(i-1);
        $('.day-happen').eq(i-1).hide();
    };
//判定当前的步骤，根据当前步骤给按钮增加class名，改变背景颜色
    function changeColor() {
        for (var i = 0; i < state.step; i++) {
            $step.eq(i).addClass("btn-blue")
        }
    }

    changeColor();
    //点击第二个或第三个按钮跳出不同信息弹出框
    function pop(step) {
        (step===2)?alert('请亡灵发表遗言'):alert('请各位玩家依次发言')
    }
    function closeGame() {
        var $choose = confirm('确定要结束本轮游戏么');
        if ($choose === true) {
            sessionStorage.clear();
            window.location.href = 'task2.html'
        }
    }

    //点击返回键，返回之前的页面
    $return.on('click', function () {
        window.location.href = 'judge-view.html';
    });
    //点击关闭键，弹出是否结束游戏
    $close.on('click', closeGame);
    //点击结束游戏键和关闭键一样
    $('footer a').eq(0).on('click',closeGame);
    //点击法官日记键，跳转至法官日志页面
    $('footer a').eq(1).on('click', function () {
        state.state=0;
        state.mark=0;
        sessionStorage.setItem('statu',JSON.stringify(state))
        window.location.href = 'judge-view.html';
    });

//按钮点击事件
    $step.on('click', function () {
        //判断该按钮是否包含class名，如果包含则是被点击过，所以跳出弹出框
        if ($(this).hasClass('btn-blue')) {
            alert('请按顺序进行下一步操作')
        }
        //如果点击了第一个按钮跳转到杀人页面，并且把改变state.state，让法官页面知道现在是杀人状态
        else if ($step.index(this) === 0&&state.step===0) {
            state.state = 1;
            window.location.href = 'judge-view.html'
        }
        //如果点击了第四个按钮跳转到投票页面，并且把改变state.state，让法官页面知道现在是投票状态
        else if ($step.index(this) === 3&&state.step===3) {
            state.state = 2;
            window.location.href = 'judge-view.html'
        }
        //如果是点击其他两个按钮，则获取当前按钮，并把值赋给步骤
        else if($step.index(this)===state.step){
            state.step++;
            pop(state.step);
        }
        else {
            alert('请按顺序进行游戏');
        }
        changeColor();
        sessionStorage.setItem('statu', JSON.stringify(state));
    });
});



