console.log("杀手请睁眼，请选择要要杀的对象");
console.log("选择下方玩家头像，对要杀的玩家进行标记");
var day;//设置变量用于存放游戏进行到第几天，每天包含4个步骤的状态；
var killMark;
var _index;//获取死亡玩家索引号
var defunct=[];//储存被投死玩家
var died;//已经死亡玩家JSON数据
var voteKill=[]; //被投死玩家
var click = 0;//投票按钮点击次数

//玩家身份数据
var part_value = sessionStorage.getItem("deal");
part_value = JSON.parse(part_value);

//存活的玩家
var live;
// 被杀手杀死玩家数据//玩家index 
sessionStorage.getItem("die");
def = JSON.parse(sessionStorage.getItem("die"));

sessionStorage.getItem("voteKill");
vot = JSON.parse(sessionStorage.getItem("vote"));


//判断是投票页还是杀人页
sessionStorage.getItem("st");
step = JSON.parse(sessionStorage.getItem("st"));

// 被玩家投死玩家数据，数组//玩家indexd
if (vot) {
    sessionStorage.getItem("vote");
    voteKill = JSON.parse(sessionStorage.getItem("vote"));
}

if (def) {
    var die = sessionStorage.getItem("die");//被杀死玩家
    defunct = JSON.parse(die);//将die 替换 为defunct
}
    

//深拷贝玩家身份数组
var copyPart_value = part_value.slice(0);
console.log(copyPart_value)


//合并杀人和投票数组
var died = [];
if (voteKill) {
    died = defunct.concat(voteKill);
}

//根据死亡玩家索引号，删除玩家身份数组中对应的数据
for(var i = 0;
    i < died.length;
    i++) {
    delete copyPart_value[died[i]];
    console.log(copyPart_value);
}

//获取已被杀死玩家
$(document).ready(function(){
    for (var i = 0;
        i < def.length;
        i++) {
        $(".character").eq(def[i]).css("background-color","#83b09a");
        $(".character").eq(def[i]).parent().find("img").hide();
    }
    for (var i = 0;
        i < vot.length;
        i++) {
        $(".character").eq(vot[i]).css("background-color","#83b09a");
        $(".character").eq(vot[i]).parent().find("img").hide();
    }
})
//弹出对话框
function alert(content) {
    var _this = $(this);
    $("#hidebg").css("display","block");
    $("#alert").css("display","flex");
    $("#prompt").text(content);

    $(".concel").on("click",function(){
        $("#alert").css("display","none");
        $("#hidebg").css("display","none");
    })
}

//杀手标记玩家
$(".option").children("img").click(function(){
    _index = $(".character").index($(this).parents(".user-operate").children(".character"));
    if (step == 1) {

        if(part_value[_index] == 1){
            alert("请选择一个平民")
            $(".confirm").on("click",function(){
                $("#alert").css("display","none");
                $("#hidebg").css("display","none");
            })
        }
        else {
            $(".character").css("box-shadow", "none");
            $(this).parents(".user-operate").children(".character").css("box-shadow", "0 0 100px 10px #83b09a inset");
            killMark = $(this);
            _index = $(".character").index($(this).parents(".user-operate").children(".character"));
            console.log(_index);
        }

    }
    else {
        $(".character").css("box-shadow", "none");
            $(this).parents(".user-operate").children(".character").css("box-shadow", "0 0 100px 10px #83b09a inset");
            killMark = $(this);
            _index = $(".character").index($(this).parents(".user-operate").children(".character"));
            console.log(_index);
    }  
});

//确定杀死玩家
$("#confirm").on("click",function(){
    var _this = $(this);
    if (!killMark) {
        alert("请选择一个玩家")
        $(".confirm").on("click",function(){
            $("#alert").css("display","none");
            $("#hidebg").css("display","none");
        })
    }
    else {
        alert("您要杀死选中的玩家吗");
        $(".confirm").on("click",function(){
            $("#alert").css("display","none");
            killMark.parents(".user-operate").children(".character").css("background-color","#83b09a");

            defunct.push(_index);
            var diedPeople = sessionStorage.setItem("die",JSON.stringify(defunct));
            console.log(defunct);

            end();//判断是否结束游戏
        })   
    }
})

//投票页，按钮
$("#vote").on("click",function(){
    var _this = $(this);
    if (!killMark) {
        alert("请选择一个玩家")
        $(".confirm").on("click",function(){
            $("#alert").css("display","none");
            $("#hidebg").css("display","none");
        })
    }
    else {
        alert("玩家将被投票出局");
        $(".confirm").on("click",function(){
            $("#alert").css("display","none");
            killMark.parents(".user-operate").children(".character").css("background-color","#83b09a");


            voteKill.push(_index);
            sessionStorage.setItem("vote",JSON.stringify(voteKill));
            console.log(voteKill);

            click = click + 1;
            sessionStorage.setItem("c",JSON.stringify(click));
            console.log("点击" + click + "次");

            end();//判断是否结束游戏
        })   
    }
})

function end() {
    var killer = 0;
    var civilian = 0;
    var copyPart_value = part_value.slice(0);
    console.log(copyPart_value)


//合并杀人和投票数组
    var died = [];
    if (voteKill) {
        died = defunct.concat(voteKill);
    }

//根据死亡玩家索引号，删除玩家身份数组中对应的数据
    for(var i = 0;
        i < died.length;
        i++) {
        delete copyPart_value[died[i]];
        console.log(copyPart_value);
    }
    for(var i = 0;
        i < copyPart_value.length;
        i++){
        if (copyPart_value[i] == 0) {
            civilian += 1;
        }
        else if(copyPart_value[i] == 1) {
            killer += 1;
        }
    }

    if (killer >= civilian){
        var victory = 1;
        window.location.href = "JS-TASK4-游戏结果.html";
        sessionStorage.setItem("end",victory);
        return;
    }
    else if(killer == 0) {
        var victory = 0;
        // alert("水民胜利");
        window.location.href = "JS-TASK4-游戏结果.html";
        sessionStorage.setItem("end",victory);
        
        return;
    }
    else {
        window.location.href = "JS-TASK4-流程.html";
    }
}


