
var state = 1;//用来分辨当前是皇上页面还是身份页面,1为小女孩页面
var player = [];//造一个player来装一个空数组
var killer = JSON.parse(sessionStorage.getItem('killer'));//取出传过来的杀手的数量
console.log(killer);
var people = JSON.parse(sessionStorage.getItem('people'));//取出传过来的平民的数量
var cycle = 1;//最上面的圆圈数字
for (i=0;i<killer;i++){//将“杀手”push到新的数组，有几个杀手就push进几个“杀手”
    player.push('杀手');
}
for (i=0;i<people;i++){//将“平民”push到新的数组，有几个平民就push进几个“平民”
    player.push('平民');
}
// console.log(player);
function shuffle(array){
    var w = array.length;
    var x,y;
    //随机选取一个元素
    while(w){
        //随机选取一个数
        y = Math.floor(Math.random()*w--);
        //与当前元素进行交换
        x = array[w];//把数组最后的那个元素赋值给x
        array[w] = array[y];//把抽出来的那个元素与最后边的元素交换
        array[y] = x;
    }
    return array;
}
console.log(shuffle(player));//打乱杀手和平民的顺序。
console.log(player);
sessionStorage.setItem('player',JSON.stringify(player));//把打乱的状态储存




$('.main-bottom').on('click',function(){
    if(cycle<player.length+1){//将圆圈的数字和总人数数组的长度作为判断条件，如果数组长度是6，那么圆圈的数字将取到6，所以需要在数组长度基础上加1.
        if(state === 1){//小女孩页面
            $('.main-top-icon-1').hide();//皇上头像隐藏
            $('.box').show();//女孩头像页显示
            $('.main-top-text').text(player[cycle-1]);//显示player数组中的第一个元素(平民或杀手)
            cycle++;
            if(cycle < player.length + 1){
                $('#bottomText').text('隐藏并传递给' + cycle + '号');
            }else if(cycle = player.length + 1){
                $('#bottomText').text('法官查看');
            }
            state = 0;
        }else if(state === 0){
            $('.main-top-icon-1').show();//皇上头像显示
            $('.box').hide();//女孩头像隐藏
            $('#topNumber').text(cycle);//圆圈的数字
            $('#bottomText').text('查看' + cycle + '号身份');
            state = 1;
        }
    }else{
        var a = confirm('请把手机交给法官');
        if(a === true){
            location.href = '../html/task2-4.html';
        }
    }
    console.log(cycle);
});
$('.backArrow').on('click',function(){
    var b = confirm('确定要返回上一页么？');
    if(b === true){
        location.href = '../html/task2-2.html';
    }
});
$('.close').on('click',function(){
    var c = confirm('你确定要返回首页么？');
    if(c === true){
        location.href = '../html/task2-1.html';
    }
});


