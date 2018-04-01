/**
 * Created by Administrator on 2017/11/15/015.
 */
localStorage.getItem("randomArray");
localStorage.valueOf();
var sum= localStorage.getItem("randomArray").split(",");
console.log(sum);

$(document).ready(function () {


    for(var i=0;i<sum.length;i++){
        var $divFather = $("<div>").addClass("f-kill");
        var $divTop = $("<div>").addClass("f-kill-t").text(sum[i]);
        var $DivButtom = $("<div>").addClass("f-kill-b").text(i+1);
        $(".container").append(
            $divFather.append($divTop).append($DivButtom)
        )
    }

    $(document).ready(function(){
        $("#b_game").click(function () {
            location.href="http://student.task.web.ptteng.com/liangyao/js/task2-4/game-process.html";
        });
    });
    var objdead=[];
    var objbill=[];
    localStorage.setItem('objdead',JSON.stringify(objdead));
    localStorage.setItem('objbill',JSON.stringify(objbill));

});