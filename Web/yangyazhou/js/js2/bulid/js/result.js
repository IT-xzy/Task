 var log = console.log;
 //获取上一个页面的传过来的数据
 var gamerStr = sessionStorage.getItem('newGameMsg'),
     gamersMsg = JSON.parse(gamerStr),
     aliveKiller=gamersMsg.killData.alive,
     alivepop=gamersMsg.popData.alive,
     days=gamersMsg.days;
     
 //获取dom节点
 var killNum = document.getElementById('killerNum'), //剩余杀手数
     popNum = document.getElementById('popNum'),     //剩余玩家数
     result =document.getElementById('resultImg'),
     nightData=document.getElementsByClassName('night-data'),
     dayData=document.getElementsByClassName('day-data'),
     main=document.querySelector('main');
     //渲染页面
     killNum.innerHTML="杀  手"+aliveKiller+"人";
     popNum.innerHTML="平  民"+alivepop+"人";
     //通过判断玩家数目
     if(aliveKiller ==0){
         result.src ="img/popwin.png";
     }else {
        result.src ="img/killwin.png";
     }
    
     var domstr="";
    //  循环出所有的数据
     for(let i=0;i<days;i++){
        var night=gamersMsg.killed[i]?`<p class="game-details ">晚上：${gamersMsg.killed[i]}号被杀死了，真实身份是${gamersMsg.idArr[gamersMsg.killed[i]-1]}</p>`:"";
        var day  =gamersMsg.voted[i]?`<p class="game-details ">白天：${gamersMsg.voted[i]}号被投死了，真实身份是${gamersMsg.idArr[gamersMsg.voted[i]-1]}</p>`:"";
        var dayNum=night?`<h4 >第${toChinese(days)}天</h4>`:"";
        var div=document.createElement('div');
        div.setAttribute('class','game-step');
        div.innerHTML=`<div class="date">
                        ${dayNum}
                        ${night}
                        ${day}
                    </div>`;
        if(night){
            main.appendChild(div);
        }
     }


     //这个函数是用来通过天数转化为相应的中文
    function toChinese(value) {
        var arr = ["", "一", "二", "三", "四", "五", "六", "七", "八", "九", '十'];
        if (value < 10) {
            return arr[value];
        } else if (value === 10) {
            return '十';
        } else if (value < 20 && value > 10) {
            return arr[10] + arr[(value - 10)];
        }
    }


















 // 跳转页面
 var again = document.getElementById('again');
 again.onclick = function () {
     window.location.href = "headerPage.html";
 };