$(document).ready(function () {
    var Arr=JSON.parse(sessionStorage.getItem("Arr"));
    var death=JSON.parse(sessionStorage.getItem("death"));
    var stages=JSON.parse(sessionStorage.getItem("stages"));//获取之前的数据
    var day=JSON.parse(sessionStorage.getItem("day"));
    console.log(Arr);console.log("死亡玩家在Arr中的序号:",death);console.log("stages:" ,stages);console.log("day:" ,day);
    $("#day").text(day);
    if (death  !== null){
        var num ;
       if(death.length%2 !==0) {
            num = death[death.length-1]+1;
        }
        else {
            num = death[death.length-2]+1;
        }
      $("#dead").text("昨晚"+num+"号玩家被杀")//显示被杀死杀死玩家
    }
    $("#return").on("click", function () {
        if(confirm("确认回到开始页面？")) {
            window.location.href = "js-task2.html";
            window.sessionStorage.clear();
        }
    });// 后退按钮
    $("#close").on("click", function() {
        if (confirm("确认关闭？")) {
            window.close();
        }
    });//关闭按钮
//创建一个控制阶段的有限状态机$stage
    var $stage = new StateMachine({
        init: 'ready',
        transitions: [
            { name: 'step1', from: 'ready', to: 'kill' },
            { name: 'step2', from: 'kill', to: 'words' },
            { name: 'step3', from: 'words', to: 'speech' },
            { name: 'step4', from: 'speech', to: 'vote' },
            { name: 'reset', from: '*', to: 'ready' }
        ],
        methods: {
            onStep1: function() {
                $(".steps").eq(0).css({"background":"silver"});
                $(".left").eq(0).css({"border-right-color":"silver"})
            },
            onStep2: function() {
                $(".steps").eq(1).css({"background":"silver"});
                $(".left").eq(1).css({"border-right-color":"silver"})
            },
            onStep3: function() {
                $(".steps").eq(2).css({"background":"silver"});
                $(".left").eq(2).css({"border-right-color":"silver"})
            },
            onStep4 : function() {
                $(".steps").eq(3).css({"background":"silver"});
                $(".left").eq(3).css({"border-right-color":"silver"})
            }
        }
    });
    //刷新判断状态
    var $stageCheck = window.sessionStorage.getItem('stages');
    (function(){
        if ($stageCheck === "1") {
            $stage.step1();
        }
        else if ($stageCheck === "2") {
            $stage.step1();
            $stage.step2();
        }
        else if ($stageCheck === "3") {
            $stage.step1();
            $stage.step2();
            $stage.step3();
        }
        else if ($stageCheck === "4") {
            $stage.step1();
            $stage.step2();
            $stage.step3();
            $stage.step4();
        }
        else {
            $stage.reset();
        }
    }());
    $(".steps").eq(0).on("click",function () {
        if ($stage.is('ready')) {
            $stage.step1();
            window.sessionStorage.setItem('stages', "1");
            window.location.href="js-task4-2.html";
        }
        else {
            alert("请按步骤进行游戏");
        }
    });
    $("   .steps").eq(1).on("click",function () {
        if ($stage.is('kill')) {
            alert("请死者表明身份并发言");
            $stage.step2();
            window.sessionStorage.setItem('stages', "2");
        }
        else {
            alert("请按步骤进行游戏");
        }
    });
    $(" .steps").eq(2).on("click",function () {
        if ($stage.is('words')) {
            alert("家依次发言讨论");
            $stage.step3();
            window.sessionStorage.setItem('stages', "3");
        }
        else {
            alert("请按步骤进行游戏");
        }
    });
    $("  .steps").eq(3).on("click",function () {
        if ($stage.is('speech')) {
            $stage.step4();
            window.sessionStorage.setItem('stages', "4");
            window.location.href="js-task4-2.html";
        }
        else {
            alert("请按步骤进行游戏");
        }
    });
    $("#btn1").on("click",function (){
        if(confirm("确认结束游戏？")){
            window.location.href="js-task2.html";
            window.sessionStorage.clear();
        }
    });//结束按钮
    $("#btn2").on("click",function (){
        window.location.href="js-task3-2.html";
        window.sessionStorage.setItem('back', "1");//使法官日志页面出现返回按钮
    });//法官日志
    if(day >1){
        for (var i=0; i<day-1; i++){
            var  days=i +1;
            var num1 =death[i*2]+1;
            var num2 =death[i*2+1]+1;//思路是 i为0时取 0,1 两个值 i为1时取2,3 两个值。
            $("#message").append(' <div  class="day">第'+days+'天\n' +
                '                   <div class="show"> </div>\n' +
                '                   <div class="days">\n' +
                '                   <p > 晚上: '+num1+' 号被杀手杀死，身份是'+Arr[num1-1]+'</p>\n' +
                '                   <p > 白天:'+num2+' 号被全民投票投死，身份是'+Arr[num2-1]+'</p>\n' +
                '                   </div>\n' +
                '                </div>') ;//如果天数大于1输出游戏进程的记录
            $(".show").eq(i).on("click",function (){
                $(this).siblings("div.days").toggle();//展示隐藏内容
            });
        }
    }
});