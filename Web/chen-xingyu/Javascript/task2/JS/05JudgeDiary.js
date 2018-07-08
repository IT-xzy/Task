//取得数据
var playerStatus=JSON.parse(sessionStorage.getItem('playerStatus')),
    days=JSON.parse(sessionStorage.getItem('days')),
    beKillNum=JSON.parse(sessionStorage.getItem('beKillNum')),
    beVoteNum=JSON.parse(sessionStorage.getItem('beVoteNum')),
    step=sessionStorage.getItem('step');
//为法官查看页面准备
sessionStorage.setItem('playerStatus',JSON.stringify(playerStatus));
sessionStorage.setItem('beKillNum',JSON.stringify(beKillNum));
sessionStorage.setItem('beVoteNum',JSON.stringify(beVoteNum));
sessionStorage.setItem('days',JSON.stringify(days));
//游戏还能继续时，再加一个循环
$(document).ready(function () {
    $('#date').text(days);
    if(days>1){
        function anotherDay(){
            for(var i=0;i<days-1;i++){
                var writeHtml =
                    "    <div class=\"oneDay\">\n" +
                    "        <div class=\"day\">\n" +
                    "            <div class=\"date\">\n" +
                    "                    第"+(i+1)+ "天\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"happening\">\n" +
                    "            <div class=\"aside\"></div>\n" +
                    "            <div class=\"incidents\">\n" +
                    "                <div id=\"kill\" class=\"incident\">\n" +
                    "                    <img class=\"moon\" src=\"../img/night.png\" alt=\"\">\n" +
                    "                    <a class=\"kill\"><span class=\"triangle-left\"></span>杀手杀人</a>\n" +
                    "                </div>\n" +
                    "                <div class=\"killMsg\">\n" +
                                     beKillNum[beKillNum.length-(i+1)].number  +
                    "                    号被杀手杀死，真实身份是\n" +
                                     beKillNum[beKillNum.length-(i+1)].role +
                    "                </div>\n" +
                    "                <div id=\"deadSpeak\" class=\"incident\">\n" +
                    "                    <img class=\"sun\" src=\"../img/day.png\" alt=\"\">\n" +
                    "                    <a class=\"death\"><span class=\"triangle-left\"></span>亡灵发言</a>\n" +
                    "                </div>\n" +
                    "                <div id=\"aliveSpeak\" class=\"incident\">\n" +
                    "                    <a class=\"aliveSpeak\"><span class=\"triangle-left\"></span>玩家依次发言</a>\n" +
                    "                </div>\n" +
                    "                <div id=\"vote\" class=\"incident\">\n" +
                    "                    <a class=\"vote\"><span class=\"triangle-left\"></span>玩家投票</a>\n" +
                    "                </div>\n" +
                    "                <div class=\"voteMsg\">\n" +
                                         beVoteNum[beVoteNum.length-(i+1)].number +
                    "                    号被投票杀死，真实身份是\n" +
                                         beVoteNum[beVoteNum.length-(i+1)].role   +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n";
                $('.oneDayCopy').before(writeHtml);
                $('.dateCopy .text-center').text("第"+(i+2)+"天");
            }
        }
        anotherDay();
    }
    //点击天数，收起放下
    $('.day').on('click',function () {
    $(this).next().toggle();
    });
    //finite status machine
    var fsm={
        status: sessionStorage.getItem('step'),
        killStep: function(){
            switch(fsm.status) {
                case "none":
                    alert("杀手请杀人");
                    location.href="../html/06killPage.html";
                    // sessionStorage.setItem('step',"killer");
                    break;
                case "dead":
                    alert('请不要重复步骤');
                    break;
                case "speak":
                case "vote" :
                    alert('请遵循游戏步骤');
                    break;
            }
        },
        deadSpeak: function(){
            switch(fsm.status){
                case "dead":
                    alert('请死者亮明身份并发表遗言');
                    fsm.status = "speak";
                    changeColor($('.death'),$('.death .triangle-leftCopy'));
                    break;
                case "speak":
                    alert('请不要重复游戏步骤~~');
                    break;
                case "vote":
                case "none":
                case "killer":
                    alert('请遵循游戏流程');
            }
        },
        aliveSpeak: function () {
            switch(fsm.status){
                case "speak":
                    alert('玩家依次发言');
                    fsm.status="vote";
                    changeColor($('.aliveSpeak'),$('.aliveSpeak .triangle-leftCopy'));
                    break;
                case "vote":
                    alert('不要重复操作');
                    break;
                case "none":
                case "killer":
                case "dead":
                    alert('请遵循游戏流程');
            }
        },
        voteStep: function () {
            switch(fsm.status){
                case "vote":
                    location.href="../html/06killPage.html";
                    sessionStorage.setItem('step',"vote");
                    fsm.status="none";
                    break;
                case "none":
                case "killer":
                case "dead":
                case "speak":
                   alert('请遵循游戏流程');
            }
        }
    };
    //点击杀手杀人
    var step=fsm.status;
    $('.incidentCopy .kill').on('click',function () {
        fsm.killStep();
        sessionStorage.setItem('step',"dead");
    });
    //点击亡灵发言
    $('.incidentCopy .death').on('click',function () {
        fsm.deadSpeak();
        sessionStorage.setItem('step',"speak");
    });
    //剩余玩家发言
    $('.incidentCopy .aliveSpeak').on('click',function () {
        fsm.aliveSpeak();
        sessionStorage.setItem('step',"vote");
    });
    //剩余玩家投票
    $('.incidentCopy .vote').on('click',function () {
        fsm.voteStep();
    });
    //设置当前天数游戏步骤提示及变色
    switch(step){
        case "dead":
            var i=days-1;
            changeColor($('.kill'),$('.kill .triangle-leftCopy'));
            $('.killMsgCopy').text(beKillNum[beKillNum.length-(1+i)].number+"号被杀死，真实身份是"+beKillNum[beKillNum.length-(1+i)].role).show();
            break;
        case "speak":
            i=days-1;
            changeColor($('.kill'),$('.kill .triangle-leftCopy'));
            $('.killMsgCopy').text(beKillNum[beKillNum.length-(1+i)].number+"号被杀死，真实身份是"+beKillNum[beKillNum.length-(1+i)].role).show();
            changeColor($('.death'),$('.death .triangle-leftCopy'));
            break;
        case "vote":
            i=days-1;
            changeColor($('.kill'),$('.kill .triangle-leftCopy'));
            $('.killMsgCopy').text(beKillNum[beKillNum.length-(1+i)].number+"号被杀死，真实身份是"+beKillNum[beKillNum.length-(1+i)].role).show();
            changeColor($('.death'),$('.death .triangle-leftCopy'));
            changeColor($('.aliveSpeak'),$('.aliveSpeak .triangle-leftCopy'));
            break;
    }
    //变色函数
    function changeColor(a,b){
        a.css({
            'backgroundColor':'#83b09a',
            'borderColor':'#83b09a'
        });
        b.css('borderRightColor','#83b09a');
    }
    //底部按钮
    $('.over').on('click',function(){
        location.href="../html/01member_setting.html";
        sessionStorage.clear()
    });
    $('.watch').on('click',function(){
        location.href="../html/04JudgeViewing.html";
    });
    //返回按钮
    var back=document.getElementById("return");
    back.onclick=function(){
        var ggsddu=confirm("确定返回玩家设置页吗？");
        if(ggsddu===true){
            window.location.href="../html/02member_setting.html";
            sessionStorage.clear();
        }
        else{
            return null;
        }
    };
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
    //关闭按钮
    var close=document.getElementById("close");
    close.onclick=function(){
        var ggsddu=confirm("确定返回版本选择页吗？");
        if(ggsddu===true){
            window.location.href="../html/01version_page.html";
            sessionStorage.clear();
        }
        else{
            return null;
        }
    };
});




