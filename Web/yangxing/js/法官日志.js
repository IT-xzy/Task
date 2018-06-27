$(document).ready(function () {
    //取上一个页面保存的玩家分配信息
    var peoplerel = JSON.parse(sessionStorage.getItem("peoplerel"));
    console.log(peoplerel);

    people = JSON.parse(sessionStorage.getItem('people'));
    killer = JSON.parse(sessionStorage.getItem('killer'));


    days = 1;//初始化游戏天数
    akiller = [];//存放被杀玩家
    avoter = [];//存放被投票玩家
    deathnum = [];//玩家死亡数
    deathpeople = [];//死亡平民
    deathkiller = [];//死亡杀手
    move = 'none';
    death = [];//死亡总人

    console.log(move);
    sessionStorage.setItem('death', JSON.stringify(death));
    sessionStorage.setItem('days', JSON.stringify(days));
    sessionStorage.setItem('akiller', JSON.stringify(akiller));
    sessionStorage.setItem('avoter', JSON.stringify(avoter));
    sessionStorage.setItem('deathnum', JSON.stringify(deathnum));
    sessionStorage.setItem('deathpeople', JSON.stringify(deathpeople));
    sessionStorage.setItem('deathkiller', JSON.stringify(deathkiller));
    sessionStorage.setItem('people', JSON.stringify(people));
    sessionStorage.setItem('killer', JSON.stringify(killer));
    sessionStorage.setItem("move", move);
    window.onload = function () {
        for (var i = 0; i < peoplerel.length; i++) {
            var num = i + 1;
            var tt1 = $('<div></div>').text(peoplerel[i]).addClass('top');
            var tt2 = $('<div></div>').text(num + '号').addClass('mid');
            var tt3 = $('<div></div>').addClass('box');
            $('main').append(tt3);
            $(tt3).append(tt1, tt2);


        }
    };
    var peoplerelstate = [];//所有玩家的状态
    for (var a = 0; a < peoplerel.length; a++) {
        peoplerelstate[a] = {};
        peoplerelstate[a].id = peoplerel[a];
        peoplerelstate[a].status = 'live';
        peoplerelstate[a].num = a + 1;
        peoplerelstate[a].days = days;
        peoplerelstate[a].type = 'none';
    }

    $('#start').click(function () {
        window.sessionStorage.setItem('peoplerelstate', JSON.stringify(peoplerelstate));
        window.sessionStorage.setItem('peoplerel', JSON.stringify(peoplerel));
        window.sessionStorage.setItem('deathnum', JSON.stringify(deathnum));
        window.location.href = '法官日记.html';
    });

});

