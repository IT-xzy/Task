var log = console.log;
// // 定义所有初始化变量



var gameMsgstr = sessionStorage.getItem('allMsg');
var initialMsg = JSON.parse(gameMsgstr);

//变量的解构赋值
let {
    dayNum: days,
    state,
    players,
    step,
    killed,
    voted,
    allDead
} = initialMsg;


var gamersVote = $('#gamersVote'), //游戏容器
    pageTitle = $('#result'), //页面标题
    speak = $('#speak'), //大标题
    smallTitle = $('.v-title'), //小标题
    close = $('#closeBtn'), //关闭按钮
    skip = $('#btn-skip'), //跳转按钮
    titleContainer = $('.audio-container');


let str;

for (let i = 0; i < players.length; i++) {
    str += `
        <div class="vote-container">
                <div class="gamer">
                    <span class="gamer-id" state="alive">${players[i].id}</span>
                    <span class="gamer-num">${players[i].index +1}号</span>
                    <div class="gamer-select">
                        <i class="kill"></i>
                    </div>
                </div>                  
        </div>`
}
gamersVote.html(str);
//循环出已死的玩家
let gamerId = $('.gamer-id');
for (let i = 0; i < players.length; i++) {
        //判断玩家状态是否死亡
        if(players[i].state ==='dead'){
            $(gamerId[players[i].index]).attr('state', 'dead');
            $(gamerId[players[i].index]).css('background-color', 'red');
    }
 }



if (state == 'kill') {
    pageTitle.text('杀手杀人');
    speak.text('杀手请睁眼，杀手请选择要杀的对象');
    smallTitle.text('点击下方玩家头像，对被杀的玩家的进行标记');
    skip.text('确定');
}

if (state == 'vote') {
    pageTitle.text('投票');
    speak.text('发言讨论结束，大家请投票');
    smallTitle.text('点击得票数最多的人头像');
    skip.text('投死');

}





$('.vote-container').on('click', function (e) {
    //背景变色
    //保证已经死亡的人不变色
    for(let i=0;i<gamerId.length;i++){
        if($(gamerId[i]).attr('state') ==='alive'){
            $(gamerId[i]).css('background-color', '#f5c97b');
        }
    }

    $(this).find('.gamer-id').css('background-color', 'red');
    // if()
    //小刀图标显现和消失
    $('.gamer-select').hide();
    $(this).find('.gamer-select').show();
    //杀手杀人
    if (state == 'kill') {
       killed[0] = $(this).index();
        
    }
    //投票
    if (state == 'vote') {
        killed[0] = $(this).index();    
    }

});
skip.on('click', function () {
    var index =killed[0] ;
    //判断有没有杀人
    if(killed.length){
        if( players[index].state =='dead'){
            alert('此玩家已死,请选择别的玩家');
            return ;
        }   
    }
    //杀手杀人
    if (state == 'kill' ) {
        //判断是否杀人
        if(!killed.length){
            alert('杀手必须杀人');
            return ;
        }
        //杀手不能杀自己
        if(players[index].id == '杀手'){
                alert('杀手不能杀自己人');
                return ;
        }
        //成功后存储数据跳转页面
        players[index].deadReason="killed";
        initialMsg.popsNum--;
          
    }  else if (state == 'vote') {
        //判断投票,本轮必须投票
        if(!killed.length){
            alert('本轮必须投票');
            return ;
        }
        //判断身份
        if(players[index].id== '杀手'){
            initialMsg.killersNum--;

        }else{
            initialMsg.popsNum--;        
        }
        //天数加一
        initialMsg.dayNum++; 
        players[index].deadReason="voted";
    }
    // log('平民人数：', initialMsg.popsNum,'杀手人数：',initialMsg.killersNum)
    // alert(1);
    killed.length=0;
    players[index].state = 'dead';
    players[index].deadDay=days;

    if(initialMsg.killersNum ==0){
        //平民胜利
        initialMsg.result='popWin';
        sessionStorage.setItem('allMsg', JSON.stringify(initialMsg));
        alert('游戏结束，平民胜利');
        $(location).attr('href','result-1.html');
        return ;
    }else if(initialMsg.killersNum >=initialMsg.popsNum){
        //杀手胜利
        initialMsg.result='killWin';        
        sessionStorage.setItem('allMsg', JSON.stringify(initialMsg));        
        alert('游戏结束，杀手胜利');        
        $(location).attr('href','result-1.html');        
        return ;        
    }
    sessionStorage.setItem('allMsg', JSON.stringify(initialMsg));            
    location.href='judePlay.html';
});






































































//关闭页面
close.on('click', function () {
    var r = confirm("您确定离开游戏吗？");
    if (r == true) {
        window.location.href = "headerPage.html";
    }
});