// 取回本地数据
// var outValue =JSON.parse(localStorage.getItem("outValue"));
// console.log(outValue);
// 读取面向对象数组
var outOject = JSON.parse(localStorage.getItem("outOject"));
console.log(outOject)
// 读取天数参数
var outNumber = ~~JSON.parse(localStorage.getItem("outNumber"));
console.log("outNumber" + outNumber)
// 捕捉要复制的节点
var boxFLex = document.getElementsByClassName("box-flex");
// 捕捉父级节点
var main = document.getElementsByTagName("main")[0];
//console.log(boxFLex);
//读取nigth日志
var night = JSON.parse(localStorage.getItem("night"));

// 循环创建创建初始信息
function clone() {
    // 创建对应数量的窗口
    for (let i = 0; i < outOject.length - 1; i++) {
        var newNode = boxFLex[0].cloneNode(true);
        main.appendChild(newNode);
    }
    // 赋予对应窗口的身份
    for (let i = 0; i < outOject.length; i++) {
        let num = i + 1;
        boxFLex[i].getElementsByClassName("name")[0].innerHTML = outOject[i].name;
        boxFLex[i].getElementsByClassName("number")[0].innerHTML = outOject[i].number;
        // if (outOject[i].state == "dead") {
        //     boxFlex[i].getElementsByClassName("name")[0].style.background = "#83b09a";
        //     boxFlex[i].getElementsByClassName("number")[0].style.background = "#83b09a";
        // }
    }
    //检测是否死亡。死亡设置变颜色
    for (let i = 0; i < outOject.length; i++) {
        if (outOject[i].state == "dead") {
            boxFLex[i].getElementsByTagName("p")[0].style.background = "#83b09a";
            boxFLex[i].getElementsByTagName("p")[1].style.background = "#83b09a";
        }
    }

}
clone();

var lastEvent; //存下上一次点击的元素
var index; //存下下标
//console.log(lastEvent);
main.addEventListener("click", function (event) {
    let parentX = event.target.parentNode; //捕捉点击对象的父级
    let name = parentX.getElementsByClassName("name")[0];
    let number = parentX.getElementsByClassName("number")[0];
    let ul = parentX.getElementsByTagName("ul")[0];
   let indexy = [].indexOf.call(parentX.parentNode.parentNode.children, parentX.parentNode); //取出下标
    console.log(index);
    if (parentX.className == "box-style") { //进行判断父级class名为box-style 则生效
      // console.log(outOject[index].number)
        if (outOject[indexy].state != "dead"||outOject[indexy].number==night[outNumber].werwolf) { //判断点击的人是否或活着，活着才能点击
           console.log(outOject[indexy])
            if (lastEvent == undefined) { //如果是第一次点击的话
                ul.style.display = "flex"; //显示下标
                name.style.background = "#83b09a"; //保护颜色
                number.style.background = "#83b09a"; //保护颜色
                lastEvent = parentX; //储存本次点击的对象
                console.log(lastEvent);
            } else { //如果不是第一次点击的话
                lastEvent.getElementsByClassName("name")[0].style.background = "#f5c97b"; //清楚上一个颜色
                lastEvent.getElementsByClassName("number")[0].style.background = "#83b09a" //清楚上一个颜色
                lastEvent.getElementsByTagName("ul")[0].style.display = "none"; //清楚上一个的下面图标
                name.style.background = "#83b09a"; //杀人颜色
                number.style.background = "#83b09a"; // 杀人颜色
                ul.style.display = "flex" //显示下标
                lastEvent = parentX; //储存本次点击的对象
            }
            index=[].indexOf.call(parentX.parentNode.parentNode.children, parentX.parentNode); //取出下标
        }

       

    }

})
var footer = document.getElementsByTagName("footer")[0];
footer.addEventListener("click", function () { //设置投票的点击事件
   //如果日志的对象数少于日子那么往里面push一个对象
    if (night.length < outNumber + 1) { 
        let xx = {};
        night.push(xx);
    }
   
    night[outNumber].prophet=index+1
    
    console.log(night);
    // 储存日志
    localStorage.setItem("night", JSON.stringify(night));
    if(night[outNumber].prophet){
        window.location.href="../dome1.8.html";
   }
   
    
       
    
   

})