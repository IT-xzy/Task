$(document).ready(function(){

    var player = JSON.parse(sessionStorage.getItem('player'));//取出总玩家人数数组
    var playerStates = [];//var一个变量来装玩家的初始状态
    var beKiller = [];//var一个变量来装被杀的角色
    var beVote = [];//var一个变量来装被投的角色
    var days = 1;//初始化天数为1

    sessionStorage.setItem('beKiller', JSON.stringify(beKiller));
    sessionStorage.setItem('beVote', JSON.stringify(beVote));
    sessionStorage.setItem('days', JSON.stringify(days));

/////////////////////////////////////////////////////////////////////////////////////////////

    for (var i=0; i<player.length; i++){//遍历数组，有几个玩家就循环几次，把所有玩家都遍历出来
        var num = i + 1;//每个角色对应的号码
        var inBox = '<div class=\"content-box\">\n'+//var个变量存储写进文档的标签代码，记住要转义字符
            '<div class=\"content-top\">\n'+
            '<div class=\"career\">\n'+ player[i] +
            '</div>\n'+
            '<div class=\"number\">\n'+ num +
            '</div>\n'+
            '</div>\n'+
            '<div class=\"content-bottom\">\n'+
            '</div>\n'+
            '</div>';
        $('.main-box').append(inBox);//通过append将盒子一个一个的往文档里面装

        playerStates[i] = {//为每个玩家角色添加初始状态，都是live
            id: player[i],//通过下标代表每个角色的身份
            state: 'live',
            num: num
        }
    }
    console.log(playerStates);
    sessionStorage.setItem('playerStates', JSON.stringify(playerStates));//将玩家状态保存
////////////////////////////////////////////////////////////////////////////////////////////


    $('.back-arrow').click(function(){
        var i = confirm('确定要返回角色页面吗？');
        if (i === true){
            location.href = '../html/task2-3.html';
        }
    });
    $('.close').click(function(){
        var i = confirm('确定要返回首页吗？');
        if (i === true){
            sessionStorage.clear();
            location.href = '../html/task2-1.html';
        }
    });
    $('.main-bottom').click(function(){
        location.href = '../html/task2-5.html';
    });

});