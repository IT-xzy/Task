var pfs = sessionStorage.getItem("player");
var player = pfs.split("1人");
var time=1;
var index=0;
// console.log(pfs);
$("#return").click(function () {
    window.location.href = "js-2.html"

})

player.pop()
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
        $(".first").hied();
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
    sessionStorage.getItem("id",player)

    location.href("js2-3.html")

})


