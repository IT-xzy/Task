
//打乱身份，待分配
var a=JSON.parse(sessionStorage.getItem('k')),
    b=JSON.parse(sessionStorage.getItem('w')),
    c=JSON.parse(sessionStorage.getItem('pNum')),
    playerStatus=[],
    players=[],
    beKillNum=[],//新增被杀组
    beVoteNum=[],//新增被投组
    days=1,
    step="none";
function basic() {
    for(var i=0;i<a;i++) {
        players.push("杀手");
    }
    for (var x=0;x<b;x++){
        players.push("水民");
    }
    for (var m=0;m<c;m++){
        playerStatus[m]={
            role: players[m],
            alive: "yes",
            number: m+1
        };
    }
    while(c){
        var r=Math.floor(Math.random()*c--);
        y=players[c];
        players[c]=players[r];
        players[r]=y;
    }
}
basic();
sessionStorage.setItem("players",JSON.stringify(players));
sessionStorage.setItem("beKillNum",JSON.stringify(beKillNum));
sessionStorage.setItem("beVoteNum",JSON.stringify(beVoteNum));
sessionStorage.setItem("days",JSON.stringify(days));
sessionStorage.setItem("playerStatus",JSON.stringify(playerStatus));
sessionStorage.setItem('step',step);
// 传递身份卡编号,点击切换
var beforeChoice=$('.before_choice');
var afterChoice=$('.after_choice');
var obo =$('.obo');
var view=$('#view');
var post=$('#post');
var postNumber=1;
var viewNumber=1;
var topNumber=1;
obo.on('click',function() {
    if(viewNumber<=players.length){
        if (view.is(':visible')) {
            view.hide();
            post.show();
            beforeChoice.hide();
            afterChoice.show();
            //角色名放入相应卡牌，放在后面会发生错误。
            $('.role').text(players[viewNumber-1]);
            //先后顺序很重要
            ++viewNumber;
            $('#v_num').text(viewNumber);
            ++postNumber;
            $('#p_num').text(postNumber);
        }
        else{
            view.show();
            post.hide();
            beforeChoice.show();
            afterChoice.hide();
            ++topNumber;
            $('.number_top').text(topNumber);
        }
    }
    else{
        // alert("下一步");
        window.location.href="../html/04JudgeViewing.html";
    }
    if(viewNumber===players.length+1){
            post.text("法官查看");
        }
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

