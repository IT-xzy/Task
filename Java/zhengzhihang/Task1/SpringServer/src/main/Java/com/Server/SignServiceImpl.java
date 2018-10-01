package com.Server;


import com.Dao.Sign;
import com.Dao.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
//用注解方式，将业务层的实现类加到IOC容器中
@Service(value = "ServiceImpl")
public class SignServiceImpl implements SignServiceIF{
    //加载Spring中数据层接口的实现类。DI的注解表示
    // @Autowired  不后面需要像Resource一样去添加id。已经测试成功。
    @Resource(name = "Sql")
    public SignMapper sm;
    public Sign sg;
    public String name;
    public String city;
    public int i;


    public static void main(String[] args) {
        //通过Spring的IOC容器才能得到设个类本身，直接new是得不到的。
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
        SignServiceIF ssf= (SignServiceImpl) ac.getBean("Impl");
        //1:主方法再测试通过id查询

        Sign sg1=ssf.checkUserById(1);
        System.out.println(sg1);

        //2:主方法再测试通过模糊查询

        Sign sg2=ssf.checkUserByName("c");
        System.out.println(sg2);

        //3:主方法再测试 插入数据，并且返回插入成功与否的结果

        Sign sg3=new Sign();
        sg3.setCity("mainCity1");
        sg3.setName("mainName1");
        ssf.puttUser(sg3);
        System.out.println("当前插入后的ID值是"+sg3.getId());

        //4:主方法再测试 通过id删除数据，并且返回删除成功与否的结果

        ssf.cutUserById(10);

        //5：主方法再测试 通过id更新数据，并且返回更新成功与否结果

        Sign sg5=new Sign();
        sg5.setId(9);
        sg5.setName("update1");
        sg5.setCity("upcity1");
        ssf.replayUserById(sg5);

        //6: 主方法再测试 通过列的字段删除数据 ，并且返回更新成功与否结果

        ssf.cutUserByName("update1");
    }

    //一下方法全部都是SignServiceIF 接口的方法。

    //通过id查询
    @Override
    public Sign checkUserById(int id) {
        sg=sm.findUserById(id);
        return sg;
    }

    //通过名字模糊查询
    @Override
    public Sign checkUserByName(String name) {
        sg=sm.findUserByName(name);
        return sg;
    }

    //插入数据并且返回值
    @Override
    public int puttUser(Sign user) {
        i=sm.insertUser(user);
        if (i!=0){
            System.out.println("插入结果：ture");
        }else {
            System.out.println("插入结果：false");
        }
        return i;

    }

    //删除数据并且返回值
    @Override
    public int cutUserById(int id) {
        i=sm.deleteUserById(id);
        if (i!=0){
            System.out.println("删除结果：ture");
        }else {
            System.out.println("删除结果：false");
        }
        return i;
    }

    //通过id更新数据，并且返回结果
    @Override
    public int replayUserById(Sign user) {
        i=sm.updateUserById(user);
        if (i!=0){
            System.out.println("更新结果：ture");
        }else {
            System.out.println("更新结果：false");
        }
        return i;
    }

    //通过名称模糊删除
    @Override
    public int cutUserByName(String name) {
        i=sm.deleteUserByName(name);
        if (i!=0){
            System.out.println("删除结果：ture");
        }else {
            System.out.println("删除结果：false");
        }
        return i;
    }
}