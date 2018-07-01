let round = JSON.parse(localStorage.getItem("round"));
let tips = JSON.parse(localStorage.getItem("tips"));

$(document).ready(function () { //页面加载后 获取本地对象数据变生成全局变量方便使用
    let length = Math.ceil((tips.length / 2));
    let day = round.day;
    console.log(tips);
    if (length > 1) { //从第二天开始添加html节点代码
        let $list = $("article").html();
        for (let i = 1; i < length; i++) {
            $("article").append($list);
        }
    }
    for (let i = 0; i < day; i++) { //写入天数标题
        $(".day").eq(i).text("第" + (i + 1) + "天");
    }
    for (let i = 0; i < tips.length; i++) {
        $(".p2").eq(i).text(tips[i]);
    }
})