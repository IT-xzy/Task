card=JSON.parse(sessionStorage .getItem('card'));//获取总的乱序数组
console.log(card);
 var div=document.getElementsByClassName('box');//获取第一个身份牌盒子
//克隆身份牌函数
function load() {
    for (var i = 0; i < card.length; i++) {
        var cloneItem = div[0].cloneNode(true);//克隆这div以及它所有子元素
        div[0].parentNode.appendChild(cloneItem);//克隆在第一个获取的身份牌盒子后面
        cloneItem.style.display ='block';
        cloneItem.getElementsByClassName('second')[0].innerHTML = (i + 1) + '号';//根据遍历获得乱序数组的号数
        cloneItem.getElementsByClassName('first')[0].innerHTML = card[i].role;//同理获得乱序数组的身份
        //根据死亡状态改变盒子透明度
        if (card[i].state !== 'live') {
            div[i+1].style.opacity = '0.5';
        }
    }

document.getElementsByClassName('footer')[0].onclick=function(){
        window.location.href='game.html';
}
}
load();


    

