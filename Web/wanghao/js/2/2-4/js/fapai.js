// 捕捉箭头设置点击事件返回分配身份
$(".arrows").on("click",function(){
    window.location.href="../html/peopleNumber.html"
})
var outValue=JSON.parse(localStorage.getItem("outValue"));
console.log(outValue)
// 设定全局数字变量来判断点击到哪一步
var num=-0.5;
// 定义流程函数
function flow(){
    switch(true){
        case num%1!=0&&num<outValue.length-1://当num不是整数的时候。显示卡背
        kabei();
        break;
        case num%1==0&&num<outValue.length-1: //当num是整数的时候显示正面
        zhegnmian();
        break;
         case num==outValue.length-1: //当num为outValue的长度的时候
        end();
        break;
        default:
        localStorage.setItem("oject",JSON.stringify("法官")) //保存对象识别身份牌页面的效
        window.location.href="rizhi.html"; //跳转
    }}
  
//卡背函数
function kabei(){
    num=num+0.5;
    let number=num+1 //显示的数字
    $(".front").hide();  //正面影藏
    $(".back").show();   //卡背显示
    $(".number")[0].innerHTML=number;  //显示数字
    $(".inquire")[0].innerHTML=number+"号查看身份"  ;
}
//正面函数
function zhegnmian(){
    let number=num+1 //显示的数字
    let next=number+1 //下一位的身份
  $(".back").hide();  //正面影藏
  $(".front").show();   //卡背显示
  $(".number")[0].innerHTML=number;  //显示数字
  if(outValue[num]=="村民"){
    $(".logo")[0].src="../../image/狼人杀-logo/cunmin.jpg"
 }else{
    $(".logo")[0].src="../../image/狼人杀-logo/lang.jpg"
 }
  $("#killname").text(outValue[num]);
  $(".inquire")[0].innerHTML=number+"影藏身份给"+next+"号"
  num=num+0.5; 
}
// 最后一次函数
function end(){
    let number=num+1 //显示的数字
    let next=number+1 //下一位的身份
  $(".back").hide();  //正面影藏
  $(".front").show();   //卡背显示
  $(".number")[0].innerHTML=number;  //显示数字
  if(outValue[num]=="村民"){
    $(".logo")[0].src="../../image/狼人杀-logo/cunmin.jpg"
 }else{
    $(".logo")[0].src="../../image/狼人杀-logo/lang.jpg"
 }
  $("#killname").text(outValue[num]);
  $(".inquire")[0].innerHTML="法官查看"
  num=num+0.5; 
}


// 进入就运行一次
flow();
// 设置footer的点击事件
$("footer").on("click",function(){flow()})