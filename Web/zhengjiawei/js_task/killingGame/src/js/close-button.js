$(function () {

    // $('.popup').hide(); /* 弹窗默认隐藏 */

    $('.close-box').on('click', function () {
        // $('.popup').show();
        $('.popup').css('display','flex');
    }) /* 点击关闭按钮弹窗确定、取消按钮 */

    $('.affirm').on('click', function () {
        sessionStorage.clear();
        window.location.href = "playerRatio.html";
    }) /* 点击确定键返回至分配页面 */

    $('.cancel').on('click', function () {
        $('.popup').hide();
    }) /* 点击取消键隐藏弹窗 */
})