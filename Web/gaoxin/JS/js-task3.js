$(document).ready(function () {
    var Arr=JSON.parse(sessionStorage.getItem("Arr"));//获取之前的数组
    var killer=JSON.parse(sessionStorage.getItem("killer"));
    var people=JSON.parse(sessionStorage.getItem("people"));
    console.log(Arr);
    console.log(killer);
    console.log(people);
    var i=0;
    $("#return").on("click", function () {
        window.location.href = "js-task2.html";
    });// 后退按钮
    $("#close").on("click", function() {
        if (confirm("确认关闭？")) {
            window.location.href="task13-1.html";
        }
    });//关闭按钮
    $("#btn1").on("click", function () {
        i=i+1;
        $("#img1").toggle();
        $("#img2").toggle();
        $("#check").toggle();
        $("#hide").toggle();
        $("#rolebox").toggle();//背景图片和按钮内容 替换
        if (i<Arr.length*2){
            $("#circle").text(Math.floor(i/2)+1);
            $("#num").text(Math.floor(i/2)+1);//圆圈和玩家号码的修改
        }
        if (Arr[Math.floor(i/2)]==="杀手"){
            $("#role").text("杀手");
            $("#tips").text("想办法杀掉所有平民，同时还要注意不要暴露身份哦");//身份显示
        }
        else {
            $("#role").text("平民");
            $("#tips").text("想办法找出所有杀手，同时注意不要被误认为杀手");//身份显示
        }
        if (i===2*Arr.length){
            $("#btn1").hide();
            $("#btn2").show();//显示查看法官日志
        }
    });
    $("#btn2").on("click", function () {
        window.location.href = "js-task3-2.html";
    });
});




