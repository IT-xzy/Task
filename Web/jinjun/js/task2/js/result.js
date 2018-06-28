function dieArray() {

    // localStorage.removeItem("dayNum");
    let dieArray = JSON.parse(localStorage.getItem("dieArray"));
    // console.log(`读取死亡数组`+dieArray);
    if (dieArray ===null) {
        let dieArray = storage();
        localStorage.setItem("dieArray", JSON.stringify(dieArray));
        dieArray = JSON.parse(localStorage.getItem("dieArray"));
        console.log(`生成死亡数组为` + dieArray);
        return dieArray;
    }
    else {
        // console.log(`死人数组为` + dieArray);
        return dieArray;
    }

}
function dayNum() {
    let dayNum = JSON.parse(localStorage.getItem("dayNum"));
    console.log(dayNum);
    return dayNum;

}

function storage() {
    let storedPeople = JSON.parse(localStorage.getItem("peopleArray"));
    console.log(storedPeople);
    return storedPeople;
}

// 各状态人数
function stateObject() {
    let a = dieArray().reduce((o, k) => {
        k in o ? o[k]++ : (o[k] = 1);
        return o;
    },{});
    // console.log(a);
    return a ;
}
// .水民
// 死亡顺序对象
function dieOrder() {

    // localStorage.removeItem("dayNum");
    let dieOrder = JSON.parse(localStorage.getItem("dieOrder"));
    console.log(`读取死亡顺序`+dieOrder);
    if (dieOrder ===null) {
        let dieOrder = {
            0:  0
        };
        localStorage.setItem("dieOrder", JSON.stringify(dieOrder));
        dieOrder = JSON.parse(localStorage.getItem("dieOrder"));
        console.log(`生成死亡顺序为` + dieOrder);
        return dieOrder;
    }
    else {
        console.log(`死人顺序为` + dieOrder);
        return dieOrder;
    }
}
function winner() {
    let  a =stateObject()[`水民`];
    let  b =stateObject()[`杀手`];
    let  c =stateObject()[`死亡`];
    if (typeof a === "undefined"  ){
        $("#winner").text("杀手胜利");
        $(".good").text("太棒了！你知道么？在游戏中只有20%的杀手取得游戏最终的胜利哦！");
        $("#killerNum").text(`${stateObject()["杀手"]}`);
        $("#waterNum").text(`0`);
        return "杀手胜利";
    }
    else if (typeof b === "undefined"){
        $("#winner").text("水民胜利");
        $(".good").text("太棒了！你知道么？在游戏中有70%的水民取得游戏最终的胜利哦！");
        $("#killerNum").text(`0`);
        $("#waterNum").text(`${stateObject()["水民"]}`);
        return "水民胜利";
    }
    else{
        $("#winner").text("游戏终止");
        $(".good").text("太菜了！你知道么？只有10%的游戏中途终止哦！");
        $("#killerNum").text(`${stateObject()["杀手"]}`);
        $("#waterNum").text(`${stateObject()["水民"]}`);
        return "游戏终止";
    }
}
// number

function addDays() {
    let a = -1;
    let b = 0;
    for (let i = 0 ; i<dayNum();i++) {
        a++;
        b++;
        let  c =dieOrder()[`${b}-kill`];
        let  d =dieOrder()[`${b}-vote`];



        let   e;
        let   f;
        if (typeof c === "undefined"){
                 e =`无操作`
        }else {
             e= `${c+1}号被票死，真实身份是${storage()[c]}`
        }
         if (typeof d === "undefined"){
             f =`无操作`
        }else {
               f= `${d+1}号被票死，真实身份是${storage()[d]}`
         }

        $(".resultText").append(` <div class="days">

     <div class="time">
     <p class="dayNumber">第${b}天</p>
     <!--<p class="minute">0小时07分</p>-->
     </div>
     <p class="people">夜晚：${e}</p>
     <p class="people">白天：${f}</p>

 </div>`);

    }
    $(".resultText").append(`<div class="no1"></div>`);
}



$(document).ready(function () {

    winner();
    addDays();






    $(".buttonLeft").click(function () {
        location.href="setting.html";
    });
});