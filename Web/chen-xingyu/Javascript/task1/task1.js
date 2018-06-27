var box = document.getElementsByClassName("box");
function basicColor() {
    for(var i=0;i < box.length;i++){
        box[i].style.backgroundColor="#ffba12";
    }
}
function cc(){
    r = Math.floor(Math.random()*256);
    g = Math.floor(Math.random()*256);
    b = Math.floor(Math.random()*256);
    //随机获取一种不等于橙色的颜色
    return "rgb(" + r + ',' + g + ',' + b + ')';
}
function shine() {
    basicColor();
    var grid = [];
    var i;
    for (i = 0; i < box.length; i++) {
        grid[i] = i;
    }
    var x, y;
    var l = grid.length;
    while (l) {
        y = Math.floor(Math.random() * l--);
        x = grid[l];
        grid[l] = grid[y];
        grid[y] = x;
    }
    console.log(grid[0], grid[1], grid[2]);

    box[grid[0]].style.backgroundColor = cc();
    box[grid[1]].style.backgroundColor = cc();
    box[grid[2]].style.backgroundColor = cc();
}

    var cxy;

    function start() {
        clearInterval(cxy);
        cxy = setInterval("shine()", 1000);
    }

    function stop() {
        clearInterval(cxy);
        basicColor();
    }
