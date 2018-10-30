import com.ptteng.entity.Collection;
import com.ptteng.entity.User;
import com.ptteng.service.CollectionService;
import com.ptteng.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

        @Autowired
        private CollectionService service;


        @Test
        public void test1() {
            Collection collection=new Collection();
            collection.setName("作品集3");
            collection.setStatus(1);
            collection.setCreateAt(System.currentTimeMillis());
            collection.setUpdateAt(System.currentTimeMillis());
            collection.setCreateBy(2L);
            collection.setUpdateBy(3L);

            System.out.println(service.insertCollection(collection));
        }


    }


