import com.pojo.Customer;
import com.pojo.Profession;
import com.tools.MemcachedUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestMemcached {
    @Autowired
    private MemcachedUtil memcachedUtil;

//    @Test
//    public void testSetObject() {
//        Customer customer = new Customer();
//        customer.setUsername("葫芦娃");
//        customer.setPassword("123456");
//        customer.setSalt("234234");
//        System.out.println(memcachedUtil.setCustomer(customer, 0));
//        Customer customer1 = memcachedUtil.getCustomer("葫芦娃");
//        if (customer1 != null) {
//            System.out.println(customer1.getUsername());
//            System.out.println(customer1.getAge());
//        }
//    }

    @Test
    public void testGetObject() {
        Profession profession = memcachedUtil.getProfession("java");
        if (profession != null) {
            System.out.println(profession.getProfession());
            System.out.println(profession.getStu_number());
        }
        List<Profession> list = memcachedUtil.getProfessions();
        if (!list.isEmpty()) {
            System.out.println(list);
        }
    }

    @Test
    public void testDeleteObject() {
        if (memcachedUtil.deleteObject("java")) {
            System.out.println("yes");
        }
        System.out.println(memcachedUtil.getProfession("java"));
    }
}
