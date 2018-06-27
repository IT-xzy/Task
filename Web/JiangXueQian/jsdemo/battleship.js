"use static";
// var randomLoc = Math.floor(Math.random()*5);
// var location1 = randomLoc;
// var location2 = randomLoc + 1;
// var location3 = randomLoc + 2;
// var guess;
// var hits = 0;
// var guesses = 0;
// var isSank = false;
// while (isSank == false){
//     guess = prompt ("Ready,aim,fire!(enter a number form 0-6);");
//     if (guess <0 || guess > 6){
//         alert("Please enter a valid cell number!");
//     }else{
//         guesses += 1;
//         if(guess ==location1 || guess == location2 || guess == location3){
//             alert("Hits!");
//             hits += 1;
//             if(hits == 3){
//                 isSank = true;
//                 alert("You sank my ship!");
//             }
//         }else{
//             alert("Miss!");
//         }
//     }
// }
// var stats = "You took"+ guesses + "guesses to sank the battleship," +
//     "which means your shooting accuracy was "+ (3/guesses);
// alert(stats);
function doIt(param) {
    param = 2;
}
var test = 1;
doIt(test);
// console.log(test);
alert(test);
function
changeStuff(num){
    num = num * 10;
    return num;
}
var num = 10;
var n = changeStuff(num);
// alert(num);//10
alert(n);
function clunk(times) {
    var num = times;
    while (num > 0) {
        display("clunk");
        num = num - 1;
    }
}
function thingamajig(size) {
    var facky = 1;
    clunkCounter = 0;
    if (size == 0) {
        display("clank");
    } else if (size == 1) {
        display("thunk");
    } else {
        while (size > 1) {
            facky = facky * size;
            size = size - 1;
        }
        clunk(facky);
    }
}
function display(output) {
    console.log(output);
    clunkCounter = clunkCounter + 1;
}
var clunkCounter = 0;
thingamajig(3);
console.log(clunkCounter);



var balance = 10500;
var cameraOn = true;
function steal(balance, amount) {
  var  cameraOn = false;
    if (amount < balance) {
        balance = balance - amount;
    }
    return amount;
    cameraOn = true;
}
var amount = steal(balance, 1250);
alert("Criminal: you stole " + amount + "!");


function changeStuff1(obj3) {
    obj3.item = "changed";
}
var obj2 =  new  Object();
obj2.item =  "unchanged";
changeStuff1(obj2);
alert(obj2.item);//unchanged

function  changeStuff2(obj2){
    obj2 = {item:"changed"};
    return obj2.item;
}
var obj2 =  new  Object();
obj2.item =  "unchanged";
var st = changeStuff2(obj2);
alert(st);
// alert(obj2.item);//unchanged
var words1 = ["24/7", "multi-tier", "30,000 foot", "B-to-B", "win-win"];
var words2 = ["empowered", "value-added", "oriented", "focused", "aligned"];
var words3 = ["process", "solution", "tipping-point", "strategy", "vision"];
var rand1 = Math.floor(Math.random() * words1.length);
var rand2 = Math.floor(Math.random() * words2.length);
var rand3 = Math.floor(Math.random() * words3.length);
var phrase = words1[rand1] + " " + words2[rand2] + " " + words3[rand3];
alert(phrase);

var scores = [60, 50, 60, 58, 54, 54, 58, 50, 52, 54, 48, 69,
    34, 55, 51, 52, 44, 51, 69, 64, 66, 55, 52, 61,
    46, 31, 57, 52, 44, 18, 41, 53, 55, 61, 51, 44];
var out;
var i = 0;
while( i < scores.length){
    out = "solution #"+ i + " score: " + scores[i];
    console.log(out);
    i += 1;
}
// var output;
// // var i = 0;
// while (i < scores.length) {
//     output = "Bubble solution #" + i + " score: " + scores[i];
//     console.log(output);
//     i =
// var i = 0;
var products = ["Choo Choo Chocolate", "Icy Mint", "Cake Batter", "Bubblegum"];
var hasBubbleGum = [false, false, false, true];
for (var i = 0;i < hasBubbleGum.length; i = i + 1){
    if (hasBubbleGum[i]){
        console.log(products[i] + " contains bubble gum");
    }

}
// i = i + 2;



