$(document).ready(function () {
    var Arr=JSON.parse(sessionStorage.getItem("Arr"));//获取之前的数组
    var back=JSON.parse(sessionStorage.getItem("back"));
    $("#return").on("click", function () {
        if (confirm("确认关闭？")) {
            window.location.href="task13-1.html";
        }
    });// 回退按钮
    (function(){
        console.log(Arr);
        for (var i=0; i<Arr.length; i++){
            $("#main").append(' <div  class="block">\n' +
                '                  <div class="block1">\n' +
                '                    <div class="title"> ' + Arr[i] + '</div>\n' +
                '                    <div class="number" >' + (i+1) + '</div>\n' +
                '                </div>\n' +
                '                </div>')//添加div
        }
    }());
    if(back===1){
        $(" #go").text("返回");
        $("#go").on("click", function () {
            window.location.href="js-task4-1.html";
        });
    }
    else {
        $("#go").on("click", function () {
            window.location.href="js-task4-1.html";
            window.sessionStorage.setItem('day', "1");
        });//开始按钮
    }
});