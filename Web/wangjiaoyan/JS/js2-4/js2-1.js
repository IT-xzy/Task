

$(document).ready(function() {
    $(document).foundation();
});

var p1=document.getElementById("page1");
var p2=document.getElementById("page2");
function page1() {
    p1.style.display="block";
    p2.style.display="none";
}

function page2() {
    p1.style.display="none";
    p2.style.display="block";
}
function next() {
    location.href='js2-2.html';
}