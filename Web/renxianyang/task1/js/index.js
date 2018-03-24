var warp = document.querySelector('.wrap');
var start = document.getElementsByName('start')[0];
var end = document.getElementsByName('end')[0];
var timer;
var defaultBgColor = 'rgb(255, 160, 0)';
for(var i = 0; i < 9; i++) {
	let liNode = document.createElement('li');
	liNode.setAttribute('class', 'li');
	warp.appendChild(liNode);
}
var allLi = document.querySelectorAll('.li');
var colors = ['lime', 'black', 'red', 'orange', 'purple', 'brown', 'yellow', 'blue', 'gray'];
var index = [0, 1, 2, 3, 4, 5, 6, 7, 8];

function getRandom(num, scope) { //随机数
	var res = [];
	for(let i = 0; i < num; i++) {
		let num = Math.floor(Math.random() * scope);
		while(res.indexOf(num) != -1) {
			num = Math.floor(Math.random() * scope);
		}
		res.push(num);
	}
	return res;
}

function change() {
	var arrIndex = getRandom(3, 9);
	console.log(arrIndex)
	reset();
	for(var i = 0; i < 3; i++) {
		allLi[index[arrIndex[i]]].style.background = colors[arrIndex[i]];
	}
}

function reset() {
	for(var i = 0; i < allLi.length; i++) {
		allLi[i].style.background = defaultBgColor;
	}
}

function removeBgColor() {
	defaultBgColor = 'transparent';
	reset();
}

function addBgColor() {
	defaultBgColor = 'rgb(255, 160, 0)';
	reset();
}
reset(); //渲染嗯~ o(*￣▽￣*)o
start.onclick = function() {
	clearInterval(timer);
	timer = setInterval(change, 500);
}
end.onclick = function() {
	clearInterval(timer);
	reset();
}