import com.jnshu.pojo.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main (String[] args) throws IOException{
        String resource = "mybatis-config.xml";
        //将硬盘中的xml变成一个输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用流对象创建一个会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //session就是程序员与数据库交互的入口
        SqlSession session = sqlSessionFactory.openSession();
        student c = session.selectOne("getCategory",3);
        System.out.println(c.getName());
//        listALL(session);
        //对话提交
        session.commit();
        //对话关闭，释放资源
        session.close();

    }
    private static void listALL(SqlSession session){

        List<student> cs = session.selectList("listStudent");
           for (student c : cs) {
               System.out.println(c.getId()+c.getDeclaration()+c.getName());
           }
    }
}
