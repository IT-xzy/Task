console.log("JS文件");

function back(){
    history.back();
}
function off(){
    var choose=confirm("是否结束本轮游戏？");
    if (choose){
        location.replace("page2.html");
    }
}
