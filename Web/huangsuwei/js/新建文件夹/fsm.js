$(document).ready(function () {
    var result=document.getElementById("result");
   var fsm = {
       state:"single",
       flower: function () {
           switch (fsm.state){
               case 'single':
                   result.innerHTML="初恋";
                   alert("送花进度太慢了");
                   fsm.state = 'first';
                   break;
               case 'first':
                   result.innerHTML="热恋";
                   alert("送花进度太慢了");
                   fsm.state = 'hot';
                   break;
               case 'hot':
                   result.innerText="结婚";
                   alert("恭喜你结婚");
                   fsm.state = 'married';
                   break;
               case 'married':
                   alert("老夫老妻还秀恩爱，真恶心");
                   break;
           }
       },
       ring: function () {
           switch (fsm.state){
               case 'single':
                   result.innerHTML="热恋";
                   alert("直接热恋了");
                   fsm.state = 'hot';
                   break;
               case 'first':
                   result.innerHTML="结婚";
                   alert("直接结婚了");
                   fsm.state = 'married';
                   break;
               case 'hot':
                   result.innerText="结婚";
                   alert("浪费了一个大钻戒");
                   fsm.state = 'married';
                   break;
               case 'married':
                   alert("夫人已经变成了指环王");
                   break;
           }
       },
       separate: function () {
           switch (fsm.state){
               case 'single':
                   alert("醒醒吧，你没有女朋友");
                   break;
               case 'first':
                   result.innerHTML="单身狗";
                   alert("好吧，你成功变成了单身狗");
                   fsm.state = 'single';
                   break;
               case 'hot':
                   result.innerText="初恋";
                   alert("你们又变回了初恋关系");
                   fsm.state = 'first';
                   break;
               case 'married':
                   result.innerText="热恋";
                   alert("你们又变回了热恋关系");
                   fsm.state = 'hot';
                   break;
           }
       },
       brawl: function () {
           switch (fsm.state){
               case 'single':
                   alert("别做梦了，你是一直单身狗");
                   break;
               case 'first':
                   result.innerHTML="单身狗";
                   alert("成功变成了一直单身狗");
                   fsm.state = 'single';
                   break;
               case 'hot':
                   result.innerText="单身狗";
                   alert("成功变成了一直单身狗");
                   fsm.state = 'single';
                   break;
               case 'married':
                   result.innerText="单身狗";
                   alert("离婚了");
                   fsm.state = 'single';
                   break;
           }
       }
   };
   $("#send1").click(function () {
       fsm.flower();
   });
    $("#send2").click(function () {
        fsm.ring();
    });
    $("#send3").click(function () {
        fsm.separate();
    });

    $("#send4").click(function () {
        fsm.brawl();
    });
});