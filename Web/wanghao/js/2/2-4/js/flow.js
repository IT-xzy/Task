var outValue = JSON.parse(localStorage.getItem("outValue")); //读取对象数组
console.log(outValue);
 var dayNum = JSON.parse(localStorage.getItem("dayNum")) //读取日期变量
console.log(dayNum);
var outOject = JSON.parse(localStorage.getItem("outOject")) //读取面向对象数组
console.log(outOject);
var dayTime = JSON.parse(localStorage.getItem("dayTime")) //读取面向对象日志
console.log(dayTime)
var flowNum=JSON.parse(localStorage.getItem("flowNum")) //读取流程数据
console.log(flowNum)
if (dayNum) {} else { //当天数没有的时候
    dayNum = 0;
    localStorage.setItem("dayNum", JSON.stringify(dayNum))
}

if (dayTime) {
    if (dayTime.length < dayNum + 1) { //当日志的对象小于天数的时候往里面push
        let day = {};
        dayTime.push(day);
        localStorage.setItem("dayTime", JSON.stringify(dayTime)) //保存
    }

} else { //当对象日志没有数组的时候
    let day = {};
    dayTime = [];
    dayTime.push(day);
    localStorage.setItem("dayTime", JSON.stringify(dayTime)) //保存
}
if(flowNum){}else{ //当流程没有的时候
    flowNum=0;
    localStorage.setItem("flowNum",JSON.stringify(flowNum))
}
for (let i = 0; i < dayNum; i++) { //循环是否复制节点把前面的影藏
    let clone = $(".days")[0].cloneNode(true);
    $("main").append(clone);
}
for (let i=0;i<dayNum;i++){  //循环影藏
    $($(".flow-style")[i]).hide();
   
}
for(let i=0;i<dayNum;i++){  //循环变色
   let ii=i
    for(let o=0;o<4;o++){
        flowPI(ii,o)
    }
    flowgurad(i);  //循环填入杀手信息
    flowVote(i);   //循环填入全名投票信息
}

for (let i = 0; i < dayNum + 1; i++) { //循环填入数据
    let day = i + 1
    $(".day")[i].innerHTML = "第" + day + "天"
}

function flowPI(day, num) { //传参对应天数的对应i和p变色
    let flow = $(".flow")[day]; //读取对应天数的flow
    let li = $(flow).find("li"); //对应flow的li
    let child = $(li[num]).children(); //捕捉子集
    $(child[1]).css("background", "#83b09a"); //捕捉变量p
    $(child[0]).css("border-right", ".2rem solid #83b09a") //捕捉变量i
}
var flowOpen = new StateMachine({
    init: 'open',
    transitions: [{
            name: 'sha',
            from: 'open',
            to: 'wangling'
        },
        {
            name: 'wang',
            from: 'wangling',
            to: 'wanjia'
        },
        {
            name: 'wan',
            from: 'wanjia',
            to: 'quanming'
        },
        {
            name: "quan",
            from: "quanming",
            to: "jieshu"
        },
    ],
    methods: {
        onSha: function () {
            flowPI(dayNum, 0)
            if(flowNum!="1"){
                localStorage.setItem("flowNum",JSON.stringify("1"))
                localStorage.setItem("oject",JSON.stringify("杀手")) //存入判断对象
                window.location.href="rizhi.html"  //跳转页面
            }
            flowgurad(dayNum)
        },
        onWang: function () {
            headlink("死者良明身份并发表遗言");
            $(".popup-style").show();
            flowPI(dayNum, 1)
            flowgurad(dayNum)
        },
        onWan: function () {
            headlink("玩家按照顺序发言");
            $(".popup-style").show();
            flowPI(dayNum, 2)
        },
        onQuan: function () {
            flowPI(dayNum, 3)
            flowVote(dayNum);
            localStorage.setItem("flowNum",JSON.stringify("0"))
            localStorage.setItem("oject",JSON.stringify("全民")) //存入判断对象
             window.location.href="rizhi.html"  //跳转页面
        },
        onInvalidTransition: function () {
            headlink("请按照正确流程")
            $(".popup-style").show();
          
        }

    }
});
if(flowNum==1){   //如果flowNum为1就执行一个的状态机。
    flowOpen.sha();
}
function flowgurad(day){   //杀手文字
  let xx= $($(".flow")[day]).find("span")
 if(dayTime[day].gurad){
     xx[0].innerHTML="杀手杀了"+dayTime[day].gurad+"号"
 }
}
function flowVote(day){   //全民文字函数
    let xx= $($(".flow")[day]).find("span")
   if(dayTime[day].vote){
       xx[1].innerHTML="全名投死"+dayTime[day].vote+"号"
   }
  }

function headlink(text) {
    $(".headlink-text").text(text)
}
// =============================================================
$(".back,.faguan").on("click", function () { //返回箭头的点击事件
    localStorage.setItem("oject", JSON.stringify("法官"));
    window.location.href = "rizhi.html";
})
$(".day").on("click", function () {
    $(this).next().slideToggle(200);
})
$(".end-game,.close").on("click", function () { //结束游戏的点击事件
    $(".close-popup").show();
})
$(".shi").on("click", function () { //是的点击事件
   localStorage.setItem("win",JSON.stringify("游戏结束"))
    window.location.href = "win.html"
})
$(".fou").on("click", function () { //否的点击事件
    $(".close-popup").hide();
})
$(".queding").on("click", function () { //点击是以后弹窗消失
    $(".popup-style").hide();
})
$($(".flow")[dayNum]).on("click", function (event) {
    let e = event.target;

    if (e.tagName == "P") {
        let eClass = e.className
        switch (true) {
            case eClass == "gurad-text":
                flowOpen.sha();
                break;
            case eClass == "dead-text":
                flowOpen.wang();
                break;
            case eClass == "speak-text":
                flowOpen.wan();
                break;
            case eClass == "vote-tou":
                flowOpen.quan();
                break;
        }
    }
})