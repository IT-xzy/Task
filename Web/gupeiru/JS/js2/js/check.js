$(function () {
    var identity = JSON.parse(localStorage.getItem("key")); //获取上个页面身份数组数据
    // console.log(identity);
    var who = document.createElement("span"); //创建span标签
    $(who).css({ //设置span样式
        "display": "block",
        "margin-top": "1.5rem",
        "font-size": ".2rem",
        "text-align": "center",
        "color": "#29BDE0",
    });
    $(".img-box").append(who); //添加span标签到页面
    var i = 0,
        j = 2;
    $("#villager,#killer").hide(); //平民和杀手头像默认消失
    //底部按钮事件
    $("#go").on("click", function () {
        //底部黄色按钮点击事件，序列数字叠加，图片改变，身份名改变
        if (i < identity.length - 1) {
            //当i<数组长度-1
            if (i % 1 == 0) {
                //如果i是整数
                $("#img").hide(); //隐藏翻牌图片
                $(who).text(identity[i]); //span标签添加数组第一项
                $("#go").text("隐藏并传递给" + j + "号"); //底部按钮文字改变
                if (identity[i] === "平民") { //如果身份为平民
                    $("#villager").show(); //平民头像显示
                    $("#killer").hide(); //杀手头像消失
                } else { //如果是杀手
                    $("#villager").hide(); //平民头像消失
                    $("#killer").show(); //杀手头像显示
                };
            } else {
                //如果i不是整数
                $("#villager,#killer").hide(); //平民和杀手头像消失
                $("#img").show(); //显示翻牌图片
                $(who).text(""); //身份文字为空
                $(".circle").text(j); //图片上的圆圈数字;
                $("#go").text("查看" + j + "号身份"); //底部按钮文字改变
                j = j + 1;
            };
        } else if (i == identity.length - 1) {
            //当i==数组长度-1
            if (identity[i] === "平民") { //如果身份为平民
                $("#villager").show(); //平民头像显示
                $("#killer").hide(); //杀手头像消失
            } else { //如果是杀手
                $("#villager").hide(); //平民头像消失
                $("#killer").show(); //杀手头像显示
            };
            $("#img").hide(); //隐藏翻牌图片
            $(who).text(identity[i]); //span标签添加数组最后一项
            $("#go").text("法官查看"); //底部按钮文字改变为法官查看
        } else {
            $(location).attr('href',"log.html"); //跳转法官日志页面
        };
        i = i + 0.5;
    });
    //顶部按钮事件
    back("index.html"); //点击返回按钮返回首页
    close(); //点击关闭按钮弹窗
    hidden(); //点击取消弹窗消失
    enter(); //enter键等同底部按钮
});