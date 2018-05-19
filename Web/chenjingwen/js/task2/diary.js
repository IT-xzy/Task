objrole=JSON.parse(sessionStorage.objrole);
killernum=sessionStorage.killernum;
personnum=sessionStorage.personnum;
//四个按钮的有限状态机
var fsm=new StateMachine({
    init:"kill",
    transitions:[
        {name:'killed',from:'kill',to:'speak'},
        {name:'spoken',from:'speak',to:'discuss'},
        {name:'discussed',from:'discuss',to:'vote'},
        {name:'voted',from:'vote',to:'kill'}
    ],
    methods:{
        onKilled:function(){
            sessionStorage.speakstate=fsm.state;
            console.log(fsm.state);
        },
        onSpoken:function(){
            sessionStorage.disstate=fsm.state;
            disstate=sessionStorage.disstate;
            console.log(fsm.state);

        },
        onDiscussed:function(){
            sessionStorage.votestate=fsm.state;
            votestate=sessionStorage.votestate;
            console.log(fsm.state);

        },
        onVoted:function(){
            sessionStorage.killstate=fsm.state;
            console.log(fsm.state);
        }
    }
});
var speakstate,disstate,votestate,killstate;
//每次进入页面都重新赋值一次
if(1>0){
    speakstate=sessionStorage.speakstate;
    disstate=sessionStorage.disstate;
    votestate=sessionStorage.votestate;
    killstate=sessionStorage.killstate;
}
//生成下一天的按钮，改变前一天类名。
var strHtml=[];
function render() {
    strHtml.push(
    '<button class="daybtn"></button>'+
     '<div class="journal">'+
     '<div class="triangle"></div>'+
     '<div class="date">'+
     '<p class="kill">杀手杀人</p>'+
     '<div class="night"></div>'+
     '<p class="speak">亡灵发表遗言</p>'+
     '<p class="discuss">玩家依次发言</p>'+
     '<p class="vote">全民投票</p>'+
     '<div class="daytime"></div>'+
     '</div>'+
     '</div>'
    );
    $('.process').html(strHtml.join(''));

}

//判断第一步杀人状态是否已经改变，如果改变则是跳转回页面状态，自动执行fsm.killed(),转到第二状态。
if(speakstate=="speak"){
    console.log(speakstate);
    fsm.killed();
    if(killstate!="kill"){
        var daynum=Math.floor((objrole.length-killernum-personnum)/2)+1;
        for(i=0;i<daynum;i++){   
        render();       
        } 
        bekilled=JSON.parse(sessionStorage.bekilled);
        console.log(bekilled);
        bevoted=JSON.parse(sessionStorage.bevoted);
        console.log(bevoted);
        for(j=0;j<daynum;j++){
            $(".daybtn").eq(j).text("第"+(j+1)+"天");
            $(".night").eq(j).html(bekilled[j]);
            console.log(bekilled[j]);
        }
        var k=0;
        while(k<(daynum-1)){
            $(".daytime").eq(k).html(bevoted[k]);
            k++;
        }
        $(function () {
        //把所有的取出来
             var journals=$('.process .journal');
        //            所有的下面的p元素都加上一个类表示已经玩过的步骤
             journals.find('p').addClass('over');
        //            再选出来最后一个，把这个类去掉，数组【数组的长度减1】就能取到最后一个元素
            journals.eq(journals.length-1).find('p').removeClass('over');
            });   
        $(".journal").hide();
        $(".journal").last().show(); 
    }
    $("p.kill").last().css("background-color","#83b09a");
}
$(".process").on('click','.kill',function(){
fsm.killed();
window.location.href="vote.html";
});

//判断状态，状态是否为"speak"，如果不是弹出对话框，是的话正常进行到下一步
if(disstate=="discuss"){
    fsm.spoken();
    $("p.speak").last().css("background-color","#83b09a");
}
//else{
    $(".process").on('click','.speak:last',function(){
        if(speakstate!="speak"){
            alert("请按正确的游戏顺序进行");
        }
        else{
            fsm.spoken();
            alert("请亡灵发表遗言");
            $("p.speak").last().css("background-color","#83b09a");
            console.log(fsm.state);
            console.log(disstate);
        }
    });
//}
//判断状态，状态是否为"discuss"，如果不是弹出对话框，是的话正常进行到下一步
$(".process").on('click','.discuss:last',function(){
    if(disstate=="discuss"){
        console.log(disstate);
        fsm.discussed();
        alert("请玩家依次发言");
        $(this).css("background-color","#83b09a");          
    }
    else{
        alert("请按正确的游戏顺序进行");
    }
});
if(votestate=="vote"){
    fsm.discussed();
    $("p.discuss").last().css("background-color","#83b09a");
}
//判断状态是否为"vote"，如果是的话执行voted事件，跳转回当前页面，状态为"kill"说明页面已经跳转两次，直接执行voted()，
//清除之前状态。

$(".journal").last().on('click','.vote',function(){
    if(votestate=="vote"){
        fsm.voted();
        window.location.href="vote.html";
    }
    else{
        alert("请按正确的游戏顺序进行");
    }
});

if(killstate=="kill"){
    fsm.voted();
    $("p.vote").last().css("background-color","#83b09a");
    //清除sessionstorage中保存数据
    sessionStorage.removeItem("killstate");
    sessionStorage.removeItem("speakstate");
    sessionStorage.removeItem("disstate");
    sessionStorage.removeItem("votestate");
    var daynum=Math.ceil((objrole.length-killernum-personnum)/2)+1;
    for(i=0;i<daynum;i++){   
        render();       
    } 
    bekilled=JSON.parse(sessionStorage.bekilled);
    bevoted=JSON.parse(sessionStorage.bevoted);
    for(j=0;j<daynum;j++){
        $(".daybtn").eq(j).text("第"+(j+1)+"天");    
    }
    var k=0;
    while(k<(daynum-1)){
        $(".daytime").eq(k).html(bevoted[k]);
        $(".night").eq(k).html(bekilled[k]);
        k++;
    }    
    $(function () {
        //把所有的取出来
         var journals=$('.process .journal');
        //            所有的下面的p元素都加上一个类表示已经玩过的步骤
         journals.find('p').addClass('over');
        //            再选出来最后一个，把这个类去掉，数组【数组的长度减1】就能取到最后一个元素
         journals.eq(journals.length-1).find('p').removeClass('over');
        });   
    $(".journal").hide();
    $(".journal").last().show();  
}
$(".daybtn").on("click",function(){
    var index=$(".daybtn").index(this);
    $(".journal").eq(index).toggle();
});

//点击结束游戏按钮，回到设置页面，储存数据清零。
$(".btn-left").on('click',function(){
    sessionStorage.clear();
    window.location.href="setup.html";
});