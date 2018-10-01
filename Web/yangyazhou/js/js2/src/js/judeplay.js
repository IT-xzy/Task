//获取各种dom元素
(function () {
    var main = document.getElementsByTagName('main')[0]; //获取main
    var log = console.log;
    //获取玩家的所有数据
    var initialStr = sessionStorage.getItem('initialMsg'),
        newGameStr = sessionStorage.getItem('newGameMsg'),
        allgameMsg = JSON.parse(newGameStr)||JSON.parse(initialStr),
        days = allgameMsg.days;
    log(allgameMsg);
    log(newGameStr);    
   



       


    //这个函数是用来通过天数转化为相应的中文
    function toChinese(value) {
        var arr = ["", "一", "二", "三", "四", "五", "六", "七", "八", "九", '十'];
        if (value < 10) {
            return arr[value];
        } else if (value === 10) {
            return '十';
        } else if (value < 20 && value > 10) {
            return arr[10] + arr[(value - 10)];
        }
    }
    //创建所有dom文件，并插入main中
    (function () {
        var domstr = "";
        var killresult="",
            voteresult="";
        for (var i = 0; i < days; i++) {
                
                    killresult=allgameMsg.killed[i]?` <li class="kill-result">${allgameMsg.killed[i]}号被杀手杀死，真实身份是${allgameMsg.idArr[allgameMsg.killed[i]-1]}</li>`:'';
                    voteresult=allgameMsg.voted[i]?` <li class="vote-result">${allgameMsg.voted[i]}号被投死，真实身份是${allgameMsg.idArr[allgameMsg.voted[i]-1]}</li>`:'';
                    log(killresult);
                
                
            domstr +=
                `<h4 class="day-num">第${toChinese(i+1)}天</h4><div class="game-container">
                            <div class="change"> 
                                <span class="moon"></span>
                                <span class="sun"></span>
                            </div>
                            <ul class="game-step">
                            <li class="kill-step li-step"><i class="arrow"></i>杀手杀人</li>
                            ${killresult}
                            <li class="ghost-speak li-step"><i class="arrow"></i>亡灵发表遗言</li>
                            <li class="player-speak li-step"><i class="arrow"></i>玩家依次发言</li>
                            <li class="vote-step li-step"><i class="arrow"></i>全民投票</li>
                            ${voteresult}
                            </ul>
                    </div>`;
            
        }
        main.innerHTML = domstr;
        

    })();
    var dayTitle = document.getElementsByClassName('day-num'), //第几天的标题
        sun      = document.getElementsByClassName('sun'),
        killStep = document.getElementsByClassName('kill-step'), //杀手杀人
        ghostSpeak = document.getElementsByClassName('ghost-speak'), //亡灵发表遗言
        playerSpeak = document.getElementsByClassName('player-speak'), //玩家依次发言
        voteStep = document.querySelectorAll('.vote-step'),
        gameContainer = document.getElementsByClassName('game-container'), //游戏步奏的容器            
        li       =document.querySelectorAll('.game-step .li-step');
       

      //定义有限状态机来控制游戏
      var fsm=new StateMachine({
        init:'initial',
        transitions:[
            {name:'kill',from:'initial',to:'firstStep'},
            {name:'ghostSpeak',from:'firstStep',to:'twoStep'},
            {name:'gamerSpeak',from:'twoStep',to:'threeStep'},
            {name:'vote',from:'threeStep',to:'lastStep'}
        ],
        methods:{
            onInvalidTransition: function(transition, from, to) {
               switch(from){
                   case "initial":
                    alert('不要跳过游戏步奏，请执行杀手杀人');
                    break;
                    case "firstStep":
                    alert("不要跳过游戏步奏，请亡灵发表遗言");
                    break;
                    case "twoStep":
                    alert("不要跳过游戏步奏，请玩家依次发言");
                    break;
                    default :
                    alert("不要跳过游戏步奏，请进行投票");
                    
               }
            },
            onKill:function(lifecycle){
                allgameMsg.kill=true;
                allgameMsg.vote=false;
            },
            onGhostSpeak:function(lifecycle){
               alert('请亡灵发表遗言');
            },
            onGamerSpeak:function(){
                alert('玩家依次发言');
            },
            onVote:function(){
                //点击进入投票节点，天数加一，vote的状态为true
                allgameMsg.kill=false;
                allgameMsg.vote=true;
                // allgameMsg.days+=1;
                // log(allgameMsg);
                // log(1);
                var allgameStr=JSON.stringify(allgameMsg);
                sessionStorage.setItem('gamersMsg',allgameStr);
                window.location.href="judeSee.html";
            }
        }
    });



        (function(){
            var days=gamersMsg.days;
            
        //循环出所有的游戏列表,并且给相关的块设置背景色
        for (var i = 0; i < days; i++) {
            //小于当前天数的
            if (i < days - 1) {
                gameContainer[i].style.border = 'none';
                sun[i].style.top="2.14rem";
                for(let j=i*4;j<4*(i+1);j++){
                    li[j].classList.add('step-selected');
                    li[j].getElementsByTagName('i')[0].classList.add('arrow-selected');                             
                }
                gameContainer[i].onclick=function(e){
                    if(e.target.nodeName =='LI'){
                        alert(`今天是第${days}天，请按游戏顺序执行游戏`);
                    }
                }
            }
            //当前天数
            if (i === days - 1) {
                //今天的游戏步奏显现
                gameContainer[i].style['max-height']= '6rem';
                gameContainer[i].style.overflow = 'initial';
                //判断是否已经杀人了
                if(allgameMsg.killed.length==days){
                    killStep[i].classList.add('step-selected');
                    killStep[i].getElementsByTagName('i')[0].classList.add('arrow-selected');                    
                    sun[i].style.top="2.14rem";                
                    fsm.kill();
                }
                
                //给四个按钮添加相关的点击事件
                //点击杀人按钮添加事件
                killStep[i].onclick=function(){
                    fsm.kill();
                    //判断是否已经杀人回来
                    if(allgameMsg.killed.length == i){
                        return ;
                    }
                    //跳转到杀人页写入数据
                    var allgameStr=JSON.stringify(allgameMsg);
                    sessionStorage.setItem('gamersMsg',allgameStr);
                    window.location.href='judeSee.html';
                };
                //亡灵发言按钮添加事件
                ghostSpeak[i].onclick=function(){
                    fsm.ghostSpeak();
                    if(fsm.state =='twoStep'){

                        this.classList.add('step-selected');
                        this.getElementsByTagName('i')[0].classList.add('arrow-selected'); 
                    }
                };
                //玩家依次发言
                playerSpeak[i].onclick=function(){
                    fsm.gamerSpeak();
                    if(fsm.state =='threeStep'){

                        this.classList.add('step-selected');
                        this.getElementsByTagName('i')[0].classList.add('arrow-selected'); 
                    }
                };
                //投票按钮
                voteStep[i].onclick=function(){
                    fsm.vote();
                };

            }
        }
    })();



    (function () {
        //点击第几天来控制下面列表出现和消失
        for (var i = 0; i < days; i++) {
            dayTitle[i].addEventListener('click', function () {
                var _this = this;
                var bro = _this.nextSibling;
                var height = window.getComputedStyle(bro, null).height;
                if(height === '0px') {
                    bro.style.border = ".01rem solid #c9c9c9";
                    bro.style['max-height'] = '5.57rem';
                    setTimeout(function () {
                        bro.style.overflow = 'initial';
                    }, 1900);
                }else{
                    bro.style.border = "none";
                    bro.style['max-height'] = '0';
                    bro.style.overflow = 'hidden';
                }
            }, false);
        }
    })();
//    log(fsm);
     //给四个按钮添加事件
    
      



    // for(let i=0;i<days;i++){
    //     if(i==days-1 && allgameMsg.index[i][0]){
    //         fsm.onKill();            
    //     }
    // }







   

    






})();