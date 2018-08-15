var people = JSON.parse(sessionStorage.getItem('people'));

var killer = JSON.parse(sessionStorage.getItem('killer'));

var days = JSON.parse(sessionStorage.getItem('days'));

var peoplerelstate = JSON.parse(sessionStorage.getItem('peoplerelstate'));


var death = JSON.parse(sessionStorage.getItem('death'));
//被杀死的玩家
var akiller = JSON.parse(sessionStorage.getItem('akiller'));
//被投死的玩家
var avoter = JSON.parse(sessionStorage.getItem('avoter'));

deathpeople = JSON.parse(sessionStorage.getItem('deathpeople'));
deathkiller = JSON.parse(sessionStorage.getItem('deathkiller'));
var deathnum = JSON.parse(sessionStorage.getItem('deathnum'));

$(document).ready(function () {

    $('.news').append('平民' + people + '人' + '杀手' + killer + '人');

    var content = [];
    if (peoplerelstate.length % 2===1) {
        console.log(peoplerelstate.length % 2);
        for (h = 0; h < days; h++) {
            content.push(
                '<div class="border">' +
                '<div class="table">' +
                '<div class="top">' +
                '<p style="color:black; font-size:30px;" class="time">第' + (h+1) + '天</p>' +
                '<p style="float:right">0小时07分</p>' +
                '</div>' +
                '<br>' +
                '<p class="akiller"></p>' +
                '<p class="avoter"></p>' +
                '</div>' +
                '</div>'
            );
        }
    }else if(peoplerelstate.length % 2===0){
        console.log(peoplerelstate.length % 2);
        for (k = 1; k < days; k++) {
            content.push(
                '<div class="border">' +
                '<div class="table">' +
                '<div class="top">' +
                '<p style="color:black; font-size:30px;" class="time">第' + (k) + '天</p>' +
                '<p style="float:right">0小时07分</p>' +
                '</div>' +
                '<br>' +
                '<p class="akiller"></p>' +
                '<p class="avoter"></p>' +
                '</div>' +
                '</div>'
            );
        }
    }
    $('footer').html(content.join(''));


    for (var p = 0; p < days; p++) {
        if (akiller.length !== 0) {
            if (akiller[p]) {
                console.log(p);
                $('.akiller').eq(p).text('昨夜' + akiller[p].num + '号被杀死,' + '身份是' + akiller[p].id);
            }
        }
        if (avoter.length !== 0) {
            if (avoter[p]) {
                console.log(p);
                $('.avoter').eq(p).text('昨夜' + (avoter[p].num) + '号被投死,' + '身份是' + (avoter[p].id));
            }
        }
    }

    //
    //  for (k = 0; k < death.length; k++) {
    //
    //      if (death[k].type === 'akiller') {
    //       console.log(death[k]);
    // if(death.length%2+1==true){
    //
    //     $('.akiller').eq(k).text('昨夜' + death[k].num + '号被杀死,' + '身份是' + death[k].id);
    // }
    // } else if (death[k].type === 'avoter'){
    //          console.log(death[k]);
    //          $('.avoter').eq(k).text('昨夜' + death[k].num + '号被投死,' + '身份是' + death[k].id);
    //      }
    //  }


});