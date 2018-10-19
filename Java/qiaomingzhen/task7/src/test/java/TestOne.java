import com.mapper.UserMapper;
import com.model.Company;
import com.model.People;
import com.model.Profession;
import com.service.CompanyService;
import com.service.ProfService;
import com.service.UserService;
import com.util.task5.DESUtil;
import com.util.task5.MD5Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private UserMapper userMapper;
    @Autowired
    @Qualifier("userServiceImpl")
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
        Company company = new Company();
        company.setCompanyId(1L);
        Company company1 = companyService.selectCompany(company);
        System.out.println(company1);
    }

    @Test
    public void test12() {
        List<People> peo = userService.listJob();
        for (People p : peo) {
            System.out.println(p);
        }
    }

    @Test
    public void test13() {
        List<Profession> list = profService.group();
        List<Profession> list1 = new ArrayList<>();
        List<Profession> list2 = new ArrayList<>();
        List<Profession> list3 = new ArrayList<>();
        System.out.println(list.size());
        for (Profession p : list) {
            switch (p.getProfGroup()) {
                case "1":
                    list1.add(p);
                    System.out.println(p.getProfName() + "1" + p.getSum());
                    break;
                case "2":
                    list2.add(p);
                    System.out.println(p.getProfName() + p.getSum());
                    break;
                case "3":
                    list3.add(p);
                    break;
            }
        }
    }

    @Test
    public void test30() {
        String name = "鼠标";
        String passward = "123456";
        People people = userMapper.selectByName(name);
        System.out.println(people.toString());
        userService.login(name, passward);
//        System.out.println(b);
    }

    @Test
    public void listByName() throws Exception {
        DESUtil desUtil = new DESUtil();
        long loginTime = System.currentTimeMillis();
        String str1 = desUtil.encryptFromLong(loginTime);
        System.out.println(str1);
        long str2 = desUtil.decryptToLong(str1);
        System.out.println("l" + str2);
        System.out.println(desUtil.encrypt("wangqichao"));
        System.out.println(desUtil.encrypt("wangqichao"+"|"+1111111));
        System.out.println(desUtil.encrypt("wangqi"));
    }

    @Test
    public void test150() {
        String plaintext = "DingSai";
        //  plaintext = "123456";
        System.out.println("原始：" + plaintext);
        System.out.println("普通MD5后：" + MD5Util.MD5(plaintext));
        System.out.println("普通MD5后：" + MD5Util.MD5(plaintext));

        // 获取加盐后的MD5值
        String ciphertext = MD5Util.generate(plaintext);
        String ciphertext1 = MD5Util.generate(plaintext);
        System.out.println("加盐后MD5：" + ciphertext);
        System.out.println("加盐后MD5：" + ciphertext1);
        System.out.println("是否是同一字符串:" + MD5Util.verify(ciphertext1, ciphertext));
        /**
         * 其中某次DingSai字符串的MD5值
         */
        String[] tempSalt = {"c4d980d6905a646d27c0c437b1f046d4207aa2396df6af86", "66db82d9da2e35c95416471a147d12e46925d38e1185c043", "61a718e4c15d914504a41d95230087a51816632183732b5a","e3a194b38229e32925b7366761ab67646129b2045c68b404"};

        for (String temp : tempSalt) {
            System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, temp));
        }

        String password = DigestUtils.md5Hex("DingSai");
        System.out.println(password);
    }
}

