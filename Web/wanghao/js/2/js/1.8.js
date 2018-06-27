// 取回本地数据
var outValue =JSON.parse(localStorage.getItem("outValue"));
console.log(outValue);
// 读取存入的outNmuber变量
 var outNumber = ~~JSON.parse(localStorage.getItem("outNumber"));
console.log("outNumber"+outNumber);
// 定义一个流程数据，来判断跳转回来后渲染几个颜色，以及流程到那
 var flowNum=~~JSON.parse(localStorage.getItem("flowNumber"));

console.log("flowNum"+flowNum);
// 读取黑白天日志
var night=JSON.parse(localStorage.getItem("night"));
console.log(night);
// var dayTime=JSON.parse(localStorage.getItem("dayTime"))

// ===============================================================
if (night.length < outNumber + 1) {
    let xx = {};
    night.push(xx);
    localStorage.setItem("night",JSON.stringify(night))
}

// ====================================================================
// 女巫解药和毒药的判断对象
var madicine=JSON.parse(localStorage.getItem("madicine"))
console.log(madicine)
// ==================================================================
// 捕捉back返回网址
var back = document.getElementsByClassName("back")[0];
back.addEventListener("click", $back);

function $back() {
    window.location.href = "dome1.7.html"
}
// ==================================================================

// 读取面向对象数组
var outOject=JSON.parse(localStorage.getItem("outOject"));
// 判断如果面向对象数组为空即创建面向对象
if(outOject.length<3){
   // console.log(1)
       for(let i=0;i<outValue.length;i++){
           let wanjia;
           outOject.push(wanjia);
           outOject[i]=new function(){
               this.name=outValue[i];
               this.number=i+1;
               this.state="health";
           }
       }
       localStorage.setItem("outOject",JSON.stringify(outOject));
}

console.log(outOject)

// ==========================================================================
// 捕捉main节点设置事件委托，完成每个对应的天数点击可以影藏出现
var main = document.getElementsByTagName("main")[0];
main.addEventListener("click", function (event) {
    // 捕捉他们的父级节点进行判断
    let ownX = event.target;
    // console.log(flowStyle);
    // 判断是否点击在天数的day上，如果是则进行判断
    if (ownX.className == "day") {
        // 捕捉点击天数的兄弟节点
        let flowStyle = event.target.nextElementSibling;
        if (flowStyle.style.display == "block" || getComputedStyle(flowStyle, false).display == "block") {
            flowStyle.style = "display:none"
        } else {
            flowStyle.style = "display:block"
        }
    }
})


// ==============================================================================
// 捕捉每个流程的文本节点，方便填充数据
// 守卫信息
var guradText = document.getElementsByClassName("gurad-text"),
    // 狼人信息
    werwolfText = document.getElementsByClassName("werwolf-text"),
    // 女巫信息
    witchText = document.getElementsByClassName("witch-text"),
    // 预言家信息
    prophetText = document.getElementsByClassName("prophet-text"),
    // 死亡信息
    theDeadText = document.getElementsByClassName("the-dead-text")
// 投票信息
voteText = document.getElementsByClassName("vote-text"),


    // 捕捉每个流程的父级节点用来改变颜色
    gurad = document.getElementsByClassName("gurad"),
    // 狼人信息
    werwol = document.getElementsByClassName("werwolf"),
    // 女巫信息
    witch = document.getElementsByClassName("witch"),
    // 预言家信息
    prophet = document.getElementsByClassName("prophet"),
    // 死亡信息
    theDead = document.getElementsByClassName("the-dead")
// 投票信息
vote = document.getElementsByClassName("vote");



// ==============================================================
function deadXT(day){  //死亡信息生成
    switch(true){
        // 守卫守中，女巫没用解药
        case night[day].gurad==night[day].werwolf&&night[day].gurad!=night[day].witchSave:
        if(night[day].witchPoison!=null){
            theDeadText[day].innerHTML=night[day].witchPoison+"号死亡"
        }else{
            theDeadText[day].innerHTML="平安夜"
        };
        break;
        //守卫守中，女巫却救了，暴毙
        case night[day].gurad==night[day].werwolf&&night[day].gurad==night[day].witchSave:
        theDeadText[day].innerHTML=night[day].witchSave+"号死亡";
        break;
        // 守卫没守中，女巫也没有救,也没有毒人
        case night[day].gurad!=night[day].werwolf&&night[day].werwolf!=night[day].witchSave&&night[day].witchPoison==undefined:
        theDeadText[day].innerHTML=night[day].werwolf+"号死亡"
        break;
        //守卫没有守中，女巫没有救人，毒人了
        case night[day].gurad!=night[day].werwolf&&night[day].werwolf!=night[day].witchSave&&night[day].witchPoison!=undefined:
        theDeadText[day].innerHTML=night[day].werwolf+"号和"+night[day].witchPoison+"号死亡";
        break;
        //守卫没有守中，女巫救人了
        case night[day].gurad!=night[day].werwolf&&night[day].werwolf==night[day].witchSave:
        theDeadText[day].innerHTML="平安夜"
        break;
    }
    
  //console.log(1 !=night[day].witchSave)
}
// =================================================================

// 创建流程有限状态机来更改状态
var flowOpen = new StateMachine({
    init: "open",
    transitions: [{
            name: "shou",
            from: "open",
            to: "endShou"
        },
        {
            name: "lang",
            from: "endShou",
            to: "endLang"
        },
        {
            name: "nv",
            from: "endLang",
            to: "endNv"
        },
        {
            name: "yv",
            from: "endNv",
            to: "endYv"
        },
        {
            name: "si",
            from: "endYv",
            to: "endSi"
        },
        {
            name: "wan",
            from: "endSi",
            to: "endWan"
        },
        {
            name: "quan",
            from: "endWan",
            to: "endQuan"
        }
    ],
    methods: {
        onShou: function () {
           if(flowNum>0){  }
           else{
             localStorage.setItem("flowNumber",JSON.stringify("1"))
               window.location.href="id-dome/gurad.html"
             
           }
           guradXT(outNumber);
        },
        onLang: function () {
            if(flowNum>1){}
            else{
               localStorage.setItem("flowNumber",JSON.stringify("2"))
             window.location.href="id-dome/werwolf.html"
         
            }
            werwolfXT(outNumber);
        },
        onNv: function () {
            if(flowNum>2){}
            else{
               witchPopup(night[outNumber].werwolf)
                localStorage.setItem("flowNumber",JSON.stringify("3"))  
             
            }
            flowPI(2)
            witchXT(outNumber);

        },
        onYv: function () {
            if(flowNum>3){}
            else{
               localStorage.setItem("flowNumber",JSON.stringify("4"))
               window.location.href="id-dome/prophet.html"
            }
           prophetXT(outNumber);
        },
        onSi: function () {
            if(flowNum>4){}
            else{
               localStorage.setItem("flowNumber",JSON.stringify("5"))
               document.getElementsByClassName("flow")[outNumber].getElementsByClassName("the-dead")[0].getElementsByTagName("p")[0].style.background = "#acabab";
               document.getElementsByClassName("flow")[outNumber].getElementsByClassName("the-dead")[0].getElementsByTagName("i")[0].style=style = "border-right:.2rem solid #acabab ;";
            //    变色完成读取数据
            deadXT(outNumber);
            }
        },
        onWan: function () {
            if(flowNum>5){}
            else{
               localStorage.setItem("flowNumber",JSON.stringify("6"))
                document.getElementsByClassName("flow")[outNumber].getElementsByClassName("speak")[0].getElementsByTagName("p")[0].style.background = "#acabab";
                document.getElementsByClassName("flow")[outNumber].getElementsByClassName("speak")[0].getElementsByTagName("i")[0].style=style = "border-right:.2rem solid #acabab ;";
                popupwindow("玩家依次发言")
            }
        },
        onQuan: function () {
            // 流程归零
               localStorage.setItem("flowNumber",JSON.stringify("0"));
              window.location.href="id-dome/vote.html";
        },
        onInvalidTransition: function () {
            popupwindow("请点击正确的流程");
        }

    }
});
// 定义状态机的this指针绑定
var shouFlow=flowOpen.shou.bind(flowOpen);
var nvFlow=flowOpen.nv.bind(flowOpen);
var yvFlow=flowOpen.yv.bind(flowOpen)

// ================================================================




// ==================================================================
// 每次刷新自动运行的函数，用来填充数据
function openwindow() {
    // 根据outNumber的数量来决定节点拷贝次数
    for (let i = 0; i < outNumber; i++) {
        // 捕捉days节点，进行克隆
        let days = document.getElementsByClassName("days")[0];
        let cloneNode = days.cloneNode(true);
        main.appendChild(cloneNode);
    }
    // 根据天数进行修改数据
    for (let i = 0; i < outNumber + 1; i++) {
        // 形成天数
        let num = i + 1;
        // 捕捉对应天数的days
        let days = document.getElementsByClassName("days")[i];
        //console.log(days);
        days.getElementsByClassName("day")[0].innerHTML = "第" + num + "天";
    }
    // 这个时候做一个判断，如果天数大于0,那么把前面的流程循环填入数剧
    if (outNumber > 0) {
        //console.log("33");
        for (let i = 0; i < outNumber; i++) {
            // 循环填入以前天数的信息
            guradXT(i);
            werwolfXT(i);
            witchXT(i);
            prophetXT(i);
            deadXT(i);
            voteXT(i);
         //   console.log(voteXT(i))
            // 循环改变前的天数流程的颜色
            flowColor(i);
        }

    }
    // 根据流程flowNum数据进行渲染颜色
    for(let i=0;i<flowNum;i++){
        flowPI(i);
    }
    // 根据人数判断流程状态有几个
    // 并根据穿出来的数据flowNum分析怎么转换状态
    if(outValue.length>12){// 当人数为13个的时候流程全部都有
        switch(true){
            case flowNum==1:
            flowOpen.shou();
            break;
            case flowNum==2:
            flowOpen.shou();
            flowOpen.lang();
            break;
            case flowNum==3:
            flowOpen.shou();
            flowOpen.lang();
            flowOpen.nv();
            break;
            case flowNum==4:
            flowOpen.shou();
            flowOpen.lang();
            flowOpen.nv();
            flowOpen.yv();
            break;
            case flowNum==5:
            flowOpen.shou();
            flowOpen.lang();
            flowOpen.nv();
            flowOpen.yv();
            break;
            case flowNum==6:
            flowOpen.shou();
            flowOpen.lang();
            flowOpen.nv();
            flowOpen.yv();
            flowOpen.si();
            break;
            case flowNum==7:
            flowOpen.shou();
            flowOpen.lang();
            flowOpen.nv();
            flowOpen.yv();
            flowOpen.si();
            flowOpen.wan();
            break;
        }
    }
}

// ================================================================
// openwindow里调用的函数


// ========================================================
// 过去天数的信息添加
function guradXT(day){ //守卫信息生成
   // console.log(typeof(night[day].gurad))
   if(night[day].gurad){
       guradText[day].innerHTML="守卫守了"+night[day].gurad+"号"
   }
}
function werwolfXT(day){ //狼人信息生成
    if(night[day].werwolf){
        let indexW=night[day].werwolf-1;
        //console.log(indexW)
        werwolfText[day].innerHTML="狼人杀了"+night[day].werwolf+"号"+"。"+"身份为"+outOject[indexW].name;
    }
 }
 function witchXT(day){ //女巫信息生成
    if(night[day].witchSave){
        let indexW=night[day].witchSave-1;
        console.log(indexW)
        witchText[day].innerHTML="女巫救了"+night[day].witchSave+"号"+"。";
       
    }else if(night[day].witchPoison){
        let indexW=night[day].witchPoison-1;
        console.log(indexW)
        witchText[day].innerHTML="女巫毒了"+night[day].witchPoison+"号"+"。"+"身份为"+outOject[indexW].name;
    }
 }
function prophetXT(day){  //预言家信息生成
    if(night[day].prophet){
        let indexW=night[day].prophet-1;
        //console.log(indexW)
        prophetText[day].innerHTML="预言家验了"+night[day].prophet+"号"+"。"+"身份为"+outOject[indexW].name;
    }
}
function voteXT(day){ //
    if(night[day].vote){
        let indexW=night[day].vote-1;
        //console.log(indexW)
        voteText[day].innerHTML="全名投票"+night[day].vote+"号。身份为"+outOject[indexW].name
    }
}


//  =============================================================
// 捕捉未知天数的flow
var flow = document.getElementsByClassName("flow");
// 过去天数颜色的改变
function flowColor(x) {
    //    捕捉未知flow的p和li
    let p = flow[x].getElementsByTagName("p");
    let arrows = flow[x].getElementsByTagName("i");
    //console.log(arrows);
    for (let i = 0; i < 7; i++) {
        p[i].style.background = "#acabab";
        arrows[i].style = "border-right:.2rem solid #acabab ;";
    }
    
}
// 创建某个天数对应的x个p和i变色
function flowPI(x){
    let p = flow[outNumber].getElementsByTagName("p")[x];
    let arrows = flow[outNumber].getElementsByTagName("i")[x];
    p.style.background = "#acabab";
     arrows.style = "border-right:.2rem solid #acabab ;";
}
// =================================================================

// 载入openwindow函数
openwindow();


// ==================================================================
// 定义流程的事件委托
flow[outNumber].addEventListener("click",function(event){
    let parentX=event.target.parentNode
   
    if(parentX.tagName=="LI"){
        switch(true){
            case parentX.className=="gurad":
            flowState("守卫",1, shouFlow);
            break;
            case parentX.className=="werwolf":
            flowOpen.lang();
            break;
            case parentX.className=="witch":
           flowState("女巫",3, nvFlow);
            break;
            case parentX.className=="prophet":
            flowState("预言家",4,yvFlow);
            break;
            case parentX.className=="the-dead":
            popupwindow("报死亡信息")
            flowOpen.si();
            break;
            case parentX.className=="speak":
            flowOpen.wan();
            break;
            case parentX.className=="vote":
            flowOpen.quan();
            break;

        }
    }
})


// ===============================================================
// 定义女巫救人和毒人的函数
var madiniceSave=document.getElementsByClassName("witchlink")[0].getElementsByTagName("button")[0];
var madinicsDead=document.getElementsByClassName("witchlink")[0].getElementsByTagName("button")[2];
// 救人的点击事件
madiniceSave.addEventListener("click",function(){
    let dead=night[outNumber].werwolf-1;
    if(madicine.save==1){
         if(outOject[dead].state=="dead"){ //正常救人
        outOject[dead].state="health";
        night[outNumber].witchSave=dead+1;
        console.log(outOject);
        console.log(night)
        witchXT(outNumber)
    }
    else{                              //同手同救
        outOject[dead].state="dead";
        console.log(outOject);
        night[outNumber].witchSave=dead+1;
        console.log(night);
        witchXT(outNumber)
    }
    }
   
    madicine.save=0;
    localStorage.setItem("madicine",JSON.stringify(madicine))
    localStorage.setItem("night",JSON.stringify(night));//储存日志
    night=JSON.parse(localStorage.getItem("night")); //读取日志
    localStorage.setItem("outOject",JSON.stringify(outOject))
    outOject=JSON.parse(localStorage.getItem("outOject"));
    witchwindow.style.display="none";
})
// 毒人的点击事件
madinicsDead.addEventListener("click",function(){
    if( madicine.dead==1){
         madicine.dead=0;
    localStorage.setItem("madicine",JSON.stringify(madicine));
    window.location.href="id-dome/witch.html"
    }
})
// ================================================================
// 下面的按钮
var footer=document.getElementsByTagName("footer")[0];
var close=footer.getElementsByTagName("button")[0];
var rizhi=footer.getElementsByTagName("button")[1];
rizhi.addEventListener("click",function(){
    window.location.href="dome1.7.html";
})
var closePopup=document.getElementsByClassName("close-popup")[0]
close.addEventListener("click",function(){
    closePopup.style.display="flex";
})
var shi=closePopup.getElementsByTagName("button")[0];
shi.addEventListener("click",function(){
    window.location.href="dome1.html"
})
var fou=closePopup.getElementsByTagName("button")[1];
fou.addEventListener("click",function(){
    closePopup.style.display="none"
})

// ==============================================================
// 判断身份是否或者，活着才能有功能
function flowState(name123,flowNumber,flowSS){
    for(let i=0;i<outOject.length;i++){
        if(outOject[i].name==name123){
            if(outOject[i].state!="dead"){
              flowSS();
              
            }else if(outOject[i].state=="dead"){
                flowPI(flowNumber-1);
                flowNum=flowNumber;
                localStorage.setItem("flowNumber",JSON.stringify(flowNum))
               flowSS();
            } 
        }
    }
}