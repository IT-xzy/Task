var player = JSON.parse(localStorage.getItem('object'));
console.log(player);
var url = location.search,
    str = url.substr(1);
console.log(str);
var killerNum = Number(sessionStorage.getItem('killerNum'));
var manNum = Number(sessionStorage.getItem('manNum'));
console.log(killerNum);
console.log(manNum);
$('body').css('backgroundColor', '#29bde0');
var day = Number(sessionStorage.getItem('day'));
console.log('共'+day+'天')
var a = document.getElementsByClassName('win');
var b = document.getElementsByClassName('header-div2');
$('#normal')[0].innerHTML = '平民' +manNum + '人';
$('#killerMan')[0].innerHTML = '杀手' + killerNum + '人';
if(str === 'peopleWin') {
    a[0].innerHTML = "平民胜利";
    b[0].innerHTML = "太棒了！你知道么？在杀人游戏中只有20%的平民取得了游戏最终的胜利哦！";
}
for(var i = 0; i < day ; i ++) {
    var c =
        '<div class="ul2">' +
        '<div class="li1"></div>' +
        '<div class="li2">黑夜：杀手信了佛</div>' +
        '<div class="li3"></div>' +
        '</div>';
    $('#ul1').append(c);
    var d = document.getElementsByClassName('ul2');
    var e = document.getElementsByClassName('li1');
    var f = document.getElementsByClassName('li2');
    var g = document.getElementsByClassName('li3');
    e[i].innerHTML = '第' + Number(i+1) + '天';
    for(var j = 0 ; j < player.length; j ++){
        if(i+1 === player[j].deathDay && player[j].dead === 'kill'){
            f[i].innerHTML = '黑夜:' + Number(player[j].num + 1) + '号被杀死了,真实身份是' + player[j].name
        }else if(i+1 === player[j].deathDay && player[j].dead === 'vote'){
            g[i].innerHTML ='白天:' + Number(player[j].num + 1) + '号被投死了,真实身份是' + player[j].name
        }
    }

}
if(str === 'killerWin'){
    a[0].innerHTML = "杀手胜利";
    b[0].innerHTML = "太棒了！你知道么？在杀人游戏中只有20%的杀手取得了游戏最终的胜利哦！"
}
$('.footer-button1').click(function () {
    window.location.href = 'js2.html'
});
$('.back').click(function () {
    window.location.href = 'js2.html'
});