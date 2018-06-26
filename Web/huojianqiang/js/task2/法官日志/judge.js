var days = sessionStorage.getItem('days');
//点击
var click = 1;
//天数
for(var i = 1; i <= days; i++){
    $('.huge').append('<div class="go"><p class="p-click p-click-1"></p><div class="none"><ul class="ul-1"><li class="li-killer">杀手杀人</li><p class="p-killerdeath"></p></ul><ul class="ul-2"><li class="li-2">亡灵发表遗言</li><li class="li-3">玩家依次发言</li><li class="li-4">投票</li><p class="p-killerdeath-second"></p></ul></div></div>');
    $('.p-click-1').eq(i-1).append('第' + i + "天");
    $('.none').hide();
    $('.none').eq(days-1).show();  
};
var day_1 = JSON.parse(sessionStorage.getItem('day_1'));
//读取几号被杀死，添加

//杀死的号码牌
who = JSON.parse(sessionStorage.getItem('who'));
for(var i = 0; i < day_1; i++){
    $('.p-killerdeath').eq(i).append( who[i].numb + '被杀死，他的真实身份是' + who[i].who);
};
//投票杀人以后，按数量添加号码
var vote = sessionStorage.getItem('vote');
who1 = JSON.parse(sessionStorage.getItem('who1'))
for(var i = 0; i < vote; i++){
    $('.p-killerdeath-second').eq(i).append( who1[i].numb + '被杀死，他的真实身份是' + who1[i].who);
};
for(var i = 1;i < days; i++){
    $('.li-2').eq(i-1).addClass('li-background');
    $('.li-3').eq(i-1).addClass('li-background'); 
    $('.li-4').eq(i-1).addClass('li-background');
};
//点击显现，以及隐藏
$('.p-click').click(function(){
    var ind = $('.p-click').index(this);
    $('.none').eq(ind).toggle();
});
//读取
var obj_1 = JSON.parse(sessionStorage.getItem('obj2'));
$(function(){
    if(JSON.parse(sessionStorage.getItem('judge'))){
        judge = JSON.parse(sessionStorage.getItem('judge'));
    }else{
        judge = 0;
    };
    var people = 0;
    if(JSON.parse(sessionStorage.getItem('day_1'))){
        day_1 = JSON.parse(sessionStorage.getItem('day_1'));
    }else{
        day_1 = 0;
    };
    $('.li-killer').eq(days-1).click(function(){ 
        if(judge == 0){
            judge = 1;
            sessionStorage.setItem('judge',judge);
            ci = -1;
            sessionStorage.setItem('cishu',JSON.stringify(ci)); 
            kil = 0;
            sessionStorage.setItem('killer',JSON.stringify(kil)); 
            people++;
            sessionStorage.setItem('people',JSON.stringify(people));
            day_1++;
            sessionStorage.setItem('day_1',JSON.stringify(day_1));
            window.location.href = "../judge2/judge.html";
        }else{
            alert('按顺序点击');
        };
    });
    //杀手杀人以后，样式保存
    people = JSON.parse(sessionStorage.getItem('people'));
    for(var i = 0; i < people; i++){
        $('.li-killer').eq(i).addClass('li-background');
    };
    $('.li-2').eq(days-1).click(function(){
        if(JSON.parse(sessionStorage.getItem('judge')) == 1){
            judge = 2;
            sessionStorage.setItem('judge',judge);
            alert('请发表遗言');
            $('.li-2').addClass('li-background');
        }else{
            alert('按顺序点击');
        };
    });
    $('.li-3').eq(days-1).click(function(){
        if(JSON.parse(sessionStorage.getItem('judge')) == 2){
            alert('请发言');
        $('.li-3').addClass('li-background');
        judge = 3;
        sessionStorage.setItem('judge',judge);
        }else{
            alert('按顺序点击');
        };
    });
    $('.li-4').eq(days-1).click(function(){
        if(JSON.parse(sessionStorage.getItem('judge')) == 3){
            window.location.href = "../judge2/judge.html";
            // ci = 3;
            // sessionStorage.setItem('cishu',JSON.stringify(ci));
            kil = 1;
            sessionStorage.setItem('killer',JSON.stringify(kil)); 
        }else{
            alert('按顺序点击');
        };
    });
}); 
$('.btn-1').click(function(){
    var x;
    var r = confirm('确认结束游戏吗？');
    if(r == true){
        sessionStorage.clear();
        window.location.href = "../首页/head.html";
    }
})