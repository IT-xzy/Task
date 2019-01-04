//获取输入玩家input节点
var antity = document.getElementById("quantity");
// 获取杀手input节点
var killer = document.getElementById("killer");
// 获取平民input节点
var civilian = document.getElementById("civilian");

var arr;//声明一个全局变量arr，让button的函数访问到arr变量

antity.oninput = function () {
    var x = /\D/g; //定义正则，非数字规则
    this.value = this.value.replace(x, ""); // 符合正则规则替换为空值
    player(this.value); // 获取当前对象输入的值
}

// 把获取的值赋给Killer和civilian两个input
function player(value) {

    killer.value = Math.round(value - (value / 2 + value / 6 + value / 24.1));
    civilian.value = Math.round(value / 2 + value / 6 + value / 24.1);

    // 时时保存分配的杀手总人数
    localStorage.setItem("Killernum", JSON.stringify(killer.value));
    // 时时保存分配的平民总人数
    localStorage.setItem("civiliannum", JSON.stringify(civilian.value));


    if (4 > value || 18 < value) { //当玩家值小于4或大于18赋给Killer和civilian值为空

        killer.value = ""; //输出空
        civilian.value = ""; //输出空

    } else {
        arr = [];//arr定义为空数组，每次执行完函数重置arr为空
        for (var i = 0; i < killer.value; i++) {
            arr.push("杀手")//输出杀手的数量push到数组
        }
        for (var i = 0; i < civilian.value; i++) {
            arr.push("平民")//输出平民的数量push到数组
        }
        console.log(arr)
    }

}
player(antity.value) //先帮默认值自运行一遍


// antity.oninput = function () {
//     mmp(); // 获取当前对象输入的值
// }

// function mmp() {
//     var x = document.getElementById("quantity").value;
//     var z= Math.round(x / 2 + x/ 6 + x/ 24.1);
//     var y = x - z;
//     document.getElementById("killer").value= y
//     document.getElementById("civilian").value =z


// if (4 > x || 18 < x) { //人数不正确判断
//     document.getElementById("killer").value = ""; //输出空
//     document.getElementById("civilian").value = ""; //输出空

// } else {
//     arr = [];
//     for (var i = 0; i < killer.value; i++) {
//         arr.push("杀手")
//     }
//     for (var i = 0; i < civilian.value; i++) {
//         arr.push("平民")
//     }
//     console.log(arr)
// }
// }

// mmp()//先帮默认值自运行一遍



function button() {
    var x = document.getElementById("quantity").value; //变量X为输入的总人数
    if (4 > x || 18 < x) { //判断条件
        confirm('请输入正确人数') //对话框
        return;
    } else {
        var res = []; //乱序，不过看不懂啊！！！！！！！！！
        for (var i = 0, len = arr.length; i < len; i++) {
            var randomIndex = Math.floor(Math.random() * arr.length);
            res[i] = arr[randomIndex];
            arr.splice(randomIndex, 1);
        }
        localStorage.setItem("key", JSON.stringify(res));//保存数据
        console.log(res);

    }
    location.href = "./js2-3.html";
    return false;
}

/// 键盘事件，onkeydown事件当用户按下按键触发
document.onkeydown = function (event) { //a是按键信息对象以函数参数的形式传递进来

    //取出按键信息中的按键代码(大部分浏览器通过keyCode属性获取按键代码，但少部分浏览器使用的却是charCode
    var code = event.charCode || event.keyCode;  

    //13为回车键的编码
    if (code === 13) {   
        button(); //调用button函数
    }
}
// var res = [];
// for (var i = 0, len = team.length; i < len; i++) {
//   // 随机叫个
//   var randomIndex = Math.floor(Math.random() * team.length);
//   // 出列到新队伍
//   res[i] = team[randomIndex];
//   // 原来的队伍人越来越少，因此上面的 randomIndex 需要实时获取 team.length
//   team.splice(randomIndex, 1);
// }
// console.log(res);
// 教官B：我不管你们咋排的，挨个随便找个人换下顺序var team = [1,2,3,4]
// for (var i = 0, len = team.length; i < len; i++) {
//   // 随机选择一个队友
//   var randomIndex = i + Math.floor(Math.random() * (len - i));
//   // 咱俩换换，找别人换过的相当于出列了，因此上面的 randomIndex 需要在剩下的人当中挑选
//   var temp = team[i];
//   team[i] = team[randomIndex];  
//   team[randomIndex] = temp;
// }
// console.log(team);
// 理论上两种方式概率一致，都是「摸牌」的方式