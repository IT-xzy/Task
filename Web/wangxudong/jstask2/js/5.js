var data2 = JSON.parse(localStorage.getItem('identity'));   //好人换人数组
var data1 = (localStorage.getItem('sum'));       //总人数
var arr = []                             //建立空数组  往里添加对象
$("#back").click(function back() {       //返回按钮
    $(location).attr('href', '4.html');
})
$("#homepage").click(function backHome() {    //关闭按钮
    sessionStorage.clear();
    if (confirm("确定关闭游戏嘛")) {
        $(location).attr('href', '1.html');
    }
});

for (let i = 0; i < data1; i++) {
    $(".overall").append(`<div class="box">
    <div>
        <span class="id"></span>
        <span class="number">1号</span>
        <ul>
            <li class="option4"></li>
        </ul>
    </div>
</div>`) 
    $(".box")[i].style.display = "block";
    $(".number")[i].innerHTML = i+1 +"号";
    if (data2[i] == '好人') {
        $(".id")[i].innerHTML ='平民';
        var obj = {
            id: i + 1,
            name: '平民',
            state: 'live',
            day: 1,
        };
        arr.push(obj);
    } else {
        $(".id")[i].innerHTML ='狼人';
        var obj = {
            id: i + 1,
            name: '狼人',
            state: 'live',
            day: 1,
        }
        arr.push(obj);
    }
} 
sessionStorage.setItem('data', JSON.stringify(arr));    //保存对象数组
$("#begin").click(function go() {
    $(location).attr('href', '6.html');      //下一步按钮
})