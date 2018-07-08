        var boxes = document.getElementsByClassName("box"); //获取节点数组
        var arr = []; //建立空数组  装随机3个数
        var colors = []; //装随机颜色数组
        var time; //创建个全局变量  用来赋予定时器
        var begin = document.getElementById('begin');
        var end = document.getElementById('end');
        // 生成随机3个数字  9以内 去重
        function number() {
            for (let i = 0; i < 3; i++) {
                arr.unshift(Math.floor((Math.random() * 9)))         //向数组前添加
            };
            if (arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]) {
                return arr;
            } else {
                number();
            }

        }

        // 生成随机颜色   给节点数组前三个 设定随机颜色
        function give() {
            for (let i = 0; i < 3; i++) {
                var color = Math.floor(Math.random() * 16777216).toString(16);
                if (color.length < 6) {
                    
                    give()
                } else {
                    colors.unshift('#' + color)
                }

            }
            boxes[arr[0]].style.backgroundColor = colors[0];
            boxes[arr[1]].style.backgroundColor = colors[1];
            boxes[arr[2]].style.backgroundColor = colors[2];

        }
        //选区全部9个节点 赋予颜色变成原来的颜色  用来清除循环上次的颜色
        function back() {
            for (let i = 0; i < 9; i++) {
                boxes[i].style.backgroundColor = 'orange';
            }
        }

        function all() {             //封装函数
                back();
                number();
                give();
        }
    

       // 点击运行  并且1s 一直循环
       begin.onclick = function go() {
           clearInterval(time);
               all()

            time = setInterval(function y() { 
                all()
              
            }, 1000);
        }


        // 点击运行  结束循环 清除彩色
       end.onclick = function over() {
            clearInterval(time);
            back()
        }