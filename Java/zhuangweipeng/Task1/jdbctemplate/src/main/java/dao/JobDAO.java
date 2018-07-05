package dao;

public interface JobDAO {
     int insert(String jname, int number, long create_at, long update_at);
     int update(String jnmae, int number);
     int delete(String jname);
     void select(String jname);
}
