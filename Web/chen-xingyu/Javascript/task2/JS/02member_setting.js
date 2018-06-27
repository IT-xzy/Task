var input_number=document.getElementById('set_number');
var range_number=document.getElementById('range_number');
var killer=document.getElementsByClassName('k_number')[0];
var people=document.getElementsByClassName('p_number')[0];
range_number.value=input_number.value;
// 鼠标返回事件
var leave=document.getElementById("leave_away");
leave.onclick=function(){
    var tip = confirm("确定返回版本选择页面吗？");
    if(tip===true){
        window.location.href="../html/01version_page.html";
    }
    else{
        return null;
    }
};
// 按 Esc要做的事情
document.onkeydown=function(event){
    var tip = event || window.event || arguments.callee.caller.arguments[0];
    if(tip && tip.keyCode===27){
        var revert=confirm("确定要返回首页么？");
        if(revert===true){
            window.location.href="../html/01version_page.html";
        }
        else {
            return null;
        }
    }
};

// 玩家人数输入值和滚动条同步
input_number.onchange=function (){
    if(input_number.value>=4&&input_number.value<=18){
        range_number.value=input_number.value;
    }
    else{
        alert("请输入正确人数,4~18人");
        input_number.value=4;
    }
};

// 玩家人数随滚动条改变
range_number.onchange=function(){
    input_number.value=range_number.value;
};


// 同步加人数
var number_plus=document.getElementById("plus");
number_plus.onclick=function(){
    range_number.value++;
    input_number.value=range_number.value;
};

//同步减人数
var number_minus=document.getElementById("minus");
number_minus.onclick=function(){
    range_number.value--;
    input_number.value=range_number.value;
};
// 分配角色
var set=document.getElementById("setting_role");
set.onclick=function () {
    var x=parseInt(input_number.value);
    var y,z;
    if(x<7){
        y=1;
        z=x-y;
    }
    else if(x>=7&&x<10){
        y=2;
        z=x-y;
    }
    else if(x>=10&&x<13){
        y=3;
        z=x-y;
    }
    else if(x>=13&&x<16){
        y=4;
        z=x-y;
    }
    else if(x>=16&&x<=18){
        y=5;
        z=x-y;
    }
    killer.innerText=y;
    people.innerText=z;
    sessionStorage.setItem("k",JSON.stringify(y));
    //JSON序列化，便于下一步的反序列化。因为sessionStorage只能表达出来的只能是字符串类型。
    sessionStorage.setItem("w",JSON.stringify(z));
    sessionStorage.setItem("pNum",JSON.stringify(x));
};
var get_start=document.getElementById("start_game");
get_start.onclick=function() {
    var a=parseInt(killer.innerText),
        b=parseInt(people.innerText),
        c=parseInt(input_number.value);
           if(a+b===c){
        window.location.href="../html/03identify_view.html";
    }
    else{
        alert('请点击蓝色字体设置角色分配');
       return null;
    }
};



