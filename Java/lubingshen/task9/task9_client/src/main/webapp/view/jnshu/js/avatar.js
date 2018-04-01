$(document).ready(function () {

        var input = document.getElementById("avatar");
        input.addEventListener('change', readFile, false);
        var fileName;
        var fileSize;

        function readFile() {
            var file = this.files[0];
            if (file) {
                fileName = file.name;
                fileSize = file.size;
                console.log("文件名:" + fileName);
                console.log("文件大小:" + fileSize);
            } else {
                fileName = undefined;
                fileSize = undefined;
            }
        }

        $('#avatar_button').click(function () {

            if (!fileName || !fileSize) {
                $('#tip').html("<font color='#B03469'><b>还未选择上传图片</b></font>");
                return false;
            }

            if (fileSize > 5242880) {
                $('#tip').html("<font color='#B03469'><b>图片大小限制为5MB</b></font>");
                return false;
            }

            var imgReg = /.*?\.(jpg|png)$/;

            if (!imgReg.test(fileName)) {

                $('#tip').html("<font color='red'><b>文件类型错误，只允许上传png或jpg图片</b></font>");
                return false;
            } else {
                $.ajax({
                    url: '/a/u/avatar',
                    type: 'POST',
                    cache: false,
                    dataType: 'json',
                    data: new FormData($('#uploadAvatar')[0]),
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        console.log(data);
                        var code = data.code;
                        var info = data.info;
                        if (code == "ok") {
                            $('#tip').html("<font color='#1e941e'><b>√ 上传成功 </b></font>");
                            location.href = "/a/u/myMessage"
                        } else {
                            $('#tip').html("<font color='#B00A08'><b>" + info + "</b></font>");
                            return false;
                        }
                    }
                })

            }
        })

    }
);