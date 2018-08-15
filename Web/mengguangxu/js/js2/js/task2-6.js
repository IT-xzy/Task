
    var newId;//装被选中的玩家的身份
    var newState;//装被选中玩家的生死状态
    var a;//储存被选中盒子的下标
    var theStatus;
    var pitch = 0;//选中，是否选中盒子，选中盒子了pitch=1
    var sixStep;//用来区分是以杀人页面胜利跳去结果页投票页面胜利跳去结果页
    var day;

    var player = JSON.parse(sessionStorage.getItem('player'));//取出总玩家人数数组
    console.log(player);
    var playerStates = JSON.parse(sessionStorage.getItem('playerStates'));//取出玩家的状态：身份、生死、编号
    console.log(playerStates);
    var people = JSON.parse(sessionStorage.getItem('people'));//取出平民玩家的数量
    console.log(people);
    var killer = JSON.parse(sessionStorage.getItem('killer'));//取出平民玩家的数量
    console.log(killer);
    var beKiller = JSON.parse(sessionStorage.getItem('beKiller'));//取出被杀的玩家
    console.log(beKiller);
    var beVote = JSON.parse(sessionStorage.getItem('beVote'));//取出被投死的玩家
    console.log(beVote);
    var days = JSON.parse(sessionStorage.getItem('days'));//获取天数
    console.log(days);
/////////////////////////////////////////////////////////////////////////////////////////////
    var getSet = sessionStorage.getItem('sate');//获取传过来的状态
    console.log(getSet);
    var sate;//储存更改后的状态
    if (getSet === 'ghost'){//表示从杀手杀人路径来的
        $('#title').text('杀手杀人');
        $('#sentence').text('杀手请睁眼，杀手请选择要杀的对象');
        $('.word').text('点击下方玩家头像，对被杀的玩家进行标记');
        $('.main-bottom').text('杀人');
        getSet = 'ghost';//状态变为发表遗言
        sessionStorage.setItem('sate',getSet);
    }else if (getSet === 'kill'){//表示从投票页来的
        $('#title').text('全民投票');
        $('#sentence').text('发言讨论结束，大家请投票');
        $('.word').text('点击得票数最多人的头像');
        $('.main-bottom').text('投票');
        getSet = 'kill';
        sessionStorage.setItem('sate',getSet);
    }


/////////////////////////////////////////////////////////////////////////////////////////////

    for (var i = 0; i < player.length; i++) {//遍历数组，有几个玩家就循环几次，把所有玩家都遍历出来
        var num = i + 1;//每个角色对应的号码
        var inBox = '<div class=\"content-box\">\n' +//var个变量存储写进文档的标签代码，记住要转义字符
            '<div class=\"content-top\">\n' +
            '<div class=\"career\">\n' + player[i] +
            '</div>\n' +
            '<div class=\"number\">\n' + num +
            '</div>\n' +
            '</div>\n' +
            '<div class=\"content-bottom\">\n' +
            '</div>\n' +
            '</div>';
        $('.main-box').append(inBox);//通过append将盒子一个一个的往文档里面装
        theStatus = (playerStates[i].state);//根据上面的遍历，遍历出每一个角色的状态，用theStatus来储存，假如遍历到的这个角色状态是死，则这个角色的颜色改变
        console.log(theStatus);
        if (theStatus === 'death'){
           $('.career').eq(i).css('backgroundColor','#83B09A');
        }else if (theStatus === 'live'){
            $('.career').eq(i).css('backgroundColor','#f9b247');
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////
    //点击选中玩家
    $('.content-box').on('click',function(){//点击盒子

        a = $(this).index();//var个变量来获取盒子的下标
        console.log(a);
        newId = playerStates[a].id;//单独显示玩家身份，没有状态和编号
        console.log(newId);
        newState = playerStates[a].state;//单独显示玩家生死状态，没有身份和编号
        console.log(newState);
        var choice = $('.content-bottom');//var个变量获取全部的隐藏图标盒子
        choice.css('visibility','hidden');//每点击一个盒子之后，再次点击前所有小图标都会隐藏
        $(choice[a]).css('visibility','visible');//通过数组下标选择单个小图标显示
        pitch = 1;//已选中玩家
    });
////////////////////////////////////////////////////////////////////////////////////////////////
    //点击确认按钮
    $('#bt').click(function () {
        if(pitch === 1){
            if(newState === 'live'){
                if(getSet === 'ghost'){
                    if(newId === '杀手'){
                        alert('兄嘚不要自相残杀好不！')
                    }else if(newId === '平民') {
                        var c = confirm('确定要杀死他？');
                        if (c === true) {
                            var x = people--;//平民人数减少
                            sessionStorage.setItem('people', JSON.stringify(people));//保存平民人数
                            console.log(x);
                            playerStates[a].state = 'death';//改变选中玩家的状态
                            sessionStorage.setItem('playerStates', JSON.stringify(playerStates));
                            console.log(playerStates);
                            beKiller.push(playerStates[a]);//被杀的玩家放进beKiller数组
                            console.log(beKiller);
                            sessionStorage.setItem('beKiller', JSON.stringify(beKiller));//保存储存被杀者的数组
                            if (people <= killer) {
                                days++; // 如果从杀人页面直接跳转到结果界面时天数要加1天
                                sessionStorage.setItem("days", JSON.stringify(days));
                                sixStep = 'kill';
                                sessionStorage.setItem('sixStep',JSON.stringify(sixStep));
                                alert("杀手胜利");
                                location.href = "../html/task2-8.html";
                            } else {
                                location.href = "../html/task2-5.html";
                            }
                        }
                    }
                }else if(getSet === 'kill'){
                    var b = confirm('确定投死他吗');
                    if(b === true){
                        playerStates[a].state = 'death';//改变选中玩家的状态
                        sessionStorage.setItem('playerStates', JSON.stringify(playerStates));//储存玩家状态
                        beVote.push(playerStates[a]);//被投死的玩家放进beVote数组
                        sessionStorage.setItem('beVote', JSON.stringify(beVote));//保存储存被投死的数组
                        if(newId === '杀手'){
                            killer--;
                            sessionStorage.setItem('killer', JSON.stringify(killer));//保存杀手人数
                            if(killer === 0){
                                alert ('平民胜利');
                                days++;
                                sessionStorage.setItem('days', JSON.stringify(days));
                                sixStep = 'vote';
                                sessionStorage.setItem('sixStep',JSON.stringify(sixStep));
                                location.href = "../html/task2-8.html";
                            }else{
                                day = days+1;
                                sessionStorage.setItem('days', JSON.stringify(day));
                                location.href = '../html/task2-5.html';
                            }
                        }else if(newId === '平民'){
                            people--;
                            sessionStorage.setItem('people', JSON.stringify(people));//保存平民人数
                            if(killer === people){
                                alert('杀手胜利');
                                days++;
                                sessionStorage.setItem('days', JSON.stringify(days));
                                sixStep = 'vote';
                                sessionStorage.setItem('sixStep',JSON.stringify(sixStep));
                                location.href = "../html/task2-8.html";
                            }else{
                                day = days+1;
                                sessionStorage.setItem('days', JSON.stringify(day));
                                location.href = '../html/task2-5.html';
                            }
                        }else{
                            day = days+1;
                            sessionStorage.setItem('days', JSON.stringify(day));
                            location.href = '../html/task2-5.html';
                        }
                    }
                }
            }else {
                alert('玩家已经死亡')
            }
        }else {
            alert('兄嘚杀个人再走喽');
        }
    });


    //////////////////////////////////////////////////////////////////////////////////////////////////
    $('.back-arrow').click(function () {
        var i = confirm('确定要返回角色页面吗？');
        if (i === true) {
            location.href = '../html/task2-3.html';
        }
    });
    $('.close').click(function () {
        var i = confirm('确定要返回首页吗？');
        if (i === true) {
            sessionStorage.clear();
            location.href = '../html/task2-1.html';
        }
    });

