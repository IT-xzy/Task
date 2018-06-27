// 清楚身份分配
localStorage.removeItem("outValue")
// 捕捉狼人的信息
var langTX = document.getElementsByClassName("langNum")[0];
var langNum;
// 捕捉村名的信息
var cunTX = document.getElementsByClassName("cunNum")[0];
var cunNum;
//定义保存数组的变量
var outValue;

// #num 捕获 按钮设置input事件分配人数
var num = document.getElementById("num")
num.oninput = function () {
    this.value = this.value.replace(/[^\d]/g, "");
    allotNumber();
};


function allotNumber() {
    // 捕捉input的值
    let input = $("#num")[0].value;
    $("#range").val(input) //将捕捉的值赋予滑块
    switch (true) {
        case input > 3 && input != 15 && input != 18 && input < 19:
            langNum = Math.floor(input / 3);
            cunNum = Math.ceil(input / 3 * 2);
            langTX.innerHTML = langNum;
            cunTX.innerHTML = cunNum;
            break;
        case input == 15 || input == 18:
            langNum = input / 3 - 1;
            cunNum = input / 3 * 2 + 1;
            langTX.innerHTML = langNum;
            cunTX.innerHTML = cunNum;
            break;
        default:
            langTX.innerHTML = " ";
            cunTX.innerHTML = " ";
    }
};
$("#range")[0].oninput = function () { //滑块的值赋予input并进行计算
    $("#num")[0].value = this.value;
    allotNumber();
    console.log(this.value)
};
allotNumber();

$(".minus").on("click", function () { //-号点击事件
    let num = ~~$("#range").val();
    $("#num").val(--num); // 捕获的值给input
    $("#range").val(num); //捕获的值给滑块
});

$(".plus").on("click", function () { //加好点击事件
    let num = ~~$("#range").val();
    $("#num").val(++num); // 捕获的值给input
    $("#range").val(num) // 捕获的值给滑块
    console.log($("#range")[0].value)
});

$("footer").on("click", function () { //设定footer的点击事件

    if ($("#num").val() < 4 || $("#num").val() > 18) { //人数不满足跳弹窗
        console.log($("#num").val() < 4)
        $(".tanchuang").show()
    } else { //满足条件的时候乱序数组
        outValue = [];
        for (let i = 0; i < cunNum; i++) { //push村民数量
            let cun = "村民";
            outValue.push(cun);
        }
        for (let i = 0; i < langNum; i++) { //push杀手数量
            let cun = "杀手";
            outValue.push(cun);
        }
        //console.log(outValue)
        // 乱序outvalue数组
        for (let i = 0; i < outValue.length-1; i++) { //
            let index=Math.floor(Math.random()*(outValue.length-1-i))
            let randomX=outValue[index];
            outValue[index]=outValue[outValue.length-1-i];
            outValue[outValue.length-1-i]=randomX;
            
        }
        
        localStorage.setItem("outValue",JSON.stringify(outValue));
        localStorage.setItem("langNum",JSON.stringify(langNum));
        localStorage.setItem("cunNum",JSON.stringify(cunNum));
      localStorage.removeItem("dayNum") //移除数据
      localStorage.removeItem("outOject")  //移除面向对象数据
      localStorage.removeItem("dayTime")  //移除日志对象
      localStorage.removeItem("flowNum")  //移除流程数据  
        console.log(JSON.parse(localStorage.getItem("outValue")) )
        window.location.href="../html/fapai.html"
    };

})

$(".close").on("click", function () { //close点击事件隐藏弹窗
    $(".tanchuang").hide()
})
$("i").on("click",function(){
    window.location.href="1.html"
})
