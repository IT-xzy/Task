var borNum = sessionStorage.getItem('dog');
entrance = JSON.parse(borNum);
console.log("js3 person===="+entrance);
//获取上一个页面传的数据。
var num = 1;
var i=0;
var w =1;
var go=true;
var e=1;
$('.bor').text(e);
$('.bod').text(num);
//初始化bor bod 的文本值


$('#btn').bind('click', function () {
        //btn的点击时间与函数;
        $('.bor').text(e);
        $('.bod').html(num);
        //开始定义操作的文本内容

//判断num小于上一个页面传过来的参数，如果小于num+1；

        //判断由那张图片显示。

        //遍历数组，把数组的每一项遍历出来，然后，放进文本中
        if (w % 2 == 0){
            $('.none').hide();
            $('.non').show();
            $('.txt').hide();
            $('.bor').text(e+1);
            e++;
            $('#btn').text('查看'+num+'身份');
        }else{
            if(num == entrance.length){
                $('.none').show();
                $('.non').hide();
                $('.txt').html(entrance[i]).show();
                $('#btn').text('法官查看');
                $('#btn').bind('click',function () {
                    window.location.href='js4.html'
                })
            }else{
                $('.none').show();
                $('.non').hide();
                $('.txt').html(entrance[i]).show();
                // console.log(i);
                $('#btn').text('隐藏身份传递给'+(num+1)+'号');

                num++;
                // console.log(num)
            }
        }

        // console.log(e);
        // console.log(num);
        // console.log(entrance.length);
        i++;
        w++;
        // console.log(w)
    });





