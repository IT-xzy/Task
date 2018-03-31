$(document).ready(function () {

        $('#studentName').focus(function () {
            $('#tip').html("<font color='#B03469'><b>活动期间，报名免费</b></font>");
        });

        $('#signup_button').click(function () {
            if ($('#studentName').val() == '') {
                $('#tip').html("<font color='#B03469'><b>请输入姓名</b></font>");
                return false;
            }

            if ($('#studentName').val().length < 4 || $('#studentName').val().length > 10) {
                $('#tip').html("<font color='#B03469'><b>长度4-10字符</b></font>");
                return false;
            }

            var nameReg = /[^a-zA-Z0-9一-龥]/;

            if (nameReg.test($('#studentName').val())) {

                $('#tip').html("<font color='red'><b>用户名不能含有非法字符</b></font>");
                return false;
            } else {
                $.ajax({
                    type: 'POST',
                    url: '/a/u/newone',
                    dataType: 'json',
                    data: {studentName: $('#studentName').val()},
                    async: true,
                    success: function (data) {
                        console.log(data)
                        var code = data.code;
                        var info = data.info;
                        if (code == "ok") {
                            $('#loginCue').html("<font color='#1e941e'><b>√ 报名成功 </b></font>");
                            location.reload(true);
                        } else {
                            $('#loginCue').html("<font color='#B00A08'><b>" + info + "</b></font>");
                            return false;
                        }
                    }

                })
            }
        })

    }
)