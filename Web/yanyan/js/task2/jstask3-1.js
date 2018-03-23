var result = JSON.parse(sessionStorage.getItem("numkey"));//获取numkey数据

var numa = "<div class='row'><div class='block2 g-inlineb'></div><div class='g-inlineb'>杀&nbsp;&nbsp;手&nbsp;1&nbsp;人</div></div>";
//给杀手显示标签赋值给变量numa
var order = [];
var noa = document.getElementById("noa");
var nob = document.getElementById("nob");
var noc = document.getElementById("noc");
var nod = document.getElementById("nod");
var role = document.getElementById("role");
var judge = document.getElementById("judge");
var m_num = document.getElementById("m_num");
var n_num = document.getElementById("n_num");
var fa_num = document.getElementById("fa_num");
var fb_num = document.getElementById("fb_num");

console.log(result.length);
    for (var i=0; i<result.length; i++){
        if(result[i]===numa){
            order[i]=1;
        }else {
            order[i]=2;
        }
    }
sessionStorage.setItem("orderkey",JSON.stringify(order));

console.log(order);

function clicka() {

    if (noa.clickcount) {
        noa.clickcount=Number(noa.clickcount)+1;
    }
    else {
        noa.clickcount=1;
    }

    m_num.innerHTML= noa.clickcount + 1;
    n_num.innerHTML= noa.clickcount ;
    fa_num.innerHTML= noa.clickcount + 1;
    fb_num.innerHTML= noa.clickcount + 1;

    if  (order[noa.clickcount-1]===1) {
        role.innerHTML="角色：杀手";
    }
    else {
        role.innerHTML="角色：平民";
    }

    if(order.length === noa.clickcount){
        judge.innerHTML = "法官查看";
    }

    noa.style.display = "none";
    nob.style.display = "block";
    noc.style.display = "none";
    nod.style.display = "block";
}
function clickb() {
    if(order.length === noa.clickcount){
        location.href="jstask3-3.html";
    }else {
        noa.style.display = "block";
        nob.style.display = "none";
        noc.style.display = "block";
        nod.style.display = "none";
    }
}
