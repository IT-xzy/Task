var back = document.querySelector('.back');
var log = console.log;

//返回上一页
back.addEventListener('click', function () {
    window.location.href = 'headerPage.html';
}, false);

//获取input中的值
var playNum = document.getElementById('player'),
    killerNum = document.getElementById('killsNum'),
    popNum = document.getElementById('popsNum'),
    goPage=document.getElementById('go'),
    playersArr = [],
    random = [],
    msg={},
    killers,
    pops;
    playNum.value="";
playNum.addEventListener('change', function () {
   
}, false);

playNum.onkeyup = function () {
    this.value = this.value.replace(/\D/, '');
    switch (true) {
        case this.value <= 5 && this.value >= 4:
            killerNum.innerHTML = 1;
            popNum.innerHTML = this.value - 1;
            break;
        case this.value >= 6 && this.value <= 8:
            killerNum.innerHTML = 2;
            popNum.innerHTML = this.value - 2;
            break;
        case this.value >= 9 && this.value <= 11:
            killerNum.innerHTML = 3;
            popNum.innerHTML = this.value - 3;
            break;
        case this.value >= 12 && this.value <= 15:
            killerNum.innerHTML = 4;
            popNum.innerHTML = this.value - 4;
            break;
        case this.value >= 16 && this.value <= 18:
            killerNum.innerHTML = 5;
            popNum.innerHTML = this.value - 5;
            break;
    }
};

function bulidArr(kills, pops) {
    var len        = kills + pops,
        fillArr    = new Array(len),
        randomArr  = [];
    fillArr.fill('杀手', 0, kills);
    fillArr.fill('平民', kills, len);
    while (fillArr.length) {
        var index = ~~(Math.random() * fillArr.length);
        randomArr.push(fillArr[index]);
        fillArr.splice(index, 1);
    }
    return randomArr;
}
goPage.onclick=function(){
     //人数不在4-18以内的就会弹出框报错
     if (this.value < 4 || this.value > 18) {
        var r = confirm("请输入正确的玩家人数!");
        killerNum.innerText = "";
        popNum.innerText = "";
        playNum.value = "";
    } else {
        //创建随机数组并且使用json在页面间传值
        killers = Number(killerNum.innerText);
        pops = Number(popNum.innerText);
        random=bulidArr(killers, pops);
        msg.killers =killers;
        msg.pops=pops;
        msg.random=random;
        sessionStorage.setItem('playersMsg',JSON.stringify(msg));
    }
//    if(msg.pops){
//        window.location.href='show.html';
//    }else{
//        alert('请输入玩家数目');
//    }
};