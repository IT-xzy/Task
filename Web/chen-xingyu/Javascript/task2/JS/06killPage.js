$(document).ready(function () {
    //导入储存的数据
    var k = JSON.parse(sessionStorage.getItem('k')),//杀手数
        w = JSON.parse(sessionStorage.getItem('w')),//水民数
        pNum = JSON.parse(sessionStorage.getItem('pNum')),//玩家数
        playerStatus = JSON.parse(sessionStorage.getItem('playerStatus')),      //玩家状态数组
        days = JSON.parse(sessionStorage.getItem('days')),//游戏天数
        select = 0,//选择标识
        index, //下标
        beKillNum = JSON.parse(sessionStorage.getItem("beKillNum")),
        beVoteNum = JSON.parse(sessionStorage.getItem("beVoteNum")),
        step = sessionStorage.getItem('step');//游戏所在的状态
    //顶部提示语
    if (step === "vote") {
        $('.caseTitle').text("玩家投票");
        $('.lightTip').text("发言讨论结束，大家请投票");
        $('.deepTipInner').text("点击得票数最多的人的头像");
    }
    //导入玩家角色
    function separate() {
        var i;
        for (i = 0; i < playerStatus.length; i++) {
            var gridHtml = "<div class=\"grid\">\n" +
                "        <div class=\"item\">\n" +
                "            <div class=\"role\">\n" +
                playerStatus[i].role +
                "            </div>\n" +
                "            <div class=\"number\">\n" +
                "\n" +
                playerStatus[i].number +
                "            号</div>\n" +
                "        </div>\n" +
                "<div class=\"knife\">\n" +
                "        <img src=\"../img/kill.png\" alt=\"\">\n" +
                "    </div>" +
                "    </div>";
            $('main').append(gridHtml);
            if (playerStatus[i].alive === "no") {
                $(".grid:eq(i) ").find('.role').css('background-color', '##83b09a');
            }
        }
    }
    separate();
    //死者卡片背景变色
    for (var i = 0; i < playerStatus.length; i++) {
        if (playerStatus[i].alive === "no") {
            $(".role").eq(i).css('backgroundColor', '#83b09a');
        }
    }
    //点击角色卡牌,出现匕首
    $('.grid').on('click', function () {
        $('.knife').css('visibility', 'hidden');
        $(this).find('.knife').css('visibility', 'visible');
        index = $(this).index();
        sessionStorage.setItem('index', JSON.stringify(index));//被选玩家的卡牌索引值
        select = 1;
    });
    //点击底部确认按钮
    $('#certain').on('click', function () {
        if (select === 0) {
            alert("必须选择一个玩家");
            return null;
        }
        if (select === 1) {
            if (step === "dead") {//杀人步骤进来的
                if (playerStatus[index].role === "杀手") {
                    alert("大哥，自己人啊~~");
                    return null;
                }
                if (playerStatus[index].alive === "no") {
                    alert("请不要鞭尸~~");
                    return null;
                }
                if (playerStatus[index].alive === "yes" && playerStatus[index].role === "水民") {
                    playerStatus[index].alive = "no";
                    beKillNum.unshift(playerStatus[index]);
                    sessionStorage.setItem('beKillNum', JSON.stringify(beKillNum));
                    sessionStorage.setItem('playerStatus', JSON.stringify(playerStatus));
                    sessionStorage.setItem('step', "dead");
                    sessionStorage.setItem('days', JSON.stringify(days));
                    pNum--;
                    w--;
                    sessionStorage.setItem('w', JSON.stringify(w));
                    sessionStorage.setItem('pNum', JSON.stringify(pNum));
                    if (k >= w) {
                        alert('杀手胜利');
                        location.href = "../html/07result.html";
                    }
                    else {
                        location.href = "../html/05JudgeDiary.html";
                    }
                }
            }
            if (step === "vote") {//投票步骤进来的
                if (playerStatus[index].alive === "no"){
                    alert("请不要鞭尸~~");
                    return null;
                }
                if (playerStatus[index].alive === "yes") {
                    playerStatus[index].alive = "no";
                    beVoteNum.unshift(playerStatus[index]);
                    pNum--;
                    sessionStorage.setItem('beVoteNum', JSON.stringify(beVoteNum));
                    sessionStorage.setItem('playerStatus', JSON.stringify(playerStatus));
                    sessionStorage.setItem('pNum', JSON.stringify(pNum));
                    sessionStorage.setItem('step', "none");
                    var role = playerStatus[index].role;
                    if (role === "杀手") {
                        k--;
                        sessionStorage.setItem('k', JSON.stringify(k));
                    }
                    if (role === "水民") {
                        w--;
                        sessionStorage.setItem('w', JSON.stringify(w));
                    }
                    if (k >= w) {
                        alert('杀手胜利');
                        location.href = "../html/07result.html";
                    }
                    if (k < w) {
                        if (k === 0) {
                            alert('水民胜利');
                            location.href = "../html/07result.html";
                        }
                        else {
                            alert("新的一天");
                            location.href = "../html/05JudgeDiary.html";
                            days++;
                            sessionStorage.setItem('days', JSON.stringify(days));
                        }
                    }
                }
            }
        }
    });
    //以上为确认按钮点击事件
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




