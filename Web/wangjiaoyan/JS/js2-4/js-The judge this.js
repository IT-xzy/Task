
$(document).ready(function () {
    var fsm = new StateMachine({
        init: 'none',
        transitions: [
            {name: 'kill', from: 'none', to: 'die'},
            {name: 'lastWords', from: 'die', to: 'lastSpeak'},
            {name: 'speak', from: 'lastSpeak', to: 'discuss'},
            {name: 'vote', from: 'discuss', to: 'none'}
        ],
        methods: {
            onAfterKill: function (lifecycle) {                             //杀人事件后
                console.log('状态、 ' + fsm.state);
                sessionStorage.setItem('stateDie', fsm.state);

            },

            onLastWords:function (lifecycle) {
                console.log('状态: ' + fsm.state);//当执行发表遗言事件时
                alert("请亡者发表最后遗言");
                sessionStorage.setItem('last', fsm.state);
                $("#lastWords").css('background-color','#18758D');

            },

            onSpeak:function (lifecycle) {          //当执行玩家发言时
                console.log('状态: ' + fsm.state);//当执行发表遗言事件时
                sessionStorage.setItem('speak', fsm.state);
                alert("请玩家依次发言");
                $("#speak").css('background-color','#18758D');

            },

            onAfterVote:function (lifecycle) {
                $('#vote').css('background-color', '#18758D');
                sessionStorage.setItem('stateNone',fsm.state  );                //保存状态 None
                sessionStorage.removeItem('stateDie');                          //清除 stateDie 状态的数据，回到第二天
                sessionStorage.removeItem('last');
                sessionStorage.removeItem('speak');
            }
        }
    });

    var Die=sessionStorage.getItem('stateDie');
    var Last=sessionStorage.getItem('last');
    var Discuss=sessionStorage.getItem('speak');

    if(Die === "die"){    //保存杀手杀人状态
        $('#kill').css('background-color', '#18758D');
    }
    if(Last=== "lastSpeak"){
        $('#lastWords').css('background-color', '#18758D');
    }
    if(Discuss === "discuss"){
        $('#speak').css('background-color', '#18758D');
    }

    $("#kill").click(function () {
        if(Die === "die"){   //如果已经杀过人，就进行下一步，并执行kill方法
            alert('请按步骤来');
        }
        else {
            location.href = 'js-kill people.html';
            fsm.kill();
            sessionStorage.setItem('isKill',1);
            disabled="disabled"
        }
    });

    $("#lastWords").click(function () {
        if(Die !== "die"){
            alert("请按步骤来")
        }
        else {
            fsm.kill();    //显示die状态才能进行下一步
            if (Last !== "lastSpeak") {
                fsm.lastWords();
                disabled="disabled"

            }
            else {
                alert("请按步骤来");
            }
        }
    });



    $("#speak").click(function () {

        if(Die !== "die"){
            alert("请按步骤点")
        }
        else{
            if ((Discuss === "discuss")) {
                alert("请按步骤来");
            } else {
                fsm.speak();
                disabled="disabled"
            }
        }
    });

    $("#vote").click(function () {
        sessionStorage.removeItem('isKill');
        if(Die !== "die") {
            alert("请按步骤点")
        }
        else{
            fsm.vote();
            location.href = 'js-kill people.html';
        }
    });

});

$(".over").click(function () {
    if (confirm("确定结束该游戏吗？")) {
        sessionStorage.clear();
        location.href = "js2-1.html";
    }
});


//储存天数
var dieNum = sessionStorage.getItem("dieNum");
if(sessionStorage.getItem('dieNum')){
    dieNum=JSON.parse(sessionStorage.getItem('dieNum'));
}else {
    dieNum=[]
}
var day;
if(dieNum<=2){
    day=1;
}else {
    day=Math.ceil((dieNum.length+1)/2);
}
$(".day").text("第"+day+"天");
$(".days").text("第"+day+"天");


var dieList = JSON.parse(sessionStorage.getItem("dieList"));
console.log(dieList);
var kong=[];
for(var i=0;i<dieList.length;i+=2){
    kong.push(dieList.slice(i,i+2));
}
console.log(kong);


var block=[];
var content;
for (var m = 0; m < kong.length; m++) {
    content = (!kong[m][1]?'':'<div class="day">' + "第"+(m+1)+"天"+ '</div>')  +'<div id="list">'+
        '<p> ' + "晚上:" +kong[m][0]+"被杀手杀死" +'</p>'+
        (!kong[m][1]?'':'<p> ' + "白天:" +kong[m][1]+"被全民投票投死" +'</p>' +'</div>');

    block.push(content);
}
document.getElementById("record").innerHTML=block.join('');

$(document).ready(function(){
    $(".day").click(function(){
      $(this).next("#list").toggle();
    });
});