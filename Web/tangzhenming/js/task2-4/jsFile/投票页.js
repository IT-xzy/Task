/*
 * @Author: 汤镇铭Michael 
 * @Date: 2018-01-14 11:48:10 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-21 15:11:36
 */
// --------------------------------------------------------------------------------------
var sumState = JSON.parse(sessionStorage.getItem('sumRandom'));// 数据传递
console.log(sumState);

var container = document.getElementById('container');
var squareArr = document.getElementsByClassName('square');// 使用CLASS，避免之后复制出来的节点一堆的ID

var setNum = document.getElementsByClassName('setNum');// 获取头像中数字部分节点
var identification = document.getElementsByClassName('identification');// 获取头像中身份部分节点
// ---------------------------------------------------------------------------------------
for (i = 1; i < sumState.length; i++) {// 克隆节点
    var sClone = squareArr[0].cloneNode(true);
    container.appendChild(sClone);
}

for (i = 0; i < sumState.length; i++) {// 遍历数组和节点进行对应写入身份和数字
    setNum[i].innerHTML = i + 1;
    if (sumState[i].role == 'killer') {
        identification[i].innerHTML = '未知';
    } else {
        identification[i].innerHTML = '未知';
    }
    if (sumState[i].state == 'died') {// 这里用的方法比较笨，因为每次点击选人杀和投的时候，需要重置颜色，所以被杀的人会重新变色，那我只能在点击事件出现之前，先把颜色给更改了，之后再在点击事件中被杀被投一起更改，这样重置前后被杀都是灰色了
        identification[i].style.backgroundColor = 'rgb(131, 176, 154)';
    }
}

container.onclick = function (e) {// 点选身份头像杀死相应的人
    var target = e.target;
    for (i = 0; i < sumState.length; i++) {
        identification[i].style.backgroundColor = '#f5c97b';// 重置颜色，其实也就是重置选择，不让玩家重复选择并杀死多人——from世豪师兄
        if (sumState[i].state == 'died') {// 参考上面遍历数组写入身份数字那相同的部分的注释
            identification[i].style.backgroundColor = 'rgb(131, 176, 154)';
        }
        if (target == identification[i]) {
            if (sumState[i].state == 'living') {// 如果还活着就投死
                identification[i].style.backgroundColor = 'rgb(131, 176, 154)';
            } else {
                alert('不能选择死人');
            }
        }
    }
}
// ---------------------------------------------------------
document.getElementById('watch').onclick = function () {
    var kNum = 0;// 还活着的杀手
    var cNum = 0;// 还活着的平民
    for (i = 0; i < sumState.length; i++) {
        if (identification[i].style.backgroundColor == 'rgb(131, 176, 154)') {
            sumState[i].state = 'died';// 把选中的角色的状态改为死亡
            if (sumState[i].date == '') {
                sumState[i].date = sessionStorage.getItem('day');// 写入数据：在第几天被杀死
            }
            if (sumState[i].style == '') {// 解决投票按钮之后所有style数据都会被修改为voted
                sumState[i].style = 'voted';
            }
            sessionStorage.setItem('sumRandom', JSON.stringify(sumState));
        }
        if (sumState[i].state == 'living' && sumState[i].role == 'killer') {
            kNum++;
        }
        if (sumState[i].state == 'living' && sumState[i].role == 'civilian') {
            cNum++;
        }
    }
    if (kNum == cNum || kNum == 0) {// 天数的运算要放在这里之后，符合胜负的话就不需要调整天数的数据了，直接跳转
        window.location.href ='https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/08.%E6%B8%B8%E6%88%8F%E7%BB%93%E6%9E%9C%E9%A1%B5.html';
    } else {
        var day = sessionStorage.getItem('day');// 获取天数
        day++;
        sessionStorage.setItem('day', day); // 增加1天，存到本地存储中去
        window.location.href = 'https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/05.%E6%B3%95%E5%AE%98%E5%8F%B0%E6%9C%AC%E9%A1%B5.html';
    }
}