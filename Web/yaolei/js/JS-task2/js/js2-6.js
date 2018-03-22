var player = JSON.parse(localStorage.getItem('object'));
console.log(player);
//获取URL数据
var url = location.search,
    str = url.substr(1);
var killMan = document.getElementById('killMan');
var trueIdentity = document.getElementById('trueIdentity');
var deadSpeak = document.getElementById('deadSpeak');
var playerSpeak = document.getElementById('playerSpeak');
var vote = document.getElementById('vote');
var day = Number(sessionStorage.getItem('day'));

var x = '<div class="day2"></div>';
var r =document.getElementsByClassName('day2');
$('.day1').before(x);
r[0].innerHTML='第' +day + '天';
var step = 0;
//每天进行任务的下拉特效
function days(){
    for(var i = 1; i < day; i++){
        var kName = "" , kNum = "" , vName = "" , vNum = "";
        for(var j = 0; j < player.length; j++){
            if(player[j].deathDay === i){
                if(player[j].dead === "kill"){
                    kNum = j+1;
                    kName = player[j].name;
                }else{
                    vNum = j+1;
                    vName = player[j].name;
                }
            }
        }
        if(kName === ""){
            $("#main").before(
                "<div class=''>"+
                "<p class=day>第"+i+"天</p>"+
                "<div class=process>"+
                "<div class=sjx><div class='moon'></div><div class='sun'></div></div>"+
                "<ul class=list>"+
                "<li class='selection1 selection-last'>"+
                "<div class='' ></div>杀手杀人</li>"+
                "<h3 class=''>杀手未杀人。</h3>"+
                "<li class='selection1 selection-last'>"+
                "<div class=''></div>亡灵发表遗言</li>"+
                "<li class='selection1 selection-last'>"+
                "<div class=''></div>玩家依次发言</li>"+
                "<li class='selection1 selection-last'>"+
                "<div class=''></div>全民投票</li>"+
                "<h3 class=''>"+vNum+"号被投票投死，他的身份是"+vName+"。"+
                "</h3>"+
                "</ul>"+
                "</div>"+
                "</div>"
            )
        }else{
            $("#main").before(
                "<div>"+
                "<p class=day>第"+i+"天</p>"+
                "<div class=process>"+
                "<div class=sjx><div class='moon'></div><div class='sun'></div> </div>"+
                "<ul class=list>"+
                "<li class='selection1 selection-last'>"+
                "<div class=''></div>杀手杀人</li>"+
                "<h3 class=''>"+kNum+"号被杀,他的身份是"+kName+"。</h3>"+
                "<li class='selection1 selection-last'>"+
                "<div class=''></div>亡灵发表遗言</li>"+
                "<li class='selection1 selection-last'>"+
                "<div class=''></div>玩家依次发言</li>"+
                "<li class='selection1 selection-last'>"+
                "<div class=''></div>全民投票</li>"+
                "<h3 class=''>"+vNum+"号被投票投死，他的身份是"+vName+"。</h3>"+
                "</ul>"+
                "</div>"+
                "</div>"
            )
        }
    }
}days();

$('.process').hide();
$(".day").click(function(){
    $(this).next('.process').slideToggle(500);
});
$(".day2").click(function(){
    $(this).next('.day1').slideToggle(500);
});
if(str === 'vote' || str === 'noKill'){
    killMan.style.backgroundColor = '#8ab09a';
}
$('#killMan').click(function () {
    if(step === 0 && str !== 'vote' && str !== 'noKill'){
        window.location.href = 'js2-7.html?kill';
        step = 1;
    }else if(step === 1 ){
        alert("请进行下一步");
    }
    else {
        alert("请进行后续操作");
    }
});
for(var i = 0 ; i < player.length ; i ++) {
    if (str === 'vote' && player[i].deathDay === day) {
        trueIdentity.style.display = 'flex';
        trueIdentity.innerHTML = (player[i].num + 1)+'号被杀手杀死，真实身份是' + player[i].name;
    }else if(str === 'noKill'){
        trueIdentity.style.display = 'flex';
        trueIdentity.innerHTML = '杀手信佛吃斋';
    }
}
$('#deadSpeak').click(function () {
    if(step === 0 && str === 'vote'){
        deadSpeak.style.backgroundColor = '#8ab09a';
        alert('请亡灵发言');
        step = 2;
    }else if(step === 0 && str === 'noKill'){
        deadSpeak.style.backgroundColor = '#8ab09a';
        alert('请亡灵发言');
        step = 2;
    }else if(step === 0){
        alert('整天就知道杀人你妈妈知道么')
    }else if(step > 1){
        alert("安息吧")
    }
});
$('#playerSpeak').click(function () {
    if (step === 2) {
        playerSpeak.style.backgroundColor = '#8ab09a';
        alert('群众发言');
        step = 3;
    }else if(step === 2 && str === 'noKill'){
        playerSpeak.style.backgroundColor = '#8ab09a';
        alert('请群众发言');
        step = 3;
    } else {
        alert('请按顺序进行')
    }
});
$('#vote').click(function () {
    if(step ===3){
        window.location.href = 'js2-7.html?vote';
        sessionStorage.setItem('day' ,day);
    }else{
        alert('请按顺序进行')
    }
});
$('.back').click(function () {
    window.location.href = 'js2.html'
});






