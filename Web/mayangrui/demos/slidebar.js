$(function () {
    //取值title
    if (localStorage.getItem('title')) {
        for (var i = 0; i < JSON.parse(localStorage.getItem('title')).length; i++) {
            if (JSON.parse(localStorage.getItem('title'))[i] == 1) {
                $(".title[index=" + i + "]").css("background-color", "red");
                $(".title[index=" + i + "]+ul").css("display", "block");
            } else {
                $(".title[index=" + i + "]").css("background-color", "transparent");
                $(".title[index=" + i + "]+ul").css("display", "none");
            }
        }
    }

    //取list数组
    if (localStorage.getItem('list')) {
        for (var i = 0; i < JSON.parse(localStorage.getItem('list')).length; i++) {
            for (var j = 0; j < JSON.parse(localStorage.getItem('list'))[i].length; j++) {
                if (JSON.parse(localStorage.getItem('list'))[i][j] == 1) {
                    $(".title[index=" + i + "]").siblings("ul.body").children(".list[index=" + j + "]").css("background-color", "#00ee00");
                } else {
                    $(".title[index=" + i + "]").siblings('ul.body').children(".list[index=" + j + "]").css("background-color", "transparent");
                }
            }
        }
    }


    //存数组title
    $('.title').click(function () {
            var title = [];
            $(".title").css('background-color', 'transparent');
            $("ul.body").css("display", "none");
            $(this).css('background-color', 'red');
            $(this).siblings('ul.body').toggle();
            if ($(this).siblings('ul.body').css('display') === 'block') {
                title[Number($(this).attr("index"))] = 1;
                console.log(title[Number($(this).attr("index"))]);
                localStorage.setItem('title', JSON.stringify(title));
            } else if ($(this).siblings('ul.body').css('display') === 'none') {
                title[Number($(this).attr("index"))] = 0;
                localStorage.setItem('title', JSON.stringify(title));
            }
            console.log($(this).siblings('ul.body').css("display"));
        }
    );

    //存数组list
    $('.list').click(function () {
            //定义二维数组
            var list = new Array(6);
            for (var i = 0; i < 6; i++) {
                list[i] = new Array(5);
            }
            //重置.list的背景色
            $(".list").css('background-color', 'transparent');
            $(this).css('background-color', '#00ee00');
            //用Number转化index的字符串值
            list[Number($(this).parent().attr("index"))][Number($(this).attr("index"))] = 1;
            //存数组需先把数组转化为JSON
            localStorage.setItem('list', JSON.stringify(list));
        }
    )
});