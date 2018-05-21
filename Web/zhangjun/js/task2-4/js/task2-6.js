$(document).ready(function () {
    var aPlayerRole = JSON.parse(sessionStorage.getItem("aPlayerRole")),  // 把取出来的字符串转换为数组
        aPlayerStatus = JSON.parse(sessionStorage.getItem("aPlayerStatus")), // 取出玩家状态
        aKilled = JSON.parse(sessionStorage.getItem("aKilled")),
        aVoted = JSON.parse(sessionStorage.getItem("aVoted")),
        days = JSON.parse(sessionStorage.getItem("days")),
        killerNum = parseInt(sessionStorage.getItem("killerNum")),  // 取出保存在killerNum中杀手人数
        civilianNum = parseInt(sessionStorage.getItem("civilianNum")), // 取出保存在civilianNum中平民人数
        step = sessionStorage.getItem("step"),
        selected = 0, // 用来判断是否选中角色，选中则改变为1
        index;  // 存储下标
    for (var i = 0; i < aPlayerRole.length; i++) {
        var num = i + 1; // 角色号数
        // html结构
        var gridHtml = "<div class=\"grid-wrap\">\n" +
            "            <div class=\"grid\">\n" +
            "                <div class=\"role\">" + aPlayerRole[i] + "</div>\n" +
            "                <div class=\"number\">" + num + "号</div>\n" +
            "            </div>\n" +
            "            <div class=\"knife\">\n" +
            "            <img src=\"images/icon1@2x.png\">\n" +
            "        </div>"
        // 为页面添加html结构
        $(".main").append(gridHtml);
    }
    // step=vote表示是从投票页面跳转来的
    if (step === "vote") {
        $("title").text("投票");
        $(".hd h1").text("投票");
        $(".tips span").text("发言讨论结束，大家请投票");
        $(".hd-message").text("点击得票数最多的人的头像");
    }
    // 为被杀和被投死角色添加样式
    for (var i = 0; i < aPlayerRole.length; i++) {
        if (aPlayerStatus[i].status === "killed" || aPlayerStatus[i].status === "voted") {
            index = aPlayerStatus[i].num - 1;  // 获取被杀角色的下标
            $(".role").eq(index).css("background-color","#83b09a");
        }
    }
    // 为关闭按钮添加点击事件
    $(".close-btn").click(function () {
        var a = confirm("确定要退出游戏吗?");
        if (a === true) {
            sessionStorage.clear();
            location.href="task2-1.html";
        }
    })
    // 为角色添加点击显示小刀效果
    $(".grid").click(function () {
        $(".knife").css("visibility","hidden");  // 每次点击时先把所有.knife 隐藏起来
        $(this).next().css("visibility","visible");
        index = $(".grid").index(this);  // 存储当前点击项的下标
        selected = 1;  // 选中角色会给个标记
    })
    // 点击确定
    $(".btn").click(function () {
        if (selected === 0) {  // 表示没有选择玩家
            if (step === "killer") {  // 表示是从法官台本页面跳转过来的
                var a = confirm("确定本轮不杀人吗？");
                if (a === true) {
                    aKilled.push({num:"NoOneDied"});
                    sessionStorage.setItem("aKilled",JSON.stringify(aKilled));
                    sessionStorage.setItem("step","dead"); // 变为dead步骤
                    location.href="task2-5.html";
                }
            } else if (step === "vote") {
                alert("请选择一个玩家");
            }
        } else if (selected === 1) { // 表示选择了一个玩家
            if (step === "killer") {
                if (aPlayerStatus[index].role !== "杀手") { // 判断被杀的人是否为杀手
                    if (aPlayerStatus[index].status !== "killed" && aPlayerStatus[index].status !== "voted") { // 判断此玩家是否已经死亡或者被投死
                        var k = confirm("确定要干掉他吗？");
                        if (k === true) {
                            sessionStorage.setItem("step","dead"); // 变为dead步骤
                            aPlayerStatus[index].status = "killed";  // 标记被杀状态
                            sessionStorage.setItem("aPlayerStatus",JSON.stringify(aPlayerStatus));
                            aKilled.push(aPlayerStatus[index]); // 添加进入被杀名单
                            sessionStorage.setItem("aKilled",JSON.stringify(aKilled));
                            civilianNum--; // 平民减少一个
                            sessionStorage.setItem("civilianNum",civilianNum);
                            if (civilianNum <= killerNum) {
                                days++; // 如果从杀人页面直接跳转到结果界面时天数要加1天
                                sessionStorage.setItem("days",JSON.stringify(days));
                                alert("杀手胜利");
                                location.href = "task2-8.html";
                            } else {
                                location.href = "task2-5.html";
                            }
                        }
                    } else {
                        alert("这个可怜虫已经死了，请不要鞭尸！")
                    }
                } else {
                    alert("自己人也杀，太残忍了吧！")
                }
            } else if (step === "vote") {  // 表示是从投票页面跳转过来的
                if (aPlayerStatus[index].status !== "killed" && aPlayerStatus[index].status !== "voted") { // 判断此玩家是否已经死亡或者被投死
                    var k = confirm("确定要投死他吗？");
                    if (k === true) {
                        aPlayerStatus[index].status = "voted";  // 标记被投状态
                        sessionStorage.setItem("aPlayerStatus",JSON.stringify(aPlayerStatus));
                        aVoted.push(aPlayerStatus[index]); // 添加进入被投名单
                        sessionStorage.setItem("aVoted",JSON.stringify(aVoted));
                        days++; // 投票结束后天数加1
                        sessionStorage.setItem("days",JSON.stringify(days));
                        if (aPlayerStatus[index].role === "杀手") {
                            killerNum--;  // 杀手减少一个
                            sessionStorage.setItem("killerNum",killerNum);
                            if (killerNum === 0) {
                                alert("平民胜利");
                                location.href = "task2-8.html";
                            } else {
                                location.href = "task2-5.html";
                            }
                        } else if (aPlayerStatus[index].role === "平民") {
                            civilianNum--;
                            sessionStorage.setItem("civilianNum",civilianNum);
                            if (civilianNum <= killerNum) {
                                alert("杀手胜利");
                                location.href = "task2-8.html";
                            } else {
                                location.href = "task2-5.html";
                            }
                        }
                        sessionStorage.setItem("step","none"); // 初始化步骤
                    }
                } else {
                    alert("这个可怜虫已经死了，请不要鞭尸！")
                }
            }
        }
    })
})