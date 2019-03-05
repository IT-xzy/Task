var slider = document.getElementsByName("slider")[0];
var Input = document.getElementsByName("Input")[0];
var killer = document.getElementById("killer");
var civilian = document.getElementById("civilian");

slider.style.background = 'linear-gradient(to right, #fbb435, white ' + slider.value * 5 + '%, white)';

function byValue() {
    if (Input.value < 4 || Input.value > 18) {
        killer.innerHTML = ""
        civilian.innerHTML = "";
    } else if (Input.value > 14) {
        killer.innerHTML = Math.floor(Input.value / 3 - 1);
        civilian.innerHTML = Input.value - killer.innerHTML;
    } else {
        killer.innerHTML = Math.floor(Input.value / 3);
        civilian.innerHTML = Input.value - killer.innerHTML;
    }


    slider.style.background = 'linear-gradient(to right, #fbb435, white ' + slider.value * 5 + '%, white)';

}

slider.oninput = function () {
    Input.value = slider.value;
    byValue();
}

Input.oninput = function () {
    var pattern = /[^0-9]/g;
    if (pattern.test(Input.value)) {
        Input.value = Input.value.replace(pattern, "");
    }
    slider.value = Input.value;
    byValue();
}

Input.onchange = function () {
    if (Input.value < 4 || Input.value > 18) {
        alert("请输入正确的玩家数量")
        Input.value = "";
    }
}

document.getElementsByClassName("menus")[0].onclick = function () {
    slider.value--;
    Input.value = slider.value;
    byValue();
}

document.getElementsByClassName("add")[0].onclick = function () {
    slider.value++;
    Input.value = slider.value;
    byValue();
}

document.getElementById("deal").onclick  = function(){
    if (Input.value < 4 || Input.value > 18) {

    } else {
        var data = [killer.innerHTML, civilian.innerHTML];
        var send = JSON.stringify(data);
        sessionStorage.data = send;
        location = "chek.html";
    }

}