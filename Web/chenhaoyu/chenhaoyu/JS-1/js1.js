var box = document.getElementsByClassName("box");
// 获取页面中的小格子存入数组内部，生成一个类数组对象；
function resetColor() {
    for( i = 0 ; i<box.length;i++) {
         box[i].style.backgroundColor = "#ffa500";
    }
}
//重置颜色
var num = [];//创建新的空数组；
function boxNum() {
    for (i = 0 ;i < box.length;i++) {
        num.push(i);//把box的下标丢到mun数组里面
    }
    return num;
}
boxNum();// 生成了全局的数组num;
function randomNumber() {
    for (i = 0; i< num.length-1 ;i++) {
        var ran = Math.floor(Math.random()*num.length);//生成随机索引值
        var middle = num [ran];
        num [ran] = num [i];
        num[i] = middle;//设定一个中间变量middle,用于换位，
        // 将最后一位的元素和随机数进行互换位置；
     }
    return num;
}
randomNumber();
// 洗牌算法，乱序num数组，然后后续任意选取三位原色，作为box的后续改变颜色的索引值。
function randomColor() {
    r = Math.floor(Math.random()*256);
    g = Math.floor(Math.random()*256);
    b = Math.floor(Math.random()*256);
    if (" rgba(" + r + "," + g + "," + b + "," + "1)"
        === " rgba(255,165,0,1)") {
        return randomColor();
    }
    else {
        return " rgba(" + r + "," + g + "," + b + "," + "1)";
    }//递归防止和原来的重色
}
// 获取三个随机的数值，r，g，b，用来写进去,结果是一个字符串；
function changeColor() {
    resetColor();//变色前，先回复原来的原色；
    randomNumber();//洗牌打乱，生成索引值；
    console.log(num);
    box[num[0]].style.backgroundColor = randomColor();
    box[num[1]].style.backgroundColor = randomColor();
    box[num[2]].style.backgroundColor = randomColor();
}
var id;
function start() {
    clearInterval(id);
    id = setInterval("changeColor()",1000);
}
function stop() {
    clearInterval(id);
    resetColor();
}