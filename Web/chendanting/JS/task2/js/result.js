all=JSON.parse(sessionStorage.getItem("all"));
died=JSON.parse(sessionStorage.getItem("died"));
diedKiller=JSON.parse(sessionStorage.getItem("diedKiller"));
votedRole=JSON.parse(sessionStorage.getItem("votedRole"));
$(".top").append('<div class="survivor"></div>');
$(".survivor").html("杀手"+(Math.floor((1/3)*all.length)-diedKiller.length)+"人"+"&emsp;&emsp;"+"平民"+(Math.ceil((2/3)*all.length)-(died.length-diedKiller.length))+"人");
day=sessionStorage.getItem("day");
//将day这个字符串转换为数字类型，不然做运算的时候会转化为day1~11;
var dayNum=parseInt(day); 
for( var i=1;i<dayNum+1;i++){
	$(".date").append('<div class="row"></div>');
	$(".row").eq(i-1).html("第"+i+"天"+"<br>"+"黑夜："+died[2*(i-1)]+"号玩家被杀死，真实身份是平民"+"<br>"+"白天："+died[2*(i-1)+1]+"号玩家被处决，真实身份是"+votedRole[i-1])
}
//回退按钮设置
function backGame(){
	sessionStorage.clear();
	window.location.href="gameSet.html";
} 
function backHome(){
	sessionStorage.clear();
	window.location.href="index.html";
} 