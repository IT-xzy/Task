var beKiller = JSON.parse(sessionStorage.getItem('beKiller'));//取出被杀数组
console.log(beKiller);
var beVote = JSON.parse(sessionStorage.getItem('beVote'));//取出被投数组
console.log(beVote);
var people = JSON.parse(sessionStorage.getItem('people'));//取出剩余平民数量
console.log(people);
var killer = JSON.parse(sessionStorage.getItem('killer'));//取出剩余杀手数量
console.log(killer);
var days = JSON.parse(sessionStorage.getItem('days'));//取出游戏执行的总天数
console.log(days);
var day = days - 1;
var step = JSON.parse(sessionStorage.getItem('sixStep'));//看是从杀人页胜利过来的还是投票页胜利过来的
console.log(step);
var theKillNum;//被杀死玩家的编号
var theKillId;//被杀死玩家的身份
var theVoteNum;//被投死玩家的编号
var theVoteId;//被投死玩家的身份


if (days > 1){
    if (step === 'vote'){//从投票页赢过来的
        for (var i=1; i<days; i++){
            theKillNum = (beKiller[i-1]).num;
            theKillId = (beKiller[i-1]).id;
            theVoteNum = (beVote[i-1]).num;
            theVoteId = (beVote[i-1]).id;
            var contentBox1 = '<div class=\"content-box\">\n' +
                '        <div class=\"date\">第' + i + '天</div>\n' +
                '        <div class=\"content-content\">晚上：' +  theKillNum + '号被杀手杀死，真实身份是' + theKillId + '</div>\n' +
                '        <div class=\"content-bottom\">白天：' + theVoteNum + '号被全民投票投死，真实身份是' + theVoteId + '</div>\n' +
                '    </div>';
            $('.content').append(contentBox1);
            $('.content-last').hide();
        }
    }else if (step === 'kill'){//从杀人页赢过来的
        for (var a=1; a<days-1; a++){
            theKillNum = (beKiller[a-1]).num;
            theKillId = (beKiller[a-1]).id;
            theVoteNum = (beVote[a-1]).num;
            theVoteId = (beVote[a-1]).id;
            var contentBox2 = '<div class=\"content-box\">\n' +
                '        <div class=\"date\">第' + a + '天</div>\n' +
                '        <div class=\"content-content\">晚上：' +  theKillNum + '号被杀手杀死，真实身份是' + theKillId + '</div>\n' +
                '        <div class=\"content-bottom\">白天：' + theVoteNum + '号被全民投票投死，真实身份是' + theVoteId + '</div>\n' +
                '    </div>';
            $('.content-last').before(contentBox2);
            $('#realDay').text(day);
            $('#realNum').text((beKiller[a].num));
            $('#realId').text((beKiller[a].id));
        }
    }
}



if (killer === 0){
    $('.main-content').text('平民胜利');
}else if (killer === people){
    $('.main-content').text('杀手胜利');
}
$('#endKiller').text(killer);
$('#endPeople').text(people);




$('.back-arrow').click(function(){
    var a = confirm('是否返回首页');
    if (a === true){
        sessionStorage.clear();
        location.href = '../html/task2-1.html';
    }
});
$('.footer-left').click(function(){
    var a = confirm('是否开始新游戏');
    if (a === true){
        sessionStorage.clear();
        location.href = '../html/task2-2.html';
    }
});