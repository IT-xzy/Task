function randomColor() {
    let colorarray=["0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"];
    let color = "#";
    for (let i = 0;i<6;i = i + 1) {
        color=color+colorarray[Math.round(15*Math.random())];
    }
    return color;
}

function number() {
    let numberArray=["1","2","3","4","5","6","7","8","9"];
    // let number1;
    let number1;
    let number2;
    let number3;
    number1 = numberArray.splice(parseInt(Math.random() * numberArray.length),1);
    number2 = numberArray.splice(parseInt(Math.random() * numberArray.length),1);
    number3 = numberArray.splice(parseInt(Math.random() * numberArray.length),1);
     console.log(number1);
     console.log(number2);
     console.log(number3);
     let numberRand ;
    numberRand = Array.of(number1, number2,number3);
     return numberRand ;

}

function getId(id) {
    return document.getElementById(id);
}

function getClass(className) {
    return document.getElementsByClassName(className);
}
function clean() {

    let boxs = document.getElementsByClassName("box");
    for (let i = 0;i<9;i++) {
        boxs[i].style.backgroundColor="orange";
    }
    // boxs[0].style.backgroundColor="orange";
    // boxs[1].style.backgroundColor="orange";
}

function changeColor() {
    let numberRand = number();
    clean();
    getId(numberRand[0]).style.backgroundColor=randomColor();
    getId(numberRand[1]).style.backgroundColor=randomColor();
    getId(numberRand[2]).style.backgroundColor=randomColor();
    document.all.start.disabled = true;
}
let t ;
function timer() {

     changeColor();
    t = setTimeout("timer()",1000)
}
function stopTimer() {
    clean();
    clearTimeout(t);
    document.all.start.disabled = false;
}