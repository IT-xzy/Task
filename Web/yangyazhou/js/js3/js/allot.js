var log = console.log;

//返回上一页
$('.back').click(function () {
    $(location).prop('href', 'headerPage.html');
})
//定义分配的玩家的人数
function allot(value) {
    switch (true) {
        //15或者18的
        case value == 15 || value == 18:
            var num = ~~(~~(value) / 3 - 1);
            killers.text(num);
            players.text(~~value - num);
            break;
        case value >= 4 && value < 17:
            num = ~~(~~(value) / 3);
            killers.text(num);
            players.text(~~value - num);
            break;
    }
}
//乱序的数组
function bulidArr(kills, pops) {
    //数组长度
    var len = kills + pops,
        fillArr = new Array(len),
        randomArr = [],
        obj,
        num=0;
    //填充数组
    fillArr.fill('杀手', 0, kills);
    fillArr.fill('平民', kills, len);
    while (fillArr.length) {
        var index = ~~(Math.random() * fillArr.length);
        obj={id:'',index:"",state:'alive',deadReason:null,deadDay:null};
        obj.id=fillArr[index];
        obj.index=num;
        num++;
        randomArr.push(obj);
        fillArr.splice(index, 1);
    }
    return randomArr;
}








var players = $('#popsNum'), //平民数
    killers = $('#killsNum'), //杀手数
    go = $('#go'), //跳转按钮
    input = $('#player'), //输入框
    add = $('#add'),
    sub = $('#sub'),
    range = $('#ranges');

//输入框的的input事件
input.on('input', function () {
    //保证输入的数值是数字
    this.value = this.value.replace(/\D/, "");
    range.val(this.value);
    if(~~this.value >3){
        range.css('backgroundSize',(~~this.value-4)/14*100+'%');
    }
    allot(this.value);
});

//滑块事件
range.on('change', function () {
    var num=range.val();//获取滑块的值
    //改变输入框的值
    input.val(num);
    //改变滑块的绿色的长度
    range.css('backgroundSize',`${(~~num-4)/14*100}%  100%`); 
    //改变玩家分配数
    allot(num);
});
//加号按钮事件
add.on('click',function(){
    var num=input.val();
    //判断是否达到数值18
    if(num ==18){
        alert('达到最大人数，无法添加人数');
        return ;
    }
    num++;
    range.css('backgroundSize',`${(~~num-4)/14*100}%  100%`);    
    input.val(num);
    range.val(num);
    allot(num);     
});
//减号按钮事件
sub.on('click',function(){
    var num=input.val();
    if(num ==4){
        alert('达到最小人数，无法减少人数');
        return ;
    }
    num--;
    range.css('backgroundSize',`${(~~num-4)/14*100}%  100%`);         
    input.val(num);
    range.val(num);
    allot(num);    
});
//跳转页面
go.click(function () {
    var num=input.val(),
        kills=~~killers.text(),
        pops=~~players.text();
    //不在4-18之间的数，会弹窗
    if(num>18 ||num <4){
        alert('请输入正确玩家数量');
        input.val(8);
        players.text(6);
        killers.text(2);
        range.val(8);
    }else{
        //设置一个对象，放置乱序后的数组，然后放置天数
        let allMsg={};
        allMsg.dayNum=1;
        allMsg.killersNum=kills;
        allMsg.popsNum=pops;
        allMsg.killed=[];
        allMsg.players=bulidArr(kills,pops);
        sessionStorage.setItem('allMsg',JSON.stringify(allMsg));
        //跳转页面
        $(location).attr('href','show.html');
    }

});



