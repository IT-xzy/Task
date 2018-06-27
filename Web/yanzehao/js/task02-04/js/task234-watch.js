

//返回至玩家配比页面
function backto(){
  window.location.href = "../html/task234-peibi.html";
}
//"key"可以理解为密钥,拿着这把密钥就可以打开存储在浏览器本地的数据
var num = sessionStorage.getItem("key1"); 
var text = sessionStorage.getItem("key2"); 
var text1 = JSON.parse(text);
console.log(text1);
//点击次数初始值
var click=0;
//点击事件函数
document.getElementById('watch').onclick=function (){
  //点击一次变量递增1,即获取了点击次数
  click+=1;
  //json数据
  var obj = {
    //玩家编号
    "numb1":(click+1)/2,
    //隐藏传递的编号
    "numb2":(click+2)/2,
    "juese":"角色:" + text1[(click+1)/2-1],
    "cizu":"词组:西伯利亚",
    "note":"想办法猜到别人的词,同时还要注意不要暴露自己哦!",
    "btn1":"查看"+ (click+2)/2 +"号身份",
    "btn2":"隐藏并传递给"+ (click+3)/2 + "号",
  }
  console.log(obj.juese);
  //模/赋值操作符,x=0表示点击次数为偶数,x=1表示奇数
  x=click%2;
  console.log(x);
  //获取图片的DOM节点
  var imgObj = document.getElementById("images");
  //三目运算符实现点击更换图片
  var Flag=(imgObj.getAttribute("src")=="../images/16.png");
  imgObj.src=Flag?"../images/15.png":"../images/16.png";
  if((click+1)/2==num){
    document.getElementById("num").innerHTML=obj.numb1;
    document.getElementById("juese").innerHTML=obj.juese;
    document.getElementById("cizu").innerHTML=obj.cizu;
    document.getElementById("note").innerHTML=obj.note;
    imgObj.style['margin']=".30rem 0 .30rem 0";
    //最后一步,显示法官查看按钮
    document.getElementsByTagName("button")[0].innerHTML="法官查看";
  }
  else if((click+1)/2<=num){
    //当点击数为奇数时
    if(x==1){
      document.getElementById("num").innerHTML=obj.numb1;
      document.getElementById("juese").innerHTML=obj.juese;
      document.getElementById("cizu").innerHTML=obj.cizu;
      document.getElementById("note").innerHTML=obj.note;
      document.getElementById("note").style.padding=".10rem";
      document.getElementById("note").style['margin-top']=".10rem";
      document.getElementById("note").style['border-top']="2px #fffaee solid";
      document.getElementsByTagName("button")[0].innerHTML=obj.btn2;
      imgObj.style['margin']=".30rem 0 .30rem 0";
    }
    //当点击数为偶数时
    else{
      document.getElementById("num").innerHTML=obj.numb2;
      document.getElementById("juese").innerHTML=null;
      document.getElementById("juese").innerHTML=null;
      document.getElementById("cizu").innerHTML=null;
      document.getElementById("note").innerHTML=null;
      document.getElementById("note").style['border']="0";
      document.getElementsByTagName("button")[0].innerHTML=obj.btn1;
      imgObj.style['margin']=".80rem 0 0 0";
    }
  }
  //点击法官查看按钮实现页面跳转
  else {
    window.location.href = "../html/task234-riji.html";
  }
}        



