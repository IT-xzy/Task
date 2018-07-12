var init = function () { //如果读不到round信息，就创建round对象到本地
    var round = localStorage.getItem("round");
    if (round == undefined) {
        round = {
            day: 1,
            step: 0,
            time: "未知"
        }
        round = JSON.stringify(round);
        localStorage.setItem("round", round); //保存对象在本地
    }
}();


$(document).ready(function () { //页面加载后 获取本地对象数据变生成全局变量方便使用
    let round = JSON.parse(localStorage.getItem("round"));
    let day = round.day;

    if (day > 1) { //从第二天开始添加html节点代码
        let $list = $("main").html()
        for (let i = 1; i < day; i++) {
            $("main").append($list);
        }
    }
    for (let i = 0; i < day; i++) { //写入天数标题
        $(".day").eq(i).text("第" + (i + 1) + "天");
    }
    draw();
})

function draw() {
    round = JSON.parse(localStorage.getItem("round"));
    step = round.step;

    let tips = JSON.parse(localStorage.getItem("tips"));
    console.log(round);
    console.log(round.day);
    
    //索引低于步数的选项
    for (let i = 0; i < step; i++) {
        $(".list-click").eq(i).css("background-color", "#999").unbind().click(function () {
            alert("已经结束的回合");
        });
        $(".list-css").eq(i).css("border-right", ".1rem solid #999");
        $(".tips").eq(i).text(tips[i]);//输入提示文字
    }
    //索引高于步数的选项
    for (let i = step + 3; i > step; i--) {
        $(".list-click").eq(i).unbind().click(function () {
            alert("请先进行前置回合");
        });
    }
    //绑定点击事件函数
    $(".list-click").eq(step).unbind().click(function () {
        execute();
    });
}

function execute() {
    console.log(round);


    switch (step % 4) {
        case 0:
            round.step++;
            round.time = "黑夜";
            round = JSON.stringify(round);
            localStorage.setItem("round", round);
            window.location.href = "04.html";
            break;

        case 1:
            round.step++;
            round.time = " ";
            round = JSON.stringify(round);
            localStorage.setItem("round", round);
            alert("请死亡玩家亮明身份并发表遗言");
            draw();
            break;

        case 2:
            round.step++;
            round.time = " ";
            round = JSON.stringify(round);
            localStorage.setItem("round", round);
            alert("请玩家依次发言阐述观点");
            draw();
            break;

        case 3:
            round.step++;
            round.day++;
            round.time = "白天";
            round = JSON.stringify(round);
            localStorage.setItem("round", round);
            window.location.href = "04.html";
            break;

        default:
            alert("出错了");
    }
}