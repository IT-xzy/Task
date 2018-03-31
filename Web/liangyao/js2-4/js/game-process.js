/**
 * Created by Administrator on 2017/11/18/018.
 */
localStorage.getItem("randomArray");
localStorage.valueOf();
var sum= localStorage.getItem("randomArray").split(",");
console.log(sum);

var objlive=JSON.parse(localStorage.getItem('objlive'));
var objdead=JSON.parse(localStorage.getItem('objdead'));
var objbill=JSON.parse(localStorage.getItem('objbill'));
console.log(objlive);
console.log(objdead);
console.log(objbill);
console.log(localStorage);
//
$(document).ready(function () {

    //状态机
    var fsm = new StateMachine({
        init: 'begin',
        transitions: [
            {name: 'killMan', from: 'begin', to: 'kill'},
            {name: 'dTalk', from: 'kill', to: 'dead'},//改变状态的名字以及从上一状态变为下状态
            {name: 'talk', from: 'dead', to: 'player'},
            {name: 'handUp', from: 'player', to: 'poll'},
            {name: 'goto', from: '*', to: 'begin'}
        ],
        methods: {
            //改变状态的方法,点击杀人跳转按钮变色，从无状态到杀手杀人状态；
            onKillMan: function () {
                $('#kill').css("background-color", "#24a7c6");
                console.log('从无状态，进入杀手杀人状态' + fsm.state);

            },
            onEnterDead: function () {
                $('#dead').css("background-color", "#24a7c6");
                console.log('从杀手杀人进入死者发言' + fsm.state);
                alert("请死者发言");

            },
            onEnterPlayer: function () {
                $('#player').css("background-color", "#24a7c6");
                console.log('从死者发言进入玩家发言' + fsm.state);
                alert("请玩家依次发言")
            },
            onEnterPoll: function () {
                $('#poll').css("background-color", "#24a7c6");
                console.log('从玩家发言进入投票' + fsm.state);
                //移除杀手杀人返回的状态
                localStorage.removeItem('setState');
                location.href = "http://student.task.web.ptteng.com/liangyao/js/task2-4/poll.html";
            }
        }

    });
    //四个步骤
    $("#kill").click(function () {

        if (fsm.cannot('killMan')) {
            alert("请按照步骤")
        }
        fsm.killMan();
        localStorage.setItem('setState',fsm.state);
        location.href = "http://student.task.web.ptteng.com/liangyao/js/task2-4/7.1.html";
        console.log(fsm.state);

    });
    $("#dead").click(function () {
        if (fsm.cannot('dTalk')) {
            alert("请按照步骤")
        }
        fsm.dTalk();
        console.log(fsm.state);
    });
    $("#player").click(function () {
        if (fsm.cannot('talk')) {
            alert("请按照步骤")
        }
        fsm.talk();
        console.log(fsm.state);

    });
    $("#poll").click(function () {
        if (fsm.cannot('handUp')) {
            alert("请按照步骤")
        }
        fsm.handUp();
        console.log(fsm.state);
        localStorage.setItem('setState',fsm.state);
    });
    var objdead=JSON.parse(localStorage.getItem('objdead'));
    var objbill=JSON.parse(localStorage.getItem('objbill'));
    var setState=localStorage.getItem('setState');
    console.log(setState);
    console.log(objdead);
    console.log(objbill);
    var day = objbill.length + 1;
    $('#today').text("第" + day + "天");


    if(setState==='kill') {
        fsm.killMan();
        // 生成杀手杀人的信息
        console.log(objdead[objdead.length - 1]);
        var y = objdead[objdead.length - 1].num + 1;
        var x = objdead[objdead.length - 1].name;
        var text = $("<p></p>").css("marginLeft", "50px").text(y + "号被杀死，其真实身份是" + x);
        $("#kill").after(text);
        console.log(day);
        console.log('投票之后' + fsm.state);
    }
    if(day>1){


        for (i = 1; i < day; i++) {
            var y = objdead[i-1].num+1;
            var x = objdead[i-1].name;
            var l = objbill[i-1].num+1;
            var k = objbill[i-1].name;
         var textbox=$("<div>").addClass("process-mesbox")
            var $daytime = $("<p></p>").addClass("process-mes").text( y+ "号被杀死，其真实身份是" + x);
            var $night = $("<p></p>").addClass("process-mes").text(l + "号被投死，其真实身份是" + k);

            var $yestrday = $("<div></div>").addClass("day").text("第" + i + "天");
            $('#today').before($yestrday);
              $yestrday.after(textbox.append($daytime).append($night))

        }
    }
});
