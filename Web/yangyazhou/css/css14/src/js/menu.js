;(function(){
    var btnMenu = document.getElementById('btn-menu'),
        menu    = document.getElementById('nav-menu');

    btnMenu.onclick = function() {
        menu.style.display ? menu.style.display = '' : menu.style.display = 'block';
    };
})();