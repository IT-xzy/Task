var box = document.getElementsByClassName('box');
function start() {
    setTimeout(select(),1000);
}
function orange() {
    for(var a=0;a<box.length;a++){
        box[a].style.background = "orange";
    }
}
function color() {
    var r = Math.floor(Math.random()*256);
    var g = Math.floor(Math.random()*256);
    var b = Math.floor(Math.random()*256);
    return "rgb(" + r + ','  + g + ',' + b + ")";
}
function select() {
    orange();
    setTimeout(abc(),1000);

    function abc() {
        for (var b = 0; b < 9; b = b + 1) {
            box[b].style.background = color();
            if (b === 8) {
                return select();
            }
        }
    }
function stop() {
    orange();
}