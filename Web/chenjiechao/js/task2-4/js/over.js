$(function () {
    var getp = sessionStorage.getItem("pe");
    var peopleNum = JSON.parse(getp); //取得存活平民数组
    var getk = sessionStorage.getItem("ki");
    var killNum = JSON.parse(getk); //取得存活杀手数组
    var getd = sessionStorage.getItem("de");
    var dead = JSON.parse(getd); //取得死者数组
    var over = sessionStorage.getItem("gameOver"); //取得游戏胜利方
    var day = sessionStorage.getItem("countDay"); //取得游戏天数
    var geta = sessionStorage.getItem("initial");
    var arr = JSON.parse(geta); //取得游戏初始数组
    console.log(arr);

    if (over == "killwin") { //判断胜利方
        $(".main-win").append('<p class="win-text">' +
            '杀手胜利' +
            '</p>'
        )
    } else {
        $(".main-win").append('<p class="win-text">' +
            '平民胜利' +
            '</p>'
        )
    }
    var survive = peopleNum.length + killNum.length; //得到剩余玩家数量
    console.log(survive);
    $(".message").append(
        '剩余玩家：' + survive +
        '</br>' +
        '杀手' + killNum.length + '人' +
        '</br>' +
        '平民' + peopleNum.length + '人');

    var time = Math.ceil(dead.length / 2);
    console.log(time);

    for (i = 0; i < (time - 1); i++) {
        $("main").append(
            '<div class="day">' +
            '<p class="first">' +
            '第' + (i + 1) + '天' +
            '</p>' +
            '<p class="time">' +
            '0小时07分' +
            '</p>' +
            '<p class="night">' +
            '晚上：' + (dead[2 * i] + 1) + '号被杀手杀死，' + (dead[2 * i] + 1) + '号是' + arr[dead[2 * i]] +
            '</br>' +
            '白天：' + (dead[2 * i + 1] + 1) + '号被全民投票投死,' + (dead[2 * i + 1] + 1) + '号是' + arr[dead[2 * i + 1]] +
            '</p>' +
            '</div>')
    }
    if ((dead.length) % 2 == 0) {
        j = time - 1;
        $("main").append(
            '<div class="day">' +
            '<p class="first">' +
            '第' + (j + 1) + '天' +
            '</p>' +
            '<p class="time">' +
            '0小时07分' +
            '</p>' +
            '<p class="night">' +
            '晚上：' + (dead[2 * j] + 1) + '号被杀手杀死，' + (dead[2 * j] + 1) + '号是' + arr[dead[2 * j]] +
            '</br>' +
            '白天：' + (dead[2 * j + 1] + 1) + '号被全民投票投死,' + (dead[2 * j + 1] + 1) + '号是' + arr[dead[2 * j ]] +
            '</p>' +
            '</div>')
    } else {
        j = time - 1;
        $("main").append(
        '<div class="day">' +
        '<p class="first">' +
        '第' + (j + 1) + '天' +
        '</p>' +
        '<p class="time">' +
        '0小时07分' +
        '</p>' +
        '<p class="night">' +
        '晚上：' + (dead[2 * j + 1] + 1) + '号被杀手杀死，' + (dead[2 * j + 1] + 1) + '号是' + arr[dead[2 * j]] )
    }
    $(".again").click(function(){
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