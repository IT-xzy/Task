package com.ev.DAO;

import com.ev.cache.GoodOneCache;
import com.ev.entity.GoodOne;
import com.ev.entity.Occupation;
import com.ev.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DAOTest {

    @Autowired
    GoodOneDAO goodOneDAO;

    @Autowired
    GoodOneCache goodOneCache;

    @Autowired
    OccupationDAO occupationDAO;

    @Autowired
    StudentGeneralInfoDAO studentGeneralInfoDAO;

    @Autowired
    UserDAO userDAO;

    @Test
    public void testGoodOneDAO() throws Exception {
        GoodOne goodOneForTest = new GoodOne("test_name1", "test_intro1", "test_path1", 123L, 123L);

        System.out.println(goodOneForTest);


        Long[] ids = {1L, 2L, 3L, 4L};
        GoodOne goodOne;
        List<GoodOne> goodOnes = new ArrayList<>();
        for (Long id : ids) {
            goodOne = goodOneCache.get(id);
            goodOnes.add(goodOne);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>" + goodOnes);
//        System.out.println(goodOneDAO.addGoodOne(goodOneForTest));
//        System.out.println(goodOneDAO.findById(1L));
//        System.out.println(goodOneDAO.findAllGoodOnes());
    }

    @Test
    public void testOccupationDAO() throws Exception {
        Occupation occupationForTest = new Occupation("test_name1", "test_direction1", "test_des_det", "test_des_gen", 111, 222, "test_cycle", 333, "test_sal_fre", "test_sal_jun", "test_sal_sen", 444, "test_tips", 1L, 2L);

        System.out.println(occupationForTest);

//        System.out.println(occupationDAO.addOccupation(occupationForTest));
        System.out.println(occupationDAO.findAllOccupation());
    }

    @Test
    public void testStudentGeneralInfoDAO() throws Exception {
        System.out.println(studentGeneralInfoDAO.selectMainStatus());
    }

    @Test
    public void testUserDAO() throws Exception {
        User userForTest = new User("test_name", "test_key_value", System.currentTimeMillis() + "test_email", "test_phone_number", 1L, 2L, "test_salt");

        System.out.println(userForTest);
//        System.out.println(userDAO.addUser(userForTest));
        System.out.println(userDAO.findByEmail("123@email.com"));
        System.out.println(userDAO.findById(1L));
        System.out.println(userDAO.findByName("123"));
        System.out.println(userDAO.findByPhoneNumber("13111111111"));
    }

}