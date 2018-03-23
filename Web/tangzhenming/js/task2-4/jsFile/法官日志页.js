/*
 * @Author: 汤镇铭Michael 
 * @Date: 2018-01-14 10:47:41 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-20 17:35:25
 */
// ------------------------------------------------------------------------------------------
var sumState = JSON.parse(sessionStorage.getItem('sumRandom'));// 数据传递
console.log(sumState);

var container = document.getElementById('container');
var square = document.getElementsByClassName('square');// 使用CLASS，避免之后复制出来的节点一堆的ID
var setNum = document.getElementsByClassName('setNum');
var identification = document.getElementsByClassName('identification');
// console.log(square);
// console.log(setNum);
// console.log(identification);

for (i = 1; i < sumState.length; i++) {// 克隆出空的节点
    var sClone = square[0].cloneNode(true);
    container.appendChild(sClone);
    // console.log(sClone);
}

for (i = 0; i < sumState.length; i++ ) {// 遍历数组和节点进行对应写入身份和数字
    setNum[i].innerHTML = i + 1;
    if (sumState[i].role == 'killer') {
        identification[i].innerHTML = '杀手';
    } else {
        identification[i].innerHTML = '平民';
    }
    identification[i].style.backgroundColor = '#f5c97b';
    if (sumState[i].state == 'died') {
        identification[i].style.backgroundColor = 'rgb(131, 176, 154)';
    }
}
// console.log(container);