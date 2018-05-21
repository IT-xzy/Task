//取得上一个页面的数据

var playBoy = JSON.parse(sessionStorage.getItem('playerRoleTrans')); //身份元素
var playNum = window.sessionStorage.getItem('playBar');  //玩家数量
var allPlayers = JSON.parse(sessionStorage.getItem('allPlayers')); //
//游戏已经开始,再也不能回头了
//杀人界面和投票页面来回切换;
// console.log(playBoy);               //玩家的基本ID
// console.log(allPlayers);            //玩家ID以及当前的状态
// console.log(typeof playNum);        //string
// console.log(typeof playBoy);        //object
// console.log(typeof allPlayers);     //object
//杀人界面和投票界面来回切换
var title = window.sessionStorage.getItem('roleTime');
if(title < 1) {
    $('.get-one-man-out').html('杀人环节');
    $('.foot-function').html('杀死平民');
    console.log(title);
} else {
    $('.get-one-man-out').html('投票环节');
    $('.foot-function').html('投票出局');
    console.log(title);
}

//添加动态角色节点
for (i = 0; i < playNum; i++) {
    $('.content-box').append(
        '<div class = "content-box1">'
        + '<p class = "content1">'
        + playBoy[i]
        + '</p>'
        + '<p class = "number1">'
        + (i + 1)
        + '号'
        + '</p>'
        + '</div>'
    );//添加节点完成
    var allPeople = $('.content1');  //获取.content1 这个元素 每一个.content元素
    // console.log(allPeople);            //打印出来
    if (allPlayers[i].state === 0) {    //如果玩家的状态为0
        $(allPeople[i]).css('backgroundColor','#ff6c5c')// i玩家的背景颜色变为红色
    }
}//没什么要改的

//最后点击的那个玩家出局
var lastSelect;
for (var j = 0; j < playNum; j++) {//遍历玩家数组
    allPeople[j].index = j;
    allPeople[j].onclick = function () {
        var deadNums = []; //每次点击都会清空数组,让数组只存放最后点击的玩家
        deadNums.push(allPlayers[this.index].number);//将死掉的内个玩家的数据放进去
        console.log(deadNums);//打印一下这个死掉的玩家的数
        //获取最后点击的玩家号码,就是被杀死的玩家,放在死亡玩家的数组中
        sessionStorage.setItem('deadNums' ,JSON.stringify(deadNums));//把这个数字储存起来,准备在法官页面使用 
        if (allPlayers[this.index].id === '杀手' || allPlayers[this.index].state === 0) {
            if (allPlayers[this.index].state === 0) {
                alert('他已经死了');
            } else {
                alert('自己人都不放过!')
            }
        } else {
            if (lastSelect !== undefined) {
                allPlayers[lastSelect].state = 1;
                $(allPeople[lastSelect]).css('backgroundColor', '#f5c97b');
            }
            $(allPeople[this.index]).css('backgroundColor','#ff6c5c');
            allPlayers[this.index].state = 0;
            console.log(allPlayers[this.index].state);
            lastSelect = this.index;
            //这三项是用来判断: 如果玩家改变杀死人时,就将之前死亡的玩家的背景颜色还原.
        }
        console.log(deadNums);
    }
}
var killer = 0;  //杀手人数
var farmer = 0;  //农民人数
function outSomebody() {
    sessionStorage.setItem("allPlayers", JSON.stringify(allPlayers));
    //存入元素名为 'allPlayers' 的JSON
    for (var n = 0;n < playNum; n++) {
        if (allPlayers[n].state === 1) {
            if (allPlayers[n].id === '杀手') {
                killer++;
                console.log(killer);
            } else {
                farmer++;
                console.log(farmer);
            }
        }
    }

    //循环判断玩家对象中,所有活着的杀手和平民的数量,再比较两者的数量,跳转到对应的页面
    if (lastSelect === undefined) {
        alert('今天必须死一个!')
    } else {
        if (killer >= farmer) {
            var result = 2;
            sessionStorage.setItem('result',JSON.stringify(result));
            alert('杀手胜利!');
            window.location.href = '玩家选择游戏页面.html';
        } else {
            window.location.href = '法官日志.html';
        }
        console.log(killer);
    }
}

function backout() {
    window.location.href = '玩家配比页面.html';
}