package Task4.rmi;

import Task4.service.PositionService;
import Task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomService {
    @Autowired
    ServiceA serviceA;
    @Autowired
    ServiceB serviceB;
    /*定义随机数*/
    private static int random;

    public UserService getUserService(){
        if (random == 1){
            return serviceA.getUserService();
        } else {
            return serviceB.getUserService();
        }
    }

    public PositionService getPositionService(){
        if (random == 1){
            return serviceA.getPositionService();
        } else {
            return serviceB.getPositionService();
        }
    }

    private int getRandom(){
        random = (int)(Math.random() * 2);
        return random;
    }
}
