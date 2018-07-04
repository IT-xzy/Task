var identifyIfo = JSON.parse(sessionStorage.getItem("playerIdentify"));
var num = sessionStorage.getItem("playerNums");
var playersifo = JSON.parse(sessionStorage.getItem('playersifo'));
var newArr = JSON.parse(sessionStorage.getItem('newArr'));
var killer = JSON.parse(sessionStorage.getItem('killer'));
var words = JSON.parse(sessionStorage.getItem("gameWords1"));
var deadMan = JSON.parse(sessionStorage.getItem('deadMan'));
console.log(playersifo);
console.log(killer);
console.log(words);
// 切换图标
if (killer !== 0) {
    $('.container1').prepend('<li class="congratulate-ico2">' + '</li>');
    $('.congratulate').html('太棒了！你知道？在捉鬼游戏游戏中只有20%的杀手取得胜利');
} else {
    $('.container1').prepend('<li class="congratulate-ico1">' + '</li>');
    $('.congratulate').html('太棒了！恭喜你们打败杀手集团');
}
// 输出杀手人数和词汇
$('.identify-info').append('<p>' + '杀手:' + Math.floor(num / 3) + '人' + '</p>');
$('.identify-info').append('<p>' + '平民:' + (num - Math.floor(num / 3)) + '人' + '</p>');
$('.game-words').append('<p>' + '平民词汇:' + '&nbsp;' + words[0] + '</p>');
$('.game-words').append('<p>' + '幽灵词汇:' + '&nbsp;' + words[1] + '</p>');
// 输出日志
if (newArr.length === 0) {
    console.log('还木有杀人')
} else if (newArr.length >= 1) {
    $('.journal').append('<p>' + '第' + 1 + '天' + '</p>');
    $('.journal').append('<span>' + '晚上:' + '</span>');
    $('.journal').append('<span>' + newArr[0] + '号被杀手杀死了' + '--------' + newArr[0] + '号是' + playersifo[(newArr[0] - 1)].identify + '</span>');
}
var x = newArr.length - 1,
    m = Math.round(x / 2);
for (i = 1; i <= m; i++) {
    if (x % 2 == 0) {
        $('.journal').append('<p class="diary-journal">' + '第' + (i + 1) + '天' + '</p>');
        $('.journal').append('<p>' + '白天:' + '</p>');
        $('.journal').append('<span>' + newArr[(2 * i - 1)] + '号被人们投死了' + '--------' + newArr[(2 * i - 1)] + '号是' + playersifo[(newArr[(2 * i - 1)] - 1)].identify + '</span>');
        $('.journal').append('<p>' + '晚上:' + '</p>');
        $('.journal').append('<span>' + newArr[(2 * i)] + '号被杀手杀死了' + '--------' + newArr[(2 * i)] + '号是' + playersifo[(newArr[(2 * i)] - 1)].identify + '</span>');
    } else {
        if (i != m) {
            $('.journal').append('<p class="diary-journal">' + '第' + (i + 1) + '天' + '</p>');
            $('.journal').append('<p>' + '白天:' + '</p>');
            $('.journal').append('<span>' + newArr[(2 * i - 1)] + '号被人们投死了' + '--------' + newArr[(2 * i - 1)] + '号是' + playersifo[(newArr[(2 * i - 1)] - 1)].identify + '</span>');
            $('.journal').append('<p>' + '晚上:' + '</p>');
            $('.journal').append('<span>' + newArr[(2 * i)] + '号被杀手杀死了' + '--------' + newArr[(2 * i)] + '号是' + playersifo[(newArr[(2 * i)] - 1)].identify + '</span>');
        } else if (i == m) {
            $('.journal').append('<p class="diary-journal">' + '第' + (i + 1) + '天' + '</p>');
            $('.journal').append('<p>' + '白天:' + '</p>');
            $('.journal').append('<span>' + newArr[(2 * i - 1)] + '号被人们投死了' + '--------' + newArr[(2 * i - 1)] + '号是' + playersifo[(newArr[(2 * i - 1)] - 1)].identify + '</span>');
        }
    }
}
// 最后一个被投出去的人的身份信息
// 主要是因为newarr的结果不包括最后一个人导致的,但是将newarry放到杀人页面会导致日记本那块第一天失效,目前先这么写着
if (x % 2 == 0) {
    $('.journal').append('<p class="diary-journal">' + '第' + (m + 2) + '天' + '</p>');
    $('.journal').append('<p>' + '白天:' + '</p>');
    $('.journal').append('<span>' + deadMan[0] + '号被人们投死了' + '--------' + deadMan[0] + '号是' + playersifo[(deadMan[0] - 1)].identify + '</span>');

} else {
    $('.journal').append('<p class="diary-journal">' + '第' + (m + 1) + '天' + '</p>');
    $('.journal').append('<p>' + '黑夜:' + '</p>');
    $('.journal').append('<span>' + deadMan[0] + '号被杀手杀死了' + '--------' + deadMan[0] + '号是' + playersifo[(deadMan[0] - 1)].identify + '</span>');
}



$('.again').on('click', function() {
    window.location.href = "./task2首页.html"
})