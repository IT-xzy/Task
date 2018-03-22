var playerNum=document.getElementById("playerNum");
var myRange=document.getElementById("myRange");
myRange.onchange=function(){
    playerNum.value = this.value;
};

window.onload = function () {
    //获取dom节点
    var playerMatch = document.getElementById("playerMatch"),
        setBtn = document.getElementById("setBtn"),
        playerNum = document.getElementById("playerNum"),
        myRange = document.getElementById("myRange"),
        less = document.getElementById("less"),
        add = document.getElementById("add");
        // percentage;

    //给发牌按钮添加天机事件，将页面中的玩家数据保存在storage中
    footerBtn.onclick = function () {
        var player = playerMatch.getElementsByClassName("identity");
        var players = [];
        for (var i = 0; i < player.length; i++) {
            players[i] = player[i].textContent.replace(/\s+/g, "").substr(0, 2).split(",", 2) + "";
        }
        sessionStorage.setItem("player", players);
        if (!playerMatch.firstElementChild) {
            alert("玩家还未匹配");
        } else if (playerMatch.querySelectorAll("li").length != playerNum.value) {
            alert("玩家设置未更新");
        } else {
            window.location.href = "Parameter setting.html";
        }
    };
    //向playerMatch中输入内容
    //创建杀手doms
    function killNum() {
        var kill = document.createElement("li");
        kill.textContent = "杀 手 1 人";
        kill.className = "identity kill";
        playerMatch.appendChild(kill);
    }
    //创建水民doms
    function civilianNum() {
        var civilian = document.createElement("li");
        civilian.textContent = "平 民 1 人";
        civilian.className = "identity civilian";
        playerMatch.appendChild(civilian);
    }

    function addContent() {
        var num = playerNum.value;
        playerMatch.innerHTML = null;
        if (num < 4) {
            killNum();
            for (var x = 0; x < 3; x++) {
                civilianNum();
            }

        } else if (num > 18) {
            for (var a = 0; a < 5; a++) {
                killNum();
            }
            for (var b = 0; b < 13; b++) {
                civilianNum();
            }

        } else if (num >= 4 & num < 6) {
            killNum();
            for (var c = 0; c < num - 1; c++) {
                civilianNum();
            }

        } else if (num >= 6 & num < 9) {
            for (var d = 0; d < 2; d++) {
                killNum();
            }
            for (var e = 0; e < num - 2; e++) {
                civilianNum();
            }

        } else if (num >= 9 & num < 12) {
            for (var f = 0; f < 3; f++) {
                killNum();
            }
            for (var g = 0; g < num - 3; g++) {
                civilianNum();
            }

        } else if (num >= 12 & num < 16) {
            for (var h = 0; h < 4; h++) {
                killNum();
            }
            for (var j = 0; j < num - 4; j++) {
                civilianNum();
            }

        } else if (num >= 16 & num <= 18) {
            for (var k = 0; k < 5; k++) {
                killNum();
            }
            for (var l = 0; l < num - 5; l++) {
                civilianNum();
            }

        }
    }

    //随机匹配位置
    setBtn.addEventListener("click", randomContent, false);

    function randomContent() {
        addContent();
        var li = playerMatch.getElementsByTagName("li"),
            liArray = [],
            temp = [],
            playersString = "";
        for (var n = 0; n < li.length; n++) {
            temp[n] = li[n];
        }
        for (var m = 0; m < li.length; m++) {
            var index = Math.floor(Math.random() * temp.length);
            liArray[m] = temp[index];
            temp.splice(index, 1);
        }
        for (var i = 0; i < liArray.length; i++) {
            playersString += liArray[i].outerHTML;
        }
        //将元素字符串添加到playerMatch中
        playerMatch.innerHTML = playersString;
    }
    //初始化滑块和按钮
    playerNum.value = myRange.value = 4;
    //关联输入玩家数和滑块的value值
    playerNum.oninput = function () {
        myRange.value = playerNum.value;
        // changeColor();
    };


    //  限制输入数量在4-18之间，超过区间alert提醒
    playerNum.onchange = function () {
        if (playerNum.value < 4 || playerNum.value > 18) {
            playerNum.value = 4;
            myRange.value = 4;
            alert("请输入正确的玩家数量（4~18人）");
            // changeColor();
        }
    };

      // 用keyCode设置输入框只对键盘上的数字，删除，退格等键位响应

    playerNum.onkeydown = function () {
        if ((event.keyCode !== 46) && (event.keyCode !== 8) && (event.keyCode !== 37) && (event.keyCode !== 39))
            if (!((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)))
                event.returnValue = false;
    };


    //关联滑块和输入玩家数
    myRange.oninput = function () {
        playerNum.value = myRange.value;
        // changeColor();
    };
    //给加减号添加点击事件，关联滑块和输入玩家数
    less.onclick = function () {
        playerNum.value -= 1;
        myRange.value -= 1;
        if (playerNum.value < 4 || myRange.value < 4) {
            playerNum.value = 4;
            myRange.value = 4;
            alert("请输入正确的玩家数量（4~18人）");
        }
        // changeColor();

    };
    add.onclick = function () {
        playerNum.value = parseInt(playerNum.value) + 1;
        myRange.value = parseInt(myRange.value) + 1;
        if (playerNum.value > 18 || myRange.value > 18) {
            playerNum.value = 18;
            myRange.value = 18;
            alert("请输入正确的玩家数量（4~18人）");
        }
        // changeColor();
    };
};
