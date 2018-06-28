$(document).ready(function () {
     $('li').hide();
    $('.navlist').click(function () {
        $(this).nextAll().slideToggle('slow');
    });
});