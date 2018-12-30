var playersArray = JSON.parse(sessionStorage.getItem("playersArray")); //提取玩家数组
        console.log(playersArray);
        var killer = sessionStorage.getItem("killer"); //提取杀手数
        var civilian = sessionStorage.getItem("civilian"); //提取平民数
        //console.log(civilian);
        var days = +sessionStorage.getItem("days");//提取天数
        var dieNumber = JSON.parse(sessionStorage.getItem("dieNumber")); //提取死掉的玩家号码数组
        //console.log(dieNumber);
        //提取被投死的数组
        if(sessionStorage.getItem("voteDead")){
            var voteDead = JSON.parse(sessionStorage.getItem("voteDead"));
        }else{
            var voteDead = [];
        }
        console.log(voteDead)
        var choosePlayer;
        var sourceNode = document.getElementById("role1"); //获取源节点
        var box = document.getElementsByClassName("player");
        var number = document.getElementsByClassName("number");
        var btn = document.getElementsByTagName("button")[0]; //获取按钮节点
        window.onload = function () {
            for (let i = 2; i < playersArray.length + 1; i++) {
                var kl = sourceNode.cloneNode(true); //克隆源节点
                sourceNode.parentNode.appendChild(kl); //将克隆的节点添加到源节点后面
                kl.setAttribute("id", "role" + i); // 修改一下id 值，避免id 重复
            }
            var name = document.getElementsByClassName("name");
            for (let i = 0; i < playersArray.length; i++) {
                if (playersArray[i] == 1) {
                    name[i].innerHTML = "杀手";
                }
                number[i].innerHTML = i + 1 + "号";
                box[i].index = i;
                box[i].onclick = function () {
                    for (let i = 0; i < box.length; i++) {
                        box[i].getElementsByTagName("i")[0].style.display = "none";
                        //console.log(box[i])
                    }
                    choosePlayer = box[i].index;
                    console.log(choosePlayer); // 玩家下标
                    box[i].getElementsByTagName("i")[0].style.display = "inline-block";

                }
            }
            for (var i = 0; i < dieNumber.length; i++) {
                name[dieNumber[i] - 1].style.background = "red";
            }

            btn.onclick = function () {
                if (choosePlayer == undefined) {
                    alert("请选择要投死的玩家");
                } else if (name[choosePlayer].style.background == "red") {
                    alert("不能投死亡的玩家");
                } else if (playersArray[choosePlayer] == 1) {
                    //存储投死玩家的信息,放到投死数组里
                    var voteds = (choosePlayer + 1) + "号被投死,真实身份是杀手";
                    voteDead.push(voteds);
                    sessionStorage.setItem("voteDead", JSON.stringify(voteDead));
                    //存储被投死玩家的号码
                    dieNumber.push(choosePlayer + 1);
                    // console.log(dieNumber);
                    sessionStorage.setItem("dieNumber", JSON.stringify(dieNumber));
                    //存储杀手剩余人数
                    killer = killer - 1;
                    sessionStorage.setItem("killer", killer);
                    if (killer >= civilian || killer == 0) {
                        location.href = ("result.html");
                    } else {
                        //存储天数  
                        days += 1;
                        sessionStorage.setItem("days", days);
                        //存储步骤
                        var step = 4;
                        sessionStorage.setItem("step", step);
                        location.href = ("version.html");
                    }
                } else if (playersArray[choosePlayer] == 0) {
                    //存储被投死玩家的信息
                    var voteds = (choosePlayer + 1) + "号玩家被投死,真实身份是平民";
                    voteDead.push(voteds);
                    sessionStorage.setItem("voteDead", JSON.stringify(voteDead));
                    //存储被投死玩家的号码
                    dieNumber.push(choosePlayer + 1);
                    sessionStorage.setItem("dieNumber", JSON.stringify(dieNumber));
                    //存储剩余的玩家
                    civilian = civilian - 1;
                    sessionStorage.setItem("civilian", civilian);
                    console.log(civilian);
                    if (killer >= civilian || killer == 0) {
                        location.href = ("result.html");
                    } else {
                        //存储天数
                        days += 1;
                        sessionStorage.setItem("days",days);
                        //存储步骤
                        var step = 4;
                        sessionStorage.setItem("step", step);
                        location.href = ("version.html");
                    }
                }
            }
        }
        var close = document.getElementsByTagName("div")[0];
        close.onclick = function () {
            if (confirm("确定退出游戏么？")) {
                sessionStorage.clear();
                location.href = ("homepage.html");
            }
        }