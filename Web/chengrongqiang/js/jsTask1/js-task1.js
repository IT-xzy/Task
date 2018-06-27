var btn1 = document.getElementById('btn1');
var btn2 = document.getElementById('btn2');
var div = document.getElementsByClassName('class1');
var c2 = document.getElementsByClassName('c2');
console.log(c2[0])
console.log(typeof(div));
console.log(typeof(btn2));
console.log(div[1])
var set;
btn1.onclick = function() {
    clearInterval(set);
    set = setInterval(select, 1000);
    btn1.style.backgroundColor = "#ff7f02";
    btn2.style.backgroundColor = "#fff";
}
btn2.onclick = function() {
    colorRest();
    clearInterval(set);
    btn2.style.backgroundColor = "#ff7f02";
    btn1.style.backgroundColor = "#fff";
}

function select() {
    colorRest();
    var box = [];
    var N = [];
    var j;
    var i;
    var x = 3;
    //    var x = 8;
    //Method(1);	   
    // for(i=0;i<3;i++) {
    // 	M = Math.floor(Math.random()*9);
    // 	N[i] = M
    // }
    // console.log(N)
    // if(N[0]!=N[1]&&N[1]!=N[2]&&N[0]!=N[2]) {
    // 	for (j=0;j<x;j++){
    // 		k = N[j];
    // 		box[j]=div[k];
    // 		box[j].style.backgroundColor = colors();
    // 	}	
    // }else {
    // 	select()
    // }
    //Method(2);
    for (i = 0; i < div.length; i++) {
        box[i] = i;
    }
    for (j = 0; j < x; j++) {
        do {
            M = Math.floor(Math.random() * 9)
        } while (box[M] == div.length
            //    ||M===4
        );
        box[M] = div.length;
        N[j] = div[M]
        N[j].style.backgroundColor = colors();
    }
    console.log(N)
}
// (for colorRest)
function colorRest() {
    for (i = 0; i < div.length; i++) {
        div[i].style.backgroundColor = '#ff7f02'
    }
}
// (for rgb)
function colors() {
    r = Math.floor(Math.random() * 255);
    g = Math.floor(Math.random() * 255);
    b = Math.floor(Math.random() * 255);
    color = "rgb(" + r + ',' + g + ',' + b + ")";
    return color
}
// (for #16)
// function colors() {
// 	color = "#"+("00000"+((Math.random()*16777215+0.5)>>0).toString(16)).slice(-6);		
// 	return color
// }
var reset = document.getElementById("reset")
reset.onclick = function() {
    colorRest();
    clearInterval(set);
    btn1.style.backgroundColor = "#fff";
    btn2.style.backgroundColor = "#fff";
}