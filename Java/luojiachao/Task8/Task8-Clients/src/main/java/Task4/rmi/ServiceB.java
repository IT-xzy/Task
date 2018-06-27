package Task4.rmi;

import Task4.service.PositionService;
import Task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {

        @Autowired
        @Qualifier("rmiUserB")
        private UserService userService;

        @Autowired
        @Qualifier("rmiPositionB")
        private PositionService positionService;

        public UserService getUserService() {
            return userService;
        }

        public void setUserService(UserService userService) {
            this.userService = userService;
        }

        public PositionService getPositionService() {
            return positionService;
        }

        public void setPositionService(PositionService positionService) {
            this.positionService = positionService;
        }
    }

