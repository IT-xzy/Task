let playerStatusAfCli = JSON.parse(sessionStorage.getItem('playerStatusAfCli')),
    role = sessionStorage.getItem('role'),
    arrOfkilled = JSON.parse(sessionStorage.getItem('afKillPush')),
    arrOfVoted = JSON.parse(sessionStorage.getItem('afVotePush')),
    civilNum = sessionStorage.getItem('civilNum'),
    killerNum = sessionStorage.getItem('killerNum'),
    lastKil = $('#lastKil'),
    lastCil = $('#lastCil'),
    footer = $('#footer'),
    gameResult = $('#gameResult');
    days = sessionStorage.getItem('afterVoteDays'),
    replay = $('#replay');

lastKil.text('杀手' + killerNum + '人');
lastCil.text('平民' + civilNum + '人');

if  (killerNum > civilNum){
    gameResult.text('杀手胜利');
}
else {
    gameResult.text('平民胜利')
}

replay.click(function(){
    sessionStorage.clear();
    window.location.href='../playerdistribution/playerDis.html';
});


// for (i = 0; i <= days; i++){
// footer.before($('\t<div class="gameprocess">\n' +
//     '\t\t<div class="firstday">第' +  (i+1)  +' 天</div>\n' +
//     '\t\t<span>黑夜：' + (parseInt(arrOfkilled[i])+1) +'号被杀手杀死,真实身份是水民' + '</span>\n' +
//     '\t\t<span>白天： ' + (parseInt(arrOfVoted[i])+1) + '号被投死了。真实身份是' + playerStatusAfCli[arrOfVoted[i]].role + '</span>\n' +
//     '\t</div>'));
// }

for (i = 0; i <= days; i++){
    bigBox = $('<div></div>')
                    .addClass('gameprocess')
    ;
    dayNum = $('<div></div>')
                    .addClass('firstday')
                    .text('第' +  (i+1)  + '天' )
    ;
    footer.before(bigBox)
    ;
    if (parseInt(arrOfkilled[i])+1) {
    bigBox.append(dayNum)
        ;
    killNight = $('<span></span>')
        .text('黑夜：' + (parseInt(arrOfkilled[i])+1) +'号被杀手杀死,真实身份是平民')
    ;
    bigBox.append(killNight)
    ;}
    if (playerStatusAfCli[arrOfVoted[i]]){
    voteDay =  $('<span></span>')
        .text('白天：' + (parseInt(arrOfVoted[i])+1) + '号被投死了。真实身份是' + playerStatusAfCli[arrOfVoted[i]].role)
    ;
    bigBox.append(voteDay)
    ;}
}

