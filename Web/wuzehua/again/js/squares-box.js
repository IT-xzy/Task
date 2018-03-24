var box=document.getElementsByClassName('box');
var start=document.getElementById('start');
var end=document.getElementById('end');
var time;
var randomNumOri = [];
for(var i=0;i<div.length;i++){
    randomNumOri[i]=i;
}
start.onclick=function () {
    var colors=['black','white','dust'];
    start.style.background='#FFA500';
    start.style.color='#ffffff';
    end.style.background='#ffffff';
    end.style.color='#FFA500';
    clearInterval(time);
    time = setInterval(function() {
        var randomNum = randomNumOri.sort(function() { return 0.5 - Math.random() });
        for(var i = 0; i <box.length; i++) {
            box[i].style.background = '#FFA500';
        }
        for(var j = 0; j < 3; j++) {
            box[randomNum[j]].style.background = colors[j];
        }
    }, 500)
}
end.onclick=function () {
    start.style.background = '#ffffff';
    start.style.color = '#FFA500';
    end.style.background = '#FFA500';
    end.style.color = '#ffffff';
    clearInterval(timer);
    for(var i = 0; i <box.length; i++) {
        box[i].style.background = '#FFA500';
    }
}