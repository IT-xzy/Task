"use strict"


function back() {
    var leftcont = document.getElementById('leftcont');
    var rightcont = document.getElementById('rightcont');

    if (rightcont.classList.contains("left-zero") ===true) {
        rightcont.classList.remove("left-zero");
        rightcont.classList.add("content");
        leftcont.classList.remove("left-pos");
        leftcont.classList.add("left-zero");
    }
    else {
        rightcont.classList.add("left-zero");
        leftcont.classList.add("left-pos");
        rightcont.classList.remove("content");
        leftcont.classList.remove("left-zero");
    }
}


