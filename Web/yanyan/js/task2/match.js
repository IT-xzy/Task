//
//
// $(function() {
//     $( "#slider-range-min" ).slider({
//         range: "min",
//         value: 6,
//         min: 1,
//         max: 20,
//         slide: function( event, ui ) {
//             $( "#amount" ).val(+ ui.value );
//         }
//     });
//     $( "#amount" ).val( $( "#slider-range-min" ).slider( "value" ) );
// });
//

var num = document.getElementById("num");
var icon = document.getElementById("icon");
var a ;
var b ;
var numa = "<div class='row'><div class='block2 g-inlineb'></div><div class='g-inlineb'>杀&nbsp;&nbsp;手&nbsp;1&nbsp;人</div></div>";
//给杀手显示标签赋值给变量numa
var numb = "<div class='row'><div class='block1 g-inlineb'></div><div class='g-inlineb'>水&nbsp;&nbsp;民&nbsp;1&nbsp;人</div></div>";
//给杀手显示标签赋值给变量numb



function num_change() {
    if (num.value <= 18 && num.value >= 6) {
        icon.value = num.value;
    } else {
        alert("请选择范围内的人数");
        num.value = 6;
        icon.value = 6;
    }
}//请选择范围内的玩家人数

function icon_change() {
    num.value = icon.value;
}//滑块的数值赋值给玩家人数

function minus_id() {
    icon.value--;
    if (num.value <= 6) {
        num.value = 6;
        alert("超出范围重新选择")
    }num.value = icon.value;
}//减超出范围重新选择

function plus_id() {
    icon.value++;
    if (num.value >= 18) {
        num.value = 18;
        alert("超出范围重新选择")
    }num.value = icon.value;
}//加超出范围重新选择



var killer = [];
var people = [];
var kp2 = [];


$("#change").click(function () {
    var i;
    //重置人员分配数组
    killer.splice(0,killer.length);
    people.splice(0,people.length);
    kp2.splice(0,kp2.length);
    if (num.value <= 8) {
        a = 2;
    } else if (num.value <= 11) {
        a = 3;
    } else if (num.value <= 15) {
        a = 4;
    } else {
        a = 5;
    }
    b = num.value - a;//杀手水民人数分配

    for ( i = 0; i < a; i++) {
        killer[i] = numa;
    }//杀手数组
    for ( i = 0; i < b; i++) {
        people[i] = numb;
    }//水民数组

    var kp = killer.concat(people);//杀手水民组合数组

    while (kp.length) {
        var index = ~~(Math.random() * kp.length);
        kp2.push(kp[index]);
        kp.splice(index, 1);
    }//杀手水民数组乱序
    sessionStorage.setItem("numkey",JSON.stringify(kp2));
    $(".abnum").empty();//清空
    $(".abnum").append(kp2);
});
console.log(kp2);




function footer() {
    console.log(typeof num.value);
    console.log(typeof kp2.length);

    if (kp2.length === parseInt(num.value)){

        location.href="jstask3-1.html";
    }else {
        alert("请点击设置分配成员");

    }
}





