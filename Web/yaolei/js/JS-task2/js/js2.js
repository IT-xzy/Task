function myFunction() {
    window.location.href="./js2-1.html";
}
function man() {
    //onchange时重置
    document.getElementById("killer").innerHTML = "";
    document.getElementById("people").innerHTML = "";
    //获取输入的玩家数的值
    var a = document.getElementsByClassName("input1")[0].value;
    if (a > 3 && a < 19) {
        //准备分配角色
        var b = Math.floor(a * 0.25);
        var c = a - b;
        //显示到页面
        document.getElementById("killer").innerHTML = b;
        document.getElementById("people").innerHTML = c;
        console.log(b);
        sessionStorage.setItem('all',a);
        sessionStorage.setItem('killerNum',b);
        sessionStorage.setItem('manNum',c);
    }
    else return false;
    //前b为杀手
    var ab = [];
    for (var i = 0; i < b; i++) {
        var d = "杀手";
        ab.push(d);
    }
    //b后面为平民
    var bc = [];
    for (var i = b; i < a; i++) {
        var d = "平民";
        bc.push(d);
    }
    //合并数组，杀手在前，平民在后
    var e = ab.concat(bc);
    //打乱数组排序
    for (var h = e.length; h--;) {
        var j = Math.floor(Math.random() * (h + 1));
        var g = e[h];
        e[h] = e[j];
        e[j] = g;
    }
    var arrAy = JSON.stringify(e);
    sessionStorage.setItem("data" ,arrAy);
}

function print() {
    var a = userForm.manNum.value;
    if (a > 3 && a < 19) {
        window.location.href = "./js2-4.html";
    } else {
        alert("请输入正确的玩家数量")
    }
}
$('body').css('backgroundColor', '#fff');