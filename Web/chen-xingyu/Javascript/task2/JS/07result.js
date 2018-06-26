//数据引入
var k=parseInt(sessionStorage.getItem('k')),//剩余杀手数
    w=parseInt(sessionStorage.getItem('w')),//剩余水民数
    days=parseInt(sessionStorage.getItem('days')),//游戏天数
    beKillNum=JSON.parse(sessionStorage.getItem('beKillNum')),//被杀数组
    beVoteNum=JSON.parse(sessionStorage.getItem('beVoteNum')),//被投数组
    step=sessionStorage.getItem('step');
//胜方
if(k===0){
    $('.winner').text("水民胜利");
}
else{
    $('.winner').text("杀手胜利");
}
//剩余玩家
$('.killerAlive').text("杀手："+k+"人");
$('.waterAlive').text("水民："+w+"人");
//内容填充
function help(){
    for(var i=0;i<days;i++){
        var lastHtml;
        var kNum=beKillNum[beKillNum.length-1-i].number,
            kRole=beKillNum[beKillNum.length-1-i].role;
        if(!beVoteNum[i]){//杀人页过来的,没有投票
            lastHtml="<div class=\"date\">\n" +
                "            <div class=\"dayCount\"></div>\n" +
                "第"+(i+1)+"天"+
                "            <div class=\"light\"></div>\n" +
                "晚上"+kNum+"号被杀手杀死，真实身份是"+kRole+
                "        </div>";
        }
        else{//投票页过来的
            var vNum=beVoteNum[beVoteNum.length-1-i].number,
                vRole=beVoteNum[beVoteNum.length-1-i].role;
            lastHtml=" <div class=\"date\">\n" +
                "            <div class=\"dayCount\">" +
                "第"+(i+1)+"天"+
                "</div>\n" +
                "            <div class=\"light\">" +
                "晚上"+kNum+"号被杀手杀死，真实身份是"+kRole+
                "</div>\n" +
                "            <div class=\"day\"></div>\n" +
                "白天"+vNum+"号被投票杀死，真实身份是"+vRole+
                "        </div>";
        }
        $('.detail').append(lastHtml);
    }
}
help();
//房子按钮
$('.home').on('click',function(){
    location.href="../html/01version_page.html";
    sessionStorage.clear()
})
//再来一局
$('.again').on('click',function(){
    location.href="../html/02member_setting.html";
    sessionStorage.clear()
});
// $('.again').click(
//     location.href="../html/02member_setting.html",
//     sessionStorage.clear()
// );

//按 Esc要做的事情
document.onkeydown=function(event){
    var tip = event || window.event || arguments.callee.caller.arguments[0];
    if(tip && tip.keyCode===27){
        var revert=confirm("确定要返回玩家设置页么？");
        if(revert===true){
            window.location.href="../html/01version_page.html";
            sessionStorage.clear();
        }
        else {
            return null;
        }
    }
};
