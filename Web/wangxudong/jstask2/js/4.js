var gain = JSON.parse(localStorage.getItem('identity')); //获得转化后的数组 传过来的数组
var data = (localStorage.getItem('sum')); //获得总人数   传过来得值
var num = 2; //建立一个值 用来每次点击加1
var a = 0; //建立一个值 用来每次点击加1

$("#back").click(function back() {   // 返回按钮
    $(location).attr('href', '3.html');
});

$("#homepage").click(function backHome() {  //关闭按钮
    sessionStorage.clear();
    if (confirm("确定关闭游戏嘛 ")) {
        $(location).attr('href', '1.html');
    }
})

$("#transmit").click(function paga() { //翻页按钮函数
    $("#look").show();
    $(this).hide();
    $("#good").hide();
    $("#bad").hide();
    $("#id").hide();
    $("#play").show();
    $("#number").text(num);
     
    if (num == data) { //最后一张实现法官查看
        $("#transmit").html("法官查看");
    }
    if (num - 1 == data) { //最后一个按钮实现跳转
        $(location).attr('href', '5.html');
    }
    num += 1;
    $("#number1").text(num);
})

$("#look").click(function check() { //查看按钮 函数
    $("#look").hide();
    $("#transmit").show();
    $("#play").hide();
    if (gain[a] == '好人') { //判断好人
        $("#good").show();
        $("#bad").hide();
        $("#id").show();
        $("#id").html("平民")
    } else { //判断狼人
        $("#bad").show();
        $("#good").hide();
        $("#id").show();
        $("#id").html("狼人")
    }
    a += 1;
})