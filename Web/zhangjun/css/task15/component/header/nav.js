// 折叠导航栏
window.onload = function () {
    var menu = document.getElementById("menu");
    var collapse = document.getElementById("collapse");
    menu.onclick = function () {
        collapse.style.display = collapse.style.display == "block" ? "" : "block";
    }
}