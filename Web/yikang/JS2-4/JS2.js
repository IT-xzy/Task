var entranceNum = document.getElementById('entrance');
var slideNum = document.getElementById('slide');

slideNum.onchange = function () {
    entranceNum.value = slideNum.value;
};

entranceNum.onchange = function () {
    if (entranceNum.value > 3 && entranceNum.value < 19) {
        slideNum.value=entranceNum.value
    } else {
        alert('请输入正确的人数')
    }
};
var left = document.getElementById('left');
left.onclick = function () {
    if (entranceNum.value > 4) {
        entranceNum.value--;
        slideNum.value = entranceNum.value;
    } else {
        alert('人太少了');
    }
};
var right = document.getElementById('right');
right.onclick = function () {
    if (entranceNum.value < 18) {
        entranceNum.value++;
        slideNum.value = entranceNum.value;
    } else {
        alert('人太多了');
    }
};


// function changeVal(operate,val) {
//     if(typeof operate!="number"){
//         alert("输入不合法");
//         return
//     }
//     if(operate>val){
//         operate--
//     }else {
//         operate++
//     }
//     slideNum.value = entranceNum.value;
// }
// left.onclick=function () {
//     changeVal(entranceNum.value,4)
// };
// right.onclick=function () {
//     changeVal(entranceNum.value,4)
// };


var slayer = "<li class='add-slayer'>殺手1人</li>";

var rolm = "<li class='add-flat'>水民1人</li>";

setting.onclick = function () {
    var entrance = [];
    var str = "";
    entrance.length = entranceNum.value;
    var slayer = Math.floor(entranceNum.value / 3);
    var out = [];
    while (out.length < slayer) {
        var stochastic = Math.floor(Math.random() * entranceNum.value);
        if (out.indexOf(stochastic) < 0) {
            out.push(stochastic);
        }
        // console.log(out);
    }
    for (i = 0; i < out.length; i++) {
        entrance[out[i]] = '杀手';
        // console.log(i);
        // console.log(out)
        // console.log(entrance)
    }
    for (i = 0; i < entrance.length; i++) {
        if (entrance[i] !== '杀手') {
            entrance[i] = '平民';
        }
        // console.log(entrance.length)
        // console.log(i)
    }

    var farmer = entrance.filter(function (item) {
        return item === "平民"
    });
    var killer = entrance.filter(function (item) {
        return item === "杀手"
    });
    $('.kill').text(killer.length);
    $('.civilian').text(farmer.length);
    // var p=farmer.length;
    // console.log(farmer.length);
    $(".go").bind('click', function () {
        if (farmer.length < 2) {
            alert('请分配好人数')
        } else {
            window.location.href = 'JS3.html'
        }
    });
    for (var i = 0; i < entrance.length; i++) {
        str += entrance[i];

    }


    // document.getElementById('info').innerHTML = str;
    sessionStorage.setItem('dog', JSON.stringify(entrance));
    console.log("js2  storage===" + JSON.parse(sessionStorage.getItem('dog')));
};
