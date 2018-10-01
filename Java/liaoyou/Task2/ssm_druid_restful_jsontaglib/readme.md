# json相关

1、返回或接收json格式的数据需要添加如下三个jar包
    jackson-core
    jackson-databind
    jackson-annotations
    
2、例子
    添加了依赖包后如下操作会自动将students转换为json格式数据
  ``@ResponseBody
    @RequestMapping(value="/student", method=RequestMethod.GET)
    public List<Student> listStudent(Page page){
    	List<Student> students = studentService.list(page);
    	logger.info("ok");
    	return students;
    }``
    
# 注解相关

1、@ResponseBody：用于将Controller中方法的返回对象，通过HttpMessageConverter接口转换为指定格
式的数据如json、xml等，通过Response响应给客户端。
   在此例中，此注解完成返回对象到json数据的转换。
   
2、@RequestBody：该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter
进行解析，然后把相应的数据绑定到要返回的对象上 ,再把HttpMessageConverter返回的对象数据绑定到controller
中方法的参数上。
此注解常用来处理context-type不是默认的application/x-www-form-urlcoded编码的内容
如 application/json、application/xml等，最常用来处理application/json类型
   在此例中，此注解用来接收前台传递的json对象的字符串
   
3、@PathVariable：用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出URI模板中的变量作为参数。

4、@RequestParam：用于将请求参数区数据映射到功能处理方法的参数上