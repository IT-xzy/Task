$("aside-title").click(function (e) {
  if(e.target.id){
    $("ul").toggle();
  }

});

$("li").click(function (e) {
  highlight(e.target);
});
function highlight(self){
  let ele = $(self);
  $("li").removeClass("active");
  $(self).addClass("active");

}