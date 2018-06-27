entrance = JSON.parse(sessionStorage.getItem('dog'));

var day = JSON.parse(sessionStorage.getItem('sky'));
console.log(day);

var p = JSON.parse(sessionStorage.getItem('subscript'));

var q = JSON.parse(sessionStorage.getItem('subscript4-4'));
var e=entrance.filter(function (item) {
    return(item.identity==='杀手')
});
var t=entrance.filter(function (item) {
    return(item.identity==='平民')
});
$('.civilian').html(t.length);
$('.killer').html(e.length);

var fate=new Array;
for( v=0;v<day-1;v++){
    fate.push(
        '<div class="diyitian">'+
        '<div>'+'第'+
        '<span class="day">'+
        (v+1)+'</span>'+'天'+'</div>'+
    '<div></div>'+
    '<div class="shijian">'+'0小时07分'+'</div>'+
    '</div>'+
    '<div class="wanshang">'+
        '<p class="daytime"></p>'+
        '<p class="night"></p>'+
        '</div>');
    $('main').html(fate).eq(v);
    console.log(fate);
    var t = entrance.filter(function (item) {
        return (item.alive === 'die' && item.death === 'killed')
    });
    var z = entrance.filter(function (item) {
        return (item.alive === 'die' && item.death === 'cast')
    });
    for (i = 0; i < t.length; i++) {
        $('.daytime').eq(i).text(t[i].number + '号玩家被杀死了,' + '他的身份是' + entrance[p].identity)
    }
    for (i = 0; i < z.length; i++) {
        $('.night').eq(i).text(z[i].number + '号玩家被投死了,' + '他的身份是' + entrance[q].identity)
    }
}
$('.diyige').bind('click',function () {
    sessionStorage.clear();
    window.location.href='JS2-4/JS2.html'
})
