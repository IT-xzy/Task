
var k = sessionStorage.getItem('killNum');
var p = sessionStorage.getItem('peopleNum');

s = sessionStorage.totalArr;
totalArr = JSON.parse(s);
console.log(totalArr);

var checkNum = 1;
var n = 0;

check();
function check() {
    if (checkNum >= (2 * totalArr.length + 1)){
        location.href="god.html";
    }else {
        if (checkNum %2 !== 0){
            reveal();
        }else {
            hide();
        }
    }
    checkNum ++;
    console.log(checkNum);
}
function reveal() {
    document.getElementById('place').innerHTML = n+1;
    document.getElementById('check').innerHTML = "查看" + (n+1) + "号身份";
    document.getElementById("king").style.display = "block";
    document.getElementById("board").style.display = "none";
    document.getElementById("status").style.display = "none";
    n ++;
    console.log(totalArr.length);
}

function hide() {
    if (n === totalArr.length){
        document.getElementById('check').innerHTML = "查看法官日志";
    }else {
        document.getElementById('check').innerHTML = "隐藏并传递给" + (n+1) + "号";
    }
    document.getElementById("king").style.display = "none";
    document.getElementById("board").style.display = "block";
    document.getElementById("status").style.display = "block";
    document.getElementById("status").innerHTML = "身份: " + totalArr[n-1];
}
