function back() {
    window.location.href = "set.html"
}
function home() {
    sessionStorage.removeItem('dieNum');
    sessionStorage.removeItem('dieList');
    sessionStorage.removeItem('K');
    sessionStorage.removeItem('P');
    window.location.href = "home.html"
}