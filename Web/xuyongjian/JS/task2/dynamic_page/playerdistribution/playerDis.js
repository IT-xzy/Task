let word = document.getElementById('changeWord');//输入栏value
let killerNum = document.getElementById('killerNum');//杀手人数
let civilianNum = document.getElementById('civilianNum');//平民人数
let x = document.getElementById("myRange");//获取滑条
let less = document.getElementById('less');
let plus = document.getElementById('plus');
let returm = document.getElementById('return');
let pageAlert = document.getElementById('pageAlert');
let setBtn = $('#setBtn');
let player = [];
let playerNum = $('#playerNum');

function isNum(s){//是否为正整数
    let re = /^[0-9]+$/ ;
    return re.test(s)
}

function inputWord(){
    if(isNum(word.value) === false){
    alert('不是整数');
    sessionStorage.clear();
        word.value = '';
        killerNum.innerHTML = '0';
        civilianNum.innerHTML = '0';
    }
    else{
	if (word.value <= 18 && word.value >= 4) {
        x.value = word.value;
        killerNum.innerHTML = Math.floor(word.value/3);
        civilianNum.innerHTML = Math.ceil(word.value * 2 / 3);
    }
	else{
		alert("请输入4-18以内的数字");
        word.value = '';
        killerNum.innerHTML = '0';
        civilianNum.innerHTML = '0';
	}}
	console.log(word.value);
}//获取输入栏value,并超限报警

function rangeWord(){
	word.value = x.value;//输入栏value等于滑条的value
    killerNum.innerHTML = Math.floor(word.value/3);
    civilianNum.innerHTML = Math.ceil(word.value * 2 / 3);
    console.log(word.value);
}//获取滑条value，并关联输入栏value。



 plus.onclick = function (){
    x.value++;
    word.value = x.value;
    killerNum.innerHTML = Math.floor(word.value/3);
    civilianNum.innerHTML = Math.ceil(word.value * 2 / 3);
    console.log();
    };//按钮事件，点击一次，滑条value增加，关联输入栏value

 less.onclick = function (){
    x.value--;
    word.value = x.value;
    killerNum.innerHTML = Math.floor(word.value/3);
    civilianNum.innerHTML = Math.ceil(word.value * 2 / 3);
    console.log();
    };//按钮事件，点击一次，滑条value减少，关联输入栏value
pageAlert.onclick = function(){
    alert('点我干嘛');
};
returm.onclick = function(){
    window.location.href= '../../static_page/task7-1.html'
};



// setBtn.on('click',function () {
// if (player.length !== 0){
//     // for (let i = 0; i < player.length; i++){
//     //     allPlayer.remove();}
//     $('.player').remove();}
//
// player.length = 0;
//     for (let i = 0; i < parseInt(killerNum.innerHTML); i++){
//     player.push('杀  &nbsp;手 1人');}//获取动态杀手数量
//
// for (let i = 0; i < parseInt(civilianNum.innerHTML); i++){
//     player.push('平  &nbsp;民 1人');}//获取动态动态平民数量
//
// let w = player.length;
// let z,y;
// for( ; w ; ){
//     y = Math.floor(Math.random()*(w--));
//     z = player[w];
//     player[w] = player[y];
//     player[y] = z;}
//
// for (let i = 0; i < player.length; i++){
// allPlayer = $('<div class="player">\n' +
//     '<div class="whitebox">'  +'</div>\n' +
//     '    <div>' + player[i] + '</div>\n' +
//     '</div>\n');
//
// playerNum
//     .append(allPlayer);}
// });//洗牌算法，将数组打乱



document.getElementById("viewId").onclick = function(){

    sessionStorage.setItem("wordStorage",word.value);
    sessionStorage.setItem('killerNum',killerNum.innerHTML);
    sessionStorage.setItem('civilianNum',civilianNum.innerHTML);
    window.location.href="../viewId/view.html";
};//点击跳转事件









