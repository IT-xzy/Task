/**
 * Created by Administrator on 2017/11/26/026.
 */


var lFarmer=JSON.parse(localStorage.getItem('lFarmer'));
var lKiller=JSON.parse(localStorage.getItem('lKiller'));
var objdead=JSON.parse(localStorage.getItem('objdead'));
var objbill=JSON.parse(localStorage.getItem('objbill'));

console.log(lKiller);
console.log(lFarmer);
console.log(objdead);
console.log(objbill);

$(document).ready(function () {

    var day = objbill.length + 1;

    console.log(day);

    for (i = 1; i < day; i++) {
        var y = objdead[i-1].num+1;
        var x = objdead[i-1].name;
        var l = objbill[i-1].num+1;
        var k = objbill[i-1].name;
        var analyse=$("<div></div>").addClass("analyse");
        var daytime = $("<div></div>").addClass(".process-text").text( y+ "号被杀死，其真实身份是" + x);
        var night = $("<div></div>").addClass(".process-text").text(l + "号被投死，其真实身份是" + k);
        var analyseday = $("<div></div>").addClass("analyse-day").text("第" + i + "天");
        $(".winner-message").after(
            analyse.append(analyseday)
        );
        analyseday.after(daytime).after(night);
// console.log();

    }
    if(lFarmer.length===lKiller.length){
        $(".winner-name").text("卧底胜利")
    }else{
        $(".winner-name").text("平民胜利")
    }







});