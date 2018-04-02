//获取杀手，平民，总身份的数组
card=JSON.parse(sessionStorage.getItem('card'));
kill=JSON.parse(sessionStorage.getItem('kill'));
people=JSON.parse(sessionStorage.getItem('people'));
var card2=kill.concat(people);//相加当前所生平民，杀手数组
console.log(card2);
//获取相关节点
var days=document.getElementsByClassName('days');
var killer=document.getElementsByClassName('kill');
var words=document.getElementsByClassName('words');
var order=document.getElementsByClassName('order');
var vote=document.getElementsByClassName('vote');
var down=Math.floor((card.length-card2.length)/2);//死亡人数的一半并向下取整
var extra=(card.length-card2.length)%2;//死亡人数对2取余
console.log(extra);
//封装了一个用js获取css属性的函数
function getStyle(obj,attr){
    if(obj.currentStyle){
        return obj.currentStyle[attr];

    }else
    {
        return getComputedStyle(obj, false)[attr];
    }
}
console.log(getStyle(killer[0],'backgroundColor'));
function load() {
    //克隆天数
    for(var i=0;i<down;i++){
        var cloneItem=days[i].cloneNode(true);
        days[0].parentNode.appendChild(cloneItem);
        cloneItem.getElementsByClassName('num')[0].innerHTML='第'+(i+2)+'天';
        //根据i遍历渲染使用过后的按钮
        killer[i].style.backgroundColor='orange';
        words[i].style.backgroundColor='orange';
        order[i].style.backgroundColor='orange';
        vote[i].style.backgroundColor='orange';
    }
    //判断杀手按钮的颜色
    for (var j = 0; j <=down; j++) {
        if(extra!==0){
            killer[j].style.backgroundColor='orange';
            console.log(killer[j].style.backgroundColor);
        }
        //用变量代替当前被点击的按钮
        var _this1=killer[j];
        var _this2=words[j];
        var _this3=order[j];
//开始各种判断了
        killer[j].onclick=function () {
            if(this.style.backgroundColor=='orange'){
                alert('请按顺序进行游戏');
            }else{
                window.location.href='process.html';
            }
        };
        words[j].onclick=function () {
            console.log(getStyle(_this1,'backgroundColor'));
            console.log(getStyle(_this1,'backgroundColor')=='rgb(41, 189, 224)');
            if(getStyle(_this1,'backgroundColor')=='rgb(41, 189, 224)'||this.style.backgroundColor=='orange'){
                alert('请按顺序进行游戏');
            }else{
                alert('请亡灵发表遗言');
                this.style.backgroundColor='orange';
            }
        };
        order[j].onclick=function(){
            if(getStyle(_this1,'backgroundColor')=='rgb(41, 189, 224)'||getStyle(_this2,'backgroundColor')=='rgb(41, 189, 224)'||this.style.backgroundColor=='orange'){
                alert('请按顺序进行游戏');
            }else{
                alert('玩家依次投票');
                this.style.backgroundColor ='orange';
            }
        };
        vote[j].onclick=function(){
            if(getStyle(_this3,'backgroundColor')=='rgb(41, 189, 224)'||getStyle(_this1,'backgroundColor')=='rgb(41, 189, 224)'||getStyle(_this2,'backgroundColor')=='rgb(41, 189, 224)'||this.style.backgroundColor=='orange'){
               alert('请按顺序进行游戏');
            }else{
                window.location.href='vote.html';
            }
        }

    }
}
load();
document.getElementsByClassName('journal')[0].onclick=function () {
    window.location.href='journal.html';
};



