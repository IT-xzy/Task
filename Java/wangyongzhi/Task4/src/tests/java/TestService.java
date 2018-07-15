import model.Prof;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import model.StuInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.ProfService;
import service.StuInfoService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TestService {
    public static Logger logger = LogManager.getLogger(TestService.class);

    @Autowired
    public StuInfoService service;

    @Autowired
    public ProfService service2;


    //测试查询方法
    @Test
    public void getById() {
        StuInfo one = new StuInfo();
        one.setId(1);
        one = service.getById(one);
        Assert.assertEquals("李恪非", one.getName());
    }

    @Test
    public void insert() {
        StuInfo one = new StuInfo();
        one.setName("郭超");
        one.setStuNumber(6L);
        one.setMajor("java");
        one.setStartTime(20160201L);
        one.setEndTime(20160509L);
        one.setStatus("结业");
        one.setCompany("Google");
        one.setPosition("技术经理");
        one.setDuty("互联网基础服务领域，从事虚拟主机，云主机，域名。");
        one.setCreateAt(20170504L);
        one.setUpdateAt(20170809L);

        logger.info(one.getStuNumber());

        int count = service.insert(one);
        if (count == 0) {
            System.out.println("插入数据失败");
        }
        //此处得手动取得主键值，count依然返回的是数据库条目变动数。
        else {
            System.out.println("插入学员的Id是：" + one.getId());
        }
    }

    @Test
    public void update() {
        StuInfo one = new StuInfo();
        one.setId(1);
        one = service.getById(one);
        one.setId(4);
        one.setName("廖友");
        int count = service.update(one);
        if (count == 0) {
            System.out.println("更新数据失败");
        }
        else {
            System.out.println("更新后学员名称为：" + one.getName());
        }
    }

    @Test
    public void getByNumName(){
        StuInfo one = new StuInfo();
        one.setName("吴义强");
        List ones = service.getByNumName(one);
        one = (StuInfo) ones.get(0); //索引从0开始
        Assert.assertEquals("360", one.getCompany());
    }

    @Test
    public void delete() {
        StuInfo one = new StuInfo();
        one.setId(17);
        int count = service.deleteById(one);
        if (count == 1) {
            System.out.println("删除成功");

        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void selectCount(){
        System.out.println(service.selectCount());
    }

    @Test
    public void selectStudy(){
        StuInfo stu = new StuInfo();
        stu.setStatus("工作");
        System.out.println(service.selectStudyWork(stu));
    }

    @Test
    public void selectByMajor(){
        StuInfo one = new StuInfo();
        one.setMajor("java");
        int count = service.selectCountByMajor(one);
        System.out.println(count);
    }

    @Test
    public void getByPro(){
        Prof prof = service2.getByProf("java后端工程师");
        Assert.assertEquals("6-8k", prof.getFirstSalary());

    }
}
