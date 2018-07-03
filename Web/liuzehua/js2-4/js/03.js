const players = JSON.parse(localStorage.getItem("players")); // 获取本地存储的身份数据
console.log(players); //身份数组


var btn = document.getElementsByClassName("btn")[0];
btn.addEventListener("click", function () {
    obj.transition()
}); // 点击事件


var num = 1; // 当前显示的玩家位置号码
var x = 1; //查看x号身份,隐藏并传递给x号玩家
var imgFace = document.getElementsByClassName("img-face")[0]; //正面图
var imgWow = document.getElementsByClassName("img-wow")[0]; //反面图
var number = document.getElementsByClassName("number")[0];
var btn = document.getElementsByClassName("btn")[0];
var txt = document.getElementsByClassName("txt")[0];


//面向对象
var obj = {
    //状态
    init: "查看",

    transition: function () {
        if (x == (players.length + 1)) {
            this.init = "法官查看";
        };
        if (num > players.length) {
            window.location.href = "./04.html";
            return;
        };
        

        switch (this.init) {
            case "查看":
                this.init = "翻牌";
                imgFace.style.display = "block"; //显示正面图片
                imgWow.style.display = "none"; //隐藏反面图片
                btn.innerHTML = "查看" + x + "号身份";
                txt.innerHTML = "";
                x++;
                number.innerHTML = num;
                break;

            case "翻牌":
                this.init = "查看";
                imgFace.style.display = "none"; //显示正面图片
                imgWow.style.display = "block"; //隐藏反面图片
                btn.innerHTML = "隐藏并传递给" + x + "号";
                txt.innerHTML = players[num - 1]; //因数组从0开始所以减1
                num++; //翻牌一次玩家位置号码+1
                number.innerHTML = num;
                break;

            case "法官查看":
                imgFace.style.display = "none"; //隐藏正面图片
                imgWow.style.display = "block"; //显示反面图片
                btn.innerHTML = "法官查看";
                txt.innerHTML = players[num - 1]; //因数组从0开始所以减1
                num++;
                break;
        }
    }
}
window.onload = obj.transition();