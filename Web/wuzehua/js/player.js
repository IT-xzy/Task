var killer = document.getElementById('killer');
			var flat = document.getElementById('flat');
			var sum = document.getElementById('sum');

			sum.onchange = function() {
				//var value=this.value;
				var value = sum.value;
				if(value < 4) {
					alert("请输入正确的玩家数量");
				} else if(value > 18) {
					alert("请输入正确的玩家数量");
				} else if(value >= 4 && value <= 5) {
					killer.innerHTML = 1;
					flat.innerHTML = value - killer.innerHTML;
				} else if(value > 5 && value <= 8) {
					killer.innerHTML = 2;
					flat.innerHTML = value - killer.innerHTML;
				} else if(value > 8 && value <= 12) {
					killer.innerHTML = 3;
					flat.innerHTML = value - killer.innerHTML;
				} else if(value > 12 && value <= 18) {
					killer.innerHTML = 4;
					flat.innerHTML = value - killer.innerHTML;
				}
			}

			var start = document.getElementById('start');

			start.onclick = function() {
				var arr = [];
				for(var i = 0; i < killer.innerHTML; i++) {
					arr.push('杀手');
				}
				for(var i = 0; i < flat.innerHTML; i++) {
					arr.push('平民');
				}
				arr.sort(function() {
					return 0.5 - Math.random()
				})
				console.log(arr)

				if(!window.localStorage) {
					alert("浏览器不支持localStorage");
					return false;
				} else {
					localStorage.setItem("killer", killer.innerHTML);
					localStorage.setItem("flat", flat.innerHTML);
					localStorage.setItem("arr", arr);
				}
				
			}
			document.getElementsByClassName('revert')[0].onclick = function() {
				window.location.href = "game.html";
			}
			document.getElementById('start').onclick = function() {
				window.location.href = "role.html";
			}






