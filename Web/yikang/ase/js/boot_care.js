//拖拽
jQuery(document).ready(
    function () {
        $('.top1').mousedown(
            function (event) {
                var isMove = true;
                var abs_x = event.pageX - $('div.wrap').offset().left;
                var abs_y = event.pageY - $('div.wrap').offset().top;
                $(document).mousemove(function (event) {
                        if (isMove) {
                            var obj = $('div.wrap');
                            obj.css({'left': event.pageX - abs_x, 'top': event.pageY - abs_y});
                        }
                    }
                ).mouseup(
                    function () {
                        isMove = false;
                    }
                );
            }
        );
    }
);

//    $('.erray-one').click(function (e) {
//        var offpage = '{ "category": "Click", "action": "F0028", "data": [] }';
//        $('#wrap').hide();
//        $("#wrap").removeClass("active");
//        CallNativeMethod('report_big_data', offpage);
//        CallNativeMethod('close_window', '');
//    });
//    点击设置
$(".setting").click(function (e) {
    var popset = '{ "category": "Click", "action": "F0026", "data": [] }';
    // $('#wrap').hide();
    // $("#wrap").removeClass("active");
    CallNativeMethod('report_big_data', popset);
    CallNativeMethod('start_pc_manager', '/settings');
    // CallNativeMethod('close_window', '');
})

if (typeof CallNativeMethod == "undefined") {
    window.CallNativeMethod = function () {
        try {
            console.dir(arguments);
        } catch (e) {
        }
    }
}

// //超时关闭页面
// var timeout, mover;
// timeout = 60;
//
// function showout() {
//     timeout--;
//     if (timeout == 0) {
//         console.log("超时自动关闭")
//         var AutoOff = '{ "category": "Click", "action": "F0030", "data": [] }';
//         CallNativeMethod('report_big_data', AutoOff);
//         $('#wrap').hide();
//         $("#wrap").removeClass("active");
//         CallNativeMethod('close_window', '');
//     } else {
//         mover = setTimeout("showout()", 1000);
//     }
// }
//
// showout()
//
// $("#wrap").click(function (e) {
//     var target = e.target;
//     if (target != "") {
//         clearTimeout(mover);
//     }
// });


JsMethodForNative('set_data', JSON.stringify({
    boot_time: 70,
    soft_count: 0,
    data_server: {
        "code": "100",
        "data": [{
            "date": 1510156800000,
            "landingPage": "cfcdcdecdc",
            "contentId": "294397",
            "loginRequired": true,
            "contentName": "20171109",
            "openWith": 2,
            "cloudeserviceType": 102,
            "h5url": "https://priv-update.lenovo.com.cn/startupmanager/thinkpad/template1/bootcare_lv/boot_care.html",
            "picUrl": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511335218&di=aaae1b86a7dff1e12fe5196c70d80b97&imgtype=jpg&er=1&src=http%3A%2F%2Fpic35.photophoto.cn%2F20150418%2F0008020936302275_b.jpg",
            "nurl": "https://clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJCeNmtp00mb0k_J_tVX00j2gQzA0rSBy4eIL6ysjup-Hp1VFTmRLRKGKScyi1CjGW0YELc9hkH0mm0pxjRwZ0VMNl07BC0mm040HkNuRh3EGLAibZmwIR_620mm0FDJ7Luiun2MpdQBQ07Sf07Bk0pxVNUcs4nJ80mm07Z707Z707c707zx07AW0XYPK07c70mu0jQCrhBCWvrbR75ekXSHhmWxLgje1eRX_ZdL0gekEcXFdcpTRHDhRa07C7&s=Jn4Pe8b40A45_4lfM0pcYO&w=0",
            "adId": 765,
            "openWith": "0",
            "targetUrl": "https://clk.lenovo.com.cn/lenovo/click?a=YH6XJCeNmtp00mb0k_J_tVX00j2gQzA0rSBy4eIL6ysjup-Hp1VFTmRLRKGKScyi1CjGW0YELc9hkH0mm0pxjRwZ0VMNl07BC0mm040HkNuRh3EGLAibZmwIR_620mm0FDJ7Luiun2MpdQBQ07Sf07Bk0pxVNUcs4nJ80mm07Z707Z707c707zx07AW0XYPK07c70mu0jQCrhBCWvrbR75ekXSHhmWxLgje1eRX_ZdL0gekEcXFdcpTRHDhRa07C7&s=Jn4Pe8b40A45_4lfM0pcYO",
            "targetTabTitle": "Think专享"
        }],
        "message": "success"
    }
}));


//交互
var obj, objs, objx, obji;

function JsMethodForNative(method_name, method_params) {

    obj = JSON.parse(method_params);
    var a = obj.data_server;
    var c = a.data[0];
    var d = c.picUrl;

    // 判断图片是否加载成功
    $('<img/>').attr('src', d).load(function () {
        $(this).remove();
        $('.header').css('background', 'url(' + d + ')')
        $('#wrap').show()


        var b = {
            err_code: 0,
            err_msg: "ok",
            data: {
                message_type: 1,
                message: {
                    // http_url: "http://10.100.18.90/online/boot_care.html",
                    http_url: c.h5url,
                    theme: c.id,
                    action: {
                        type: 1,
                        target: "",
                        note: c.targetUrl,
                        isToken: true,
                    }
                }
            }
        }
        // if (c.launchOutside == true) {
        //     // web
        //     b.data.message.action.type = 2;
        //     b.data.message.action.target = "";
        // }
        // if (c.launchOutside == false) {
        //     //app
        //     b.data.message.action.type = 1;
        //     b.data.message.action.target = "LenovoPrivilege.exe";
        //     b.data.message.action.note = '-url:' + c.landingPage.trim() + ' -tab:' + c.targetTabTitle.trim() + ' -from:boot';
        // }
        if (c.openWith == 0) {
            // 智慧联想
            b.data.message.action.type = 0;
            b.data.message.action.target = "SmartHome.exe";
            b.data.message.action.note = '-id:' + c.targetTabTitle.trim() + ' ' + '-url:' + c.landingPage.trim();
        }
        if (c.openWith == 1) {
            // 特权
            b.data.message.action.type = 1;
            b.data.message.action.target = "LenovoPrivilege.exe";
            b.data.message.action.note = '-url:' + c.landingPage.trim() + ' -tab:' + c.targetTabTitle.trim() + ' -from:boot';
        }
        if (c.openWith == 2) {
            //网页
            b.data.message.action.type = 2;
            b.data.message.action.target = "";
        }
        // 上报 ase
        $.get(c.nurl);

        // function reportAseClick() {
        //     // 上报 ase
        //     $.get(c.targetUrl);
        //     // var str = JSON.stringify(c.targetUrl);
        //     // console.log(c,c.targetUrl)
        // }

        obj.data_server = b;

        function reportAseClick() {
            // 上报 ase
            $('<img/>').attr('src', c.targetUrl)
            // var str = JSON.stringify(c.targetUrl);
            // console.log(c,c.targetUrl)
        }

        var H5url = '[{ "key": "adverturl", "value": "' + obj.data_server.data.message.http_url + '" }, { "key": "title", "value": "' + c.title + '" }, { "key": "adverID", "value": "' + c.id + '" }] ';

        // 显示上报
        CallNativeMethod('report_big_data', '{ "category": "business", "action": "F0032", "data": ' + H5url + ' }');


        if (method_name == 'set_data') { // 初始化
            //开机时间显示
            var num = parseInt(obj.boot_time), count = 0;//obj.time
            var timeshow = setInterval(function () {
                var min = Math.floor(num / 60);
                var second = num % 60;
                $(".cou-list3").text(count);
                $(".cou-list1").text(min);
                if (second == count) {
                    clearInterval(timeshow);
                }
                count++;
            }, 50);
            if (obj.soft_count > 0) {
                $(".speed-up").html("哎呀！<label>" + obj.soft_count + "</label>项自启动建议优化!");
                $(".btn-icon-one").text("立即加速");

                //点击按钮
                $(".btn-icon-one").click(function (e) {
                    CallNativeMethod('start_pc_manager', '/startacce');
                    var openbstart = '{ "category": "Click", "action": "F0022", "data": [] }';
                    CallNativeMethod('report_big_data', openbstart);
                    // $('#wrap').hide();
                    // $("#wrap").removeClass("active");
                    // CallNativeMethod('close_window', '');
                })
            } else {
                $(".speed-up").text("电脑健康，从体检开始！");
                $(".btn-icon-one").text("立即体检");
                //点击按钮
                $(".btn-icon-one").click(function (e) {
                    CallNativeMethod('start_pc_manager', '/docmd:homepage');
                    var openpage = '{ "category": "Click", "action": "F0025", "data": [] }';
                    CallNativeMethod('report_big_data', openpage);
                    // $('#wrap').hide();
                    // $("#wrap").removeClass("active");
                    // CallNativeMethod('close_window', '');
                })
            }
            // alert(obj.data_server.data.message.action.note)


            var journalismUrl = 'https://dsp.lenovo.com.cn/lenovo/bid?positionId=50119&clientType=api' + '&lenovoId=' + CallNativeMethod('get_user_id', '') + '&uname=' + CallNativeMethod('get_real_user_name', '') + '&pctype=' + CallNativeMethod('get_mt', '') + '&lpsust=' + CallNativeMethod('get_st', '') + '&mac=' + CallNativeMethod('get_mac', '') + '&sn=' + CallNativeMethod('get_sn', '') + '&version=' + CallNativeMethod('get_version', '');
            objx = CallNativeMethod('http_get', journalismUrl)
            obji = {
                "code": "100",
                "data": [{
                    "adi": "https://mt.lenovo.com.cn/test/c/569/46e492e7-f37c-44f7-981c-cb760b4bcbb71435349310617386789.jpg",
                    "landingPage": "//mini.eastday.com/a/180523000917650.html?qid=lxkjzs",
                    "contentId": "0008_9223370509849418157",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Ky3BK0Xnap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS4osNHvyW6lc7adHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=Fcxv26AqoQwQjzyEHK75XI",
                    "updateTime": 1527005357650,
                    "source": "江湖报",
                    "title": "王峰十问罗永浩 锤子也要搞区块链了？2018-05-23 17:05:31",
                    "categoryName": "科技",
                    "contentName": "王峰十问罗永浩 锤子也要搞区块链了？",
                    "cloudeserviceType": 101,
                    "index_seq": 25,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Ky3BK0Xnap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS4osNHvyW6lc7adHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=Fcxv26AqoQwQjzyEHK75XI&w=0",
                    "pageViews": 83,
                    "categoryId": "keji"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/737/a2bca76d-7932-4356-bd1e-ffe1aea320283779024280804037787.jpg",
                    "landingPage": "//mini.eastday.com/a/180522171031926.html?qid=lxkjzs",
                    "contentId": "0008_9223370509874543881",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Ke3BK0Xjap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oY7ijGvM3bvIdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=3bzgcKwEbzgokkwTZE_Hzf",
                    "updateTime": 1526980231926,
                    "source": "站长之家",
                    "title": "王峰十问罗永浩 锤子科技目前财务状况及前景泄露2018-05-23 17:05:31",
                    "categoryName": "科技",
                    "contentName": "王峰十问罗永浩 锤子科技目前财务状况及前景泄露",
                    "cloudeserviceType": 101,
                    "index_seq": 22,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Ke3BK0Xjap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oY7ijGvM3bvIdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=3bzgcKwEbzgokkwTZE_Hzf&w=0",
                    "pageViews": 44,
                    "categoryId": "keji"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/1013/d484befe-f6fe-4a3d-85e5-d15e8308bfb64352401372172284538.jpg",
                    "landingPage": "//mini.eastday.com/a/180522231936953.html?qid=lxkjzs",
                    "contentId": "0005_9223370509852398854",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Kn3BK0XNap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oCPivyv-3b76dHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=SQ1P2Hj1iVJNAcIA9DAOgf",
                    "updateTime": 1527002376953,
                    "source": "卡嘴军事",
                    "title": "美为这个盟友花费9000亿, 如今联合伊朗共同反美2018-05-23 17:05:31",
                    "categoryName": "军事",
                    "contentName": "美为这个盟友花费9000亿, 如今联合伊朗共同反美",
                    "cloudeserviceType": 101,
                    "index_seq": 36,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Kn3BK0XNap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oCPivyv-3b76dHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=SQ1P2Hj1iVJNAcIA9DAOgf&w=0",
                    "pageViews": 88,
                    "categoryId": "junshi"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/27/ec09b308-2192-4377-8090-558a3c4654354324728004258432723.jpg",
                    "landingPage": "//mini.eastday.com/a/180522170407330.html?qid=lxkjzs",
                    "contentId": "0004_9223370509874928477",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KpdBK0Xeap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oY7HOGS6YB3adHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=iHPWwHjQAWXEhrTWR9GH8O",
                    "updateTime": 1526979847330,
                    "source": "网易财经",
                    "title": "张小龙:交了8千万税 无北京户籍孩子连私立也不让上2018-05-23 17:05:31",
                    "categoryName": "财经",
                    "contentName": "张小龙:交了8千万税 无北京户籍孩子连私立也不让上",
                    "cloudeserviceType": 101,
                    "index_seq": 11,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KpdBK0Xeap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oY7HOGS6YB3adHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=iHPWwHjQAWXEhrTWR9GH8O&w=0",
                    "pageViews": 12,
                    "categoryId": "caijing"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/878/571c1b30-4942-4815-b188-e1d6b0967c048472491357220112928.jpg",
                    "landingPage": "//mini.eastday.com/a/180522162136586.html?qid=lxkjzs",
                    "contentId": "0003_9223370509877479221",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KQ3BK0XFap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYq8jyv-lbZIdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=a7rqqnRX7yoIqn3ItQIsMI",
                    "updateTime": 1526977296586,
                    "source": "东方头条",
                    "title": "肚痛5小时掉出婴儿尸体，15岁少女一脸迷茫：我以为只是变胖了2018-05-23 17:05:31",
                    "categoryName": "社会",
                    "contentName": "肚痛5小时掉出婴儿尸体，15岁少女一脸迷茫：我以为只是变胖了",
                    "cloudeserviceType": 101,
                    "index_seq": 59,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KQ3BK0XFap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYq8jyv-lbZIdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=a7rqqnRX7yoIqn3ItQIsMI&w=0",
                    "pageViews": 3415,
                    "categoryId": "shehui"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/529/4bac0362-5f55-472a-9cad-02ea3ea14dbf7964959638432911002.jpg",
                    "landingPage": "//mini.eastday.com/a/180522113054681.html?qid=lxkjzs",
                    "contentId": "0002_9223370509894921126",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KS3BK0Xaap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYSQjGqalcZBdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=9vkx7fqQj-hBp-ER0cBQlI",
                    "updateTime": 1526959854681,
                    "source": "不八卦会死星人",
                    "title": "他是1线古装美男，曾入狱7月毁前途，成晒女狂魔又被于正力捧2018-05-23 17:05:31",
                    "categoryName": "娱乐",
                    "contentName": "他是1线古装美男，曾入狱7月毁前途，成晒女狂魔又被于正力捧",
                    "cloudeserviceType": 101,
                    "index_seq": 43,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KS3BK0Xaap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYSQjGqalcZBdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=9vkx7fqQj-hBp-ER0cBQlI&w=0",
                    "pageViews": 201,
                    "categoryId": "yule"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/609/ee15073d-a923-4226-a596-9a7c2aca24fe9186078082552654190.jpg",
                    "landingPage": "//mini.eastday.com/a/180522141002576.html?qid=lxkjzs",
                    "contentId": "0008_9223370509885373231",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Kl3BK0XWap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYvijGSAlbpIdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=swH9bpK7xvoTl1ncjDWccf",
                    "updateTime": 1526969402576,
                    "source": "站长之家",
                    "title": "乘客集体跳闸逃票视频热传 这到底是怎么回事？2018-05-23 17:05:31",
                    "categoryName": "科技",
                    "contentName": "乘客集体跳闸逃票视频热传 这到底是怎么回事？",
                    "cloudeserviceType": 101,
                    "index_seq": 28,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Kl3BK0XWap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYvijGSAlbpIdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=swH9bpK7xvoTl1ncjDWccf&w=0",
                    "pageViews": 131,
                    "categoryId": "keji"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/753/7b4b4270-f7bc-485c-9366-cf9bbb299e4b4855721841292841972.jpg",
                    "landingPage": "//mini.eastday.com/a/180522163507867.html?qid=lxkjzs",
                    "contentId": "0004_9223370509876667940",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KgdBK0Xdap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYqQOyS63ogNdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=Ctij45cgRhX8ho2elBHbq2",
                    "updateTime": 1526978107867,
                    "source": "担扑",
                    "title": "在北京拥有6000亩庄园，在长安街有大楼，中国真正的隐形富豪2018-05-23 17:05:31",
                    "categoryName": "财经",
                    "contentName": "在北京拥有6000亩庄园，在长安街有大楼，中国真正的隐形富豪",
                    "cloudeserviceType": 101,
                    "index_seq": 15,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KgdBK0Xdap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYqQOyS63ogNdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=Ctij45cgRhX8ho2elBHbq2&w=0",
                    "pageViews": 14,
                    "categoryId": "caijing"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/969/a0dfcc69-13ee-4fc4-a067-00d99c5b6c643758207325563962557.jpg",
                    "landingPage": "//mini.eastday.com/a/180522160811886.html?qid=lxkjzs",
                    "contentId": "0008_9223370509878283921",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Kq3BK0XLap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYqHvGWM3oZIdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=jXz4np7_UtJ0LJucvG2sxf",
                    "updateTime": 1526976491886,
                    "source": "站长之家",
                    "title": "联想回应国产系统 事件原因/来龙去脉详解2018-05-23 17:05:31",
                    "categoryName": "科技",
                    "contentName": "联想回应国产系统 事件原因/来龙去脉详解",
                    "cloudeserviceType": 101,
                    "index_seq": 23,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0Kq3BK0XLap07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2oYqHvGWM3oZIdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=jXz4np7_UtJ0LJucvG2sxf&w=0",
                    "pageViews": 46,
                    "categoryId": "keji"
                }, {
                    "adi": "https://mt.lenovo.com.cn/test/c/153/11912a5f-0e3c-44e1-9009-93f5607c2a832946217000880013215.jpg",
                    "landingPage": "//mini.eastday.com/a/180522095317001.html?qid=lxkjzs",
                    "contentId": "0019_9223370509900778806",
                    "adUrl": "https://test.clk.lenovo.com.cn/lenovo/click?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KtdBK0XgBp07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2ospMjMW6YoWBdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=jNf2zESf-PNpnbER7zL-52",
                    "updateTime": 1526953997001,
                    "source": "天天健康分享",
                    "title": "血管垃圾会引起这些疾病，多吃8种食物、记住四个多，血管很干净2018-05-23 17:05:31",
                    "categoryName": "健康",
                    "contentName": "血管垃圾会引起这些疾病，多吃8种食物、记住四个多，血管很干净",
                    "cloudeserviceType": 101,
                    "index_seq": 4,
                    "nurl": "https://test.clk.lenovo.com.cn/lenovo/t.gif?a=YH6XJgeNmtpA0mb0kHOktmJM0j2gQzuCgz2T4y8oWy5h6CBhp1IMqrRoemGkvcydWHOaP-lEgE9K450mm0963HUsbBEY07BC0mm0mm0FDJ7LtYgn2Mpd8bZ07qf07ck0ZxJ7jcRWYJyQOiA0mm0XTAK0XTAK0XTAK07nF0KtdBK0XgBp07c70mtg71Leow0eorTaGsKaLssvmG1rKEFwpsoqFUjS2ospMjMW6YoWBdHrRF1NvJFaa1rThQh_zBO0XnAKbXwL1fw0HxNc0oRLarssEjMYqloo0qPcw8Gjv8nCWMLGWIlcZ-qL6I7iZTKMQRCoNOxXPOcsWz2y6XHcwCwjSXaiW1NyP1RB3tWK3rddHxXFR-k6QMygEsbYvRK1WGrFky&s=jNf2zESf-PNpnbER7zL-52&w=0",
                    "pageViews": 34,
                    "categoryId": "jiankang"
                }],
                "message": "success"
            };
            // $.ajax({
            //     url:'http://www.easy-mock.com/mock/59ef05a8fb6c9121992d6637/example/a',
            //     type:"get",
            //     data:{},
            //     success:function (res) {
            //         console.log(res)
            //         objs = res.data;
            objs = obji.data;
            // 获取上报
            // var adverIDs = [];
            for (var i = 0; i < objs.length; i++) {
                var temp = objs[i].contentId;

                if (temp != undefined) {
                    var H5url_show = '[{"key": "adverID","value":"' + temp + '"}]'
                    CallNativeMethod('report_big_data', '{ "category": "business", "action": "F0037", "data": ' + H5url_show + ' }');
                }
                if (temp == undefined) {
                    var H5url_show = '[{"key": "adverID","value":"' + 'ID获取异常' + '"}]'
                    CallNativeMethod('report_big_data', '{ "category": "business", "action": "F0037", "data": ' + H5url_show + ' }');
                }
            }

            // alert(objs[0].categoryName != undefined)
            try {
                if (objs[0].categoryName != undefined) {
                    // 箭头按钮
                    // $('.bottom img').attr('src', 'assets/bottom.png')
                    $('.bottom').show()
                    $('.quan').show()

                    setInterval(function () {
                        $('.bottom').css('top', '380px')
                        setTimeout(function () {
                            $('.bottom').css('top', '378px')
                        }, 500)
                    }, 1000)


                    var quanNum = 8;
                    var timeHide = setInterval(function () {
                        $('.quan').html(quanNum + "s")
                        quanNum--;
                        if (quanNum == -2) {
                            clearInterval(timeHide)
                            $('.quan').hide();
                            $('.ppop').animate({top: "-268px"}, 2000, function () {
                                $('.bottom img').attr('src', 'https://priv-update.lenovo.com.cn/startupmanager/changui-news/templet/20180130/bootcare_lv/assets/bottom.png');
                                aseAndavart()
                            });
                        }
                    }, 1000)
                    // 弹出新闻框
                    // var timeId = setInterval(function () {
                    //     $('.quan').hide()
                    //     $('.ppop').animate({top: "-268px"}, 2000, function () {
                    //         $('.bottom img').attr('src', 'https://priv-update.lenovo.com.cn/startupmanager/changui-news/templet/20180130/bootcare_lv/assets/bottom.png');
                    //
                    //     });
                    //     clearInterval(timeId)
                    // }, 5000);


                    // 点击打开关闭
                    $('.bottom').on('click', function (e) {
                        var ppopTop = $('.ppop').css('top')
                        if (ppopTop === '-268px') {
                            $('.ppop').stop(true, false).animate({top: "0px"}, 1000, function () {
                                $('.bottom img').attr('src', 'https://priv-update.lenovo.com.cn/startupmanager/changui-news/templet/20180130/bootcare_lv/assets/bottom.png');
                            });
                        } else {
                            $('.quan').hide();
                            $('.ppop').stop(true, false).animate({top: "-268px"}, 1000, function () {
                                clearInterval(timeHide)
                                aseAndavart()
                                $('.bottom img').attr('src', 'https://priv-update.lenovo.com.cn/startupmanager/changui-news/templet/20180130/bootcare_lv/assets/bottom.png');
                            })
                        }
                    })


                    // 类别导航，上报第一个显示类别的信息；

                    //取得类型然后去重；
                    var aa = []
                    for (var i = 0; i < objs.length; i++) {
                        aa.push(objs[i].categoryName)
                    }
                    var result = []
                    for (var i = 0; i < aa.length; i++) {
                        if (result.indexOf(aa[i]) == -1) {
                            result.push(aa[i])
                        }
                    }
                    // console.log('去重结果',result)

                    // 输出到导航类型html
                    for (var i = 0; i < result.length; i++) {
                        $(".headline").append('<li style="font-family:\'微软雅黑\',\'Microsoft YaHei\'">' + result[i] + '</li>')
                    }
                    $('.headline li:first').addClass('active')


                    function aseAndavart() {
                        // 取当前类的新闻
                        var exportTemp = [];
                        var tempNum;
                        for (var i = 0; i < result.length; i++) {
                            if ($('.headline').find('li').eq(i).hasClass('active') == true) {
                                console.log(i)
                                tempNum = i;
                            }
                        }
                        console.log()
                        for (var i = 0; i < objs.length; i++) {
                            if (objs[i].categoryName == $('.headline li').eq(tempNum).text()) {
                                exportTemp.push(i)
                            }
                        }
                        // console.log(exportTemp)

                        var total = "";
                        var newtimer1 = [];
                        // var adverIDss = [];
                        for (var i = 0; i < exportTemp.length; i++) {
                            // console.log(exportTemp[i])
                            // console.log(objs[exportTemp[i]])
                            // 时间戳转时间
                            newtimer1.push(objs[exportTemp[i]].updateTime)
                            var a = parseInt(newtimer1[i]);
                            var date = new Date(a);
                            var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
                            var D = date.getDate();
                            // console.log(M+D);
                            var str = objs[exportTemp[i]].contentName.substr(0, 25) + (objs[exportTemp[i]].contentName.length >= 25 ? "..." : "");
                            var matrixing = objs[exportTemp[i]].pageViews;
                            if (matrixing > 10000) {
                                matrixing = parseInt(matrixing / 10000) + '万';
                            }

                            // ase显示
                            // $('.aseImg').attr('src',objs[exportTemp[i]].nurl);
                            // avart显示
                            var temp = objs[exportTemp[i]].contentId;
                            // adverIDss.push(temp)
                            // console.log(temp)
                            // avatar显示上报

                            if (temp != undefined) {
                                var H5url_show = '[{"key": "adverID","value":"' + temp + '"}]'
                                CallNativeMethod('report_big_data', '{ "category": "business", "action": "F0038", "data": ' + H5url_show + ' }');
                            }
                            if (temp == undefined) {
                                var H5url_show = '[{"key": "adverID","value":"' + 'ID显示异常' + '"}]'
                                CallNativeMethod('report_big_data', '{ "category": "business", "action": "F0038", "data": ' + H5url_show + ' }');
                            }

                            var tiem = '<li>' +
                                '<span  class="atop1" ><img class="lazy" src="' + objs[exportTemp[i]].adi + '"/></span>' +
                                '<span  class="atop2"  style="font-family:\'微软雅黑\',\'Microsoft YaHei\'" >' + str + '</span>' +
                                '<div class="left_bottom"><span  style="font-family:\'微软雅黑\',\'Microsoft YaHei\'">' + objs[exportTemp[i]].source + '</span>' +
                                '<span  style="font-family:\'微软雅黑\',\'Microsoft YaHei\'">' + matrixing + '阅读' + '</span>' +
                                '<span style="font-family:\'微软雅黑\',\'Microsoft YaHei\'" >' + M + D + '</span></div></li>';
                            total += tiem;
                            // $('.contents').append($('<div class="overL">没有更多了</div>'))
                        }
                        $('.contents').html(total)


                        $('.atop1,.atop2,.left_bottom span').on('click', function () {
                            // alert($(this).parent().index());
                            // 打开新闻
                            var landingUrl = '"' + 'http:' + objs[exportTemp[$(this).parent().index()]].landingPage + '"'
                            CallNativeMethod('open_url', landingUrl);
                            // 上报点击
                            var clickAdverId = objs[exportTemp[$(this).parent().index()]].contentId;
                            var clickData = '[{"key": "adverID","value":"' + clickAdverId + '"}]'
                            var parameter = '{ "category": "Click", "action": "F0039", "data": ' + clickData + ' }';
                            CallNativeMethod('report_big_data', parameter);
                            $('.aseImg').attr('src', objs[exportTemp[$(this).parent().index()]].adUrl);

                        })
                    }

                    // 选择新闻类型
                    $('.headline li').on('click', function () {
                        // 导航样式
                        $(this).addClass('active').siblings().removeClass('active');
                        // console.log($(this).text())
                        var exportTemp = []
                        for (var i = 0; i < objs.length; i++) {
                            if (objs[i].categoryName == $(this).text()) {
                                exportTemp.push(i)
                            }
                        }
                        // console.log(exportTemp)
                        var total = "";
                        var newtimer1 = [];
                        // var adverIDss = [];
                        for (var i = 0; i < exportTemp.length; i++) {
                            // console.log(exportTemp[i])
                            // console.log(objs[exportTemp[i]])
                            // 时间戳转时间
                            newtimer1.push(objs[exportTemp[i]].updateTime)
                            var a = parseInt(newtimer1[i]);
                            var date = new Date(a);
                            var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
                            var D = date.getDate();
                            // console.log(M+D);
                            var matrixing = objs[exportTemp[i]].pageViews;

                            if (matrixing > 10000) {
                                matrixing = parseInt(matrixing / 10000) + '万';
                            }
                            var str = objs[exportTemp[i]].contentName.substr(0, 25) + (objs[exportTemp[i]].contentName.length >= 25 ? "..." : "");
                            // ase显示
                            // $('.aseImg').attr('src',objs[exportTemp[i]].nurl);
                            // avart显示
                            var temp = objs[exportTemp[i]].contentId;
                            // avatar显示上报

                            if (temp != undefined) {
                                var H5url_show = '[{"key": "adverID","value":"' + temp + '"}]'
                                CallNativeMethod('report_big_data', '{ "category": "business", "action": "F0038", "data": ' + H5url_show + ' }');
                            }
                            if (temp == undefined) {
                                var H5url_show = '[{"key": "adverID","value":"' + 'ID显示异常' + '"}]'
                                CallNativeMethod('report_big_data', '{ "category": "business", "action": "F0038", "data": ' + H5url_show + ' }');
                            }
                            // adverIDss.push(temp)
                            // console.log(temp)

                            var tiem = '<li>' +
                                '<span  class="atop1" ><img class="lazy" src="' + objs[exportTemp[i]].adi + '"/></span>' +
                                '<span  class="atop2"  style="font-family:\'微软雅黑\',\'Microsoft YaHei\'"> ' + str + '</span>' +
                                '<div class="left_bottom"><span  style="font-family:\'微软雅黑\',\'Microsoft YaHei\'">' + objs[exportTemp[i]].source + '</span>' +
                                '<span  style="font-family:\'微软雅黑\',\'Microsoft YaHei\'">' + matrixing + '阅读' + '</span>' +
                                '<span style="font-family:\'微软雅黑\',\'Microsoft YaHei\'" >' + M + D + '</span></div></li>';
                            total += tiem;
                            // $('.contents').append($('<div class="overL">没有更多了</div>'))
                        }
                        $('.contents').html(total)


                        $('.atop1,.atop2,.left_bottom span').on('click', function () {
                            // alert($(this).parent().index());
                            var landingUrl = '"' + 'http:' + objs[exportTemp[$(this).parent().index()]].landingPage + '"'
                            CallNativeMethod('open_url', landingUrl);
                            // 上报点击
                            var clickAdverId = objs[exportTemp[$(this).parent().index()]].contentId;
                            var clickData = '[{"key": "adverID","value":"' + clickAdverId + '"}]'
                            var parameter = '{ "category": "Click", "action": "F0039", "data": ' + clickData + ' }';
                            CallNativeMethod('report_big_data', parameter);
                            $('.aseImg').attr('src', objs[exportTemp[$(this).parent().index()]].adUrl);
                        })
                    })

                }
            } catch (e) {
                console.log(e)
            }
            // }
            // })


            //运营位点击
            //token处理----------------------------------------------------------0
            try {
                if (objs[0].categoryName != undefined) {
                    if (!!c.landingPage) {
                        $('#header').addClass('pointer');
                    } else {
                        $('#header').on('mousedown', function (e) {
                            if (e.target.className !== 'setting' && e.target.className !== 'btn-icon-one' && e.target.className !== 'erray-one') {
                                CallNativeMethod('move_window', '')
                            }
                        });
                        return;
                    }

                    var strtoken = obj.data_server.data.message.action.note;
                    var straa = obj.data_server.data.message.action.note;
                    var arrtok = strtoken.split("?");

                    strtoken = arrtok[0] + "?token=" + CallNativeMethod('get_st', '') + '&' + arrtok[1];
                    if (obj.data_server.data.message.action.type == 2 && obj.data_server.data.message.action.target == "") {
                        //网址
                        $("#header").click(function (e) {
                            if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                                // reportAseClick();
                                CallNativeMethod('open_url', straa);
                                var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                                CallNativeMethod('report_big_data', parameter);


                                // function closeWindow() {
                                //     $('#wrap').hide();
                                //     $("#wrap").removeClass("active");
                                //     CallNativeMethod('close_window', '')
                                // }
                                //
                                // setInterval(closeWindow(), 1000)

                            }
                        })
                    } else if (obj.data_server.data.message.action.type == 2 && obj.data_server.data.message.action.target == "bbs.exe") {
                        //迷你论坛网址
                        $("#header").click(function (e) {
                            if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                                // reportAseClick();
                                CallNativeMethod('start_bbs', straa);
                                var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                                CallNativeMethod('report_big_data', parameter);

                                // function closeWindow() {
                                //     $('#wrap').hide();
                                //     $("#wrap").removeClass("active");
                                //     CallNativeMethod('close_window', '')
                                // }
                                //
                                // setInterval(closeWindow(), 1000)
                            }
                        })
                    } else if (obj.data_server.data.message.action.type == 1 && obj.data_server.data.message.action.target == "LenovoPrivilege.exe") {
                        //联想特权
                        $("#header").click(function (e) {
                            if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                                reportAseClick();
                                CallNativeMethod('start_privilege', strtoken);
                                var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                                CallNativeMethod('report_big_data', parameter);
                                // $('#wrap').hide();
                                // $("#wrap").removeClass("active");
                                // CallNativeMethod('close_window', '');
                            }
                        })
                    } else if (obj.data_server.data.message.action.type == 1 && obj.data_server.data.message.action.target == "LenovoPcManager.exe") {
                        //联想电脑管家
                        $("#header").click(function (e) {
                            if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                                reportAseClick();
                                CallNativeMethod('start_pc_manager', strtoken);
                                var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                                CallNativeMethod('report_big_data', parameter);
                                // $('#wrap').hide();
                                // $("#wrap").removeClass("active");
                                // CallNativeMethod('close_window', '');
                            }
                        })
                    } else if (obj.data_server.data.message.action.type == 0 && obj.data_server.data.message.action.target == "SmartHome.exe") {
                        //智慧联想
                        $("#header").click(function (e) {
                            if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                                reportAseClick();
                                CallNativeMethod('start_privilege', strtoken);
                                var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                                CallNativeMethod('report_big_data', parameter);
                                // $('#wrap').hide();
                                // $("#wrap").removeClass("active");
                                // CallNativeMethod('close_window', '');
                            }
                        })
                    }
                }
            } catch (e) {

                $('.cou_box').css('bottom', '-5px');
                $('.speed-up').css('bottom', '-26px');
                $('.btn-icon-one').css('bottom', '-26px');

                if (!!c.landingPage) {
                    $('#header').addClass('pointer');
                } else {
                    $('#header').on('mousedown', function (e) {
                        if (e.target.className !== 'setting' && e.target.className !== 'btn-icon-one' && e.target.className !== 'erray-one') {
                            CallNativeMethod('move_window', '')
                        }
                    });
                    return;
                }
                var strtoken = obj.data_server.data.message.action.note;
                var straa = obj.data_server.data.message.action.note;
                var arrtok = strtoken.split("?");

                strtoken = arrtok[0] + "?token=" + CallNativeMethod('get_st', '') + '&' + arrtok[1];
                if (obj.data_server.data.message.action.type == 2 && obj.data_server.data.message.action.target == "") {
                    //网址
                    $("#header").click(function (e) {
                        if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                            // reportAseClick();
                            CallNativeMethod('open_url', straa);
                            var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                            CallNativeMethod('report_big_data', parameter);


                            function closeWindow() {
                                $('#wrap').hide();
                                $("#wrap").removeClass("active");
                                CallNativeMethod('close_window', '')
                            }

                            setInterval(closeWindow(), 1000)

                        }
                    })
                } else if (obj.data_server.data.message.action.type == 2 && obj.data_server.data.message.action.target == "bbs.exe") {
                    //迷你论坛网址
                    $("#header").click(function (e) {
                        if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                            // reportAseClick();
                            CallNativeMethod('start_bbs', straa);
                            var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                            CallNativeMethod('report_big_data', parameter);

                            function closeWindow() {
                                $('#wrap').hide();
                                $("#wrap").removeClass("active");
                                CallNativeMethod('close_window', '')
                            }

                            setInterval(closeWindow(), 1000)
                        }
                    })
                } else if (obj.data_server.data.message.action.type == 1 && obj.data_server.data.message.action.target == "LenovoPrivilege.exe") {
                    //联想特权
                    $("#header").click(function (e) {
                        if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                            reportAseClick();
                            CallNativeMethod('start_privilege', strtoken);
                            var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                            CallNativeMethod('report_big_data', parameter);
                            $('#wrap').hide();
                            $("#wrap").removeClass("active");
                            CallNativeMethod('close_window', '');
                        }
                    })
                } else if (obj.data_server.data.message.action.type == 1 && obj.data_server.data.message.action.target == "LenovoPcManager.exe") {
                    //联想电脑管家
                    $("#header").click(function (e) {
                        if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                            reportAseClick();
                            CallNativeMethod('start_pc_manager', strtoken);
                            var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                            CallNativeMethod('report_big_data', parameter);
                            $('#wrap').hide();
                            $("#wrap").removeClass("active");
                            CallNativeMethod('close_window', '');
                        }
                    })
                } else if (obj.data_server.data.message.action.type == 0 && obj.data_server.data.message.action.target == "SmartHome.exe") {
                    //智慧联想
                    $("#header").click(function (e) {
                        if (e.target.id == "header" || e.target.className == "toptime" || e.target.className == "toptex" || e.target.className == "cou-list1" || e.target.className == "cou-list2" || e.target.className == "cou-list3" || e.target.className == "cou-list4" || e.target.className == "speed-up") {
                            reportAseClick();
                            CallNativeMethod('start_privilege', strtoken);
                            var parameter = '{ "category": "Click", "action": "F0029", "data": ' + H5url + ' }';
                            CallNativeMethod('report_big_data', parameter);
                            $('#wrap').hide();
                            $("#wrap").removeClass("active");
                            CallNativeMethod('close_window', '');
                        }
                    })
                }
            }
        }


    });
    // }
    // })
}