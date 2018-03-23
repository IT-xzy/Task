// var array = new Array("aaaa", "bbbb", "cccc", "eeee");
function init(){
    createNewNode();
}
window.onload = init;
function createNewNode(){
    for(var i=0; i<5; i++){
        var newDivNode = document.createElement("div");
        document.body.appendChild(newDivNode);

        newDivNode.setAttribute("id", "newId"+i);

        var idd = newDivNode.getAttribute("id");

        newDivNode.style.width = "50px";
        newDivNode.style.height = "50px";
        newDivNode.style.background = "rgba(150,50,32,1)";
        newDivNode.style.float = "left";
        newDivNode.style.position = "absolute";
        newDivNode.style.left = (60 * i) + "px";
        newDivNode.style.color = "white";

        newDivNode.addEventListener("click", function(){

        }, false);
    }
}