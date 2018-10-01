$(document).ready(function () {
    var little = document.getElementsByClassName('little-box')[0]; //获取身份牌小盒子
    var people = document.getElementsByClassName('people'); //获取身份节点
    var order = document.getElementsByClassName('order'); //获取序列号节点
    var identity = JSON.parse(localStorage.getItem("key")); //获取存储的身份数组数据
    var knife = document.getElementsByClassName("knife"); //获取小刀图片节点
    // console.log(identity);
    $(".little-box").remove(); //删除原身份盒子
    //动态生成身份牌
    for (var i = 0; i < identity.length; i++) { //动态添加身份牌节点
        var clone = little.cloneNode(true); //复制身份牌
        $(".big-box").append(clone); //添加身份牌
        people[i].innerHTML = identity[i]; //添加身份文字
        order[i].innerHTML = i + 1 + "号"; //添加序列号
    };
    //点击身份牌系列事件
    var step = localStorage.getItem('steps'); //获取步骤页面存储的步骤状态
    // console.log(step);
    var allPlayers = JSON.parse(localStorage.getItem('allP')); //获取储存的所有人序列号和对应身份和状态
    console.log(allPlayers)
    if (step === 'killer') { //根据步骤改变标题和按钮文字
        $('.title').text('杀手杀人');
        $('#go').text('杀死');
        $(".main-top").text("杀手请睁眼，杀手请选择要杀的对象");
        $(".advice").text("点击下方玩家头像，对被杀的玩家进行标记");
    } else {
        $('.title').text('全民投票');
        $('#go').text('投死');
        $(".main-top").text("发言讨论结束，请大家投票");
        $(".advice").text("点击得票数最多的人的头像");
    }
    var allPeople = document.getElementsByClassName('yellow-box'); //获取身份牌节点
    for (var e = 0; e < identity.length; e++) {
        if (allPlayers[e].state === 0) { //如果为死亡则背景颜色改变
            allPeople[e].style.backgroundColor = "#83b09a";
        }
    };
   console.log(allPeople)
    var lastSelect; //设置变量，为上次点击，存储上次点击的身份牌索引
    for (var k = 0; k < identity.length; k++) {
        allPeople[k].index = k; //为每个身份牌分配索引
        $(allPeople[k]).on("click", function () { //身份牌点击事件
            var died = this.index; //为变量died为赋值当前点击的身份牌的索引
            if (step === 'killer') { //如果是杀手杀人步骤
                if (died !== null) { //如果索引不是空
                    localStorage.setItem('deathNums', died); //存储点击的身份牌的身份索引
                    // console.log(died + "点击的索引");
                };
                if (allPlayers[this.index].status === '杀手' && indexArray === undefined) { //如果点击活的杀手
                    ask("visible", "27vh auto"); //弹窗
                    $("#text").text("你是杀手不能杀死本职业，请选择其他玩家杀死");
                } else if (indexArray && indexArray.indexOf(died.toString()) >= 0) { //如果点击了死人
                    ask("visible", "27vh auto"); //弹窗
                    $("#text").text("当前玩家已死亡，请选择其他玩家");
                } else if (indexArray && allPlayers[this.index].status === '杀手' && indexArray.indexOf(died.toString()) < 0) { //如果点击活的杀手
                    ask("visible", "27vh auto"); //弹窗
                    $("#text").text("你是杀手不能杀死本职业，请选择其他玩家杀死");
                } else { //如果点击活平民
                    if (allPlayers[this.index].state === 0) { //如果重复点击平民身份牌则弹窗
                        ask("visible", "27vh auto"); //弹窗
                        $("#text").text("请不要重复点击，如果确定选择该玩家请点击杀死");
                    } else { //如果不是重复点击而是点击另一个平民身份牌
                        $(allPeople[this.index]).css('background-color', '#83b09a'); //点击变色
                        $(knife[this.index]).css("display", "block");
                        allPlayers[this.index].state = 0; //状态变为死亡
                        if (lastSelect !== undefined) { //如果上次点击了身份牌,则上次点击的身份牌
                            $(knife[lastSelect]).css("display", "none");
                            $(allPeople[lastSelect]).css('background-color', '#f5c97b'); //颜色恢复
                            allPlayers[lastSelect].state = 1; //变为存活
                        };
                        lastSelect = this.index; //为上次点击变量赋值本次点击的身份牌的索引
                    };
                };
            } else { //如果是全民投票步骤
                // console.log(died + "点击的索引");
                localStorage.setItem('deathNums2', died); //存储点击的身份牌的身份索引
                if (indexArray && indexArray.indexOf(died.toString()) >= 0) { //如果点击了死人
                    ask("visible", "27vh auto"); //弹窗
                    $("#text").text("当前玩家已死亡，请选择其他玩家");
                } else { //如果点击活人
                    if (allPlayers[this.index].state === 0) { //如果重复点击身份牌则弹窗
                        ask("visible", "27vh auto"); //弹窗
                        $("#text").text("请不要重复点击，如果确定选择该玩家请点击投死");
                    } else { //如果不是重复点击而是点击另一个平民身份牌，
                        $(allPeople[this.index]).css('background-color', '#83b09a'); //点击变色
                        $(knife[this.index]).css("display", "block");
                        allPlayers[this.index].state = 0; //状态变为死亡
                        if (lastSelect !== undefined) { //如果上次点击了身份牌,则上次点击的身份牌
                            $(knife[lastSelect]).css("display", "none");
                            $(allPeople[lastSelect]).css('background-color', '#f5c97b'); //颜色恢复
                            allPlayers[lastSelect].state = 1; //变为存活
                        };
                        lastSelect = this.index; //为上次点击变量赋值本次点击的身份牌的索引
                    };
                };
            };
        });
    };
    // console.log(allPlayers);

    var w = JSON.parse(localStorage.getItem('dieNum')); //获取存储的杀手杀死的死亡索引数组
    var u = JSON.parse(localStorage.getItem('dieNum2')); //获取存储的投票投死的死亡索引数组
    if (w !== null || u !== null) {
        var indexArray = w.concat(u) //创建一个数组为杀死和投死合并
    }
    // console.log(w, u)
    // console.log(indexArray)
    var day = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二", "十三", "十四"] //创建所有天数数组
    //底部按钮点击事件
    $('#go').on("click", function () { //底部按钮点击事件
        localStorage.setItem('allP', JSON.stringify(allPlayers)); //存储点击后的身份数据，即几号什么身份被杀死了
        var q = localStorage.getItem('deathNums'); //获取点击的身份牌的身份索引，赋值给变量q
        var p = localStorage.getItem('deathNums2'); //获取点击的身份牌的身份索引，赋值给变量p
        // console.log(q, p);
        var dieNum; //声明一个死亡索引变量
        var dieNum2; //声明一个死亡索引变量
        var knumber = 0; //杀死人数
        var pnumber = 0; //平民人数
        var resault; //结果
        for (var n = 0; n < identity.length; n++) { //循环，获取杀手和平民的剩余人数
            if (allPlayers[n].state === 1) { //如果为存活状态
                if (allPlayers[n].status === '杀手') { //如果是杀手
                    knumber++; //杀手人数加1
                } else { //如果是平民
                    pnumber++; //平民人数加1
                };
            };
        };
        var Num = JSON.parse(localStorage.getItem("num")); //获取步骤页面的变量num数据赋值给Num
        if (lastSelect === undefined && step === 'killer') { //如果没点击身份牌
            ask("visible", "27vh auto"); //弹窗
            $("#text").text("请选择玩家");
        } else if (lastSelect === undefined && step === 'vote') {
            ask("visible", "27vh auto"); //弹窗
            text.innerHTML = "请先选择要操作的玩家";
        } else { //如果点击了
            if (step === 'killer') { //如果是杀手杀人步骤进入的
                if (w === null) { //如果w数组是空
                    dieNum = new Array(0); //创建一个空数组赋值给变量dieNum，长度为0，用来存储身份索引
                    if (q !== null) { //如果q不是空，即有身份索引
                        dieNum.push(q); //数组中添加索引。
                    };
                    localStorage.setItem('dieNum', JSON.stringify(dieNum)); //存储数组
                } else { //如果w数组不是空
                    dieNum = w; //w数组赋值给死亡索引变量
                    if (q !== null && dieNum.indexOf(q) < 0) { //如果身份牌索引不是空且死亡索引数组里没有本次点击的身份索引
                        dieNum.push(q); //数组中添加索引
                    };
                    localStorage.setItem('dieNum', JSON.stringify(dieNum)); //存储数组
                };
                localStorage.setItem('steps', 'death'); //步骤变为亡灵
            } else if (step === 'vote') { //如果是投票步骤进入的
                if (u === null) { //如果u数组是空
                    dieNum2 = new Array(0); //创建一个空数组赋值给变量dieNum2，长度为0，用来存储身份索引
                    if (p !== null) { //如果p不是空，即有身份索引
                        dieNum2.push(p); //数组中添加索引。
                    };
                    localStorage.setItem('dieNum2', JSON.stringify(dieNum2)); //存储数组
                } else { //如果u数组不是空
                    dieNum2 = u; //w数组赋值给死亡索引变量
                    if (p !== null && dieNum2.indexOf(p) < 0) { //如果身份牌索引不是空且死亡索引数组里没有本次点击的身份索引
                        dieNum2.push(p); //数组中添加索引
                    };
                    localStorage.setItem('dieNum2', JSON.stringify(dieNum2)); //存储数组
                };
                localStorage.setItem('steps', 'none'); //步骤恢复为初始
                var arryDay = new Array(); //创建一个空数组用来储存天数
                Num = Num + 1; //天数+1
                for (n = 0; n < Num; n++) {
                    arryDay.push(day[n]);
                };
                localStorage.setItem("arryDay", JSON.stringify(arryDay));
                localStorage.setItem("num", JSON.stringify(Num)); //保存天数
                // console.log(Num);
                localStorage.setItem("dayNum", JSON.stringify(day));
            };
            //判断杀手人数和平民人数
            localStorage.setItem("pNum", JSON.stringify(pnumber));
            localStorage.setItem("kNum", JSON.stringify(knumber));
            if (knumber >= pnumber) { //如果杀手人数大于等于平民人数
                resault = '杀手胜利'; //杀手胜利,跳转结果页面
                localStorage.setItem('resault', JSON.stringify(resault)); //存储结果
                $(location).attr('href','resault.html');
            } else if (knumber === 0) { //如果杀手人数为0
                resault = '平民胜利'; //平民胜利，跳转结果页面
                localStorage.setItem('resault', JSON.stringify(resault)); //存储结果
                $(location).attr('href','resault.html');
            } else { //除以上情况外，返回步骤页面
                $(location).attr('href','step.html');
            };
        };
    });
    //顶部，底部按钮点击事件
    close(); //点击关闭按钮弹窗
    hidden(); //点击取消弹窗消失
    enter(); //enter键等同底部按钮
});