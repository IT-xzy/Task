var days = JSON.parse(sessionStorage.getItem('days'));
console.log(days);
var beVote = JSON.parse(sessionStorage.getItem('beVote'));
console.log(beVote);
var beKiller = JSON.parse(sessionStorage.getItem('beKiller'));
console.log(beKiller);
var nowKillNum;//表示这一轮被杀死的角色号码
var nowKillId;//表示这一轮被杀死的角色身份
var playerStates = JSON.parse(sessionStorage.getItem('playerStates'));
console.log(playerStates);
sessionStorage.setItem('playerStates', JSON.stringify(playerStates));
var theKillNum;//被杀死玩家的编号
var theKillId;//被杀死玩家的身份
var theVoteNum;//被投死玩家的编号
var theVoteId;//被投死玩家的身份
$('.day').text('第' + days +'天');
if(days > 1){
    for(var i=1;i < days;i++){
        theKillNum = (beKiller[i-1]).num;
        console.log(theKillNum);
        theKillId = (beKiller[i-1]).id;
        console.log(theKillId);
        theVoteNum = (beVote[i-1]).num;
        console.log(theVoteNum);
        theVoteId = (beVote[i-1]).id;
        console.log(theVoteId);
        var player = JSON.parse(sessionStorage.getItem('player'));
        var inbox = '<div class=\"content1\" >\n' +
            '        <span></span>\n' +
            '        <span class=\"day\">第'+ i + '天</span>\n' +
            '        <span class=\"icon\"></span>\n' +
            '    </div>\n' +
            '    <div class=\"hidden1\">\n' +
            '        <div class=\"bar\">\n' +
            '            <div class=\"circular-first\"></div>\n' +
            '            <div class=\"circular-second1\"></div>\n' +
            '        </div>\n' +
            '        <ul>\n' +
            '            <li>\n' +
            '                <div class=\"triangle1\"></div>\n' +
            '                <span class=\"triangle2\">杀手杀人</span>\n' +
            '            </li>\n' +
            '            <div class=\"box2\">\n' +
            '            <span>' + theKillNum + '号被杀，真实身份是' + theKillId + '</span>\n' +
            '            </div>\n' +
            '        </ul>\n' +
            '        <ul>\n' +
            '            <li>\n' +
            '                <div class=\"triangle1\"></div>\n' +
            '                <span class=\"triangle2\">亡灵发表遗言</span>\n' +
            '            </li>\n' +
            '        </ul>\n' +
            '        <ul>\n' +
            '            <li>\n' +
            '                <div class=\"triangle1\"></div>\n' +
            '                <span class=\"triangle2\">玩家依次发言</span>\n' +
            '            </li>\n' +
            '        </ul>\n' +
            '        <ul>\n' +
            '            <li>\n' +
            '                <div class=\"triangle1\"></div>\n' +
            '                <span class=\"triangle2\">投票</span>\n' +
            '            </li>\n' +
            '        </ul>\n' +
            '            <div class=\"box2\">\n' +
            '            <span>' + theVoteNum + '号被投死，真实身份是' +  theVoteId + '</span>\n' +
            '            </div>\n' +
            '    </div>';
        $('.content').before(inbox);
        $('.hidden1').hide();
    }
}

//控制下拉菜单的显示与隐藏
$('.content1').on('click',function(){
    // $(this).next().toggle("normal");
    var z = $('.content1').index(this);//$(this).index();获取的是与content同级的所有元素的下标，不同的类名但是同级也会获取它的下标，要想获取同级的相同一组类名的下标需要写成$('.content').index(this)，也就是获取到的是content类名同级的元素下标，类名不同不会算在内
    var theHidden = $('.hidden1');
    $(theHidden[z]).slideToggle();
});
$('.content').on('click',function(){
    // $(this).next().toggle("normal");
    var z = $('.content').index(this);//$(this).index();获取的是与content同级的所有元素的下标，不同的类名但是同级也会获取它的下标，要想获取同级的相同一组类名的下标需要写成$('.content').index(this)，也就是获取到的是content类名同级的元素下标，类名不同不会算在内
    var theHidden = $('.hidden');
    $(theHidden[z]).slideToggle();
});
///////////////////////////////////////////////////////////////////////////////////////////////////////

var theStates;//var一个变量来存储当前状态
var aaa = sessionStorage.getItem('sate');//var一个变量来存储从杀人页获取的状态storage的值
if (aaa == null){//假如storage里面是空，就让aaa等于kill
    theStates = 'kill';
}else{//假如storage里面已经有了值，那么就让aaa等于这个值
    theStates = aaa;
}
console.log(theStates);
//杀手杀人跳转
var fsm = {
    state:theStates,
    toKill: function (){
        switch(theStates){
            case'kill':
                console.log(theStates);
                alert('杀手杀人');
                theStates = 'ghost';
                sessionStorage.setItem('sate','ghost');
                location.href = '../html/task2-6.html';
                break;
            case'ghost':
                alert('请按顺序游戏');
                break;
            case'speak':
                alert('请按顺序游戏');
                break;
            case'poll':
                alert('请按顺序游戏');
                break;
        }
    },
    toGhost: function (){
        switch(theStates){
            case'ghost':
                console.log(theStates);
                alert('亡灵发表遗言');
                $('#two1').css('borderRightColor','#82af9a');
                $('#two2').css('backgroundColor','#82af9a');
                theStates = 'speak';
                sessionStorage.setItem('sate','speak');
                console.log(theStates);
                break;
            case'kill':
                alert('请按顺序游戏');
                break;
            case'speak':
                alert('请按顺序游戏');
                break;
            case'poll':
                alert('请按顺序游戏');
                break;
        }
    },
    toSpeak: function (){
        switch(theStates){
            case'kill':
                alert('请按顺序游戏');
                break;
            case'ghost':
                alert('请按顺序游戏');
                break;
            case'speak':
                console.log(theStates);
                alert('玩家依次发言');
                $('#three1').css('borderRightColor','#82af9a');
                $('#three2').css('backgroundColor','#82af9a');
                theStates = 'poll';
                sessionStorage.setItem('sate','poll');
                console.log(theStates);
                break;
            case'poll':
                alert('请按顺序游戏');
                break;
        }
    },
    toPoll: function (){
        switch(theStates){
            case'kill':
                console.log(theStates);
                alert('不要重复点击');
                break;
            case 'ghost':
                alert('不要重复点击');
                break;
            case'speak':
                alert('不要重复点击');
                break;
            case'poll':
                alert('全民投票');
                theStates = 'kill';
                sessionStorage.setItem('sate','kill');
                $('#four1').css('borderRightColor','#82af9a');
                $('#four2').css('backgroundColor','#82af9a');
                location.href = '../html/task2-6.html';
                break;
        }
    }
};
$('.killer').on('click',function(){
    fsm.toKill();
});
$('.die').on('click',function(){
   fsm.toGhost();
});
$('.player').on('click',function(){
    fsm.toSpeak();
});
$('.vote').on('click',function(){
    fsm.toPoll();
});

/////////////////////////////////////////////////////////////////////////////////////////////////////
if(theStates === 'ghost'){
    nowKillNum = (beKiller[days-1]).num;
    console.log( nowKillNum);
    nowKillId = (beKiller[days-1]).id;
    console.log(nowKillId);
    $('#realNum').text(nowKillNum);
    $('#realId').text(nowKillId);
    $('#one1').css('borderRightColor','#82af9a');//控制框变色
    $('#one2').css('backgroundColor','#82af9a');//控制框变色
    $('.box').css('display','block');//显示一段话
    $('.circular-second').css('top','.9rem');//小图标下移
    theStates = 'ghost';
}else if(theStates === 'speak'){
    nowKillNum = (beKiller[days-1]).num;
    console.log( nowKillNum);
    nowKillId = (beKiller[days-1]).id;
    console.log(nowKillId);
    $('#realNum').text(nowKillNum);
    $('#realId').text(nowKillId);
    $('#one1').css('borderRightColor','#82af9a');
    $('#one2').css('backgroundColor','#82af9a');
    $('#two1').css('borderRightColor','#82af9a');
    $('#two2').css('backgroundColor','#82af9a');
    $('.box').css('display','block');//显示一段话
    $('.circular-second').css('top','.9rem');//小图标下移
    theStates = 'speak';
}else if(theStates === 'poll'){
    nowKillNum = (beKiller[days-1]).num;
    console.log( nowKillNum);
    nowKillId = (beKiller[days-1]).id;
    console.log(nowKillId);
    $('#realNum').text(nowKillNum);
    $('#realId').text(nowKillId);
    $('#one1').css('borderRightColor','#82af9a');
    $('#one2').css('backgroundColor','#82af9a');
    $('#two1').css('borderRightColor','#82af9a');
    $('#two2').css('backgroundColor','#82af9a');
    $('#three1').css('borderRightColor','#82af9a');
    $('#three2').css('backgroundColor','#82af9a');
    $('.box').css('display','block');//显示一段话
    $('.circular-second').css('top','.9rem');//小图标下移
    theStates = 'poll';
}

/////////////////////////////////////////////////////////////////////////////////////////////////////
$('.back-arrow').click(function(){
    var i = confirm('确定要返回角色页面吗？');
    if (i === true){
        location.href = '../html/task2-4.html';
    }
});
$('.close').click(function(){
    var i = confirm('确定要返回首页吗？');
    if (i === true){
        sessionStorage.clear();
        location.href = '../html/task2-1.html';
    }
});
$('.ft-left').click(function(){
    var i = confirm('确定要结束游戏么？');
    if(i === true){
        sessionStorage.clear();
        location.href = '../html/task2-1.html';
    }
});
$('.ft-right').click(function(){
    location.href = '../html/task2-7.html';
});