entrance = JSON.parse(sessionStorage.getItem('dog'));
console.log("js4 person==="+entrance);


var day=1;
sessionStorage.setItem('sky',JSON.stringify(day));

var i = 0;

var box = $('.rongqi').append('<div class="row"><button class="shuiming"></button><div class="shuzi"></div></div>');
//先写一个盒子出来添加到容器里面，以便后面循环使用。
for (box = 1; box < entrance.length; box++) {
    $('.rongqi').append('<div class="row"><button class="shuiming"></button><div class="shuzi"></div></div>');
}
//利用上面写出来的盒子循环至entrance-1为止。

for (i; i < entrance.length; i++) {
    // $('.rongqi').append('<div class="row"><div class="shuiming">' + entrance[i] + '</div><div class="shuzi">' + (i + 1) +'号'+ '</div></div>');
    //循环出来的每一个i全部添加到容器里面的方式，主要部分' + entrance[i] + '   ' + (i + 1) +'号'+ '，只需要上面的3行代码，完成本页面。
    $('.shuiming').eq(i).html(entrance[i]);
    $('.shuzi').eq(i).text(i + 1);
    //利用eq来把i的每一个都单独的添加到容器里面去。
}
$('.tousi').click(function () {
    window.location.href = 'JS4-2.html'
});
var q;
var num = 0;
for (q = 0; q < entrance.length; q++) {
    entrance[q] = {
        identity: entrance[q],
        alive: 'alive',
        day: num,
        death: 'none',
        number: q + 1
    };
}
sessionStorage.setItem('dog', JSON.stringify(entrance));
console.log("js4  storage===" + JSON.parse(sessionStorage.getItem('dog')));

sessionStorage.setItem('stage',JSON.stringify('none'));

var s='0';
sessionStorage.setItem('asd',JSON.stringify(s));