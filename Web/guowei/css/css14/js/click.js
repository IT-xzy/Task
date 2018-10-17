document.getElementById("navbtn").onclick = navbtn;

function listClasses() {
    var classlist = document.getElementById("nav").classList;
    results.innerHTML = "Current classes: "
    for (var i = 0; i < classlist.length; i++) {
        results.innerHTML += classlist[i] + " ";
    }
}

function navbtn() {
    document.getElementById("nav").classList.toggle("show");
}
