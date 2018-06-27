function start() {
    var arr = [0, 1, 2, 3, 4, 5, 6, 7, 8];
    for (i = 0; i < 3; i++) {
        var a = Math.floor(Math.random() * arr.length);
        var b = Math.floor(Math.random() * arr.length);
        var c = Math.floor(Math.random() * arr.length);
        if (a !== b && a !== c && b !== c) {
            break;
        }
    }

    var square = document.getElementsByClassName("square");
    for (j = 0; j < square.length; j++) {
        square[j].style.background = "orange";
    }

    function color() {
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return 'rgb( ' + r + ',' + g + ',' + b + ')';
    }

    square[a].style.background = color();
    square[b].style.background = color();
    square[c].style.background = color();

    t = setTimeout("start()", 500);
    clearTimeout(t);
}


var t;

function stop() {
    console.log(t);
    clearInterval(t);
    var square = document.getElementsByClassName("square");
    for (h = 0; h < square.length; h++) {
        square[h].style.background = "orange";
    }

}