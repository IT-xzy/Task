var oli = document.getElementsByTagName("li");
var btn = document.getElementsByTagName("button");
var startBtn;
var timer

function color() {
    var r, g, b;
    r = Math.floor(Math.random() * 256);
    g = Math.floor(Math.random() * 256);
    b = Math.floor(Math.random() * 256);
    return 'rgb(' + r + ',' + g + ',' + b + ')';
}

function Time() {
    var randomArray = [];
    for (var i = 0; i < oli.length; i++) {
        oli[i].style.background = "#ffa500";
    }
    for (var i = 0; i < 3; i++) {
        var randomLoc = Math.floor(Math.random() * (oli.length));
        if (randomArray.indexOf(randomLoc) < 0) {
            randomArray.push(randomLoc);
        } else {
            i--;
        }
    }
    oli[randomArray[0]].style.background = color();
    oli[randomArray[1]].style.background = color();
    oli[randomArray[2]].style.background = color();
}


btn[0].onclick = function () {
    if (btn[0].className == "") {
        Time();
        btn[0].className = "orange"
        clearInterval(timer);
        timer = setInterval("Time()", 1000); 
    }
}

btn[1].onclick = function () {
    clearInterval(timer);
    btn[0].className = "";
    for (var i = 0; i < oli.length; i++) {
        oli[i].style.background = "#ffa500";
    }
}