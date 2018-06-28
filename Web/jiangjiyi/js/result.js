var state=JSON.parse(sessionStorage.getItem('statu'));
for(i=1;i<state.day;i++) {
    $('main').append(
        "<div class=\"game-daily\">\n" +
        "        <div class=\"date\">\n" +
        "            第" + i + "天<span class=\"time\">0小时07分</span>\n" +
        "        </div>\n" +
        "        <p>晚上："+state.bekill[i-1].num+"号被杀手杀死，死者身份是"+state.bekill[i-1].name+"</p>\n" +
        "        <p>白天："+ state.bevote[i-1].num +"号被全民投死，死者身份是"+state.bevote[i-1].name+"</p>\n" +
        "    </div>")
};
//点击放回首页
function closeGame() {
    sessionStorage.clear();
    window.location.href='task2.html'
}
$('.another-game').on('click',closeGame)
$('header').find('a').eq(0).on('click',function () {
    sessionStorage.clear()
    window.location.href='task2.html'
});

$('.victory-img-area').append('<h3>'+state.win+'</h3>');

$('footer a').eq(0).on('click',function () {
    sessionStorage.clear();
    window.location.href='task2-licens.html'
});
$('.home').on('click',function () {
    sessionStorage.clear();
    window.location.href='task2-licens.html'
});