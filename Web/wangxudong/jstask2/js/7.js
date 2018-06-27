var data = JSON.parse(localStorage.getItem('identity'));      //原始数组
var box = document.getElementsByClassName('box');        //所有的box节点
var id = document.getElementsByClassName('id');       //文字  节点  好人坏人那里
var a ;
var arr = JSON.parse(sessionStorage.getItem('data'));         //传过来的对象数组
var arr1 = JSON.parse(sessionStorage.getItem('data3'));        //保存的杀人动作的数组  返回来继续往里添加
$("#homepage").click(function backHome() {               //关闭按钮
    sessionStorage.clear(); 
    if (confirm("确定关闭游戏嘛 ")) {
        $(location).attr('href', '1.html');
    }
});
 for ( let i = 0; i < data.length; i++) {             //循环生成所有玩家盒子 和身份
        $(box[i]).css('display','block');
        if (data[i] == '好人') {
            $(id[i]).html('平民');       
        }
        else {
           $(id[i]).html('狼人');
         }
     }

    $(".box").click(function () {
         a = $(this).index();
    })

    for (let i = 0; i < data.length; i++) {        //死了的玩家上颜色
         if (arr[i].state == 'died') {
            $(id[i]).css('backgroundColor','green');
        }
    }
if(arr1 == null) {           //第一天进来 使空的所以需要定义成空数组才能向里push
    arr1= [];
}
$("#begin").click(function () {                //杀死按钮
     if(!a){                         //没杀人执行的操作
        arr1.push('杀手没有杀人');
        sessionStorage.setItem('data3', JSON.stringify(arr1));
        window.sessionStorage.setItem('data', JSON.stringify(arr));
        $(location).attr('href', '6.html');
        return
    }
    if (arr[a].state != 'live'){           //死亡玩家不能重复杀死
          alert('该玩家已死');
          return
        } 
      else if(arr[a].name == '狼人'){     //不能杀狼人阵营
          alert('不能杀狼人');
          return
      }  
    arr[a].state = 'died';                                     //给死亡玩家 对象属性发生变化
    arr1.push(arr[a].id + '号玩家被杀死，真实身份是好人');
    sessionStorage.setItem('data3', JSON.stringify(arr1));
    window.sessionStorage.setItem('data', JSON.stringify(arr));
    var n = 0;                                                    //建立两个基础类型    根据活着的玩家 身份 判定输赢
    var m = 0;
    for(let i=0; i<data.length; i++){
        if(arr[i].state == 'live' && arr[i].name == '平民') {
               n += 1
        }   
        else if (arr[i].state == 'live' && arr[i].name == '狼人'){
            m += 1 ;
        }
    }
    sessionStorage.setItem('goodlive', JSON.stringify(n));          //保存这个值 给结束页面  方便在结束页面进行判定
    sessionStorage.setItem('badlive', JSON.stringify(m));
    if( n == m ) {
        
        window.sessionStorage.setItem('data', JSON.stringify(arr));       
        $(location).attr('href', '9.html');
        return
    }
    $(location).attr('href', '6.html');
})



