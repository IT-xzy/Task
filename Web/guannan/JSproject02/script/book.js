"use strict";

$(document).ready(function() {
//有限状态机
//创建一个控制天数的有限状态机$day
	var $day = new StateMachine({
		init: '0',
		transitions: [
			{ name: 'pass', from: '0', to: '1'},
			{ name: 'pass', from: '1', to: '2'},
			{ name: 'pass', from: '2', to: '3'},
			{ name: 'pass', from: '3', to: '4'},
			{ name: 'pass', from: '4', to: '5'},
			{ name: 'pass', from: '5', to: '6'},
			{ name: 'pass', from: '6', to: '7'},
			{ name: 'pass', from: '7', to: '8'},
			{ name: 'pass', from: '8', to: '9'},
			{ name: 'pass', from: '9', to: '10'}
		],
		methods: {
			onPass: function() {
				let $index = parseInt($day.state);
				let $stepIndex = $index * 4;
				var $chinaNum = ["一", "二", "三", "四", "五", "六", "七", "八", "九"];
					
				$(".step").removeClass("done");

				let $clone1 = $(".day").eq(0).clone();
				let $clone2 = $(".menu").eq(0).clone();
				$("main").append($clone1);
				$("main").append($clone2);


				$(".day").eq($index - 1).addClass("up");
				$(".menu").eq($index - 1).hide();


				$(".day").eq($index).removeClass("up");
				$(".menu").eq($index).show();
				
				$(".day").eq($index).text(function() {
					return "第" + $chinaNum[$index] + "天";
				});
			}
		}
	});

//创建一个控制阶段的有限状态机$stage
	var $stage = new StateMachine({
		init: 'ready',
		transitions: [
			{ name: 'step1', from: 'ready', to: 'kill' },
			{ name: 'step2', from: 'kill', to: 'words' },
			{ name: 'step3', from: 'words', to: 'speech' },
			{ name: 'step4', from: 'speech', to: 'vote' },
			{ name: 'reset', from: '*', to: 'ready' }
		],
		methods: {
			onStep1: function() {
				$(".step").eq(parseInt($day.state) * 4).addClass("done");
			},
			onStep2: function() {
				$(".step").eq(parseInt($day.state) * 4 + 1).addClass("done");
			},
			onStep3: function() {
				$(".step").eq(parseInt($day.state) * 4 + 2).addClass("done");
			},
			onStep4: function() {
				$(".step").eq(parseInt($day.state) * 4 + 3).addClass("done");
			}
		}
	});

//刷新判断状态
	var $stageCheck = window.sessionStorage.getItem('stages');
	//console.log("stagecheck" + $stageCheck);

	function refresh() {
		let $dayCheck = window.sessionStorage.getItem('days');
		//console.log("daycheck" + $dayCheck);

		for (let $x = 0; $x < $dayCheck; $x++) {
			$day.pass();
		}

		let $index = parseInt($day.state);
		let $stepIndex = $index * 4;

		for (let $x = 0; $x < $stepIndex; $x++) {
			$(".step").eq($x).addClass("done");
		}

		if ($stageCheck == "1") {
			$stage.step1();
		}
		else if ($stageCheck == "2") {
			$stage.step1();
			$stage.step2();
		}
		else if ($stageCheck == "3") {
			$stage.step1();
			$stage.step2();
			$stage.step3();
		}
		else if ($stageCheck == "4") {
			$stage.step1();
			$stage.step2();
			$stage.step3();
			$stage.step4();
		}
		else {
			$stage.reset();
		}
		//提取历史记录history并判断、增加hint的内容
		let $historyObj = JSON.parse(window.sessionStorage.getItem('history'));
		if ($historyObj != null) {
			$(".hint").each(function() {
				let $hintIndex = $(".hint").index($(this));
				if ($hintIndex < ($historyObj.length * 2)) {
					if ($hintIndex % 2 == 1) {
						let $historyIndex = ($hintIndex - 1) / 2;
						$(this).text($historyObj[$historyIndex].history2);
					}
					else {
						let $historyIndex = $hintIndex / 2;
						$(this).text($historyObj[$historyIndex].history1);
					}
				}
			});
		}
	}
	refresh();

//Buttons
//根据天数声明索引
	var $index = parseInt($day.state);
	var $stepIndex = $index * 4;

//返回建
	$("#back").click(function() {
		window.location.href = "./journal.html";
	});

//查看法官日志按钮
	$("#journal").click(function() {
		window.sessionStorage.setItem('flag', "1");
		window.location.href = "./journal.html";
	});

//点击下拉收起
	$(".day").on("click", function() {
		var x = $(".day").index($(this));
		if ($(this).is(".up")) {
			$(".menu").eq(x).slideDown("slow");
			$(this).removeClass("up");
		}
		else {
			$(".menu").eq(x).slideUp("slow");
			$(this).addClass("up");
		}
	});

//杀手杀人按钮
	$(".step").eq($stepIndex).on("click", function() {
		if ($stage.is('ready')) {
			alert("请杀手杀人");
			window.sessionStorage.setItem('stages', "1");
			window.location.href = "./mark.html";
		}
		else {
			alert("请继续后面的步骤");
		}
	});

//遗言按钮
	$(".step").eq($stepIndex + 1).on("click", function() {
		if ($stage.is('kill')) {
			alert("请亡灵发表遗言");
			$stage.step2();
			window.sessionStorage.setItem('stages', "2");
		}
		else if ($stage.is('ready')) {
			alert("请按步骤进行游戏");
		}
		else {
			alert("请继续后面的步骤");
		}
	});

//玩家发言按钮
	$(".step").eq($stepIndex + 2).on("click", function() {
		if ($stage.is('words')) {
			alert("请玩家依次发言");
			$stage.step3();
			window.sessionStorage.setItem('stages', "3");
		}
		else if ($stage.is('ready') || $stage.is('kill')) {
			alert("请按步骤进行游戏");
		}
		else {
			alert("请继续后面的步骤");
		}
	});

//全民投票按钮
	$(".step").eq($stepIndex + 3).on("click", function() {
		if ($stage.is('speech')) {
			alert("请玩家开始投票");
			$stage.step4();
			window.sessionStorage.setItem('stages', "4");
			let $dayCheck = window.sessionStorage.getItem('days');
			$dayCheck++;
			//console.log($dayCheck);
			window.sessionStorage.setItem('days', $dayCheck);
			window.location.href = "./mark.html"
		}
		else if ($stage.is('ready') || $stage.is('kill') || $stage.is('words')) {
			alert("请按步骤进行游戏");
		}
		else {
			alert("请继续后面的步骤");
		}
	});

//清空sessionStorage
	function clear() {
		window.sessionStorage.clear();
	}

//关闭按钮
	function closewin(){
	    if (navigator.userAgent.indexOf("Firefox") != -1 || navigator.userAgent.indexOf("Chrome") !=-1) {
	        window.location.href="about:blank";
	        window.close(); 
	    } else {
	        window.opener = null;
	        window.open("", "_self");
	        window.close();
	    }
	}
	$("#close").on("click", function() {
		if (confirm("确认关闭？")) {
			closewin();
			clear();
		}
	});

//结束游戏
	$("#end").on("click", function() {
		if (confirm("确认结束游戏？")) {
			clear();
			window.location.href = "./home.html";
		}
	});
});