// 身份数组
function storage() {
    let storedPeople = JSON.parse(localStorage.getItem("peopleArray"));
    console.log(storedPeople);
    return storedPeople;

}
function dayNum() {
    let dayNum = JSON.parse(localStorage.getItem("dayNum"));
    console.log(dayNum);
    return dayNum;
}

// 死人在死亡数组中的索引
function dieIndex() {
    // 获得相同元素下标
    let [ ...arr ] = dieArray();
    let dieNum = [];
    for (let i = 0; i < dieArray().length; i++) {
        let a = arr.lastIndexOf("死亡");
        if (a === -1){
            break;
        }
        dieNum.push(a);
        console.log(a);
        console.log(arr);
        arr.splice(a,1);
        console.log(arr);
        console.log(dieNum);
    }
    return dieNum;
}

// 死亡玩家上色
function changeColor() {
    let a = 0;
    for (let i=0; i<dieIndex().length;i++){
        $(`#${dieIndex()[a]}-1`).css("backgroundColor", "#83b09a");
        a++
    }
}

//各状态人数对象
function stateObject() {
    let a = dieArray().reduce((o, k) => {
        k in o ? o[k]++ : (o[k] = 1);
        return o;
    },{});
    console.log(a);
    return a ;
}
// .水民


// 死亡状态数组
function dieArray() {

    // localStorage.removeItem("dayNum");
    let dieArray = JSON.parse(localStorage.getItem("dieArray"));
    console.log(`读取死亡数组`+dieArray);
    if (dieArray ===null) {
        let dieArray = storage();
        localStorage.setItem("dieArray", JSON.stringify(dieArray));
        dieArray = JSON.parse(localStorage.getItem("dieArray"));
        console.log(`生成死亡数组为` + dieArray);
        return dieArray;
    }
    else {
        console.log(`死人数组为` + dieArray);
        return dieArray;
    }

}
// 人数
function waterAliveNum(){
    let a= dieArray().reduce((o, k) => {
        k in o ? o[k]++ : (o[k] = 1);
        return o;
    },{});
    console.log(a);
    return a ;
}

$(document).ready(function () {

    // 生成玩家框
    let a = 0;
    for (let i = 0; i < storage().length ; i++) {
        let txt=$(`<div class="boxNumber" id="${a}">
            <div class="people" id="${a}-1">${storage()[i]}</div>
            <div class="number">${i+1}号</div>

            <img class="killImg" src="img/kill.png" /></div>
    </div>`);

        $(".box").append(txt);
        a++;
    }

    changeColor();
    // 小刀状态控制
    $(".killImg").hide();
    // $(".boxNumber").click(
    //     function () {
    //         $(".killImg").hide();
    //         $(this).children(".killImg").show();
    //         $(".boxNumber").removeClass("willDie");
    //         $(this).addClass("willDie");
    //
    //     }
    //
    // );
    $("#x").click(
        function show_confirm() {
            let r=confirm("结束本轮游戏吗");
            if (r===true) location.href="index.html";
        }
    );

    $("#button").click(function () {
        // 获取index值

                location.href="game.html";




        // $(".box").children(".willDie");

        // localStorage.removeItem("dayNum");
        // window.open("game.html","_self");
    });
});

