/**
 * Created by Administrator on 2017/12/15.
 */


$(document).ready(function () {
    var arr2 = JSON.parse(localStorage.getItem("user"));        // 保存在main.js页面据
    var arr3 = JSON.parse(localStorage.getItem('arr3'));        // 保存在main.js页面
    var arr5 = JSON.parse(localStorage.getItem('arr5'));        // 保存在main.js页面
    var arr6 = JSON.parse(localStorage.getItem('arr6'));        // 保存在main.js页面
    var arr4 = JSON.parse(localStorage.getItem('arr4'));        //用来保存被杀死玩家condition对象
    var arr7 = JSON.parse(localStorage.getItem('arr7'));         //保存被投死玩家condition对象
    var fsm = new StateMachine({
        init:      'none',
        transitions:[
            {name:'kill',from:'none',to:'die'},
            {name:'lastWords',from:'die',to:'lastSpeak'},
            {name:'speak',from:'lastSpeak',to:'discuss'},
            {name:'vote',from:'discuss',to:'none'},
            {name: 'goto', from: '*', to: function (a) {return a}}
        ],
        methods:{
            onAfterKill:function (lifecycle) {                             //杀人事件后
                console.log('状态、 ' + fsm.state);
                // console.log('事件、'+fsm.transitions()[0]);
                var stateDie = fsm.state;                                  //声明变量
                localStorage.setItem('stateDie',stateDie);                 //保存状态 Die
                $('#kill').css('background-color','#18758D');
                $('#killTriangle').addClass('left_triangle2');
                location.href = 'kill.html';                             //跳转到杀人页面


            },
            // onLeaveDie:function (lifecycle) {                            //离开die状态
            // },
            onEnterLastSpeak:function (lifecycle) {                         //进入LastSpeak状态
                // console.log('onEnterLastSpeak状态、 ' + fsm.state);
            },
            onAfterLastWords:function(lifecycle){                           //发表遗言事件后
                // console.log('onAfterLastWords状态、 ' + fsm.state);
                var stateLast = fsm.state;                                  //声明变量
                localStorage.setItem('stateLast',stateLast );               //保存状态 LastSpeak
            },
            onAfterSpeak:function(lifecycle){                                //讨论事件后
                // console.log('onAfterSpeakc状态、 ' + fsm.state);
                var stateDiscuss = fsm.state;                                //声明变量
                localStorage.setItem('stateDiscuss',stateDiscuss );          //保存状态 Discuss
            },
            onLeaveDiscuss:function () {
                console.log(fsm.state);
                // arr4.push(1);
                // localStorage.setItem('arr4',JSON.stringify(arr4));  //用localStorage 以JSON 格式保存 数组arr3
            },
            onAfterVote:function () {                                        //投票事件后
                // $('#vote').css('background-color','#18758D');
                // console.log('onAfterVote状态、 ' + fsm.state);
                var stateNone = fsm.state;                                    //声明变量
                localStorage.setItem('stateNone',stateNone  );                //保存状态 None
                localStorage.removeItem('stateDie');                          //清除 stateDie 状态的数据，回到第二天
                localStorage.removeItem('stateLast');
                localStorage.removeItem('stateDiscuss');

                // top.location='Vote1.html';
                location.href = 'Vote1.html';                                 //跳转到投票
                $('#kill').css('background-color',' #29bde0');              //回到初始颜色
                $('#killTriangle').removeClass('left_triangle2');
                $('#lastWords').css('background-color',' #29bde0');
                $('#lastTriangle').removeClass('left_triangle2');
                $('#speak').css('background-color',' #29bde0');
                $('#speakTriangle').removeClass('left_triangle2');
                console.log('状态、 ' + fsm.state);
                console.log('事件、'+fsm.transitions()[0]);

            }
        }
    });

    $('#kill').click(function () {
        fsm.goto('none');                                  //使用goto方法，当前条件满足时跳到改状态。
        fsm.kill();                                         //触发AfterKill事件
        console.log(fsm.state);
    });
    var stateDie = localStorage.getItem('stateDie');        //死亡状态
    if(stateDie === "die"){                                   //用于发表遗言事件的逻辑
        fsm.goto('die');                                     //使用goto方法，当前条件满足时跳到改状态。
    }
    console.log(fsm.state);
    $('#lastWords').click(function () {
        console.log(fsm.state);
        if((fsm.state === 'die') || (fsm.state === 'lastSpeak' ) ||  (fsm.state === 'discuss' ) ){
            false;
        }else {
            alert('小姐姐请先杀人' );
        }
        fsm.lastWords();                                      //触发AfterLsatWords事件

        if(fsm.state === 'lastSpeak' ){
            alert('请死者表明身份并发表遗言');
            $('#lastWords').css('background-color','#18758D');
            $('#lastTriangle').addClass('left_triangle2');
        }
    });
    var stateLast = localStorage.getItem('stateLast');            //死亡状态
    if(stateLast === "lastSpeak"){    //用于发表遗言事件的逻辑
        fsm.goto('lastSpeak');                                     //使用goto方法，当前条件满足时跳到改状态。
    }

    $('#speak').click(function () {
        var stateDie = localStorage.getItem('stateDie');                      //死亡状态
        var stateLast = localStorage.getItem('stateLast');                    //遗言状态
        console.log(fsm.state);
        if( (stateDie  !== 'die' ) ){
            alert('小姐姐请先杀人' );
        }
        else if((stateDie  === 'die' ) && (stateLast !== 'lastSpeak') ){
            alert("请亡灵发表遗言");
        }
        fsm.speak();                                              //触发AfterSpeak事件
        if(fsm.state === 'discuss' ){
            alert('请玩家依次发言讨论');
            $('#speak').css('background-color','#18758D');
            $('#speakTriangle').addClass('left_triangle2');
        }
        console.log('状态、 ' + fsm.state);
        console.log('事件、'+fsm.transitions()[0]);
    });
    var stateDiscuss = localStorage.getItem('stateDiscuss');              //讨论状态
    if(stateDiscuss === "discuss"){    //用于发表遗言事件的逻辑
        fsm.goto('discuss');
    }
    $('#vote').click(function () {
        var stateDie = localStorage.getItem('stateDie');        //死亡状态
        var stateLast = localStorage.getItem('stateLast');                    //遗言状态
        console.log(fsm.state);
        if( stateDie !== 'die'){
            alert('小姐姐请先杀人' );
        }else if(fsm.state === "die"){
            alert("请亡灵发表遗言")
        }else if(( stateDie === 'die') && (stateLast === "lastSpeak") && (fsm.state === "lastSpeak")){
            alert("请玩家依次发言讨论")
        }
        else {
            fsm.vote();
        }                                        //触发AfterVote事件

    });

    var none = localStorage.getItem('none');                              //开始状态 （取出状态数据）
    var stateDie = localStorage.getItem('stateDie');                      //死亡状态

    var stateDiscuss = localStorage.getItem('stateDiscuss');              //讨论状态
    var stateNone = localStorage.getItem('stateNone');                    //当前状态
    if(stateDie === 'die'){
        $('#kill').css('background-color','#18758D').off('click');                     //通过保存的状态，保存颜色变化
        $('#killTriangle').addClass('left_triangle2');
    }
    if(stateLast === "lastSpeak"){
        $('#lastWords').css('background-color','#18758D');
        $('#lastTriangle').addClass('left_triangle2');
    }
    if(stateDiscuss === "discuss"){
        $('#speak').css('background-color','#18758D');
        $('#speakTriangle').addClass('left_triangle2');
    }
    var i =0;
    for( i=0;i < arr7.length;i++){
        $('.top_triangle').before(
            "<div>"
            + "<div  class=\"day\">第"+ (i+1) + "天</div>"
            + "<div class=\"record\">" +( arr4[i].num +1 )
            + "号被杀死，其真实身份是" + (arr4[i].name)
            + "<br>"
            + ( arr7[i].num +1 )+ "号被投票投死，其真实身份是" + (arr7[i].name)
            + "</div>"
            +"</div>"
        );
    }
    $(".top_triangle").before(
        "<div  class=\"day\">第"+(arr7.length+1)+"天</div>"
        +"<span></span>"
    );
    $(".day").click(function () {
        $(this).next().toggle();
    });
    if(stateDie === 'die') {
        $("#kill").after(
            "<div style='padding-left:.5rem;'>"
            + ( arr3[(arr3.length - 1)] + 1 )
            + "号被杀死,"
            + " 其真实身份是"
            + (arr4[arr4.length - 1].name) + "</div>");
    }
    $('#to-judge-seeing').click(function () {
        location.href = 'judge-seeing.html';                                   //返回法官日志页面（顶部返回图标）
    });
    $('#toJudgeSeeing').click(function () {                                 //跳转到法官日志页面(底部按钮)
        location.href = 'judge-seeing.html';
    });
    $("#end").click(function () {
        location.href = 'result.html';
    })
});
