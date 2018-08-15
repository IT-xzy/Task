// function blockul() {
//     var oUl = document.getElementById("ul1").style.display;
//     if (oUl == 'none') {
//         document.getElementById("ul1").style.display = 'block';
//     }
//     else {
//         document.getElementById("ul1").style.display = 'none';
//     }
// }
$(function () {
    $('#nav').click(function () {
        $('#ul1').toggle();
    });
});



function play() {
    var audio = document.getElementById('music');
    if (audio.paused) {
        audio.play();//audio.play();// 播放
    }
    else {
        audio.pause();// 暂停
    }
};

$("#game-play1").mouseover(function () {
    $("#vote1").css("visibility", "visible");
});

$("#game-play1").mouseout(function () {
    $("#vote1").css("visibility", "hidden");
});

$("#game-play2").mouseover(function () {
    $("#vote2").css("visibility", "visible");
});

$("#game-play2").mouseout(function () {
    $("#vote2").css("visibility", "hidden");
});

$("#game-play3").mouseover(function () {
    $("#vote3").css("visibility", "visible");
});

$("#game-play3").mouseout(function () {
    $("#vote3").css("visibility", "hidden");
});

$("#game-play4").mouseover(function () {
    $("#vote4").css("visibility", "visible");
});

$("#game-play4").mouseout(function () {
    $("#vote4").css("visibility", "hidden");
});

$("#game-play5").mouseover(function () {
    $("#vote5").css("visibility", "visible");
});

$("#game-play5").mouseout(function () {
    $("#vote5").css("visibility", "hidden");
});

$("#game-play6").mouseover(function () {
    $("#vote6").css("visibility", "visible");
});

$("#game-play6").mouseout(function () {
    $("#vote6").css("visibility", "hidden");
});

$("#game-play7").mouseover(function () {
    $("#vote7").css("visibility", "visible");
});

$("#game-play7").mouseout(function () {
    $("#vote7").css("visibility", "hidden");
});

$("#game-play8").mouseover(function () {
    $("#vote8").css("visibility", "visible");
});

$("#game-play8").mouseout(function () {
    $("#vote8").css("visibility", "hidden");
});

$("#game-play9").mouseover(function () {
    $("#vote9").css("visibility", "visible");
});

$("#game-play9").mouseout(function () {
    $("#vote9").css("visibility", "hidden");
});

$("#game-play10").mouseover(function () {
    $("#vote10").css("visibility", "visible");
});

$("#game-play10").mouseout(function () {
    $("#vote10").css("visibility", "hidden");
});

$("#game-play11").mouseover(function () {
    $("#vote11").css("visibility", "visible");
});

$("#game-play11").mouseout(function () {
    $("#vote11").css("visibility", "hidden");
});

$("#game-play12").mouseover(function () {
    $("#vote12").css("visibility", "visible");
});

$("#game-play12").mouseout(function () {
    $("#vote12").css("visibility", "hidden");
});