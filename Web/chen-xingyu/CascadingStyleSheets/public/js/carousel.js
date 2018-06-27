;(function($){
	$.fn.carousel = function(param){
		var carousel = param.carousel;
		var list = $(carousel).children("li");
		var indexContainer = param.indexContainer;
		var prev = param.prev;
		var next = param.next;
		var timing = param.timing;
		var animateTime = param.animateTime;
		var auto = param.auto;
		var timer;
		for(var i = 1;i <= list.length;i++){
			$(indexContainer).append("<li>"+i+"</li>")
		}
		var indexList = $(indexContainer).children("li");
		$(list[0]).addClass("on").fadeIn(animateTime);
		$(indexList[0]).addClass("index")
		if(auto){
			startTiming();
			/*鼠标进入停止计时，离开开始计时*/
			$(carousel+","+prev+","+next+","+indexContainer).hover(function(){
				window.clearInterval(timer);
			},function(){
				startTiming();
			});
		}

		/*开始计时方法*/
		function startTiming(){
			timer = window.setInterval("$.switchImg();",timing);
		};

		$(prev).off("click").on("click",function(){
			var on = $(carousel).children(".on");
			on.stop(true,true).fadeOut(animateTime).removeClass("on");
			if(on.prev().is("li")){
				$.switchIndex($(carousel).children("li").index(on.prev()));
				on.prev().stop(true,true).addClass("on").delay(animateTime/2).fadeIn(animateTime);
			}else{
				$.switchIndex($(carousel).children("li").index(list[list.length-1]));
				$(list[list.length-1]).stop(true,true).addClass("on").delay(animateTime/2).fadeIn(animateTime);
			}

		});
		$(next).off("click").on("click",function(){
			var on = $(carousel).children(".on");
			on.stop(true,true).fadeOut(animateTime).removeClass("on");
			if(on.next().is("li")){
				$.switchIndex($(carousel).children("li").index(on.next()));
				on.next().stop(true,true).addClass("on").delay(animateTime/2).fadeIn(animateTime);
			}else{
				$.switchIndex($(carousel).children("li").index(list[0]));
				$(list[0]).stop(true,true).addClass("on").delay(animateTime/2).fadeIn(animateTime);
			}
		});

		$(indexList).off("click").on("click",function(){
			if ($(this).attr("class") != "index") {
				var on = $(carousel).children(".on");
				var index = $(this).index();
				console.log(index);
				$(indexList).removeClass("index");
				$(indexList[index]).addClass("index");
				on.stop(true,true).fadeOut(animateTime).removeClass("on");
				$(list[index]).stop(true,true).addClass("on").delay(animateTime/2).fadeIn(animateTime);
			}
		});

		/*切换当前索引*/
		$.extend({switchIndex:function(index){
			$(indexList).removeClass("index");
			$(indexList[index]).addClass("index");
		}});

		/*定时切换图片*/
		$.extend({switchImg:function(){
			var on = $(carousel).children(".on");
			on.stop(true,true).fadeOut(animateTime).removeClass("on");
			if(on.next().is("li")){
				$.switchIndex($(carousel).children("li").index(on.next()));
				on.next().stop(true,true).addClass("on").delay(animateTime/2).fadeIn(animateTime);
			}else{
				$.switchIndex($(carousel).children("li").index(list[0]));
				$(list[0]).stop(true,true).addClass("on").delay(animateTime/2).fadeIn(animateTime);
			}
		}});
	}
})(jQuery);