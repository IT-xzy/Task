var result = document.getElementById("result");
var killer = document.getElementById("killer");
var civilian = document.getElementById("civilian");
var people = JSON.parse(sessionStorage.getItem("people"));
var killerNum = 0, civilianNum = 0;

for(var i = 0; i < people.length; i++){
    if(people[i].id === "杀 手"){
        killerNum++;
    } else {
        civilianNum++;
    }
}
killer.textContent = "杀手" + killerNum + "人";
civilian.textContent = "平民" + civilianNum + "人";
