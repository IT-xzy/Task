$(document).ready(function () {
    var Arr=JSON.parse(sessionStorage.getItem("Arr"));
    var death=JSON.parse(sessionStorage.getItem("death"));
    var win=JSON.parse(sessionStorage.getItem("win"));
    var killer=JSON.parse(sessionStorage.getItem("killer"));
    var people=JSON.parse(sessionStorage.getItem("people"));
    var day=JSON.parse(sessionStorage.getItem("day"));
    var remove=JSON.parse(sessionStorage.getItem("remove"));
    console.log(Arr);
    console.log("死亡玩家在Arr中的序号:",death);
    console.log("killer",killer);
    console.log("people",people);
    console.log("winner:",win);
    console.log("day:" ,day);
    if (win === "killer"){
        $("#kwin").css("display","inline-block")//杀手胜利时显示此图片
    }
    if (win === "people"){
        $("#pwin").css("display","inline-block")//平民胜利时显示此图片
    }
    $("#daynum").text(day);
    $("#killernum").text(killer);
    $("#peoplenum").text(people);
    for (var i=0; i<day; i++){
        var  days=i +1;
        var num1 =death[i*2]+1;
        var num2 =death[i*2+1]+1;
        $("main").append(' <div  class="details">\n' +
            '                  <div class="day ">第 '+days+'天</div>\n' +
            '                   <div class="day"> 晚上: '+num1+' 号被杀手杀死，身份是'+Arr[num1-1]+'</div>\n' +
            '                   <div class="day dayremove"> 白天:'+num2+' 号被全民投票投死，身份是'+Arr[num2-1]+'</div>\n' +
            '                </div>')//输出游戏进程的记录
    }
    if ( remove === 1) {
        $(".dayremove").last().css("display","none")//晚上杀手胜利时，用来移除结果页面白天的信息
    }
    $("#again").on("click",function (){
            window.location.href="js-task2.html";
            window.sessionStorage.clear();
    });//再来一局
});
