/* 定时改变3个颜色 */

/* http://caibaojian.com/js-get-random-elements-from-array.html */
/*使用随机数获取数组下标，添加到数组尾部，返回随机数组 */
function getRandomArrayElements(arr, count) {
  var shuffled = arr.slice(0),
    i = arr.length,
    min = i - count,
    temp, index;
  while (i-- > min) {
    index = Math.floor((i + 1) * Math.random());
    temp = shuffled[index];
    shuffled[index] = shuffled[i];
    shuffled[i] = temp;
  }
  return shuffled.slice(min);
}
// 生成一个 0 到 n-1 的数组
function createArray(n) {
  var arr = [];
  for (var i = 0; i < n; i++) {
    arr.push(i);
  }
  return arr;
}
// 十进制数字decimal转换随机颜色
function decimal2RandomColor() {
  var a = '#';
  for (var i = 0; i < 3; i++) {
    var temp;
    temp = Math.floor((0xff + 1) * Math.random()).toString(16);
    a += (Array(2).join(0) + temp).slice(-2);
  }
  return a;
}

/* box 盒子数组 */
/* boxIndex  存放 1 到 indexlength 的下标数组 */
/* boxRandom colorRandom 存放3个下标的数组 */
var intervalID,
  box = document.getElementsByClassName('box'),
  boxIndex = createArray(box.length);

function getColor() {
  var boxRandom, colorRandom = [];
  // 数组去重
  do {
    boxRandom = getRandomArrayElements(boxIndex, 3);
    console.log(boxRandom[0] + ';' + boxRandom[1] + ';' + boxRandom[2] + ';');
  } while (boxRandom[0] == boxRandom[1] || boxRandom[1] == boxRandom[2] || boxRandom[2] == boxRandom[0])
  // 
  for (var i = 0; i < 3; i++) {
    colorRandom[i] = decimal2RandomColor();
  }
  // 重置背景色 orange #ffa500
  for (var i = 0; i < box.length; i++) {
    box[i].style.backgroundColor = 'orange';
  }
  // 改变背景色
  for (var i = 0; i < 3; i++) {
    // 数字转换为颜色
    box[boxRandom[i]].style.backgroundColor = colorRandom[i];
    console.log(boxRandom[i] + ';' + colorRandom[i]);
  }
}

// 改变颜色
function changeColor() {
  clearInterval(intervalID);
  intervalID = setInterval(getColor, 1000);
}
// 清除
function stop() {
  clearInterval(intervalID);
  for (var i = 0; i < box.length; i++) {
    box[i].style.backgroundColor = 'orange';
  }
}