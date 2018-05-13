
var fsm = new StateMachine({
    init:"kill",
    transitions:[
        {name:'killed',from:'kill',to:'speak'},
        {name:'spoken',from:'speak',to:'discuss'},
        {name:'discussed',from:'discuss',to:'vote'},
        {name:'voted',from:'vote',to:'kill'}
    ],
    methods:{
        //事件1 触发killed事件，离开kill状态，进入speak状态，在spoken之前。
        onBeforeKilled:function(){
            console.log("1");
            console.log(fsm.state); 
            newstate=fsm.state;
        },
        onLeaveKill:function(){
            console.log("2");
            console.log(fsm.state); 

            
        },
        onEnterSpeak:function(){
            console.log("3");
            console.log(fsm.state); 
            window.location.href="demo1.html";
            $("#killbtn").css("background-color","pink");
            sessionStorage.newstate=fsm.state;
            newstate=sessionStorage.newstate;
        },
        onAfterKilled:function(){   
  
            console.log("4");
            console.log(fsm.state);   
            newstate=fsm.state;
        },

        //事件二
        onBeforeSpoken:function(){
            $("#speakbtn").css("background-color","pink");
            console.log("5");
            console.log(fsm.state);
            alert("请死者亮明身份，并且发表遗言");
            newstate=fsm.state;
        },
        onLeaveSpeak:function(){
     
            console.log("6");
            console.log(fsm.state);
            newstate=fsm.state;
        },
        onEnterDiscuss:function(){
    
            console.log("7");
            console.log(fsm.state);
            newstate=fsm.state;
        },
        onAfterSpoken:function(){
    
            console.log("8");
            console.log(fsm.state);
            newstate=fsm.state;
        },
        //事件三
        onBeforeDiscussed:function(){
            $("#discussbtn").css("background-color","pink");
            alert("玩家依次发言讨论");
            console.log("9");
            console.log(fsm.state);
            newstate=fsm.state;
        },
        onLeaveDiscuss:function(){
    
            console.log("10");
            console.log(fsm.state);
            newstate=fsm.state;
        },
        onEnterVote:function(){
    
            console.log("11");
            console.log(fsm.state);
            newstate=fsm.state;
        },
        onAfterDiscussed:function(){   
            console.log("12");
            console.log(fsm.state);
            newstate=fsm.state;
        },
        //事件四
        onBeforeVoted:function(){
            $("#votebtn").css("background-color","pink");
  
            console.log("13");
            console.log(fsm.state);
            //window.location.href="demo1.html";
            newstate=fsm.state;
        },
        onLeaveVote:function(){
   
            console.log("14");
            console.log(fsm.state);
            newstate=fsm.state;
        },
        onAfterVoted:function(){
  
            console.log("16");
            console.log(fsm.state);
            newstate=fsm.state;
        },
    }
});

$("#killbtn").on('click',function(){ 
    fsm.killed();  
});
$("#speakbtn").on('click',function(){
    fsm.spoken();
});
$("#discussbtn").on('click',function(){
    fsm.discussed();
});
$("#votebtn").on('click',function(){
    fsm.voted();
});



