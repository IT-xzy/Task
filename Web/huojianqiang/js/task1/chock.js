var Obtain = document.getElementById("one");//获取到的class id
var Obtain_1 = Obtain.getElementsByClassName("small");//class dom
var arr = [0, 1, 2, 3, 4, 5, 6, 7, 8]//索引数组
var clock;//防止越点越快
var g = 2;

function randomColor() {//抽取随机颜色，保证抽取的不重复

    return '#' + Math.floor(0x1000000 + Math.random() * 0x1000000).toString(16).slice(1);

}
//使用16制式随机获取的颜色

//随机抽取的dom变更颜色为随机
function dianji() {
    var getClasss = document.getElementsByClassName('small');
    for (i = 0; i < 9; i++) {
        getClasss[i].style.background = "#2570a1";
    }
    var randomColor_1 = randomColor();
    var randomColor_2 = randomColor();
    var randomColor_3 = randomColor();
    var index = [];
    while (index.length < 3) { //index.length代表数组的长度，当数组的长度不再满足小于3，跳出循环
        var randomindex = Math.floor(Math.random() * 9); //获得在0-9之间的随机数
        if (index.indexOf(randomindex) < 0) {
            //判断randomindex之前有没有在数组里面，如果没有，就添加进去，如果有，重新循环。
            // indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。
            index.push(randomindex);
            // 将randomindex这个随机数，添加到index这个数组里面。
        }
        // console.log(index);
    }
    getClasss[index[0]].style.background = randomColor();
    getClasss[index[1]].style.background = randomColor();
    getClasss[index[2]].style.background = randomColor();
}
//开始闪烁
function start_flash() {//延时操作
    if( g == 2){
        clearInterval(clock);
        clock = setInterval('dianji()', 1000);
        g++;
    }
    console.log(g);
}

//结束闪烁
function end_flash() {//结束延时，并且重置颜色为
    g = 2;
    clearInterval(clock);//清除计时器
    var getClasss = document.getElementsByClassName('small');
    for (i = 0; i < arr.length; i++) {
        getClasss[i].style.background = "#2570a1";
    }
};