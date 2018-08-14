package wyq.webapp.util;

import com.whalin.MemCached.MemCachedClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wyq.webapp.pojo.Engineer;

import java.util.List;

@Component
@Aspect
public class MemcacheInterceptor {
    @Autowired
    MemCachedClient memCachedClient;

    @Around("execution(* wyq.webapp.service.impl.EngineerServiceImpl.*(..))")
    public List doFindEngineerAround(ProceedingJoinPoint call) {
        List<Engineer> engineerList = (List<Engineer>)memCachedClient.get("engineerList");
        System.out.println(engineerList);

        if (engineerList != null) {
            System.out.println("从缓存中读取！engineerList" + engineerList );
        } else {
            try {
                engineerList = (List<Engineer>)call.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            if (engineerList != null) {
                memCachedClient.add("engineerList", engineerList);
                System.out.println("缓存加入:" + engineerList );
            }

        }

        return engineerList;

    }
}
