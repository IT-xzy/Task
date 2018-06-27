var log = console.log;

//头部信息
$('#backBtn').on('click',function(){
    $(location).attr('href','allot.html');    
});
$('.close-icon').on('click',function(){
    var r = confirm("您确定离开游戏吗？");
    if (r == true) {
        window.location.href = "headerPage.html";
    }
           
})


$(function(){
    var gameMsgstr=sessionStorage.getItem('allMsg');
    var gameMsg=JSON.parse(gameMsgstr);
    var stepNum=$('#playerNum'),     //数字编号
        showImg=$('.show-img'),     //翻盘图片
        hideImg=$('.hide-img'),     //身份图片
        skipBtn=$('#checkBtn'),     //跳转按钮
        playId=$('#playId'),       //玩家身份
        index=1;                                   
    //初始化赋值数字为1   
    stepNum.text(index);
    skipBtn.text('查看1号身份');
    //给按钮添加点击事件
    skipBtn.on('click',function(){
        var players=gameMsg.players;
        //通过toggle方法操作图片显示隐藏
        showImg.toggle();
        hideImg.toggle();
        //判断是否是整数
        if(index%1){
            index +=0.5;
            if(index ===players.length+1){
                $(location).attr('href','judeState.html');                           
                return ;
            }
            stepNum.text(index);
            $(this).text('查看'+ (index)+'号身份');            
        }else{
            playId.text(players[index-1].id);
            $(this).text('隐藏并传递给'+ (index+1)+'号');
            index +=0.5;
            if(players.length+0.5 ===index){
                $(this).text('法官查看'); 
            }
        }
    });
});























