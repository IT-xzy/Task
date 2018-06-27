//获取模态框的DOM
var s = document.getElementById("shade");
var r = document.getElementById("circle");
var d = document.getElementById("dialog");
var e = document.getElementById("enter");
var n = document.getElementById("end");

// //有限状态机
// $(document).ready(function () {
//     var fsm = new StateMachine({
//         into: 'night',
//         transitions: [
//             {name: 'kill', from: 'night', to: 'day'},
//             {name: 'ghost', from: 'day', to: 'say'},
//             {name: 'player', from: 'say', to: 'voter'},
//             {name: 'vote', from: 'voter', to: 'night'}
//         ],
//         methods: {
//             onAfterKill: function (lifecycle) {
//                 console.log('状态:'+ fsm.state);
//                 sessionStorage.setItem('stateDie', fsm.state);
//             },
//             onGhost: function (lifecycle) {
//                 s.style.display = "block";
//                 r.style.display = "block";
//                 d.innerHTML = "请亡灵发表遗言";
//                 sessionStorage.setItem('ghosts', fsm.state);
//                 $("#ghost").css('background-color', '#21a8c8');
//             },
//             onPlayer: function (lifecycle) {
//                 s.style.display = "block";
//                 r.style.display = "block";
//                 d.innerHTML = "请玩家依次发言";
//                 sessionStorage.setItem('say', fsm.state);
//                 $("#player").css('background-color', '#21a8c8');
//             },
//             onAfterVote: function (lifecycle) {
//                 $("#vote").css('background-color', '#21a8c8');
//                 sessionStorage.setItem('stateNight', fsm.state);
//                 sessionStorage.removeItem('stateDie');
//                 sessionStorage.removeItem('ghosts');
//                 sessionStorage.removeItem('say');
//             }
//         }
//     });
//     var Die = sessionStorage.getItem('stateDie');
//     var Ghost = sessionStorage.getItem('ghosts');
//     var Say = sessionStorage.getItem('say');
//     if(Die === "day"){
//         $('#kill').css('background-color', '#21a8c8');
//     }
//     if(Ghost === "say"){
//         $('#ghost').css('background-color', '#21a8c8');
//     }
//     if(Say === "voter"){
//         $('#player').css('background-color', '#21a8c8');
//     }
//     $('#kill').click(function () {
//         if(Die === "day"){
//             alert("请按步骤来!")
//         }else {
//             fsm.kill();
//             window.location.href = "kill.html";
//             sessionStorage.setItem('title', "杀手杀人");
//             sessionStorage.setItem('killer',"杀手请睁眼,杀手请选择要杀的对象");
//             sessionStorage.setItem('isKill','1');
//             disabled = "disabled";
//         }
//     });
//     $('#ghost').click(function () {
//         if(Die !== 'day'){
//             alert("请按步骤来!");
//         }else {
//             fsm.kill();
//             if(Ghost !== 'say'){
//                 fsm.ghost();
//                 disabled = "disabled";
//             }
//         }
//     });
//     $('#player').click(function () {
//         if(Die !== 'day'){
//             alert("请按照步骤来!")
//         }else {
//             if(Say === 'voter'){
//                 alert("请按步骤来!")
//             }else {
//                 fsm.player();
//                 disabled = "disabled";
//             }
//         }
//     });
//     $('#vote').click(function () {
//         sessionStorage.removeItem('isKill');
//         if(Die !== 'day'){
//             alert("请按步骤来!");
//         }else {
//             fsm.vote();
//             window.location.href = "kill.html";
//         }
//     })
// });
var a;
var b;
var c;
function test() {
    a = parseInt(sessionStorage.getItem('A'));
    b = parseInt(sessionStorage.getItem('B'));
    c = parseInt(sessionStorage.getItem('C'));
}
test();
function rendar() {
    if(a === 1){
        document.getElementById("kill").style.background = "#18758D";
    }
    if(b === 1){
        document.getElementById("ghost").style.background = "#18758D";
    }
    if (c ===1){
        document.getElementById("player").style.background = "#18758D";
    }
}
rendar();

//杀手杀人
function kill() {
    if(a === 1){
        alert("请按步骤来!");
    }else {
        window.location.href = "kill.html";
        sessionStorage.setItem('title', "杀手杀人");
        sessionStorage.setItem('killer', "杀手请睁眼,杀手请选择要杀的对象");
        sessionStorage.setItem('isKill', '1');
        document.getElementById("kill").style.background = "#18758D";
        sessionStorage.setItem('A', '1');
    }
}
//亡灵遗言
function ghost() {
    if(a === 1){
        if(b !== 1) {
            alert("请亡灵发表遗言");
            // s.style.display = "block";
            // r.style.display = "block";
            // d.innerHTML = "请亡灵发表遗言";
            document.getElementById("ghost").style.background = "#18758D";
            sessionStorage.setItem('B', '1');
            test();
        }else alert("请按步骤来!");
    }else alert("请按步骤来!");
}
//玩家发言
function player() {
    if(b === 1){
        if(c !== 1){
            alert("请玩家依次发言");
            // s.style.display = "block";
            // r.style.display = "block";
            // d.innerHTML = "请玩家依次发言";
            document.getElementById("player").style.background = "#18758D";
            sessionStorage.setItem('C', '1');
            test();
        }else alert("请按步骤来!");
    }else alert("请按步骤来!");
}
//玩家投票
function vote() {
    if(c === 1){
        window.location.href = "kill.html";
        sessionStorage.setItem('title', "玩家投票");
        sessionStorage.setItem('killer',"发言讨论结束,大家请投票");
        sessionStorage.removeItem('isKill');
        sessionStorage.removeItem('A');
        sessionStorage.removeItem('B');
        sessionStorage.removeItem('C');
    }else alert("请按步骤来!");
}

// function test() {
//     window.location.href = "game.html";
// }
//根据已死亡玩家数量来判断游戏进行到第几天
var dieNum = sessionStorage.getItem('dieNum');
var day;
if(sessionStorage.getItem('dieNum')){
    dieNum = JSON.parse(sessionStorage.getItem('dieNum'));
}else {
    dieNum = [];
}
if(dieNum<=2){
    day = 1;
}else {
    day = Math.ceil((dieNum.length+1)/2);
}
$('#day').text("第"+day+"天");
$('#days').text("第"+day+"天");

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
        '<p>' + "晚上:" +kong[m][0]+"被杀手杀死" +'</p>'+
        (!kong[m][1]?'':'<p>' + "白天:" +kong[m][1]+"被全民投票投死" +'</p>' +'</div>');

    block.push(content);
}
document.getElementById("record").innerHTML=block.join('');

$(document).ready(function(){
    $(".day").click(function(){
        $(this).next("#list").toggle();
    });
});

//结束游戏
function finish() {
    s.style.display = "block";
    r.style.display = "block";
    e.style.display = "none";
    n.style.display = "block";
    d.innerHTML = "确定要结束游戏?";
}

//法官日志
// function judge() {
//     window.location.href = "god.html";
// }

//模态框
function enter() {
    location.href = "game.html";
}
function cancel() {
    location.href = "game.html";
}
function end() {
    sessionStorage.clear();
    window.location.href = "home.html";
}