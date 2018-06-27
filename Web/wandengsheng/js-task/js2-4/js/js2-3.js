//测试



//
var pfs = sessionStorage.getItem("player");
console.log(pfs);

var player = pfs.split("1人");
console.log(player);
var time=1;
var index=0;
player.pop();
console.log(player);

$("#return").click(function () {
    window.location.href = "js2-1.html"

})

// player.pop()
$(".watch").show();
$(".first").show();
$(".number").text(1);
$(".first").click(function () {
    $(".number").text(time);
    $(".number1").text(time+1);
    $(".apellation").text(player[index++]);
    $(".personnumber").toggle();



    $(".first").toggle();
    $(".second").toggle();
    $(".watch").toggle();
    $(".conceal").toggle();
    if (time==player.length){
        $(".judge").toggle();
        $(".first").hide();
        $(".second").hide();
    }


});

$(".second").click(function () {
    $(".number").text(++time);
    $(".secondtwo").text(time);


    $(".first").toggle();
    $(".second").toggle();
    $(".watch").toggle();
    $(".conceal").toggle();


})

$(".judge").click(function () {
    sessionStorage.setItem("id",player);
    window.location.href = "js2-4.html";


})
//重新游戏

$(".right").click(function () {
    confirm("确定要退出本局游戏么？") ? location.href = "js2-1.html" : x;
    // var qd = confirm("确定要退出本局游戏么？")
    // if (qd = true) {
    //     location.href = "js2-1.html"
    // }else{
    //     location.href != "js2-1.html"
        
    // }

});


