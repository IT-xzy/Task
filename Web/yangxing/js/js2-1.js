$(document).ready(function () {
    var people = parseInt(sessionStorage.getItem("player")); //取到平民的人数
    var killer = parseInt(sessionStorage.getItem("killernum"));//取到杀手的人数
    console.log(people);
    console.log(killer);
    peoplerel = [];//存放玩家对象的数组


    //把平民和杀手组成一个数组
    for (i = 0; i < people; i++) {
        peoplerel.push("平民");
    }

    for (i = 0; i < killer; i++) {
        peoplerel.push("杀手");
    }


    // 洗牌算法
    function shuffle(array) {
        var m = array.length,
            t,
            i;
        while (m) {
            // 随机选取一个数
            i = Math.floor(Math.random() * m--);
            // 把数组中最后一个数赋值给t
            t = array[m];
            // 把随机到的数与最后一个数互换
            array[m] = array[i];
            array[i] = t;
        }
        // 返回打乱后的数组
        return array;
    }


    //用洗牌算法调用新的数组
    shuffle(peoplerel);
    console.log(peoplerel);

    sessionStorage.setItem("peoplerel", JSON.stringify(peoplerel));

//给按钮添加点击

    var i = 1;
    var flag = true;
    var $num = Math.floor(i / 2) + 1;
    $(".title").text("查看" + ($num) + "号玩家");
    $(".but1").text("查看玩家");
    $("#but").click(function () {
        $num = Math.floor(i / 2) + 1;
        if (flag) {
            console.log('查看身份的逻辑');
            $(".show").css("display", "none");
            $(".hide").css("display", "block");
            $(".but1").text("隐藏并传给" + ($num + 1) + "号玩家");
            $(".ttt").css("display", "block");
            $('.zhiye').append(peoplerel[$num - 1]);
        } else {
            $num = Math.floor(i / 2 + 1);
            console.log('隐藏身份的逻辑');
            $(".show").css("display", "block");
            $(".hide").css("display", "none");
            $(".title").text("查看" + ($num) + "号玩家");
            $(".but1").text("查看玩家");
            $(".ttt").css("display", "none");
            $(".maintop").text($num);
            $('.zhiye').empty();
            if (($num) === peoplerel.length) {
                $(".but1").text("法官日志");
                window.location.href = "法官日志.html";
                sessionStorage.setItem('people', JSON.stringify(people));
                sessionStorage.setItem('killer', JSON.stringify(killer));
            }
        }
        i++;
        flag = !flag;

    });


    $(".top-left").click(function () {
        window.location.href = "分配人数.html";
    });

    $(".top-right").click(function () {

        if (window.confirm("你确定要退出游戏？")) {
            alert("确定")
            return ture;
        } else {
            alert("取消")
            return false;
        }


    })


});




