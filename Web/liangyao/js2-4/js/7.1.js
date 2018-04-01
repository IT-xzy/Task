/**
 * Created by Administrator on 2017/11/21/021.
 */
localStorage.getItem("randomArray");
localStorage.valueOf();
var sum= localStorage.getItem("randomArray").split(",");


var objdead=JSON.parse(localStorage.getItem('objdead'));


$(document).ready(function () {

//把字符串数组变成对象数组
    var objArray =[];

//生成n个对象
    for (var j=0;j<sum.length;j++) {
        var objplayer = {
            name: sum[j],
            state: 'live',
            num: j
        }
        objArray[j]=objplayer;
    }
    console.log(objArray);
    //生成随机数组相匹配的身份
    for (var i = 0; i < objArray.length; i++) {
        var $divFather = $("<div>").addClass("f-kill");
        var $divTop = $("<div>").addClass("f-kill-t").text(objArray[i].name);
        var $DivButtom = $("<div>").addClass("f-kill-b").text(objArray[i].num+1);
        $(".container").append(
            $divFather.append($divTop).append($DivButtom)
        );
    }
//生成状态机，设置初始状态
    var fsm = new StateMachine({
        init: 'live',
        transitions: [
            {name: 'bekill', from: 'live', to: 'death'},
            {name: 'renew', from: 'death', to: 'e'},
            {name:'goto',from:'*',to:'live' }
        ],
        methods: {
            onBekill: function () {
                console.log(fsm.state);
            },
            ongoto: function () {
                console.log(fsm.state);
            }
        }

    });



    console.log('未点击之前的状态'+fsm.state);
    //点击class获取当前点击的属性
    $(".f-kill-t").click(function () {
        var x=$(this).next().text()-1;
        if(objArray[x].state==='death'){
            alert("该玩家已死亡")
        } else if( $(this).text()=== "杀手") {
            alert("杀手不能自刀")
        } else {
            $(this).css("background-color", "#83b09a");
            fsm.bekill();
            console.log(fsm.state);
            //当前元素的索引值
            objArray[x].state=fsm.state;
            var objlive=objArray.filter(function (array) {
                return(array.state==='live')
            });
            var die=objArray.filter(function (array) {
                return(array.state==='death')
            });
            //创建被杀数组


            objdead.push(objArray[x]);
            console.log(objdead);
            localStorage.setItem('objdead',JSON.stringify(objdead));
            console.log( '点击之后的状态'+ objArray[x].state);
            console.log(objArray[x]);

            console.log(objArray);
            localStorage.setItem('objlive',JSON.stringify(objlive));
            localStorage.setItem('die',JSON.stringify(die));
            var objlive=JSON.parse(localStorage.getItem('objlive'));

            var objbill=JSON.parse(localStorage.getItem('objbill'));

            //胜利判断
            var lFarmer=objlive.filter(function (array) {
                return(array.name==='平民')
            });
            var lKiller=objlive.filter(function (array) {
                return(array.name==='杀手')
            });
            localStorage.setItem('lFarmer',JSON.stringify(lFarmer));
            localStorage.setItem('lKiller',JSON.stringify(lKiller));
            if(lFarmer.length===lKiller.length){
                alert("杀手胜利");
                window.location="http://student.task.web.ptteng.com/liangyao/js/task2-4/7.2.html";
            }else if(lKiller.length===0){
                alert("平民胜利");
                window.location="http://student.task.web.ptteng.com/liangyao/js/task2-4/7.2.html";
            }


            console.log(objlive);
            console.log(objdead);
            console.log(lKiller);
            console.log(lFarmer);
            $(".f-kill-t").off('click');
            $(".f-kill-t").on("click",function () {
                alert("请不要重复杀人")
            });

        }
    });
    //点击确定按钮
    $(".button-kill").click(function () {
        console.log("确定按钮"+fsm.state);

        if(fsm.cannot('renew')){
            alert("请先杀人")
            console.log(fsm.state);
        }else{

            window.location.href="http://student.task.web.ptteng.com/liangyao/js/task2-4/game-process.html";
        }

    });
    var die=JSON.parse(localStorage.getItem('die'));
     console.log(die);




//通过被杀死的数组改变样式跟状态

    for(var j=0;j<die.length;j++){
        var q=die[j].num;
        objArray[q].state= die[j].state;

        console.log(objArray[q]);


    console.log($('.f-kill-t')[q]);
    var div=[];
    div.push($('.f-kill-t')[q]);
    console.log(div);
    $(div).css("background-color", "#83b09a");
}

});











