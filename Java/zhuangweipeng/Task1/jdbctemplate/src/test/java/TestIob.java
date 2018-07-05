import dao.JobDAO;
import daoImpl.JobDAOImpl;

import java.sql.SQLException;
import java.util.Date;

public class TestIob {

    public static void main(String[] args) throws SQLException {
        JobDAO jobdao = new JobDAOImpl();
        long time = new Date().getTime();
        int res;
        res = jobdao.insert("java工程师",3,time,time);
        if (res>0)
            System.out.println("插入成功，插入"+res+"条");
        else System.out.println("插入失败！！！");
        res = jobdao.update("java工程师",13);
        if(res>0)
            System.out.println("更新成功！！");
        else
            System.out.println("更新失败！！");
        res = jobdao.delete("java工程师");
        if(res>0)
            System.out.println("删除成功！");
        else
            System.out.println("更新失败！");
        jobdao.select("java研发工程师");

    }
}
