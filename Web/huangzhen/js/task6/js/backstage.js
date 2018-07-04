// 左侧jQuery手风琴
myApp.controller("backstage", function ($scope, $state) {
    // 原始版本 写死
    // $(".list_li_dt").on("click", function () {
    //     $('.list_li_dd').stop();
    //     $(this).siblings("dt").removeAttr("id");
    //     if ($(this).attr("id") == "open") {
    //         $(this).removeAttr("id").siblings("dd").slideUp();
    //     } else {
    //         $(this).attr("id", "open").next().slideDown().siblings("dd").slideUp();
    //     }
    // });

    $(function () {
        //取值title
        if (localStorage.getItem('title')) {
            for (var i = 0; i < JSON.parse(localStorage.getItem('title')).length; i++) {
                if (JSON.parse(localStorage.getItem('title'))[i] == 1) {
                    $(".list_dt[index=" + i + "]").css("background-color", "black");
                    $(".list_dt[index=" + i + "]+ul").css("display", "block");
                } else {
                    $(".list_dt[index=" + i + "]").css("background-color", "transparent");
                    $(".list_dt[index=" + i + "]+ul").css("display", "none");
                }
            }
        }

        //取list数组
        if (localStorage.getItem('list_li')) {
            for (var i = 0; i < JSON.parse(localStorage.getItem('list_li')).length; i++) {
                for (var j = 0; j < JSON.parse(localStorage.getItem('list_li'))[i].length; j++) {
                    if (JSON.parse(localStorage.getItem('list_li'))[i][j] == 1) {
                        $(".list_dt[index=" + i + "]").siblings("ul.body").children(".list_li[index=" + j + "]").css("background-color", "blue");
                    } else {
                        $(".list_dt[index=" + i + "]").siblings('ul.body').children(".list_li[index=" + j + "]").css("background-color", "transparent");
                    }
                }
            }
        }

        //存数组title
        $('.list_dt').click(function () {
            var title = [];
            $(".list_dt").css('background-color', 'transparent');
            $("ul.body").css("display", "none");
            $(this).css('background-color', 'black');
            $(this).siblings('ul.body').toggle();
            if ($(this).siblings('ul.body').css('display') === 'block') {
                title[Number($(this).attr("index"))] = 1;
                // console.log(title[Number($(this).attr("index"))]);
                localStorage.setItem('title', JSON.stringify(title));
            } else if ($(this).siblings('ul.body').css('display') === 'none') {
                title[Number($(this).attr("index"))] = 0;
                localStorage.setItem('title', JSON.stringify(title));
            }
            // console.log($(this).siblings('ul.body').css("display"));
        })

        //存数组list
        $('.list_li').click(function () {
            //定义二维数组
            var list = new Array(6);
            for (var i = 0; i < 6; i++) {
                list[i] = new Array(5);
            }
            //重置.list的背景色
            $(".list_li").css('background-color', 'transparent');
            $(this).css('background-color', 'blue');
            //用Number转化index的字符串值
            list[Number($(this).parent().attr("index"))][Number($(this).attr("index"))] = 1;
            //存数组需先把数组转化为JSON
            localStorage.setItem('list_li', JSON.stringify(list));
        })
    });
})