//返回
function Back(){
    var a = confirm("退回到上一页？");
    if(a == true){
        sessionStorage.clear();
        window.location.href = "task-2.html";
    }
}
//结束游戏
function Off(){
    var b = confirm("是否结束本轮游戏？");
    if (b == true) {
        sessionStorage.clear();
        window.location.href = "zhuoyou.html";
    }
}
//传递的玩家人数
var Num=sessionStorage.getItem("Num");
//传递的身份数组
var playerpeople = JSON.parse(sessionStorage.getItem("playerpeople"));
//传递的水民词汇
var civword =sessionStorage.getItem("civword");
//传递的杀手词汇
var killword = sessionStorage.getItem("killword");
//console.log(Num);
// console.log(civword);
// console.log(killword);
console.log(playerpeople);

var x = 0;
var y = 0;
var z = 2;
// 序号
$("#Number").html(z-1);
$("#btm2").css("display","none");
$("#flop").css("display","none");
$(document).ready(function(){
    $("button").click(function(){
        $("#btm1").toggle();
        $("#btm2").toggle();
        $("#cir1").toggle();
        $("#flop").toggle();
        //结束
        if (y<Num) {
            //第一次点击
            if (x == 0) {
                //角色身份
                $("#role").html(playerpeople[y]);
                //更改文字
                $("#btm2").html("隐藏并传递给" + z + "号");
                //角色词组
                word();
                y++;
                if (y == Num) {
                    $("#btm2").html("法官日记");
                }
                //第二次点击
                x = 1;
            }
            else {
                //更改身份
                $("#role").html("");
                //更改按钮内容
                $("#btm1").html("看看" + z + "号是谁");
                //更改顶部数字
                $("#Number").html(z);
                //增加每次点击显示的数字
                z++;
                //还原为第一次点击
                x = 0;
            }
            console.log(playerpeople);
        }
        else {
            sessionStorage.playerpeople=JSON.stringify(playerpeople);
            window.location.href = "judgenote.html";
        }
    })
});
function word() {
    if(playerpeople[y] == "平民"){
        $("#word").html(civword);
    }
    else{
        $("#word").html(killword);
    }
}