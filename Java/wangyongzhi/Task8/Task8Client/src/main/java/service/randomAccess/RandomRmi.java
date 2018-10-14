package service.randomAccess;

import model.Prof;
import model.StuInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import service.ProfService;
import service.StuInfoService;
/**
 * @Description: 随机调用机制实现
 */
@Component
public class RandomRmi {
    private static Logger logger = LoggerFactory.getLogger(RandomRmi.class);
    //启动spring容器
    private static ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 随机数产生器
     */
    public int getRandomNum() {
        int random = (int) (Math.random() * 2 / 1);
        if (random == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ProfService getProfService() {
        int random = getRandomNum();
        ProfService profService = null;
        if (random == 0) {
            try {
                logger.info("调用远程服务profServiceA；");
                profService = (ProfService) context.getBean("profServiceA");
                logger.info("调用远程服务profServiceA成功！");
            } catch (Exception e) {
                try {
                    logger.warn("远程服务profServiceA调用失败，更改调用远程服务profServiceB;");
                    profService = (ProfService) context.getBean("profServiceB");
                    logger.info("调用远程服务profServiceB成功！");
                } catch (Exception ex) {
                    logger.warn("你在搞笑吗？两台机器都挂了！");
                    ex.printStackTrace();
                }
            }
        } else {
            try {
                logger.info("调用远程服务profServiceB；");
                profService = (ProfService) context.getBean("profServiceB");
                logger.info("调用远程服务profServiceB成功！");
            } catch (Exception e) {
                try {
                    logger.warn("远程服务profServiceB调用失败，更改调用远程服务profServiceA;");
                    profService = (ProfService) context.getBean("profServiceA");
                    logger.info("调用远程服务profServiceA成功！");
                } catch (Exception ex) {
                    logger.warn("你在搞笑吗？两台机器都挂了！");
                    ex.printStackTrace();
                }
            }
        }
        return profService;
    }

    public StuInfoService getStuInfoService() {

        int random = getRandomNum();
        StuInfoService stuInfoService = null;
        if (random == 0) {
            try {
                logger.info("调用远程服务stuInfoServicrA；");
                stuInfoService = (StuInfoService) context.getBean("stuInfoServiceA");
                logger.info("调用远程服务stuInfoServicrA成功！");
            } catch (Exception e) {
                try {
                    logger.warn("远程服务stuInfoServicrA调用失败，更改调用远程服务stuInfoServicrB;");
                    stuInfoService = (StuInfoService) context.getBean("stuInfoServiceB");
                    logger.info("调用远程服务stuInfoServicrB成功！");
                } catch (Exception ex) {
                    logger.warn("你在搞笑吗？两台机器都挂了！");
                    ex.printStackTrace();
                }
            }
        } else {
            try {
                logger.info("调用远程服务stuInfoServicrB；");
                stuInfoService = (StuInfoService) context.getBean("stuInfoServiceB");
                logger.info("调用远程服务stuInfoServicrB成功！");
            } catch (Exception e) {
                try {
                    logger.warn("远程服务stuInfoServicrB调用失败，更改调用远程服务stuInfoServicrA;");
                    stuInfoService = (StuInfoService) context.getBean("stuInfoServiceA");
                    logger.info("调用远程服务stuInfoServicrA成功！");
                } catch (Exception ex) {
                    logger.warn("你在搞笑吗？两台机器都挂了！");
                    ex.printStackTrace();
                }
            }
        }
        return stuInfoService;
    }
}
