// 点击次数
var time = 1;
// 上面是数字
var num = 1;
var obj = JSON.stringify(player);
obj = sessionStorage.player;
var player = JSON.parse(obj);


// 初始状态通用
$('.number').text(num);
// 点击事件
$("#look").click(function () {
    // $("#pass,#show").toggle();

    // 点击次数奇数次
    if (time % 2 == 1) {
        $("#pass").show();
        $("#show").hide();
        var sub = player[num];
        num++;
        if (num > player.length) {
            $('#look').text("法官查看");
        } else {
            sub = (sub.substring(sub.length - 7, sub.length - 5));
            // console.log(sub);
            $('#who').text(sub);
            $('#look').text("隐藏身份并传递给 " + (num) + " 号");
        }
        console.log(num);
    }
    // 点击次数偶数次
    else {
        $("#pass").hide();
        $("#show").show();
        if (num > player.length) {
            window.location.href = 'task3-2.html';
        } else {
            $('#look').text("查看 " + (num) + "号身份");
            $('.circle').text(num);
        }
    }
    time++;
})