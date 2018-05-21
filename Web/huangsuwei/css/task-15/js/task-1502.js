window.onload = function (){
    var list=document.getElementById('list');
    var prev=document.getElementById('prev');
    var next=document.getElementById('next');
    var container = document.getElementById('slideshow-father');
    prev.onclick = function() {
        console.log("1");
        animate(100);
    }
    next.onclick = function() {
        console.log("2");
        animate(-100);
    }
    var timer;
    function play() {

        timer=setInterval(function () {
            console.log("0");
            prev.onclick()
        },3000)
    }
    function stop() {
        console.log("4");
        clearInterval(timer);
    }
    container.onmouseover = stop;
    container.onmouseout = play;
    function animate(offset) {
        console.log("3");
        var newLeft=parseInt(list.style.left)+offset;
        list.style.left=newLeft+ 'vw';
        if (newLeft<-400) {
            list.style.left = -200 + 'vw';
        }
        if (newLeft>-100) {
            list.style.left =-200 + 'vw';
        }

    }
    play();
}
