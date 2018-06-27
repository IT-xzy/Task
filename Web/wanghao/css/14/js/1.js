//定义变量为盒子的id
var imgBox0 = document.getElementById("img-0");
var imgBox1 = document.getElementById("img-1");
var imgBox2 = document.getElementById("img-2");
var imgBox3 = document.getElementById("img-3");
//定义计时器的全局变量
var open = setInterval(function () {
    time()
}, 2000);
//如何一开始就使用定时器

//定义全局变量
var i = 0;

function time() {
    //延迟轮播
    setTimeout(function () {
        transform()
    }, 1000);
    //每次轮播事件+1
    i=i+1;
    console.log(i);
   // console.log(imgBox2);

}

function transform() {
    //i小于4的时候
    if(i<4){
         for (let e = 0; e < 4; e++) {
        let num="translateX"+"("+(-103*i+"vw")+")";
         eval("imgBox"+e).style.transform = num;
      //  console.log(eval("imgBox"+e));
        }
    
    } 
    
}