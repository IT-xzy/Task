






// $(".rectangle").click(function () {
//     $(".nav-2").height(0);
// });

$(".rectangle").click(function () {
    if ($(".nav-2").height() == 0){

         $(".nav-2").height(100);
    }
    else {
         $(".nav-2").height(0);
    }
    
});


// $(".rectangle").click(function () {
//     if ($(".nav-2").height === 0) {
//          this.height(100); 
//         }
//     else{
//          this.height(0); 
//         }

// });


// $(function () {
//     $('.rectangle').click(function () {
//         $('.nav-2').toggle();
//     });
// });



// $(".main-content:nth-child(1)").mouseover(function () {
//     $(".transparent").css("visibility", "visible");
// });

// $(".main-content:nth-child(1)").mouseout(function () {
//     $(".transparent").css("visibility", "hidden");
// });