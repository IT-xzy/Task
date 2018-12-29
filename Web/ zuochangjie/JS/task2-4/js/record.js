var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
        console.log(playersArray);
        var sourceNode = document.getElementsByClassName("player");
        var number = document.getElementsByClassName("number");
         //提取死掉的玩家号码数组
         if (sessionStorage.getItem("dieNumber")) {
            var dieNumber = JSON.parse(sessionStorage.getItem("dieNumber"));
        } else {
            var dieNumber = [];
        }    
        console.log(dieNumber);
        window.onload = function () {
            for (let i = 0; i < playersArray.length - 1; i++) {
                var cloneNode = sourceNode[0].cloneNode(true);
                cloneNode.setAttribute("id", "role" + i); // 修改一下id 值，避免id 重复 
                sourceNode[0].parentNode.appendChild(cloneNode);
            }
            var name = document.getElementsByClassName("name");
            for (let i = 0; i < playersArray.length; i++) {
                if (playersArray[i] == 1) {
                    name[i].innerHTML = "杀手";
                }
                number[i].innerHTML = i + 1 + "号";
            }
            for (let i = 0; i < dieNumber.length; i++) {
                name[dieNumber[i] - 1].style.background = "red";
                console.log(name[dieNumber[i]-1])
            }
        }
        document.getElementsByTagName("button")[0].onclick = function () {
            location.href = ('version.html');
        }