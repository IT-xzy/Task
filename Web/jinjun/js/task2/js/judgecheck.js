function storage() {


    let storedPeople = JSON.parse(localStorage.getItem("peopleArray"));
    console.log(storedPeople);
    return storedPeople;

}


$(document).ready(function () {

    for (let i = 0; i < storage().length ; i++) {

    let txt=$("<div class=\"boxNumber\"></div>")  // 使用 jQuery 创建文本
       .append(`<div class=\"people\">${storage()[i]}</div>`)
       .append(`<div class=\"number\">${i+1}号</div>`);
    $(".box").append(txt);

    }

    $("#x").click(
        function show_confirm()
        {
            let r=confirm("结束本轮游戏吗");
            if (r===true)
            {
                location.href="index.html";
            }
            else
            {
            }
        }
    );

    $("#button").click(function () {
        localStorage.removeItem("dayNum");
        localStorage.removeItem("state");
        localStorage.removeItem("dieArray");
        localStorage.removeItem("dieOrder");
        window.open("game.html","_self");
    });
});

