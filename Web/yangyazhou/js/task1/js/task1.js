$(function () {
    //获取所有九宫格节点
    var nodes = $('.item');
    //设置数组，获取其中3个节点，这个函数的作用是放入数组取得相应的节点
    function getRandomArrayElements(arr, count) {//count就是取得节点的数值，我们这个任务取3
        var shuffled = arr.slice(0),//复制数组
            length = arr.length,    //获得数组长度
            min = length - count,   //获取数组剩余项
            temp, index;       
        while (length-- > min) {     //进行循环
            index = ~~((length + 1) * Math.random()); //获取整数
            temp = shuffled[index];        //获取随机数组项，存入变量temp中  
            shuffled[index] = shuffled[length]; //把数组最后一项赋值给随机项
            shuffled[length] = temp;           //数组最后一项存入temp值
        }
        return shuffled.slice(min);       //完成循环，截取最后的随机项
    }
       var interval;
    //获取随机颜色
    function bgcolors() {
        //新颜色
        return `rgb(${~~(Math.random()*256)},${~~(Math.random()*256)},${~~(Math.random()*256)})`;

        // return '#' + Math.floor(Math.random() * 0xffffff).toString(16);
    }
    //开始按钮点击触发事件
    $('#startBtn').on('click', function () {
        
        if(interval){
            clearInterval(interval);
        }//如果定时器存在，清除定时器，放置点击一次按钮，出现多个interval函数
        interval = setInterval(function () { //建立interval循环函数，每1s触发一次
            nodes.css('background', '#FFA500');
            var nodearr = getRandomArrayElements(nodes, 3);//获取3个随机dom节点
            for (var i = 0; i < 3; i++) {
                var bgcolor = bgcolors(); //获取随机颜色
                nodearr[i].style.background = bgcolor;
            }
        }, 1000);
    });
    //结束按钮，先清除定时器
    $('#endBtn').on('click',function(){
        clearInterval(interval);
        nodes.css('background', '#FFA500');
    })
        
    });
    