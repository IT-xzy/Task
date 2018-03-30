card=JSON.parse(sessionStorage.getItem ('card'));
kill=JSON.parse(sessionStorage.getItem ('kill'));
people=JSON.parse(sessionStorage.getItem('people'));
deadPeople=JSON.parse(sessionStorage.getItem('deadPeople'));
var reDeadPeople=deadPeople.reverse();//反转死亡数组里面的位置
var card2=people.concat(kill);//当前活着的数组
var down=Math.ceil((card.length-card2.length)/2);//总当前死亡人数的一半向上取整
//获取各个节点
var victory=document.getElementsByClassName('cup');
var text=document.getElementById('text');
var aDiv=document.getElementsByClassName('box');
var btn=document.getElementsByClassName('onebutton');
var home=document.getElementsByClassName('home');

function load() {
    //克隆每一天的信息
    for(var i=0;i<down;i++){
        var cloneItem=aDiv[0].cloneNode(true);
        aDiv[0].parentNode.appendChild(cloneItem);
        cloneItem.style.display ='block';
        cloneItem.getElementsByClassName ('days')[0].innerHTML='第'+(i+1)+'天';
        //根据死亡数组的位置来遍历每一天所发生的事
        cloneItem.getElementsByClassName ('night')[0].innerHTML='晚上：' + (reDeadPeople[i+i].deadNum) + '号被杀手杀死，身份是'+reDeadPeople[i+i].deadRole;
        cloneItem.getElementsByClassName ('morning')[0].innerHTML='白天: ' + (reDeadPeople[i+i+1].deadNum) + '号被全民投票投死，身份是' + reDeadPeople[i+i+1].deadRole;
    }
    //判断胜利条件
    if(people.length==0){
        victory[0].innerHTML='杀手胜利';
        text.innerHTML='太棒了！你知道么？在杀人游戏中只有20%的杀手取得游戏最终的胜利哦！'
    }else{
        victory[0].innerHTML='平民胜利';
        text.innerHTML='太棒了！你知道么？在杀人游戏中只有80%的平民取得游戏最终的胜利哦！'

    }
    //跳转初始页并清空所有数据
    btn[0].onclick=function () {
        sessionStorage.removeItem ('card');
        sessionStorage.removeItem ('people');
        sessionStorage.removeItem ('kill');
        sessionStorage.removeItem ('deadPeople');
        window.location.href='install.html';
    }
    //跳转首页并清空所有数据
    home[0].onclick=function () {
        sessionStorage.removeItem ('card');
        sessionStorage.removeItem ('people');
        sessionStorage.removeItem ('kill');
        sessionStorage.removeItem ('deadPeople');
        window.location.href='choice.html';
    }


}
load();