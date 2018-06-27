package mybatis;

import mybatis.modle.User;
import mybatis.service.UserService;
import mybatis.service.UserServiceImpl;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {


//        long time = System.currentTimeMillis();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String nowSystemTime = sdf.format(time);
        User user;
        Logger logger = Logger.getLogger(Main.class.getName());
        UserService userService = new UserServiceImpl();
        long startInsert = System.currentTimeMillis();
        //插入50条数据
        for (int i = 1; i < 100; i++) {
            try {
                user = new User("ccc","222222222","222","sjjs","ccc","199","https://ccc","学学学","75654","2222");
                logger.info("->Succeed adding a student whose id is " + userService.add(user));
            } catch (Exception e) {
                logger.info("-->WARNING" + e.getMessage());
                logger.info("-->Error happens when adding.");
            }
        }
        long endInsert = System.currentTimeMillis();
        logger.info("-->All inserts done ,it costs " + (endInsert - startInsert) + " ms.");


        //删除指定id为50的学员
        try {
            int deleteId = 28;
            if (
                    userService.delete(deleteId))
                logger.info("-->Delete student successfully, the id is " + deleteId + ".");
            else
                logger.info("-->Delete student whose id is " + deleteId + " failed, the student doesn't exist! ");
        } catch (Exception e) {
            logger.info(e.getClass().getSimpleName());
            logger.info("-->Error happens when deleting.");
        }
        //使用学号精确查询
        try {
            int selectid = 30;
            User userByNum;
            userByNum = userService.findById(selectid);
            if (userByNum != null) {
                logger.info("-->Succeed finding the student whose id is " + selectid + "\n" + userByNum + ".");
            } else {
                logger.info("-->Querying failed to find a student whose id is " + selectid + ".");
            }
        } catch (Exception e) {
            logger.info(e.getClass().getSimpleName());
            logger.info("-->Error happens when querying student bu number");
        }
        //逐条更新
        //不更新Num属性
//        userUpdate.setNumber(null);



        try{
            for (int i=1;i<50;i++){
                User userupdata = new User("ccc","222222222","222","sjjs","ccc","199","https://ccc","老大最帅","75654","2222");

                userupdata.setid(i);
              //  userupdata.setWishing("老大最帅");
                userupdata.setUpdate_at(System.currentTimeMillis());
                if (userService.update(userupdata)){
                    logger.info("更新成功");
                }else
                    logger.info("修改失败"+userupdata.getid());
            }
        }catch (Exception e){
            logger.info(e.getMessage());
            logger.info("修改失败");
        }
//        清空表格，为下次测试做准备
//        try {
//            userService.reset();
//            logger.info("-->Table has been reset, ready for another test.");
//        } catch (Exception e) {
//            logger.info(e.getClass().getSimpleName());
//            logger.info("-->Error happens when resetting the table.");
//        }

    }

    }







