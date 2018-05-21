var inputData = document.getElementById("play-numbers"),//获取input节点
    slidingData = document.getElementById("range"),//获取滚动条节点
    mark = 1,//记录点击设置按钮有没被点击
    $return = $('header').find('a').eq(0),//获取回退按钮的节点
    $changeNum = $('.change-number'),//获取加号减号按钮节点
    $range = $('#range'),//获取滑动条节点
    $input = $('#play-numbers');//获取输入框节点
console.log($input)
//函数功能：当输入值大于4或小于18时跳出提示框，然后改变input的值
function alertNum(num) {
    bootbox.alert('玩家人数应在4-18之间')
    inputData.value=(num>18)?18:4;
}

//绑定input和range的值的函数
function bingNum(num) {
    if (num === 1) {
        inputData.value = slidingData.value;
    } else {
        slidingData.value = inputData.value;
    }
};

//生存杀手平民配比数组
function ranDomarr() {
    var Arr = [],
        n = 1,//参数，用于当表达式成立时的下标等于杀手
        index,//洗牌数组的乱序下标
        temp;//用于乱序下标和有序下标交换的容器
    for (var i = 0; i < inputData.value; i++) {
        Arr[i] = '平民';
        if (i >= 3 * n) {
            Arr[n] = '杀手';
            n++
        }
    }
    for (var i = 0; i < inputData.value; i++) {
        index = Math.floor(Math.random() * inputData.value);
        if (i != index) {
            temp = Arr[i];
            Arr[i] = Arr[index];
            Arr[index] = temp;
        }
    }
    return Arr
}

//点击回退键后退
$return.on('click', function () {
    window.location.href = 'game-version.html';
});

//滑动进度条时，根据进度条位置修改文本框数值
$range.on('input touchmove', function () {
    bingNum(1)
    mark = null;
});

//文本框数值修改时，根据数值改变进度条位置
$input
    .on('change', function () {
        bingNum();
        alertNum(inputData.value)
    })
    .on('keyup', function () {
    bingNum()
})

//点击减号减少进度条和文本框的数值
$changeNum.eq(0).on('click', function () {
    inputData.value--;
    bingNum();
    alertNum(inputData.value)
});

//点击加号增加进度条和文本框的数值
$changeNum.eq(1).on('click', function () {
    inputData.value++;
    bingNum()
    alertNum(inputData.value)
});

//点击设置人数，触发事件
$('.proportion-setting').on('click', function () {
    mark = 2;
    var Arr = ranDomarr();//用变量保存乱序数组
    $('.proportion-player').empty();//每次点击前清空内容区域
    for (i = 0; i < inputData.value; i++) {
        $('.proportion-player').append(' <div class="role-name-wrap">\n' +
            '                    <div class="blue"></div>\n' +
            '                    <div class="role-name">' + Arr[i] + '</div>\n' +
            '                </div>')
        if (Arr[i] === '杀手') {
            $('.blue').eq(i).css({'background': 'orange'})
        }
    }
    sessionStorage.setItem('Arr', JSON.stringify(Arr));//存入sessionstorage
});
//底部按钮点击时跳转页面
$('footer').children('a').on('click', function () {
    if (mark === 2) {
        window.location.href = "Flop.html"
    }
    else if (mark === null) {
        bootbox.alert("人数已变更，请重新设置玩家配比")
    }
    else {
        bootbox.alert("请设置人数")
    }
});
