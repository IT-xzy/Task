package task08client.utils;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GetRandomSerUtils {
    private static org.apache.commons.logging.Log logger = LogFactory.getLog(GetRandomSerUtils.class);

    public static Object getServices(String ConfigurationPath, String beanName){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(ConfigurationPath);
        return applicationContext.getBean(beanName);
    }

    public static Object getRandomServices(String ConfigurationPath,String beanName1, String beanName2){

        Object className;
        String runClientName;
        String rmiClient1 =beanName1;
        String rmiClient2 =beanName2;

        // 获得 1或者2 的随机数
        Random random =new Random();
        int randomNum =random.nextInt(2)+1;

        try{
            logger.info("进入服务中");
            if (randomNum ==1){
                className =getServices(ConfigurationPath,rmiClient1);
                runClientName = rmiClient1;

            }else{
                className =getServices(ConfigurationPath,rmiClient2);
                runClientName = rmiClient2;
            }
            logger.info("调用了服务：" + runClientName);
        }catch (Exception e){
            logger.info("宕机一台");
            if (randomNum ==1){
                className =getServices(ConfigurationPath,rmiClient2);
                runClientName = rmiClient2;
            }else{
                className =getServices(ConfigurationPath,rmiClient1);
                runClientName = rmiClient1;
            }
            logger.info("调用了服务：" + runClientName);
        }

        return className;

    }




}
