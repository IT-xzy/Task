 var open = document.getElementById("open"); //定义变量
 var close = document.getElementById("close"); //定义变量
 var classList = document.getElementsByClassName("box"); //全局类名变量
//定时器事件
var mytime ; //计时器1000毫秒一次
var redo=true; 

 open.addEventListener("click", $open);

 function $open() { //查询id=opne，富裕点击事件
     //开始闪按钮变色
     
     
     console.log(redo);
     if(redo){
    this.style.background = "#fea600";
     this.style.color = "#fff";
     //取消id=close的点击事件。
     close.style.background = "#fff";
     close.style.color = "#fea600";
     mytime = setInterval(function () {
          timeLag()
      }, 1000);
        redo=false;
    };
    
    console.log(redo)
      
    }
     

     function timeLag() {
         //设置3个随机数
         //1.建立01-9的数组
         var num = [];
         for (let i = 0; i < 9; i++) {
             num.push(i);
         }
         //  console.log(num);
         var out = [];
         for (let i = 0; i < 3; i++) {
            // var b = num;
             //产生随机数,取整
             let temp = Math.floor(Math.random() * num.length);
             //将得出的随机数赋予out数组
             out.push(num[temp]);
             //删除num数组中的已取随机数
             num.splice(temp, 1);
             //console.log(out);
         }
         //取三个随机颜色
         var color = [];
         var colorReal = [];
         //循环三次去除重复颜色。
         for (let i = 0; i < 3; i++) {
             a()
             let e=0;
               if (color[i] == color[i-1]){
                   i-1;
                   e++;
                   continue;
               }
               else if(color[i] == color[i-2]){
                  i-1;
                  e++
               }
               else{
                colorReal.push(color[i+e]);
               }
         };
         //console.log(colorReal);
    //产生随机颜色；
         function a() {
            var colorChange = parseInt(Math.floor(Math.random()* (0xffffff+1)));
           colorChange ="00000"+colorChange.toString(16);
           if(colorChange.length>6){
               colorChange="#"+colorChange.substring(colorChange.length-6,colorChange.length)
           };
            color.push(colorChange);
            //console.log(color);
        };
        for(let i=0;i<3;i++){
            classList[out[i]].style.background=colorReal[i];
        }
       
         //     //      //给三个随机数分配颜色
        setTimeout(function(){
           for (let i=0;i<9;i++) {
            classList[i].style.background = "#fea600";
        } 
 }, 900);
        };
     


 close.addEventListener("click", $close);

 function $close() { //查询id=close，富裕点击事件
     //开始闪按钮变色
     this.style.background = "#fea600";
     this.style.color = "#fff";
     //取消id=open的点击事件。
     open.style.background = "#fff";
     open.style.color = "#fea600";
     clearInterval(mytime);
     redo=true;
 };