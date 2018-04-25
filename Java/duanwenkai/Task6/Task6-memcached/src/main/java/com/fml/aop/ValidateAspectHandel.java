package com.fml.aop;

import com.fml.annotion.ValidateFiled;
import com.fml.annotion.ValidateGroup;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect
@Component
public class ValidateAspectHandel {
    /**
     * 使用AOP对使用了ValidateGroup的方法进行代理校验
     * @throws Throwable
     */
    @SuppressWarnings({ "finally", "rawtypes" })
    @Around("@annotation(com.fml.annotion.ValidateGroup)")
    public Object validateAround(ProceedingJoinPoint joinPoint) throws Throwable  {
        boolean flag = false ;
        ValidateGroup an = null;
        Object[] args =  null ;
        Method method = null;
        Object target = null ;
        String methodName = null;
        try{
            methodName = joinPoint.getSignature().getName();//方法名
            target = joinPoint.getTarget();//运行类
            method = getMethodByClassAndName(target.getClass(), methodName);//得到拦截的方法

            args = joinPoint.getArgs();     //方法的参数
            an = (ValidateGroup)getAnnotationByMethod(method ,ValidateGroup.class);//得到注解对象
            flag = validateFiled(an.fileds() , args);
        }catch(Exception e){
            flag = false;
        }finally{
            if(flag){
                System.out.println("验证通过");
                return joinPoint.proceed();
            }else{  //这里使用了Spring MVC ，所有返回值应该为Strng或ModelAndView ，如果是用Struts2，直接返回一个String的resutl就行了
                System.out.println("验证未通过");
                Class returnType = method.getReturnType();  //得到方法返回值类型
                if(returnType == String.class){ //如果返回值为Stirng
                    return "/error.jsp";        //返回错误页面
                }else if(returnType == ModelAndView.class){
                    return new ModelAndView("/error.jsp");//返回错误页面
                }else{  //当使用Ajax的时候 可能会出现这种情况
                    return null ;
                }
            }
        }
    }

    /**
     * 验证参数是否合法
     */
    public boolean validateFiled(ValidateFiled[] valiedatefiles , Object[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (ValidateFiled validateFiled : valiedatefiles) {
            Object arg = null; //参数的值

            if(validateFiled.filedName().equals("") ){
                arg = args[validateFiled.index()];
            }else{
                arg = getFieldByObjectAndFileName(args[validateFiled.index()] ,
                        validateFiled.filedName() );
            }

            if(validateFiled.notNull()){        //判断参数是否为空
                if(arg == null )
                    return false;
            }else{      //如果该参数能够为空，并且当参数为空时，就不用判断后面的了 ，直接返回true
                if(arg == null )
                    return true;
            }

            if(validateFiled.maxLen() > 0){      //判断字符串最大长度
                if(((String)arg).length() > validateFiled.maxLen())
                    return false;
            }

            if(validateFiled.minLen() > 0){      //判断字符串最小长度
                if(((String)arg).length() < validateFiled.minLen())
                    return false;
            }

            if(validateFiled.maxVal() != -1){   //判断数值最大值
                if( (Integer)arg > validateFiled.maxVal())
                    return false;
            }

            if(validateFiled.minVal() != -1){   //判断数值最小值
                if((Integer)arg < validateFiled.minVal())
                    return false;
            }

            if(!"".equals(validateFiled.regStr())){ //判断正则
                if(arg instanceof String){
                    if(!((String)arg).matches(validateFiled.regStr()))
                        return false;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 根据对象和属性名得到 属性
     */
    public Object getFieldByObjectAndFileName(Object targetObj , String fileName) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        String tmp[] = fileName.split("\\.");
        Object arg = targetObj ;
        for (int i = 0; i < tmp.length; i++) {
            Method method = arg.getClass().
                    getMethod(getGetterNameByFiledName(tmp[i]));
            arg = method.invoke(arg);
        }
        return arg ;//返回get方法get到的属性
    }

    /**
     * 根据属性名 得到该属性的getter方法名
     */
    public String getGetterNameByFiledName(String fieldName){
        return "get" + fieldName.substring(0 ,1).toUpperCase() + fieldName.substring(1) ;
    }

    /**
     *   根据目标方法和注解类型  得到该目标方法的指定注解
     */
    public Annotation getAnnotationByMethod(Method method , Class annoClass){
        Annotation all[] = method.getAnnotations();
        for (Annotation annotation : all) {
            if (annotation.annotationType() == annoClass) {
                return annotation;
            }
        }
        return null;
    }

    /**
     * 根据类和方法名得到方法
     */
    public Method getMethodByClassAndName(Class c , String methodName){
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if(method.getName().equals(methodName)){
                return method ;
            }
        }
        return null;
    }
}
