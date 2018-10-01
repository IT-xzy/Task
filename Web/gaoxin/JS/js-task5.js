$(document).ready(function () {
    $("#btn").on("click",function () {
        var account = $(".account").val();
        var password = $(".password").val();
    $.post('/carrots-admin-ajax/a/login',
        {
            name: account, pwd: password
        },
        function(data,status) {
        var $data = JSON.parse(data);
            console.log($data);
        if ($data.message === "success") {
            window.location.href = "http://dev.admin.carrots.ptteng.com/";
        }
        else {
            $("#info").text($data.message)
        }
    });
});
});

// document.getElementById("btn").addEventListener("click", function() {
//     var account = document.getElementById("account").value;
//     var password = document.getElementById("password").value;
//     var formElement = new FormData();
//     formElement.append('name',account);
//     formElement.append('pwd', password);
//     var request = new XMLHttpRequest();
//     request.open("POST", "/carrots-admin-ajax/a/login");
//     request.onreadystatechange = function () {
//         var text = JSON.parse(request.responseText);
//         console.log(text);
//         if (text.message === "success"){
//             window.location.href = "http://dev.admin.carrots.ptteng.com/";
//         }
//         else {
//             alert(text.message);
//         }
//     };
//     request.send(formElement);
// });
//
//

