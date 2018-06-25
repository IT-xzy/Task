package com.zyq.Index;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class InsertData {

    public void insert(Integer num){
        Connection connection = C3P0Util.getConnection();
        String prefix = "insert into student"+ num +" (name ,qq,profession,university) values";
        PreparedStatement preparedStatement = null;
        Long begin = new Date().getTime();
        try{
            StringBuffer suffix = new StringBuffer();
            connection.setAutoCommit(false);
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < 10000; j++) {
                    suffix.append("('"+randomCC()+"',779672655,'JAVA工程师','北京北方工业大学'),");
                }
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.execute();
                connection.commit();
                suffix = new StringBuffer();
            }
        }catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("回滚的时候出现异常了");
            }
            e.printStackTrace();
        }finally {
            C3P0Util.close(connection,preparedStatement,null);
        }
        Long end = new Date().getTime();
        System.out.println("插入"+num+"W条数据用时:"+(end-begin)/1000+"s");
    }

    public String randomCC(){
        return String.valueOf((char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1))));
    }
}
