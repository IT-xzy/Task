
$('backBtn').on('click',function(){
    $(location).attr('href','allot.html');    
});
$('.close-icon').on('click',function(){
    var r = confirm("您确定离开游戏吗？");
    if (r == true) {
        window.location.href = "headerPage.html";
    }
           
})