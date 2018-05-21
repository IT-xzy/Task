/**
 * Created by Administrator on 2017/11/21.
 */


function turn() {
    var a=document.getElementById("num").value;
    if(3<a&&a<19){
        location.href = "js-3.1.html";}
   else {
        var b=document.getElementById("box1");
        box1.style.visibility="visible";
    }
}
function my1() {
    var a=document.getElementById("num").value;
    if(3<a&&a<19){
        var s=Math.floor(a/4);
        var t=[a]-[s];
        document.getElementById("kinum").innerHTML=s;
        document.getElementById("sinum").innerHTML=t;
        
    }
    else {
        var b=document.getElementById("box1");
        box1.style.visibility="visible";
    }

    var ki="杀手";
    var arr = new Array(ki,ki,ki,ki);

    var arrki=arr.slice(0,s);

    var si="水民";
    var arr1=new Array(si,si,si,si,si,si,si,si,si,si,si,si,si,si,si,si,si);

    arrsi=arr1.slice(0,t);

    arral=arrki.concat(arrsi);

    Array.prototype.shuffle = function() {
        var input = this;
        for (var i = input.length-1; i >=0; i--) {
            var randomIndex = Math.floor(Math.random()*(i+1));
            var itemAtIndex = input[randomIndex];
            input[randomIndex] = input[i];
            input[i] = itemAtIndex;
        }
        return input;
    };
    var l=arral.shuffle();


    var all=[];
    for (i=0;i<a;i++){
     var ci=i+1;
        all.push(+ci+'号是'+l[i]);
 //document.getElementById("som").innerHTML=all;
        var str = JSON.stringify(all);
        var strl=JSON.stringify(l);

        sessionStorage.l=strl;
        sessionStorage.all = str;
        sessionStorage.setItem('knu',s);
        sessionStorage.setItem('snu',t);
        sessionStorage.setItem('knum',s);
        sessionStorage.setItem('snum',t);
}
}

function my() {
    var t=setTimeout(function () {
        my1()
    },1800);
}










