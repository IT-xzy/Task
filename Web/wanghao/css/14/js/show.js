//获取imgStyle本身
var imgFather = document.getElementsByClassName("show")[0];
//获取id show 下的所有元素
var img = document.getElementsByClassName("show")[0].children;
//console.log(img[0]);
//捕捉lunbo，设置鼠标放上去除计时器
// var lunbo=document.getElementsByClassName("lunbo")[0];
// imgFather.addEventListener("mouseover",lunboover);
// imgFather.addEventListener("mouseout",lunboout);
// function lunboover(){
//     var time;
// }
// function lunboout(){
//     alert("1");
//     clearInterval(time);
// }
//计数变量
var num = 1;
//设置一个定时器，让图片循环起来
var time = setInterval(function () {
    circulation()
}, 2000)

//循环函数
function circulation() {
    //margin 每次变化的左边负边距
    let margin = -(100 * num) + "vw"
    console.log(margin)
    //做一个if判断，如果num小于四的时候正常轮播
    if (num < 5 && num > -1) {
        //产生过渡效果的函数
        transition();
        //给外面的盒子设置-marginleft的变化
        imgFather.style.marginLeft = margin;
        //循环完成给全局变量mnum计数器添加+1；
        num++;
    } else if (num > 4) {
        if (num == 5) {
            //运行清楚过渡函数
            clearTransition();
            // clearTransition();
            //使节点1变化到show的最后一个节点
            let nods = imgFather.insertBefore(img[0], null);
            //改变marginLeft的数值使图片显示倒数第二张，也就是最后一张
            imgFather.style.marginLeft = "-300vw";
            //延时器调用，让节点1放到最后一个节点
            img5()

        }

    }
//num=-1的时候的函数
else {
    //清楚过渡
    clearTransition();
    //把最后一张一放到第一张
    let nodsLast = imgFather.insertBefore(img[4], img[0]);
    //调整div的marginLeft的大小
    imgFather.style.marginLeft = "-100vw"
    //延迟器
    let timeFirst = setTimeout(function () {
        //添加过渡效果
        transition();
        //调整matginleft
        imgFather.style.marginLeft = "0";
        //清楚过渡效果
        clearTransition();
        let lastNods = imgFather.insertBefore(img[0], null);
        imgFather.style.marginLeft = "-400vw"
    }, 1)
    clearTimeout(timeFirst);
    num = num + 6;
}
}
console.log(num)
//产生点击事件
//捕捉left，right的id
var left = document.getElementById("left");
var right = document.getElementById("right");

//left 的点击事件
left.addEventListener("click", $left, false);

function $left() {
    
    clearTimeout(time);
    num = num - 1;
   circulation();

}
right.addEventListener("click", $right, false);

function $right() {
   
    clearTimeout(time);
    num = num + 1;
   circulation();
}
//产生过渡效果的函数
function transition() {
    imgFather.style.transition = "margin 0.5s";
}
//清楚过渡效果的函数
function clearTransition() {
    imgFather.style.transition = "initial";
}
//延时器调用，让节点1放到最后一个节点
function img5() {
    var img5time = setTimeout(function () {
        //赋予过渡效果
        transition();
        //    调整margin-left
        imgFather.style.marginLeft = "-400vw";
        num = num - 4;
    }, 1);
    var img1time=setTimeout(function(){
    //         //清楚过渡效果
             clearTransition();
    //         //把节点放回去
             let firstNods = imgFather.insertBefore(img[4], img[0]);
            imgFather.style.marginLeft = "0";
    //         console.log(imgFather.style.marginLeft);
    //          num = num - 3;
    //    // }, 10);
    //     //clearTimeout(timeShow);
    //    }
    },600);
}