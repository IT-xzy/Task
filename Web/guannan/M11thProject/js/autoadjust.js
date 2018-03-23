(function (doc, win) {
        //  html   
            var docEl = doc.documentElement,
                resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize', recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
                docEl.style.fontSize = 10 * (clientWidth / 720 ) + 'px';
                };
            if (!doc.addEventListener) return; win.addEventListener(resizeEvt, recalc, false);
                recalc();
            })(document, window); 
/*移动端适应大小*/