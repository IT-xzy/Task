//头部返回关闭js文件
(function(){
    var back= document    .getElementById('backBtn'),
        close= document.querySelector('header .close-icon');
        
   back.addEventListener('click', function () {
        window.history.go(-1);
   }, false);
   close.addEventListener('click', function () {
       var r = confirm("您确定离开游戏吗？");
       if (r == true) {
           window.location.href = "headerPage.html";
       }
   }, false);
})();