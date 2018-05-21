//玩家分配数据
var part_value = sessionStorage.getItem("deal");
part_value = JSON.parse(part_value);
console.log(part_value);

var userNumber = document.getElementsByClassName("user-operate");
var i;
var a;

$(".icon_back").click(function () {
    window.location.href = "JS-TASK2-分配.html"
})
for (i = 18;
    i > part_value.length - 1;
    i--) {
    $(".user-operate").eq(i).remove();
}
//清除“玩家”wrap div的高度
for (a = 0;
    a < 6;
    a++) {
    var x = document.getElementsByClassName("form");
    if ($(".form")[a].childNodes.length == 4) {
        x[a].style.height = "0";
    }
}

//遍历使显示“水民”或“杀手”
for (var n = 0;
    n < part_value.length;
    n++){
    var x = document.getElementsByClassName("character");
    if (part_value[n] == 0) {
        $(".character").eq(n).children("li").eq(0).html("水民");
    }
    else {
        $(".character").eq(n).children("li").eq(0).html("杀手");
    }
}

$(".startGame").click(function(){
    window.location.href="JS-TASK4-流程.html";
    sessionStorage.removeItem("die");
    sessionStorage.removeItem("vote");
    sessionStorage.removeItem("st");
    sessionStorage.removeItem("c");
    sessionStorage.removeItem("end");
})