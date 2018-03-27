
console.log("JS成功执行进来;")
console.log("JS是否存在逻辑问题、变量问题、参数问题等等")
console.log("JS符号是否存在问题")



function toSimple () {
	window.location.href="https://ZZsuper.github.io/JS/TASK2/JS-TASK2-分配/JS-TASK2-分配.html";
}
function people() {
    var num = document.getElementById('number').value;
}

//滑块
// $(function() {
//     $("#line").slider({
//       range: "min",
//       value: 4,
//       min: 4,
//       max: 18,
//       slide: function(event, ui) {
//         $("#number").val(ui.value);
//       }
//     });
//     $("#number").val($("#line").slider("value"));
//   });
function player() {
    var killer_num1 = 1;
    var killer_num2 = 2;
    var killer_num3 = 3;
    var killer_num4 = 4;
    var num = $("#number").val(); 
    
        if (3 < num && num<=8) {
            return killer_num1;
        }
        else if (8 < num && num <=11) {
            return killer_num2;
        }
        else if (11 < num && num <=15) {
            return killer_num3;
        }
        else if (15 < num && num <=18) {
            return killer_num4;
        }
        else {
            alert("请输入正确的玩家数量(4 ~ 18)");
        }
};

function distribute() { //玩家配比
    var num = document.getElementById('number').value;
    if (player() == undefined) {
        document.getElementById('killer_num').value = null;
        document.getElementById('civilian_num').value = null;
    }
    else {
        document.getElementById('killer_num').value = player();
        document.getElementById('civilian_num').value = num - player();
    }

}


function voluation() {
    var num = document.getElementById("number").value;
    var killerNum = new Array(player());
    var civilianNum = new Array(num - player());
    var i;
    for (
        var i = 0;
        i < killerNum.length;
        i++
        ) {
        killerNum[i] = "1";//杀手 = 1;
    console.log(killerNum)
    }
    for (
        var a = 0;
        a < civilianNum.length;
        a++
        ) {
        civilianNum[a] = "0";//平民 = 0;
    console.log(civilianNum)
    }  
    civilianNum.push.apply(civilianNum,killerNum);//合并数组
    console.log(civilianNum);
    shuffle;
    return civilianNum;
}

//数组乱序
//Fisher-Yates Shuffle(从后向前遍历);
function shuffle() {  
    var _array = voluation();
    for (var i = _array.length; i--; ) {
        var j = Math.floor(Math.random() * (i + 1));//j = rand(i);  or  j=(rand(n)/n)*(n-i+1)+i-1; ps: n=_array.length;
        var temp = _array[i];   //简便写法exchange(_array[i], _array[j]);
        _array[i] = _array[j];
        _array[j] = temp;
    } 
    return _array;
};
console.log(shuffle());

$("#set_text").click(function a() {
    shuffle;
    var shuffle = JSON.stringify(shuffle());
    sessionStorage.setItem("deal", shuffle);
}); 


// var storage;
// $("#set_text").click(function a(){
    
// });


//点击去发牌跳转
go_deal.addEventListener("click",toDeal);
function toDeal() {
    player;
    distribute;
    voluation;
    shuffle;
    var k = document.getElementById('killer_num').value;
    if (k) {
        window.location.href="JS-TASK2-翻牌.html";

    }
    else {
        alert("请输入正确的玩家数量(4 ~ 18)");
    }

};




// var num = document.getElementById('number').value;


 

 

