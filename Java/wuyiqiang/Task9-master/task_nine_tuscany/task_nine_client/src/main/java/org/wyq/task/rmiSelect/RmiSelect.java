package org.wyq.task.rmiSelect;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.wyq.task.service.BaseService;

@Component
//@Scope("prototype")
public class RmiSelect {

    private static Logger logger = Logger.getLogger(RmiSelect.class);

    @Autowired(required = false)
    @Qualifier("schoolServiceRmiA")
    private BaseService schoolServiceRmiA;

    @Autowired(required = false)
    @Qualifier("schoolServiceRmiB")
    private BaseService schoolServiceRmiB;

    public BaseService getSchoolServiceRmi() {
        boolean random = this.getRandom();
        BaseService baseService = selectSchoolServiceRmi(random);
        return baseService;
    }

    public BaseService selectSchoolServiceRmi(boolean random) {
        if (tryBaseService(schoolServiceRmiA) && tryBaseService(schoolServiceRmiB)) {
            logger.info("schoolServiceRmiA:alive; schoolServiceRmiB:alive");
            if (random) {
                logger.info("select A");
                return schoolServiceRmiA;
            } else {
                logger.info("select B");
                return schoolServiceRmiB;
            }
        } else if (tryBaseService(schoolServiceRmiA)) {
            logger.error("schoolServiceRmiB:dead");
            return schoolServiceRmiA;
        } else if (tryBaseService(schoolServiceRmiB)) {
            logger.error("schoolServiceRmiA:dead");
            return schoolServiceRmiB;
        } else {
            logger.error("schoolServiceRmiA:dead; schoolServiceRmiB:dead");
            return null;
        }
    }

    private boolean tryBaseService(BaseService baseService){
        try {
            baseService.selecSalarytAll();
            return true;
        }catch (Exception e){
            System.out.println("############################################");
            System.out.println(e.getClass().getName());
//            e.printStackTrace();
            return false;
        }
    }

    private boolean getRandom() {
        if (System.currentTimeMillis() % 2 == 0)
            return true;
        else
            return false;
    }
}
