var civilian_win = JSON.parse(sessionStorage.getItem("平民组"));
var killer_win =  JSON.parse(sessionStorage.getItem("杀手组"));
var rrrsul = JSON.parse(sessionStorage.getItem("rrrsul")) ;
var condition = JSON.parse(sessionStorage.getItem("对象组"));
var x_day = JSON.parse(sessionStorage.getItem("be_killed")) ;

var day = Math.floor((x_day.length + 1)/2) - 1 ;
console.log(day) ;

var u = sessionStorage.getItem("u");
var a =document.getElementById("resss") ;
var b = document.getElementById("killer_number") ;
var c = document.getElementById("civilian_number") ;
var z = document.getElementById("body7");

b.innerHTML= killer_win.length ;
c.innerHTML= civilian_win.length ;


if( rrrsul == 0 ){
    a.innerHTML ="杀手胜利" ;
}else{
    a.innerHTML ="平民胜利" ;
}
for (i = 0; i < day; i++) {
    var html = z.innerHTML;
    z.innerHTML =
        html +
        "<div class = \"body5\">\n" +
        "第" +
        "&nbsp;" +
        "&nbsp;" +
        "<span>" +
        (i + 1) +
        "</span>" +
        "&nbsp;" +
        "&nbsp;" +
        "天" +
        "</div>" +
        "<div class=\"body6\">\n" +
        "晚上：" +
        // "<span class = \"kill_1\">\n" +
        (x_day[i * 2] + 1) +
        // "</span>\n" +
        "号被杀手杀死了" +
        "<span class=\"kill_1\"> " +
        (x_day[i * 2] + 1) +
        "</span>" +
        "号是" +
        condition[x_day[i * 2]].name +
        "</div>\n" +
        "<div class=\"body6\" >\n" +
        "白天：" +
        (x_day[i * 2 + 1] + 1) +
        "号被全民投票投死" +
        "，" +
        "他的身份是" +
        condition[x_day[i * 2 + 1]].name +
        "</div>";
    console.log(z.innerHTML);
}

if ((x_day.length % 2) === 1) {
    var html = z.innerHTML;
    z.innerHTML =
        html +
        "<div class = \"body5\">\n" +
        "第" +
        "&nbsp;" +
        "&nbsp;" +
        "<span>" +
        (day + 1) +
        "</span>" +
        "&nbsp;" +
        "&nbsp;" +
        "天" +
        "</div>" +
        "<div class=\"body6\">\n" +
        "晚上：" +
        // "<span class = \"kill_1\">\n" +
        (x_day[x_day.length - 1] + 1) +
        // "</span>\n" +
        "号被杀手杀死了" +
        "<span class=\"kill_1\"> " +
        (x_day[i * 2] + 1) +
        "</span>" +
        "号是平民" +
        "</div>\n"

}



function clear1() {
    sessionStorage.removeItem("对象组") ;
    sessionStorage.removeItem("随机组") ;
    sessionStorage.removeItem("杀手组") ;
    sessionStorage.removeItem("平民组") ;
    sessionStorage.removeItem("civilian") ;
    sessionStorage.removeItem("condition") ;
    sessionStorage.removeItem("step") ;
    sessionStorage.removeItem("kill_rell") ;
    sessionStorage.removeItem("w");
    sessionStorage.removeItem("u") ;
    sessionStorage.removeItem("p") ;
    sessionStorage.removeItem("rrrsul");
    sessionStorage.removeItem("be_killed") ;
    location.href="../1_index.html" ;
}
