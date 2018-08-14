console.log("js文件");

var Num=sessionStorage.getItem("Num"); //上一页面输入人数
var playArr = JSON.parse(sessionStorage.getItem("playArr"));//上一页面身份数组

$('#back').on('click',function(){
    history.back();
} );//左上角返回按钮
$('#close').on('click',close);//右上角关闭按钮
function close(){
    var message = confirm("是否结束本轮游戏？");//是否确定
    if (message){
        location.replace('page2.html');//返回首页
    }
}

var playbox=$('.play-box');
for (var i=0;i<Num;i++){
    playbox.append(
        `<div class="player">
            <div class="play-t">`
            +playArr[i]+
            `</div>
            <div class="play-b">`
                +(i+1)+
            `号</div>
        </div>`);
}//生成角色模块

$('#playgame').on('click',function(){
    //重置杀人页面数据
    sessionStorage.removeItem("x");//重置游戏状态（判断杀人页面或投票页面）
    sessionStorage.removeItem("y");//重置游戏天数
    var deadArr = new Array; //死亡玩家数组
    sessionStorage.deadArr=JSON.stringify(deadArr);
    var noteArr = new Array; //法官笔记
    sessionStorage.noteArr=JSON.stringify(noteArr);
    location.assign('page6.html');
});
