

function upd(id) {

    $("#upda_"+id).modal({
        keyboard: false
    })
    $("#myModal").bind('hide.bs.modal',function(){
         $(".modal-backdrop").remove();
    })
}

function del(id){

    window.location.href = "/del.do?id="+id;

}

function updlayer(id){
    layer.open({
              type: 2,
              area: ['360px','500px'],
              shadeClose: true, //点击遮罩关闭
              content: '/updStudent?stuid='+id
            });
}




function viewUpd(){
 window.location.href = "/studentPage.do?nowPage=1&PageSize="+$('#viewCountInput').val() ;

}

function torefrom(){

    window.location.href = "/studentPage.do?nowPage="+$("#refrominput").val();
//    var page = "/studentPage.do?nowPage="+$("#refrominput").val();
//    var fromS = $("#refrom");
//    fromS.action = page;
//    fromS.method = "post";
//    fromS.submit();

}






















