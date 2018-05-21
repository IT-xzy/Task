var a;
function go() {
    clearInterval(a);
    function GetRandomNum(Min,Max) {
        var Range = Max - Min;
        var Rand = Math.random();
        return(Min + Math.round(Rand * Range));
    }
    for(i=0;i<9;i++){
        var num1 = GetRandomNum(0,8);
        var num2 = GetRandomNum(0,8);
        var num3 = GetRandomNum(0,8);
        if(num1!==num2&&num2!==num3&&num1!==num3){
            break;
        }
    }
    var node = document.getElementsByClassName("box");
    for(j=0;j<node.length;j++){
        node[j].style.background = "orange";
    }
    function bg1() {
        var r = Math.floor(Math.random()*256);
        var g = Math.floor(Math.random()*256);
        var b = Math.floor(Math.random()*256);
        return "rgb("+r+','+g+','+b+")";
    }
    node[num1].style.background = bg1();
    node[num2].style.background = bg1();
    node[num3].style.background = bg1();

    a = setInterval("go()",1000);
}

function stop() {
    clearTimeout(a);
    var node = document.getElementsByClassName("box");
    for(i=0;i<9;i++){
        node[i].style.background = "orange";
    }
}



