const players = JSON.parse(localStorage.getItem("players")); // 获取本地存储的身份数据
var round = JSON.parse(localStorage.getItem("round"));
var checked;

//如果是第一次进入页面 就创建玩家对象和提示文本数组
function init() {
    let player_arr = []; //玩家对象数
    let tips = []; //死亡提示数组
    for (let i = 0; i < players.length; i++) {
        let obj = new Object();
        obj.number = i; //序号
        obj.name = players[i]; //身份
        obj.state = "alive"; //状态
        obj.day = " "; //死亡日期
        obj.death = " "; //死亡时间
        player_arr.push(obj);
    };
    player_arr = JSON.stringify(player_arr); //获得数组并转为字符串
    localStorage.setItem("players_dom", player_arr); //保存在本地

    tips = JSON.stringify(tips);
    localStorage.setItem("tips", tips);
}

//页面加载完成后启动函数
$(document).ready(function () {
    if (round == undefined) { //判断是否第一次进入页面
        console.log("第一次进入页面")
        init();
    }
    player_arr = JSON.parse(localStorage.getItem("players_dom")); // 获取本地对象数组
    tips = JSON.parse(localStorage.getItem("tips"));
    console.log(player_arr);
    console.log(round);
    readState();
})


//游戏运行判断规则函数
function readState() {
    //遍历数组中每个合法对象，生成玩家DOM节点，活着的打印，死亡状态的改变背景颜色
    for (let i = 0; i < players.length; i++) {
        $(".list").eq(i).css("display", "block"); //生成节点
        $(".box-a").eq(i).text(players[i]); //写入身份
        var obj = player_arr[i];
        if (obj.state != "alive") {
            $(".box-a").eq(obj.number).css("background-color", "#999"); //改变已经死亡玩家的背景色
        }
    }

    if (round == null) { //开始游戏 点击跳转
        $("#start").html("开始游戏").click(function () { //直接跳转
            window.location.href = "./05.html";
        });
    } else { //绑定点击事件 交给杀人规则函数判断是否跳转
        $("#start").html("确定").click(judge);
        $(".box").click(function () { //绑定点击事件获得index值 保存在变量checked里
            checked = ($(".box").index(this));
            console.log("选中了" + (checked + 1) + "号玩家");
        })
    }
}


function judge() { //杀人或投票规则
    if (checked == undefined) {
        alert("请选择目标");
        return;
    }
    let obj = player_arr[checked];

    switch (round.time) {
        case "黑夜":
            if (obj.name != "狼人" && obj.state == "alive") {
                obj.state = "杀死";
                obj.day = round.day;
                obj.death = "黑夜";
                tips.push(((obj.number + 1) + "号被狼人杀死，真实身份是" + obj.name));

                console.log(obj);
                //对象状态保存在本地
                player_arr = JSON.stringify(player_arr);
                localStorage.setItem("players_dom", player_arr);
                tips = JSON.stringify(tips);
                localStorage.setItem("tips", tips);

                victory();
            } else if (obj.name == "狼人") {
                alert("请爱护狼队友！");
            } else if (obj.state != "alive") {
                alert("请不要鞭尸！");
            }
            break;


        case "白天":
            if (obj.state == "alive") {
                obj.state = "投死";
                obj.day = round.day;
                obj.death = "白天";
                tips.push(((obj.number + 1) + "号被玩家投死，真实身份是" + obj.name));
                console.log(obj);
                //对象状态保存在本地
                player_arr = JSON.stringify(player_arr);
                localStorage.setItem("players_dom", player_arr);
                tips = JSON.stringify(tips);
                localStorage.setItem("tips", tips);

                victory();
            } else {
                alert("请不要鞭尸！");
            }
            break;
    }
}

function victory() {
    player_arr = JSON.parse(localStorage.getItem("players_dom")); // 获取本地对象数组
    let killer = 0;
    let farmer = 0;
    for (let i = 0; i < players.length; i++) {
        if (player_arr[i].state == "alive") {
            if (player_arr[i].name == "狼人") {
                killer++;
                console.log("狼人剩余"+killer);
            } else {
                farmer++;
                console.log("村民剩余"+farmer);
            }
        }
    }

    if (killer == farmer) {
        window.location.href = "./06.html";

    }else if (killer == 0) {
        window.location.href = "./06.html";
        return;
    }else{
        window.location.href = "./05.html";
    }
}