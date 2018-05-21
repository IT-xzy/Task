var part_value = sessionStorage.getItem("deal");
part_value = JSON.parse(part_value);
console.log(part_value);

$(".icon_back").click(function () {
    window.location.href = "JS-TASK2-分配.html"
})
$(document).ready($("#transmit").hide());
$(document).ready($("#judge").hide());
var i = 0;
var n = 1;


    $("#check").click(function numberOfClick(){
        i += 1;
        n += 1;
        if (part_value[i] == 0) {
            $("#identity").html("平民");
        }
        else {
            $("#identity").text("杀手");
        }
        $("#wow").show();
        $("#block").css("background-size","0");
        $("#check").hide();
        
        if(i < part_value.length) {
            $("#transmit").show();
            $("#transmit").val("隐藏并传递给" + n + "号");
        }
        else {
            $("#transmit").hide();
            $("#judge").show();
        }
        return i;
    });

    $("#transmit").click(function(){
        $("#identifier").val(n);
        $("#block").css("background-size","50%");
        $("#wow").hide();
        $("#check").show();
        $("#transmit").hide();
        $("#check").val("查看" + n + "号身份");
        return n;
    });

$("#judge").click(function(){
    window.location.href="JS-TASK2-法官查看.html"
})


