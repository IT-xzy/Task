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
   
}
clone();
console.log(boxFLex[1])