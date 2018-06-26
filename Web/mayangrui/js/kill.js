var kills = JSON.parse(localStorage.getItem('kills'));
var day = JSON.parse(localStorage.getItem('day'));
var dead = JSON.parse(localStorage.getItem('dead'));
window.onload = function auto() {
    for (i = 0; i < kills.length; i++) {
        var txt1 = $("<div></div>").text(kills[i].identity).addClass("name");
        var txt2 = $("<div></div>").text(i + 1).addClass("num");
        var txt3 = $("<li></li>").addClass("card1");
        if (kills[i].state === "dead") {
            $(txt3).addClass("red1");
            $(".content").append(txt3);
            $(txt3).append(txt1, txt2);
        } else {
            $(".content").append(txt3);
            $(txt3).append(txt1, txt2);
        }

    }
};



// $(document).ready(function () {
//     $(".card1").click(function () {
//         // $(".card1").removeClass("red");
//         console.log($(this));
//         // var index = $(this).index();
//         // if (kills[index].state === "dead") {
//         //     alert("请杀活人");
//         // }
//         // else if (kills[index].identity === "杀手") {
//         //     alert("自己人兄dei")
//         // } else {
//         //
//         //     // $(this).addClass("red");
//         //     // localStorage.setItem('index', JSON.stringify(index));
//         // }
//     });
// });

//
function jump() {
    var index = localStorage.getItem('index', JSON.stringify(index));
    dead.push(kills[index]);
    kills[index].state = "dead";
    kills[index].kmode = "killdead";
    kills[index].ktime = day;
    localStorage.setItem('dead', JSON.stringify(dead));
    localStorage.setItem('index', JSON.stringify(index));
    localStorage.setItem('kills', JSON.stringify(kills));
    localStorage.setItem('day', JSON.stringify(day));

    var aliveevilmen = kills.filter(function (item, index, array) {
        return (item.identity === "杀手" && item.state === "alive");
    });
    var alivegoodmen = kills.filter(function (item, index, array) {
        return (item.identity === "平民" && item.state === "alive");
    });
    if (alivegoodmen.length + 1 - aliveevilmen.length < 2) {
        var txt1 = "杀手胜利";
        var txt2 = "80%的杀手";
        localStorage.setItem('outcome1', JSON.stringify(txt1));
        localStorage.setItem('outcome2', JSON.stringify(txt2));
        window.location.href = "task4outcome.html";

    }
    else if (alivegoodmen.length + 1 - aliveevilmen.length > 2 && aliveevilmen.length === 0) {
        var txt3 = "平民胜利";
        var txt4 = "20%的平民";
        localStorage.setItem('outcome1', JSON.stringify(txt3));
        localStorage.setItem('outcome2', JSON.stringify(txt4));
        window.location.href = "task4outcome.html";
    }
    else {
        window.location.href = "task4-2.html";
    }
}