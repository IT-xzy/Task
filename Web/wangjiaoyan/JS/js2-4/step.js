/**
 * Created by Administrator on 2017/12/18.
 */
$(document).ready(function () {
    // var day = 1;
    var status = sessionStorage.getItem("state");
    console.log(status);
    var fsm = new StateMachine({
        init: status,
        transitions: [
            {name: 'kill', from: 'none', to: 'die'},
            {name: 'lastWords', from: 'die', to: 'lastSpeak'},
            {name: 'speak', from: 'lastSpeak', to: 'discuss'},
            {name: 'vote', from: 'discuss', to: 'none'}
        ],
        methods: {
            onAfterKill: function (lifecycle) {                             //杀人事件后
                // console.log('状态、 ' + fsm.state);
                sessionStorage.setItem('state', fsm.state);
                $('#kill').css('background-color', '#18758D');

            },

            onAfterLastWords: function (lifecycle) {
                console.log('状态: ' + fsm.state);//当执行发表遗言事件时
                // alert("请亡者发表最后遗言");
                sessionStorage.setItem('state', fsm.state);
                // $("#lastWords").css('background-color', '#18758D');

            },

            onSpeak: function (lifecycle) {          //当执行玩家发言时
                console.log('状态: ' + fsm.state);//当执行发表遗言事件时
                sessionStorage.setItem('state', fsm.state);
                // alert("请玩家依次发言");
                // $("#speak").css('background-color', '#18758D');

            }

        }
    });
    $("#kill").click(function () {
        fsm.kill()
    });
    $("#lastWorlds").click(function () {

            fsm.lastWords()

    })

});