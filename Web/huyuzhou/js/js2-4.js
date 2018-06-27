
var arr = sessionStorage.players;  
players = JSON.parse(arr);

console.log(players);
//取序号
$(function box() {
 for (var i=0; i<players.length; i++){
 	if (players[i]=="杀手") {
      var div='<div class="box-killer">'+'<p>'+(i+1)+"号"+players[i]+'</p>'+'</div>';
 	}else{
      var div='<div class="box">'+'<p>'+(i+1)+"号"+players[i]+'</p>'+'</div>'; 
      }
       $(".main").append(div)
    }
})
document.getElementById('next').onclick=function(){
location.href="js2-5.html"
}