//滑动条加减
$(".less").click(function(){
    let num = $("#range").val();
    let nn = Number(num)-1;
        if (3<num<17) {
        $("#range").val(nn);
        console.log(num)
            let shuri = $("#digital").val();
            let ss = $("#range").val();
            $("#digital").val(ss);
            chan()
    } else {
        alert("数字不要超过4和18，谢谢");
    }
});
$(".plus").click(function(){
    let num = $("#range").val();
    let nnn = Number(num)+1;
    if (3<num<17) {
        $("#range").val(nnn);
        // nnn = $("#digital").val();
        // shuri  = $("#range").val(nnn);
            console.log(nnn)
        let shuri = $("#digital").val();
        let ss = $("#range").val();
        $("#digital").val(ss);
        chan()
    } else {
        alert("数字不要超过4和18，谢谢");
    }
});
// 这是关联滑动条跟玩家人数的代码

$("#range").change(function(){
    let shuri = $("#digital").val();
    let ss = $("#range").val();
    $("#digital").val(ss);
    chan()
});

$("#digital").change(function(){
    let shuri = $("#digital").val();
    let ss = $("#range").val();
    $("#range").val(shuri);
    chan();
});


//改变玩家人数




function chan() {
    let num = $("#range").val();
    let number =  Number(num);
    if (number<5) {
        $("#kill").text("1");
        let ss =Number(number)-1;
        $("#water").text(ss);
        return 1;
    }
    else if (number<9) {
        $("#kill").text("2");
        let ss =Number(number)-2;
        $("#water").text(ss);
        return 2;
    }
    else if (number<13) {
        $("#kill").text("3");
        let ss =Number(number)-3;
        $("#water").text(ss);
        return 3;
    }
    else if (number<17) {
        $("#kill").text("4");
        let ss =Number(number)-4;
        $("#water").text(ss);
        return 4;
    }
    else{
        $("#kill").text("5");
        let ss =Number(number)-5;
        $("#water").text(ss);
        return 5;
    }
}
//限制输入人数
$("#digital").change(function(){
    change ()
});
function change (){
    let digital = $("#digital").val();
    let digita = $("#digital");
    if (digital>18) {
        alert("玩家不能超过18人")
        digita.val(18);
    }
    else if (digital<4) {
        alert("玩家不能少于4人")
        digita.val(4);
    }
    else {

    }
    return digital;
};
//
console.log (chan())
function renarr() {
    let number = Number($("#digital").val());

    var sha = Math.ceil(number * 0.25);
    let shui = number - sha;
    var aa = [];
    for (var i = 0; i < sha; i++) {
        var d = "杀手";
        aa.push(d);
    }
    //b后面为平民
    var bb = [];
    for (var i = sha; i < number; i++) {
        var d = "平民";
        bb.push(d);
    }
    var cc = aa.concat(bb);
    //经典的洗牌算法，但是不够随机。
    // function shuffle(cc) {
    //     return cc.concat().sort(function (cc,b) {
    //         return Math.random() - 0.5;
    //     })
    // }
    Array.prototype.shuffle = function () {
        var input = this;

        for (var i = input.length - 1; i >= 0; i--) {

            var randomIndex = Math.floor(Math.random() * (i + 1));
            var itemAtIndex = input[randomIndex];

            input[randomIndex] = input[i];
            input[i] = itemAtIndex;
        }
        return input;
    }
    return cc.shuffle();
}

    $(".bottom-vote").click(function(){
        // let ren =JSON.stringify(renarr());
        // sessionStorage.setItem("key", ren);
        localStorage.setItem('Arr', JSON.stringify(renarr()));
    });




// localStorage.setItem("key",renarr());
// fill的方法，首先生成一个全部的数组，所有人数。
// var 人数 = fill(shuiming);
// 第二步，声明一个杀手的变量，
// let sha = 杀手；
// 最后一步填充。
// 人数.fill("杀手", 0, sha);




