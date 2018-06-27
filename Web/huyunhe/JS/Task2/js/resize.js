window.onresize = function(){
  var width = window.screen.width;
  var viewport = document.getElementsByName("viewport")[0];
  if(width <= 640){
      viewport.content="width=640";
  }
  else{
      viewport.content="width=device-width";
  }
}