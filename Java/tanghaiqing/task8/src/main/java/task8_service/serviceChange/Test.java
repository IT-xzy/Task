package task8_service.serviceChange;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import task8_service.service.JobService;

public class Test {

    //private static ServiceChange<JobService> jobService=
    //        (ServiceChange<JobService> )new ClassPathXmlApplicationContext("spring-servlet.xml")
    //                .getBean("serviceChange");
    //
    //public static void main(String[] args) {
    //    Thread t1 =new Thread(){
    //        @Override
    //        public void run() {
    //            for (int i=0;i<10;i++){
    //                System.out.println(jobService.getT("jobService").queryService("前端开发"));
    //            }
    //        }
    //    };
    //    Thread t2 =new Thread(){
    //        @Override
    //        public void run() {
    //            for (int i=0;i<10;i++){
    //                System.out.println(jobService.getT("jobService").queryService("后端开发"));
    //            }
    //        }
    //    };
    //    t1.start();t2.start();
    //}
}
