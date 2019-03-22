if (sessionStorage.j) {
    var j = JSON.parse(sessionStorage.j);
}
if (sessionStorage.killed) {
    var killed = JSON.parse(sessionStorage.killed);
}

if (sessionStorage.byvote) {
    var byvote = JSON.parse(sessionStorage.byvote);
}

if (sessionStorage.initial) {
    var initial = sessionStorage.initial;
} else if(!sessionStorage.initial) {
    var initial = "murder";
}
console.log(j);
var main = document.getElementsByTagName("main")[0];
var headerSpan = document.getElementsByTagName("header")[0].getElementsByTagName("span")[0];
var bBtn = document.getElementsByTagName("footer")[0].getElementsByTagName("button");
var murder = document.getElementsByClassName("murder");
var words = document.getElementsByClassName("words");
var speak = document.getElementsByClassName("speak");
var vote = document.getElementsByClassName("vote");
var row = document.getElementsByClassName("row");
var step = document.getElementsByClassName("step")[0];
var body = document.getElementsByTagName("body")[0];
var fate = document.getElementsByClassName("fate");
var state = sessionStorage.state;
var record = [];
var newP;
// var digit = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十"];
if (sessionStorage.num) {
    var num = JSON.parse(sessionStorage.num);
}
if (num == undefined) {
    var num = 0;
    console.log(num);
} else {
    console.log(num);
    for (var i = num; i > 0; i--) {
        console.log(killed[i]);
            step.innerHTML = '<div class="substep">' +
                '<p onclick="myhide(event)">第'+digited(i-1) +'天</p>' +
                '<div onclick="myFunction(event)" style="display: none;" class="row">' +
                '<p style="background: #999" class="murder"><i style="border-right:8px solid #999"></i>杀手杀人</p>' +
                '<span style="margin-bottom: 10px; display: block; text-align: center; font-size:12px">'+killed[i-1].num+'号被杀手杀死，真实身份是'+killed[i-1].role+'</span>' +
                '<p style="background: #999" class="words"><i style="border-right:8px solid #999"></i>亡灵发表遗言</p>' +
                    '<p style="background: #999" class="speak"><i style="border-right:8px solid #999"></i>玩家依次发言</p>' +
                '<p style="background: #999" class="vote"><i style="border-right:8px solid #999"></i>全民投票</p>' +
                '<span style="font-size:12px; display: block; text-align: center;">'+ byvote[i-1].num + '号被投票投死了，真实身份是' + byvote[i-1].role +'</span>' +
                    '</div></div>' +
                    step.innerHTML;
            console.log(step.innerHTML);
    }
    
    fate[0].innerHTML = "第" + digited(num) + "天";
}

function myFunction(e) {
    var fas = e.target.tagName;
    if (fas == "P") {
        alert("请进行下一项活动");
    }
}

function myhide(e) {
    var fas = e.target;
    var faed = fas.nextSibling;
    if (faed.style.display == "") {
        faed.style.display = "none";
    } else {
        faed.style.display = "";
    }
}
function digited(value) {
    var arr = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十"];
    if (value < 10) {
        return arr[value];
    } else {
        return arr[9] + arr[(value - 10)];
    }
}

function exit() {
    alert("要退出游戏吗");
    sessionStorage.clear();
    location = "homepage.html";
}

function esck() {
    sessionStorage.clear();
    location="chek.html";
}

var fsm = new StateMachine({

    init: initial,
    
    transitions: [
    
      { name: "one", from: "murder", to: "words" },
    
      { name: "two", from: "words", to: "speak"},
    
      { name: "tri",  from: "speak", to: "vote"},
    
        { name: "four", from: "vote", to: "end" },
      { name: "five", from: "end", to: "murder"}
    
    ],
    
    methods: {
        onWords : function () {
            newP = document.createElement("p");
            newP.innerHTML = (j + 1) + "号被杀手杀死，真实身份是平民";
            row[num].insertBefore(newP, words[num]);
            newP.style.marginBottom = "10px";
            newP.style.fontSize = "12px";
            murder[num].style.background = "#999";
            murder[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
            console.log(newP);
        },
        onSpeak: function () {
            if (!newP) {
                newP = document.createElement("p");
                newP.innerHTML = (j + 1) + "号被杀手杀死，真实身份是平民";
                row[num].insertBefore(newP, words[num]);
                newP.style.marginBottom = "10px";
                newP.style.fontSize = "12px";
                murder[num].style.background = "#999";
                murder[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
            }
            words[num].style.background = "#999";
            words[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
            console.log(newP);
        },
        onVote: function () {
            if (!newP) {
                newP = document.createElement("p");
                newP.innerHTML = (j + 1) + "号被杀手杀死，真实身份是平民";
                row[num].insertBefore(newP, words[num]);
                newP.style.marginBottom = "10px";
                newP.style.fontSize = "12px";
                murder[num].style.background = "#999";
                murder[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
            }
            words[num].style.background = "#999";
            words[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
            speak[num].style.background = "#999";
            speak[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
        },
        // onEnd: function () {
        //     if (!newP) {
        //         newP = document.createElement("p");
        //         newP.innerHTML = (j + 1) + "号平民被杀害";
        //         row[num].insertBefore(newP, words[num]);
        //         newP.style.marginBottom = "10px";
        //         murder[num].style.background = "#999";
        //         murder[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
        //     }
        //     words[num].style.background = "#999";
        //     words[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
        //     speak[num].style.background = "#999";
        //     speak[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
        //     vote[num].style.background = "#999";
        //     vote[num].getElementsByTagName("i")[0].style.borderRight = "8px solid #999";
        //     newP = document.createElement("p");
        //         newP.innerHTML = (j + 1) + "号被投票死了";
        //         row[num].appendChild(newP);
        //     newP.style.marginBottom = "10px";
        //     fsm.four();
            
        // }
    }   
    
})
console.log(newP);
console.log(fsm.state);
fate[0].onclick = function () {
    row[num].classList.toggle("d-none");
}
murder[num].onclick = function () {
    if (fsm.state == "murder") {
        sessionStorage.initial = fsm.state;
        sessionStorage.num = JSON.stringify(num);
        location = "murder.html";
    } else {
        alert("请按顺序操作");
    }
}

words[num].onclick = function () {
    if (fsm.state == "words") {
        alert("请死者亮明身份并且发表遗言");
        fsm.two();
        sessionStorage.initial = fsm.state;

    } else {
        alert("请按顺序操作");
    }
}

speak[num].onclick = function () {
    if (fsm.state == "speak") {
        alert("玩家依次发言");
        fsm.tri()
        console.log(fsm.state);
        sessionStorage.initial = fsm.state;
    } else {
        alert("请按顺序操作");
    }
}

vote[num].onclick = function () {
    if (fsm.state == "vote") {
        sessionStorage.num = JSON.stringify(num);
        location = "murder.html";
    } else {
        alert("请按顺序操作");
    }
}
