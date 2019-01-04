var playersArray = JSON.parse(sessionStorage.getItem("playersArray")); //获取玩家数组
        console.log(playersArray)
        var sourceNode = document.getElementById("role1"); // 获得被克隆的节点对象 
        // console.log(sourceNode);
        var number = document.getElementsByClassName("number"); //获取数字节点
        var a = 0;

        window.onload = function () {
            var name = document.getElementsByClassName("name"); //获取角色名称节点
            for (var i = 2; i < playersArray.length + 1; i++) {
                var clonedNode = sourceNode.cloneNode(true); // 克隆节点 
                clonedNode.setAttribute("id", "role" + i); // 修改一下id 值，避免id 重复 
                sourceNode.parentNode.appendChild(clonedNode); // 在父节点插入克隆的节点 
                // console.log(sourceNode.parentNode.nodeName);
            }
            for (var i = 0; i < playersArray.length; i++) {
                if (playersArray[a] == 0) {
                    name[i].innerHTML = "平民";
                    a++;
                } else if (playersArray[a] == 1) {
                    name[i].innerHTML = "杀手";
                    a++;
                }
                number[i].innerText = i + 1 + "号";
            }
        }
        document.getElementsByTagName("button")[0].onclick = function () {
            location.href = ('version.html');
        }