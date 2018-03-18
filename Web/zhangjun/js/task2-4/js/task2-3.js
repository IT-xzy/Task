$(document).ready(function () {
    var killerNum = parseInt(sessionStorage.getItem("killerNum")),  // 取出保存在killerNum中杀手人数
        civilianNum = parseInt(sessionStorage.getItem("civilianNum")), // 取出保存在civilianNum中平民人数
        aPlayerRole = [],  // 存放玩家角色的数组
        num = 1,  // 设置初始为1，用来表示圆圈内的数字
        status = 1; // 初始化状态为1，0表示显示角色界面
    // 把杀手和平民组成一个数组
    for (var i = 0; i < civilianNum; i++) {
        aPlayerRole.push("平民");
    }
    for (var i = 0; i < killerNum; i++) {
        aPlayerRole.push("杀手");
    }
    // 洗牌算法
    function shuffle(array) {
        var m = array.length,
            t,
            i;
        while (m) {
            // 随机选取一个数
            i = Math.floor(Math.random()*m--);
            // 把数组中最后一个数赋值给t
            t = array[m];
            // 把随机到的数与最后一个数互换
            array[m] = array[i];
            array[i] = t;
        }
        // 返回打乱后的数组
        return array;
    }
    // 调用洗牌算法把杀手与平民打乱
    shuffle(aPlayerRole);
    // 存储玩家数组
    sessionStorage.setItem("aPlayerRole",JSON.stringify(aPlayerRole));
    // 给按钮添加点击事件
    $(".btn").click(function () {
        if (num < aPlayerRole.length + 1) {
            if (status === 0) { // 此时为显示角色界面
                $(".cover").show();
                $(".hide").hide();
                status = 1; // 改为显示状态
                $(".circle").text(num);  // 修改圆圈内的数字
                $(".btn").html("查看" + num + "号身份");
            } else if (status === 1) {   // 此时为皇上翻牌界面
                $(".cover").hide();
                $(".hide").show();
                status = 0;  // 改为隐藏状态
                $(".circle").text(num);
                $(".label span").text(aPlayerRole[num-1]);
                num++;
                $(".btn").html("隐藏并传递给" + num + "号");
            }
        }
        // 当查看完最后一个玩家角色时，显示法官查看按钮
        if (num === aPlayerRole.length + 1) {
            $(".btn").html("法官查看").click(function () {
                var a = confirm("请把手机交给法官");
                if (a === true) {
                    location.href = "task2-4.html";
                }
            });
        }
    });
    // 为后退按钮添加点击事件
    $(".back-btn").click(function () {
        var a = confirm("确定要返回到游戏设置吗?");
        if (a === true) {
            location.href = "task2-2.html";
        }
    });
    // 为关闭按钮添加点击事件
    $(".close-btn").click(function () {
        var a = confirm("确定要退出游戏吗?");
        if (a === true) {
            location.href = "task2-1.html";
        }
    });

})
