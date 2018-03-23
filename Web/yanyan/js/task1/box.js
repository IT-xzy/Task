var box = document.getElementsByClassName("box");


function change() {

    function random_color() {
        function r() {
            return Math.floor(Math.random() * 256)
        }
        return "rgb(" + r() + "," + r() + "," + r() + ")";
    }//随机获得一种颜色

    var color1 = String(random_color());
    var color2 = String(random_color());
    var color3 = String(random_color());//函数变为字符串，设三个随机颜色


    var ax = new Array(box.length);
    for (var i = 0; i < box.length; i++) {
        ax[i] = i;
    }//遍历box类组成一个数组

    function get_three_num(n) {
        var reslut = [];
        for (var i = 0; i < n; ++i) {
            var random_num = Math.floor(Math.random() * ax.length);//从ax数组中取一个随机数
            reslut.push(ax[random_num]);//给reslut数组添加一个随机元素
            ax.splice(random_num, 1);//在x数组里删除随机选中的元素
        }
        return reslut;
    }//可指定元素数量的随机数组
    var xbox = get_three_num(3);//赋值xbox一个指定数目、随机元素的数组

    var one = xbox[0];
    var two = xbox[1];
    var three = xbox[2];//给三个变量赋值随机数组中的元素

    function task() {
        box[one].style.backgroundColor = color1;
        box[two].style.backgroundColor = color2;
        box[three].style.backgroundColor = color3;//更改三个随机box的样式

    }

    return task();
}//随机选择三格变随机颜色,封到一个函数中

var time;

function star_color() {
    clearInterval(time);//执行前先清除setInterval
    time = setInterval(function () {
        for (var i = 0, max = box.length; i < max; i++) {
            box[i].style.background = "orange";
        }//遍历每个box类变成原色
        return change();
    }, 1000);//1000毫秒重复执行
}

function stop_color() {
    clearInterval(time);//清除setInterval
    for (var i = 0, max = box.length; i < max; i++) {
        box[i].style.background = "orange";
    }//遍历每个box类变成原色
}

