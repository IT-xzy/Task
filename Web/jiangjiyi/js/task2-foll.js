var key = JSON.parse(localStorage.getItem("Arr"));




//关闭页面可以使用
$("header img").first().click(function(){
    let r = confirm("你想关闭页面，重新开始吗？")
    if ( r === true ) {
    window.location.href =  "task2-licens.html";
    };

});

$("header img").last().click(function(){
    let r = confirm("你想结束游戏，看结果吗？")
    if ( r === true ) {
        window.location.href =  "task2-win.html";
    };
});


var fsm = new StateMachine({
    init: 'live',
    transitions: [
        { name: 'murder',     from: 'live',  to: 'kill' },
        { name: 'speech',     from: 'kill',  to: 'undead' },
        { name: 'players',     from: 'undead',  to: 'tall' },
        { name: 'vote',     from: 'tall',  to: 'govote' },
    ],
    methods: {
        onMurder: function () {
            $(".kill").css("background-color", "#C8FFAD");
            // window.location.href =  "task2-ched.html";
        },
        onSpeech: function () {
            $(".tall").css("background-color", "#C8FFAD");

        },

        onPlayers: function () {
            $(".tall2").css("background-color", "#C8FFAD");

        },

        onVote: function () {
            $(".vote").css("background-color", "#C8FFAD");
            // window.location.href =  "task2-licens.html";
        },

    }
});

//添加点击事件
// $(document).ready(function(){
    $(".kill").click(function () {
        if(fsm._fsm.state=='live'){
            fsm.murder();
            window.location.href =  "task2-ched.html";
            localStorage.setItem('state', (fsm.murder()));
        }
        else {
            alert("请按顺序操作")
        }

    });

    $(".tall").click(function () {
        if(fsm._fsm.state=='kill'){
            fsm.speech();
            confirm("死亡的人出来唠唠")
        }
        else {
            alert("请按顺序操作")
        }
    });
    $(".tall2").click(function () {
        if(fsm._fsm.state=='undead'){
            fsm.players();
            confirm("请玩家发言吧，看谁不顺眼就杀谁")
        }
        else {
            alert("请按顺序操作")
        }

    });
    $(".vote").click(function () {
        if(fsm._fsm.state=='tall'){
            fsm.vote();
            window.location.href =  "task2-ched.html";
        }
        else {
            alert("请按顺序操作")
        }
    });
    // if () {
    //     g
//     // }
// });
