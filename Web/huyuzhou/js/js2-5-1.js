var arr;
arr=sessionStorage.players;
players=JSON.parse(arr)

console.log(arr);
//杀手和平民数量



var allDeads;
if (sessionStorage.allDeads) {
  str=sessionStorage.allDeads;
  allDeads=JSON.parse(str)

}else {
  var allDeads=new Array();
  sessionStorage.allDeads=JSON.stringify(allDeads);
}


console.log("allDeads所有死亡信息"+sessionStorage.allDeads);

//初始状态
var stateInit = {
  step: {
    "1": true,
    "2": false,
    "3": false,
    "4": false
  },
  isClick: {
    "1": false,
    "2": false,
    "3": false,
    "4": false
  },

  day: 1
}
//构造死亡对象




var state;
var sessionState=sessionStorage.state;
if (sessionState) {
  state=JSON.parse(sessionStorage.state);
}else{
  state=stateInit;
}

function init(){
  var arrNode=[];
  sessionStorage.days=state.day;
for (var k = 0; k <state.day; k++) {
  arrNode.push(
  '<div class="container">'
    +'<p class="days">'+"第"+(k+1)+"天"+'</p>'
    +'<ul>'
      +'<li class="step1">'
        +'<img class="img_1" src="images/js2-5_2.png">'
        +'<div class="triangle triangle-1">'+'</div>'+"杀手杀人"
      +'</li>'
      +'<div class="Message">'+'</div>'
      +'<li class="step2">'+'<div>'+'</div>'+"亡灵发表遗言"+'</li>'
      +'<li class="step3">'
        +'<img class="img_2" src="images/js2-5_1.png">'
        +'<div class="triangle  triangle-2">'+'</div>'+"玩家依次发言"
      +'</li>'
      +'<li class="step4">'+'<div>'+'</div>'+"全民投票"+'</li>'
        +'<div class="Message">'+'</div>'
    +'</ul>'
  +'</div>')
var bug=arrNode.join("");
$(".main").html(bug);
  //
  // $(".main").html(oodiv)
  // if (sessionStorage.state) {
  //   $(".step1").addClass("Rred");
  //   $(".triangle-1").addClass("triangle2");
  //
  //   }
  }
}
  init();
//点击折叠
  $(".days").on("click",function(){
    // $(this).parent().siblings("div").children("ul").toggle();
     $(this).parent().children("ul").toggle();
  })
//变色与返回页面折叠
var asd=state.day-1;
  $("ul:eq("+asd+")").parent().siblings(".container").find("ul").addClass("hidden");
  $("ul:eq("+asd+")").parent().siblings(".container").find("ul li").addClass("Rred");
  $("ul:eq("+asd+")").parent().siblings(".container").find("ul li .triangle").addClass("triangle2");





for (var i = 0; i < $(".main li").length; i++) {
  $(".main li").eq(i).attr("index",i);
  $(".main li").eq(i).on("click",function(){
    var index=parseInt($(this).attr("index"))+1;
    var stepGo = state.step[index];
    var canClick = state.isClick[index];
    if(!canClick) {
      if(stepGo) {

        state.step[(index + 1)] = true;
        //点击当前的置为true
        state.isClick[index] = true;
        this.style.backgroundColor = 'red';
        $(this).children(".triangle").addClass("red");
        if (index%4==1) {
          sessionStorage.state=JSON.stringify(state);
          location.href="js2-6.html"
        }
        if (index%4==2) {
          sessionStorage.state=JSON.stringify(state);
          alert("请亡灵发表遗言")
        }
        if (index%4==3) {
          sessionStorage.state=JSON.stringify(state);
          alert("请玩家依次发言")
        }
        if(index%4==0){
          alert("进入投票页")
          state.day++;
          sessionStorage.state=JSON.stringify(state);
          location.href="js2-7.html"

        }
      } else {
        alert('请按顺序操作');
      }
    } else {
      alert('请不要重复操作');
    }
  }
)}

for ( i = 0; i < allDeads.length; i++) {
  if (i%2==0) {
          message="<p>"+"昨天"+(allDeads[i]+1)+"号死亡，被杀手杀死,他的身份是"+(players[allDeads[i]])+"</p>";
          var show=state.day-1;


  }else {
        message="<p>"+"昨天"+(allDeads[i]+1)+"号死亡，被玩家投死,他的身份是"+(players[allDeads[i]])+"</p>";
}
  $(".Message:eq("+i+")").append(message)
  a=allDeads.length;
if(!(a%2)==0){
$(".step1:eq("+show+")").addClass("Rred")
$(".triangle-1:eq("+show+")").addClass("triangle2");
}
}

// //
