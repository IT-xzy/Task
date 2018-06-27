var reSult=sessionStorage.result;
$(".result").append(reSult);
var arr=sessionStorage.players;
var players=JSON.parse(arr)
var shaShou=0;
var pinMin=0;
var arr1=sessionStorage.allDeads;
var allDeads=JSON.parse(arr1)
for (var i = 0; i < players.length; i++) {
  if (players[i]=="杀手") {
    shaShou++;
  }else{
    pinMin++;
  }
}
  console.log(shaShou)
  console.log(pinMin)

$(".shaShou").append(shaShou);
$(".pinMin").append(pinMin);

var oodiv=
'<div class="content2-1">'
  +'<span class="content2-span1">'+"第1天"+'</span>'
  +'<p>'+"晚上："+"<span class='Message'>"+"</span>"+"号被杀手杀死，"+"<span class='Message1'>"+"</span>"+"号是"+"<span class='roles'>"+"</span>"+'</p>'
  +'<p>'+"白天："+"<span class='Message'>"+"</span>"+"号被全民投死，"+"<span class='Message1'>"+"</span>"+"号是"+"<span class='roles'>"+"</span>"+'</p>'
+"</div>";

days=sessionStorage.days;

for(var d=0;d<days;d++){
		$(".content2").append(oodiv);
$(".content2-span1:eq("+d+")").text("第"+(d+1)+"天")
}
//
// for (var i = 0; i < players.length; i++) {
    for (var i = 0; i < allDeads.length; i++) {
              message=allDeads[i]+1;
      $(".Message:eq("+i+")").append(message)
      $(".Message1:eq("+i+")").text(message)
      $(".roles:eq("+i+")").append(players[allDeads[i]])
      a=i+1;
}
$(".roles:eq("+a+")").parent().addClass("hidden")
  // }
