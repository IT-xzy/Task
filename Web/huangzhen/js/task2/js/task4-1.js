// 定义天数变量
var time = 1;

$(".wrap").prepend('<div class="date">第' + time + '天</div>');
$(".date").click(function () {
    $(".process").slideToggle();
});
$(".info").append('<p class="death-note">2号玩家已死亡，他的身份是平民</p>');
var i = $(".btn").index($(this));

$(document).ready(function () {
    // 有限状态机，控制流程step1-4
    // 创建一个控制流程的参数
    var $stage = new StateMachine({
        // 初始
        init: 'none',
        transitions: [{
                name: 'step1',
                from: 'none',
                to: '1'
            },
            {
                name: 'step2',
                from: '1',
                to: '2'
            },
            {
                name: 'step3',
                from: '2',
                to: '3'
            },
            {
                name: 'step4',
                from: '3',
                to: '4'
            },
            {
                name: 'reset',
                from: '4',
                to: 'none'
            }
        ],

        // 这里只是方法，点击事件要重新写
        methods: {
            onStep1: function () {
                $(".btn").eq(parseInt(i) - 3).addClass("another");
                $(".trangel").eq(parseInt(i) - 3).addClass("border-another");
                // console.log(i);
            },
            onStep2: function () {
                $(".btn").eq(parseInt(i) - 2).addClass("another");
                $(".trangel").eq(parseInt(i) - 2).addClass("border-another");
            },
            onStep3: function () {
                $(".btn").eq(parseInt(i) - 1).addClass("another");
                $(".trangel").eq(parseInt(i) - 1).addClass("border-another");
            },
            onStep4: function () {
                $(".btn").eq(parseInt(i)).addClass("another");
                $(".trangel").eq(parseInt(i)).addClass("border-another");
            }
        }
    })

    // 判断流程状态

    $(".step1").click(function () {
        $stage.step1();
        alert("进入杀人环节！");
        window.sessionStorage.setItem('$stage', "1");
        // window.location.href = "task4-2.html";
    })
    $(".step2").click(function () {
        $stage.step2();
        window.sessionStorage.setItem('$stage', "2");
        alert("亡灵发表遗言！");
    })
    $(".step3").click(function () {
        $stage.step3();
        window.sessionStorage.setItem('$stage', "3");
        alert("玩家依次发言！")
    })
    $(".step4").click(function () {
        $stage.step4();
        window.sessionStorage.setItem('$stage', "4");
        alert("进入投票环节！");
        // window.location.href = "task4-2.html";  
    })

    // var $stagecheck = window.sessionStorage.getItem("$stage");
    // if ($stageCheck == "1") {
    //     $stage.step1();
    // }
    // else if ($stageCheck == "2") {
    //     $stage.step1();
    //     $stage.step2();
    // }else if ($stageCheck == "3") {
    //     $stage.step1();
    //     $stage.step2();
    //     $stage.step3();
    // }
    // else if ($stageCheck == "4") {
    //     $stage.step1();
    //     $stage.step2();
    //     $stage.step3();
    //     $stage.step4();
    // }
    // else {
    //     $stage.reset();
    // }

    var $day=new StateMachine({

    })
})