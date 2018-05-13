//input text和range数据同步
function change(){
    var num=document.getElementById("range");
    var location=document.getElementById("shownum");
    location.value=num.value;
}
//input range和text数据同步
function synchro(){
    var num=document.getElementById("range");
    var location=document.getElementById("shownum");
    num.value=location.value;
}
//点击+按钮数字增加
function addnum(){
    var num=document.getElementById("range");
    num.value=++num.value;
    change();
}
//点击-按钮数字减少
function subnum(){
    var num=document.getElementById("range");
    num.value=num.value-1;
    change();
}
//生成角色数组并实现数组乱序
function roleArray(){
    var location=document.getElementById("shownum");
    var figure=location.value;
    var role=[];
    for(i=0;i<Math.ceil(figure/5);i++){
        role.push("杀手");
    }
    for(j=0;j<(figure-Math.ceil(figure/5));j++){
        role.push("平民");
    }
    for(var n=0;n<(role.length-1);n++){
        var m=Math.round(Math.random()*(role.length-1));
        var temp=role[n];
        role[n]=role[m];
        role[m]=temp;
    }
    return role;
}
//生成序号按钮
function orderArray(){
    var location=document.getElementById("shownum");
    var figure=parseInt(location.value);
    var order=[];
    for(k=1;k<=figure;k++){
        order.push(k);
    }
    return order;
}
//一对一匹配角色和序号
function distribute(){
    var _role=roleArray();
    var _order=orderArray();
    for(l=0;l<_role.length;l++){
        document.getElementById("write").innerHTML=document.getElementById("write").innerHTML+_order[l]+"号玩家是"+_role[l]+"<br/>";
    }
}
//判断数字在正确范围内可实现点击事件，否则弹出对话框
function judge(){
    var location=document.getElementById("shownum");
    if(location.value>=6&&location.value<=18){
        document.getElementById("write").innerHTML = "";
        distribute();
        var objorder=orderArray();
        var objrole=roleArray();
        var strorder=JSON.stringify(objorder);
        var strrole=JSON.stringify(objrole);
        sessionStorage.objorder=strorder;
        sessionStorage.objrole=strrole;
    }
    else{
        alert("请填写正确的人数,6-18之间");
    }
}
//判断玩家配对框不为空，并且人数正确跳转进入下一个页面，否则弹出对话框
function deal(){
    if(document.getElementById("write").innerHTML==""){
        alert("请点击'点击设置'按钮进行角色分配");
    }
    else if (document.getElementById("shownum").value<6||document.getElementById("shownum").value>18){
        alert("请输入正确的人数并重新点击'点击设置'按钮");
    }
    else{
        window.location.href="flop.html";
    }
}
//把数组order()和role()转译为字符串储存到sessionStorage中


