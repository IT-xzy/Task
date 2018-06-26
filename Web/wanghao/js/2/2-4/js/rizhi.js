var oject=JSON.parse(localStorage.getItem("oject"))  //取回对象判断
console.log(oject);
var outValue =JSON.parse(localStorage.getItem("outValue")) //取回数组
console.log(outValue);
var dayNum=JSON.parse(localStorage.getItem("dayNum")) //取回天数
console.log(dayNum);
var dayTime=JSON.parse(localStorage.getItem("dayTime"))//取回日志
console.log(dayTime);
var outOject=JSON.parse(localStorage.getItem("outOject"))//取回对象
console.log(outOject);
var lastIndex;  //上一个下标
var nowIndex;   //现在的小标
for(let i=0;i<outValue.length-1;i++){ //循环复制节点
    let clone=$(".box-flex")[0].cloneNode(true);
    $("main").append(clone);
}
if (outOject) {} else { //当对象数组没有的时候
    outOject = [];
    for (let i = 0; i < outValue.length; i++) {
        let wanjia = {
            name: outValue[i],
            number: i + 1,
            state: "health"
        }
        outOject.push(wanjia);
        localStorage.setItem("outOject", JSON.stringify(outOject)) //保存到本地
    }
}
for(let i=0;i<outValue.length;i++){ //循环填入数字，身份 //以及更爱颜色
    $(".name")[i].innerHTML=outValue[i];
    $(".number")[i].innerHTML=i+1
    if(outOject[i].state=="dead"){
        $($(".name")[i]).css("background","#83b09a")
    }
}

switch(true){
    case oject=="法官":
   faguan();
    break;
    case oject=="杀手":
    shashou();
    break;
    case oject=="全民":
    quanming();
    break;

}
function faguan(){ //法官函数 影藏多余的东西
    $(".link").text("法官日志") //改变文字
  $(".close").hide();
if(dayNum){    //判断是否有天数产生
    $("a").text("返回")
}else{
    $("a").text("开始游戏")
}

}
function shashou(){    //杀手函数
    $(".link").text("杀手杀人") //改变文字
    $("a").text("投票")  //改变文字
}
function quanming(){    //全名函数
    $(".link").text("全名投票") //改变文字
    $("a").text("投票")  //改变文字
}
$(".box-style").on("click",function(event){   //格子点击
    let e=event.target.parentNode;
    let eParentIndex=$(e.parentNode).index();
  //  console.log($(e.parentNode).index());
   if(oject!="法官"){
       if(e.className=="box-style"){   
      if(outOject[eParentIndex].state=="health"){  //当点击的对象是或者的时候
      
        if(lastIndex||lastIndex==0){
            nowIndex=eParentIndex;   //下标存入
            let lastName=$(".name")[lastIndex];
            $(lastName).css("background","#f5c97b") //清除颜色
            $($(".fun")[lastIndex]).hide()    //清除点击效果
            let name=$(".name")[nowIndex]; 
           $(name).css("background","#83b09a");
           $($(".fun")[nowIndex]).show()
           lastIndex=eParentIndex;
           }
           else{
            nowIndex=eParentIndex;   //下标存入
            lastIndex=eParentIndex;
           let name=$(".name")[nowIndex]; 
           $(name).css("background","#83b09a");
           $($(".fun")[nowIndex]).show()
           }
      }}
      console.log(nowIndex)
    }
   }
  
)
function win(){   //判断胜利条件
    let sha=0;
    let ming=0;
    for(let i=0;i<outOject.length;i++){   //统计数据里的村民和杀手几个人活着
     
        if(outOject[i].name=="村民"){
            console.log(1)
            if(outOject[i].state=="health"){
                ming=ming+1;
            }
        }else{
            console.log(1)
            if(outOject[i].state=="health"){
                sha=sha+1;
            }
        }
    }
    console.log(sha)
    console.log(ming)
     if(sha==0){   //杀手阵亡
        localStorage.setItem("win",JSON.stringify("村民胜利"));
        window.location.href="win.html"
    }else if(ming==0){   //村民阵亡
        localStorage.setItem("win",JSON.stringify("杀手胜利"));
        window.location.href="win.html"
    }else{  //啥事都没有
        window.location.href="flow.html";  //跳转;
    }
}

// =====================================================
// 法官的时候绑定点击事件
$("footer").on("click",function(){
    switch(true){
        case oject=="法官":
        window.location.href="flow.html";
        break;
        case oject=="杀手":
        shaClick();
        break;
        case oject=="全民":
        quanClick();
        break;

    }
   
})
function shaClick(){
     dayTime[dayNum].gurad=nowIndex+1;  //更改日志
     outOject[nowIndex].state="dead";   //更改属性
    localStorage.setItem("dayTime",JSON.stringify(dayTime)) ;//保存数据
     localStorage.setItem("outOject",JSON.stringify(outOject)) ;
   win();
}
function quanClick(){
    dayTime[dayNum].vote=nowIndex+1;  //更改日志
    outOject[nowIndex].state="dead";   //更改属性
   localStorage.setItem("dayTime",JSON.stringify(dayTime)) ;//保存数据
    localStorage.setItem("outOject",JSON.stringify(outOject)) ;
    localStorage.setItem("dayNum",JSON.stringify(dayNum+1));
    win();
}