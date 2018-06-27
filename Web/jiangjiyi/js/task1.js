var box = $(".box");
var time;


function suiji() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + "," + g + "," + b + ")";
}


function org() {
    for (var i= 0; i< box.length;i++) {
        box[i].style.backgroundColor = "orange";
    }
}

function df() {
    org();
    var box1 = Math.floor(Math.random() * box.length);
    var box2 = Math.floor(Math.random() * box.length);
    var box3 = Math.floor(Math.random() * box.length);
    if (box1!=box2&&box1!=box3&&box2!=box3) {
        box[box1].style.backgroundColor = suiji();
        box[box2].style.backgroundColor = suiji();
        box[box3].style.backgroundColor = suiji();
    }
    else {
        df()
    }
}

$("#btn1").click(function dfd() {
    clearInterval(time);
    time = setInterval(df, 1000);
});
$("#btn2").click(function () {
    org();
    clearInterval(time);
});
