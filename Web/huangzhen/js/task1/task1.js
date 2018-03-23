// 定时器变量，不设置就说  time is not defined at begin 
var time;

// 绑定box
var box = document.getElementsByClassName("box");

function begin() {


    //随机生成9个255内数字。
    var color = [];
    for (var a = 0; a < 9; a++) {
        color[a] = Math.floor(Math.random() * 256);
    }
    console.log(color);

    //把数字转成3个rgb色
    var c0 = "rgb(" + color[0] + "," + color[1] + "," + color[2] + ")";
    var c1 = "rgb(" + color[3] + "," + color[4] + "," + color[5] + ")";
    var c2 = "rgb(" + color[6] + "," + color[7] + "," + color[8] + ")";
    console.log(c0, c1, c2);

    //从9个方块中随机取得3个小方块
    var index = [];
    while (index.length < 3) { //index.length代表数组的长度，当数组的长度不再满足小于3，跳出循环
        var randomindex = Math.floor(Math.random() * 9); //获得在0-9之间的随机数
        if (index.indexOf(randomindex) < 0) {
            //判断randomindex之前有没有在数组里面，如果没有，就添加进去，如果有，重新循环。
            // indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。
            index.push(randomindex);
            // 将randomindex这个随机数，添加到index这个数组里面。
        }
        console.log(index);
    }


    //每次循环把9个小方块全重置为默认色
    for (var c = 0; c < box.length; c++) {
        box[c].style.backgroundColor = "#fea500";
    }

    //把三种颜色填充入三个小方块中
    box[index[0]].style.background = c0;
    box[index[1]].style.background = c1;
    box[index[2]].style.background = c2;

    // 设置超时重复
    clearInterval(time);
    time = setInterval("begin()", 1000);
}


function stop() {
    clearTimeout(time);
    //循环过后重置颜色
    for (var c = 0; c < box.length; c++) {
        box[c].style.backgroundColor = "#fea500";
    }
}
