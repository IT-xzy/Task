var Array3=JSON.parse(sessionStorage.getItem('user')),//获取乱序数组
    person=JSON.parse(sessionStorage.getItem('person')),//获取各角色生存状态
    day=JSON.parse(sessionStorage.getItem('day')),//获取游戏进展的天数
    step=JSON.parse(sessionStorage.getItem('step')),
    indexArray=JSON.parse(sessionStorage.getItem('indexArray')),//获取死亡数组
    mark=sessionStorage.getItem('mark'),
    square=$(".column"),//获取正方格节点
    role=$(".role-name"),
    $button=$("footer").children("a"),
    title=$("header").children('h4'),
    number=$('.role-number'),
    $return=$('header').find('a').eq(0),
    $close=$('header').find('a').eq(1),
    num=[];
//遍历数组，根据杀手平民数量显示块
for (var i=0;i<Array3.length;i++){
    num[i]=i+1;
    square[i].style.display="block";
    role[i].innerHTML=Array3[i];
    number[i].innerHTML=num[i]+"号"
};
$return.on('click',function () {
    sessionStorage.clear();
    window.location.href='setting.html';
});
$close.on('click',function () {
    var $choose=confirm('确定要结束本轮游戏么');
    if($choose===true) {
        sessionStorage.clear();
        window.location.href ='game-version.html'
    }
});
//状态机根据不同状态显示不同页面
var fsm=new StateMachine({
    init:'judge',
    transitions:[
        {name:'jump',from:'judge',to:'kill'},
        {name:'jump',from:'kill',to:'vote'},
        {name: 'goto', from: '*', to: function(s) { return s }}
    ],
    methods:{
        onJump:function(){console.log(fsm.state)}
    }
});
//当从sessionStorage获取的值不等于0时，把fsm的状态装换为存储的状态.
if( mark==='1'){
    sessionStorage.removeItem('mark')
    fsm.goto('judge')
}
else if (sessionStorage.getItem('judge-state')=='vote'){
    fsm.goto('vote')
}
else if(sessionStorage.getItem('judge-state')=='kill'){
    fsm.goto('kill')
}
console.log(sessionStorage.getItem('state'));
//法官日记状态显示的页面
if(fsm.state==='judge'){
    title[0].innerHTML="法官日志";
    $button[0].innerHTML="开始游戏";
    if((sessionStorage.getItem('person'))==null) {
        var person = [],//通过遍历生成对象数组，用于保存各角色的名称，状态，以及编号
            day = 1,
            step=0,//存储游戏进展的天数
            indexArray = [];//声明一个空组，用来保存死亡的人
        for (i = 0; i < Array3.length; i++) {
            person[i] = {
                name: Array3[i],
                state: 'live',
                num: i
            }
        }
    }
    sessionStorage.setItem('indexArray',JSON.stringify(indexArray));
    sessionStorage.setItem('day',JSON.stringify(day));
    sessionStorage.setItem('person',JSON.stringify(person));
    $($button).on('click',function () {
        window.location.href='game-process.html'
    });
}
//状态为'kill'时显示以下页面
else if(fsm.state==='kill') {
    var index;
    //杀手页面显示的内容
    title[0].innerHTML = "杀手杀人";
    $button[0].innerHTML = "杀人";

    //角色被点击时显示的内容
    $('.column').click(function () {
        $(this).find('.more').css({'display':'block'});
        index=$('.column').index(this);//用变量保存点击模块的索引值
        console.log(index)
        //根据各个角色的状态和名称，根据判断显示点击时的效果
        if (day===step){
            index=null;
            var bb=confirm('请不要重复杀人');
            if(bb===true) {
                window.location.href = 'game-process.html'
            }
        }
        else if(person[index].state==='die'){
            alert('兄弟你要鞭尸吗？');
            index=null;
        }
        else if(person[index].name==='杀手'){
            alert('无法杀死队友');
            index=null;
        }
        else {//当角色为平民时
            for(i=0;i<Array3.length;i++){
                if(person[i].state==='live'){
                    $('.role-name').eq(i).css({'background':'','color':''})
                }
            }
            $(this).find('.role-name').css({'background':'#000','color':'#fff'})//被点击的块颜色改变
        }

    });

    //点击底部按钮时，根据不同情况，显示不同效果
    $button.click(function () {
        console.log(index);
        if(index!==null){
            var choose=confirm('Are you going to kill him?'),
                killerLive=0,
                civilianLive=0;
            if(choose===true){
                person[index].state='die';
                indexArray.push(index+1);
                step++;
                sessionStorage.setItem('state','killers-action')
                sessionStorage.setItem('step',JSON.stringify(step));
                sessionStorage.setItem('indexArray',JSON.stringify(indexArray));
                sessionStorage.setItem('index',JSON.stringify(index));
                console.log(indexArray);
                console.log(person);
               //遍历数组，计算杀手和平民的存活人数
                for(i=0;i<person.length;i++){
                    if(person[i].name==='杀手'&&person[i].state==='live'){
                        killerLive++;
                    }
                    else if(person[i].name==='平民'&&person[i].state==='live'){
                        civilianLive++
                    }
                }
                console.log(killerLive);
                //比较杀手人数和平民人数，根据人数，判断游戏结果
                if(killerLive>=civilianLive||killerLive==0){
                    window.location.href='result.html'
                }
                sessionStorage.setItem('person',JSON.stringify(person));
                window.location.href='game-process.html';
            }
        }
        else if(index===null){
            alert('请选择要击杀的角色')
        }

        })
}
//状态为'vote'时，显示的页面，以及可以操作的页面
else if (fsm.state==='vote'){
    title[0].innerHTML="投票";
    $button[0].innerHTML = "投票";
    //设置角色被点击时的效果
    var index;
    $('.column').click(function () {
        index=$('.column').index(this);
        if(person[index].state==='die'){
            alert('兄弟你要鞭尸吗？');
            index=null;
        }
        else {
            for(i=0;i<Array3.length;i++){
                if(person[i].state==='live'){//判断角色是否或者，把活着的角色颜色重置
                    $('.role-name').eq(i).css({'background':'','color':''})
                }
            }
            $(this).find('.role-name').css({'background':'#000','color':'#fff'})//被点击的块颜色改变
        }
        console.log(index)
    });
    $button.click(function () {
        if(index!==null){
            var choose=confirm('Are you going to vote him?');
            if(choose===true){
                person[index].state='die';
                sessionStorage.setItem('state','vote-action');
                sessionStorage.setItem('person',JSON.stringify(person));
                var killerLive=0,
                    civilianLive=0;
                for(i=0;i<person.length;i++){
                    if(person[i].name==='杀手'&&person[i].state==='live'){
                        killerLive++;
                    }
                    else if(person[i].name==='平民'&&person[i].state==='live'){
                        civilianLive++;
                    }
                }
                if(killerLive>=civilianLive-1||killerLive==0){
                    indexArray.push(index+1);
                    sessionStorage.setItem('indexArray',JSON.stringify(indexArray));
                    window.location.href='result.html'
                }
                else {
                    day++;
                    indexArray.push(index+1);
                    console.log(indexArray)
                    sessionStorage.setItem('indexArray',JSON.stringify(indexArray));
                    sessionStorage.setItem('day',JSON.stringify(day));
                    sessionStorage.removeItem('state');
                    window.location.href='game-process.html';
                }
            }
        }
        else if(index===null){
            alert('请重新选择被投角色')
        }
    })
}
for(i=0;i<Array3.length;i++){
    if(person[i].state==='die'){
        $('.role-name').eq(i).css({'background':'#000','color':'#fff'});
    }
}






