var log = console.log;
$(function () {

    $('backBtn').on('click',function(){
        $(location).attr('href','allot.html');    
    });
    $('.close-icon').on('click',function(){
        var r = confirm("您确定离开游戏吗？");
        if (r == true) {
            window.location.href = "headerPage.html";
        }
               
    })

    var gameMsgstr = sessionStorage.getItem('allMsg');
    var gameMsg = JSON.parse(gameMsgstr);
    var players = gameMsg.players,
        playersBox = $('#gamersVote'),
        btn=$('#btn-skip'),
        str;
        log(gameMsg);
    for (let i = 0; i < players.length; i++) {
        str += `
        <div class="vote-container">
                <div class="gamer">
                    <span class="gamer-id">${players[i].id}</span>
                    <span class="gamer-num">${players[i].index +1}号</span>
                    <div class="gamer-select">
                        <i class="kill"></i>
                    </div>
                 </div>                  
        </div>`
    }
    playersBox.html(str);
    playerId=$('.gamer-id');
    if(gameMsg.goLog){
        for (let i = 0; i < players.length; i++) {
                if(players[i].state ==='dead'){
                   $(playerId[i]).css('background-color','red');
                }
        }
        btn.text('返回');
    }
    btn.on('click',function(){
        $(location).prop('href','judePlay.html');
    });
});