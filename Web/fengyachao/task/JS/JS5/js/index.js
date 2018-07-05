
$(document).ready(function () {
    $('#login').click(function () {
        var name = $('#name').val();
        var password = $('#password').val();
        console.log(name);
        console.log(password);
        $.post('/carrots-admin-ajax/a/login', {
            name: name,
            pwd: password
        },
            function (data, status) {
                console.log(status);
                var jsons = JSON.stringify();
                console.log(jsons.message);
                if(jsons.code === 0){
                    window.location.href = "test.html";
                }else {
                    $('#hint').html(jsons.message);
                }
            });
    });
});
