
window.onload=function() //网页加载之后执行 
{
//变量
var div = document.getElementsByTagName('div');//获取div标签
// console.log(typeof div);


// console.log(div.length);
var flash = document.getElementById('flash');//
var cancel = document.getElementById('cancel');
var time;
// 输出随机div背景颜色
function thethree (){
  var num1 = Math.floor(Math.random()*div.length);  //0-8的整数;
  var num2 = Math.floor(Math.random()*div.length);  //0-8的整数;
  var num3 = Math.floor(Math.random()*div.length);  //0-8的整数;

  if(num1 == num2){
    num1 = Math.floor(Math.random()*div.length);
  }else if(num2 == num3){
    num2 = Math.floor(Math.random()*div.length);
  }else if(num1 == num3){
    num3 = Math.floor(Math.random()*div.length);
  }
  console.log(num1,num2,num3);

  // div[num1].style.background = '#'+ colors();
  div[num1].style.background = '#32cc0';  
  div[num2].style.background = '#'+ colors();
  div[num3].style.background = '#'+ colors();
}
// function thethree (){
//   // var div = Math.floor(Math.random()*div.length);
//   var result = [];
//   var ranNum = 3;
//   for (var i = 0; i < ranNum; i++) {
//     var ran = Math.floor(Math.random() * div.length);
//     result.push(div.splice(ran, 1)[0]);
//   }
// }

//随机颜色
function colors (){
  var col = Math.floor(Math.random()*Math.pow(255,3));
  var c16 = col.toString(16);
  return c16;
  console.log(c16);
  
}

//开始闪
flash.onclick = function(){  
  clearInterval(time);  
  time = setInterval(function(){  
    for(var i = 0; i < div.length; i++){  
      div[i].style.background = '';  
    }  
    thethree(); 
  },1000);  
} 
//取消闪
cancel.onclick = function(){  
  clearInterval(time);  
  for(var i = 0; i < div.length; i++){  
    div[i].style.background = '';  
  }  
} 
}