package com.jnshutask.controller;

import com.jnshutask.controller.ControllerUtil.ResponseBo;
import com.jnshutask.controller.ControllerUtil.TaException;
import com.jnshutask.pojo.TaStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("va")
public class TestController  {

    @RequestMapping("")
    public String index() {
        return "test111";
    }

    //使用validation对bean进行验证,方法内处理;
    @PostMapping("list")
    @ResponseBody
    public ResponseBo dictList(@Valid TaStudent taStudent, BindingResult bindingResult) {
        Map<String, Object> map=new HashMap<String, Object>(10);
        System.out.println(bindingResult);
        if(bindingResult.hasErrors()){
            for(FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error("出错信息为:{}",fieldError.getDefaultMessage());
            }
            return ResponseBo.error("student数据格式错误;");
        }

        return ResponseBo.ok("请求成功;",taStudent);
    }

    //使用validation对bean进行验证，全局异常进行处理;
    @PostMapping("aaa")
    @ResponseBody
    public ResponseBo testList(@Valid TaStudent taStudent) {
        Map<String, Object> map=new HashMap<String, Object>(10);

        return ResponseBo.ok("请求成功;",taStudent);
    }

    //使用validation对方法进行验证;
//    @PostMapping("bbb")
//    @ResponseBody
//    @Validated
//    public ResponseBo test000(@Validated @NotBlank  String str) {
//            return ResponseBo.error("str数据格式错误;");
//    }

    //使用try，catch对断言判断参数处理
    @PostMapping("asse")
    @ResponseBody
    public ResponseBo Test111( String string){
        try{
            Assert.notNull(string,"传入的参数string为空");
            log.info("得到的参数信息为:{}",string);
            return ResponseBo.ok("方法测试成功",string);
        }catch(Exception e){
            log.error("出错信息为:{}",e.getMessage());
        }
        return ResponseBo.error("方法测试，传入数据出错");
    }

    @PostMapping("meth")
    public String Test222( String string,Model model){
        string="这是测试数据";
        log.info("数据成功");
        ResponseBo r= ResponseBo.ok("方法测试成功",string);
        log.info("woshi{}",r);
        model.addAttribute("response",r);
        return "test111";
    }
    //使用默认异常处理参数异常
    @ExceptionHandler(value = Exception.class)
    @PostMapping("exce")
    public ResponseBo Test33( String string){
        Assert.notNull(string,"传入的参数出错,为null");
        return ResponseBo.ok("测试完成");
    }
    // 使用全局异常处理参数异常
    @PostMapping("excd")
    public ResponseBo Test34( String string,Model model){
        Assert.notNull(string,"传入的参数出错,为null");
        return ResponseBo.ok("测试完成");
    }

    @PostMapping("nupo")
    public ResponseBo Test44( String string,Model model){
        //测试空指针异常
        string.equals("hah");
        return ResponseBo.ok("测试完成");

    }

}

