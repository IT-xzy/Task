function judgeNumber() {
   let number = document.getElementById("inputNumber").value;
   let re = new RegExp("^([4-9]|1[0-8])$",);
   re.test(number);
    console.log(re.test(number));
   if ( !re.test(number)) {
       alert("请输入正确的玩家数量");
       document.getElementById("inputNumber").value = "4"; //清空错误数量
       document.getElementById("range").value=document.getElementById("inputNumber").value;

       changNumber();
       // console.log(/^.$/u.test(text)); // true  正则表达式
       // (Number.isInteger(25.1)  判断整数形式
   }
       else {
           document.getElementById("range").value=document.getElementById("inputNumber").value;
           changNumber();
       }

}

function changNumber() {
    let killer ;
    killer  = killerNumber();
    document.getElementById("killer").innerText = killer;

    let water;
      water  = waterNumber();
    document.getElementById("water").innerText = water;
}

    // 身份数组赋值
function peopleArray() {
    let  peopleNumber = parseInt(document.getElementById("inputNumber").value);
    let peopleArray = new Array(peopleNumber);

    peopleArray.fill("水民",0);

    console.log(peopleNumber);
    let killer = killerNumber();
    peopleArray.fill("杀手",0 ,killer);
    return peopleArray.shuffle();


    }

    function killerNumber() {

        let  peopleNumber = parseInt(document.getElementById("inputNumber").value);
        if (peopleNumber  <= 5) {
           let killerNumbers ;
             killerNumbers = 1;
           return killerNumbers;

        }

        else if(peopleNumber <= 8) {
            let killerNumbers ;
            killerNumbers = 2;
            return killerNumbers;
        }
        else if(peopleNumber  <= 11) {
            let killerNumbers ;
            killerNumbers = 3;
            return killerNumbers;
        }
        else if(peopleNumber <= 15) {
            let killerNumbers ;
            killerNumbers = 4;
            return killerNumbers;
        }
        else {
            let killerNumbers ;
            killerNumbers = 5;
            return killerNumbers;
        }
    }

   function waterNumber() {
       let number = document.getElementById("inputNumber").value;
       let water;
       water  = number - killerNumber();
       return water ;
   }




// 数组乱序
Array.prototype.shuffle = function() {
    let input = this;

    for (let i = input.length-1; i >=0; i--) {

        let randomIndex = Math.floor(Math.random()*(i+1));
        let itemAtIndex = input[randomIndex];

        input[randomIndex] = input[i];
        input[i] = itemAtIndex;
    }
    return input;
};

function storage() {

   let people =  peopleArray();
    localStorage.setItem("peopleArray", JSON.stringify(people) );
    let storedPeople = JSON.parse(localStorage.getItem("peopleArray"));
    console.log(storedPeople);
    return storedPeople;

}
function removeItem() {
    localStorage.removeItem("dieArray");
    localStorage.removeItem("dayNum");
}


function getId(id) {
    return document.getElementById(id);
}
function getClass(className) {
    return document.getElementsByClassName(className);
}

function add() {
    // let i =  getId(range).value;
    let i = document.getElementById("range").value;
    console.log(i);
    if (i < 18 ) {
        document.getElementById("range").value++;
        document.getElementById("inputNumber").value=document.getElementById("range").value;
        changNumber();
    }
    else {
        alert("不得超过18人")
    }

    }

function reduce() {
    // let i =  getId(range).value;
    let i = document.getElementById("range").value;
    console.log(i);
    if (i > 4 ) {
        document.getElementById("range").value--;
        document.getElementById("inputNumber").value=document.getElementById("range").value;
        changNumber();
    }else {
        alert("不得低于4人")
    }

}

function move() {
    document.getElementById("inputNumber").value=document.getElementById("range").value;
    changNumber();
}

function isNull( str ){
    if ( str === "" ) return true;
    let regu = "^[ ]+$";
    let re = new RegExp(regu);
    return re.test(str);
}

function openPlayersLook() {
    let killWord;
    killWord = document.getElementById("killWord").value;
    console.log(typeof (killWord));
    let waterWord;
    killWord = document.getElementById("waterWord").value;



    console.log(isNull(killWord));
    if (isNull(killWord) || isNull(waterWord)) {
        alert("词汇不能为空");
    }
        else {
            storage();
            removeItem();
            window.open("playerslook.html","_self");
        }

    }



