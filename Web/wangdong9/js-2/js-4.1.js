/**
 * Created by Administrator on 2017/12/6.
 */
strl = sessionStorage.l;
l = JSON.parse(strl);
console.log(l);
str=sessionStorage.all;
all=JSON.parse(str);
var m=[];
$(document).ready(function (){
    var si=sessionStorage.getItem("nn");
    if(si==null){
        $("#daynumber").html('第1天');
    }else if(si!==null){

        sin=JSON.parse(si);
        console.log(sin);
        sing=Math.floor((sin.length)/2);

        console.log(sing);
        $("#daynumber").html('第'+(sing+1)+'天');
        for (i=0;i<sing;i++){
            m[i]=i;
            var oDay0=document.createElement("div");
            var oDay=document.createElement("div");
            var oDaytime=document.createElement("div");
            var oNight=document.createElement("div");
            var oTextnum=document.createTextNode('第'+(i+1)+'天');
            console.log(oTextnum);
            var oTextday=document.createTextNode('晚上:'+(sin[i*2]+1)+'号被杀手杀死,'+(sin[i*2]+1)+'号是水民');
            console.log(oTextday);
            var iden=sin[(i*2)+1];
            var oTextnight=document.createTextNode('白天:'+(sin[(i*2)+1]+1)+'号被投票投死，'+(sin[(i*2)+1]+1)+'号是'+l[iden]);
            console.log(oTextnight);
            oDay.className="oday";
            oDaytime.className="odaytime";
            oNight.className="odaynight";
            oDay.appendChild(oTextnum);
            oDaytime.appendChild(oTextday);
            oNight.appendChild(oTextnight);
            oDay0.appendChild(oDay);
            oDay0.appendChild(oDaytime);
            oDay0.appendChild(oNight);
            oDay0.id='div'+m[i];
            document.getElementById("message").appendChild(oDay0);
            // $("#daynumber").html('第'+(i+1)+'天');
            // document.getElementById("message").appendChild(oDaytime);
            // document.getElementById("message").appendChild(oNight);
        }
    }
});
$(document).ready(function () {
// $("#daynumber").html('第'+sing+'天');
    
var fsm =new StateMachine({
    init: 'live',
    transitions: [
        { name: 'kill',  from: 'live',  to: 'die' },
        { name: 'ghost', from:['live','die','discuss'] ,  to: 'ghost' },
        { name: 'speak',  from: ['live','die','ghost'], to: 'discuss' },
        { name: 'vote', from: 'discuss',   to: 'next' }
    ],

    methods:{
   onAfterKill:function () {
       sessionStorage.setItem("killed","killed");
       console.log(fsm.state)
   },
  onAfterGhost:function () {
      sessionStorage.setItem("ghosted","ghosted");
      console.log(fsm.state)
  },
        onAfterSpeak:function () {
            sessionStorage.setItem("speaked","speaked");
            console.log(fsm.state)
        }
    }
});
    died = sessionStorage.getItem("killed");
    ghost=sessionStorage.getItem("ghosted");
    speak=sessionStorage.getItem("speaked");
    if(died!==null){
        document.getElementById("kill").style.background="#ccc";
    }
    if(ghost!==null){
        document.getElementById("ghost").style.background="#ccc";
    }
if(speak!==null){document.getElementById("speak").style.background="#ccc";}
    $('#kill').click(function () {
        if (died == null) {
            location.href = "js-4.2.html";
            fsm.kill();
        }
        else {
            alert("一定要按顺序点,不然会崩");
        }
    });
    $('#ghost').click(function () {
        if (ghost == null&&died!==null) {
            alert("亡灵发言");
            document.getElementById("ghost").style.background = "#ccc";
            fsm.ghost();
        }
        else{
            alert("一定要按顺序点,不然会崩");
        }
    });
    $('#speak').click(function () {
        ghost=sessionStorage.getItem("ghosted");
        speak=sessionStorage.getItem("speaked");
        console.log(speak);
        if (speak == null&&ghost!==null) {
            alert("轮流发言");
            document.getElementById("speak").style.background = "#ccc";
            fsm.speak();
        }
        else {
            alert("一定要按顺序点,不然会崩");
        }
    });
    $('#vote').click(function () {
        speak=sessionStorage.getItem("speaked");
        console.log(speak);
        vote = sessionStorage.getItem("vote");
        if (speak!==null){
            sessionStorage.setItem("voted","voted");
            location.href = "js-4.2.html";

        }
        else {alert("一定要按顺序点,不然会崩")}

    });
});
$(document).ready(function(){
    var flag=true;
    $('.oday').click(function () {

        if(flag){
            $(this).siblings().show();
        }
        else{
            $(this).siblings().hide();
        }
         flag=!flag;
    });
    $('#once').click(function () {
        voted=sessionStorage.getItem('voted');
        if(voted!==null){
            sessionStorage.removeItem("voted");
            sessionStorage.removeItem("speaked");
            sessionStorage.removeItem("ghosted");
            sessionStorage.removeItem("killed");
        }
    });
       $('a').click(function () {
        sessionStorage.clear()
    })
});
