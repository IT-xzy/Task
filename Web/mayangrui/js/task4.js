var kills=JSON.parse(localStorage.getItem('killInit'));
window.onload=function auto() {
    for(i=0;i<kills.length;i++) {
        var txt1 = $("<div></div>").text(kills[i]).addClass("name");
        var txt2=$("<div></div>").text(i+1).addClass("num");
        var txt3=$("<li></li>").addClass("card1");
        $(".content").append(txt3);
        $(txt3).append(txt1,txt2);
    }
};
function jump() {
    function aliveordead() {
        var temp=[];
        var gameprocess="none";
        var day=1;
        var dead=[];
        for(i=0;i<kills.length;i++){
            temp.push({
                state:"alive",
                identity:kills[i],
                number:i+1,
                kmode:"notyet",
                ktime:"notyet"
            });
        }
        localStorage.setItem('kills', JSON.stringify(temp));
        localStorage.setItem('day', JSON.stringify(day));
        localStorage.setItem('dead',JSON.stringify(dead));
        localStorage.setItem('step', JSON.stringify(gameprocess));
    }
    aliveordead();
    window.location.href="task4-2.html";

}