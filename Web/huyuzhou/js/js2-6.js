
var arr = sessionStorage.players;
players = JSON.parse(arr);
var str=sessionStorage.allDeads;
var allDeads=JSON.parse(str);
console.log(players);
console.log(allDeads)
var deads;

//取序号
$(function box() {
 for (var i=0; i<players.length; i++){
   if (players[i]=="杀手") {
     var div='<div class="box kill" >'+'<p>'+(i+1)+"号杀手"+'</p>'+'</div>';
      $(" .center").append(div);
  	}else{
     var div='<div class="box" >'+'<p>'+(i+1)+"号玩家"+'</p>'+'</div>';
      $(" .center").append(div);
   }
 }

for (var j = 0; j < allDeads.length; j++) {
  $(".box:eq("+allDeads[j]+")").addClass("deads")
}


  $(".center div").click(function(){
    if($(this).hasClass("deads")){
      alert("不可杀死人")
        }else if(!$(this).hasClass("kill")){
          $(this).toggleClass("box-select")
                 .siblings("div").removeClass("box-select")
                deads=sessionStorage.deads=$(".center div").index($(this));
        }else{
          alert("不可杀队友")
        }
  })
})
//状态机
/*var myState=new StateMachine({

})
*/
//进去投票页
document.getElementById('next').onclick=function(){
  allDeads.push(deads);
  var str1=allDeads;
  sessionStorage.allDeads=JSON.stringify(str1);
  // for (var i = 0; i < allDeads.length-1; i++) {
  // players.splice(allDeads[i],1);
  // }

  var shaShou=0;
  var pinMin=0;
  for (var j = 0; j <players.length; j++) {
    if (players[j]=="杀手") {shaShou++;}
    if (players[j]=="平民") {  pinMin++;}
  }
  for (var i = 0; i < allDeads.length; i++) {
    if (players[allDeads[i]]=="杀手") {
        shaShou--;
    }else {
      pinMin--;
    }
  }
  sessionStorage.shaShou=shaShou;
  sessionStorage.pinMin=pinMin;
    if (shaShou>pinMin) {
      alert("杀手胜利")
      sessionStorage.result="杀手";
      location.href="js2-8.html"
    }else if(shaShou==0){
      alert("平民胜利")
      sessionStorage.result="平民";
      location.href="js2-8.html"
    }else{
	 location.href="js2-5.html"
 }
}
