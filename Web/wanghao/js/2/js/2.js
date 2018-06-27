// 读取面向对象
var outOject = JSON.parse(localStorage.getItem("outOject"));
// 读取日志
var night = JSON.parse(localStorage.getItem("night"));
// 读取谁胜利
var winOject = JSON.parse(localStorage.getItem("winOject"));
console.log(outOject)
console.log(night)
console.log(winOject)
// 捕捉win标签添加是谁胜利
var win = document.getElementsByClassName("win")[0];
win.innerHTML = winOject + "胜利";
// 捕捉header-main-title标签谈价百分比胜利
var headerMainMassge = document.getElementsByClassName("header-main-title")[0];
headerMainMassge.innerHTML = "太棒了!你知道么？在狼人杀中 只有20%的" + winOject + "取得游戏最终的 胜利哦！";


// ==============================================================
// 捕捉村民和狼遍历数组进行分数字
var cunNum = [];
var werwolfNum = [];
// 循环取出人数
for (let i = 0; i < outOject.length; i++) {
    if (outOject[i].name == "村民") {
        cunNum.push(outOject[i])
    } else if (outOject[i].name == "狼人") {
        werwolfNum.push(outOject[i])
    }
}
var cun = document.getElementsByClassName("cun")[0];
var werwolf = document.getElementsByClassName("werwolf")[0];
cun.innerHTML = "村&emsp;民" + cunNum.length + "人&emsp;&emsp;";
werwolf.innerHTML = "狼&emsp;人" + werwolfNum.length + "人&emsp;&emsp;";


// ==============================================================
// 复制节点循环填入
var main = document.getElementsByClassName("main")[0]
var li = main.getElementsByTagName("li");

for (let i = 0; i < night.length - 1; i++) {
    let clone = li[0].cloneNode(true);
    main.appendChild(clone);
   // console.log(night[i+1].vote==undefined)
    if(night[i+1].vote==undefined){
        li[i+1].removeChild(li[i+1].getElementsByClassName("massge")[1])
       // console.log(1111);
    }

}
// 循环填入数据

var date = document.getElementsByClassName("date"); // 捕捉天数对象
// 守卫信息
var guradTest = document.getElementsByClassName("gurad-test")

function guradXT(day) {
    if (night[day].gurad) {
        guradTest[day].innerHTML = "守卫守护了" + night[day].gurad + "号"
    }
}
//狼人信息
var werwolfTest = document.getElementsByClassName("werwolf-test")

function werwolfXT(day) {
    if (night[day].gurad) {
        let index = night[day].gurad - 1;
        werwolfTest[day].innerHTML = "狼人杀了" + night[day].werwolf + "号。真实身份为" + outOject[index].name;
    }
}
//女巫信息
var witchTest = document.getElementsByClassName("witch-test")

function witchXT(day) {
    if (night[day].witchSave) {
        witchTest[day].innerHTML = "女巫救了" + night[day].werwolf + "号"
    } else if (night[day].witchPoison) {
        let index = night[day].witchPoison - 1;
        witchTest[day].innerHTML = "女巫毒了" + night[day].werwolf + "号。真实身份为" + outOject[index].name;
    }
}
//预言家信息
var propTest = document.getElementsByClassName("prop")

function propXT(day) {
    if (night[day].prophet) {
        let index = night[day].prophet - 1
        propTest[day].innerHTML = "预言家验了" + night[day].werwolf + "号。真实身份为" + outOject[index].name;

    }
}
// 全名投票信息
var voteTest = document.getElementsByClassName("vote")

function voteXT(day) {
    if (night[day].vote) {
        let index = night[day].vote - 1
        voteTest[day].innerHTML = "全名投出" + night[day].vote + "号。真实身份为" + outOject[index].name;

    }
}
for (let i = 0; i < night.length; i++) {
    let num = i + 1
    date[i].innerHTML = "第" + num + "天"
    guradXT(i);
    werwolfXT(i);
    witchXT(i);
    propXT(i);
    voteXT(i);
}
var again=document.getElementsByClassName("again")[0]
again.addEventListener("click",function(){
    window.location.href="dome1.html";
})