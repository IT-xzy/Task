/*
 * @Author: 汤镇铭Michael 
 * @Date: 2018-01-09 21:02:09 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-21 15:05:14
 */

//--------------------------------------------------------------------------------------
var sumState = JSON.parse(sessionStorage.getItem('sumRandom'));// 数据传递
// console.log(typeof sumState);
console.log(sumState);

var page1 = document.getElementById('image1');
var page2 = document.getElementById('image2');
// 获取图片模块

var watch1 = document.getElementById('watch1');
var watch2 = document.getElementById('watch2');
// 获取查看和隐藏并传递给下一号按钮

var numTop = document.getElementById('numTop');
var numButtom1 = document.getElementById('numButtom1');
var numButtom2 = document.getElementById('numButtom2');
//console.log(numTop); //< div id = "numTop" class = "num" > 1 < /div>
// 获取号数

var id = document.getElementById('id');// 获取身份
// console.log(id);

var clickNum = 1;// 点击次数 
/* 
这个地方要放在点击事件之外，这样就能实现每次点击以后不会再重置点击次数啦
妈的智障卡了我差不多一天，根本就不需要考虑循环什么的
*/

var playerState = new StateMachine({// 生成FSM实例
    init: 'cover',
    transitions: [// 创建生命周期
        {name: 'change', from: 'cover', to: 'flip'},// 绑定事件，设置转化状态
        {name: 'change', from: 'flip', to: 'cover'}
    ],
    methods: {
        onEnterCover: function () {
            page1.style.display = 'block';
            page2.style.display = 'none';
            watch1.style.display = 'block';
            watch2.style.display = 'none';

            numTop.innerHTML = clickNum;
            // console.log(numTop);
            numButtom1.innerHTML = clickNum;
            numButtom2.innerHTML = clickNum + 1;
            
            if (clickNum <= sumState.length) {
                if (sumState[clickNum - 1].role == 'killer') {
                    id.innerHTML = '角色：杀手';
                } else if (sumState[clickNum - 1].role == 'civilian') {
                    id.innerHTML = '角色：平民';
                }
            } else {
                window.location.href = "https://tzmmichael.github.io/TZM-ITJNS/JavaScript/task2/htmlFile/04.%E6%B3%95%E5%AE%98%E6%97%A5%E5%BF%97%E9%A1%B5.html";
            }
            clickNum++;
        },
        onEnterFlip: function () {
            page1.style.display = 'none';
            page2.style.display = 'block';
            watch1.style.display = 'none';
            watch2.style.display = 'block';
            if (clickNum > sumState.length) {
                watch2.innerHTML = '查看法官日志';
            }
        },
    }
});

$('#watch1,#watch2').click(// 触发事件
    function () {
        playerState.change();
        console.log(playerState.state); 
    }
);
console.log(playerState.state);






/* 
// 绑定点击事件的另一种写法
$('#watch').on('click',function () {
    playerState.change();// 调用状态机事件方法
    // console.log(playerState.state);
});
// console.log(playerState.state);
*/