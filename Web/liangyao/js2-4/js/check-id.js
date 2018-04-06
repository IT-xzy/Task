/**
 * Created by Administrator on 2017/11/13/013.
 */
//从本地存储里取出name的值（字符串），转换为数组
localStorage.getItem("randomArray");
localStorage.valueOf();
var sum= localStorage.getItem("randomArray").split(",");

//点击事件
var i=0;




$(document).ready(function () {
    $("#f_check").click(function () {
        i++;
        console.log(i);
        $("#man").toggle("");
        $("#woman").toggle("");
        console.log(sum);
        //当超过数组长度时，跳转到下一页面
        if(i<2*sum.length-1){
            //奇偶判定
            if(i%2===0){  //当i为偶数时
                var j=i/2;
                var k=i/2+1;
                $("#f_check").text("查看"+k+"号身份");
                $("#p-number").text(k);

            }else if (i%2===1){  //当i为奇数时
                var j=(i+1)/2;
                var k=j+1;
                $("#f_check").text("隐藏并传递给"+k+"号");
                $("#p-number").text(j);
                $("#puker").text(sum[j-1]);

            }
        }else {
            $("#f_check").text("查看法官页面");
            $("#f_check").click(function () {
                location.href="http://student.task.web.ptteng.com/liangyao/js/task2-4/judge.html";
            })
        }

    });
    localStorage.removeItem('objlive');
    localStorage.removeItem('objdead');
    localStorage.removeItem('objbill');
    localStorage.removeItem('lFarmer');
    localStorage.removeItem('lKiller');
    localStorage.removeItem('setState');
    localStorage.removeItem('die');
    localStorage.removeItem('killyou');
    localStorage.removeItem('objArray');


    console.log(localStorage);




});
console.log(localStorage);