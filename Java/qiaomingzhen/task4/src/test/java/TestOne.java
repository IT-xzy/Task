import com.model.Company;
import com.model.People;
import com.model.Profession;
import com.service.CompanyService;
import com.service.ProfService;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestOne {
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;
@Autowired
private ProfService profService;
    @Test
    public void test1() {
        People people = new People();
        people.setName("小明");
        people.setInfo("好好学习");
        people.setCreatTime(System.currentTimeMillis());
        people.setUpdateTime(System.currentTimeMillis());
        userService.addUser(people);
    }

    @Test
    public void test2() {
        long a = System.currentTimeMillis();
//方法 二
        long b = Calendar.getInstance().getTimeInMillis();
//方法 三
        long d = new Date().getTime();
        People people = new People();
        people.setId(1L);

        People people1 = userService.selectPeople(people);
        people1.getCreatTime();

//        Calendar c = Calendar. getInstance();
//        c.setTimeInMillis(time);
//        System.out.println(c);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(d);

        Date i = new Date();

        System.out.println(i);

    }

    @Test
    public void test3() {
        People people = new People();
        people.setJob(1);
        people.setId(1);
        userService.job(people);
    }

    @Test
    public void test10() {
        List<Company> companies = companyService.listCompany();
        for (Company c : companies) {
            System.out.println(c.toString());
        }
    }

    @Test
    public void test11() {
        Company company =new Company();
        company.setCompanyId(1L);
        Company company1= companyService.selectCompany(company);
        System.out.println(company1);
    }

    @Test
    public void test12(){
        List<People> peo = userService.listJob();
        for(People p:peo){
            System.out.println(p);
        }
    }

    @Test
    public void test13(){
        List<Profession> list=profService.group();
        List<Profession> list1=new ArrayList<>();
        List<Profession> list2=new ArrayList<>();
        List<Profession> list3=new ArrayList<>();
        System.out.println(list.size());
        for(Profession p : list){
            switch (p.getProfGroup()){
                case "1" :
                    list1.add(p);
                    System.out.println(p.getProfName()+"1"+p.getSum());
                    break;
                case "2" :
                    list2.add(p);
                    System.out.println(p.getProfName()+p.getSum());
                    break;
                case "3" :
                    list3.add(p);
                    break;
            }
        }
    }

}
