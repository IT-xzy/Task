$(document).ready(function () {
var Arr=JSON.parse(sessionStorage.getItem('Arr')),//将值转换为数组
    role=$(".card-wrap"),//获取卡片的节点
    seeRole=$(".see-role"),//获取按钮的节点
    roleInformaion=$(".role"),//获取卡片身份的节点
    circle=$(".circle"),//获取头部序号的节点
    $return=$('header').find('a').eq(0),//获取后退按钮节点
    $close=$('header').find('a').eq(1),//获取关闭按钮节点
    $text=$('.role-information').eq(0),//获取文本节点
    $seeRole=$('.see-role').eq(0)//获取底部按钮节点
    show=new Show(),//实例化一个构造函数
    num=1;

//创建构造函数，里面包含一个属性和一个方法，每次调用方法改变属性的值
function Show() {
}
Show.prototype.statu='show';
Show.prototype.ChangeStatu=function () {
    this.statu=(this.statu==='show')?'hide':'show'
};
function ChangeStatu() {
    if(num===Arr.length+1){
        window.location.href = "judge-view.html"
    }
    //状态为h时显示的页面
    else if(show.statu==='hide'){
        role[0].style.display="none";
        role[1].style.display='block'
        circle[1].innerHTML=num;
        roleInformaion[0].innerHTML="身份："+Arr[num-1];
        if(Arr[num-1]==='杀手') {
            $text.text('想办法杀掉所有平民，同时还要注意不要暴露身份哦');
        }
        else {
            $text.text('想办法找出所有杀手，同时注意不要被误认为杀手');
        }
        if(num<Arr.length) {
            seeRole[0].innerHTML = "隐藏并传递给" + (num+1) + "号";
        }
        else {
            seeRole[0].innerHTML = "查看法官日记";
        }
        num++;
    }
    //状态为s时显示的页面
    else {
        role[1].style.display="none";
        role[0].style.display='block'
        circle[0].innerHTML=num;
        seeRole[0].innerHTML="查看"+num+"号身份";
    }
}

//初始状态
role[0].style.display="block";
seeRole[0].innerHTML="查看"+num+"号身份";
circle[0].innerHTML=1;

//点击头部返回键，撤退，点击关闭键，返回首页
$return.on('click',function () {
    window.location.href='setting.html';
    sessionStorage.clear('Arr');
});

$close.on('click',function () {
    var $choose=confirm('确定要结束本轮游戏么');
    if($choose===true) {
        window.location.href = 'game-version.html'
    }
});
//点击底部按钮触发事件
$seeRole.on('click',function () {
    show.ChangeStatu();
    ChangeStatu();

});
})