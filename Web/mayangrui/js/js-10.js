$(document).ready(function () {
    $("#bt1").click(function () {
        $(".ps1").addClass("orange");
        $(".ps2").removeClass("orange");
        $(".ps3").removeClass("orange");
        $(".ps4").removeClass("orange");
    })
})
$(document).ready(function () {
    $("#bt2").click(function () {
        $(".ps2").addClass("orange");
        $(".ps1").removeClass("orange");
        $(".ps3").removeClass("orange");
        $(".ps4").removeClass("orange");
    })
})
$(document).ready(function () {
    $("#bt3").click(function () {
        $(".ps3").addClass("orange");
        $(".ps2").removeClass("orange");
        $(".ps1").removeClass("orange");
        $(".ps4").removeClass("orange");
    })
})
$(document).ready(function () {
    $("#bt4").click(function () {
        $(".ps4").addClass("orange");
        $(".ps2").removeClass("orange");
        $(".ps3").removeClass("orange");
        $(".ps1").removeClass("orange");
    })
})