// 返回按钮返回到发牌页面
$('#backtrack').click(function () {
    //点击按钮清除本地存储的数据
    localStorage.removeItem("castarr");
    localStorage.removeItem("killarr");
    localStorage.removeItem("statusarr");
    localStorage.removeItem("fate");
    localStorage.removeItem("killarr");
    localStorage.removeItem("castarr");
    localStorage.removeItem("progress");
    // 返回上一个页面
    location.href = "../html/diary.html";
})

// 关闭按钮返回到主页面
$('#off').click(function () {
    if (confirm("是否要退出游戏返回到主页面")) {
        localStorage.clear(); //清除所有数据
        location.href = "../html/start.html"; //点击确定返回到主页面
    } else {
        return false; //点击取消停留在当前页面
    }
})

// 获取一开始生成的角色对象数组
var data = JSON.parse(localStorage.getItem("store"));
var arr = [];
var arr = data;
console.log(arr)

// 获取状态机的初始状态
var condition = JSON.parse(localStorage.getItem("condition"));
// console.log(condition)

//状态机状态数组
var state = ["homicide", "deceased", "discuss", "vote"];

var initialize; // 定义一个变量来储存状态机的init状态
initialize = "homicide"; //设置变量为默认状态为

// 当杀手杀人后把保存的数据读取并赋值给状态变量为condition状态
for (let i = 0; i < arr.length; i++) {
    if (arr[i].status == "杀死") {
        initialize = condition;
    }
}
// console.log(initialize)

// 状态机
var fsm = new StateMachine({
    init: initialize, //初始状态
    // 定义状态的状态
    transitions: [{
            name: 'killer',
            from: 'homicide',
            to: 'deceased'
        },
        {
            name: 'ghost',
            from: 'deceased',
            to: 'discuss'
        },
        {
            name: 'player',
            from: 'discuss',
            to: 'vote'
        },
        {
            name: 'finally',
            from: 'vote',
            to: 'homicide'
        },
    ],
    //构造状态机的方法
    methods: {
        // 定义状态机的报错机制
        onInvalidTransition: function (transition, from, to) {
            switch (from) {
                case "homicide":
                    alert("杀手请先杀人");
                    break;
                case "deceased":
                    alert("亡灵请先发表遗言");
                    break;
                case "discuss":
                    alert("玩家请先发表言论");
                    break;
                case "vote":
                    alert("玩家请先投票");
                    break;
            }
        },
        onKiller: function () {
            // 符合状态机制改变跳出窗口修改期背景颜色
            alert("杀手开始杀人")
            $('ul li:nth-child(3)').css("background", "#e4e4e4");
            $('.step1').css("border-right", ".35rem solid #e4e4e4");
            //改变每个对应的步骤状态对象属性从no改为yes
            for (let i = 0; i < statusarr.length; i++) {
                statusarr[i].murder = "yes";
            }
            // 保存改变对象属性的数据
            localStorage.setItem("statusarr", JSON.stringify(statusarr));
        },
        onGhost: function () {
            alert("杀手杀人完毕，死者发表遗言")
            $('ul li:nth-child(5)').css("background", "#e4e4e4");
            $('.step2').css("border-right", ".35rem solid #e4e4e4");
            for (let i = 0; i < statusarr.length; i++) {
                statusarr[i].demise = "yes";
            }
            localStorage.setItem("statusarr", JSON.stringify(statusarr));
        },
        onPlayer: function () {
            alert("死者发表遗言完毕，玩家依次讨论发言")
            $('ul li:nth-child(6)').css("background", "#e4e4e4");
            $('.step3').css("border-right", ".35rem solid #e4e4e4");
            for (let i = 0; i < statusarr.length; i++) {
                statusarr[i].discuss = "yes";
            }
            localStorage.setItem("statusarr", JSON.stringify(statusarr));
        },
        onFinally: function () {
            alert("玩家发言完毕，玩家进行投票")
            $('ul li:nth-child(7)').css("background", "#e4e4e4");
            $('.step4').css("border-right", ".35rem solid #e4e4e4");
            for (let i = 0; i < statusarr.length; i++) {
                statusarr[i].vote = "yes";
            }
            // 保存改变对象属性的数据
            localStorage.setItem("statusarr", JSON.stringify(statusarr));
            //点击投票按钮后手动push步骤对象到数组
            statusarr.push(new Status("no", "no", "no", "no"))
            //时时保存手动push的步骤对象数据
            localStorage.setItem("statusarr", JSON.stringify(statusarr));
        },
    }
});

// 获取每一天被杀死和投死的玩家
var fate = JSON.parse(localStorage.getItem("fate"));
var fate = []; //创建死亡数组

// 获取被杀手杀死的玩家
var killarr = JSON.parse(localStorage.getItem("killarr"));
// 获取被投票投死的玩家
var castarr = JSON.parse(localStorage.getItem("castarr"));

//创建每天被杀死和被投死的构造函数对象
function Days(kill, cast) {
    this.kill = kill;
    this.cast = cast
}
var kill = killarr; //把获取到的每天被杀死的玩家传到对象
var cast = castarr; //把获取到的每天被投死的玩家传到对象
fate.push(new Days(kill, cast)) //把对象push到创建的死亡数组里
console.log(fate)
localStorage.setItem("fate", JSON.stringify(fate)); //保存死亡对象数组



// 创建一个天数数组
var time = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十"];
if (cast != undefined) {
    // 点击玩家投票后生成新的一天
    for (let i = 0; i <= cast.length - 1; i++) {
        $('main').append($('#Days').eq(0).clone(true));
    }

    for (let e = 0; e <= cast.length; e++) {
        // 根据生成的天数并改变为第几天
        $('h4').eq(e).text("第" + time[e] + "天")
        // 生成新的一天后，把前一天的进度隐藏
        for (let i = 0; i < $('ul').length - 1; i++) {
            $('ul').eq(i).css("display", "none");
        }
        // console.log(e+'e')
        // 当e小于天数长度
        // if (e < cast.length) {
        //     for (let i = 0; i<$('ul li').length; i++) {
        //         if (i === 2 || i === 4 || i === 6 || i === 5) {
        //             // 点击当前天数之前的天数跳出弹窗提示
        //             $('ul').eq(e).find('li').eq(i).click(function () {
        //                 alert('请按正确流程')
        //             })
        //         } 
        //     }
        // }
    }
}

// 定义一个委托事件,当点击当前天数之前的天数跳出提示
for (let i = 0; i < $('ul').length - 1; i++) {
    let x = i + 1;
    $('ul').eq(i).on('click', 'li.step', function () {
        alert("这是是第" + x + "天的流程，请按正确的天数流程进行")
    })
}


// 显示每一天对应被杀死的人
if (kill != null) {
    for (let i = 0; i < kill.length; i++) {
        $('.killed').eq(i).text(kill[i].num + "号被杀死，他的真实身份是" + kill[i].breed).css({
            "font-size": ".1rem",
            "margin-bottom": ".2rem",
        })
        $('.sun').css("margin-top", ".9rem")
    }
}
// 显示每一天对应被投死的人
if (cast != null) {
    for (let i = 0; i <= cast.length - 1; i++) {
        $('.Cast').eq(i).text(cast[i].num + "号被投死，他的真实身份是" + cast[i].breed).css({
            "font-size": ".1rem",
            "margin-bottom": ".2rem",
        })
    }
}

// 获取步骤状态对象属性数组
var tt = JSON.parse(localStorage.getItem("statusarr"));
// console.log(tt)
var statusarr = []; //创建骤状态对象属性数组

//当第一天杀手杀完人之后的跳转把获取步骤状态对象属性的值传入数组
if (tt != null) {
    statusarr = tt;
}
console.log(statusarr)
// 创建每一天的步骤的构造函数
function Status(murder, demise, discuss, vote) {
    this.murder = murder;
    this.demise = demise;
    this.discuss = discuss;
    this.vote = vote;
}
// 当点击开始游戏时自动把步骤对象push到数组，状态为no
if (statusarr.length == 0) {
    statusarr.push(new Status("no", "no", "no", "no"));
    // 保存自动push的步骤对象数组
    localStorage.setItem("statusarr", JSON.stringify(statusarr));
}

// 定义点击杀人按钮的方法
if (cast) {
    li1(cast.length) //当该数组长度存在把该值调用到e
} else {
    li1(0) //当数组长度不存在把该值调用到e
}

// 点击杀手杀人按钮
function li1(e) {
    $('ul li:nth-child(3)').eq(e).click(function () {
        if (initialize == state[0]) {
            //改变状态机初始状态为发表遗言状态，防止跳转回来不可以按正常流程进行
            initialize = state[1];
            //保存改变的状态，单杀手杀人后跳转回来再读取这个状态
            localStorage.setItem("condition", JSON.stringify(initialize));
            // 进入到杀人页面
            location.href = "../html/murder.html";
        }
        fsm.killer() //定义状态机过渡的方法
    })
}

// 定义亡灵按钮的方法
if (cast) {
    li2(cast.length); //当该数组长度存在把该值调用到e
} else {
    li2(0) //当数组长度不存在把该值调用到e
}

// 点击亡灵发表遗言按钮
function li2(e) {
    $('ul li:nth-child(5)').eq(e).click(function () {
        if (initialize == state[1]) {
            initialize = state[2]; //修改状态变量，防止后面无法做判断
            console.log(initialize)
        }
        fsm.ghost() //定义状态机过渡的方法
    })
}

// 点击讨论按钮的方法
if (cast) {
    li3(cast.length) //当该数组长度存在把该值调用到e
} else {
    li3(0) //当数组长度不存在把该值调用到e
}

// 点击讨论按钮
function li3(e) {
    $('ul li:nth-child(6)').eq(e).click(function () {
        if (initialize == state[2]) {
            initialize = state[3] //修改状态变量，防止后面无法做判断
            console.log(initialize)
        }
        fsm.player() //定义状态机过渡的方法
    })
}

// 定义投票按钮的方法
if (cast) {
    li4(cast.length) //当该数组长度存在把该值调用到e
} else {
    li4(0) //当数组长度不存在把该值调用到e
}

// 点击投票按钮
function li4(e) {
    $('ul li:nth-child(7)').eq(e).click(function () {
        if (initialize == state[3]) {
            initialize = state[0] //修改状态变量为初始状态，反正第二天不能按正常流程进行
            console.log(initialize)
            // 保存状态变量，生成第二天后读取数据
            localStorage.setItem("condition", JSON.stringify(initialize));
            location.href = "../html/vote.html"; //进入投票页面
        }
        fsm.finally() //定义状态机过渡的方法
    })
}

// 当步骤对象从no被修改为yes后改变对应的背景颜色
for (let i = 0; i < statusarr.length; i++) {
    if (statusarr[i].murder == "yes") {
        $('ul li:nth-child(3)').eq(i).css("background", "#e4e4e4");
        $('.step1').eq(i).css("border-right", ".35rem solid #e4e4e4");
    }
    if (statusarr[i].demise == "yes") {
        $('ul li:nth-child(5)').eq(i).css("background", "#e4e4e4");
        $('.step2').eq(i).css("border-right", ".35rem solid #e4e4e4");
    }
    if (statusarr[i].discuss == "yes") {
        $('ul li:nth-child(6)').eq(i).css("background", "#e4e4e4");
        $('.step3').eq(i).css("border-right", ".35rem solid #e4e4e4");
    }
    if (statusarr[i].vote == "yes") {
        $('ul li:nth-child(7)').eq(i).css("background", "#e4e4e4");
        $('.step4').eq(i).css("border-right", ".35rem solid #e4e4e4");
    }
}

//点击下拉宽，显示和隐藏
$("h4").click(function () {
    $(this).next().toggle();
});

// 点击结束游戏按钮
$('button').eq(0).click(function () {
    if (confirm("确定要现在结束游戏吗？")) {
        location.href = "../html/result.html"; //点击确定结束游戏
    } else {
        return false; //点击取消留在当前页面
    }
})

// 点击法官日志按钮查看log记录
$('button').eq(1).click(function () {
    location.href = "../html/log.html"
})














// function wh (day,num1,num2) {
//     $('ul').eq(day).children('li').eq(num1).css("background", "#e4e4e4");
//      $('.step' + num2).eq(day).css("border-right", ".35rem solid #e4e4e4");

//  }
//  wh(0,4,2)
//   console.log(wh(2,4,2))