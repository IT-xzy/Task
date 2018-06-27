//提取数据
killernum=sessionStorage.killernum;
personnum=sessionStorage.personnum;
objrole=JSON.parse(sessionStorage.objrole);
bekilled=JSON.parse(sessionStorage.bekilled);
bevoted=JSON.parse(sessionStorage.bevoted);
var daynum=Math.ceil(objrole.length-killernum-personnum)/2;
var votenum=Math.floor(objrole.length-killernum-personnum)/2;


var strHtml=[];
function render(){
    strHtml.push(
        '<div class="days"></div>'+
        '<div class="night"></div>'+
        '<div class="daytime"></div>'
    );
    $('.dailyrecord').html(strHtml.join(''));
}
//生成对应天数的div标签
for(i=0;i<daynum;i++){
    render();
    for(j=0;j<daynum;j++){
        $(".days").eq(j).text("第"+(j+1)+"天");
        $(".night").eq(j).text(bekilled[j]);
    }
    for(k=0;k<votenum;k++){
        $(".daytime").eq(k).text(bevoted[k]);
    }
}
//根据杀手剩余人数，判断杀手和平民哪一方胜利
if(killernum==0){
    $(".winner").text("平民胜利");
    $(".greet").text("本次游戏中共抓住杀手"+Math.ceil(objrole.length/5)+"人，"+"共经历了"+daynum+"个白天，最终取得了胜利！");
    $(".survive").text("杀手"+killernum+"人"+" "+"平民"+personnum+"人");
}
else{
    $(".winner").text("杀手胜利");
    $(".greet").text("太棒了！你知道吗？在杀人游戏中，只有20%的杀手取得游戏最终的胜利哦");
    $(".survive").text("杀手"+killernum+"人"+" "+"平民"+personnum+"人");
}
//点击结束游戏按钮，回到设置页面，储存数据清零。
$(".btn-left").on('click',function(){
    sessionStorage.clear();
    window.location.href="setup.html";
});