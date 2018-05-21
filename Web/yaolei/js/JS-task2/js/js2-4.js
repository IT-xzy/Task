var strr = JSON.parse(sessionStorage.getItem("data"));
var i = 0;
$('#div3').hide();
document.getElementById("ppage1").innerHTML=1;
document.getElementById("identity").innerHTML=1;

$("#div1").click(function () {
    var job = strr[i];
    $("#ppage2").text(Number(i)+1);
    $("#job").text(job);
    $("#identity1").text(Number(i)+2);
    $("#page1").hide();
    $("#page2").show();
    if(i === strr.length-1){
        $('#div3').show();
        $('#div2').hide();
    }
});
$("#div2").click(function () {
    i = i + 1;
    $("#ppage1").text(Number(i)+1);
    $("#page2").hide();
    $("#identity").text(Number(i)+1);
    $("#page1").show();
});
$('#div3').click(function () {
    window.location.href='js2-5.html';
})

