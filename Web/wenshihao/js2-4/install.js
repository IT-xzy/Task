//定义玩家对象
function player(role,state){
    this.role=role;
    this.state=state;
}
//输出初始值触发的函数
function change(){
    var num=document.getElementById("figure");//总人数
    var slip=document.getElementById("range");//获取滑块
    var kill=[];//定义杀手数组
    var people=[];//定义平民数组
    if(num.value == ''||isNaN(num.value)){
        alert('不是数字');
    }
    if(num.value<4||num.value>18){
        alert('请输入正确玩家数量');
    }
    //根据玩家数判断杀手和平民数
    if(num.value>3&&num.value<6){
        kill.length=1;
    }else if(num.value>5&&num.value<9){
        kill.length=2;
    }else if(num.value>8&&num.value<12){
        kill.length=3;
    }else if(num.value>11&&num.value<16){
        kill.length=4;
    }else {
        kill.length=5;
    }
     people.length=num.value-kill.length;
    for(var i=0;i<kill.length;i++){
        kill[i]=new player("杀手","live");
    }//分配出杀手
    for(var j=0;j<people.length;j++){
        people[j]=new player("平民","live");
    }//分配出平民
    document.getElementById("killer").innerHTML=kill.length;//由杀手长度实现页面杀手人数
    document.getElementById("man").innerHTML=people.length;//同上
    slip.value=num.value;//使滑块的值=输入的值
    console.log(kill);
    console.log(people);
    var card=kill.concat(people);//合并数组
    //洗牌算法乱序身份
    function randomDom(card) {
        var len = card.length;
        for (var i = 0; i < len; i++) {
            var idx = Math.floor(Math.random() * (len - i));
            var temp = card[idx];
            card[idx] = card[len - i - 1];
            card[len - i - 1] = temp;
        }
        return card;
    }
    randomDom(card);
    console.log( randomDom(card));
    //传递杀手，平民，乱序数组的参数
    sessionStorage .setItem('card',JSON.stringify(card) );
    sessionStorage .setItem('kill',JSON.stringify(kill) );
    sessionStorage .setItem ('people',JSON.stringify(people));
    var deadPeople=[];//定义死亡数组
    deadPeople.length=card.length;
    sessionStorage.setItem ('deadPeople',JSON.stringify(deadPeople));
}

//同上（当时写的实在sb= =）
function put() {
    var num = document.getElementById("figure");
    var slip = document.getElementById("range");
    var kill = [];
    var people = [];
    if (slip.value > 3 && slip.value < 6) {
        kill.length = 1;
    } else if (slip.value > 5 && slip.value < 9) {
        kill.length = 2;
    } else if (slip.value > 8 && slip.value < 12) {
        kill.length = 3;
    } else if (slip.value > 11 && slip.value < 16) {
        kill.length = 4;
    } else {
        kill.length = 5;
    }
    people.length = slip.value - kill.length;
    for (var i = 0; i < kill.length; i++) {
        kill[i] =new player( "杀手","live")
    }
    for (var j = 0; j < people.length; j++) {
        people[j] =new player( "平民","live")
    }
    document.getElementById("killer").innerHTML = kill.length;
    document.getElementById("man").innerHTML = people.length;

    num.value = slip.value;
    console.log(kill);
    console.log(people);
    var card = kill.concat(people);
    function randomDom(card) {
        var len = card.length;
        for (var i = 0; i < len; i++) {
            var idx = Math.floor(Math.random() * (len - i));
            var temp = card[idx];
            card[idx] = card[len - i - 1];
            card[len - i - 1] = temp;
        }
        return card;
    }
    randomDom(card);
    console.log( randomDom(card));
    sessionStorage .setItem('card',JSON.stringify(card) );
    sessionStorage .setItem('kill',JSON.stringify(kill) );
    sessionStorage .setItem ('people',JSON.stringify(people));
    var deadPeople=[];//定义死亡数组
    deadPeople.length=card.length;
    sessionStorage.setItem ('deadPeople',JSON.stringify(deadPeople));
}
function jump(){
    window.location.href="plate.html";

}



