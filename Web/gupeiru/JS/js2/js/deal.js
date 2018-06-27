$(function () {
    back("index.html"); //点击返回按钮返回首页
    hidden(); //点击确定和取消弹框消失
    enter();//enter键等同按钮
    $("#go").on("click", function () { // 去发牌按钮点击事件
        let n = $("#number").val(); //变量n赋值为输入框输入的值
        if (n < 4 || n == "") { //当输入数字<4,弹出确定取消选择提示框
            ask("visible", "27vh auto");
        } else { //如果输入正确则跳转查看身份页面
            $(location).attr('href', "check.html");
        };
    });

    $("#number").on("input", input);

    function input() {
        let n = $("#number").val(); //变量n赋值为输入框输入的值

        $("#number").val(n.replace(/\D/g, ''));

        switch (true) { //判断输入数字进行动态人数分配
            case n >= 4 && n <= 14 || n >= 16 && n <= 17:
                $("#killer").text(Math.floor(n / 3)); //填入杀手人数
                $("#villager").text(n - killer.innerHTML); //填入平民人数
                break;
            case n == 15 || n == 18:
                $("#killer").text(Math.ceil(n / 4));
                $("#villager").text(n - killer.innerHTML);
                break;
            case n > 18: //大于18人数不填入且input值为空
                $("#number").val("");
                $("#killer").text("");
                $("#villager").text("");
                break;
            case n < 4: //小于人数人数不填入
                $("#killer").text("");
                $("#villager").text("");
        };
        let arryKiller = []; //创建一个空数组名为杀手
        for (let i = 0; i < $("#killer").text(); i++) { //给杀手数组添加项
            arryKiller.push("杀手");
        }
        let arryVillager = []; //创建一个空数组名为村民
        for (let j = 0; j < $("#villager").text(); j++) { //给村民数组添加项
            arryVillager.push("平民");
        }
        let gather = arryKiller.concat(arryVillager); //创建新数组名为集合，为杀手和村民的集合
        function shuffle(identity) { //洗牌，让集合数组乱序
            var mix = []; //创建新数组mix，用来储存乱序后的集合数组即乱序后的身份
            while (identity.length) {
                var index = ~~(Math.random() * identity.length); //取随机数
                mix.push(identity[index]); //添加随机项
                identity.splice(index, 1); //删除原项
            }
            // console.log(mix)
            localStorage.setItem("key", JSON.stringify(mix)); //存储乱序后的数组mix即身份数据
        }
        shuffle(gather);

    }
    input(); //自运行一次是默认值运行
});