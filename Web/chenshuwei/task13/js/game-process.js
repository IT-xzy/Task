var person=JSON.parse(sessionStorage.getItem('person')),
    day=JSON.parse(sessionStorage.getItem('day')),
    index=JSON.parse(sessionStorage.getItem('index')),
    indexArray=JSON.parse(sessionStorage.getItem('indexArray')),
    num=1,
    $return=$('header').find('a').eq(0),
    $close=$('header').find('a').eq(1),
    step=$(".step"),
    mark;
console.log(mark)
//点击回首页
$return.on('click',function () {
    mark='1';
    sessionStorage.setItem('mark',mark);
    window.location.href='judge-view.html';
});
$close.on('click',function () {
    var $choose=confirm('确定要结束本轮游戏么');
    if($choose===true) {
        sessionStorage.clear();
        window.location.href = 'game-version.html'
    }
});
$('footer a').eq(0).on('click',function () {
    var $choose=confirm('确定要结束本轮游戏么');
    if($choose===true) {
        sessionStorage.clear();
        window.location.href = 'game-version.html'
    }
});
$('footer a').eq(1).on('click',function () {
    mark='1';
    sessionStorage.setItem('mark',mark);
    window.location.href='judge-view.html';
});

//设置状态，每天有4个状态
var fsm=new StateMachine({
    init:'blank',//初始状态为空白
    transitions:[
        {name:'a',from:'blank',to:'killers-action'},
        {name:'b',from:'killers-action',to:'will'},
        {name:'c',from:'will',to:'speech'},
        {name:'d',from:'speech',to:'vote-action'},
        {name:'e',from:'vote-action',to:'judge'},
        {name: 'goto', from: '*', to: function(s) { return s }}
    ],
    methods:{
        onA:function() {
            }
    }
});
//当天数增加时，记录之前发生的事，并放在所在的天数下，隐藏
for(i=1;i<day;i++){
    $('.first-day').eq(0).clone().insertAfter($('.first-day').eq(i-1));
    $('.first-day').eq(i).html('<h4>第'+(i+1)+'天</h4>');
    $('<p>白天'+indexArray[i*2-1]+'号死亡，死者身份为'+person[indexArray[i*2-1]-1].name+'</p>').insertAfter($('.first-day').eq(i-1));
    $('<p>夜晚'+indexArray[i*2-2]+'号死亡，死者身份为'+person[indexArray[i*2-2]-1].name+'</p>').insertAfter($('.first-day').eq(i-1));
    $('.first-day').eq(i-1).nextAll('p').css({'display':'none'})
    $('.first-day').eq(i-1).css({'border-top':'1px solid #c9c9c9'})
};
//点击时，显示此天发生的内容
$('.first-day').click(function () {
    $(this).nextUntil('.first-day').slideToggle('fast')
});
//
if(sessionStorage.getItem('state')!==null){
    fsm.goto(sessionStorage.getItem('state'));
    $('<p>昨晚'+(index+1)+'号死亡，死者身份为'+person[index].name+'</p>').insertAfter($('.step').eq(0));
}
switch (fsm.state){
    case 'killers-action':
        step[0].style.background="#09586b";
        break;
    case 'will':
        step[0].style.background="#09586b";
        step[1].style.background="#09586b";
        break;
    case 'speech':
        step[0].style.background="#09586b";
        step[1].style.background="#09586b";
        step[2].style.background="#09586b";
        break;
    case 'vote-action':
        step[0].style.background="#09586b";
        step[1].style.background="#09586b";
        step[2].style.background="#09586b";
        step[3].style.background="#09586b";
        break;
}
$('.step').eq(0).click(function () {
    if(fsm.state=='blank') {
        fsm.a();
        sessionStorage.setItem('judge-state','kill');
        $(this).css('background','#09586b');
        window.location.href='judge-view.html';
    }
    else {
     alert('请按循序游戏');
    }
});
$('.step').eq(1).click(function () {
    if(fsm.state=='killers-action') {
        fsm.b();
        sessionStorage.setItem('state',fsm.state);
        $(this).css('background','#09586b');
        alert('请死者发言');
    }
    else {
        alert('请按循序游戏');
    }
});
$('.step').eq(2).click(function () {
    if(fsm.state=='will') {
        fsm.c();
        sessionStorage.setItem('state',fsm.state)
        $(this).css('background','#09586b');
        alert('所有人发言')
    }
    else {
        alert('请按循序游戏')
    }
});
$('.step').eq(3).click(function () {
    if(fsm.state=='speech') {
        sessionStorage.setItem('judge-state','vote');
        $(this).css('background','#09586b');
        window.location.href='judge-view.html';
    }
    else {
        alert('请按循序游戏');
    }
});
console.log(sessionStorage.getItem('state'));
console.log(fsm.state);



