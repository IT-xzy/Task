//开始运行函数
var myVar;
var kaiguan=true;
function start() {
    if(kaiguan) {
        myVar = setInterval(threeNum, 1000);
        kaiguan=false;
    }
}
//终止函数，所有块回复原背景色
function over() {
    clearInterval(myVar);
    var b = document.getElementsByClassName("table");
    for(var i=0;i<b.length;i++)
        b[i].style.background = "orange";
    kaiguan=true;
}



//函数封装
 function threeNum() {
//声明一个数组
    var b = [];
    //调用随机数函数
    for (var e = 0;b.length<3 ; e++){
            boxNum()
        }
    //生成一个0-9之间的随机整数,并且将其和数组内的数字比较，如果相同，则不push给数组，如果不同，则push给数组
     function boxNum() {
         var box = Math.floor(Math.random() * 9);
         for (var i = 0; i < 3; i++) {
             if (b[i] === box) {
                 return false;
             }
         }
         b.push(box);
     }
     //先重置背景色,然后再给随机3个格子上色
    var ab = document.getElementsByClassName("table");
     for(var i =0; i < 9; i ++){
        ab[i].style.background = "orange";
     }
    for (var i = 0; i < 3; i++) {
        var c = b[i];
        ab[c].style.background = color();
    }


//随机颜色函数
    function color() {
        var hex = Math.floor(Math.random() * 16777216).toString(16);
        while (hex.length < 6) {
            hex = '0' + hex;
        }
        return '#' + hex;
    }
}