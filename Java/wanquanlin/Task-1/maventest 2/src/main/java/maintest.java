
import Dao.MaintestDAO;
import POJO.User;
import POJO.creatsession;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
public class maintest{
    public static void main(String[] args) throws IOException{
        long start=System.currentTimeMillis();
        creatsession i=new creatsession();
        SqlSession sqlSession=i.getSession();
        for (int s=0;s<=1000;s++){
        MaintestDAO maintestDAO = sqlSession.getMapper(MaintestDAO.class);
        User user=new User("ss",null,"m","las");
        sqlSession.insert("test2.insertUser",user);
        sqlSession.commit();
        }
        sqlSession.close();
        long end=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(end-start)/1000+"S");
     }
    }