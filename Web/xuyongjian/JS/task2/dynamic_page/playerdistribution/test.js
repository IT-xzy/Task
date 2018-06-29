let x = 1;

if (x < 5) {
    idButton.onclick = function () {
        identify.style.zIndex = 1;
        hidden.style.zIndex = 2;
        headerNum.style.zIndex = 3;
        hiddenButton.innerHTML = '隐藏并传递给' + ++transferNum + '号';
    };
    hidden.onclick = function () {
        hidden.style.zIndex= 1;
        identify.style.zIndex= 2;
        headerNum.style.zIndex = 3;
        idButton.innerHTML = '查看' + ++viewNum + '号身份';
        headerNum.innerHTML++;
    };}