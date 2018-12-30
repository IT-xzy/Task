        var dayss = document.getElementsByClassName("dayss");//第几天数的节点
        var itme = document.getElementsByClassName("itme"); //获取克隆的源节点
        var order = document.getElementsByClassName("order");//隐藏内人容器的节点
        var sha = document.getElementsByClassName("sha");//显示杀人信息的节点
        var tou = document.getElementsByClassName("tou");//显示投死信息的节点
        var daybtn = document.getElementsByClassName("day");//点击显示或隐藏的节点
        var box = document.getElementsByClassName("box");//按钮父级的节点
        //四个按钮的节点获取
        var killingg = document.getElementsByClassName("killingg");
        var undeadspeakk = document.getElementsByClassName("undeadspeakk");
        var playerspeakingg = document.getElementsByClassName("playerspeakingg");
        var votingg = document.getElementsByClassName("votingg");

        //提前存储信息
        var step = sessionStorage.getItem("step"); //提取步骤
        var civilian = sessionStorage.getItem("civilian"); //平民
        var killer = sessionStorage.getItem("killer"); //杀手
        //提取被杀死的平民信息
        if (sessionStorage.getItem("killDead")) {
            var killDead = JSON.parse(sessionStorage.getItem("killDead"));
        } else {
            var killDead = [];
        }
        //提取被投死的玩家信息
        if (sessionStorage.getItem("voteDead")) {
            var voteDead = JSON.parse(sessionStorage.getItem("voteDead"));
        } else {
            var voteDead = [];
        }
        //提取天数
        if (sessionStorage.getItem("days")) {
            var days = sessionStorage.getItem("days");
        } else {
            var days = 1;
        }
        console.log(days);
        //创建天数数组
        var daysArray = ["十", "一", "二", "三", "四", "五", "六", "七", "八", "九"];
        //创建状态机数组
        // var state = ["kill", "undead", "playerspeak", "vote"];
        //创建执行顺序状态机
        var fsm = new StateMachine({
            //当前状态
            init: "kill",
            //状态转换
            transitions: [{
                    name: "killing",
                    from: "kill",
                    to: "undead"
                },
                {
                    name: "undeadspeak",
                    from: "undead",
                    to: "playerspeak"
                },
                {
                    name: "playerspeaking",
                    from: "playerspeak",
                    to: "vote"
                },
                {
                    name: "voting",
                    from: "vote",
                    to: "kill"
                }
            ],
            //构造状态机的方法
            methods: {
                /* 如果状态转换不能正常转换就会触发下面的错误处理机制 */
                onInvalidTransition: function (transitions, from, to) {
                    switch (from) {
                        case "kill":
                            alert("请点击杀手杀人");
                            break;
                        case "undead":
                            alert("请点击亡灵发表遗言");
                            break;
                        case "playerspeak":
                            alert("请点击玩家依次发言");
                            break;
                        case "vote":
                            alert("请点击请点击全民投票");
                            break;
                    }
                }
            }
        });

        window.onload = function () {    //自运行事件 
            if (days > 1) {              //判断，第一天以后做的事情
                for (let i = 0; i < days - 1; i++) {
                    var cloneNode = itme[0].cloneNode(true);    //克隆源节点
                    itme[0].parentNode.appendChild(cloneNode);  //将克隆的节点排在源节点后依次排列
                    var button = box[i].getElementsByTagName("button"); //获取button
                    for (let i = 0; i < button.length; i++) {        
                        button[i].style.background = "red";       //渲染背景
                    }
                    var buttonn = box[i + 1].getElementsByTagName("button"); //获取当前的button
                    for (let i = 0; i < button.length; i++) {
                        buttonn[i].style.background = "#24A7C6";    //覆盖背景
                    }
                    dayss[i].innerHTML = daysArray[i + 1]; //修改天数数字
                    sha[i].innerHTML = killDead[i];       //遍历修改杀人信息
                    tou[i].innerHTML = voteDead[i];       //遍历修改投死信息
                }
                for (let i = 0; i < days - 1; i++) { //当到下一天的时候，上一天自动隐藏
                    //console.log(order[i])
                    order[i].classList.add("none");
                }
                dayss[days - 1].innerHTML = daysArray[days]; //修改当前天数数字
                if (killDead[days - 1] == undefined) { //修改当前杀人信息
                    sha[days - 1].innerHTML = "";

                } else {
                    sha[days - 1].innerHTML = killDead[days - 1];
                }
                if (voteDead[days - 1] == undefined) { //修改当前投死信息
                    tou[days - 1].innerHTML = "";

                } else {
                    tou[days - 1].innerHTML = voteDead[days - 1];
                }

            }
            if (days == 1) {                     //第一天的样式
                if (killDead[0] == undefined) {
                    sha[0].innerText = "";
                } else {
                    sha[0].innerText = killDead[0];
                }
            }
            for (let i = 0; i < days; i++) {        //遍历点击事件  显示或影藏
                daybtn[i].onclick = function () {
                    order[i].classList.toggle("none");
                }
            }
            //当前的按钮点击事件
            killingg[days - 1].onclick = function () {      
                fsm.killing();
                if (step == null) {
                    location.href = ('killing.html');
                }
            }
            undeadspeakk[days - 1].onclick = function () {
                //console.log(fsm.can('undeadspeak'));
                fsm.undeadspeak();
                if (step == 1) {
                    alert("亡灵发表遗言");
                    undeadspeakk[i].style.background = "red";
                    step = 2;
                    sessionStorage.setItem("step", step);
                }
            }
            playerspeakingg[days - 1].onclick = function () {
                //console.log(fsm.can('playerspeaking'));
                fsm.playerspeaking();
                if (step == 2) {
                    alert("玩家发表言");
                    playerspeakingg[i].style.background = "red";
                    step = 3;
                    sessionStorage.setItem("step", step);
                }
            }
            votingg[days - 1].onclick = function () {
                //console.log(fsm.can('voting'));
                fsm.voting();
                if (step == 3) {
                    sessionStorage.setItem("days", days);
                    sessionStorage.setItem("step", step);
                    location.href = ('vote.html');
                }
            }
            //判断步骤为第几步时运行哪些代码
            switch (step) {                
                case "1":
                    fsm.killing();
                    for (let i = 0; i < days; i++) {
                        killingg[i].style.background = "red";
                    }
                    break;
                case "2":
                    fsm.killing();
                    fsm.undeadspeak();
                    for (let i = 0; i < days; i++) {
                        killingg[i].style.background = "red";
                        undeadspeakk[i].style.background = "red";
                    }
                    break;
                case "3":
                    fsm.killing();
                    fsm.undeadspeak();
                    fsm.playerspeaking();
                    for (let i = 0; i < days; i++) {
                        killingg[i].style.background = "red";
                        undeadspeakk[i].style.background = "red";
                        playerspeakingg[i].style.background = "red";
                    }

                    break;
                case "4":
                    step = null;
                    break;
            }
            //事件委托   运行当天之前按钮的点击事件
            for (var i = 0; i < days - 1; i++) {
                box[i].onclick = function (ev) {         
                    var ev = ev || window.event;
                    var target = ev.target || ev.srcElement;
                    if (target.nodeName.toLowerCase() == 'button') {
                        alert("请返回当天流程操作");
                    }
                }
            }
        }
        //存储
        sessionStorage.setItem("civilian", civilian); //平民
        sessionStorage.setItem("killer", killer); //杀手
        sessionStorage.setItem("voteDead", JSON.stringify(voteDead)); //投死信息
        sessionStorage.setItem("days", days); //天数
        sessionStorage.setItem("killDead", JSON.stringify(killDead)); //杀人信息
        sessionStorage.setItem("daysArray", JSON.stringify(daysArray)); //天数数组
        //退出游戏按钮
        var close = document.getElementsByClassName("right")[0];
        close.onclick = function () {
            if (confirm("确定退出游戏么？")) {
                sessionStorage.clear();
                location.href = ("homepage.html");
            }
        }
        //法官日记按钮
        var record = document.getElementById("record");
        record.onclick = function () {
            location.href = ("record.html");
        }
        //结束游戏按钮
        var end = document.getElementById("end");
        end.onclick = function () {
            if (confirm("确定退出游戏么？")) {
                location.href = ("result.html");
            }
        }