'use strict';
    
    var aaa;
    function clickBox(){
        //多次点击后，定时执行函数会重复触发，导致颜色变化越来越快。原因是每点击一次，setInterval（）定时器的运行速度就会在原来的基础上加快一倍。需要进行定时器初始化，在setInterval（）前添加清除定时器clearInterval(mytime);
        clearInterval(aaa);


        aaa = setInterval(
        function chooseBox(){
        //获取九个子元素，将其定义为数组
        var a = document.getElementsByClassName('block'); 
        /*实现原理和过程：核心代码就是result.push(arr.splice(Math.floor(Math.random()*arr.length),1)[0]);，这个的原理就是每一次往result里面push一个元素，这个元素是从arr里面随便获取的。这里值得注意的一点，arr=Object.assign([],arrOld)这行代码就是为了，打乱的结果不影响原来的数组。比如传进来时[1,2,3]，执行了原来的数组还是[1,2,3]。只是产生了一个新的打乱的数组而已。*/
        function upsetOrder(arrOld, num){
          var result = [], _length = num || arrOld.length, arr;
          arr = Object.assign([], arrOld);
          for (var i=0, len=arr.length; i<len; i++){
            result.push(arr.splice(Math.floor(Math.random()*arr.length), 1)[0]);
          }
          return result;
        }
        upsetOrder(a);
        var x = upsetOrder(a);

        //在每一次事件被点击的时候将格子的颜色重新设置回橘色
        for (var i=0; i<9; i++){
          x[i].style.backgroundColor = 'orange';
        }
      

        function changeColor() {
        const r = Math.round(Math.random()*255);
        const g = Math.round(Math.random()*255);
        const b = Math.round(Math.random()*255);
        const color = `rgb(${r},${g},${b})`; 
        return color;
        }
        var color1 = changeColor(); 
        var color2 = changeColor(); 
        var color3 = changeColor(); 
      
        
        //给随机出来的格子新颜色
        (x[0]).style.backgroundColor = color1;
        (x[1]).style.backgroundColor = color2;
        (x[2]).style.backgroundColor = color3;
        },
        1000
      );
    }


    function backBox(){
      clearInterval(aaa);
      var b = document.getElementsByClassName('block');
      for (var i=0; i<9; i++){
        b[i].style.backgroundColor = 'orange';
      }
    }

    
