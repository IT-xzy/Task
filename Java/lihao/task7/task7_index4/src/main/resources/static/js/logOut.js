/**
 * Created by odd-hoo on 2017/12/19.
 */
$(function () {
    $('.log-out').click(function () {
        if (confirm('是否关闭初号机？')) {
            window.location.href = '../index.html';
        }
    });
});

