var get = sessionStorage.arr;
var arr = JSON.parse(get);
var Oplayer = JSON.parse(sessionStorage.player);
var newUl = document.getElementsByTagName("ul")[0];
var ul_lis = newUl.getElementsByTagName('li');
function insert(i) {
    var newLi = document.createElement("li");
    var newstrong = document.createElement("strong");
    var newspan = document.createElement("span");
    var newi = document.createElement("i");
    newstrong.innerHTML = arr[i];
    newspan.innerHTML = (i + 1) + "号";
    newLi.appendChild(newstrong);
    newLi.appendChild(newspan);
    newLi.appendChild(newspan);
    newLi.appendChild(newi);
    newUl.appendChild(newLi);
    li = document.getElementsByTagName("li");
}
newUl.style.marginTop = "-60px";
for (var i = 0; i < arr.length; i++) {
    insert(i);
}
for (var i = 0; i < ul_lis.length; i++) {
    if (Oplayer[i].state == "die") {
        ul_lis[i].style.cssText = "border-color: #999; background: #999";
    }
}