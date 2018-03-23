var win=sessionStorage.getItem("win");
var killnum=parseInt(sessionStorage.getItem("killnum"));
var peoplenum=parseInt(sessionStorage.getItem("peoplenum"));
var P=sessionStorage.getItem("P");
var K=sessionStorage.getItem("K");

if(win==0){
    $(".win").text('杀手胜利')
}
else {
    $(".win").text('平民胜利')
}
$("#killer").text(killnum);
$("#people").text(peoplenum);
if(K==null){
    $("#surviveK").text(killnum);
}else{
    $("#surviveK").text(K);
}
$("#surviveP").text(P);


var dieList = JSON.parse(sessionStorage.getItem("dieList"));
console.log(dieList);

var kong=[];
for(var i=0;i<dieList.length;i+=2){
    kong.push(dieList.slice(i,i+2));
}
console.log(kong);


var block=[];
var content;
for (var m = 0; m < kong.length; m++) {
    content ='<ul>'+'<li>'+ '<div class="time">' + "第"+(m+1)+"天" + '</div>' +
        '<p> ' + "晚上:" +kong[m][0]+"被杀手杀死" +'</p>'+'<p class="none">'+'</p>'+
        (kong[m][1]?'<p> ' + "白天:" +kong[m][1]+"被全民投票投死" +'</p>':'') +'</li>'+'</ul>';
    
    block.push(content);
}
document.getElementById("result").innerHTML=block.join('');


$(".more").click(function () {
    sessionStorage.clear();
    location.href="js2-1.html";
});
