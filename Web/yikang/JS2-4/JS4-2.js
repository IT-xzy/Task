var current_stage = JSON.parse(sessionStorage.getItem('stage'));
var judge= JSON.parse(sessionStorage.getItem('sd'));

//状态机初始值需要一个变量来指定，这个页面设置变量每次进入页面会重置初始值，所以，在上个页面设置初始值利用数    据存取传过来。
console.log("current_stage===" + current_stage);
entrance = JSON.parse(sessionStorage.getItem('dog'));
// console.log("js4 person===" + entrance[0].identity);
// console.log("js4 person===" + entrance[0].alive);
var p = JSON.parse(sessionStorage.getItem('subscript'));

var q = JSON.parse(sessionStorage.getItem('subscript4-4'));

var day = JSON.parse(sessionStorage.getItem('sky'));

var murder = new Array;
for (h = 0; h < day; h++) {
    // console.log(h+1);
    if (h < day) {
        murder.push(
            '<div>' +
            '<div class="center">' + '第' + '<span class="nm">' + (h + 1) + '</span>' + '天' + '</div>' +
            '<div class="center-bottom">' +
            '<div class="left">' +
            '<div class="left-top"><img src="images/JS4-2.png" alt=""></div>' +
            '<div class="left-boot"><img src="images/JS4-3.png" alt=""></div>' +
            '</div>' +
            '<div class="right">' +
            '<br>' +
            '<div class="dis">' +
            '<button class="btn">' + '杀手杀人' + '</button>' +
            '<br>' +
            '<p class="text-top"></p>' +
            '</div>' +
            '<br>' +
            '<div class="dis">' +
            '<button class="btn">' + '亡灵发表遗言' + '</button>' +
            '</div>' +
            '<br>' +
            '<div class="dis">' +
            '<button class="btn">玩家依次发言</button>' +
            '</div>' +
            '<br>' +
            '<div class="dis">' +
            '<button class="btn">' + '玩家投票' + '</button>' +
            '<p class="text-bottom"></p>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>');
        $('main').html(murder).eq(h);
        // $('p').eq(h).html(p+1+'号玩家被杀死了,'+'他的身份是'+entrance[p].identity)
        // console.log(murder);
        var t = entrance.filter(function (item) {
            return (item.alive === 'die' && item.death === 'killed')
        });
        var z = entrance.filter(function (item) {
            return (item.alive === 'die' && item.death === 'cast')
        });
//         for(var b=0;b<day;b++){
//             if(t.length!==0){
//                 if(t[b]){
//                     $('.text-top').eq(b).text(p+1+'号玩家被杀死了,'+'他的身份是'+entrance[p].identity);
//                 }
//             }
//         }
//         for(var x=0;x<day;x++){
//             if(z.length!==0){
//                 if(z[x]){
//                     $('.text-bottom').eq(x).text(q+1+'号玩家被投死了,'+'他的身份是'+entrance[q].identity);
//                 }
//             }
//         }
//
//     }
// }
        for (i = 0; i < t.length; i++) {
            $('.text-top').eq(i).text(t[i].number + '号玩家被杀死了,' + '他的身份是' + entrance[p].identity)
        }
        for (i = 0; i < z.length; i++) {
            $('.text-bottom').eq(i).text(z[i].number + '号玩家被投死了,' + '他的身份是' + entrance[q].identity)
        }
    }
}
// for(var c=0;c<t.length;c++){
//     if((c+1)%2===0){
//         $('.text-top').eq(c).html(p+1+'号玩家被杀死了,'+'他的身份是'+entrance[p].identity)
//     }else{
//         $('.text-bottom').eq(c).html(q+1+'号玩家被杀死了,'+'他的身份是'+entrance[q].identity)
//     }
// }
// $('.right').eq(day-2).attr('disabled', true);
// $('.right').eq(day-1).attr('disabled', false);
//定义一个变量，用于指定第几天。
for (c = 0; c < $('.btn').length; c++) ;
var fsm = new StateMachine({
    //定义状态机
    init: current_stage,
    //初始值
    transitions: [
        //状态转变的条件。
        {name: 'course', from: 'none', to: '1'},
        {name: 'course1', from: '1', to: '2'},
        {name: 'course2', from: '2', to: '3'},
        {name: 'course3', from: '3', to: '4'},
        {name: 'course4', from: '4', to: 'none'}
    ],
    methods: {
        //状态转变时需要执行的方法。
        onCourse: function () {

            // $('.btn').eq(c-4).addClass('ccc');
            // console.log("step 0 ===" + fsm.state);
        },
        onCourse1: function () {
            // $('.btn').eq(c-3).addClass('ccc');
            // console.log("step 1 ===" + fsm.state);
        },
        onCourse2: function () {
            // $('.btn').eq(c-2).addClass('ccc');
            // console.log("step 2 ===" + fsm.state);
        },
        onCourse3: function () {
            // $('.btn').eq(c-1).addClass('ccc');
            // console.log("step 3 ===" + fsm.state);
        }
    }
});
$(document).ready(function () {
    if(fsm.state==="1"){
        $('.right').find(".btn").addClass("ccc");
        $('.right').eq(day - 1).find(".btn").css("background-color", "#29bde0");
        $('.right').eq(day - 1).find(".btn").eq(0).css("background-color", "#ccc")
    }
    else if(fsm.state==="none"&&t.length!==0){
        $('.right').find(".btn").addClass("ccc");
        $('.right').eq(day - 1).find(".btn").css("background-color", "#29bde0");
    }
});


// var p=JSON.parse(sessionStorage.getItem('subscript'));
// if(entrance[p]!==undefined){
//     $('.text-top').text(p+1+'号玩家被杀死了,'+'他的身份是'+entrance[p].identity);
// }
// // console.log('subscript===='+p+1+'号玩家被杀死了。');
// var q=JSON.parse(sessionStorage.getItem('subscript4-4'));
// if(entrance[q]!==undefined){
//     $('.text-bottom').text(q+1+'号玩家被投死了,'+'他的身份是'+entrance[q].identity);
// }
// console.log('subscript4-4==='+q+1+'号玩家被投死了。');

//点击事件，状态转变时执行上面定义的方法。
$('.btn').eq(day * 4 - 4).bind('click', function () {
          $(this).css('background-color','#ccc');
          fsm.course();
          alert('准备进入杀人页面');
          window.location.href = 'JS4-3.html';
          //跳转页面。
});
$('.btn').eq(day * 4 - 3).bind('click', function () {
              if(judge==1){
                  judge='2';
                  $(this).css('background-color','#ccc');
                  fsm.course1();
                  alert('请亡灵准备好发言');
              }
});
$('.btn').eq(day * 4 - 2).bind('click', function () {
     if(judge==2){
         judge='3';
         $(this).css('background-color','#ccc');
         fsm.course2();
         alert('请玩家准备好以此发言');
     }
});
$('.btn').eq(day * 4 - 1).bind('click', function () {
    if(judge==3){
        judge=null;
        $(this).css('background-color','#ccc');
        fsm.course3();
        alert('准玩家准备好进入投票页面');
        window.location.href = 'JS4-4.html';
    }
});
$('.footer').bind('click',function () {
    sessionStorage.clear()
});
// if (current_stage == 1) {
//     // $('.btn').addClass('ccc');
// }
// if (current_stage == 2) {
//     // $('.btn').addClass('ccc');
// }
// if (current_stage == 3) {
//     // $('.btn').addClass('ccc');
// }
// if (current_stage == 4) {
//     // $('.btn').addClass('ccc');
// }
for (var m = 0; m < (day - 1) * 4; m++) {
    $('.btn').eq(m).addClass('blue');
}
$('.center').click(function () {
    $(this).siblings().toggle()
});
for (var y = 0; y < day; y++) {
    $('.center-bottom').eq(y).hide();
    // $('.btn').eq(y).addClass('ccc');
    // console.log(y)
}
$('.center-bottom').eq(day - 1).show();
// $('.bnt').eq(day-1).removeClass('ccc');

// for(u=0;u<$('.btn').length;u++){
//     $('.btn').eq(u).addClass('ccc');
//     $('.btn').eq(u-day*4).removeClass('ccc');
// }

var s = JSON.parse(sessionStorage.getItem('asd'));
if (s == 1) {
    fsm.course();
} else if (s == 2) {
    console.log("stet 2===");
    fsm.course1();
} else if (s == 3) {
    console.log("stet 3===");
    fsm.course2();
} else if (s == 4) {
    fsm.course();
    fsm.course1();
    fsm.course2();
    fsm.course3();
    fsm.course4();
}
