function storage() {
    let storedPeople = JSON.parse(localStorage.getItem("peopleArray"));
    console.log(storedPeople);
    return storedPeople;
}
function dayNum() {
    // localStorage.removeItem("dayNum");
let dayNum = JSON.parse(localStorage.getItem("dayNum"));
console.log(`读取天数存储值`+dayNum);
if (dayNum ===null) {
    let dayNum = 1;
    localStorage.setItem("dayNum", JSON.stringify(dayNum));
    dayNum = JSON.parse(localStorage.getItem("dayNum"));
    console.log(`天数为` + dayNum);
    return dayNum;
}
else {
    console.log(`天数为` + dayNum);
    return dayNum;
}
}
function kill() {
    let kill = $(".kill");
    let triangle1 = $(".triangle-left1");
    function truncate(arr) {
        return arr.slice(0,-1);
    }
    truncate(kill).css("backgroundColor","#8ec6a9");
    truncate(triangle1).css("border-right","1rem solid #8ec6a9");
    truncate(kill).click(
        function () {
            alert("不要皮,请进行下一项活动");
        }
    );
}
function lastWords() {
    let kill = $(".lastWords");
    let triangle2 = $(".triangle-left2");
    function truncate(arr) {
        return arr.slice(0,-1);
    }
    truncate(kill).css("backgroundColor","#8ec6a9");
    truncate(triangle2).css("border-right","1rem solid #8ec6a9");
    truncate(kill).click(
        function () {
            alert("不要皮,请进行下一项活动");
        }
    );
}
function vote() {
    let kill = $(".vote");
    function truncate(arr) {
        return arr.slice(0,-1);
    }
    let triangle3 = $(".triangle-left3");
    truncate(kill).css("backgroundColor","#8ec6a9");
    truncate(triangle3).css("border-right","1rem solid #8ec6a9");
    truncate(kill).click(
        function () {
            alert("不要皮,请进行下一项活动");
        }
    );
}
function speak() {
    let kill = $(".speak");
    function truncate(arr) {
        return arr.slice(0,-1);
    }
    let triangle4 = $(".triangle-left4");
    truncate(kill).css("backgroundColor","#8ec6a9");
    truncate(triangle4).css("border-right","1rem solid #8ec6a9");
    truncate(kill).click(
        function () {
            alert("不要皮,请进行下一项活动");
        }
    );
}
// 过去天数步骤变色
function changeColor() {

}
// 被杀情况动态添加
function detail() {
     let a = -1;
     let b = 0;
    for (let i = 0 ; i<dayNum()-1;i++) {
        a++;
        b++;
       let  c =dieOrder()[`${b}-kill`];
        if (typeof c === "undefined"){
            $(".kill").eq(a).after(`<div class="killWho">无操作</div>`)
        }
        else {
            $(".kill").eq(a).after(`<div class="killWho">${c+1}号被杀手杀死，真实身份是水民</div>`)
        }
        let  d =dieOrder()[`${b}-vote`];
        if (typeof d === "undefined"){
            $(".vote").eq(a).after(`<div class="killWho">无操作</div>`)
        }
        else {
            $(".vote").eq(a).after(`<div class="killWho">${d+1}号被票死，真实身份是${storage()[d]}</div>`)
        }


    }
}
// 死亡顺序对象
function dieOrder() {

    // localStorage.removeItem("dayNum");
    let dieOrder = JSON.parse(localStorage.getItem("dieOrder"));
    console.log(`读取死亡顺序`+dieOrder);
    if (dieOrder ===null) {
        let dieOrder = {
            0:  0
        };
        localStorage.setItem("dieOrder", JSON.stringify(dieOrder));
        dieOrder = JSON.parse(localStorage.getItem("dieOrder"));
        console.log(`生成死亡顺序为` + dieOrder);
        return dieOrder;
    }
    else {
        console.log(`死人顺序为` + dieOrder);
        return dieOrder;
    }

}

// 状态
function state() {
    // localStorage.removeItem("dayNum");
    let a = localStorage.getItem("state");
    console.log(`读取状态存储值`+a);
    console.log(a);
    console.log(typeof a);
    console.log(a === "kill");
    if (a === "kill") {
        fsm.step1();
        let  c =dieOrder()[`${dayNum()}-kill`];
        if (typeof c === "undefined"){
            $(".kill").eq(-1).after(`<div class="killWho">无操作</div>`)
        }
        else {
            $(".kill").eq(-1).after(`<div class="killWho">${c+1}号被杀手杀死，真实身份是水民</div>`)
        }

        console.log("123123123");
        return a;
    }
    else if (a === "lastWord") {
        fsm.step1();
        fsm.step2();
        return a;
    }
    else if (a === "speak") {
        fsm.step1();
        fsm.step2();
        fsm.step3();
        return a;
    }

    else {
        console.log(`状态为` + a);
        return a;
    }
}
var chnNumChar = ["零","一","二","三","四","五","六","七","八","九"];
var chnUnitSection = ["","万","亿","万亿","亿亿"];
var chnUnitChar = ["","十","百","千"];
function SectionToChinese(section){
    var strIns = '', chnStr = '';
    var unitPos = 0;
    var zero = true;
    while(section > 0){
        var v = section % 10;
        if(v === 0){
            if(!zero){
                zero = true;
                chnStr = chnNumChar[v] + chnStr;
            }
        }else{
            zero = false;
            strIns = chnNumChar[v];
            strIns += chnUnitChar[unitPos];
            chnStr = strIns + chnStr;
        }
        unitPos++;
        section = Math.floor(section / 10);
    }
    return chnStr;
}
function NumberToChinese(num){
    var unitPos = 0;
    var strIns = '', chnStr = '';
    var needZero = false;

    if(num === 0){
        return chnNumChar[0];
    }

    while(num > 0){
        var section = num % 10000;
        if(needZero){
            chnStr = chnNumChar[0] + chnStr;
        }
        strIns = SectionToChinese(section);
        strIns += (section !== 0) ? chnUnitSection[unitPos] : chnUnitSection[0];
        chnStr = strIns + chnStr;
        needZero = (section < 1000) && (section > 0);
        num = Math.floor(num / 10000);
        unitPos++;
    }

    return chnStr;
}

// 有限状态机
var fsm = new StateMachine({
    init: 'stepNo',
    transitions: [
        { name: 'step1',     from: 'stepNo',  to: 'stepKill' },
        { name: 'step2',     from: 'stepKill',  to: 'stepLastWord' },
        { name: 'step3',     from: 'stepLastWord',  to: 'stepSpeak' },

        { name: 'step4', from: 'stepSpeak',    to: 'stepVote' }
    ],
    methods: {
        onStep1:     function() {

            // $(this).css("color","red");
            // $(".kill").last().css("color","red");
            console.log('I stepKill')
        },

        onStep2: function() {
            console.log('I stepLastWord')
        },
        onStep3:     function() {

            console.log('I stepSpeak')
        },
        onStep4:     function() {


            console.log('I stepVote')
        },
        onAfterStep1:     function() {
            $(".kill").last().css("backgroundColor","#8ec6a9");
            $(".triangle-left1").css("border-right","1rem solid #8ec6a9");
            console.log("AfterStep1");
        },
        onAfterStep2:     function() {
            $(".lastWords").last().css("backgroundColor","#8ec6a9");
            $(".triangle-left2").css("border-right","1rem solid #8ec6a9");
            console.log("AfterStep2");
        },
        onAfterStep3:     function() {
            $(".speak").last().css("backgroundColor","#8ec6a9");
            $(".triangle-left3").css("border-right","1rem solid #8ec6a9");
            console.log("AfterStep3");
        },
    }
});

$(document).ready(function () {
    // storage();
    // dayNum = dayNum();

        for (var i = 1; i<=dayNum();i++){
    let chinese= NumberToChinese(i);
        let txt1=$(`<div class="day" id="${i}">
    第${chinese}天
</div>
    <div class="gameFlowBox" id="${i}-">
        <div class="gameFlow">
            <div class="kill">杀手杀人
                <img class="sun" src="img/moon.png" />
                <div class="triangle-left1"></div>
            </div>
             <!--<div class="killWho">5号被杀手杀死，真实身份是平民</div>-->
            <div class="lastWords">亡灵发表遗言
                <img class="sun" src="img/sun.png" />
                <div class="triangle-left2"></div>
            </div>
            <div class="speak">玩家依次此发言
                <div class="triangle-left3"></div>
            </div>
            <div class="vote">全民投票
                <div class="triangle-left4"></div>
            </div>
            <!--<div class="killWho">5号被杀手杀死，真实身份是平民</div>-->
        </div>
    </div>`);  // 使用 jQuery 创建文本
        $("main").append(txt1);

        }
    $("main").append(`<div class="no"></div>`);


     // 折叠步骤
    $(".gameFlowBox").hide();
    $(".gameFlowBox").last().show();



    state();
    detail();
    $(document).on({
        click: function () {
            $(this).next().toggle();
        }
    },".day");

   // alert "不要皮"
    kill();
    lastWords();
    vote();
    speak();


    $(".kill").last().click(
        function () {
            switch (fsm.state){
                case "stepNo":
                    // location.href="index.html";
                    fsm.step1();
                    // $(".kill").last().css("color","red");
                    location.href="kill.html";
                    localStorage.setItem("state", "kill");
                    console.log("本地存储状态为"+localStorage.getItem("state"));
                    break;
                default:
                    alert("请进行下一项");
            }
        }
    );


    $(".lastWords").last().click(
        function () {
            switch (fsm.state){
                case "stepNo":
                    alert("请按顺序操作");
                    break;
                case "stepKill":
                    alert("请死者亮明身份，并发表遗言");
                    fsm.step2();
                    localStorage.setItem("state", "lastWord");
                    console.log("本地存储状态为"+localStorage.getItem("state"));
                    break;
                case "stepLastWord":
                    alert("请进行下一项");
                    break;
                default:
                    alert("请进行下一项");
            }
        }
    );
    $(".speak").last().click(
        function () {
            switch (fsm.state){
                case "stepNo":
                    alert("请按顺序操作");
                    break;
                case "stepKill":
                    alert("请按顺序操作");
                    break;
                case "stepLastWord":
                    alert("玩家依次发言讨论");
                    fsm.step3();
                    localStorage.setItem("state", "speak");
                    console.log("本地存储状态为"+localStorage.getItem("state"));
                    break;
                default:
                    alert("请进行下一项");
            }
        }
    );

    $(".vote").last().click(
        function () {
            switch (fsm.state){
                case "stepNo":
                    alert("请按顺序操作");
                    break;
                case "stepKill":
                    alert("请按顺序操作");
                    break;
                case "stepLastWord":
                    alert("请按顺序操作");
                    break;
                case "stepSpeak":
                    location.href="vote.html";
                    fsm.step4();
                    // localStorage.removeItem("state");
                    console.log("本地存储状态为"+localStorage.getItem("state"));
                    break;
                default:
                    alert("请进行下一项");
            }
        }
    );

    $("#x").click(
        function show_confirm() {
            let r=confirm("结束本轮游戏吗");
            if (r===true) location.href="index.html";
        }
    );

    $(".buttonLeft").click(function () {
        let r=confirm("本轮游戏是否已经结束？");
        if (r===true) location.href="result.html";
    });
    $(".buttonRight").click(function () {
            location.href="daily.html";
    });

});













// var menu = {
//
//     // 当前状态
//     currentState: 'hide',
//
//     // 绑定事件
//     initialize: function() {
//         var self = this;
//         self.on("hover", self.transition);
//     },
//
//     // 状态转换
//     transition: function(event){
//         switch(this.currentState) {
//             case "hide":
//                 this.currentState = 'show';
//                 doSomething();
//                 break;
//             case "show":
//                 this.currentState = 'hide';
//                 doSomething();
//                 break;
//             default:
//                 console.log('Invalid State!');
//                 break;
//         }
//     }
//
// };









