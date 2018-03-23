/*
 * @Author: 汤镇铭Michael 
 * @Date: 2018-01-09 14:54:16 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-19 21:02:28
 */

 
 //输入框与滑动条部分--------------------------------------------------------------------------
//input输入框与滑动条的双向绑定
var inputNum = document.getElementById("inputnum");
var rangeNum = document.getElementById("range");

var btn1 = document.getElementById("btn1");
var btn2 = document.getElementById("btn2");

inputNum.onchange = function () {
	rangeNum.value = inputNum.value;
	if (inputNum.value < 4 || inputNum.value > 18) {
		alert("请输入正确的数字");
	}
}
rangeNum.onchange = function () {
	inputNum.value = rangeNum.value;
}

//点击按钮改变滑动条按钮的位置
btn1.onclick = function () {//btn1点击后，滑动条按钮位置改变，滑动条值改变，同时改变输入框的值；btn2一样。
	/* rangeNum.value -= 1; 如果是减法的话是没问题的，加法有BUG，参考下面 */
	rangeNum.value--;
	inputNum.value = rangeNum.value;
}
btn2.onclick = function () {
	rangeNum.value++;
	inputNum.value = rangeNum.value;
	/* 
	这部分有BUG，点击之后直接到最大值了
	rangeNum.value += 1;问题的始源，这里这么写的话，出来的还是字符串，相当于字符串8加上1等于字符串81，我INPUT限制了最大值，所以会跳到18
	var a= rangeNum.value = rangeNum.value*1+1; inputNum.value = a;先*1就可以转化为数字，问题可以解决，目前可以用++自增运算，以后需求改变以后，可以考虑用这个
	parseInt("rangeNum.value");这里为什么无法解决这个问题，是因为这样写并没有把rangeNum.value字符串转化为数字，不能这样写，要去掉双引号
	*/
}

//随机分配部分-----------------------------------------------------------------------------------
var setBtn = document.getElementById("set");
var option = document.getElementById('option');
// console.log(option); 
// console.log(typeof option); 发现取得的是一个元素节点对象，那么之后的初始化就要用对象的格式写方法了【option.innerHTML = "";】

setBtn.onclick = function () {
	var setNum = inputNum.value;// 不要在这个执行环境以外的环境中声明，否则就会无法获取实时的input值
	
	// 每次点击重置数组对象
	var killer = new Array();
	var civilian = new Array();
	function obj(state, identify) {
		this.state = state;
		this.role = identify;
		this.date = '';
		this.style = '';
	}
	/* 
	这里有一个地方我犯错了，
	我当时是在全局执行环境中声明的初始数组和初始对象，
	这就导致了，
	每次点击事件开始的时候，里面的语句直接使用第一次生成的新数组和新对象；
	所以当人数是4的时候，生成的长度为4的数组对象（杀手平民加起来），
	5的时候，生成的长度为5的数组对象，6的时候生成长度为6的数组对象，这都是没问题的，
	因为新的长度会覆盖之前的长度。
	氮素！当我需要减少人数的时候，比如我从6变回4，这时候出现问题了：
	在全局执行环境中已经定义了长度为6的数组对象，你再添加4，也是只改变了前4位，总体长度还是6。
	所以就会出现人数只能增加，不能减少的BUG~
	如何解决？
	很简单，不要再全局执行环境中声明初始数组和对象就可以了。
	直接在局部执行环境中声明，这样当函数结束后，用完的数据就会被销毁（或者说又被重新定义了可能更确切一点）。
	当出现问题的时候，告诉自己莫慌。
	定位出现问题的位置，善用console.log & typeof & breakpoints~
	 */
	
	// option.innerHTML = "";
	// 重置节点
	while (option.hasChildNodes()) {
		option.removeChild(option.firstChild);
	}
	
	//根据分配规则在数组中添加对象
	if (setNum == 4 || setNum == 5) {
		for (var i = 0; i < 1; i++) {
			killer[i] = new obj('living', "killer");
		}
		for (var i = 0; i < setNum - 1; i++) {
			civilian[i] = new obj('living', "civilian");
		}
	} else if (setNum > 5 && setNum < 9) {
		for (var i = 0; i < 2; i++) {
			killer[i] = new obj('living', "killer");
		}
		for (var i = 0; i < setNum - 2; i++) {
			civilian[i] = new obj('living', "civilian");
		}
	} else if (setNum >= 9 && setNum <= 11) {
		for (var i = 0; i < 3; i++) {
			killer[i] = new obj('living', "killer");
		}
		for (var i = 0; i < setNum - 3; i++) {
			civilian[i] = new obj('living', "civilian");
		}
	} else if (setNum >= 12 && setNum <= 15) {
		for (var i = 0; i < 4; i++) {
			killer[i] = new obj('living', "killer");
		}
		for (var i = 0; i < setNum - 4; i++) {
			civilian[i] = new obj('living', "civilian");
		}
	} else if (setNum >= 16 && setNum <= 18) {
		for (var i = 0; i < 5; i++) {
			killer[i] = new obj('living', "killer");
		}
		for (var i = 0; i < setNum - 5; i++) {
			civilian[i] = new obj('living', "civilian");
		}
	}
	
	var sumArr = killer.concat(civilian);
	// console.log(sumArr);
	
	// 数组乱序
	realArr = Array.prototype.slice.call(sumArr, 0);
	var sumRandom = new Array();
	for (i = 0; i < sumArr.length; i++) {
		var num = Math.floor(Math.random() * realArr.length);
		sumRandom.push(realArr[num]);
		realArr.splice(num, 1);
	}
	// console.log(sumRandom);
	
	sessionStorage.sumRandom = JSON.stringify(sumRandom); // 存储数据
	
	//实现随机分配
	for (i = 0; i < sumRandom.length; i++) {// 以后再不理解的话，可以打断点，可视化的执行进程，易于理解
		var li = document.createElement('li');
		if (sumRandom[i].role == 'killer') {
			option.appendChild(li);
			li.innerHTML = "杀手 1 人";
			li.style.color = '#29bde0';
		} else if (sumRandom[i].role == 'civilian') {
			option.appendChild(li);
			li.innerHTML = "平民 1 人";
			li.style.color = '#fbb435';
		}
	}
}



//重写重写---------------------------------------------------
/* 
var killer = document.getElementById("kNum");
var civilian = document.getElementById("cNum");

// 页面初始化显示的分配数
setNum = 4;
killer.innerHTML = 1;
setNum -= 1;
civilian.innerHTML = setNum;

// 点击按钮进行人数分配，赋值改值
setBtn.onclick = function () {
	var setNum = rangeNum.value;
	if (setNum == 4 || setNum == 5) {
		killer.innerHTML = 1;
		setNum -= 1;
		civilian.innerHTML = setNum;
	} else if (setNum > 5 && setNum < 9) {
		killer.innerHTML = 2;
		setNum -= 2;
		civilian.innerHTML = setNum;
	} else if (setNum >= 9 && setNum <= 11) {
		killer.innerHTML = 3;
		setNum -= 3;
		civilian.innerHTML = setNum;
	} else if (setNum >= 12 && setNum <= 15) {
		killer.innerHTML = 4;
		setNum -= 4;
		civilian.innerHTML = setNum;
	} else if (setNum >= 16 && setNum <= 18) {
		killer.innerHTML = 5;
		setNum -= 5;
		civilian.innerHTML = setNum;
	}
} */




/* 

//--------------------------------------------------------------------重写


var square = document.getElementsByClassName("square");

var getOption = document.getElementsByClassName("option");
var randomArr = Array.prototype.slice.call(getOption, 0);//伪数组
var randomOption = new Array();
for (i = 0; i < getOption.length; i++) {//创建随机数组
	var num = Math.floor(Math.random() * randomArr.length);
	randomOption.push(randomArr[num]);
	randomArr.splice(num, 1);
}

function startChange() {
	for (i = 0; i < 18; i++) {//把所有元素隐藏并脱离文档流，这样之后显示元素以后就能自动浮动在一起了
		randomOption[i].style.display = "none";
	}
	var setNum = rangeNum.value;
	for (i = 0; i < setNum; i++) {
		if (setNum == 4 || setNum == 5) {
			if (i < 1) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				square[i].style.display = "block";
				randomOption[i].style.display = "flex";
			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";
			}
		} else if (setNum > 5 && setNum < 9) {
			if (i < 2) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				randomOption[i].style.display = "flex";
			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";
			}
		} else if (setNum >= 9 && setNum <= 11) {
			if (i < 3) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				randomOption[i].style.display = "flex";

			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";

			}
		} else if (setNum >= 12 && setNum <= 15) {
			if (i < 4) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				randomOption[i].style.display = "flex";

			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";

			}
		} else if (setNum >= 16 && setNum <= 18) {
			if (i < 5) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				randomOption[i].style.display = "flex";

			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";

			}
		}
	}
}

var setBtn = document.getElementById("set");
setBtn.onclick = function () {
	for (i = 0; i < 18; i++) {//重置
		randomOption[i].innerHTML = "";
	}
	setTimeout(startChange,0);
} 
*/
	



// --------------------------------------------------------------------重写



// var getOption = document.getElementsByClassName("option");
// var getKiller = document.getElementsByClassName("kill");
// var getCivilian = document.getElementsByClassName("civilian");

// var optionArr = Array.prototype.slice.call(getOption, 0);
// var killerArr = Array.prototype.slice.call(getKiller,0);
// var civilianArr = Array.prototype.slice.call(getCivilian, 0);
// 伪数组转化



// var sumArr = killerArr.concat(civilianArr);
// console.log(sumArr)
// 合并数组




// var randomKiller = new Array();
// for (i = 0; i < getKiller.length; i++) {
// 	var num = Math.floor(Math.random() * killerArr.length);
// 	randomKiller.push(killerArr[num]);
// 	killerArr.splice(num, 1);
// }
// var randomCivilian = new Array();
// for (i = 0; i < getCivilian.length; i++) {
// 	var num = Math.floor(Math.random() * civilianArr.length);
// 	randomCivilian.push(civilianArr[num]);
// 	civilianArr.splice(num, 1);
// }
// var randomSum = new Array();
// for (i = 0; i < getOption.length; i++) {
// 	var num = Math.floor(Math.random() * optionArr.length);
// 	randomSum.push(optionArr[num]);
// 	optionArr.splice(num, 1);
// }
// console.log(randomKiller)
// console.log(randomCivilian)
// console.log(randomSum)
//随机数组


// var square = document.getElementsByClassName("square");
// for (i = 0; i < square.length; i++) {
// 	square[i].style.display = "none";
// }


// function startChange() {
// 	for (i = 0; i < 18; i++) {//把所有元素隐藏并脱离文档流，这样之后显示元素以后就能自动浮动在一起了
// 		randomSum[i].style.display = "none";
// 	}
// 	var setNum = rangeNum.value;
// 	if (setNum == 4 || setNum == 5) {
// 		}
// 	}
// }


/* 
	for (i = 0; i < setNum; i++) {
		if (setNum == 4 || setNum == 5) {
			if (i < 1) {
			} else {
			}
		} else if (setNum > 5 && setNum < 9) {
			if (i < 2) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				randomOption[i].style.display = "flex";
			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";
			}
		} else if (setNum >= 9 && setNum <= 11) {
			if (i < 3) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				randomOption[i].style.display = "flex";

			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";

			}
		} else if (setNum >= 12 && setNum <= 15) {
			if (i < 4) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				randomOption[i].style.display = "flex";

			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";

			}
		} else if (setNum >= 16 && setNum <= 18) {
			if (i < 5) {
				randomOption[i].innerHTML = "杀&emsp;手 1 人";
				randomOption[i].style.display = "flex";

			} else {
				randomOption[i].innerHTML = "平&emsp;民 1 人";
				randomOption[i].style.display = "flex";
			}
		}
	}
*/











//-----------------------------------------------------


/* caocaocao 重写……

setBtn.onclick = function () {
	var setNum = rangeNum.value;//获取人数


	for (i = 0; i < 5; i++) {
		getKiller[i].style.display = "none";
	}
	for (i = 0; i < 13; i++) {
		getCivilian[i].style.display = "none";
	}


	if (setNum == 4 || setNum ==5) {//注意了，单个=号是赋值操作！！！等于是==
		for (i = 0; i < 1; i++) {
			randomKiller[i].style.display = "flex";
			randomKiller[i].style.visibility = "visible";
		}
		for (i = 0; i < setNum - 1; i++) {
			randomCivilian[i].style.display = "flex";
			randomCivilian[i].style.visibility = "visible";
		}
	} else if (setNum > 5 && setNum < 9) {
		for (i = 0; i < 2; i++) {
			randomKiller[i].style.display = "flex";
			randomKiller[i].style.visibility = "visible";
		}
		for (i = 0; i < setNum - 2; i++) {
			randomCivilian[i].style.display = "flex";
			randomCivilian[i].style.visibility = "visible";
		}
	} else if (setNum >= 9 && setNum <= 11) {
		for (i = 0; i < 3; i++) {
			randomKiller[i].style.display = "flex";
			randomKiller[i].style.visibility = "visible";
		}
		for (i = 0; i < setNum - 3; i++) {
			randomCivilian[i].style.display = "flex";
			randomCivilian[i].style.visibility = "visible";
		}
	} else if (setNum >= 12 && setNum <= 15) {
		for (i = 0; i < 4; i++) {
			randomKiller[i].style.display = "flex";
			randomKiller[i].style.visibility = "visible";
		}
		for (i = 0; i < setNum - 4; i++) {
			randomCivilian[i].style.display = "flex";
			randomCivilian[i].style.visibility = "visible";
		}
	} else if (setNum >= 16 && setNum <= 18) {
		for (i = 0; i < 5; i++) {
			randomKiller[i].style.display = "flex";
			randomKiller[i].style.visibility = "visible";
		}
		for (i = 0; i < setNum - 5; i++) {
			randomCivilian[i].style.display = "flex";
			randomCivilian[i].style.visibility = "visible";
		}
	}
} 
 */