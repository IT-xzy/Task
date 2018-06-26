package task2;




import task2.pojo.Student;
import task2.service.StudentService;
import task2.service.StudentServiceImpl;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {


        Student student;
        Logger logger = Logger.getLogger(Main.class.getName());
        StudentService userService = new StudentServiceImpl();


        long startInsert = System.currentTimeMillis();
        //插入50条数据
        for (int i = 1; i < 50; i++) {
            try {
                student = new Student("ccc","222222222","222","sjjs","ccc","199","https://ccc","学学学","75654","2222");
                logger.info("->Succeed adding a student whose id is " + userService.add(student));
            } catch (Exception e) {
                logger.info("-->WARNING" + e.getMessage());
                logger.info("-->Error happens when adding.");
            }
        }
        long endInsert = System.currentTimeMillis();
        logger.info("-->All inserts done ,it costs " + (endInsert - startInsert) + " ms.");


        //删除指定id为28的学员
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
            Student student1ByNum;
            student1ByNum = userService.findById(selectid);
            if (student1ByNum != null) {
                logger.info("-->Succeed finding the student whose id is " + selectid + "\n" + student1ByNum + ".");
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
        try {
            String stu_name = "l";
            List<Student> studentsByName;
            studentsByName = userService.findByName(stu_name);
            if (studentsByName!=null){
                logger.info("-->Succeed finding a user whose stu_name is " + stu_name + "\n" + studentsByName + ".");
            }else {
                logger.info("-->Querying failed to find a user whose stu_name is " + stu_name + ".");
            }
        }catch (Exception e){
            logger.info(e.getClass().getSimpleName());
            logger.info("-->Error happens when querying student by stu_name");
        }


        try{
            for (int i=1;i<50;i++){
                Student studentupdata = new Student("ccc","222222222","222","sjjs","ccc","199","https://ccc","老大最帅","75654","2222");

                studentupdata.setid(i);
                //  userupdata.setWishing("老大最帅");
                studentupdata.setUpdate_at(System.currentTimeMillis());
                if (userService.update(studentupdata)){
                    logger.info("更新成功");
                }else
                    logger.info("修改失败"+studentupdata.getid());
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







