// "use static";
//----------------------------------------获取dom以及添加onclick事件-------------------------------------------
var startBotton = document.getElementById("start");
var endBotton = document.getElementById("end");
var list = document.getElementsByClassName("block");
var time;
//------------------------------------------随机获取颜色------------------------------------------------------
function  color() {
  var r =Math.floor(Math.random()*256);
  var g =Math.floor(Math.random()*256);
  var b =Math.floor(Math.random()*256);
 return  "rgb("   + r +   ","  + g +   " ,"  + b+   ")";
}
// function begin() {
//     for(var i =0;i < list.length;i++){
//         list[i].style.backgroundColor = "";
//     }
//     var one = Math.floor(Math.random()*list.length);
//     var two = Math.floor(Math.random()*list.length);
//     var three = Math.floor(Math.random()*list.length);
//     if( one!=two && two!=three && three!=one){
//         list[one].style.backgroundColor = color();
//         console.log(list[one]);
//         list[two].style.backgroundColor = color();
//         console.log(list[one]);
//         list[three].style.backgroundColor = color();
//         console.log(list[one]);
//     }else{
//          begin();
//     }
// }
// function begin() {
//     var arr = [];
//     while (arr.length < 3) {
//         var bFlag = true;
//         var number = Math.floor(Math.random() * 9);
//         if (arr.length == 0) {
//             arr.push(number);
//         }
//         for (var i = 0; i < arr.length; i++) {
//             if (number == arr[i]) {
//                 bFlag = false;
//             }
//         }
//         if (bFlag) {
//             arr.push(number);
//         }
//     }
// }
    function start(){
        var arr =[];
        while (arr.length < 3){
            var bFlag = true;
            var number = Math.floor(Math.random()*9);
            if(arr.length == 0){
                arr.push(number);
            }
            for(var i = 0;i < arr.length ; i++){
                if(number == arr[i]){
                    bFlag  = false;
                }
            }
            if (bFlag){
                arr.push(number);
            }
        }
        // console.log(arr);
        // console.log(arr[0]);

        // return arr;
        list[arr[0]].style.backgroundColor = color();
        // console.log(arr[0]);
        list[arr[1]].style.backgroundColor = color();
        list[arr[2]].style.backgroundColor = color();

    }
 // var s = start();
        // list[arr[0]].style.backgroundColor = color();
        // console.log(list[arr[0]]);
        // list[arr[1]].style.backgroundColor = color();
        // console.log(list[arr[1]]);
        // list[arr[2]].style.backgroundColor = color();
        // console.log(list[arr[2]]);

    // return arr;
// }
startBotton.onclick=function displayStart (){
    clearInterval(time);
    time = setInterval(function(){
        for(var i =0;i < list.length;i++){
            list[i].style.backgroundColor = "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
        };
        start();},3000);
}
endBotton.onclick=function displayEnd() {
    clearInterval(time);
    for(var i =0;i < list.length;i++){
        list[i].style.backgroundColor = "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    }
}

    // list[0].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    // list[1].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    // list[2].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    // list[3].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    // list[4].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    // list[5].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    // list[6].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    // list[7].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    // list[8].style.backgroundColor= "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";

















     //---------------------------------------------------------------------
     // var a= arr;
    // return arr;
//     var a = randomNum();
//     console.log(randomNum());
//     console.log(a);
//     // var st = setInterval(function () {display()},3000);
//
//  var ad = setInterval(function () {randomNum()},3000);
// function display() {
//     // setInterval(function () {randomNum()}, 3000);
//     list[a[0]].style.backgroundColor = color();
//     list[a[1]].style.backgroundColor = color();
//     list[a[2]].style.backgroundColor = color();
// }
// var st = setInterval(function () {
//     display()
// },3000);

// clearInterval(st);

//    var ttt =  setInterval(function() {display()}, 3000);
//
// // }
// function  displayDemo() {
//     // list.style.backgroundColor= "rgb(256,66,0)";
//     document.getElementsByClassName("block").style.backgroundColor =  "rgb("   + 255 +   ","  + 66 +   " ,"  + 0+   ")";
// }
// var randoms=[];
// while (true)
// {
//     var isExists = false;
    // 获取一个10–100范围的数
    // var random = parseInt(10 + (90 - 10) * (Math.random()))
    // 判断当前随机数是否已经存在
    // for (var i = 0; i < randoms.length; i++) {
    //     if (random === randoms[i]) {
    //         isExists = true;
    //         break;
    //     }
    // }
    // 如果不存在，则添加进去
    // if (!isExists)
    //     randoms.push(random);
    // 如果有10位随机数了，就跳出
    // if (randoms.length === 10) {

        // console.log(randoms);
        // break;
    // }
// }