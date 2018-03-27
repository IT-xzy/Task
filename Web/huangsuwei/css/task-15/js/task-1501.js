function myfunc() {

    var showlist = document.getElementById('showlist');

    var navlist = document.getElementById('navlist');

    var mainfather = document.getElementById('mainfather');

    if (navlist.classList.contains("nav-list-up") == true){

        navlist.classList.remove("nav-list-up");

        navlist.classList.add("nav-list-down");

        mainfather.classList.remove("main-pos");

        mainfather.classList.add("mian-down");

    }

    else {

        navlist.classList.add("nav-list-up");

        navlist.classList.remove("nav-list-down");

        mainfather.classList.add("main-pos");

        mainfather.classList.remove("mian-down");
    }
}