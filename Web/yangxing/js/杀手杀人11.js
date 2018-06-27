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
console.log(deathpeople);
var akiller=JSON.parse(sessionStorage.getItem('akiller'));

var avoter=JSON.parse(sessionStorage.getItem('avoter'));

var death=JSON.parse(sessionStorage.getItem('death'));

//平民人数
people = JSON.parse(sessionStorage.getItem('people'));
//杀手人数
killer = JSON.parse(sessionStorage.getItem('killer'));
//游戏天数
days = JSON.parse(sessionStorage.getItem('days'));


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


    var boxes = [];
    $(document).ready(function () {
        $(".box").push(boxes);
        console.log($('.box').length)
    });


    $(".box").click(function () {
        //点击控件下标
        var o = $(this).index();
        num = o + 1;
        console.log(num);//验证下标序号
        console.log(peoplerelstate[o].id);//验证下标id


        //判断
        //如果是杀手
        if (peoplerelstate[o].id === "杀手") {
            alert('自己人 别杀！');
        } else {
            //如果身份是平民
            if (peoplerelstate[o].id === "平民") {
                //且如果平民状态死亡
                if (peoplerelstate[o].status !== "live") {
                    alert('已经被杀！');
                } else {
                    //或如果平民状态是存在
                    console.log(this);
                    $('.top').removeClass('black2');
                    $(this).find('.top').addClass('black2');
                    sessionStorage.setItem('o', JSON.stringify(o));
                }
            } else {
                //玩家身份是杀手
                alert('自己人 别杀！')
            }
        }
    });


});


function www() {
    var o = JSON.parse(sessionStorage.getItem('o'));
    console.log(o);
    if (o === undefined) {
        alert("最少选择一人")
    } else if (peoplerelstate[o].status === 'die') {
        alert('不要鞭尸！')
    } else {
        alert("确定杀他吗？");
        $('.box').eq(o).addClass('black2');
        peoplerelstate[o].status = 'die';
        peoplerelstate[o].type = 'akiller';
        peoplerelstate[o].days = days;
        days = days;


        if (peoplerelstate[o].id === '平民') {
            deathpeople.push(peoplerelstate[o]);
        } else {
            deathkiller.push(peoplerelstate[o]);
        }

        if(peoplerelstate[o].type==='akiller'){
            akiller.push(peoplerelstate[o]);
        }else {
            avoter.push(peoplerelstate[o]);
        }


        death.push(peoplerelstate[o]);


        sessionStorage.setItem('death',JSON.stringify(death));
        sessionStorage.setItem('akiller',JSON.stringify(akiller));
        sessionStorage.setItem('avoter',JSON.stringify(avoter));
        sessionStorage.setItem('deathpeople', JSON.stringify(deathpeople));
        sessionStorage.setItem('deathkiller', JSON.stringify(deathkiller));
        sessionStorage.setItem('deathnum', JSON.stringify(deathnum));
        sessionStorage.setItem('peoplerelstate', JSON.stringify(peoplerelstate));


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
}

