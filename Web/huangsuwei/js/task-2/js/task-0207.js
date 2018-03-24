$(document).ready(function () {
    var civ=sessionStorage.getItem('all');
    var step=sessionStorage.getItem('step');
    var allPlayers = JSON.parse(sessionStorage.getItem('allP'));
    var container=[];
    console.log(typeof dieNum);
    var identity;
    var i;
    for (i = 0; i <civ; i++) {
        identity = '<div class="player-box1">'+ '<div class="player-status">' + allPlayers [i].status+
            '</div>' +'<div class="player-number"> ' + allPlayers [i].number + "号" + '</div>'+'</div>' ;
        container.push(identity);
    }
    var lastSelect;
    $('#diary').html(container.join(''));
    if ( step === 'killer'){
        $('#game-title').text('杀手杀人');
        $('#start').text('杀死');
    }
    else {
        $('#game-title').text('全民投票');
        $('#start').text('投死');
    }
    var allPeople=document.getElementsByClassName('player-box1');
    for( var e= 0; e <civ; e++){
        if (allPlayers[e].state === 0){
            $(allPeople[e]).css('backgroundColor', '#ff6c5c');
        }
    }
    for( j= 0; j <civ; j++){
        allPeople[j].index = j;

        allPeople[j].onclick = function () {
            var died = this.index;
            if (died !== null){
                sessionStorage.setItem('deadNums',JSON.stringify(died));
            }
            if(step==='killer'){
                if (allPlayers[this.index].status === '杀手'){
                    alert('请杀平民');
                }else {
                    if (allPlayers[this.index].state===0){
                       alert('请不要鞭尸');
                    }else {
                        if (lastSelect !== undefined) {
                            $(allPeople[lastSelect]).css('backgroundColor', '#f5c97b');
                            allPlayers[lastSelect].state = 1;
                        }
                        $(allPeople[this.index]).css('backgroundColor','#ff6c5c');
                        allPlayers[this.index].state = 0;
                        console.log(allPlayers[this.index].state);
                        lastSelect = this.index;
                        //这三项是用来判断: 如果玩家改变杀死人时,就将之前死亡的玩家的背景颜色还原.
                    }
                }

            } else {
                if (allPlayers[this.index].state === 0) {
                    alert('请不要鞭尸')
                } else {
                    if (lastSelect !== undefined) {
                        $(allPeople[lastSelect]).css('backgroundColor', '#f5c97b');
                        allPlayers[lastSelect].state = 1;
                    }
                    $(allPeople[this.index]).css('backgroundColor', '#ff6c5c');
                    allPlayers[this.index].state = 0;
                    lastSelect = this.index;
                }
            }
        }
    }

    $('#start').click(function () {
        sessionStorage.setItem('allP',JSON.stringify(allPlayers));
        var q=sessionStorage.getItem('deadNums');
        console.log(q);
        var w=JSON.parse(sessionStorage.getItem('dieNum'));
        var dieNum;
        if(w === null){
            dieNum=new Array(0);
            if(q!== null){
                dieNum.push(q);
            }
            sessionStorage.setItem('dieNum',JSON.stringify(dieNum));
        }else {
            dieNum=w;
            if(q!== null && dieNum.indexOf(q)<0){
                dieNum.push(q);
            }
            sessionStorage.setItem('dieNum',JSON.stringify(dieNum));
        }
        var knumber=0;
        var pnumber=0;
        var result;
        for (var n=0;n<civ;n++) {
            if (allPlayers[n].state === 1) {
                if (allPlayers[n].status === '杀手') {
                    knumber++;
                } else {
                    pnumber++;
                }
            }
        }
        console.log(knumber);
        console.log(pnumber);
        if (step==='killer'){
            sessionStorage.setItem('step','dead');
        }else {
            if(step==='vote'){
                sessionStorage.setItem('step','none');
            }
        }
        if(lastSelect===undefined){
            alert('必须杀一个再走')
        }else {

            if (knumber >= pnumber) {
                result = '杀手胜利';
                alert(result);
                sessionStorage.setItem('result', result);
                window.location.href = './task-1302.html';
            }
            else {
                if (knumber === 0) {
                    result = '平民胜利';
                    alert(result);
                    sessionStorage.setItem('result', result);
                    window.location.href = './task-1302.html';
                }
                else {
                    window.location.href = './task-0205.html';
                }
            }
        }
    });
});