var win = sessionStorage.getItem('win');
//胜利方
$('.p-killer').append(win);
//添加天数
//读取天数
var days = sessionStorage.getItem('days');
//读取杀手杀死人数
var who = JSON.parse(sessionStorage.getItem('who'));
//读取投票投死
var who1 = JSON.parse(sessionStorage.getItem('who1'));
// console.log(who1)
//平民数量
var people = 0;
$.each(who,function(i){
    if(who[i].who == '平民'){
        people++;
    }
});
$.each(who1,function(i){
    if(who1[i].who == '平民'){
        people++;
    }
})
//杀手数量
var killer = 0;
$.each(who1,function(i){
    if(who1[i].who == '杀手'){
        killer++;
    }
})
console.log(people);
$('main').append('<p class="p-3"></p><p class="p-4"></p>')
$('.p-3').append('平民 : ' + people + '  人');
$('.p-4').append('杀手 : ' + killer + '  人');
//循环天数
for(var i = 0; i < days; i++){
    var day = i+1;
    $('footer').append('<div class="wihte"><p class="p-footer"></p><p class="p-footer-1"></p><p class="p-footer-2"></p></div>');
    $('.p-footer').eq(i).append('第' + day + '天');
    $('.p-footer-1').eq(i).append('晚天: ' + who[i].numb + '号被杀死，他的身份是' + who[i].who);
    $('.p-footer-2').eq(i).append('白上: ' + who1[i].numb + '号被杀死，他的身份是' + who1[i].who);
}
$('.btn-1').click(function(){
    var x;
    var r = confirm('确认结束游戏吗？');
    if(r == true){
        sessionStorage.clear();
        window.location.href = "../首页/head.html";
        // sessionStorage.removeItem("key");
        // sessionStorage.removeItem("obj");
        // sessionStorage.removeItem("days");
        // sessionStorage.removeItem("judge");
        // sessionStorage.removeItem("cishu");
        // sessionStorage.removeItem("killer");
        // sessionStorage.removeItem("people");
        // sessionStorage.removeItem("day_1");
        // sessionStorage.removeItem("who");
        // sessionStorage.removeItem("vote");
        // sessionStorage.removeItem("who1");
        // sessionStorage.removeItem("win");
        
    }
})