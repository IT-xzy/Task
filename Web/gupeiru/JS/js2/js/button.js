function ask(style, height) { //弹窗函数
    $("#position,.window").css("visibility", style);
    $(".window").css("margin", height);
};

function back(link) { //返回按钮函数
    $(".arrow").on("click", function () { //点击返回按钮返回查看身份页面
        $(location).attr('href', link);
    });
};

function hidden() { //点击确定和取消弹框消失函数
    $("#confirm,#cancle").on("click", function () { //点击确定和取消弹框消失
        ask("hidden", "25vh auto"); //调用弹窗函数
    });
};

function close() { //关闭按钮函数
    $(".close").on("click", function () { //点击关闭按钮,弹窗
        ask("visible", "27vh auto"); //调用弹窗函数
        $("#text").text("结束本轮游戏吗?");
        $("#confirm").on("click", function () {
            if ($("#text").text() === "结束本轮游戏吗?") {
                $(location).attr('href', "index.html");
                localStorage.clear();
            };
        });
    });
};

function enter() { //enter键函数
    document.onkeydown = function (event) { //键盘enter键确认输入等同底部按钮点击
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) {
            $("#go").click();
        };
    };
};




