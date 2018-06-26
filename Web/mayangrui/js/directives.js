myApp.directive("sliderbar", function () {
    return {
        restrict: "AEMC",
        link: function (scope, element, attrs) {
            element.on("click", function () {
                var slider = $(this).index();
                $(this).parent().fadeToggle("slow");
                sessionStorage.setItem('slider', JSON.stringify(slider));
                $("li").css('background-color', 'transparent');
                $(this).css('background-color', '#fdbb6b');
            })
        }
    }
});
myApp.directive("open", function () {
    return {
        restrict: "AEMC",
        link: function (scope, element, attrs) {
            var index = sessionStorage.getItem('index', JSON.stringify(index));
            if (index !== null) {
                var slider = sessionStorage.getItem('slider', JSON.stringify(slider));
                var num = Number(index) * 4 + Number(slider);
                $(".title ul").eq(index).css('display', 'block');
                $(".title div").eq(index).css('background-color', '#fdbb6b');
                $("li").eq(num).css('background-color', '#fdbb6b');
            }
                element.on("click", function ($event) {
                    var index = $(this).index();
                    $(".title div").css('background-color', 'transparent');
                    $(this).siblings().find('ul').css('display', 'none');
                    $(this).find('ul').fadeToggle("slow");
                    $(".title div").eq(index).css('background-color', '#fdbb6b');
                    sessionStorage.setItem('index', JSON.stringify(index));
                })
            }
        }
});