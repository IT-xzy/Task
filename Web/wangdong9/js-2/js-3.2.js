/**
 * Created by Administrator on 2017/12/1.
 */
strl=sessionStorage.l;l=JSON.parse(strl);
var m=[];
window.onload=function cDiv(){
for   (i=0;  i<l.length; i++) {
    m[i]=i;
    var main=document.getElementsByClassName("main");
    var footer=document.getElementById("footer");
    var oDiv=document.createElement("div");
    var oDivsi=document.createElement("div");
    var oDivnumber=document.createElement("div");
    var oText=document.createTextNode((i+1)+"号");
    oDiv.className="squar";
    oDivsi.className="si";
    oDivnumber.className="number";



oDiv.appendChild(oDivnumber);
    oDiv.appendChild(oDivsi);
    oTextname=document.createTextNode(l[i]);
    oDivnumber.appendChild(oText);
    oDivsi.appendChild(oTextname);
    oDiv.id='div'+m[i];
    document.getElementById("all").appendChild(oDiv);

       }
};

function star() {
    location.href = "js-4.1.html";
    // var strl = JSON.stringify(l);
    // sessionStorage.l = strl;
}
  