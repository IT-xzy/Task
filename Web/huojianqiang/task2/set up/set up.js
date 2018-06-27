function tiaozhuan(){
    window.location.href = '../首页/head.html';
};
//页面跳转至首页
function Licensing(){
    window.location.href = '../See/See.html';
};
var arr = [];
//防止点击不一致跳转
var dath = 0;
//页面跳转至发牌页面
function Appear(){
    var ul = document.getElementById("box");
    //设置一个变量，赋值获取id“box"
    var dd = document.getElementsByClassName("li-one");
    //设置一个变量，并且赋值，获取到classname
    var rr = document.getElementsByClassName("li-two");
    //设置一个变量，赋值，获取到的classname
    for(var x = 0;x < dd.length;i++){
        ul.removeChild(dd[x]);
        //移除ul里获取到的dd，dd[x]表示一个数组，x表示dd的长度，所以是循环移除
    }
    for(var h = 0; h < rr.length; g++){
        ul.removeChild(rr[h]);
        //移除ul中rr的长度，h，h是根据rr的长度循环得出结果
    }
    var c = document.getElementById("slider").value;
    // 给变量c赋值，是id slider的value数值
    var arr = [];
    //定义一个空的数组
    var killerNum;
    // 定义一个空的变量，取名为杀手
    var civilianNum; 
    //定义一个空的变量，取名为平民，用于给if做赋值
    if(c <= 8){
        killerNum = 2;
        civilianNum = c - 2;
        //在c小于等于8的时候，给杀手赋值为2
        //给杀手赋值为2，再接着使用获取到的value的数值减去设置的杀手数量就是平民的数量
    }else if(c <=11){
        killerNum = 3;
        civilianNum = c - 3;
        //如果获取到的c小于等于，给杀手赋值为3，
        //然后使用value的值减去杀手的数值就是平民的数量
    }else if( c <= 15){
        killerNum = 4;
        civilianNum = c - 4;
        //如果获取到的c小于等于，给杀手赋值为4，
        //然后使用value的值减去杀手的数值就是平民的数量
    }else{
        killerNum = 5;
        civilianNum = c - 5;
        //结果为false的时候，给杀手赋值为5，
        //然后使用value的值c减去杀手的数值就是平民的数量
    };
    //0代表杀手
    for(var q = 0;q < killerNum;q++){
        arr.push(0);    
        //给变量q赋值为0，在q小于杀手的人数的时候，把0这数字push进arr数组
        //运行结束后，在给q+1
    }
    //1代表平民
    for(var w = 0; w < civilianNum; w++){
        arr.push(1);
        //给w赋值为0，在w小于平民的人数的时候，把数字1push进arr数组
        //代码运行结束后，给w+1
    }
    for(var i = 0;i < c;i++){
        var li = document.createElement("li");
        // 定义的li变量，赋值为返回的li标签
        li.classList.add("li-one");
        //class li-one返回给li标签
    };
    var li;
    // 定义一个变量为li
    for(var g = 0; g < arr.length; g++){
        //变量给变量g赋值为0，在个小于arr的数组长度
          if(arr[g] == 0){
            //条件语句若结果为true，
            //也就是arr数组的结果为0的时候
            //设置一个新标签为li
            li = document.createElement("li");
            li.innerHTML = '&nbsp;杀&nbsp;手';
            li.classList.add("li-one");
            // 把li-one添加进li标签中
            ul.appendChild(li);
            // 意为在ul标签里添加li标签
        }else{
            // 结果为false的时候
            li = document.createElement("li");
            // 创建一个元素节点为li
            li.innerHTML = '&nbsp平&nbsp;民';
            li.classList.add("li-two");
            // 给li标签添加class为li-two
            ul.appendChild(li);
            // 给ul添加li标签
        };
        // web存储
        sessionStorage.setItem('key',JSON.stringify(arr));
        // var read = JSON.parse(sessionStorage.getItem("key"));
    };
    dath = 0;
};
var ss = sessionStorage.getItem('key');
console.log(ss);
//点击触发动态生成杀手，以及平民
function Enlarge(){//右边图片点击触发滑块增加
    x = document.getElementById('slider').value;
    if(x < 18){
        x++;
        document.getElementById('slider').value = x;//拖动条
        document.getElementById('display').value = x;//输入框
    }else{
        alert("Duang一下，人就变少了"); 
    };
    console.log(x);
};

function Reduce(){//左边图片点击触发value减少
    x = document.getElementById('slider').value;
    if(x > 6){
        x--;
        document.getElementById('slider') .value = x;
        document.getElementById('display').value = x; 
    }else{
        alert("人太少了,再找几个小伙伴来吧"); 
    };
    console.log(x);
};

function Obtain(){//输入框绑定拖动条
    var x = document.getElementById("display").value;
    document.getElementById("slider").value = x;
    if(x > 18 || x < 6){
        alert("最少6人，最多18人")
    };
    console.log(x);
    
};
function Obtain_two(){
    f = document.getElementById("slider").value;
    document.getElementById('display').value = f;
    dath = 1;
}; 
//拖动条绑定输入框
function Licensing(){
    if(sessionStorage.getItem('key')){
        if(dath == 0){
            window.location.href = '../See/See.html';
        }else{
            alert('对不起，请设置人数');//请将“文本框”改成你需要验证的属性名称! 
        }
    }else{
        alert('对不起，请设置人数');//请将“文本框”改成你需要验证的属性名称! 
    }
};
