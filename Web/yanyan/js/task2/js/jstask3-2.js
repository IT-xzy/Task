var resultNum = JSON.parse(sessionStorage.getItem("orderkey"));//原始人员数据
var day1 = JSON.parse(sessionStorage.getItem("daykill"));//当前步骤状态
var result = JSON.parse(sessionStorage.getItem("aliveColorB"));//新人员数据
var dieNum = JSON.parse(sessionStorage.getItem("dieNum"));//黑夜死亡人员号码
var dieNumA = JSON.parse(sessionStorage.getItem("dieNumA"));//死亡人员位置数组
var dieArr = JSON.parse(sessionStorage.getItem("dieArr"));//死亡人员数组

sessionStorage.setItem("aliveColorA", JSON.stringify(resultNum));
sessionStorage.setItem("aliveColorC", JSON.stringify(result));
sessionStorage.setItem("dieArr", JSON.stringify(dieArr));
sessionStorage.setItem("dieNumA", JSON.stringify(dieNumA));

console.log(dieNum);
console.log(dieNumA);
console.log(dieArr);
console.log(result);
console.log(resultNum);
console.log(day1);

var kill = document.getElementById('kill'),
    word = document.getElementById('word'),
    speak = document.getElementById('speak'),
    vote = document.getElementById('vote'),
    daynum = document.getElementById('daynum'),
    identity = document.getElementById('identity'),
    log = document.getElementById("log"),
    day = document.getElementsByClassName("day"),
    pad = document.getElementsByClassName("pad-process");

kill.disabled = true;
word.disabled = true;
speak.disabled = true;
vote.disabled = true;

//黑夜完后出现文字
num.innerText = dieNum + 1;
if (resultNum[dieNum] === 1) {
    identity.innerText = "杀手";
} else {
    identity.innerText = "水民";
}

//重新游戏
function goback() {
    if (confirm("是否要重新开始游戏")) {
        //如果是true
        sessionStorage.clear();
        location.href = "home.html";
        // window.history.back();

    }
}

//关闭窗口
function closeA() {
    if (confirm("你确定要关闭窗口结束游戏吗")) {
        //如果是true
        sessionStorage.clear();
        window.location.href="about:blank";
        window.close();
    }
}

// 接收流程状态，自动运行改变样式
var menu2 = {
    // 当前状态
    state2: day1,
    // 绑定事件（自动运行）
    // 状态转换
    transition2: function () {
        switch (menu2.state2) {
            case null:
                vote.disabled = true;
                kill.disabled = false;

                break;
            case"b":
                word.disabled = false;
                $("#a").css("border-right-color", "green");
                $("#kill").css("background", "green");
                $("#night").css("display", "block");
                break;
            case"c":
                $("#night").css("display", "block");
                $("#a").css("border-right-color", "green");
                $("#kill").css("background", "green");
                $("#b").css("border-right-color", "green");
                $("#word").css("background", "green");
                speak.disabled = false;
                break;
            case"d":
                $("#night").css("display", "block");
                $("#a").css("border-right-color", "green");
                $("#kill").css("background", "green");
                $("#b").css("border-right-color", "green");
                $("#word").css("background", "green");
                $("#c").css("border-right-color", "green");
                $("#speak").css("background", "green");
                vote.disabled = false;
                break;
        }
    }
};
menu2.transition2();

//杀人、遗言、发言、投票四个状态的状态机，点击执行不同函数达到页面效果。
var menu = {
    // 当前状态
    state: day1,
    // 绑定事件
    initialize: function event() {
        $(".pad-process").click(function () {
            menu.transition();
        })
    },
    // 状态转换
    transition: function () {
        switch (menu.state) {
            case null:
                aaa();
                break;
            case"b":
                bbb();
                break;
            case"c":
                ccc();
                break;
            case"d":
                ddd();
                break;
            default:
                console.log('Invalid State!');
                break;
        }
        console.log(menu.state);
        sessionStorage.setItem("daynum", JSON.stringify(menu.state));
    }
};
menu.initialize();
console.log(menu);


//杀人状态执行函数b
function aaa() {
    //利用对话框返回的值 （true 或者 false）
    if (confirm("进入夜晚，杀手请杀人")) {
        //如果是true
        menu.state = 'b';
        // Hours = myDate.getHours();//获取当前小时数(0-23)
        // Minutes = myDate.getMinutes();//获取当前分钟数(0-59)
        location.href = 'jstask3-4.html';
    }
}

//遗言执行函数
function bbb() {
    alert("请死者亮明身份并发表遗言");
    menu.state = 'c';
    word.disabled = true;
    speak.disabled = false;
    $("#b").css("border-right-color", "green");
    $("#word").css("background", "green");
}

//发言执行函数
function ccc() {
    alert("玩家依次发言讨论");
    menu.state = 'd';
    speak.disabled = true;
    vote.disabled = false;
    $("#c").css("border-right-color", "green");
    $("#speak").css("background", "green");
}

//投票执行函数
function ddd() {
    if (confirm("玩家依次开始投票")) {
        //如果是true
        menu.state = null;
        location.href = 'jstask3-4.html';
    }
}
//结束游戏
function end() {
    if (confirm("你确定要中途结束游戏？")) {
        //如果是true
        location.href = 'end.html';
    }
}

//自动生成日志
var logArr = []; //全部人的数组
if (dieArr === null){
}
//显示新日志（多一天）
else if(day1 === null){
    var dieArrLength = Math.ceil(dieArr.length/2);
    for (var i = 0; i < dieArrLength; i++) {
        var a = i + 1;
        var numA = a*2 -2;
        var numB = a*2 -1;
        logArr[i] = "<div class=\"day\" ><span class=\"margin-l\">第"+a+"天</span><img class=\"s-img1 f-right\" src=\"img/down.png\"></div><div class='logday'><div>黑夜："+dieNumA[numA]+"号被杀死，真实身份是"+dieArr[numA]+"</div><div>白天："+dieNumA[numB]+"号被投死，真实身份是"+dieArr[numB]+"</div></div>";
    }
    var logBrr = logArr.join("");//转换成字符串
    log.innerHTML = logBrr;//显示数量
    daynum.innerText = a+1;
}//显示旧日志（少一天）
else{
    var dieArrLength = Math.ceil(dieArr.length/2);
    for (var i = 0; i < dieArrLength-1; i++) {
        var a = i + 1;
        var numA = a*2 -2;
        var numB = a*2 -1;

        logArr[i] = "<div class=\"day\" ><span class=\"margin-l\">第"+a+"天</span><img class=\"s-img1 f-right\" src=\"img/down.png\"></div><div class='logday'><div>黑夜："+dieNumA[numA]+"号被杀死，真实身份是"+dieArr[numA]+"</div><div>白天："+dieNumA[numB]+"号被投死，真实身份是"+dieArr[numB]+"</div></div>";
    }
    var logBrr = logArr.join("");//转换成字符串
    log.innerHTML = logBrr;//显示数量
    daynum.innerText = i+1;
}

//显示隐藏日志
$(".day").click(function () {
    $(this).next().toggle();
});

// var Hours;
// var Minutes;
// var myDate = new Date();

// var x = 2;

// var day = "<div class=\"day\" id=\"day\"><span class=\"margin-l\">第<span id=\"daynum\">" + x + "</span>天</span><img" +
//     " class=\"s-img1 f-right\" src=\"img/down.png\"></div>";
// var dayDay = JSON.parse(sessionStorage.getItem("dayA"));//死亡人员位置
// sessionStorage.setItem("dayA", JSON.stringify(day));
// console.log(dayDay);




// var day = new StateMachine({
//     init:'kill',
//     transitions:[
//         { name: 'kill', from: 'kill', to: 'words'},
//         { name: 'words', from: 'words', to: 'speak'},
//         { name: 'speak', from: 'speak', to: 'vote'},
//         { name: 'vote', from: 'vote', to: 'kill'}
//     ]
// });
//
// var choice = new StateMachine({
//     init:'die',
//     transitions:[
//         { name: 'put', from: 'die', to: 'live'},
//         { name: 'safe', from: 'live', to: 'die'}
//     ]
// });

// function changeColor() {
//     this.style.backgroundColor = "green";
// }


// // 当前状态
// name: '1'；

// 绑定事件
// initialize: function() {
//     var self = this;
//     self.on("click", self.transition);
// },aaa

// 状态转换

// function change(who) {
//    return who.name
// }
// var name = change(kill);
// console.log(name);
//
// function abcd() {
//     function change(who) {
//         return who.name
//     }
//     switch (who) {
//         case "kill":
//             kill.disabled = true;
//             word.disabled = false;
//             kill.background = "green";
//             name = '2';
//             break;
//         case "2":
//             word.disabled = true;
//             kill.disabled = false;
//             word.background = "green";
//             name = '1';
//             break;
//         default:
//             console.log('Invalid State!');
//             break;
//     }
// }

// $(function () {
//     $(".pad-process").click(function () {
//         $(this).css("background","red");
//         $(this).attr("disabled",true);
//     });
// });


//callback
//
//     callback1:function(){}
//
//     callback2:function(){}

//执行
//
// menu.initialize();
//
//

