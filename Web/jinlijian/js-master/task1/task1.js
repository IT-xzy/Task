function getcolor() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + "," + g + "," + b + ")";
}
function clear() {
    for(i = 0; i < 9 ; i++){
        document.getElementsByClassName("small")[i].style.backgroundColor="#ff7f02";
        document.getElementsByClassName("small")[i].innerHTML = "";
    }
}

var change = document.getElementsByClassName("small") ;
function randomNum() {
    clear();
    var old_arr = [];
    for( var i = 0 ;i < 9; i++ ){
        old_arr[i] = i;
    }
    var new_arr = [];
    for(var b = 9 ;b >0 ; b-- ){
        var z =Math.floor(Math.random()*b);
        new_arr.push(old_arr[z]);
        old_arr.splice(z,1);
    }
    change[new_arr[0]].style.backgroundColor=getcolor();
    change[new_arr[0]].innerHTML = "所有的";
    change[new_arr[1]].style.backgroundColor=getcolor();
    change[new_arr[1]].innerHTML = "作品都";
    change[new_arr[2]].style.backgroundColor=getcolor();
    change[new_arr[2]].innerHTML = "保持纯度";
}

var myvar;
function timestart() {
    clearInterval(myvar);
    myvar = setInterval("randomNum()",1000);
}
function pause() {
    clearInterval(myvar)
}
function timestop() {
    clearInterval(myvar);
    clear()
}
//从九个盒子中取出三个不同的盒子上色；
















