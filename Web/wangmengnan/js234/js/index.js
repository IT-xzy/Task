//播放控件
function play() {
    var audio = document.getElementById('music');
    if (audio.paused) {
        audio.play(); //audio.play();// 音乐播放
    } else {
        audio.pause(); // 暂停
    }
};
//弹出层
function tanchu() {
    var oTanchu = document.getElementById("tanchuchen");
    oTanchu.style.display = "block";
}
function tanchuNone() {
    var oTanchu = document.getElementById("tanchuchen");
    oTanchu.style.display = "none";
}
function randomMath() {
    var oPlayer = $('input[name="zongshu"]').val();
    var arr = []; //定义一个数组
    for (var i = 0; i < parseInt(oPlayer); i++) {
        arr[i] = i; //传0~ n n个数
    }
    arr.sort(function () {
        return 0.5 - Math.random() //把数组打乱
    })
    var str = arr.join();
    var shashou = new Array(Math.round(parseInt(oPlayer) / 3.4));
    for (var i = 0; i < Math.round(parseInt(oPlayer) / 3.4); i++) {
        shashou[i] = '杀手';
    }
    var pingmin = new Array(parseInt(oPlayer) - Math.round(parseInt(oPlayer) / 3.4));
    for (var i = 0; i < parseInt(oPlayer) - Math.round(parseInt(oPlayer) / 3.4); i++) {
        pingmin[i] = '平民';
    }
    var allPeople = shashou.concat(pingmin);
    localStorage.clear();
    localStorage.setItem('allPeople', JSON.stringify(allPeople));
    localStorage.setItem('arr',JSON.stringify(arr));
    var arrEz = [];
    for (var l = 0; l < arr.length; l++) {
        arrEz[l] = allPeople[arr[l]];
    }
    localStorage.setItem('arrEz', JSON.stringify(arrEz));
    sczt(); 
}
$('input').bind('input onBlur', function () {
    var oPlayer = $('input[name="zongshu"]').val(); //获取输入的值
    var oKill = document.getElementById("killer-p"); //获取杀手几个
    var oPlayerp = document.getElementById("player-p"); //获取平民几个
    oKill.innerHTML = Math.round(parseInt(oPlayer) / 3.4); //输入的值除以3.4然后取整，再输入文档
    oPlayerp.innerHTML = parseInt(oPlayer) - Math.round(parseInt(oPlayer) / 3.4);//拿输入的值减去上面的值，输入文档
    var arr1 = ["4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"];
    if ($.inArray(oPlayer, arr1) == -1) {
        tanchu();
    } else {
        oKill.innerHTML = Math.round(parseInt(oPlayer) / 3.4);
        oPlayerp.innerHTML = parseInt(oPlayer) - Math.round(parseInt(oPlayer) / 3.4);
    };
});
function playerpd() {
    var oPlayer = $('input[name="zongshu"]').val();
    randomMath();
    var arr1 = ["4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"];
    if ($.inArray(oPlayer, arr1) == -1) {
        tanchu();
    } else {
        goFapai();
    };
}
// 键盘事件
document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if (e && e.keyCode == 13) {
        playerpd();
    }
}
//跳转页面
function goPeibi() {
    window.location.assign('./peibi.html');
}
function goFapai() {
    window.location.assign('./fapai.html');
}
function sczt(){
    var oPlayer = $('input[name="zongshu"]').val();
    var arrZt = new Array(oPlayer);
    for (var l = 0; l < oPlayer; l++) {
        arrZt[l] = 'alive';
    }  
    localStorage.setItem('arrZt', JSON.stringify(arrZt));
}



