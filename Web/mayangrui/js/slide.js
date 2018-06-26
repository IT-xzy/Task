/*	window.onload = function() {
	var oActionBlock = document.getElementById('action-block');
	var oActionBar = document.getElementById('action-bar');
	var oScrollBar = document.getElementById('scroll-bar');
	var oShowAmount = document.getElementById('showAmount').getElementsByTagName('input')[0];
	var length = 550;

	clickSlide(oActionBlock, oActionBar, oScrollBar, 300, length, oShowAmount);
	drag(oActionBlock, oActionBar, 300, length, oShowAmount);
	addScale(60, 300, length, oScrollBar);
	inputBlur(oActionBlock, oActionBar, length, oShowAmount);
}		*/

function SlideBar(data){
	var _this = this;
	var oActionBlock = document.getElementById(data.actionBlock);
	var oActionBar = document.getElementById(data.actionBar);
	var oSlideBar = document.getElementById(data.slideBar);
	var barLength = data.barLength;
	var interval = data.interval;
	var maxNumber = data.maxNumber;
	var oShowArea = null;
	if(data.showArea){
		oShowArea = document.getElementById(data.showArea);	
	}

	if(oShowArea){
		_this.addScale(oSlideBar, interval, maxNumber, barLength);
		_this.inputBlur(oActionBlock, oActionBar, maxNumber, barLength, oShowArea);
		_this.clickSlide(oActionBlock, oActionBar, oSlideBar, maxNumber, barLength, oShowArea);
		_this.drag(oActionBlock, oActionBar, maxNumber, barLength, oShowArea);
	}
	else{
		_this.addScale(oSlideBar, interval, maxNumber, barLength);
		_this.clickSlide(oActionBlock, oActionBar, oSlideBar, maxNumber, barLength);
		_this.drag(oActionBlock, oActionBar, maxNumber, barLength);
	}
	
}

SlideBar.prototype = {
	//初始化(添加刻度线)
	addScale : function(slideBar, interval, total, barLength){
		// interval代表刻度之间间隔多少, total代表最大刻度
		// slideBar表示在哪个容器添加刻度

		var num = total / interval; //num为应该有多少个刻度

		for (var i = 0; i < num + 1; i++) {
			var oScale = document.createElement('div');
			oScale.style.width = '2px';
			oScale.style.height = '14px';
			oScale.style.position = 'absolute';
			oScale.style.background = '#AFAFAF';
			oScale.style.zIndex = '-10';
			oScale.style.left = (i * interval * barLength) / total + 'px';
			slideBar.appendChild(oScale);

			var oText = document.createElement('div');
			oText.style.position = 'absolute';
			oText.style.top = '16px';
			oText.style.height = '16px';
			oText.innerHTML = i * interval;
			slideBar.appendChild(oText);
			oText.style.left = ((i * interval * barLength) / total) - (oText.offsetWidth / 2) + 'px';
		}
	},

	// 监听输入框
	inputBlur : function(actionBlock, actionBar, maxNumber, barLength, input){
		//actionBlock指滑块,actionBar指显示条,input指显示的输入框
		var _this = this;
		input.onblur = function(){
			var inputVal = this.value;
			_this.autoSlide(actionBlock, actionBar, maxNumber, barLength, inputVal);
		}
	},

	/* 在输入框输入值后自动滑动	*/
	autoSlide : function(actionBlock, actionBar, total, barLength, inputVal){
		//inputVal表示输入框中输入的值
		var _this = this;
		var target = (inputVal / total * barLength);
		_this.checkAndMove(actionBlock, actionBar, target);
	},

	/*	检查target(确认移动方向)并滑动	*/
	checkAndMove : function(actionBlock, actionBar, target){
		if(target > actionBar.offsetWidth){
			actionBarSpeed = 8;		//actionBar的移动度和方向
		}
		else if(target == actionBar.offsetWidth){
			return;
		}
		else if(target < actionBar.offsetWidth){
			actionBarSpeed = -8;
		}
		
		var timer = setInterval(function(){
			var actionBarPace = actionBar.offsetWidth + actionBarSpeed;

			if(Math.abs(actionBarPace - target) < 10){
				actionBarPace = target;
				clearInterval(timer);
			}
			actionBar.style.width = actionBarPace + 'px';
			actionBlock.style.left = actionBar.offsetWidth - (actionBlock.offsetWidth / 2) + 'px';
		},30);
	},

	/*	鼠标点击刻度滑动块自动滑动	*/
	clickSlide : function(actionBlock, actionBar, slideBar, total, barLength, showArea){
		var _this = this;
		slideBar.onclick = function(ev){
			var ev = ev || event;
			var target = ev.clientX - slideBar.offsetLeft;
			if(target < 0){
				//表示鼠标已经超出那个范围
				target = 0;
			}
			if(target > barLength){
				target = barLength;
			}
			_this.checkAndMove(actionBlock, actionBar, target);
			if(showArea){
				showArea.value = Math.round(target / barLength * total);	
			}
		}
	},

	/*	鼠标按着拖动滑动条	*/
	drag : function(actionBlock, actionBar, total, barLength, showArea){
		/*	参数分别是点击滑动的那个块,滑动的距离,滑动条的最大数值,显示数值的地方(输入框)	*/
		actionBlock.onmousedown = function(ev) {
			var ev = ev || event;
			var thisBlock = this;
			var disX = ev.clientX;
			var currentLeft = thisBlock.offsetLeft;

			document.onmousemove = function(ev) {
				var ev = ev || event;
				var left = ev.clientX - disX;

				if (currentLeft + left <= (barLength - thisBlock.offsetWidth / 2 ) && currentLeft + left >= 0 - thisBlock.offsetWidth / 2) {
					thisBlock.style.left = currentLeft + left + 'px';
					actionBar.style.width = currentLeft + left + (actionBlock.offsetWidth / 2) + 'px';
					if(showArea){
						showArea.value = Math.round(actionBar.offsetWidth / barLength * total);
					}
				}
				return false;
			}

			document.onmouseup = function() {
				document.onmousemove = document.onmouseup = null;
			}

			return false;
		}
	},

	getStyle : function(obj, attr){
		return obj.currentStyle?obj.currentStyle[attr]:getComputedStyle(obj)[attr];
	}
}