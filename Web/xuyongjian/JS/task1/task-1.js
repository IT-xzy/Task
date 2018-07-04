var threebox = document.getElementsByTagName('div');

var getRandomColor = function(){
  return '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6);
}//随机颜色

var myTime;//声明空定时器




function sjcolor(){
  var a = [0,1,2,3,4,5,6,7,8];
  var w = a.length;
  var x,y;
  for( ; w ; ){ 
    y = Math.floor(Math.random()*(w--));
    x = a[w];
    a[w] = a[y];
    a[y] = x;}//洗牌算法。






  for (var i = 0; i < 9; i++) {
    threebox[i].style.backgroundColor = "orange";}  //给格子上颜色之前，先将所有颜色统一。

  for (var i = 0; i < 3; i++){
    threebox[a[i]].style.backgroundColor = getRandomColor();}
    console.log(a);
    var a = {};}//点击修改颜色

document.getElementById('start').onclick = function(){
   clearInterval(myTime); //每次点击之前先清理一次定时器，以防加速
  myTime = setInterval(sjcolor,1000);//设置定时器}//开始闪事件。
};
document.getElementById('end').onclick = function(){
  clearInterval(myTime);
  for (var i = 0; i < 9; i++) {
    threebox[i].style.backgroundColor = "orange";}
}//结束闪任务按钮，清理定时器，统一颜色。
