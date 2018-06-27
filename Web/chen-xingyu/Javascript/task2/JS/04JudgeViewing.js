//添加html元素,添加玩家状态
var players=JSON.parse(sessionStorage.getItem('players')),
    playerStatus=JSON.parse(sessionStorage.getItem('playerStatus')),
    beKillNum = JSON.parse(sessionStorage.getItem("beKillNum")),
    beVoteNum = JSON.parse(sessionStorage.getItem("beVoteNum")),
    days = JSON.parse(sessionStorage.getItem("days")),
    step=sessionStorage.getItem('step');
//法官查看界面卡片背景设置
$(document).ready(function () {
    if(step){
        for (var i = 0; i < playerStatus.length; i++) {
            if (playerStatus[i].alive === "no") {
                $(".role").eq(i).css('backgroundColor', '#83b09a');
            }
        }
    }
});
// if(step==="dead"||step==="none"){
//     for (var i = 0; i < playerStatus.length; i++) {
//         if (playerStatus[i].alive === "no") {
//             $(".role").eq(i).css('backgroundColor', '#83b09a');
//         }
//     }
// }
//储存数据
sessionStorage.setItem('days',JSON.stringify(days));
sessionStorage.setItem('beVoteNum',JSON.stringify(beVoteNum));
sessionStorage.setItem('beKillNum',JSON.stringify(beKillNum));
sessionStorage.setItem('step',step);
function separate(){
    var i;
    for(i=0;i<players.length;i++){
        var num=i+1;
        var gridHtml =
            "<div class=\"grid\">" +
            "<div class=\"item\">" +
            "<div class=\"role\">" +
            players[i]+
            "</div>" +
            "<div class=\"number\">" +
            num+
            " 号</div>" +
            " </div>" +
            " </div>";
        $('main').append(gridHtml);
        // playerStatus[i]={
        //     role: players[i],
        //     alive: "yes",
        //     number: i+1
        // };
    }
}
separate();
//开始游戏
var playNow=$('#playNow');
playNow.on('click',function(){
    window.location.href='../html/05JudgeDiary.html';
});
//返回按钮
var back=document.getElementById("return");
back.onclick=function(){
    var ggsddu=confirm("确定返回玩家设置页吗？");
    if(ggsddu===true){
        window.location.href="../html/02member_setting.html";
    }
    else{
        return null;
    }
};
// 按 Esc要做的事情
document.onkeydown=function(event){
    var tip = event || window.event || arguments.callee.caller.arguments[0];
    if(tip && tip.keyCode===27){
        var revert=confirm("确定要返回玩家设置页么？");
        if(revert===true){
            window.location.href="../html/01version_page.html";
        }
        else {
            return null;
        }
    }
};
//关闭按钮
var close=document.getElementById("close");
close.onclick=function(){
    var ggsddu=confirm("确定返回版本选择页吗？");
    if(ggsddu===true){
        window.location.href="../html/01version_page.html";
    }
    else{
        return null;
    }
};