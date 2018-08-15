var inputNumber = document.getElementById("inputNumber");
var rangeNumber = document.getElementById("rangeNumber");
var killer = document.getElementById("killer");
var people = document.getElementById("people");
inputNumber.value=rangeNumber.value;
//返回首页
function back(){
    var revert=confirm("确定要返回首页么？");
    if(revert===true){
        window.location.href="../html/task2-1.html";
    }
    else {
        return null;
    }
}
//Esc键盘事件
document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode===27){ // 按 Esc要做的事情
        var revert=confirm("确定要返回首页么？");
        if(revert===true){
            window.location.href="../html/task2-1.html";
        }
        else {
            return null;
        }
    }
};
//玩家人数的输入框与滚动条同步
function getNumber(){
    if(inputNumber.value>=4&&inputNumber.value<=18){
        rangeNumber.value=inputNumber.value;
    }
    else{
        alert("请输入正确玩家人数，人数为4-18人。");
        inputNumber.value=4;
    }
}
//滚动条改变玩家人数随着改变
function change(){
    inputNumber.value=rangeNumber.value;
}
//减号按钮与滚动条同步
function btLeft(){
    inputNumber.value--;
    rangeNumber.value=inputNumber.value;
    console.log(inputNumber.value);
    if(inputNumber.value<4) {
        alert("人数不足，请凑好再来");
        inputNumber.value = 4;
    }
}
//加号按钮与滚动条同步
function btRight(){
    inputNumber.value++;
    rangeNumber.value=inputNumber.value;
    if(inputNumber.value>18) {
        alert("人数太多，请分开游戏");
        inputNumber.value = 18;
    }
}
//设置杀手和平民人数
function push(){
    var x=inputNumber.value;
    var y=killer.value;
    var w=people.value;
    if (x<9){
        y=1;
        w=x-y;
    }else if (x<12){
            y=2;
            w=x-y;
        }else if (x<16){
                y=3;
                w=x-y;
            }else if (x<=18){
        y=4;
        w=x-y;
    }
    killer.innerHTML=y;
    people.innerHTML=w;
    sessionStorage.setItem("killer", JSON.stringify(y));//JSON.stringify(y)把数值转换为JSON字符串，sessionStorage只储存字符串
    sessionStorage.setItem("people",JSON.stringify(w));//同上
    sessionStorage.setItem("inputNumber",JSON.stringify(x));
}
function start(){
    var a = JSON.parse(sessionStorage.getItem("killer"));//JSON.parse(sessionStorage.getItem("killer"))把储存的数据获取出来，取出来的数据是字符串，需要把它变成数值。
    var b = JSON.parse(sessionStorage.getItem("people"));
    var player = a + b;
    if(player == inputNumber.value){
        window.location.href = "../html/task2-3.html";
    }else {
        alert("请分配玩家身份");
    }
}