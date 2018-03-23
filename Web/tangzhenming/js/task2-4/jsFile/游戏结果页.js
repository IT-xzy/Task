/*
 * @Author: 汤镇铭Michael 
 * @Date: 2018-01-19 15:57:57 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-21 15:12:08
 */
// ------------------------------------------------------------------------------------------
var sumState = JSON.parse(sessionStorage.getItem('sumRandom'));// 数据传递
console.log(sumState);

var day = sessionStorage.getItem('day'); // 获取天数数据

var content = document.getElementsByClassName('content')[0];

for (i = 0; i < day; i++) {// 根据天数增加子节点
    var div_box = document.createElement('div');
    // console.log(div_box);// 创建元素节点需要加上引号，打印的时候如果是变量就不用加引号了，加了引号就打印字符串了
    content.appendChild(div_box);
    div_box.setAttribute('class', 'box');// 设置节点属性值
    
    var div_line = document.createElement('div');
    var div = document.createElement('div');
    div_box.appendChild(div_line);
    div_box.appendChild(div);
    div_line.setAttribute('class', 'line');
    
    var p_day = document.createElement('p');
    var p_time = document.createElement('p');
    div_line.appendChild(p_day);
    div_line.appendChild(p_time);
    p_day.setAttribute('class', 'day');
    p_time.setAttribute('class', 'time');
    p_day.innerHTML = '第' + (i+1) + '天';
    p_time.innerHTML = '0小时07分';
    
    var p_night = document.createElement('p');
    var p_daytime = document.createElement('p');
    div.appendChild(p_night);
    div.appendChild(p_daytime);
    p_night.setAttribute('class', 'night');
    p_daytime.setAttribute('class', 'daytime');

    for (j = 0; j < sumState.length; j++) {
        if (sumState[j].date == (i + 1)) {
            if (sumState[j].style == 'killed') {
                if (sumState[j].role == 'civilian') {
                    p_night.innerHTML = '晚上：' + (j + 1) + '号被杀手杀死，' + (j + 1) + '号是平民';
                }// 杀手不会被刀死
            }
            if (sumState[j].style == 'voted') {
                if (sumState[j].role == 'civilian') {
                    p_daytime.innerHTML = '白天：' + (j + 1) + '号被全民投票投死，' + (j + 1) + '号是平民';
                } else {
                    p_daytime.innerHTML = '白天：' + (j + 1) + '号被全民投票投死，' + (j + 1) + '号是杀手';
                }
            }
        }
    }
}
// --------------------------------------------------------------------------------
$('.left').click(function () {// 再来一局
    window.location.href = 'https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/01.%E9%A6%96%E9%A1%B5.html';
    sessionStorage.clear();
})
/* 业务逻辑 
1、根据进行的天数，循环添加节点
2、根据：第几天被杀死，身份是什么，如何被杀死，是几号玩家（根据数组下标+1）四个数据对节点进行写入 
 */