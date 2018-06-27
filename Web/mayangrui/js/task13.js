function jump(){
    window.location.href="https://bradmatt213.github.io/learngit/task13-1"
}
$(document).ready(function () {
    $(".right").click(function () {
        $(".main").animate({left:'0rem'},"slow");
    });
});
$(document).ready(function () {
    $("#show").click(function () {
        $(".main").animate({left:'3rem'},"slow");
    })
});
$(document).ready(function () {
    $(".btn").click(function () {
        jump();
    })
});
