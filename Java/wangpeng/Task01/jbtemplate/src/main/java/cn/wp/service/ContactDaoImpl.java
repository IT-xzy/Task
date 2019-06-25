/**
 * Author：老王
 * Time：2019/3/28 13:13
 **/

package cn.wp.service;

import cn.wp.dao.ContactDao;
import cn.wp.po.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用JDBCTemplate实现增删改查的具体实现
 */
public class ContactDaoImpl implements ContactDao {

    // 若未继承JdbcDaoSupport则声明一个JdbcTemplate变量jTemplate来注入
    private JdbcTemplate jTemplate;

    public void setjTemplate(JdbcTemplate jTemplate) {
        this.jTemplate = jTemplate;
    }

    //增
    public void add(Contact contact) throws SQLException {
        String sql = "insert into contact values(?,?,?,?,?)";
        jTemplate.update(sql, contact.getID(), contact.getName(),
                contact.getEmail(), contact.getQQ(), contact.getGender());
    }

    //删
    public void remove(int ID) throws SQLException {
        String sql = "delete from contact where id=?";
        jTemplate.update(sql, ID);
    }

    //改
    public void update(Contact contact) throws SQLException {
        String sql = "update contact set name=?,email=?,qq=?,gender=? where ID=?";
        jTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getQQ(),
                contact.getGender(), contact.getID());
    }

    //查
    public List<Contact> findAll() throws SQLException {
        String sql = "select * from contact";

        List<Contact> list = jTemplate.query(sql, new RowMapper<Contact>() {
            public Contact mapRow(ResultSet rs, int i) throws SQLException {
                Contact d = new Contact();
                d.setID(rs.getInt("ID"));
                d.setName(rs.getString("Name"));
                d.setEmail(rs.getString("Email"));
                d.setQQ(rs.getInt("QQ"));
                d.setGender(rs.getString("Gender"));
                return d;
            }
        });
        return list;
    }

}
/*org.springframework.jdbc.BadSqlGrammarException:
 PreparedStatementCallback; bad SQL grammar [insert into database values(?,?,?,?,?)];
 nested exception is java.sql.SQLSyntaxErrorException:
 You have an error in your SQL syntax;
  check the manual that corresponds to your
  MySQL server version for the right syntax to use near
  'database values(8,'hsk','12345@qq.com',56789,'女')' at line 1
 */
