window.onload = function(){
    var gridList = document.getElementsByClassName("grid");
    var begin = document.getElementById("begin");
    var end = document.getElementById("end");
    var timer;
    var flag = 0;
    // 随机n个格子并且随机颜色,把这些方法封装到一个change函数中
    function change(n){
        var arr = [];  // 用来储存所有格子的下标的数组，比如这里存9个格子下标就是0~8
        for(var i = 0; i < gridList.length; i++){
            arr[i] = i;
        }
        // 返回一个含n个随机数的数组
        function randomNum(n){
            var reslut = [];  // 用来储存得到的n个随机数的数组
            for(var i = 0; i < n; i++){
                var random = Math.floor(Math.random()*arr.length);  // 从arr数组中随机取一个数
                reslut.push(arr[random]);  // 给reslut数组添加一个随机元素
                arr.splice(random, 1);  // 在arr数组里删除随机选中的元素，避免重复
            }
            return reslut;
        }
        // 赋值num一个指定数目、随机元素的数组
        var num = randomNum(n);
        // 获取颜色方法一：
        // 随机获得一种rgb类型的颜色
        function randomColor(){
            var r = Math.floor(Math.random()*256);
            var g = Math.floor(Math.random()*256);
            var b = Math.floor(Math.random()*256);
            return "rgb(" + r + "," + g + "," + b + ")";
        }
        /*获取颜色方法二：
        随机获得一种十六进制颜色
        function randomColor1(){
            var r = Math.floor(Math.random()*256);
            var g = Math.floor(Math.random()*256);
            var b = Math.floor(Math.random()*256);
            if(r < 16){
                r = "0"+r.toString(16);
            }else{
                r = r.toString(16);
            }
            if(g < 16){
                g = "0"+g.toString(16);
            }else{
                g = g.toString(16);
            }
            if(b < 16){
                b = "0"+b.toString(16);
            }else{
                b = b.toString(16);
            }
            return "#"+r+g+b;
        }*/
        // 更改n个随机格子的样式
        function changeColor(){
            for (var i = 0 ; i < n; i++) {
                gridList[num[i]].style.backgroundColor = randomColor();
            }
        }
        return changeColor();
    };
    // 开始变化,可自行选择变化的数量
    var beginChange = function (){
        restoreColor();
        change(3);
    };
    // 还原颜色
    var restoreColor = function (){
        for(var i = 0; i < gridList.length; i++){
            gridList[i].style.backgroundColor = "#ffa600"; // 遍历每个格子变成原色
        }
    };
    // 开始函数
    function beginFun(){
        clearInterval(timer); // 执行前先清除setInterval，避免重复点击导致越来越快
        timer = setInterval(beginChange, 1000); // 1000毫秒即1秒钟，重复执行
    };
    // 结束函数
    function endFun(){
        clearInterval(timer);
        restoreColor();
    };
    // 给按钮注册点击事件
    begin.onclick = beginFun;
    end.onclick = endFun;
    // 键盘事件
    document.onkeyup = function (event){
        event = event || window.event;
        if(event.keyCode == 13){ // 回车键的键码为13
            if(flag == 0){  // 如果flag为0则表示没有按过回车键
                beginFun();
                flag = 1;
            }else{
                endFun();
                flag = 0;
            }
        }
    };
}