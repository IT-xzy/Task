var order = JSON.parse(localStorage.getItem('key'));
console.log(order)
// var player = document.getElementsByClassName("main_font");

var number = document.getElementsByClassName("main_number");
var b; //建立一个空变量
var dead = document.getElementsByClassName("main_font");
//获取盒子变量

var header_font = document.getElementsByClassName("header-font")[0];

var key1 = JSON.parse(localStorage.getItem('key1'));

var arr = [];
var arr = order;


function run() {
    var boxes;
    boxes = arr.length;


    var main = document.getElementsByTagName("main")[0];
    //获取标签main节点，变量名main

    for (var i = 0; i < arr.length - 1; i++) {
        var bb = document.getElementsByClassName("box")[0].cloneNode(true);
        //获取类名box节点，克隆，变量名bb
        main.appendChild(bb);
        //在main的后面向子节点添加bb节点。
        // console.log(play

    }
    for (var i = 0; i < arr.length; i++) {
        dead[i].innerText = (arr[i]);

        number[i].innerText = i + 1 + "号";
    }
}
run();

if (!localStorage.getItem('look')) {




    $(document).ready(function () { //jquery语句
        $('.box').click(function () { //绑定点击事件
            $('.skill-box').hide(); //隐藏
            $(this).find($('.skill-box')).show();
            //显示被点击的盒子下的隐藏内容
        })
    })
}



var die = JSON.parse(localStorage.getItem('key1'))
console.log(die)
if (die == null) {
    var die = [{}]; //创建空标签
}

for (let i = 0; i < arr.length; i++) { //for循环,以数组长度为循环条件
    var bb = document.getElementsByClassName("box");
    // console.log(bb)
    //获取"box"节点，赋值变量"bb";


    bb[i].onclick = function () { //绑定点击事件
        b = i;




        var a = localStorage.getItem('vote')
        console.log(a)
    }
}


if (localStorage.getItem('vote') == 1) { //如果get带‘vote’
    header_font.innerHTML = "投票"; //头部HTML样式改为“投票”
    console.log(555)
}
if (localStorage.getItem('look')) {
    header_font.innerHTML = "法官查看";
}




//构造函数
function Style(number, job, life) {
    this.number = number;
    this.job = job;
    this.life = life;
}


// var res = []; //创建空数组
// for (let i = 0; i < arr.length; i++) {
//     res.push(new Style(i + 1, arr[i], "c")); //将new Style的值push给res
// }
var res;
if (!localStorage.getItem('res')) { //如果没有get“res”
    var res = []; //创建空数组
    for (let i = 0; i < arr.length; i++) {
        res.push(new Style(i + 1, arr[i], "c")); //将new Style的值push给res
    }
} else {
    res = JSON.parse(localStorage.getItem('res'))
}




if (!localStorage.getItem('look')) {
    function footer_box() {
        var mm = 0;
        var nn = 0;
        var w = die.length - 1;
        if(b==undefined){
            confirm("请选择要操作的玩家")
            return;
        }
        if (res[b].life == 'dead') {
            confirm("当前玩家已死亡，请选择其他玩家");
            return;
        }
        if (localStorage.getItem('vote')) { //vote存在 那就是投票
            // header_font.innerHTML="投票";//头部HTML样式改为“投票”
            console.log(555)
            die[w].tou = b;
            die.push({});
            // console.log(JSON.parse(localStorage.getItem('vote')) == undefined)
            console.log(1)
            w = w++;
            localStorage.setItem("key1", JSON.stringify(die)); //保存数据
            localStorage.removeItem('liu');
            localStorage.removeItem('vote');
            res[b].life = 'dead'; //改变life为dead
            localStorage.setItem('res', JSON.stringify(res)); //保存变量res名为“res”
        } else { // vote不存在 ，那就杀人逻辑
            if (arr[b] == "杀手" && header_font.innerHTML == "杀手杀人") {
                confirm("你是杀手不能杀死本职业，请选择其他玩家杀死")
                return;
            } else {
                // dead[b].style.background="red";//杀死为红色
                console.log(die)
                res[b].life = 'dead'; //改变life为dead
                localStorage.setItem('res', JSON.stringify(res)); //保存变量res名为“res”
                // localStorage.getItem('res'); //读取“res”
                console.log(localStorage.getItem('res'))
                console.log(res)
                die[w].kill = b;
                localStorage.setItem("key1", JSON.stringify(die)); //保存数据
                localStorage.setItem('liu', 1) //名字为liu，值为1
            }
        }
        for (i = 0; i < res.length; i++) {
            if (res[i].job == "平民") {
                if (res[i].life == "c") {
                    mm++;
                    // if (mm == 0) {
                    //     location.href = "over.html";
                    // }
                } //判断语句不能放在for循环里！！！！！！！！！
            }

            if (res[i].job == "杀手") {
                if (res[i].life == "c") {
                    nn++;
                    // if (nn === 0) {
                    //     location.href = "over.html";
                    // }
                }
            }
        }
        console.log(mm, nn)
        if (mm == 0 || nn == 0) {
            // localStorage.setItem('res', JSON.stringify(res));
            location.href = "over.html";
        } else {
            // localStorage.setItem('res', JSON.stringify(res));
            location.href = "playscript.html";
        }
    }
} else {
    function footer_box() {
        localStorage.removeItem('look');
        location.href = "playscript.html";
    }
}

console.log(b)

for (i = 0; i < res.length; i++) {
    if (res[i].life == "dead") {
        dead[i].style.background = "red"; //杀死为红色
    }

}



