$('.nav-content').hide();
$(".nav-list").click(function(){
    $(this).next('.nav-content').slideToggle(300);
});