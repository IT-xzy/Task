/**
 * Created by Administrator on 2017/12/19.
 */
strl = sessionStorage.l;
l = JSON.parse(strl);
console.log(l);
killer=sessionStorage.getItem('killer');
siller=sessionStorage.getItem('siller');
k=sessionStorage.getItem('knu');
s=sessionStorage.getItem('snu');
$(document).ready(function () {
    $('#numt').html('杀手：'+k+'人'+'&nbsp;'+'水民：'+s+'人');

   if(killer=='win'){
$('#whowin').html('杀手胜利')  ;
       $('#know').html('你知道吗，在杀人游戏中，只有20%的杀手能胜利')
   }
    else{
       $('#whowin').html('水民胜利')  ;
       $('#know').html('水民终于报仇雪恨了')
   }
       $('a').click(function () {
        sessionStorage.clear()
    })
});
var m=[];
$(document).ready(function (){
    var si=sessionStorage.getItem("nn");
    if(si==null){
        $("#daynumber").html('第1天');
    }else if(si!==null){
        sin=JSON.parse(si);
        console.log(sin);
        sing=Math.ceil((sin.length)/2);
        console.log(sing);
        $("#daynumber").html('第'+(sing+1)+'天');
        for (i=0;i<sing;i++){
            m[i]=i;
            var oDay0=document.createElement("div");
            var oDay=document.createElement("div");
            var oTime=document.createElement('span');
            var oDaytime=document.createElement("div");
            var oNight=document.createElement("div");
            var oTextnum=document.createTextNode('第'+(i+1)+'天');
            console.log(oTextnum);
            var oUtime=document.createTextNode('0小时7分');
            var oTextday=document.createTextNode('晚上:'+(sin[i*2]+1)+'号被杀手杀死,'+(sin[i*2]+1)+'号是水民');
            console.log(oTextday);
            var iden=sin[(i*2)+1];
            var ii=(i+1)*2;
            var oTextnight=document.createTextNode('白天:'+(sin[(i*2)+1]+1)+'号被投票投死，'+(sin[(i*2)+1]+1)+'号是'+l[iden]);
            console.log(oTextnight);
            oDay.className="oday";
            oDay0.className='oday0';
            oTime.className='otime';
            oUtime.className='outime';
            oDaytime.className="odaytime";
            oNight.className="odaynight";
            oDay.appendChild(oTextnum);
            oDay.appendChild(oTime);
            oTime.appendChild(oUtime);
            oDaytime.appendChild(oTextday);
            if(ii<=sin.length){ oNight.appendChild(oTextnight);}
            oDay0.appendChild(oDay);
            oDay0.appendChild(oDaytime);
            oDay0.appendChild(oNight);
            oDay0.id='div'+m[i];
            document.getElementById("message").appendChild(oDay0);
        }
    }

});
