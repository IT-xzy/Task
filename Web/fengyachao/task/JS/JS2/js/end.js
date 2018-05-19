//本次游戏杀手和平民各有多少人
var killNum = parseInt(sessionStorage.getItem('killNum'));
var peopleNum = parseInt(sessionStorage.getItem('peopleNum'));
$('#killNum').text(killNum);
$('#peopleNum').text(peopleNum);
//游戏结束时杀手和平民还剩下多少
var K = sessionStorage.getItem('K');
var P = sessionStorage.getItem('P');
if(K === null){
    $('#kill').text(killNum);
}else {
    $('#kill').text(K);
}
$('#people').text(P);

var dieList = JSON.parse(sessionStorage.getItem('dieList'));
console.log(dieList);
var kong=[];
for(var i=0;i<dieList.length;i+=2){
    kong.push(dieList.slice(i,i+2));
}
console.log(kong);

var block=[];
var content;
for(i=0;i<kong.length;i++){
    content = '<div class="record">'+'<p class="today">'+"第"+(i+1)+"天"+'</p>'+'<p class="log">'+"晚上: "+kong[i][0]+"被杀手杀死"+'</p>'+'<p class="log">'+"白天: "+kong[i][1]+"被投票投死"+'</p>'+'</div>';
    block.push(content);
}
document.getElementById('list').innerHTML=block.join('');


var v = sessionStorage.getItem('victory');
document.getElementById('victory').innerHTML = v;

function again() {
    sessionStorage.clear();
    window.location.href = "set.html";
}