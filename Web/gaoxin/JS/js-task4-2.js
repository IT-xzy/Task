$(document).ready(function () {
    var Arr=JSON.parse(sessionStorage.getItem("Arr"));
    var killer=JSON.parse(sessionStorage.getItem("killer"));
    var people=JSON.parse(sessionStorage.getItem("people"));
    var stages=JSON.parse(sessionStorage.getItem("stages"));
    var day=JSON.parse(sessionStorage.getItem("day"));//获取之前的数据
    var death = [];
    var deathnum;
    var deathtest=JSON.parse(sessionStorage.getItem("death"));
   if (deathtest  !== null){
       death =deathtest;
   }//如果deathtest不是空的，赋值给death
    console.log(Arr);console.log("死亡玩家在Arr中的序号:",death);console.log("killer",killer);console.log("people",people);console.log("stages:" ,stages);console.log("day:" ,day);
   if(stages===1){
       $("#title1").text("杀手杀人");
       $("#title2").text("杀手杀人");
       $("#title3").text("杀手请睁眼，杀手请选择要杀的对象");
       $("#title4").text("点击下方玩家头像，对被杀的玩家进行标记");
   }
    if(stages===4){
        $("#title1").text("投票");
        $("#title2").text("投票");
        $("#title3").text("请玩家投票，选择被投出局的对象");
        $("#title4").text("点击下方玩家头像，对投票出局的玩家进行标记");
    }
    $("#close").on("click", function () {
        if (confirm("确认关闭？")) {
            window.close();
        }
    });// 关闭按钮
    (function(){
        for (var i=0; i<Arr.length; i++){
            $("#main").append(' <div  class="block click">\n' +
                '                  <div class="block1">\n' +
                '                    <div class="title"> ' + Arr[i] + '</div>\n' +
                '                    <div class="number" >' + (i+1) + '</div>\n' +
                '                </div>\n' +
                '                </div>');//生成玩家信息
                if (Arr[i] === "杀手" && stages===1) {
                $(".click").eq(i).on("click", function () {
                    window.alert("不能杀自己人");
                });//点杀手弹出提示框
                 }
                 else {
                    $(".click").eq(i).on("click", function () {
                      $(this).siblings(".click").css("opacity","1");
                      $(this).css("opacity","0.5");
                       deathnum =$(this).index();//死亡玩家序号
                      console.log(" kill",deathnum,"?");
                    });
            }
        }//遍历添加事件
        if(death  !== null){
            for (i=0;i<death.length;i++){
                $(".block").eq(death[i]) .unbind();
                $("  .block").eq(death[i]) .removeClass("click");
                $(" .block").eq(death[i]) .css("opacity","0.5");//死亡玩家事件移除及变色
            }
        }
    }());
    $("#confirm").on("click", function () {
        if (deathnum !== undefined) {
            death.push(deathnum);//将死亡玩家序号保存在数组里面
            console.log(death);console.log(Arr[deathnum]);
            if  (Arr[deathnum] === "杀手"){
                killer =killer -1 ;//存活杀手-1
            }
            else {
                people=people-1;//存活平民-1
            }
            sessionStorage.setItem("death", JSON.stringify(death));
            sessionStorage.setItem("killer", JSON.stringify(killer));
            sessionStorage.setItem("people", JSON.stringify(people));
            if(stages===1){
                window.sessionStorage.setItem('stages', "1");//返回法官页面时有限状态机状态为1
            }
            if(stages===4){
                window.sessionStorage.setItem('stages', "0");//返回法官页面时有限状态机状态重置
                day = day +1 ;//天数+1
                window.sessionStorage.setItem('day', day);
            }
            window.location.href="js-task4-1.html";
            if ( killer === people) {
                window.location.href="js-task4-3.html";
                window.sessionStorage.setItem("win", JSON.stringify("killer"));//杀手胜利
                if(stages===1) {
                    window.sessionStorage.setItem('day', day);
                    window.sessionStorage.setItem('remove', "1");//晚上杀手胜利，用来移除结果页面白天的信息
                }
                else {
                    day = day -1 ;
                    window.sessionStorage.setItem('day', day);//游戏结束天数不需要再+1
                }
            }
            if( killer <= 0){
                window.location.href="js-task4-3.html";
                window.sessionStorage.setItem("win", JSON.stringify("people"));//平民胜利
                day = day -1 ;
                window.sessionStorage.setItem('day', day);
            }
        }
        else {
            alert("请选择一位玩家") //不选择玩家不让走
        }
    });
});