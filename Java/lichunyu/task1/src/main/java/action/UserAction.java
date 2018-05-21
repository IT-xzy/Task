package action;

import org.apache.log4j.Logger;
import service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;
import service.UserServiceImpl;

import java.util.List;

/**
 * task1 Main函数调用DAO接口，实现增删查改
 */

public class UserAction {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserService userServiceImpl = context.getBean(UserServiceImpl.class);
        Logger log=Logger.getLogger(UserAction.class);

//循环插入10次
        long start =System.currentTimeMillis();
        log.info("开始循环插入10条数据");
        for (int i = 0; i < 10; i++) {
            try {
                User user = new User();
                int x = (int) (Math.random() * 50);
                String mix = "MIX2S" + x;
                String pwx = "guess" + x;
                user.setName(mix);
                user.setPassword(pwx);
                userServiceImpl.insert(user);
                log.info("数据插入成功id:"+user.getId());
            }catch (Exception e){
                log.info("插入异常信息："+e.getMessage());
                log.info("循环插入出现异常!");
            }
        }
        long end =System.currentTimeMillis();
        log.info("插入10条数据一共耗时："+(end-start)+"毫秒");


//        删除数据
        log.info("尝试删除id=4数据");
        try {
            int count = userServiceImpl.delete(4);
            if (count > 0)
                log.info("删除数据成功！");
            else
                log.info("不存在id=4的数据，无需删除");
        }catch (Exception e){
            e.printStackTrace();
        }


//        通过id查找数据
        log.info("查找id=1000的数据");
        try {
            User selectUser = userServiceImpl.select(1000);
            log.info("查找到的数据：" + selectUser.getName() + "\t\t" + selectUser.getPassword());
        }catch (Exception e){
            log.info("未查找到相关数据");
            log.info("查找异常信息："+e.getClass().getSimpleName());
        }

//        通过name模糊查询
        log.info("通过姓名'小小'进行模糊查询");
        try {
            List<User> users = userServiceImpl.selectByName("小小");
            if(users.isEmpty())
                log.info("通过姓名未查找到相关数据");
            else
                for (User u : users) {
                log.info("通过模糊查询到的id：" + u.getId());
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.info("模糊查询异常信息："+e.getClass().getSimpleName());
        }

        User user1=new User();
        user1.setId(5);
        user1.setName("米家");
        user1.setPassword("123465");
//        更改数据
        log.info("对id=3的行进行数据更新");
        try {
            int count1 = userServiceImpl.update(user1);
            if (count1 > 0)
                log.info("更新数据成功！");
            else
                log.info("更新数据失败！");
        }catch (Exception e){
            log.info("更改数据异常信息："+e.getClass().getSimpleName());
        }

//        添加数据返回id
        User user2=new User();
        user2.setName("天猫");
        user2.setPassword("123465");
        try {
            int returnId = userServiceImpl.returnId(user2);
            if (returnId == 0)
                log.info("一条数据未插入成功");
            else
                log.info("数据插入成功!数据插入id：" + returnId);
        }catch (Exception e){
            log.info("插入失败信息："+e.getClass().getSimpleName());
        }

//        删除数据返回boolean
        try {
            boolean isDelete = userServiceImpl.isDelete(3);
            if (!isDelete)
                log.info("删除id=3数据失败");
            else
                log.info("删除id=3数据成功");
        }catch (Exception e){
            log.info("删除异常信息："+e.getClass().getSimpleName());
        }

//        更新数据返回boolean
        try {
            boolean isUpdate = userServiceImpl.isUpdate(user1);
            if (!isUpdate)
                log.info("id=5数据更新失败！");
            else
                log.info("id=5数据更新成功");
        }catch (Exception e){
            log.info("更新异常原因："+e.getClass().getSimpleName());
        }

    }

}
