// 点击顶部返回按钮返回到游戏主页
function start() {
    // 点击返回弹出提示窗口
    if(confirm("是否要退出游戏，并返回到主页面")){     
        location.href = "start.html";//点击确定返回到主页面
     }else{
        return false;//点击取消停留在当前页面
    }
}

//获取输入玩家input节点
var quantity = document.getElementById("content");
// 获取杀手input节点
var Killer = document.getElementById("Killer");
// 获取平民input节点
var civilian = document.getElementById("civilian");


// 利用oninput输入事件触发玩家input属性
quantity.oninput = function () {
    var x=/\D/g;//定义正则，非数字规则
    this.value=this.value.replace(x,"");// 符合正则规则替换为空值
    gain(this.value);// 获取当前对象输入的值
}


var arr;//声明一个全局变量arr，让button的函数访问到arr变量

// 把获取的值赋给Killer和civilian两个input
function gain(value) {
    Killer.value = Math.round(value - (value / 2 + value / 6 + value / 24.1));
    civilian.value = Math.round(value / 2 + value / 6 + value / 24.1);

    // 当玩家值小于4或大于18赋给Killer和civilian值为空
    if (value< 4 || value > 18) {
        Killer.value = "";
        civilian.value = "";
    }else{
        arr=[];//arr定义为空数组，每次执行完函数重置arr为空

    // 当玩家值小于4或大于18把Killer和civilian以组数形式输出
        for (let i=0;i<Killer.value;i++){
            arr.push("杀手");//输出杀手的数量push到数组
        }
        for (let i=0;i<civilian.value;i++){
            arr.push("平民");//输出平民的数量push到数组
        }
    }
}
gain(quantity.value);//自运行



// // 点击button按钮判断条件
function button() {
    var array;
    // 获取输入玩家input的value的值
    var count = document.getElementById("content").value;
    // 获取输入玩家input的焦点，当人数不符时点击提示按钮获取焦点
    var focus = document.getElementById("content").focus();
    // 判断条件符合弹出提示窗口,否则进入下一个页面
    if (count < 4 || count > 18) {
        confirm("请输入正确的玩家数量。");
        quantity.value="";//点击提示按钮输入玩家input值为空
    } else {
        array=arr;//访问全局变量arr
        // 洗牌算法
        if(array){
            for (let i = array.length - 1; i > 0; i--) {
            // 打乱数组的玩家
            var j = Math.floor(Math.random() * (i + 1));
            var temp = array[i];
            array[i] = array[j];
            array[j] = temp;    
        }
        // 把打乱的玩家角色储存到浏览器本地
        localStorage.setItem("key",JSON.stringify(array));
        console.log(array);
        }  
        location.href = "check.html";//进入下一个页面
    }
    return false;//冒泡事件
}


// 键盘事件，onkeydown事件当用户按下按键触发
document.onkeydown = function (event) {//a是按键信息对象以函数参数的形式传递进来
   
     //取出按键信息中的按键代码(大部分浏览器通过keyCode属性获取按键代码，但少部分浏览器使用的却是charCode
    var code = event.charCode || event.keyCode;  

        //13为回车键的编码
    if (code === 13) {   
        button();//调用button函数
    }
}