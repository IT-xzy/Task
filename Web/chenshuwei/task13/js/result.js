var person=JSON.parse(sessionStorage.getItem('person')),
    day=JSON.parse(sessionStorage.getItem('day')),
    index=JSON.parse(sessionStorage.getItem('index')),
    indexArray=JSON.parse(sessionStorage.getItem('indexArray'));
console.log(indexArray)
for(i=1;i<=day;i++) {
    $('main').append(
        "<div class=\"game-daily\">\n" +
        "        <div class=\"date\">\n" +
        "            第" + i + "天<span class=\"time\">0小时07分</span>\n" +
        "        </div>\n" +
        "        <p>晚上："+indexArray[i*2-2]+"号被杀手杀死，死者身份是"+person[indexArray[i*2-2]-1].name+"</p>\n" +
        "        <p>白天："+indexArray[i*2-1]+"号被全民投死，死者身份是"+person[indexArray[i*2-1]-1].name+"</p>\n" +
        "    </div>")
};
//点击放回首页
$('.another-game').click(function () {
    sessionStorage.clear()
    window.location.href='game-version.html'
});
$('header').find('a').eq(0).on('click',function () {
    sessionStorage.clear()
    window.location.href='game-version.html'
});
var killerAlive=0,
    civilianAlive=0;
for(i=0;i<person.length;i++){
    if(person[i].name=='杀手'&&person[i].state=='live'){
        killerAlive++
    }
    else if (person[i].name=='平民'&&person[i].state=='live'){
        civilianAlive++
    }
};
if(killerAlive>0) {
    $('.victory-img-area').append('<h3>杀手胜利</h3>')
}
else {
    $('.victory-img-area').append('<h3>平民胜利</h3>')
};
$(".text-area").append(
    '<p>剩余:</p>\n' +
    '            <p>\n' +
    '                <span>杀手'+killerAlive+'人</span>\n' +
    '                <span>平民'+civilianAlive+'人</span>\n' +
    '            </p>'
    );
$('footer a').eq(0).on('click',function () {
    sessionStorage.clear();
    window.location.href='setting.html'
});
$('.home').on('click',function () {
    sessionStorage.clear();
    window.location.href='setting.html'
});