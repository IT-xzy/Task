var identifyIfo = JSON.parse(sessionStorage.getItem("playerIdentify"));
var num = sessionStorage.getItem("playerNums");
var playersifo = JSON.parse(sessionStorage.getItem('playersifo'));
var bg = JSON.parse(sessionStorage.getItem('bg1'));
var deadMan = JSON.parse(sessionStorage.getItem('deadMan'));
var deadManNum = JSON.parse(sessionStorage.getItem('deadManNum'));
var dayTime = JSON.parse(sessionStorage.getItem('dayTime'));
var day = JSON.parse(sessionStorage.getItem('day'));

console.log(identifyIfo);
console.log(num);
console.log(playersifo);
console.log(deadMan);
console.log(deadManNum);
console.log(bg);
console.log(dayTime);
console.log(day);
// 反复查看deadManNum会有重复的数组
// 先定义一个新的数组
var newArr = [];
// 遍历数组
for (i = 0; i < deadManNum.length; i++) {
    if (newArr.indexOf(deadManNum[i]) < 0) {
        //判断在s数组中是否存在，不存在则push到s数组中
        newArr.push(deadManNum[i]);
    }
    console.log(newArr);
}
if (newArr.length === 0) {
    console.log('还木有杀人')
} else if (newArr.length >= 1) {
    $('.result').append('<p>' + '第' + 1 + '天' + '</p>');
    $('.result').append('<span>' + '晚上:' + '</span>');
    $('.result').append('<span>' + newArr[0] + '号被杀手杀死了' + '--------' + newArr[0] + '号是' + playersifo[(newArr[0] - 1)].identify + '</span>');
}
var x = newArr.length - 1,
    m = Math.round(x / 2);
for (i = 1; i <= m; i++) {
    if (x % 2 == 0) {
        $('.result').append('<p class="diary-result">' + '第' + (i + 1) + '天' + '</p>');
        $('.result').append('<p>' + '白天:' + '</p>');
        $('.result').append('<span>' + newArr[(2 * i - 1)] + '号被人们投死了' + '--------' + newArr[(2 * i - 1)] + '号是' + playersifo[(newArr[(2 * i - 1)] - 1)].identify + '</span>');
        $('.result').append('<p>' + '晚上:' + '</p>');
        $('.result').append('<span>' + newArr[(2 * i)] + '号被杀手杀死了' + '--------' + newArr[(2 * i)] + '号是' + playersifo[(newArr[(2 * i)] - 1)].identify + '</span>');
    } else {
        if (i != m) {
            $('.result').append('<p class="diary-result">' + '第' + (i + 1) + '天' + '</p>');
            $('.result').append('<p>' + '白天:' + '</p>');
            $('.result').append('<span>' + newArr[(2 * i - 1)] + '号被人们投死了' + '--------' + newArr[(2 * i - 1)] + '号是' + playersifo[(newArr[(2 * i - 1)] - 1)].identify + '</span>');
            $('.result').append('<p>' + '晚上:' + '</p>');
            $('.result').append('<span>' + newArr[(2 * i)] + '号被杀手杀死了' + '--------' + newArr[(2 * i)] + '号是' + playersifo[(newArr[(2 * i)] - 1)].identify + '</span>');
        } else if (i == m) {
            $('.result').append('<p class="diary-result">' + '第' + (i + 1) + '天' + '</p>');
            $('.result').append('<p>' + '白天:' + '</p>');
            $('.result').append('<span>' + newArr[(2 * i - 1)] + '号被人们投死了' + '--------' + newArr[(2 * i - 1)] + '号是' + playersifo[(newArr[(2 * i - 1)] - 1)].identify + '</span>');
        }
    }

}
$('.return-game').on('click', function() {
    window.location.href = './大法官的日志.html';
})