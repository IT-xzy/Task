window.onload = function(){
    var gridList = document.getElementsByClassName("grid");
    var begin = document.getElementById("begin");
    var end = document.getElementById("end");
    var timer;
    var flag = 0;
    // 随机三个格子并且随机颜色,把这些方法封装到一个change函数中
    function change(){
        // 遍历9个格子组成一个0~8的数组，用来作为下标
        var arr = [];
        for(var i = 0; i < gridList.length; i++){
            arr[i] = i;
        }
        // 指定n个随机数，返回一个含N个随机数的数组
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
        var num = randomNum(3);
        // 给三个变量赋值随机数组中的元素
        var one = num[0];
        var two = num[1];
        var three = num[2];

        // 获取颜色方法一：
        // 随机获得一种rgb类型的颜色
        function randomColor(){
            var r = Math.floor(Math.random()*256);
            var g = Math.floor(Math.random()*256);
            var b = Math.floor(Math.random()*256);
            return "rgb(" + r + "," + g + "," + b + ")";
        }
        // 获取颜色方法二：
        // 随机获得一种十六进制颜色
        // function randomColor1(){
        //     var r = Math.floor(Math.random()*256);
        //     var g = Math.floor(Math.random()*256);
        //     var b = Math.floor(Math.random()*256);
        //     if(r < 16){
        //         r = "0"+r.toString(16);
        //     }else{
        //         r = r.toString(16);
        //     }
        //     if(g < 16){
        //         g = "0"+g.toString(16);
        //     }else{
        //         g = g.toString(16);
        //     }
        //     if(b < 16){
        //         b = "0"+b.toString(16);
        //     }else{
        //         b = b.toString(16);
        //     }
        //     return "#"+r+g+b;
        // }

        // 更改三个随机格子的样式
        function changeColor(){
            gridList[one].style.backgroundColor = randomColor();
            gridList[two].style.backgroundColor = randomColor();
            gridList[three].style.backgroundColor = randomColor();
        }
        return changeColor();
    }
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
    // 开始函数
    function beginFun(){
        clearInterval(timer); // 执行前先清除setInterval，避免重复点击导致越来越快
        timer = setInterval(function (){
            for(var i = 0; i < gridList.length; i++){
                gridList[i].style.background = "#ffa600"; // 遍历每个格子变成原色
            }
            return change();
        }, 1000); // 1000毫秒即1秒钟，重复执行
    };
    // 结束函数
    function endFun(){
        clearInterval(timer); // 清除setInterval
        for(var i = 0; i < gridList.length; i++){
            gridList[i].style.background = "#ffa600"; // 遍历每个格子变成原色
        }
    };
}