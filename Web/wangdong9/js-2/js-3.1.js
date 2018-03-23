/**
 * Created by Administrator on 2017/11/21.
 */
//读取

//alert(all);
//document.getElementById("introduce").innerHTML=all;
//document.getElementById("img" ).innerHTML=l;

str = sessionStorage.all;
strl = sessionStorage.l;
//重新转换为对象
all = JSON.parse(str);
l = JSON.parse(strl);
console.log(l);
//add();
 i = 1;
//i<l.length;
y = 1;
function add() {
    i++;

    if (i % 2 == 1 && i < 2 * l.length) {
        document.getElementById("number").innerHTML = y;
        document.getElementById("next").innerHTML = "查看" + y + "号查看身份";
        document.getElementById("identity").innerHTML = "";
    }
    else {
        y++;  
      if(y< l.length + 1){
          document.getElementById("next").innerHTML = "隐藏并传递给" + y + "号";
          document.getElementById("identity").style.display = "block";
          document.getElementById("identity").innerHTML = l[(y - 2)];}
       
        else if (y == l.length + 1) {
            document.getElementById("next").innerHTML = "查看法官日志";
          document.getElementById("identity").innerHTML = l[(y - 2)];
        }
        else if (i >= (2 * l.length - 1)) {
            return location.href = "js-3.2.html";
        }
        var strl = JSON.stringify(l);
        sessionStorage.l = strl;

    }


    //document.getElementById("examine").innerHTML=l;
}
// $(document).ready(function () {
//     $("#next").toggle(
//         function () {
//             $("#next").show();
//             $("#next").show()
//         },
//         function () {
//             $("#king").hide();
//             $("#wow").show();
//         },
//         function () {
//             $("#king").show();
//             $("#wow").hide();
//         }
//     );
// });
var flag=true;
$('#next').click(function () {
    if(flag){
        $('#king').hide();
        $('#wow').show()
    }else {
        $('#king').show();
        $('#wow').hide()
    }
    flag=!flag;
});
