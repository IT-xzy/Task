package com.springmybatis.test;


import com.springmybatis.Mapper.StudentMapper;
import com.springmybatis.model.StudentMod;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 增删改查的测试方法
 * Created by Administrator on 17/7/2017.
 */

//让测试运行于Spring测试环境
//加载spring的配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext-druid.xml"})
public class StudentMapperTest {
    private static Logger loggerTest = Logger.getLogger(Test.class);

    //对ctx进行标注，完成自动配装的工作
    @Autowired
    ApplicationContext ctx;

    //所有测试开始前执行
    @BeforeClass
    public static void begin(){
        loggerTest.info("测试开始");
    }

    //所有测试完成后执行
    @AfterClass
    public static void end(){
        loggerTest.info("测试结束");
    }


    //测试查找
    @Test
    public void studentSelect(){
        try {
            loggerTest.info("测试查找\n");
            //getBean() 方法得到所需要的 bean
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            StudentMod studentMod = new StudentMod();
            studentMod.setUser_id("CS-1233");
            studentMod = studentMapper.studySelect(studentMod);
            loggerTest.info("输出查询结果\n" + studentMod);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("查找出错： " + e.getMessage());
        }
    }

    @Test
    public void studentInsert(){
        try {
            loggerTest.info("测试增加");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            StudentMod studentMod1 = new StudentMod();
            long entry_data = System.currentTimeMillis();
            studentMod1.studentMod("CS-1233", "王尼玛", 1, 112233, entry_data,"郑州大学",
                    "www.baidu.com","学习吧，少年","知乎",entry_data,entry_data);
            studentMapper.studyInsert(studentMod1);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("增加出错： " + e.getMessage());
        }
    }


    @Test
    public void studentUpdate(){
        try {
            loggerTest.info("测试修改");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            StudentMod studentMod4 = new StudentMod();
            studentMod4.setName("玛尼王");
            long entry_data = System.currentTimeMillis();
            studentMod4.setUpdate_at(entry_data);
            studentMod4.setUser_id("CS-1233");
            //i为返回影响的行数
            int i = studentMapper.studyUpdate(studentMod4);
            loggerTest.info("修改记录： " + i);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("修改出错： " + e.getMessage());
        }
    }


    @Test
    public void studentDelete(){
        try {
            loggerTest.info("测试删除");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            //i为返回影响的行数
            int i = studentMapper.studyDelete("CS-1233");
            loggerTest.info("删除记录： " + i);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("删除出错： " + e.getMessage());
        }
    }

    @Ignore
    @Test
    public void ignore(){
        loggerTest.info("忽略该测试");
    }
}
