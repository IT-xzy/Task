var backBtn = document.getElementById("backBtn"), // 返回按钮的id
    closeBtn = document.getElementById("closeBtn"), // 关闭按钮的id
    container = document.getElementById("container"), // 大盒子的id。所有的玩家都在里面
    submit = document.getElementById("submit");// 按钮的id

//给玩家设置生死状态
// 获取本地存储数据分割成数组
// sessionStorage是本地存储的对象，getItem() 是他下面的方法，split() 是 字符串分割的方法，连起来就是获取本地存储值，并用逗号隔开。
// split(',')这个方法就直接分割成字符串数组

var player = sessionStorage.getItem("player").split(",");
// 对象里面循环加对象，数据格式就是{{}，{}，{}……}
// 类数组
// 第一行设置了一个空对象
// 后面for循环把属性加到这个对象里面
var playerState = {};
for (var i = 0; i < player.length; i++) {
    playerState[i] = {
        identity: player[i],
        num: i + 1,
        state: "live",
        date: sessionStorage.day,
        how: ""
    };
}

//给页面添加内容和样式
function killContent() {
    document.getElementById("title").textContent = "杀人";
    document.getElementById("titleText").textContent = "杀手请睁眼，杀手请选择要杀的对象";
    document.getElementById("titleTips").textContent = "点击下方玩家头像，对被杀的玩家进行标记";
}

function voteContent() {
    document.getElementById("title").textContent = "投票";
    document.getElementById("titleText").textContent = "发言讨论，大家开始投票";
    document.getElementById("titleTips").textContent = "点击得票数最多的人的头像";
}

// 获取存在本地container对应的键值，并设置为container这个dom 要渲染的内容 （后面那个只是本地存储key的命名，前面那个应该是获取的dom）
container.innerHTML = sessionStorage.getItem("container");

// 从sessionStorage获取数据"page"    数据为“kill时 执行killContent()”否则执行vote()
if (sessionStorage.getItem("page") == "kill") {
    killContent();
} else {
    voteContent();
}

//给死亡玩家设置样式
//获取sessionStorage里key为playerState的值，用json.parse方法解析后返回。
//循环判断
//JSON.parse() 方法用来解析JSON字符串，构造由字符串描述的JavaScript值或对象。
if (sessionStorage.playerState) {
    var playerState = JSON.parse(sessionStorage.getItem("playerState"));
    for (var i = 0; i < container.getElementsByClassName("wrap").length; i++) {
        if (playerState[i].state == "dead") {
            container.getElementsByClassName("wrap")[i].className = "wrap wrap-unClickable";
        }
    }
}


//给头部按钮添加点击事件
closeBtn.addEventListener("click", function () {
    if (confirm("确定关闭？")) {
        window.location.href = "type of play.html";
        sessionStorage.clear();
    }
}, false);

backBtn.addEventListener("click", function () {
    window.location.href = "Game steps.html";
    sessionStorage.removeItem("back");
}, false);

//建立玩家必杀点击效果
var num,
    identity;
container.addEventListener("click", function (e) {
    console.log(e.currentTarget);
    var a = e.currentTarget.getElementsByClassName("wrap");
    console.log(a);

    for (var i = 0; i < a.length; i++) {
        a[i].classList.remove("wrap-knife");
    }
    if (e.target && e.target.parentNode.nodeName.toLowerCase() == "div" && !e.target.parentNode.classList.contains("wrap-unClickable")) {
        e.target.parentNode.classList.add("wrap-knife");
        num = parseInt(e.target.parentNode.lastElementChild.textContent) ;
        console.log(num);
        identity = e.target.parentNode.firstElementChild.textContent;
        console.log(identity);
    }
});


submit.addEventListener("click", function () {
    var killResult = "";
    var killNum = 0,
        civilianNum = 0,
        array = [],
        gameResult = "";
    if (sessionStorage.getItem("page") == "kill") {

        if (identity === "杀手") {
            alert("杀手不能杀杀手，只能杀平民。");
        } else {
            if (num) {
                playerState[num - 1].state = "dead";
                playerState[num - 1].how = sessionStorage.getItem("page");
                playerState[num - 1].date = sessionStorage.getItem("day");
                killResult = num + "号被杀手杀死，真实身份是" + playerState[num - 1].identity;
                for (var n = 0; n < container.getElementsByClassName("wrap").length; n++) {
                    array[n] = playerState[n];
                }
                killNum = array.filter(function (item, index, array) {
                    for (var i = 0; i < array.length; i++) {
                        if (item.state == "live" && item.identity == "杀手") {
                            return item;
                        }
                    }
                });
                civilianNum = array.filter(function (item, index, array) {
                    for (var i = 0; i < array.length; i++) {
                        if (item.state == "live" && item.identity == "平民") {
                            return item;
                        }
                    }
                });

                if (killNum.length === 0) {
                    gameResult = "平民胜利";
                    window.location.href = "result.html";
                    sessionStorage.setItem("gameResult", gameResult);
                } else if (killNum.length == civilianNum.length) {
                    gameResult = "杀手胜利";
                    window.location.href = "result.html";
                    sessionStorage.setItem("gameResult", gameResult);
                } else {
                    window.location.href = "Game steps.html";
                }

                sessionStorage.setItem("array", JSON.stringify(array));
            } else {
                killResult = "杀手没有杀人";
                window.location.href = "Game steps.html";
            }
            sessionStorage.setItem("playerState", JSON.stringify(playerState));
            var killState = "unClickable";
            sessionStorage.setItem("killState", killState);
            sessionStorage.setItem("killResult", JSON.stringify(killResult));
        }
    } else {
        var voteResult = "";
        if (!num) {
            alert("请投票");
        } else {
            playerState[num - 1].state = "dead";
            playerState[num - 1].how = sessionStorage.getItem("page");
            playerState[num - 1].date = sessionStorage.getItem("day");
            for (var m = 0; m < container.getElementsByClassName("wrap").length; m++) {
                array[m] = playerState[m];
            }
            killNum = array.filter(function (item, index, array) {
                for (var i = 0; i < array.length; i++) {
                    if (item.state == "live" && item.identity == "杀手") {
                        return item;
                    }
                }
            });
            civilianNum = array.filter(function (item, index, array) {
                for (var i = 0; i < array.length; i++) {
                    if (item.state == "live" && item.identity == "平民") {
                        return item;
                    }
                }
            });

            if (killNum.length === 0) {
                gameResult = "玩家胜利";
                window.location.href = "result.html";
                sessionStorage.setItem("gameResult", gameResult);
            } else if (killNum.length == civilianNum.length) {
                gameResult = "杀手胜利";
                window.location.href = "result.html";
                sessionStorage.setItem("gameResult", gameResult);
            } else {
                sessionStorage.setItem("day", parseInt(sessionStorage.day) + 1);



                window.location.href = "Game steps.html";
            }
            voteResult = num + "号被投票投死，真实身份是" + playerState[num - 1].identity;
            sessionStorage.setItem("playerState", JSON.stringify(playerState));
            sessionStorage.setItem("voteResult", JSON.stringify(voteResult));
            sessionStorage.setItem("killState", "clickable");
            sessionStorage.setItem("array", JSON.stringify(array));
            sessionStorage.removeItem("killResult");
        }
    }

}, false);


