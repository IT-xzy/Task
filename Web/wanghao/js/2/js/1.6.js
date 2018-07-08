// 取回本地保存的数据，并转成数组
var outValue = JSON.parse(localStorage.getItem("outValue"));
var outNumber=JSON.parse(localStorage.getItem("outNumber"));
console.log(outValue);
console.log(outValue.length);
console.log(outNumber);
// 捕捉卡背和正面
var back = document.getElementsByClassName("back")[0];
var front = document.getElementsByClassName("front")[0];
// 捕捉每次改变的文字和数字
var killname =  document.getElementById("killname");
var number = document.getElementsByClassName("number")[0];
var inquire = document.getElementsByClassName("inquire")[0];
// 捕捉logo图片节点
var logo=document.getElementsByClassName("logo")[0];
// 捕捉footer并设置点击事件
var footer = document.getElementsByTagName("footer")[0];
// 声明一个全局变量num用来监听身份分配
var num = -0.5;
footer.addEventListener("click", allot);

function allot() {
    // 每次运行影藏卡背卡面，并重置牌的数字,重置图片
    back.style.visibility = "hidden";
    front.style.visibility = "hidden";
    killname.innerHTML = "";
    number.innerHTML = "";
    inquire.innerHTML = "";
    logo.src="";
    // 判断全局变量是否超过分配数
    if (num < outValue.length-1) {
        // 当num为整数的时候显示正面
        if (num - Math.floor(num) == 0) {
            // 显示数字
            let numX=num + 1;
            let numY=numX+1;
            number.innerHTML = numX;
            // 显示正面
            front.style.visibility = "visible";
            // 调用显示正面的函数
            identity();
            // 更改footer里面的文字
            inquire.innerHTML="隐藏并传递给"+numY+"号";
        }
        
        // 当num有小数的时候显示为卡背
        else {
            // 显示数字
            let numX=num+1.5;
            number.innerHTML = numX;
            // 显示卡背
            back.style.visibility = "visible";
             // 更改footer里面的文字
             inquire.innerHTML="查看"+numX+"号身份";
        }
    }
    // 超过的时候变成跳转
    else if(num==outValue.length-1) {
        // 显示数字
        let numX=num + 1;
       
        number.innerHTML = numX;
        // 显示正面
        front.style.visibility = "visible";
        // 调用显示正面的函数
        identity();
        // 更改footer里面的文字
        inquire.innerHTML="法官查看";
       
    }
    else{
          // 显示数字
          num=num-0.5;
          let numX=num + 1;
          number.innerHTML = numX;
          // 显示正面
          front.style.visibility = "visible";
          // 调用显示正面的函数
          identity();
          // 更改footer里面的文字
          inquire.innerHTML="法官查看";
        window.location.href="dome1.7.html" ;
    }
    num = num + 0.5;
    
}
// 每次开始的时候运行一次
allot();
// 正面分配函数
// console.log(killname);
function identity(){
    // console.log(killname);
    // 赋予name节点身份
    killname.innerHTML=outValue[num];

    //console.log(name);
    // 分配对应身份的图片
    switch(true){
        case outValue[num]=="村民":
        logo.src="image/狼人杀-logo/cunmin.jpg";
        break;
        case outValue[num]=="狼人":
        logo.src="image/狼人杀-logo/lang.jpg";
        break;
        case outValue[num]=="白痴":
        logo.src="image/狼人杀-logo/baichi.jpg";
        break;
        case outValue[num]=="猎人":
        logo.src="image/狼人杀-logo/猎人.jpg";
        break;
        case outValue[num]=="女巫":
        logo.src="image/狼人杀-logo/nvwu.jpg";
        break;
        case outValue[num]=="预言家":
        logo.src="image/狼人杀-logo/yuyanjia.jpg";
        break;
        case outValue[num]=="守卫":
        logo.src="image/狼人杀-logo/守卫.jpg";
        break;
    }
}
var arrows =document.getElementsByClassName("arrows")[0];
arrows.addEventListener("click",arrowsLink);
function arrowsLink(){
    window.location.href="dome1.5.html"
}