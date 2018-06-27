package Test;

import java.sql.Statement;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.omg.Dynamic.Parameter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.spring_mybatis.Category.Category;
import com.spring_mybatis.Category.CategorySet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
    @Autowired
    private CategorySet categorySet;
    @Test
    public void testAdd(){
        Category category = new Category();
        category.setName("new Spring_Mybatis11");
        categorySet.add(category);
        System.out.println("输入的ID值： "+category.getId());

    }

    @Test
    public void testUpdate(){
        Category category = new Category();
        categorySet.get(3);
        System.out.println(category.toString());
    }
    @Test
    public void testDelete(){
        Category category = new Category();
       // categorySet.delete(5);
        System.out.println(categorySet.delete(8));
    }

    @Test
    public void testList(){
        System.out.println(categorySet);
        List<Category> cs = categorySet.list();
        for(Category c : cs){
            System.out.println(c.getName());
            System.out.println(c.toString());
        }
    }
}
