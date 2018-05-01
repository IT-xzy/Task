package aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Aspect
public class BindingResultAop {
    private final Logger logger = Logger.getLogger(BindingResultAop.class);
    @Pointcut("execution(* action..*.*(..))")
    public void binding(){}
    @Around(value = "binding()")
    public Object aroundbindingResult(ProceedingJoinPoint proceedingJoinPoint){
        BindingResult bindingResult = null;
        Model model = null;
        Object object = null;
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg:args){
            if (arg instanceof  BindingResult){
                bindingResult = (BindingResult) arg;
            }
            if (arg instanceof Model){
                model = (Model)arg;
            }
        }
        if (bindingResult !=null) {
         List<ObjectError> objectErrors = bindingResult.getAllErrors();
         if (objectErrors.size() > 0) {
             StringBuilder stringBuilder = new StringBuilder();
             for (ObjectError objectError : objectErrors) {
                 stringBuilder.append(objectError.getDefaultMessage());
                 stringBuilder.append("\r\n");
             }
             HashMap<String, Object> hashMap = new HashMap();
             hashMap.put("result", false);
             hashMap.put("message", stringBuilder.toString());
             model.addAllAttributes(hashMap);
//             HashMap<String, Object> hashMap = new HashMap();
//             hashMap.put("result", false);
//             hashMap.put("message", stringBuilder.toString());
//             ObjectMapper mapper = new ObjectMapper();
//             try {
//                  mapper.writeValueAsString(hashMap);
//             } catch (JsonProcessingException e) {
//                 e.printStackTrace() ;
//             }
             return  "/task5/error";
         }
     }
        try {
            object = proceedingJoinPoint.proceed(args);
        }
        catch (Throwable throwable) {
            logger.error("bingdingAOP error",throwable);
        }
        return object;
    }
}
