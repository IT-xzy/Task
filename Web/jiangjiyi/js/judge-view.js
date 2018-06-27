$(document).ready(function () {
    var state = JSON.parse(sessionStorage.getItem('statu')) || new Status(),
        Arr = JSON.parse(sessionStorage.getItem('Arr')),
        $button = $("footer").children("a"),
        $title = $("header").children('h4'),
        $return = $('header').find('a').eq(0),
        $close = $('header').find('a').eq(1);

    //创建state的构造函数
    function Status() {
        this.state = 0;
        this.step = 0;
        this.day = 1;
        this.person = [];
        this.bekill = [];
        this.bevote = [];
        this.mark = 1;
    }

//遍历数组，根据杀手平民数量显示块
    for (var i = 0; i < Arr.length; i++) {
        $('.row-wrap').append('\n' +
            '            <div class="column">\n' +
            '                <div class="square">\n' +
            '                    <div class="role-name">\n' +  Arr[i]+
            '                    </div>\n' +
            '                    <div class="role-number">\n' + (i + 1) +
            '                    </div>\n' +
            '                </div>\n' +
            '                <img class="more" src="../images/1.png">\n' +
            '            </div>')
    };
//点击回退按钮
    $return.on('click', function () {
        // sessionStorage.clear();
        window.location.href = 'task2-licens.html';
    });
//点击关闭按钮
    $close.on('click', function () {
        var $choose = confirm('确定要结束本轮游戏么');
        if ($choose === true) {
            // sessionStorage.clear();
            window.location.href = 'task2.html'
        }
    });

//法官日记状态显示的页面
    if (state.state === 0) {
        $title[0].innerHTML = "法官日志";
        //在第一次进来法官日记页面时通过遍历生成对象数组，用于保存各角色的名称，状态，以及编号。第二次进法官日志页面则
        // 不会再生成对象数组
        if (state.mark) {
            for (i = 0; i < Arr.length; i++) {
                state.person[i] = {
                    name: Arr[i],
                    state: 'live',
                    num: i
                }
            }
            $button[0].innerHTML = "开始游戏";
            sessionStorage.setItem('statu', JSON.stringify(state));
        }
        else {
            $button[0].innerHTML = "继续游戏";
        }
        $button.on('click', function () {
            window.location.href = 'game-process.html'
        });
    }
//状态为'kill'时显示以下页面
    else if (state.state !== 0) {
        var index,
            index2
        //杀手页面显示的内容
        if (state.state === 1) {
            $title[0].innerHTML = "杀手杀人";
            $button[0].innerHTML = "杀人";
        }
        //投票页面显示内容
        else if (state.state === 2) {
            $title[0].innerHTML = "投票";
            $button[0].innerHTML = "投票";
        }
        //角色被点击时显示的内容
        $('.column').click(function () {
            index = $('.column').index(this);//用变量保存点击模块的索引值
            //当点击到死人的时候
            if (state.person[index].state === 'die') {
                alert('兄弟你要鞭尸吗？');
            }//当点击到杀手并且当前状态为杀手杀人状态的时候
            else if (state.person[index].name === '杀手' && state.state === 1) {
                alert('无法杀死队友');
            }
            else {
                for (i = 0; i < Arr.length; i++) {
                    if (state.person[i].state === 'live') {//判断角色是否或者，把活着的角色颜色重置
                        $('.square').eq(i).css({'border-color': '#fff'})
                    }
                }
                $(this).find('.square').css({'border-color': '#333'})//被点击的块颜色改变
                index2 = index;
            }
        });
        //点击底部按钮时，根据不同情况，显示不同效果
        $button.click(function () {
            if (index2 !== undefined) {
                var choose = (state.state === 1) ? confirm('Are you going to kill him?') : confirm('Are you going to vote him?')
                if (choose === true) {
                    state.person[index2].state = 'die';
                    if (state.state === 1) {
                        state.step++;
                        state.bekill.push({name: state.person[index2].name, num: index2 + 1});
                    }
                    else if (state.state === 2) {
                        state.step = 0;
                        state.day++;
                        state.bevote.push({name: state.person[index2].name, num: index2 + 1});
                    }
                    //计算杀手和平民人数，根据人数判断是否跳转结果页面
                    var killerLive = 0,//杀手人数
                        civilianLive = 0;//平民人数
                    for (i = 0; i < state.person.length; i++) {
                        if (state.person[i].name === '杀手' && state.person[i].state === 'live') {
                            killerLive++;
                        }
                        else if (state.person[i].name === '平民' && state.person[i].state === 'live') {
                            civilianLive++;
                        }
                    }
                    if (killerLive >= civilianLive || killerLive === 0) {
                        state.win = (killerLive === 0) ? '平民胜利' : '杀手胜利';
                        window.location.href = 'result.html'
                    }
                    else {
                        window.location.href = 'game-process.html';
                    }
                    sessionStorage.setItem('statu', JSON.stringify(state));
                    sessionStorage.setItem('statu', JSON.stringify(state));
                }
            }
            else if (index2 === undefined) {
                if (state.state === 1) {
                    alert('请选择要击杀的角色')
                } else {
                    alert('请选择要投票的角色')
                }
            }
        })
    }
//遍历数组，把死亡的人颜色标黑;
    for (i = 0; i < state.person.length; i++) {
        if (state.person[i].state === 'die') {
            $('.role-name').eq(i).css({'background': '#000', 'color': '#fff'})
        }
    }
})