/**
 * task1
 * @authors TZMMichael (15977536060@163.com)
 * @date    2017-12-29 11:33:37
 */

function startFlash() {
    var square = document.getElementsByClassName("square");//获取DOM
    var squareArray = Array.prototype.slice.call(square,0);//将dom对象伪数组转化为真数组
    /*
    1、注意，除了ID以外，使用这种类似get elements的方法，返回的是一个数组。
    2、更新：console.log(typeof square) 返回的是一个对象object，
    也就是说，这个square并不是一个数组，而是一个对象。
    也可以说，这个方法返回的square是一个伪数组，只支持length属性和索引，其他的数组方法不支持，
    这也就导致了下面的代码中splice这个数组方法报错了。 
    使用以下方法可以把这个对象改为一个真正的数组>>>
    var arr = [];
    for (var i = 0, len = myArray.length; i < len; i++) {
        arr[i] = myArray[i];
    }
    这里len是一个变量，可以写成下面这样>>>
    var arr = [];
    for (var i = 0, i < myArray.length; i++) {
        arr[i] = myArray[i];
    }
    此外，补充一个方法，可以直接将具有lenth属性的对象转化为数组>>>
    Array.prototype.slice.call(arguments)
    */
    for (i = 0; i < 9; i++) { //重置颜色
        squareArray[i].style.backgroundColor = "orange";
    }
    var randomArray = new Array();
    for (i = 0; i < 3; i++) {//将一个随机数放进随机数组中，并在原数组中把这个随机数删除,这个过程循环执行3次
        var num = Math.floor(Math.random()*squareArray.length);
        randomArray.push(squareArray[num]);
        squareArray.splice(num, 1);
    }
    /* 
    理解while循环>>>
    官方定义：当指定条件为真的时候，执行代码块里面的代码。
    条件为真是怎么回事呢？放到我上面的代码来看，那就是大于0的情况下为真。
    亲测=0的时候浏览器就崩溃了，也就是说进入了死循环。
    */
    function randomColor() {//随机颜色
        var hex = Math.floor(Math.random()*16777216).toString(16);
        while (hex.length < 6) {
            hex = "0" + hex;
        }
        return "#" + hex;
        /* 
        return '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).substr(-6);
        这个方法也可以，目前还不理解，PO下来，以后复习需要回顾看看。
        以下是分析：
        1、先执行Math.random() * 0x1000000， 其中0x1000000 = 0xffffff + 1， 因为Math.random() 取不到1， 所以 + 1， 这样就会生成一个1 - 16777216(不包含) 以内的浮点数。
        2、然后执行 << 0， 这是取整运算， 去掉后面的小数点。 这时为一个16777216(不包含) 以内的十进制数。
        3、之后执行.toString(16)， 把十进制数转化为六位以下16进制数。
        4、再后执行 '00000' + ，这时因为之前生成的16进制数最少可能仅一位， 在前面加上5个0。
        5、最后执行.substr(-6)， 是去从 - 6 开始的后面所有字符串， 也就是最后6位数。
        6、前面加上# 并retuen。 */

    }
    for (var i = 0; i < 3; i++) {//循环3次新数组，并将随机颜色赋给新数组
        randomArray[i].style.backgroundColor = randomColor();
    }
}

var mySet;
function startButton() {
    clearInterval(mySet);//每次执行定时器之前清除一次定时器，不然越亮越多越快，应该是相当于反复执行了多个定时器的意思？
    mySet = setInterval(startFlash, 1000);
}
function stopButton() {
    var square = document.getElementsByClassName("square");
    var squareArray = Array.prototype.slice.call(square, 0);
    for (i = 0; i < 9; i++) {
        squareArray[i].style.backgroundColor = "orange";
    }
    clearInterval(mySet);
}