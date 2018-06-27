 var log = console.log;
 //获取上一个页面的传过来的数据
 var gameMsgstr = sessionStorage.getItem('allMsg');
 var initialMsg = JSON.parse(gameMsgstr);
 log(initialMsg);    
 let {result,dayNum,players,state} =initialMsg;
log(result,dayNum,players,state);
if(state =='vote'){
    dayNum--;
}
let img=$('#resultImg');
//显示剩余玩家
$('#killerNum').text(`杀 手${initialMsg.killersNum}人`);
$('#popNum').text(`平 民${initialMsg.popsNum}人`);
//判断什么结果
log(result);
log(img)
if(result === 'popWin'){
    img.prop('src','img/popwin.png');
}else if(result === 'killWin'){
    img.prop('src','img/killwin.png');
}else{
    img.prop('src','img/gameover.png');
}
let str='';
for( let i=0; i<dayNum;i++){
       let night=`<p class="game-details ">晚上：</p>`;
        let day =`<p class="game-details ">白天：</p>`;
    for(let j=0;j<players.length;j++){
     
        if(players[j].deadDay ==[i+1] && players[j].deadReason =='killed'){
            night=`
            <p class="game-details ">晚上：${players[j].index+1}号被杀手杀死，${players[j].index+1}号是水民</p>
           `
        }
        if(players[j].deadDay ==[i+1] && players[j].deadReason =='voted'){
            day=`
            <p class="game-details ">白天：${players[j].index+1}号被投死，${players[j].index+1}号是${players[j].id}</p>
           `
        }
    
    }
        str +=`<div class="game-step">
        <div class="date">
            <h4 >第${toChinese(i+1)}天</h4>
            ${night}
            ${day}
        </div>
    </div>`
}

$('main').append(str);



$('#again').on('click',function(){
    $(location).attr('href','headerPage.html');
})











 
     //这个函数是用来通过天数转化为相应的中文
    function toChinese(value) {
        var arr = ["", "一", "二", "三", "四", "五", "六", "七", "八", "九", '十'];
        if (value < 10) {
            return arr[value];
        } else if (value === 10) {
            return '十';
        } else if (value < 20 && value > 10) {
            return arr[10] + arr[(value - 10)];
        }///
    }








