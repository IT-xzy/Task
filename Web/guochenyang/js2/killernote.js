// //上一页玩家人数
var Num = sessionStorage.getItem("Num");
//上一页身份数组
var playerpeople = JSON.parse(sessionStorage.getItem("playerpeople"));
var click = JSON.parse(window.sessionStorage.getItem("click"));
var note = JSON.parse(window.sessionStorage.getItem("note"));
var bgColor = JSON.parse(window.sessionStorage.getItem("bgColor"));
var day = JSON.parse(window.sessionStorage.getItem("day"));
var die = JSON.parse(window.sessionStorage.getItem("die"));
console.log(playerpeople);
console.log(bgColor);
console.log(click);
console.log(note);
console.log(day);
console.log(die);
//返回
function Back(){
    var a = confirm("退回到上一页？");
    if(a == true){
        sessionStorage.clear();
        window.location.href = "task-2.html";
    }
}
//结束游戏
function Off(){
    var b = confirm("是否结束本轮游戏？");
    if (b == true) {
        sessionStorage.clear();
        window.location.href = "zhuoyou.html";
    }
}
for (var i = 0; i < playerpeople.length; i++) {
    //创建div
    $("main").append('<div class="cont1"></div>');
    //给div添加身份p标签
    $(".cont1").eq(i).append('<p class="text1"></p>');
    //给身份p标签添加内容
    $(".text1").eq(i).html(playerpeople[i].name);
    //给div添加玩家号数p标签
    $(".cont1").eq(i).append('<p class="text2"></p>');
    //给玩家号数p标签添加对应数字
    $(".text2").eq(i).html((i + 1) + "号");
}
//根据点击次数修改样式
if (note.length !== 1) {
    if (click == 0) {
        $("h2").html("杀手杀人");
    } else {
        $("h2").html("玩家投票");
    }
} else {
    $("h2").html("游戏日志");
    $("#gamestart").html("返回");
}
//死者上色
for (var a = 0; a < playerpeople.length; a++) {
    if (playerpeople[a].death == false) {
        $(".text1").eq(a).css("background-color", "red");
    }
}
//此为为了方便存储数据用，跟下方按钮关联
var Click;
//点击判断
$(".cont1").click(function () {
    //获取点击的数组下标
    var j = $(".cont1").index($(this));
    //关联下方按钮
     Click = j;
    //重置样式
    for (var k = 0; k < playerpeople.length; k++) {
        $(".text1").eq(k).removeClass("red");
    }
    if (note.length !== 1) {
        //判断杀人或投票
        if ((click.length - 1) == 0) {
            //判断是否是平民，是否存活
            if (playerpeople[j].name == "平民" && playerpeople[j].death == true) {
                $(".text1").eq(j).addClass("red");
            }
            //点击死人弹窗
            else if (playerpeople[j].death !== true) {
                alert("死的不能再死了！");
            } else {
                alert("杀队友？");
            }
        } //投票
        else {
            if (playerpeople[j].death == true) {
                $(".text1").eq(j).addClass("red");
            } else {
                alert("杀队友？");
            }
        }
    }
        else{
            for (var k = 0; k < playerpeople.length; k++) {
                $(".text1").eq(k).removeClass("red");
        }
    }
    console.log(playerpeople[j]);
    console.log(playerpeople[k]);
    console.log(Click);
})

//胜利及跳转
function wingame() {
    var lifeNumber = playerpeople.filter(function (item, index, array) {
        return (item.death == true)
    })
    //存活的杀手
    var killerNumber = lifeNumber.filter(function (item, index, array) {
        return (item.name == "杀手")
    })
    //胜利
    if (killerNumber.length == 0) {
        JumpStorage();
        var win = "平民胜利";
        sessionStorage.setItem("win", win);
        sessionStorage.setItem("lifeNumber", JSON.stringify(lifeNumber));
        sessionStorage.setItem("killerNumber", JSON.stringify(killerNumber));
        window.location.href = "jieguo.html"
    } else if (killerNumber.length >= (lifeNumber.length - killerNumber.length)) {
        JumpStorage();
        var win = "杀手胜利";
        //如果杀人页面胜利则增加天数
        if ((click.length - 1) == 0) {
            day.push(0);
            sessionStorage.setItem("day", JSON.stringify(day));
        }
        sessionStorage.setItem("win", win);
        sessionStorage.setItem("lifeNumber", JSON.stringify(lifeNumber));
        sessionStorage.setItem("killerNumber", JSON.stringify(killerNumber));
        window.location.href = "jieguo.html"
    } else {
        window.location.href = "startgame.html"
    }
}
//底部按钮操作函数
function JumpOperation() {
    //修改存活状态
    playerpeople[Click].death = false;
    //死亡人数加一
    die.push(Click + 1);
}
//存储并跳转
function JumpStorage() {
    //存储需要的数据
    sessionStorage.setItem("die", JSON.stringify(die));
    sessionStorage.setItem("day", JSON.stringify(day));
    sessionStorage.setItem("bgcolor", JSON.stringify(bgColor));
    sessionStorage.setItem("click", JSON.stringify(click));
    sessionStorage.setItem("playerpeople", JSON.stringify(playerpeople))
}
//选中杀或投的后点击跳转
$("#gamestart").click(function () {
    if (note.length !== 1) {
        //判断第几次点击，第一次则附加必须选中平民才可
        if (Click !== undefined && (click.length - 1) == 0 && playerpeople[Click].name == "平民" && playerpeople[Click].death == true) {
            //关联按钮操作
            JumpOperation();
            //关联存储
            JumpStorage();
            //存活人数
            wingame();
            //投票页面
        } else if (Click !== undefined && (click.length - 1) == 3 && playerpeople[Click].death == true) {
            //增加天数
            day.push(0);
            //清空点击
            click.splice(0, click.length);
            JumpOperation();
            JumpStorage();
            wingame();
        } else {
            alert("需要选一个人呀！");
        }
    } else {
        if (note.length == 1) {
            JumpStorage();
            note.splice(0, note.length);
            sessionStorage.setItem("note", JSON.stringify(note));
            $(".note").hide();
            window.location.href = "startgame.html";
        }
    }
})
