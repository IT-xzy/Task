var order = JSON.parse(localStorage.getItem('key'));
var arr = [];
var arr = order;


var content = document.getElementsByClassName("nav_content")[0];
var kill = document.getElementsByClassName("box")[0];
//杀手杀人
var last_word = document.getElementsByClassName("box")[1];
//发表遗言
var say = document.getElementsByClassName("box")[2];
//依次发言        
var vote = document.getElementsByClassName("box")[3];
//全民投票

// kill.onclick=function(){
//     location.href = "./log.html";
// }

var fsm = new StateMachine({
    init: 'kill',
    transitions: [{
            name: 'one',
            from: 'kill',
            to: 'last_word'
        },
        {
            name: 'two',
            from: 'last_word',
            to: 'say'
        },
        {
            name: 'three',
            from: 'say',
            to: 'vote'
        },
        {
            name: 'four ',
            from:'vote',
            to:'kill'

        }
    ],

    methods: {
        onInvalidTransition: function (transitions, from, to) {
            switch (from) {
                case 'one':
                    alert('请按顺序操作');
                    break;
                case 'two':
                    alert('请按顺序操作');
                    break;
                case 'three':
                    alert('请按顺序操作');
                    break;
                case 'four':
                    alert('请按顺序操作');
                    break;
            }
        }
    }
});



$('.box').eq(0).on('click', function () {
    location.href = "./log.html";
    fsm.one();
})

$('.box').eq(1).on('click', function () {
    confirm("死者亮明身份并且发表遗言");
    fsm.two();
})

$('.box').eq(2).on('click', function () {
    confirm("玩家依次发言");
    fsm.three();
})

$('.box').eq(3).on('click', function () {
    confirm("跳跳跳");
    fsm.four();
})



// function kill() {

// }




function button_right() {
    location.href = "./log.html";
}

function button_left() {
    confirm("本轮游戏是否已经结束？");
}