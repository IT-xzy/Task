var die = JSON.parse(localStorage.getItem('key1'));
if( die!=null){
var num=die.length;
} else {
    var num =1
}
var order = JSON.parse(localStorage.getItem('key'));

var res = JSON.parse(localStorage.getItem('res'));
var arr = [];
var arr = order;

console.log(die)


var kill = document.getElementsByClassName("box");
//杀手杀人
var last_word = document.getElementsByClassName("box")[1];
//发表遗言
var say = document.getElementsByClassName("box")[2];
//依次发言        
var vote1 = document.getElementsByClassName("box")[3];
//全民投票
var sun = document.getElementsByClassName("circle-b")[0];
//太阳图标
var text = document.getElementsByClassName("dead");
//几号被杀死，真实身份
var vote_font=document.getElementsByClassName("vote-font");
//几号被投死，真实身份
var flow = document.getElementsByClassName("nav_content")[0];
//主要内容
var dayes = document.getElementsByClassName("nav-font");
// //天数
var body = document.getElementsByTagName("body")[0];





if(die){
    for(i=0;i<die.length-1;i++){
        // kill[num-1].style.background = "red"; //杀人后改变HTML和css样式
        // sun.style.top = "5.65rem";

     var day = document.getElementsByTagName("nav")[i].cloneNode(true); //克隆天数
     body.appendChild(day); //天数位置
     dayes[i+1].innerHTML = "第" + (i+2) + "天"; //以day.length来显示天数
     var flow1 = document.getElementsByClassName("nav_content")[i].cloneNode(true); //克隆流程图
     body.appendChild(flow1); //流程图位置
    }}
    


//die的数组长度

// kill.onclick=function(){
//     location.href = "./log.html";
// }


// if (die) {
//     kill[num-1].style.background = "red"; //杀人后改变HTML和css样式
//     sun.style.top = "5.65rem";
// }






// for(i=0;i<res.length;i++){
// if(res){
//     kill.style.background="red";//杀人后改变HTML和css样式
//     sun.style.top="5.65rem";
//     text.innerHTML=res[i]
// }
// console.log(res[i])

// }


var fsm = new StateMachine({
    init: 'kill',
    transitions: [{
            name: 'one',
            from: 'kill',
            to: 'last_word'
        },
        {
            name: 'two',
            from: 'last_word',
            to: 'say'
        },
        {
            name: 'three',
            from: 'say',
            to: 'vote1'
        },
        {
            name: 'four',
            from: 'vote1',
            to: 'kill'

        }
    ],

    methods: {
        onOne: function () {
            // location.href = "./log.html";
            console.log(10)
            if (localStorage.getItem('liu') < 1 || !localStorage.getItem('liu')) {
                location.href = "./log.html";
                kill[(num-1)*4].style.background="red";
                sun.style.top = "5.65rem";
            } else {
                kill[(num-1)*4].style.background="red";
                sun.style.top = "5.65rem";
            }

        },
        onTwo: function () {
            console.log(die)
            confirm("死者亮明身份并且发表遗言");
           kill[(num-1)*4+1].style.background = "red";
            console.log(2)

        },
        onThree: function () {
            confirm("玩家依次发言");
            kill[(num-1)*4+2].style.background = "red"
        },
        onFour: function () {
            if (!localStorage.getItem('vote')) {
                localStorage.setItem('vote', 1);
            }
            // last_word.style.background="red";
            // say.style.background="red";
            // vote1.style.background="red";
            flow.style.display = "none";
            location.href = "./log.html"; //跳转投死页面 

        },
        onInvalidTransition: function (transition, from, to) {
            alert('请按顺序操作');
        }
    }
});

// for(let i=0;i<1;i++){
if (localStorage.getItem('liu')) { //读取到“liu”
    let a = localStorage.getItem('liu') //将“liu”赋值给变量“a”
    switch (true) { //switch语句
        case a == 1: //当a=1时
            fsm.one(); //运行第一状态，开始第二状态
    }
}





// }

// if(localStorage.getItem('vote')){
//     flow.style.display="none";
//     var day=document.getElementsByClassName("nav-font")[0].cloneNode(true);
//    flow.appendChild(day);

// }
// -
// if (die) {
//     for (let i =0;i<die.length;i++){
//         $('.dead').eq(i).innerHTML =die[i].kill;
//         $('vote-font').eq(i).innerHTML = die[i].tou 
//         console.log(die[i].kill)
//         console.log(die[i].tou)
//     }
// }








if(die){
for(let i=0;i<die.length;i++){
    if (die[i].kill||die[i].kill==0) {
        text[i].innerHTML = die[i].kill+1 + "号被杀死，真实身份是平民";
        // kill[(num-1)*4].style.background="red";
    }
    if (die[i].tou||die[i].tou == 0) {
        console.log(55555)
        vote_font[i].innerHTML=die[i].tou+1+"号被投票投死，真实身份是"+res[die[i].tou].job;
    }
    // if(i<die.length+1){
    //     document.getElementsByClassName("box")[i+2].style.background="red";

    // }

}}



for (let i=0;i<$(".centent").length-1;i++){

    



    $(".centent").eq(i).on('click','.box',function(){
        alert("aa")
    })
}









if (die == null) {
   wh(0)
} else {
  wh(num-1)
  
}
function wh (day){
    $('.centent').eq(day).children('.box').eq(0).on('click', function () {
        //通过判断.centent里的.box
        fsm.one();
        //  localStorage.setItem('liu', 1)//名字为liu，值为1
    })
    $('.centent').eq(day).children('.box').eq(1).on('click', function () {
        //通过判断.centent里的.box
        fsm.two();
        //  localStorage.setItem('liu', 1)//名字为liu，值为1
    })
    $('.centent').eq(day).children('.box').eq(2).on('click', function () {
        //通过判断.centent里的.box
        fsm.three();
        //  localStorage.setItem('liu', 1)//名字为liu，值为1
    })
    $('.centent').eq(day).children('.box').eq(3).on('click', function () {
        //通过判断.centent里的.box
        fsm.four();
        //  localStorage.setItem('liu', 1)//名字为liu，值为1
    })

}
 
// if((num-1)*4)




// $('.box').eq(1).on('click', function () {
//     console.log(2.5)
//     fsm.two();
// })

// $('.box').eq(2).on('click', function () {

//     fsm.three();
// })

// $('.box').eq(3).on('click', function () {

//     fsm.four();
// })

// var day=new Date().getDate();
// switch(day){
//     case 0:
//     x="Today it's Sunday"
// }


// $(document).ready(function () { //jquery语句
//     $('nav').click(function () { //绑定点击事件
//         $('.nav_content').hide(); //隐藏
//         $(this).find($('.nav_content')).show();
//         //显示被点击的盒子下的隐藏内容
//     })
// })


$('nav').click(function () { //jquery,"nav"绑定点击事件
    $(this).next().toggle(); //显示、隐藏可以切换
})



for(i=0;i<(num-1)*4;i++){
document.getElementsByClassName("box")[i].style.background="red";

}
for(i=0;i<num-1;i++){
   document.getElementsByClassName("nav_content")[i].style.display="none"; 
}





function button_right() {
    localStorage.setItem('look',1);
    location.href = "./log.html";
}

// function button_left() {
//     confirm("本轮游戏是否已经结束？");
//     if( button_left()==turn){
//         localStorage.clear();
//         location.href="deal.html";
//     }
// }
function button_left(){
    if(confirm("本轮游戏是否已经结束？")){
        localStorage.clear();
        location.href= "./deal.html";
    }else{
        return;
    }
}
