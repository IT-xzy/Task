let playerTotalNum = JSON.parse(sessionStorage.getItem('playerNum')),
    killerNum = Math.floor(playerTotalNum.length/3),
    civilNum = Math.ceil(playerTotalNum.length*2/3),
    main = $('#main'),
    confirmBtn = $('#confirm'),
    closePage = $('#closePage'),
    eyesOrVote =$('#eyesOrVote'),
    title = $('#title'),
    selectSb = $('#selectSb'),
    playerStatus = [],
    arrOfkilled = [],
    arrOfVoted = [],
    noneOp = [],
    selected = 0,
    index,
    murderOrVote = sessionStorage.getItem('murderOrVote'),
    statusAfMurOrVo = JSON.parse(sessionStorage.getItem('statusAfMurOrVo'));
// let oriPlayerTotalNum = sessionStorage.getItem('playerNum');
// let playerTotalNum = oriPlayerTotalNum.split(',');
// console.log(playerTotalNum);//使用split将字符串分割为数组

for (i = 0 ; i < playerTotalNum.length ; i++) {
let playerId = $('<div></div>')
    .text(playerTotalNum[i])
    .addClass('player_box')
    ;//创建大格子，依附内容，依附样式
let knife = $('<div></div>')
    .addClass('knife')
    ;//创建刀子，依附样式
let playerNum = $('<div></div>')
    .text(i+1 + "号")
    .addClass('player_num')
    ;//创建小格子，序号，依附样式
playerId.append(knife)
    ;//将刀子依附到大格子上
playerId.append(playerNum)
    ;//将小格子依附到大格子上
main.append(playerId)
    ;//将大格子依附到格子容器中
playerStatus[i] = {
    role: playerTotalNum[i],
    status : 'live',
    num : i+1 }//创建玩家状态.
    }//动态的将获取到的数组变成页面上的玩家数量



let playerId = $('.player_box')
    ;//获取所有的大格子
let playerNum = $('.player_num')
    ;//获取所有的序号
let knife = $('.knife')
    ;//获取所有的刀子
knife.hide()
    ;//隐藏所有的刀子
playerId.click(function () {
    $(this).find(knife).show()
    ;//show当前大格子内部的刀子
    $(this).siblings().find(knife).hide()
    ;//隐藏所有兄弟格子内部的刀子
    index = playerId.index(this);//存储当前点击的下标
    selected = 1;//被选中的角色加个标记
});//在main之下获取所有的大格子，并绑定大格子事件


if (murderOrVote == 'murder'){
    if  (JSON.parse(sessionStorage.getItem('afKillPush'))){
    playerStatus = JSON.parse(sessionStorage.getItem('playerStatusAfCli'))
    ;
    arrOfkilled = JSON.parse(sessionStorage.getItem('afKillPush'))
    ;
    arrOfVoted = JSON.parse(sessionStorage.getItem('afVotePush'))
    ;
    noneOp = JSON.parse(sessionStorage.getItem('noneOper'))
    ;
    if (sessionStorage.getItem('civilNum')){
            civilNum = sessionStorage.getItem('civilNum');
    }
    if (sessionStorage.getItem('killerNum')){
            killerNum = sessionStorage.getItem('killerNum');
    }
    for (i = 0 ; i < arrOfVoted.length ; i++){
            $(playerId[arrOfVoted[i]]).css('background-color','#83b09a')
            ;
            $(playerNum[arrOfVoted[i]]).css('width','78px')
            ;
        }
    }
    for (i = 0 ; i < arrOfkilled.length ; i++){
        $(playerId[arrOfkilled[i]]).css('background-color','#83b09a')
        ;
        $(playerNum[arrOfkilled[i]]).css('width','78px')
        ;
    }
confirmBtn.click(function() {
    if (selected === 1) {
        if (playerStatus[index].status == 'killed'){
            confirm('不能鞭尸')
        }
    else if (playerStatus[index].role == '杀手'){
        confirm('自己人')
    }
    else /*if (selected === 1) */{
            let kill = confirm("确定要杀掉他吗？");
            if (kill === true){
                civilNum--;
                arrOfkilled.push(index);
                if (civilNum < 1){
                    alert('杀手胜利');
                    window.location.href = '../gameOver/gameOver.html';

                }
                else if (killerNum < 1){
                    alert('水民胜利');
                    window.location.href = '../gameOver/gameOver.html';
                }
                else {
                playerStatus[index].status = 'killed';
                window.location.href = "../firstDay/firstDay.html";
                }
                sessionStorage.setItem('afKillPush',JSON.stringify(arrOfkilled));
            }}}
    else if (selected === 0 ){
        alert('请选择要操作的玩家')
    }
    sessionStorage.setItem('civilNum',civilNum);
    sessionStorage.setItem('playerStatusAfCli',JSON.stringify(playerStatus));
});}



if (murderOrVote == 'dairy'){
    title.text('法官日志')
    ;
    eyesOrVote.remove()
    ;
    $('.openeyes').remove()
    ;
    $('.header').css('margin-bottom','0')
    ;
    confirmBtn.click(function () {
        window.location.href = '../firstDay/firstDay.html';
    });
    arrOfkilled = JSON.parse(sessionStorage.getItem('afKillPush'))
    ;
    playerStatus = JSON.parse(sessionStorage.getItem('playerStatusAfCli'))
    ;
    arrOfVoted = JSON.parse(sessionStorage.getItem('afVotePush'))
    ;
    for (i = 0 ; i < arrOfkilled.length ; i++){
        $(playerId[arrOfkilled[i]]).css('background-color','#83b09a')
        ;
        $(playerNum[arrOfkilled[i]]).css('width','78px')
        ;
    }
    if  (JSON.parse(sessionStorage.getItem('afVotePush'))){
    for (i = 0 ; i < arrOfVoted.length ; i++){
        $(playerId[arrOfVoted[i]]).css('background-color','#83b09a')
        ;
        $(playerNum[arrOfVoted[i]]).css('width','78px')
        ;
    }}
}

if(murderOrVote == 'vote'){
    eyesOrVote.text('发言结束，请大家投票')
    ;
    title.text('投票')
    ;
    selectSb.text('点击得票数最多的人的头像')
    ;//修改样式
    arrOfkilled = JSON.parse(sessionStorage.getItem('afKillPush'))
    ;
    playerStatus = JSON.parse(sessionStorage.getItem('playerStatusAfCli'))
    ;
    civilNum = sessionStorage.getItem('civilNum');
    if  (JSON.parse(sessionStorage.getItem('afVotePush'))){
    arrOfVoted = JSON.parse(sessionStorage.getItem('afVotePush'));
    }
    if (sessionStorage.getItem('killerNum')){
        killerNum = sessionStorage.getItem('killerNum');
    }
    if (sessionStorage.getItem('civilNum')){
        civilNum = sessionStorage.getItem('civilNum');
    }
    for (i = 0 ; i < arrOfkilled.length ; i++){
        $(playerId[arrOfkilled[i]]).css('background-color','#83b09a')
        ;
        $(playerNum[arrOfkilled[i]]).css('width','78px')
        ;
    }
    for (i = 0 ; i < arrOfVoted.length ; i++){
        $(playerId[arrOfVoted[i]]).css('background-color','#83b09a')
        ;
        $(playerNum[arrOfVoted[i]]).css('width','78px')
        ;
    }
    confirmBtn.click(function(){
        if (playerStatus[index].status == 'killed'){
                confirm('不能鞭尸')
            }
        else if (selected === 1){
            if (playerStatus[index].role == '平民') {
                civilNum--;
            }
            else if (playerStatus[index].role == '杀手') {
                killerNum--;
            }
            arrOfVoted.push(index);
            if (civilNum < 1){
                alert('杀手胜利');
                window.location.href = '../gameOver/gameOver.html';
            }
            else if (killerNum < 1){
                alert('水民胜利');
                window.location.href = '../gameOver/gameOver.html';
            }
            else {
            playerStatus[index].status = 'killed';
            window.location.href = "../firstDay/firstDay.html";
            }}
        else if (selected == 0) {
            confirm('请选择要操作的玩家');
        }
        sessionStorage.setItem('civilNum',civilNum);
        sessionStorage.setItem('killerNum',killerNum);
        sessionStorage.setItem('role',playerStatus[index].role);
        sessionStorage.setItem('playerStatusAfCli',JSON.stringify(playerStatus));
        sessionStorage.setItem('afVotePush',JSON.stringify(arrOfVoted));
});}

closePage.click(function(){
    let a = confirm('结束本轮游戏游戏吗？');
    if (a === true){
        sessionStorage.clear();
        window.location.href = "../playerdistribution/playerDis.html"}
});