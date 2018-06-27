import cn.Service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.User.User;

public class SpringTest {
    private UserService userService;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) context.getBean("userservice");
    }

    @After
    public void after() throws Exception {
    }

    //根据id 查询
    @Test

    public void getUserById() {
        try {
            System.out.println(userService.findUserById(1));

        } catch (Exception e) {
            System.out.println("错误：" + e);
        }
    }

    @Test
    // 插入数据 增   并返回插入id

    public void insertUser() {
        User user = new User();
        user.setName("baichensong");
        user.setQq("123565");
        user.setKemu("java");
        user.setStartTime("1211-12-12");
        user.setSchool("世界");
        user.setXuehao(3306);
        user.setRibao("www.bai.song");
        user.setXinyuan("kimjm");
        user.setShixiong("muomuo");

        try {
            userService.insertUser(user);
        } catch (Exception e) {
            System.out.println("错误" + e);
        }
        System.out.println("当前插入id: "+ user.getId());




    }

    // 删除某列。 删
    @Test
    public void deleteId() {
        try {
           System.out.println(userService.deleteUserId(9));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //查询 表内所有数据
    @Test
    public void AllId() {
        try {
            System.out.println(userService.AllId());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test // 修改数据
    public void updateUser() {
        User user = new User();
        user.setId(2);
        user.setName("你好");
        user.setQq("98765");
        try {
          System.out.println(userService.updateUser(user));
        } catch (Exception e) {
            System.out.println(e);
        }


    }
// 根据学生姓名和学号查询
    @Test
    public void findname() {
        User user = new User();
        user.setName("小白");
        user.setXuehao(100);
        try{
           System.out.print(userService.findName(user));
        }catch (Exception e){
            System.out.println(e);
        }
    }



}
