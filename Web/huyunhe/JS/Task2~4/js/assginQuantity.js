var myurl;

function setting() {
  var quantities = document.getElementById("totle-player").value;
  var killer = document.getElementById("killer");
  var citizen = document.getElementById("citizen");
  var killerNum;
  if(quantities < 3 || quantities > 18){
    alert("请输入3~18之间的数字！");
  }
  else{
    killerNum = Math.round(quantities * 1/4);
  }
  killer.innerHTML = killerNum;
  citizen.innerHTML = quantities - killerNum;
  myurl = "./task2-identity.html?kn=" + killerNum + "&cn=" + (quantities - killerNum);
  // console.log(myurl);
}

function dispatcher() {
  window.location = myurl;
}

setting();