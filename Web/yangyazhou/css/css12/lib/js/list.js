


  // 因为下拉框使用label标签绑定input单选按钮，
        // 所以在点击下拉框其他位置时，input的选中状态为false,
        // 所以设置了一个全局的点击事件，用来取消input的checked的状态
        $(document).on('click',function(e){
            $('input[name=drop]').prop('checked',false);
        });
        //到下拉菜单容器时，阻止事件冒泡。
    
        $('.drop-container').on('click',function(e){
            var status=$(this).find('ul').css('display')
            if(status== 'none'){
                $(this).find('ul').css('display','block');
            }else if(status == 'block'){
                $(this).find('ul').css('display','none');
            }
            return false;

        });
        

       

 