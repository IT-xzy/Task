var entrance = JSON.parse(sessionStorage.getItem('dog'));
console.log("js4-3  person===" + entrance);

var o = 'none';
sessionStorage.setItem('count', JSON.stringify(o));
//存初始值为none的o
// console.log(o);
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
    $('.shuiming').eq(i).html(entrance[i].identity);
    $('.shuzi').eq(i).text(i + 1);
    //利用eq来把i的每一个都单独的添加到容器里面去。
}
var day=JSON.parse(sessionStorage.getItem('sky'));



$('.row').click(function () {
    q = $(this).index();
    sessionStorage.setItem('subscript4-4',JSON.stringify(q));
    // console.log('subscript4-4==='+q);
    // console.log("current person is ===" + (entrance[q].identity));
    if (entrance[q].identity == '平民','杀手') {
        $('.row').addClass('blue').removeClass('red');
        $(this).addClass('red');
        $('.tousi').click(function () {
            entrance[q].alive = 'die';
            entrance[q].death = 'cast';
            console.log(entrance[q]);
            sessionStorage.setItem('dog', JSON.stringify(entrance));
            entrance = JSON.parse(sessionStorage.getItem('dog'));
            console.log("person 0 is alive===" + entrance[0].alive);
            sessionStorage.setItem('stage', JSON.stringify(4));
            sessionStorage.setItem('asd', JSON.stringify(4));
            sessionStorage.setItem('sky',JSON.stringify(day));
            var famer=entrance.filter(function (item) {
                return(item.identity==='平民'&& item.alive==='alive');
            });
            var killer=entrance.filter(function (item) {
                return(item.identity==='杀手'&& item.alive==='alive')
            });
            if(killer.length==famer.length){
                window.location.href='JS4-5.html'
            }else if(killer.length==0){
                window.location.href='../task777.html'
            }else {
                window.location.href = 'JS4-2.html';
            }
        })
    }

});
$('.diyige').bind('click',function () {
    sessionStorage.clear()
});

for(m=0;m<entrance.length;m++){
    $('.shuiming').eq(m).removeClass('red');
    if(entrance[m].alive =='die'){
        // console.log(entrance[m].alive=='die');
        $('.row').eq(m).addClass('redd');
    }
}
$(document).ready(function () {
$(".row").click(function () {
   var index=$(this).index();
   if(entrance[index].alive==='die'){
       alert("不要鞭尸胸dei")
   }
})
});
day++;

