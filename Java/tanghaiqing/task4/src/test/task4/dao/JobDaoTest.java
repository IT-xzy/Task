package task4.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task4.pojo.Job;

import javax.annotation.Resource;
import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JobDaoTest {
    @Resource(name = "jobDao")
    private JobDao jobDao;
    @Test
    public void savaJob() {
        List<Job> jobs=jobDao.queryCategory("前端开发");
        for(Job job:jobs){
            System.out.println(job);
        }
    }

    @Test
    public void queryCategory() {
        Job j =new Job();
        j.setJobName("###java后端工程师");
        j.setJobCategory("后端开发");
        j.setJobIntro("后端的爆发力并不差，只要你给他时间，只要你愿意前进，后端的路线很深，" +
                "深到你有时候会觉得自己还没来得及全部了解，就已经有无数的新人涌进来要替换你的位置了。");
        j.setJobImage("687");
        j.setThreshold(3);
        j.setCycle("1-3");
        j.setScarcity(22);
        j.setSalary1("0k-8k/月");
        j.setSalary2("5k-13/月");
        j.setSalary3("8k-20k/月");
        j.setTerm1("0-1年");
        j.setTerm2("1-3年");
        j.setTerm3("3-5年");
        j.setAtSchool(178);
        j.setHint("######提示:####在你学习之前你应该计算机基础(计算机网络，数据结构，数据库，操作系统，Java基础语法)。");
        j.setJobIntroduce("####职业限制就是不去做独立的项目，不做DB设计，不做接口设计。第二个职业限制就是视野不开阔，" +
                "不知道有什么样的开源软件可以用。第三个职业限制就是不重视线上环境，不知道如何写日报，也不知道如何快速定位。" +
                "");
        j.setUpdateTime(System.currentTimeMillis());
        Integer i =jobDao.savaJob(j);
        System.out.println(i);
    }
}