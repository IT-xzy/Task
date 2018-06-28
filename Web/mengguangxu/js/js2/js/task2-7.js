var playerStates = JSON.parse(sessionStorage.getItem('playerStates'));//取出玩家的状态：身份、生死、编号
console.log(playerStates);
var player = JSON.parse(sessionStorage.getItem('player'));//取出总玩家人数数组
console.log(player);


for (var i = 0; i < player.length; i++) {//遍历数组，有几个玩家就循环几次，把所有玩家都遍历出来
    var num = i + 1;//每个角色对应的号码
    var inBox = '<div class=\"content-box\">\n' +//var个变量存储写进文档的标签代码，记住要转义字符
        '<div class=\"content-top\">\n' +
        '<div class=\"career\">\n' + player[i] +
        '</div>\n' +
        '<div class=\"number\">\n' + num +
        '</div>\n' +
        '</div>\n' +
        '<div class=\"content-bottom\">\n' +
        '</div>\n' +
        '</div>';
    $('.main-box').append(inBox);//通过append将盒子一个一个的往文档里面装
    theStatus = (playerStates[i].state);//根据上面的遍历，遍历出每一个角色的状态，用theStatus来储存，假如遍历到的这个角色状态是死，则这个角色的颜色改变
    console.log(theStatus);
    if (theStatus === 'death'){
        $('.career').eq(i).css('backgroundColor','#83B09A');
    }else if (theStatus === 'live'){
        $('.career').eq(i).css('backgroundColor','#f9b247');
    }
}



$('.back-arrow').click(function () {
    var i = confirm('确定要返回角色页面吗？');
    if (i === true) {
        location.href = '../html/task2-3.html';
    }
});
$('.close').click(function () {
    var i = confirm('确定要返回首页吗？');
    if (i === true) {
        sessionStorage.clear();
        location.href = '../html/task2-1.html';
    }
});
$('#bt').click(function(){
    location.href = '../html/task2-5.html';
});