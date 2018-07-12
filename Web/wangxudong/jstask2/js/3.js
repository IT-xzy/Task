var arr = []; //建立空数组  添加好人和坏人
operation(); //默认值需要运行这个函数
$( "#back" ).click(function() {      //返回按钮
    window.location.href='2.html'; 
   });

$("#dome").on("input", function () {    //正则   input事件
    this.value = this.value.replace(/[^0-9]+/, '');
    operation();
});

$("#goto").click(function(){     //开始按钮    做判断 不符合的话就弹窗
    if ($("#dome").val() > 3 && $("#dome").val() < 19) {
        $(location).attr('href', '4.html');
    }
    else{
        $("#pop-up").show();
    }
})
$(".none").click(function() {     //弹窗消失
    $("#pop-up").hide();
})

//捕捉input值检测 运算符合标准的数组
function operation() {
    var a = $("#dome").val() ; //建立 方便比较
    window.localStorage.setItem('sum',a); //存储数据 是纯数字的value值所以没有转换格式
    if (a < 6 && a > 3) {
        arr[0] = 1;
    } else if (a > 5 && a < 9) {
        arr[0] = 2;
    } else if (a > 8 && a < 12) {
        arr[0] = 3;
    } else if (a > 11 && a < 16) {
        arr[0] = 4;
    } else if (a > 15 && a < 19) {
        arr[0] = 5;
    } else { //找不到合适的人数就变为0
        $("#bad").html("0");
        $("#good").html("0");
        return;
    }
    arr[1] = a - arr[0]; //符合条件的值传分配给好人坏人
    $("#bad").html(arr[0]);
    $("#good").html(arr[1]);
    
    var arr1 = []; //建立局部空数组方便使用
    for (let i = 0; i < arr[0]; i++) { //循环出坏人有几个就传入空数组b几个
        arr1.push('狼人');
    }
    for (let i = 0; i < arr[1]; i++) { //循环出好人有几个就传入空数组b几个
        arr1.push('好人');
    }
    var len = arr1.length; //设置变量等于数组长度
    for (var i = 0; i < len - 1; i++) { //给b数组乱序 使好人坏人随机
        var idx = Math.floor(Math.random() * (len - i));
        var temp = arr1[idx];
        arr1[idx] = arr1[len - i - 1];
        arr1[len - i - 1] = temp;
    }
    window.localStorage.setItem('identity', JSON.stringify(arr1)); //转换格式 保存数据

}