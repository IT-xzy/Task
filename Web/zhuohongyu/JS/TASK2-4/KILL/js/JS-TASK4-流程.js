var die = sessionStorage.getItem("die");//被杀死玩家
die = JSON.parse(die);
var judgeBtn = die;
console.log(die);

//被投死的玩家
// sessionStorage.getItem("vote");
var voteKill = JSON.parse(sessionStorage.getItem("vote"));

//玩家身份数据
var part_value = JSON.parse(sessionStorage.getItem("deal"));
// part_value = JSON.parse(part_value);

//判断是否按顺序点击按钮，
var step;
step = JSON.parse(sessionStorage.getItem("st"));

//退出游戏
$(".icon_quit").click(function (){
    alert("确定退出游戏吗？")
    $(".confirm").on("click",function(){
        window.location.href="JS-TASK4-gameHome.html";
    })
})
//弹出框,使按钮变成灰色
function alertConfirm(here) {
    $(".confirm").on("click",function(){
        $("#alert").css("display","none");
        here.attr("disabled","disabled");
        here.css({
            color:"#999",
            background:"#b5b3b3"
        });
        here.children(".triangle").css("border-top-color","#b5b3b3");
        $("#hidebg").css("display","none");
    })
}

//弹出对话框
function alert(content) {
    // var _this = $(this);
    $("#hidebg").css("display","block");
    $("#alert").css("display","flex");
    $("#prompt").text(content);
    $(".concel").on("click",function(){
        $("#alert").css("display","none");
        $("#hidebg").css("display","none");
    })
}

//点击杀人按钮
$("#kill").on("click",function(){
    step = 1;
    sessionStorage.setItem("st",JSON.stringify(step));
    window.location.href="JS-TASK4-状态改变.html";
})

//亡灵发表遗言
$("#last_words").on("click",function(){
    if (step == 1) {
        var _this = $(this);
        alert("请死者亮明身份并发表遗言");
        alertConfirm($(this));
        step = 2;
    }
    else {
        alert("请先杀人");
        $(".confirm").on("click",function(){
            $("#alert").css("display","none");
            $("#hidebg").css("display","none");
        });
    }
});

//玩家发言讨论
$("#speak").on("click",function(){
    if (step == 2) {
        var _this = $(this);
        alert("玩家依次讨论发言");
        alertConfirm($(this));
        step = 3;
    }
    else if(step == 1) {
        alert("请先让死者发表遗言");
        $(".confirm").on("click",function(){
            $("#alert").css("display","none");
            $("#hidebg").css("display","none");
        });
    }
    else {
        alert("请先杀人");
        $(".confirm").on("click",function(){
            $("#alert").css("display","none");
            $("#hidebg").css("display","none");
        });
    }
});

///投票
$("#vote").click(function(){
    if (step == 3) {
        window.location.href="JS-TASK4-全民投票.html";
    }
    else {
        alert("请按照顺序进行游戏");
        $(".confirm").on("click",function(){
            $("#alert").css("display","none");
            $("#hidebg").css("display","none");
        });
    }
    sessionStorage.removeItem("st"); 
});

//投票按钮点击次数
click = sessionStorage.getItem("c");
click = JSON.parse(click);

//x号玩家被玩家投死，真实身份是x
//前一台 
for (
    var i = 1;
    i < click + 1;
    i++){
        
        if (click) {
            var a = die[i-1] + 1;
            var n = i + 1;
            var x = voteKill[i - 1] + 1;
            var status = [];
            if (part_value[x-1] == 1) {
                status = "杀手";
                console.log(part_value[x])
            }
            else {
                status = "水民";
            }

            $("main").eq(i-1).before(
            '<main>\n' +
                '<p class="day">'+'第'+ i + '天' + '</p>\n' +
                '<img class="arrow_down" src="https://ZZsuper.github.io/JS/TASK2/icon/arrow_down.png">\n' +
                '<div class="diary_wrap">\n' + 
                    '<span class="moon"></span>' +
                    '<span class="sun"></span>' +
                    '<button class="kill">\n' + 
                    '<p>杀手杀人</p>\n' +
                    '<p class="diary_1">' + "夜晚：" + a + "号玩家被杀手杀死，真实身份是水民" + '</p>\n' +
                    '</button>\n'+
                    '<button class="step">\n' +
                    '<p>亡灵发表遗言</p>\n' +
                    '</button>\n' +
                    '<button class="step">\n' +
                    '<p>玩家依次发言</p>\n' +
                    '</button>\n' +
                    '<button class="step">\n' +
                    '<p>投票</p>\n' +
                    '<p class="diary_2">'+ "白天：" + x + "号玩家被全民投死，真实身份是" + status+'</p>\n'+
                    '</button>\n' +
                '</div>' +
            '</main>\n' 
            )
        $("main").eq(i-1).children(".diary_wrap").hide();
        $(".day").eq(i).text("第"+n+"天");
    } 
};

//弹出对话框
function alert(content) {
    // var _this = $(this);
    $("#hidebg").css("display","block");
    $("#alert").css("display","flex");
    $("#prompt").text(content);
    $(".concel").on("click",function(){
        $("#alert").css("display","none");
        $("#hidebg").css("display","none");
    })
}

//x号玩家被杀手杀死，真实身份是x
$(document).ready(function() {
    if (step == 1) {
        a = die[die.length - 1] + 1;
        $(".diary_1").text("夜晚：" + a + "号玩家被杀手杀死，真实身份是平民");
    } 
});



//隐藏显示天数详情
$(".arrow_down").click(function(){
    $(this).parents("main").children(".diary_wrap").slideToggle();
})

//判断杀人按钮状态
$(document).ready(
    function(){
        if(!voteKill) {
            if(judgeBtn){
                $("#kill").attr("disabled","disabled");

            $("#kill").css({
                color:"#999",
                background:"#b5b3b3"
            });
            $("#kill").children(".triangle").css("border-top-color","#b5b3b3");
            $("#kill").attr("disabled","disabled");
            }
        }
        else if (judgeBtn.length+1 > voteKill.length+1) {//judgeBtn = die(被杀死玩家);
            $("#kill").attr("disabled","disabled");

            $("#kill").css({
                color:"#999",
                background:"#b5b3b3"
            });
            $("#kill").children(".triangle").css("border-top-color","#b5b3b3");
            $("#kill").attr("disabled","disabled");
        }
    }
);









