var div = document.getElementsByClassName('box'); //获取方块节点
var on = document.getElementById("on"); //获取开始按钮节点
var off = document.getElementById("off"); //获取结束按钮节点
var time; //声明定时器变量


function mycolor() {
    //随机生成十六进制颜色
    return '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).substr(-6);

}

on.onclick = function () { //点击开始
     
    time = setInterval(function () { //使用定时器
         
        start(3); //调用函数
         
    }, 1000) //设置时间
    this.disabled = true; //点击开始闪后不可再点击
    this.style.background = "#ccc";
    this.innerHTML="无法再次点击";
    this.style.cursor="not-allowed";
};

off.onclick = function () { //停止按钮的
     
    for (i = 0; i < div.length; i++) { //循环
         
        div[i].style.background = "#FFA500"; //遍历恢复原颜色
         
    } 
    clearInterval(time) //停止定时器
    on.disabled = false; //开始闪按钮恢复可点击
    on.style.background = "transparent";
    on.innerHTML="开始闪";

};

function start(num) { 
    
    var arr = new Array(num); //创建数组容纳随机数
    for (var i = 0; i < arr.length; i++) { //创建第一组数组
         
        var a = parseInt(Math.random() * 9);  //取得一个0-9随机数
        if (i == 0) { //第一个数字直接导入数组
            arr[i] = a; 
        } else { 
            for (var j = 0; j < i; j++) { //第二个与第三个数字进行判断
                if (a == arr[j]) { //如果重复从新开始
                    i-- 
                } else {  
                    arr[i] = a; 
                } 
            } 
        } 
    } ;

    for (var i = 0; i < div.length; i++) { //每次随机颜色时遍历将背景设置好
         
        div[i].style.background = "#FFA500"; 
    } ;
    for (var i = 0; i < arr.length; i++) { 
        div[arr[i]].style.background = mycolor(); //将随机的颜色给随机的地址 
    };
}