var log = console.log;


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
$(function () {
$('backBtn').on('click',function(){
    $(location).attr('href','allot.html');    
});
$('.close-icon').on('click',function(){
    var r = confirm("您确定离开游戏吗？");
    if (r == true) {
        window.location.href = "headerPage.html";
    }
})







    var gameMsgstr = sessionStorage.getItem('allMsg');
    var initialMsg = JSON.parse(gameMsgstr);
    let {dayNum:days=null,players,killed,state,voted}=initialMsg;
    log(initialMsg);
    // log(players);
    var main =$('main');
    //根据天数循环出所有的dom节点
    var str="";
    for(let i=0;i<days;i++){
        let killstr ='';
        let voteStr ='';
        for(var j=0;j<players.length;j++){
            if( players[j].deadDay==i+1 && players[j].deadReason =='killed'){
                killstr =  `<li class="kill-result">${ players[j].index+1}号被杀手杀死，真实身份是平民</li>`;
            }
            if( players[j].deadDay==i+1 && players[j].deadReason =='voted'){
                voteStr =  `<li class="vote-result">${ players[j].index+1}号被投票投死，真实身份是${ players[j].id}</li>`;
            }
        }
        str += `<h4 class="day-num">第${toChinese(i+1)}天</h4>
        <div class="game-container">
            <div class="change"> 
                <span class="moon"></span>
            </div>
            <ul class="game-step">
                <li class="kill-step"><i class="arrow"></i>杀手杀人</li>
                ${killstr}
                <li class="ghost-speak"><i class="arrow"></i>亡灵发表遗言</li>
                <li class="player-speak"><i class="arrow"></i>玩家依次发言</li>
                <li class="vote-step"><i class="arrow"></i>全民投票</li>               
                ${voteStr}
            </ul>
        </div>
        `;
    }
    main.html(str);


    //获取dom节点
    var dayNum = $('.day-num'), //第几天
        gameContainer = $('.game-container'), //游戏容器
        gameBtn = $('#gameover'),
        dayLog = $('#dayLog'),
        killStep =$('.kill-step'),
        ghostSpeak=$('.ghost-speak'),
        playerSpeak=$('.player-speak'),
        voteStep=$('.vote-speak'),
        voteresult=$('.vote-result'),
        killresult=$('.kill-result');
        log(voteresult);
        //定义一个状态机
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
                        alert('请执行杀手杀人');
                        break;
                        case "firstStep":
                        alert("请执行亡灵发表遗言");
                        break;
                        case "twoStep":
                        alert("请执行玩家发言");
                        break;
                        default :
                        alert("请执行投票");
                   }
                },
                onKill:function(lifecycle){
                    initialMsg.state='kill';
                    initialMsg.step=1;
                },
                onGhostSpeak:function(lifecycle){
                   initialMsg.step=2;                     
                   changebgcolor(ghostSpeak[days-1]);                  
                },
                onGamerSpeak:function(){
                     initialMsg.step=3;                    
                     log(playerSpeak)
                     changebgcolor(playerSpeak[days-1]);   
                },
                onVote:function(){
                    //点击进入投票节点，天数加一，vote的状态为true
                    initialMsg.step=4;                     
                    initialMsg.state="vote";
                    log(initialMsg);
                    sessionStorage.setItem('allMsg',JSON.stringify(initialMsg));
                    window.location.href="judeSee.html";
                }
            }
        });
        gameContainer.each(function(i){
            log(i,days);
            if(i<days-1){
                $(this).toggle()
                $(this).on('click','li',function(e){
                    alert(`今天是第${days}天,请按照游戏步奏进行游戏`);
                });
                  $(this).find('li').css('background-color','#808080');
                  $(this).find('.arrow').css('border-right-color','#808080');
                  //投票杀人的结果返回原来的颜色
                  $(voteresult[i]).css('background-color','initial');
                  $(killresult[i]).css('background-color','initial');
            }
            if(i==days-1){
                switch(initialMsg.step){
                    case 1:
                    changebgcolor(killStep[days-1]);
                    fsm.kill();
                    break;
                    case 2:
                    changebgcolor(killStep[days-1]);                    
                    fsm.kill();
                    fsm.ghostSpeak();
                    break ;
                    case 3:
                    changebgcolor(killStep[days-1]);                                        
                    fsm.kill();
                    fsm.ghostSpeak();
                    fsm.gamerSpeak();
                    break;
                }
               
                $(this).on('click','li',function(e){
                    //杀手杀人
                    if($(e.target).is('.kill-step')){
                        fsm.kill();
                        if(state=='kill'){
                            return ;
                        }
                        sessionStorage.setItem('allMsg',JSON.stringify(initialMsg));
                        $(location).attr('href','judeSee.html');     
                    }
                    //亡灵发言
                    if($(e.target).is('.ghost-speak')){
                        log(fsm.state)
                        if(fsm.state=='firstStep'){
                            alert('请亡灵发表遗言');
                        }
                        fsm.ghostSpeak();
                    }
                    //玩家发言
                    if($(e.target).is('.player-speak')){
                        if(fsm.state == 'twoStep'){
                            alert('玩家依次发言');
                        }
                        fsm.gamerSpeak();
                    }
                    //全民投票
                    if($(e.target).is('.vote-step')){
                        fsm.vote();
                        
                    }
                });
            }
        });
        //改变背景颜色
        function changebgcolor(ele){
            let target=ele;
            $(target).css('background-color','#808080');
            $(target).find('.arrow').css('border-right-color','#808080');
        }
















    
    // 点击天数按钮
    dayNum.on('click', function (e) {
        $(this).next('.game-container').toggle();
    });
    //结束游戏按钮
    gameBtn.click(function () {
        var r = confirm("结束游戏")
        if (r === true) {
           $(location).prop('href','result-1.html'); 
        } else {
           
        }
    });
    //法官日志按钮
    dayLog.on('click', function () {
        initialMsg.goLog=true;  
        sessionStorage.setItem('allMsg', JSON.stringify(initialMsg));               
        $(location).prop('href', 'judeState.html');
    });
    //返回按钮
    $('#backBtn').click(function(){
        $(location).prop('href', 'allot.html');
    })









});



























// (function () {
//     var main = document.getElementsByTagName('main')[0]; //获取main
//     var log = console.log;
//     //获取玩家的所有数据
//     var initialStr = sessionStorage.getItem('initialMsg'),
//         newGameStr = sessionStorage.getItem('newGameMsg'),
//         allgameMsg = JSON.parse(newGameStr)||JSON.parse(initialStr),
//         days = allgameMsg.days;
//     log(allgameMsg);
//     log(newGameStr);    







//     //这个函数是用来通过天数转化为相应的中文
//     function toChinese(value) {
//         var arr = ["", "一", "二", "三", "四", "五", "六", "七", "八", "九", '十'];
//         if (value < 10) {
//             return arr[value];
//         } else if (value === 10) {
//             return '十';
//         } else if (value < 20 && value > 10) {
//             return arr[10] + arr[(value - 10)];
//         }
//     }
//     //创建所有dom文件，并插入main中
//     (function () {
//         var domstr = "";
//         var killresult="",
//             voteresult="";
//         for (var i = 0; i < days; i++) {

//                     killresult=allgameMsg.killed[i]?` <li class="kill-result">${allgameMsg.killed[i]}号被杀手杀死，真实身份是${allgameMsg.idArr[allgameMsg.killed[i]-1]}</li>`:'';
//                     voteresult=allgameMsg.voted[i]?` <li class="vote-result">${allgameMsg.voted[i]}号被投死，真实身份是${allgameMsg.idArr[allgameMsg.voted[i]-1]}</li>`:'';
//                     log(killresult);


//             domstr +=
//                 `<h4 class="day-num">第${toChinese(i+1)}天</h4><div class="game-container">
//                             <div class="change"> 
//                                 <span class="moon"></span>
//                                 <span class="sun"></span>
//                             </div>
//                             <ul class="game-step">
//                             <li class="kill-step li-step"><i class="arrow"></i>杀手杀人</li>
//                             ${killresult}
//                             <li class="ghost-speak li-step"><i class="arrow"></i>亡灵发表遗言</li>
//                             <li class="player-speak li-step"><i class="arrow"></i>玩家依次发言</li>
//                             <li class="vote-step li-step"><i class="arrow"></i>全民投票</li>
//                             ${voteresult}
//                             </ul>
//                     </div>`;

//         }
//         main.innerHTML = domstr;


//     })();
//     var dayTitle = document.getElementsByClassName('day-num'), //第几天的标题
//         sun      = document.getElementsByClassName('sun'),
//         killStep = document.getElementsByClassName('kill-step'), //杀手杀人
//         ghostSpeak = document.getElementsByClassName('ghost-speak'), //亡灵发表遗言
//         playerSpeak = document.getElementsByClassName('player-speak'), //玩家依次发言
//         voteStep = document.querySelectorAll('.vote-step'),
//         gameContainer = document.getElementsByClassName('game-container'), //游戏步奏的容器            
//         li       =document.querySelectorAll('.game-step .li-step');


//       //定义有限状态机来控制游戏
//       var fsm=new StateMachine({
//         init:'initial',
//         transitions:[
//             {name:'kill',from:'initial',to:'firstStep'},
//             {name:'ghostSpeak',from:'firstStep',to:'twoStep'},
//             {name:'gamerSpeak',from:'twoStep',to:'threeStep'},
//             {name:'vote',from:'threeStep',to:'lastStep'}
//         ],
//         methods:{
//             onInvalidTransition: function(transition, from, to) {
//                switch(from){
//                    case "initial":
//                     alert('不要跳过游戏步奏，请执行杀手杀人');
//                     break;
//                     case "firstStep":
//                     alert("不要跳过游戏步奏，请亡灵发表遗言");
//                     break;
//                     case "twoStep":
//                     alert("不要跳过游戏步奏，请玩家依次发言");
//                     break;
//                     default :
//                     alert("不要跳过游戏步奏，请进行投票");

//                }
//             },
//             onKill:function(lifecycle){
//                 allgameMsg.kill=true;
//                 allgameMsg.vote=false;
//             },
//             onGhostSpeak:function(lifecycle){
//                alert('请亡灵发表遗言');
//             },
//             onGamerSpeak:function(){
//                 alert('玩家依次发言');
//             },
//             onVote:function(){
//                 //点击进入投票节点，天数加一，vote的状态为true
//                 allgameMsg.kill=false;
//                 allgameMsg.vote=true;
//                 // allgameMsg.days+=1;
//                 // log(allgameMsg);
//                 // log(1);
//                 var allgameStr=JSON.stringify(allgameMsg);
//                 sessionStorage.setItem('gamersMsg',allgameStr);
//                 window.location.href="judeSee.html";
//             }
//         }
//     });



//         (function(){
//             var days=gamersMsg.days;

//         //循环出所有的游戏列表,并且给相关的块设置背景色
//         for (var i = 0; i < days; i++) {
//             //小于当前天数的
//             if (i < days - 1) {
//                 gameContainer[i].style.border = 'none';
//                 sun[i].style.top="2.14rem";
//                 for(let j=i*4;j<4*(i+1);j++){
//                     li[j].classList.add('step-selected');
//                     li[j].getElementsByTagName('i')[0].classList.add('arrow-selected');                             
//                 }
//                 gameContainer[i].onclick=function(e){
//                     if(e.target.nodeName =='LI'){
//                         alert(`今天是第${days}天，请按游戏顺序执行游戏`);
//                     }
//                 }
//             }
//             //当前天数
//             if (i === days - 1) {
//                 //今天的游戏步奏显现
//                 gameContainer[i].style['max-height']= '6rem';
//                 gameContainer[i].style.overflow = 'initial';
//                 //判断是否已经杀人了
//                 if(allgameMsg.killed.length==days){
//                     killStep[i].classList.add('step-selected');
//                     killStep[i].getElementsByTagName('i')[0].classList.add('arrow-selected');                    
//                     sun[i].style.top="2.14rem";                
//                     fsm.kill();
//                 }

//                 //给四个按钮添加相关的点击事件
//                 //点击杀人按钮添加事件
//                 killStep[i].onclick=function(){
//                     fsm.kill();
//                     //判断是否已经杀人回来
//                     if(allgameMsg.killed.length == i){
//                         return ;
//                     }
//                     //跳转到杀人页写入数据
//                     var allgameStr=JSON.stringify(allgameMsg);
//                     sessionStorage.setItem('gamersMsg',allgameStr);
//                     window.location.href='judeSee.html';
//                 };
//                 //亡灵发言按钮添加事件
//                 ghostSpeak[i].onclick=function(){
//                     fsm.ghostSpeak();
//                     if(fsm.state =='twoStep'){

//                         this.classList.add('step-selected');
//                         this.getElementsByTagName('i')[0].classList.add('arrow-selected'); 
//                     }
//                 };
//                 //玩家依次发言
//                 playerSpeak[i].onclick=function(){
//                     fsm.gamerSpeak();
//                     if(fsm.state =='threeStep'){

//                         this.classList.add('step-selected');
//                         this.getElementsByTagName('i')[0].classList.add('arrow-selected'); 
//                     }
//                 };
//                 //投票按钮
//                 voteStep[i].onclick=function(){
//                     fsm.vote();
//                 };

//             }
//         }
//     })();



//     (function () {
//         //点击第几天来控制下面列表出现和消失
//         for (var i = 0; i < days; i++) {
//             dayTitle[i].addEventListener('click', function () {
//                 var _this = this;
//                 var bro = _this.nextSibling;
//                 var height = window.getComputedStyle(bro, null).height;
//                 if(height === '0px') {
//                     bro.style.border = ".01rem solid #c9c9c9";
//                     bro.style['max-height'] = '5.57rem';
//                     setTimeout(function () {
//                         bro.style.overflow = 'initial';
//                     }, 1900);
//                 }else{
//                     bro.style.border = "none";
//                     bro.style['max-height'] = '0';
//                     bro.style.overflow = 'hidden';
//                 }
//             }, false);
//         }
//     })();















// })();