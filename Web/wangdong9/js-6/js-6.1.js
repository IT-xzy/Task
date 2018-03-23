/**
 * Created by Administrator on 2017/12/26.
 */
/**
 * Created by Administrator on 2017/12/22.
 */
$(document).ready(function () {
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            $('#on').click();
        }
    });
    $('#on').click(function () {
        var user = $('#name').val();
        var pass = $('#pass').val();
        //     var ajax= new XMLHttpRequest();
        //         ajax.onreadystatechange=function () {
        //             if(ajax.readyState==4&&ajax.status==200){
        //                 document.getElementById('#message').innerHTML=ajax.responseText;
        //             }
        //         };
        //         ajax.open('POST','/carrots-admin-ajax/a/login',true);
        //         ajax.send();
        //     });

        $.ajax({
            type:'POST',
            url: '/carrots-admin-ajax/a/login',
            datatype:'json',
            data:{'name':user,
                'pwd':pass
            },
            success:function (data) {
                var data=JSON.parse(data);
                console.log(data);
                if(data.message=='success'){
                    alert('success');
                    // location.href="js-6.2.html"
                     $state.go('.page')
                    
                }
                else {
                    $("#message").html(data.message)
                }
            }
        })
    });
});
