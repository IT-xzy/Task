var rotave=document.getElementById('rotave');
var prev=document.getElementById('prev');
var next=document.getElementById('next');
var simple=document.getElementsByClassName('simple');
prev.onclick = function() {
    animate(100);
};
next.onclick = function() {
    animate(-100);
};

function animate(offset) {
    var newLeft=parseInt(rotave.style.left)+offset;
    rotave.style.left=newLeft+ '%';
    if (newLeft<-300) {
        rotave.style.left = -100+ '%';
    }
    if (newLeft>-100) {
        rotave.style.left =-200 + '%';
    }
}

