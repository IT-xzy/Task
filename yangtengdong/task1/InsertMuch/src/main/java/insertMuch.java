

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertMuch {
    Connection connection;
    public void insert(){
        long startime = System.currentTimeMillis();
        //sql语句前缀
        String prefix = "insert into test (id,name,age,create_time,update_time) values";
        try{
            connection = JDBCUtils.getConnection();
            //保存sql语句后缀
            StringBuffer suffix = new StringBuffer();
            //设置事务非自动提交
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("");
            //外层循环,设置总提交事务次数
            for (int i = 1;i<=1000;i++){
                //设置第多少次提交步长
                for (int j = 1;j<=30000;j++){
                    //构建sql语句后缀
                    suffix.append("("+j * i+",\"杨腾东\","+18+","
                            +System.currentTimeMillis()+","+System.currentTimeMillis()+"),");
                  /*  suffix.append("(")
                            .append(j*i)
                            .append(",杨腾东")
                            .append(","+18)
                            .append(","+System.currentTimeMillis())
                            .append(","+System.currentTimeMillis())
                            .append("),");*/
                }
//                System.out.println(suffix.toString());
                //构建完整的sql语句,-1是为了去掉最后()后面的逗号 ,
                String sql = prefix + suffix.substring(0,suffix.length()-1);
                //添加执行sql
                ps.addBatch(sql);
                //执行操作
                ps.executeBatch();
                //提交事务
                connection.commit();
                //清空上一次添加的数据
                suffix = new StringBuffer();
            }
            //关闭连接
            ps.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        long endtime = System.currentTimeMillis();
        System.out.println("插入耗时: "+(endtime-startime)/1000+"秒");
    }

    public static void main(String[] args) {
        insertMuch im = new insertMuch();
        im.insert();
    }
}
