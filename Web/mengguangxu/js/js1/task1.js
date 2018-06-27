//取出九个格子节点
var box=document.getElementsByClassName("box");
// 还原背景颜色
var i;
function clearColor(){
    for( i=0;i<box.length;i++){
        box[i].style.backgroundColor="#ffa600";
    }
}
//随机获取一个颜色
var r;
var g;
var b;
function arr(){
    r = Math.floor(Math.random()*256);
    g = Math.floor(Math.random()*256);
    b = Math.floor(Math.random()*256);
    //随机获取一种不等于橙色的颜色
    return "rgb(" + r + ',' + g + ',' + b + ')';
}
function color(){
     clearColor();//执行函数前先把颜色重置为背景颜色

    //第一种方法

    // var a =[];//装格子下标的数组
    // for(i=0;i<box.length;i++){//把格子数组的下标放进a数组，a数组等于[0,1,2,3,4,5,6,7,8]一共九个格子，下标就是0-8.
    //     a[i] = i;
    // }
    // //完全打乱数组的排序，保证每次都不一样。
    // var w = a.length;//数组长度
    // var x,y;
    // //随机选取一个元素
    // while(w){
    //     //随机选取一个数
    //     y = Math.floor(Math.random()*w--);
    //     //与当前元素进行交换
    //     x = a[w];//把数组最后的那个元素赋值给x
    //     a[w] = a[y];//把抽出来的那个元素与最后边的元素交换
    //     a[y] = x;
    // }
    // console.log(a);
    // box[a[0]].style.backgroundColor = arr();
    // box[a[1]].style.backgroundColor = arr();
    // box[a[2]].style.backgroundColor = arr();


    //第二种方法

    var a = [0,1,2,3,4,5,6,7,8];
            var w = a.length;
            var x,y;
            //随机选取一个元素
            while(w){
                //随机选取一个数
                y = Math.floor(Math.random()*w--);
                //与当前元素进行交换
                x = a[w];//把数组最后的那个元素赋值给x
                a[w] = a[y];//把抽出来的那个元素与最后边的元素交换
                a[y] = x;
            }
            console.log(a);
    box[a[0]].style.backgroundColor = arr();
    box[a[1]].style.backgroundColor = arr();
    box[a[2]].style.backgroundColor = arr();
    console.log(a[0]);
    console.log(a[1]);
    console.log(a[2]);

    //第三种方法

    // var num=[];
    // var temp=[];
    // for (var a = 0; a < 3; a++) {
    //     do {
    //         num[a] = Math.floor(Math.random() * box.length);
    //     } while (temp.indexOf(num[a]) >= 0);
    //     //检查数组中存不存在num[a]如果存在则循环
    //     temp.push(num[a]);
    //     //把（num[a]）放到一个空数组中去
    // }
    // box[num[0]].style.backgroundColor = arr();
    // box[num[1]].style.backgroundColor = arr();
    // box[num[2]].style.backgroundColor = arr();//分别把3个随机数给盒子数组，组成3个随机盒子，并把3个随机盒子分别改变颜色，并且颜色随机
}
var z;
function start(){
    clearInterval(z);
    z=setInterval("color()",1000);
}
function end(){
    clearInterval(z);
    clearColor();
}