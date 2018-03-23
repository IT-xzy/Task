//原始人员数据判断接收
var result;
if (JSON.parse(sessionStorage.getItem("aliveColorC")) === null) {
    result = JSON.parse(sessionStorage.getItem("aliveColorA"));
}
else {
    result = JSON.parse(sessionStorage.getItem("aliveColorC"));
}



var state = JSON.parse(sessionStorage.getItem("daynum"));//页面1状态数据
var dayA = JSON.parse(sessionStorage.getItem("dayA"));//死亡人员位置
var dieArr = JSON.parse(sessionStorage.getItem("dieArr"));//死亡人员数组
if (dieArr === null) {
    var dieArr = [];
}
var dieNumA = JSON.parse(sessionStorage.getItem("dieNumA"));//死亡人员数组
if (dieNumA === null) {
    var dieNumA = [];
}
sessionStorage.setItem("dayA", JSON.stringify(dayA));

console.log(result);
console.log(state);
console.log(dieArr);
console.log(dieNumA);


var main = document.getElementById("main");
var orange = document.getElementsByClassName("two-orange");
var kill = document.getElementById("kill");
var twoSpeak = document.getElementById("two-speak");


var number;//点击对象的index位置
var boxArr = [];//全部人的数组

//数组result内“1 表示杀手 2 表示水民 0表示死亡”
for (var i = 0; i < result.length; i++) {
    var a = i + 1;
    boxArr[i] = "<div class=\"dropdown\"><div class=\"tow-box\"><div class=\"two-orange\" id='some'>水民</div><div" +
        " class=\"two-green\">" + a + "号</div></div><div class=\"two-choice\"><button class=\"" +
        " img-two4\"></button></div></div>";
    if (result[i] === 1) {
        boxArr[i] = "<div class=\"dropdown\"><div class=\"tow-box\"><div class=\"two-orange\" id='some'>杀手</div><div" +
            " class=\"two-green\">" + a + "号</div></div><div class=\"two-choice\"><button class=\" img-two4\"></button></div></div>";
    }
}//遍历一个人数盒子数组
var boxbrr = boxArr.join("");//转换成字符串
main.innerHTML = boxbrr;//自动显示数量

//死亡状态自动变色
console.log(result);
for (var n = 0; n < result.length; n++) {
    if (result[n] === 0) {
        orange[n].style.backgroundColor = "green";
    }
}
//根据流程页面状态自动显示文字
if (state === null) {
    kill.innerText = "投票";
    twoSpeak.innerText = "发言讨论结束，大家请投票";
}


//人员死活状态机
var menu = {
    // 当前状态
    state: result[number],
    // 绑定事件
    initialize: event(),
    // 状态转换
    transition: function () {
        switch (result[number]) {
            case 1:
                night();
                break;
            case 2:
                vote();
                break;
            case 0:
                alert("玩家已死亡，请选择其它玩家");
                break;
        }
    }
};

//人员死活状态机-事件函数
function event() {
    $(".img-two4").click(function () {
        number = $(this).parent().parent().index();
        console.log(number);
        sessionStorage.setItem("dieNum", JSON.stringify(number));
        menu.transition();
    })
}

//人员死活状态机-存活状态执行函数（夜晚判断杀手不能杀自己）
function night() {
    if (state === 'b') {
        alert("杀手不能杀死自己，请重新选择")
    } else {
        vote();
    }
}

//投票环节执行函数
function vote() {
    if (confirm("是否确定选择")) {
        //如果是true
        orange[number].style.backgroundColor = "green";
        //生产死亡数组

        dieNumA.push(number+1);
        if (result[number] === 1) {
            dieArr.push("杀手");
        } else {
            dieArr.push("水民");
        }
        result[number] = 0;//数组里数为0表示状态死亡
        console.log(number);
        console.log(result);
        console.log(dieArr);

        sessionStorage.setItem("aliveColorB", JSON.stringify(result));
        sessionStorage.setItem("dieArr", JSON.stringify(dieArr));
        sessionStorage.setItem("dieNumA", JSON.stringify(dieNumA));
        if (state === null) {
            end();
        }else {
            location.href = "jstask3-2.html";
        }

    }

}


//判断游戏是否结束
function end() {
    //建立杀手、水民、死亡数组
    var compare = {};
    result.join().replace(/(\w{1})/g, function ($1) {
        compare[$1] ? compare[$1] += 1 : compare[$1] = 1;
    });
    //判断游戏是否结束
    if (compare[1] === undefined) {
        alert("水民胜利，游戏结束");
        location.href = "end.html"
    } else if (compare[2] - compare[1] <= 1) {
        alert("杀手胜利，游戏结束");
        location.href = "end.html"
    }
    else {
        location.href = "jstask3-2.html";
    }
}

//点击确定弹框
function determine() {
    alert("请点击号码下面的图标")
}


//页面1状态数据
sessionStorage.setItem("daykill", JSON.stringify(state));


//之前页面状态机的状态重新执行并用sessionStorage返回
// function day() {
//     switch (state) {
//         case null:
//             state = 'b';
//             break;
//         case"b":
//             state = 'c';
//             break;
//         case"c":
//             state = 'd';
//             break;
//         case"d":
//             state = null;
//             break;
//         default:
//             console.log('Invalid State!');
//             break;
//     }
// }
//
// day();


// function nowfsm() {
//     style = window.getComputedStyle(orange , )
// }
//
// function xxx(x) {
//     for(var x=0; x<result.length;x++)
//         var live = menu;
// }

// for (var x = 0; x < img.length; x++) {
//     img[x].disabled = true;
// }

// var alive = {
//     people : result[0]
// };

// img[0].onclick = function() {
//     var oStyle = window.getComputedStyle(orange[x], null);
//     if (oStyle.backgroundColor === "rgb(245, 201, 123)") {
//         menu.state = "orange";
//     } else {
//         menu.state = "green";
//     }
// };

// var arrAlive = [];
// for(var n = 0; n < i; n++) arrAlive[n] = 'orange';
// console.log(arrAlive);

