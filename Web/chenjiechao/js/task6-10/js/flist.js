//风琴导航
myApp.controller('flist', function ($scope, $state, check) {
    // var s = sessionStorage.getItem('logstatus'); //获取是否登录的一个存储信息
    // if (s == undefined) { //如果未定义，也就是未登录
    //     $state.go('signin'); //则跳转到登录页面
    // }
    var logstatus = check(0);
    console.log(logstatus);
    if (logstatus == 'false') { //如果为false也就是未登录
        $state.go('signin'); //则跳转到登录页面
    }

    $(function () {
        let open = JSON.parse(sessionStorage.getItem('open')); //获取点击的项目索引
        $('.list_dt').eq(open).attr("id", "open").next().slideDown().siblings("dd").slideUp(); //使之前点击状态存在
        let bright = JSON.parse(sessionStorage.getItem('bright')); //获取点击高亮的索引
        $('.list_li').eq(bright).addClass('bright'); //使高亮状态保存

        $(".list_dt").on("click", function () {
            $('.list_dd').stop();
            $(this).siblings("dt").removeAttr("id"); //消除之前点击的状态和箭头
            var clickDt = $('.list_dt').index(this); //获取当前点击的项目索引
            sessionStorage.setItem('open', JSON.stringify(clickDt)); //保存点击的项目索引
            if ($(this).attr("id") == "open") { //判定点击的项目是否已经打开
                $(this).removeAttr("id").siblings("dd").slideUp();
            } else {
                $(this).attr("id", "open").next().slideDown().siblings("dd").slideUp(); //打开点击项目
            }
        });

        $(".list_li").on("click", function () { //高亮点击事件
            let dim = JSON.parse(sessionStorage.getItem('bright')); //获取之前的高亮
            $('.list_li').eq(dim).removeClass('bright'); //取消之前的高亮状态
            $(this).addClass('bright'); //使当前点击高亮
            var clickLi = $('.list_li').index(this); //存储当前点击的索引
            sessionStorage.setItem('bright', JSON.stringify(clickLi));
        })

    })

})