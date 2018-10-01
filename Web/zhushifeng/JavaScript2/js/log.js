var order = JSON.parse(localStorage.getItem('key'));
console.log(order)
var player = document.getElementsByClassName("main_font");
var number = document.getElementsByClassName("main_number");
var b;//建立一个空变量

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
        console.log(player)

    }
    for (var i = 0; i < arr.length; i++) {
        player[i].innerText = (arr[i]);

        number[i].innerText = i + 1 + "号";
    }
}
run();

$(document).ready(function () { //jquery语句
    $('.box').click(function () { //绑定点击事件
        $('.skill-box').hide(); //隐藏
        $(this).find($('.skill-box')).show();
         //显示被点击的盒子下的隐藏内容
    })
})





for(let i=0;i<arr.length;i++){//for循环,以数组长度为循环条件
    var bb=document.getElementsByClassName("box");
    //获取"box"节点，赋值变量"bb";
    bb[i].onclick=function(){//绑定点击事件
        b=i;
        console.log(b)
    }
//构造函数
function Style(life,time){
    this.life=life;
    this.time=time;
}
var bb=()


}

function footer_box() {
    if (arr[b]=="杀手") {
        confirm("你是杀手不能杀死本职业，请选择其他玩家杀死")
    } else {
        location.href = "playscript.html"
    }
}







// $(document).ready(function(){
//     $(".box").click(function(){
//     $(".skill-box").hide();
//     $(this).find($('.skill-box')).show();
//   });
//   });

// function myFunction(){

// 	var my2=document.getElementById("my2").lastChild;//itm=获取m2的子级的最后一位
// 	var cln=my2.cloneNode(true);//变量cln=克隆itm
// 	document.getElementById("my1").appendChild(cln);//将变量cln放入m1的HTML的后面
// }
