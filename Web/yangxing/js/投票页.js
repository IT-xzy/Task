//总玩家状态的信息
var peoplerelstate = JSON.parse(sessionStorage.getItem('peoplerelstate'));
console.log(peoplerelstate);
//玩家总人数
var peoplerel = JSON.parse(sessionStorage.getItem('peoplerel'));
//死亡的玩家总数
var deathnum = JSON.parse(sessionStorage.getItem('deathnum'));
//定义死亡的平民
var deathpeople = JSON.parse(sessionStorage.getItem('deathpeople'));
//定义死亡的杀手
var deathkiller = JSON.parse(sessionStorage.getItem('deathkiller'));
//平民人数
people = JSON.parse(sessionStorage.getItem('people'));
//杀手人数
killer = JSON.parse(sessionStorage.getItem('killer'));
//被杀死的人
var akiller=JSON.parse(sessionStorage.getItem('akiller'));
//被投死的人
var avoter=JSON.parse(sessionStorage.getItem('avoter'));

var death=JSON.parse(sessionStorage.getItem('death'));

//天数days
var days = JSON.parse(sessionStorage.getItem('days'));
console.log(days);


$(document).ready(function () {

    for (var i = 0; i < peoplerel.length; i++) {
        var num = i + 1;
        var tt1 = $('<div></div>').text(peoplerel[i]).addClass('top');
        var tt2 = $('<div></div>').text(num + '号').addClass('mid');
        var tt3 = $('<div></div>').addClass('box');
        if (peoplerelstate[i].status === 'die') {
            $(tt1).removeClass('.top');
            $(tt1).addClass('black');
            console.log(peoplerelstate[i]);
        }
        $('main').append(tt3);
        $(tt3).append(tt1, tt2);
    }


    $('.box').click(function () {
        var m = $(this).index();
        if (peoplerelstate[m].status === 'die') {
            alert("不要鞭尸！");
        } else {
            $('.top').removeClass('black2');
            $(this).find('.top').addClass('black2');
            sessionStorage.setItem('m', JSON.stringify(m));
        }
    });
});


function eee() {
    var m = JSON.parse(sessionStorage.getItem('m'));
    console.log(m);
    alert("确定杀他吗？");
    peoplerelstate[m].status = 'die';
    peoplerelstate[m].type = 'avoter';
    days = days + 1;
    console.log(days);
    peoplerelstate[m].days = days-1;
    console.log(peoplerelstate[m].days+'21212121212');

    if( peoplerelstate[m].id==='平民'){
        deathpeople.push(peoplerelstate[m]);
    }else {
        deathkiller.push(peoplerelstate[m]);
    }

    if(peoplerelstate[m].type==='akiller'){
        akiller.push(peoplerelstate[m]);
    }else {
        avoter.push(peoplerelstate[m]);
    }


    death.push(peoplerelstate[m]);


    sessionStorage.setItem('death',JSON.stringify(death));

    sessionStorage.setItem('akiller',JSON.stringify(akiller));
    sessionStorage.setItem('avoter',JSON.stringify(avoter));
    sessionStorage.setItem('peoplerelstate', JSON.stringify(peoplerelstate));
    sessionStorage.setItem('days', JSON.stringify(days));
    sessionStorage.setItem('deathpeople', JSON.stringify(deathpeople));
    sessionStorage.setItem('deathkiller', JSON.stringify(deathkiller));
    sessionStorage.setItem('deathnum', JSON.stringify(deathnum));

    if (killer - deathkiller.length === 0) {
        alert('平民胜利');
        window.location.href = '游戏结束.html';
    } else if (killer - deathkiller.length >= people - deathpeople.length) {
        alert('杀手胜利');
        window.location.href = '游戏结束.html';
    } else {
        window.location.href = '法官日记.html';

    }


}

