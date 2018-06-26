var arr = sessionStorage.players;
players = JSON.parse(arr);
deads=sessionStorage.deads;
console.log(deads);
console.log(players);

var str=sessionStorage.allDeads;
var allDeads=JSON.parse(str);
console.log(players);
console.log(allDeads)

$(function box() {
 for (var i=0; i<players.length; i++){
 	if (i==deads||i==sessionStorage.vote) {
 		var div=
 		'<div class="box text-center">'+
			'<button type="button" class=" box-button box-dead">'+
				'<p class="box-p1">'+players[i]+'</p>'+
				'<p class="box-p2">'+(i+1)+'号'+'</p>'+
			'</button>'+
		'</div>';
       $(".boxs").append(div);
 	}else{
 		var div=
 		'<div class="box text-center">'+
			'<button type="button" class="box-button">'+
				'<p class="box-p1">'+"玩家"+'</p>'+
				'<p class="box-p2">'+(i+1)+'号'+'</p>'+
			'</button>'+
		'</div>';
       $(".boxs").append(div);
 		}
    for(var j=0;j<allDeads.length;j++){
      $(".box:eq("+allDeads[j]+") button").addClass("box-dead")
      $(".box:eq("+allDeads[j]+") button .box-p1").text(players[allDeads[j]])
    }
  }

  $(".boxs div").click(function(){
    $(this).children().toggleClass("Bborder")
    $(this).siblings(".box").children().removeClass("Bborder")
     voteDeads=$(".boxs div").index($(this));
     if ($(this).children("button").hasClass("box-dead")) {

       alert("不可重复杀人哦")
       $("flooter button").attr("disabled", true);
     }else{
        $("flooter button").attr("disabled", false);
     }
   })
    $("flooter button").click(function(){
      deads=sessionStorage.vote=voteDeads;
      allDeads.push(deads)
      sessionStorage.allDeads=allDeads;
      var str1=allDeads;
      sessionStorage.allDeads=JSON.stringify(str1);

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


      sessionStorage.shaShou=shaShou;
      sessionStorage.pinMin=pinMin;
      console.log("杀手剩余"+shaShou);//2
      console.log("平民剩余"+pinMin);//6

        })
  })
