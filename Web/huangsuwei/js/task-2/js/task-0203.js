
var a;
var b;
var c;
var d;
var e;
var player = [];

function printvalue (){
  a = document.getElementById('nn').value;
  if (a>=4&&a<=18){
      zero();
      judge();
  }
  else{
      alert("请输入正确的玩家人数")
  }
}
function zero() {
    for (d = 0; d < 18; d++) {
        player[d] = d;
        document.getElementsByClassName('player-status')[d].innerHTML = '未分配';
        document.getElementsByClassName('player-status')[d].style.color= "transparent";
    }
}
function judge() {

     switch (true) {
         case (a >= 4 && a <= 5):
             b = 1;
             c = a - b;
             break;
         case (a >= 6 && a <= 8):
             b = 2;
             c = a - b;
             break;
         case (a >= 9 && a <= 11):
             b = 3;
             c = a - b;
             break;
         case(a >= 12 && a <= 14) :
             b = 4;
             c = a - b;
             break;
         case (a >= 15 && a <= 18):
             b = 5;
             c = a - b;
             break;
     }

    document.getElementById('c-num').innerHTML = c;
    document.getElementById('k-num').innerHTML = b;

    for (d = 0; d < a; d++) {
        player[d] = d;
        document.getElementsByClassName('player-status')[d].innerHTML = d + 1 + '号是平民';
        document.getElementsByClassName('player-status')[d].style.color= 'blue';
    }
    var temp1= [];
    var temp2= [];
    for (e = 0; e < b; e++) {
        do {
            temp1[e] = Math.floor(Math.random() * a)
        } while (temp2.indexOf(temp1[e])>= 0);
        temp2.push(temp1[e]);
        document.getElementsByClassName('player-status')[temp1[e]].innerHTML = temp1[e]+1+ '号是杀手';
        document.getElementsByClassName('player-status')[temp1[e]].style.color= 'red';

       sessionStorage.setItem('stats',JSON.stringify(temp1));
    }

}

function deal() {
    if(a >= 4 && a <= 18){
        sessionStorage.setItem('all',a);
        window.location.href="./task-0203.html";
    }else {
        alert("请输入正确的玩家人数")
    }
}
var clo=document.getElementById("close");
clo.onclick=function () {
  var close = confirm("确定离开");
  if(close === true){
      location.href='./index.html';
      sessionStorage.clear();
  }
};