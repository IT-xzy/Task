// 取回本地数据
var outValue =JSON.parse(localStorage.getItem("outValue"));
console.log(outValue);
// 捕捉要复制的节点
var boxFLex=document.getElementsByClassName("box-flex");
// 捕捉父级节点
var main=document.getElementsByTagName("main")[0];
//console.log(boxFLex);

// 循环创建创建初始信息
function clone(){
    // 创建对应数量的窗口
    for(let i=0;i<outValue.length-1;i++){
        var newNode=boxFLex[0].cloneNode(true);
        main.appendChild(newNode);
    }
    // 赋予对应窗口的身份
    for(let i=0;i<outValue.length;i++){
        let num=i+1;
        boxFLex[i].getElementsByClassName("name")[0].innerHTML=outValue[i];
       boxFLex[i].getElementsByClassName("number")[0].innerHTML=num;
    }   
    // 移除身份不符合的功能
   for(let i=0;i<outValue.length;i++){
    // 捕获对应节点下的功能表
    let fun=boxFLex[i].getElementsByClassName("fun")[0];
    let knife=boxFLex[i].getElementsByClassName("knife")[0];
    let check=boxFLex[i].getElementsByClassName("check")[0];
    let gun=boxFLex[i].getElementsByClassName("gun")[0];
    let save=boxFLex[i].getElementsByClassName("save")[0];
    switch(true){
        case outValue[i]=="村民":
        fun.removeChild(knife);
        fun.removeChild(check);
        fun.removeChild(gun);
        fun.removeChild(save);
        console.log(1);
        break;
        case outValue[i]=="狼人":
        fun.removeChild(check);
        fun.removeChild(gun);
        fun.removeChild(save);
        break;
        case outValue[i]=="猎人":
        fun.removeChild(knife);
        fun.removeChild(check);
        fun.removeChild(save);
        break;
        case outValue[i]=="女巫":
        fun.removeChild(check);
        fun.removeChild(gun);
        break;
        case outValue[i]=="白痴":
        fun.removeChild(knife);
        fun.removeChild(check);
        fun.removeChild(gun);
        fun.removeChild(save);
        break;
        case outValue[i]=="守卫":
        fun.removeChild(knife);
        fun.removeChild(check);
        fun.removeChild(gun);
        break;
        case outValue[i]=="预言家":
        fun.removeChild(knife);
        fun.removeChild(save);
        fun.removeChild(gun);
        break;
    }
   }
}
clone();
console.log(boxFLex[1])