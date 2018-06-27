

function storage() {
    let storedPeople = JSON.parse(localStorage.getItem("peopleArray"));
    console.log(storedPeople);
    return storedPeople;
}
// function hide() {
//     document.getElementsByClassName("hide")[0].style.display="none";
//     document.getElementsByClassName("look")[0].style.display="flex";
// }
$(document).ready(function(){
    $(".hide").show();
    $(".lookBox").hide();

    let peopleNumber = storage().length;
    let lookNumber;
     lookNumber = 1 ;
    $("#number").text(lookNumber);

     console.log(lookNumber);
     $("#x").click(
         function show_confirm()
         {
             let r=confirm("结束本轮游戏吗");
             if (r===true)
             {
                 location.href="index.html";
             }
             else
             {
             }
         }
     );


    $("#buttonBox").click(function(){
        lookNumber++;
        if (lookNumber <= storage().length * 2){
         let number ;
         number = Math.ceil(lookNumber / 2) ;

        console.log(lookNumber);
        console.log(number);
        $("#number").text(number);
        if (lookNumber%2 === 0){
            $(".content").text(`隐藏并传递给${number + 1}号`);
        }
        else {
            $(".content").text(`查看${number}号身份`);
        }

        $(".people").text(storage()[number-1]);

        $(".hide").toggle();
        $(".lookBox").toggle();

        }
         if(lookNumber===storage().length * 2) {

            $(".content").text(`法官查看`);
        }
        else if(lookNumber===storage().length * 2 + 1) {
            window.open("judgecheck.html","_self");
        }

    });






});


