//取回数据
var strr = JSON.parse(sessionStorage.getItem("data"));
var player = [];
for(var i = 0; i < strr.length; i ++){
    function P() {
        this.name = strr[i];
        this.state = true;
        this.day = 0;
        this.dead = 1;
        this.deathDay = 0 ;
        this.click = 0;
        this.num = i;
    }
    var aa = new P();
    player.push(aa)
}
var day =1;
sessionStorage.setItem('day' , day);
var one = JSON.stringify(player);
localStorage.object = one;
for(var i = 0; i < strr.length; i ++){
    var d =
        '<button id=role class="role">' +
        '<div class="button2">' +
        '<p id=div8 class="div8"></p>' +
        '<p id=div9 class="div9"></p>' +
        '</div>' +
        '</button>';
    $(".main2").append(d);
    var ab = document.getElementsByClassName('div8');
    var cd = document.getElementsByClassName("div9");
    ab[i].innerHTML=strr[i];
    cd[i].innerHTML=Number(i+1)+'号';
}

function gameStart() {
    window.location.href='./js2-6.html';
}
var box = JSON.stringify(d);
sessionStorage.setItem("data3" ,box);
$('body').css('background' ,'#29BDE0');