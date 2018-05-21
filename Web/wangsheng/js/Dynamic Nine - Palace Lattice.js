var boxs=document.getElementsByClassName("box");
var timer;
function getRandom(minNum,maxNum,count) {
    var numArr=[],num;
    for(var i=0;i<count;i++) {
        do {
            num=Math.floor(Math.random()*maxNum);
        }while(numArr.indexOf(num)>-1);
        numArr.push(num);
    }
    return numArr;
}


function renderColor(indexArr) {
    for (var i = 0; i < boxs.length; i++) {
        boxs[i].style.backgroundColor = "orange"
    }
    for (var i = 0; i < indexArr.length; i++) {
        boxs[indexArr[i]].style.backgroundColor = (function renderColor(indexArr) {
            return 'rgb(' + parseInt(Math.random() * 255) + ',' + parseInt(Math.random() * 255) + ',' + parseInt(Math.random() * 255) + ')'
        })();
    }
}

function start() {
    var randoms = getRandom(0, boxs.length, 3);

    renderColor(randoms);
    clearInterval(timer);
    timer = setInterval(function () {
        var randoms = getRandom(0, boxs.length, 3);
        renderColor(randoms);
    }, 1000);
}

function end() {
    clearInterval(timer);
    for (var i = 0; i < boxs.length; i++) {
        boxs[i].style.backgroundColor = "orange";
    }
}