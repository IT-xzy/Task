(function () {
    var box = document.getElementById('banner'),
    slide = document.getElementsByClassName('slide'),
    prev = document.getElementById('banner-btn-left'),
    next = document.getElementById('banner-btn-right'),
    dots = document.getElementsByClassName('banner-dots')[0].children,
    count = 0,
    leng = slide.length,
    timer = null;

// 切换图片
function changeImg(diraction) {
    // diraction值: 空,next,prev,num;
    // 首次加载页面，diraction值为空;
    // next,prev分别为点击上一张和下一张传来的值;
    // num为点击底部圆点出来的值;
    var prev, next;

    for (var i = 0; i < leng; i++) {
        // 复位
        slide[i].className = 'slide';
        dots[i].className = '';
        // slide[i].style.display = ''; 

        if (diraction === 'prev') {
            prev = 'slide next-left';
            next = 'slide active prev-left';

            // 判断是否是最后一张
            if (count === leng - 1) {
                slide[0].style.display = 'block';
                slide[0].className = prev;
            } else {
                slide[count + 1].style.display = 'block';
                slide[count + 1].className = prev;
            }
        } else if (diraction === 'next' || diraction == null){
            prev = 'slide prev-right';
            next = 'slide active next-right';

            // 判断是否是第一张
            if (count === 0) {
                slide[leng - 1].style.display = 'block';
                slide[leng - 1].className = prev;
            } else {
                slide[count - 1].style.display = 'block';
                slide[count - 1].className = prev;
            }
        } else { 
            if (count > diraction) {
                prev = 'slide prev-right';
                next = 'slide active next-right';
            } else {
                prev = 'slide next-left';
                next = 'slide active prev-left';
            }
            slide[diraction].style.display = 'block';
            slide[diraction].className = prev;
        }
        
        slide[count].className = next;
        dots[count].className = 'active';
    }

}

//自动切换图片
function autoPlay() {
    timer = setInterval(function () {
        count++;
        if (count >= leng) {
            count = 0;
        }
        changeImg();
    }, 3000);
}
autoPlay();

// 鼠标移入，暂停切换
box.onmouseover = function () {
    clearInterval(timer);
};

// 鼠标移出，继续切换
box.onmouseout = function () {
    autoPlay();
};       

// 下一张
next.onclick = function () {
    count++;
    if (count >= leng) {
        count = 0;
    }
    changeImg('next');
};

// 上一张
prev.onclick = function () {
    count--;
    if (count < 0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ) {
        count = leng - 1;
    }
    changeImg('prev');
};

// 点击小圆点切换图片
for (var i = 0; i < leng; i++) {
    (function (i) {
        dots[i].onclick = function () {
            var num = count;
            count = i;
            changeImg(num);
        }
    })(i);
}
})();