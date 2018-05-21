
var threeColor = null;
//随机颜色方法
function getRandomColor() {
    //随机三种颜色
    var randomColor1 = '#' + (Math.floor(Math.random() * 16777215 + 0.5).toString(16)).slice(-6);
    var randomColor2 = '#' + (Math.floor(Math.random() * 16777215 + 0.5).toString(16)).slice(-6);
    var randomColor3 = '#' + (Math.floor(Math.random() * 16777215 + 0.5).toString(16)).slice(-6);
    //1-9随机3个数字
    var randomNum = [];
    for (var i = 1; i < 10; i++) {
        randomNum.push(i);
    }
    randomNum.sort(function () {
        return 0.5 - Math.random()
    });
    randomNum.length = 9;
    // console.log(randomNum);
    var p1 = "p" + randomNum[0];
    var p2 = "p" + randomNum[1];
    var p3 = "p" + randomNum[2];
    var p4 = "p" + randomNum[3];
    var p5 = "p" + randomNum[4];
    var p6 = "p" + randomNum[5];
    var p7 = "p" + randomNum[6];
    var p8 = "p" + randomNum[7];
    var p9 = "p" + randomNum[8];
    //数组前三个为随机的颜色
    document.getElementById(p1).style.backgroundColor = randomColor1;
    document.getElementById(p2).style.backgroundColor = randomColor2;
    document.getElementById(p3).style.backgroundColor = randomColor3;
    document.getElementById(p4).style.backgroundColor = "orange";
    document.getElementById(p5).style.backgroundColor = "orange";
    document.getElementById(p6).style.backgroundColor = "orange";
    document.getElementById(p7).style.backgroundColor = "orange";
    document.getElementById(p8).style.backgroundColor = "orange";
    document.getElementById(p9).style.backgroundColor = "orange";
}
//点击后全部变为橙色
function orangeColor(){
    window.clearInterval(threeColor);
    document.getElementById("p1").style.backgroundColor= "orange";
    document.getElementById("p2").style.backgroundColor= "orange";
    document.getElementById("p3").style.backgroundColor= "orange";
    document.getElementById("p4").style.backgroundColor= "orange";
    document.getElementById("p5").style.backgroundColor= "orange";
    document.getElementById("p6").style.backgroundColor= "orange";
    document.getElementById("p7").style.backgroundColor= "orange";
    document.getElementById("p8").style.backgroundColor= "orange";
    document.getElementById("p9").style.backgroundColor= "orange";
}