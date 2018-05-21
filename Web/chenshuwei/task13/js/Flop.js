var Array2=JSON.parse(sessionStorage.getItem('user')),//将值转换为数组
    role=$(".card-wrap"),//获取卡片的节点
    seeRole=$(".see-role"),//获取按钮的节点
    roleInformaion=$(".role"),//获取卡片身份的节点
    circle=$(".circle"),//获取头部序号的节点
    $return=$('header').find('a').eq(0),
    $close=$('header').find('a').eq(1);
    var fsm=new StateMachine({//创建状态机
        init:'s',//最初的状态为s
        transitions:[
            {name:'hide',from:'s',to:'h'},//"hide"行为可以吧s状态转换为h
            {name:'hide',from:'h',to:'s'}//"hide"行为也可以吧h状态装换为s
        ],
        methods:{
            onHide:function () {console.log(fsm.state)}//过渡到不同状态的方法
        }
    });
    $return.on('click',function () {
        window.location.href='setting.html'
    });
    $close.on('click',function () {
        var $choose=confirm('确定要结束本轮游戏么');
        if($choose===true) {
            window.location.href = 'game-version.html'
        }
    });

var num=1;//声明变量保存点击次数
role[0].style.display="block";
seeRole[0].innerHTML="查看"+num+"号身份";
circle[0].innerHTML=1;
function transmit() {
    if(num==Array2.length+1){//
        window.location.href = "judge-view.html"
    }
    else if(fsm.state=='h'){
        role[0].style.display="none";
        role[1].style.display="block";
        circle[1].innerHTML=num;
        roleInformaion[0].innerHTML="身份："+Array2[num-1];
        if(num<Array2.length) {
            seeRole[0].innerHTML = "隐藏并传递给" + num + "号";
        }
        else {
            seeRole[0].innerHTML = "查看法官日记";
        }
        num++;
    }
    else {
        role[0].style.display="block";
        role[1].style.display="none";
        circle[0].innerHTML=num;
        seeRole[0].innerHTML="查看"+num+"号身份";
        console.log(num);
    }
}
