var x = document.getElementsByClassName("block");//从class:block中得到HTML collection对象
var index_x = [0,1,2,3,4,5,6,7,8];//定义一个索引数组
//从一个给定的数组arr中,随机返回num个不重复项
function getArrayItems(arr, num) {
    //新建一个数组,将传入的数组复制过来,用于运算,而不要直接操作传入的数组;
    var temp_array = new Array();
    for (var index in arr) {
        temp_array.push(arr[index]);
    }
    //取出的数值项,保存在此数组
    var return_array = new Array();
    for (var i = 0; i < num; i++) {
        //判断如果数组还有可以取出的元素,以防下标越界
        if (temp_array.length > 0) {
            //在数组中产生一个随机索引
            var arrIndex = Math.floor(Math.random() * temp_array.length);
            //将此随机索引的对应的数组元素值复制出来
            return_array[i] = temp_array[arrIndex];
            //然后删掉此索引的数组元素,这时候temp_array变为新的数组
            temp_array.splice(arrIndex, 1);
        } 
        else {
            //数组中数据项取完后,退出循环,比如数组本来只有10项,但要求取出20项.
            break;
        }
    }
    return return_array;
}

function randomColor()//随机颜色
{
	//return '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).substr(-6);
	var hex = Math.floor(Math.random() * 16777216).toString(16); //生成ffffff以内16进制数
	while (hex.length < 6) { //while循环判断hex位数，少于6位前面加0凑够6位
		hex = '0' + hex;
	}
	return '#' + hex; //返回‘#'开头16进制颜色
}

function changeColor()//点击开始闪
{
	var num = 3;//填写需要闪动块的个数
	var temp_array = getArrayItems(index_x, num);
	for (var i = 0; i < index_x.length; i++) {
		for (var j = 0; j < num; j++) {
			if (temp_array[j] == i) {
				x[i].style.backgroundColor = randomColor();
				break;
			}
			else {
				x[i].style.backgroundColor = "#eee";
			}
		}
	}
}

var start;//定义延时变量
var count = 0;
document.getElementById('flashStartButton').addEventListener('click', flashStart);
document.getElementById('flashEndButton').addEventListener('click', flashEnd);
//延时函数，开始闪动
function flashStart() {
	if (count == 0) {
		start = window.setInterval(changeColor, 1000);
		count++;
	}
	else {
		document.getElementById('flashStartButton').removeEventListener('click', flashStart);
	}
}
//停止闪动（使用延时变量清除延时）
function flashEnd() {
	window.clearInterval(start);
	document.getElementById('flashStartButton').addEventListener('click', flashStart);
	count = 0;
	//清除所有块的颜色
	for (var i = 0; i < index_x.length; i++) {
		x[i].style.backgroundColor = "#eee";
	}
}