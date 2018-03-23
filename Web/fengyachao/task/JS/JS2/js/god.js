
var k = sessionStorage.getItem('killNum');
var p = sessionStorage.getItem('peopleNum');
console.log(k);
console.log(p);

s = sessionStorage.totalArr;
totalArr = JSON.parse(s);
console.log(totalArr);
var main = document.getElementById("main");
var n = 0;

function init() {
    createNewNode();
}
window.onload = init;
function createNewNode() {
    for(i=0; i<totalArr.length; i++){
        var newDivNode = document.createElement("div");
        main.appendChild(newDivNode);
        newDivNode.setAttribute("id", "newId"+i);
        var idd = newDivNode.getAttribute("id");

        newDivNode.style.width = "23.3%";
        newDivNode.style.border = "3px solid white";
        newDivNode.style.float = "left";
        newDivNode.style.margin = "0 5% 8%";
        newDivNode.style.boxSizing = "border-box";
        newDivNode.style.fontSize = "1.2rem";
        newDivNode.style.textAlign = "center";

        var newId = document.getElementById("newId"+i);
        var a = document.createElement("div");
        newId.appendChild(a);
        a.setAttribute("id", "casting");
        var ibb = a.getAttribute("id");
        a.style.padding = "23% 20%";
        a.style.background = "#f5c97b";

        var b = document.createElement("div");
        newId.appendChild(b);
        b.setAttribute("id", "num");
        var icc = b.getAttribute("id");
        b.style.padding = "0 20%";
        b.style.background = "#83b09a";

        // for(k=0; k<totalArr.length; k++) {
        //     var casting = document.getElementById("casting");
        //     casting.innerHTML = totalArr[n];
        //
        //     var num = document.getElementById("num");
        //     num.innerHTML = totalArr[n];
        // }
        // n++;
    }
}