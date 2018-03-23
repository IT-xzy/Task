/*
 * @Author: 汤镇铭Michael 
 * @Date: 2018-01-15 16:23:15 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-21 15:09:58
 */
// -------------------------------------------------------------------------------------
var sumState = JSON.parse(sessionStorage.getItem('sumRandom'));// 数据传递
console.log(sumState);

var container = document.getElementById('container');
var squareArr = document.getElementsByClassName('square');// 使用CLASS，避免之后复制出来的节点一堆的ID

var setNum = document.getElementsByClassName('setNum');// 获取头像中数字部分节点
var identification = document.getElementsByClassName('identification');// 获取头像中身份部分节点
// -------------------------------------------------------------------------------------
for (i = 1; i < sumState.length; i++) {// 克隆节点
    var sClone = squareArr[0].cloneNode(true);
    container.appendChild(sClone);
}

for (i = 0; i < sumState.length; i++) {// 遍历数组和节点写入身份和数字
    setNum[i].innerHTML = i + 1;
    if (sumState[i].role == 'killer') {
        identification[i].innerHTML = '杀手';
    } else {
        identification[i].innerHTML = '平民';
    }
    if (sumState[i].state == 'died') {
        identification[i].style.backgroundColor = 'rgb(131, 176, 154)';
    }
}

container.onclick = function (e) {// 点选身份头像
    var target = e.target;
    for (i = 0; i < sumState.length; i++) {
        if (sumState[i].state != 'died') { // 如果还活着，就重置颜色
            identification[i].style.backgroundColor = '#f5c97b';// 重置颜色，其实也就是重置选择，不让玩家重复选择并杀死多人——from世豪师兄
        }
        if (target == identification[i]) {
            if (sumState[i].role == 'civilian') {// 如果是平民的话就杀死
                identification[i].style.backgroundColor = 'rgb(131, 176, 154)';
            }
            if (sumState[i].role == 'killer') {
                alert('杀手只能被投死，不能被刀死');
            }
            if (sumState[i].state == 'died' && sumState[i].role == 'civilian') {// 这里的逻辑是：这里是杀人页，杀手是不能被杀死的，即便是死了的杀手也是弹出杀手不能被杀死。但是平民的话死了的就不能重复杀了。
                alert('不能重复杀人');
            }
        }
    }
}
// ---------------------------------------------------------------------------------------
document.getElementById('watch').onclick = function () {
    var kNum = 0;// 还活着的杀手
    var cNum = 0;// 还活着的平民
    for (i = 0; i < sumState.length; i++) {
        if (identification[i].style.backgroundColor == 'rgb(131, 176, 154)') {// console.log(identification[i].style.backgroundColor); 居然是rgb……
            sumState[i].state = 'died';// 把选中的角色的状态改为死亡
            if (sumState[i].date == '') {
                sumState[i].date = sessionStorage.getItem('day');// 写入数据：在第几天被杀死
            }
            if (sumState[i].style != 'voted') {
                sumState[i].style = 'killed';
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
    if (kNum == cNum || kNum == 0) {
        window.location.href = 'https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/08.%E6%B8%B8%E6%88%8F%E7%BB%93%E6%9E%9C%E9%A1%B5.html';
    } else {
        window.location.href = 'https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/05.%E6%B3%95%E5%AE%98%E5%8F%B0%E6%9C%AC%E9%A1%B5.html';
    }
}