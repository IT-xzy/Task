package Test;
//import mybatis.MybatisUse;
import org.junit.Test;
import java.util.List;
import com.spring_mybatis.Category.Category;
import org.apache.ibatis.session.*;
import com.spring_mybatis.Category.CategoryDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
    @Autowired
    private CategoryDao categorydao;
    @Test
    public void testAdd(){
        Category category = new Category();
        category.setName("王刚12");
        categorydao.insert(category);

    }
    @Test
    public void testGet(){
        Category category = new Category();
        categorydao.get(1);
        System.out.println(category.getName());
        }
    @Test
    //修改数据
        public void testUpdate(){
        Category category = new Category();
        category.setId(12);
        category.setName("无名12");
        categorydao.update(category);
        System.out.println(category.toString());
    }
    @Test
    public void testGetAll(){

    List<Category> categories = categorydao.list();
        for(Category c : categories){
            System.out.println(c.toString());
        }
    }
}
