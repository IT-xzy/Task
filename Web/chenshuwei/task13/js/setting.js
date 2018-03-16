var inputData=document.getElementById("play-numbers"),//获取input节点
slidingData=document.getElementById("range"),//获取滚动条节点
roleName=document.getElementsByClassName("role-name"),
roleMark=document.getElementsByClassName("blue");
num=1;
$return=$('header').find('a').eq(0);
//点击回退键后退
$return.on('click',function () {
    mark='1';
    sessionStorage.setItem('mark',mark);
    window.location.href='game-version.html';
});
//滑动进度条时，根据进度条位置修改文本框数值
$('.slide input:in-range').on('mouseup touchmove',function () {
    inputData.value = slidingData.value;
    num=null;
});
//文本框数值修改时，根据数值改变进度条位置
$('.play-number input:text').on('change',function () {
    slidingData.value = inputData.value;
    if (inputData.value < 4) {
        alert("玩家人数应在4-18之间");
        inputData.value=4;
    }
    else if(inputData.value>18){
        alert("玩家人数应在4-18之间");
        inputData.value=18;
    }
}) .on('keyup',function () {
    slidingData.value = inputData.value;
})
//点击减号减少进度条和文本框的数值
$('.change-number').eq(0).on('click',function () {
    inputData.value--;
    slidingData.value = inputData.value;
    if (inputData.value < 4) {
        alert("玩家人数应在4-18之间");
        inputData.value = 4;
    }
});
//点击加好增加进度条和文本框的数值
$('.change-number').eq(1).on('click',function () {
    inputData.value++;
    slidingData.value=inputData.value;
    if(inputData.value>18){
        alert("玩家人数应在4-18之间");
        inputData.value=18
    }
});
//点击设置人数，触发事件
$('.proportion-setting').on('click',function () {
    num=2
    for(var i=0;i<18;i++){//隐藏在设置人数里面的Html元素
        roleName[i].innerHTML="";
        roleMark[i].style.display="none";
    }
    var Arr=[];//生成杀手和平民的有序数组
    for(var i=0;i<inputData.value;i++){
        if (inputData.value>=4&&inputData.value<=5){//当总人数在4-5之间时
            if(i<1){
                Arr[i]="杀手"//第一个为杀手
            }
            else {
                Arr[i]="平民"//其余为平民
            }
        }
        else if(inputData.value>=6&&inputData.value<=8){
            if(i<2){
                Arr[i]="杀手"
            }
            else {
                Arr[i]="平民"
            }
        }
        else if(inputData.value>=9&&inputData.value<=11){
            if(i<3){
                Arr[i]="杀手"
            }
            else {
                Arr[i]="平民"
            }
        }
        else if(inputData.value>=12&&inputData.value<=15){
            if(i<4){
                Arr[i]="杀手"
            }
            else {
                Arr[i]="平民"
            }
        }
        else if(inputData.value>=16&&inputData.value<=18){
            if(i<5){
                Arr[i]="杀手"
            }
            else {
                Arr[i]="平民"
            }
        }
    }
    /*  /打乱数组，从数组随机去一个下标值，与数组中的第一个元素交换，然后在随机取一个下标值与数组中第二个元素交换
    * 以此类推，交换次数与数组长度一致，最后输出数组，用一个变量保存
    * */
    function ranDomarr() {
        var index,
            temp;
        for(var i=0;i<inputData.value;i++){
            index=Math.floor(Math.random()*inputData.value);
            if(i!=index){
                temp=Arr[i];
                Arr[i]=Arr[index];
                Arr[index]=temp;
            }
        }
        return Arr
    }
    var Array=ranDomarr();//用变量保存乱序数组
    sessionStorage.setItem('user',JSON.stringify(Array));//存入sessionstorage
    console.log(Array);
    for(var i=0;i<inputData.value;i++){//遍历点击设置里得元素，根据数组长度，显示元素
        roleMark[i].style.background="#29bde0";
        roleName[i].innerHTML=Array[i]+"1人";
        roleMark[i].style.display="block"
        if(Array[i]=="杀手"){//当Arr[i]的值为杀手的小方格背景颜色为橙色
            roleMark[i].style.background="#ee9f1b"
        }
    }

    if(inputData.value<4||inputData.value>18){
        alert("请输入正确的玩家数")
    }
});
//底部按钮点击时跳转页面
$('footer').children('a').on('click',function () {
    if(num===2) {
        window.location.href = "Flop.html"
    }
    else if(num===null){
        alert("人数已变更，请重新设置人数")
    }
    else {
        alert("请设置人数")
    }
});







