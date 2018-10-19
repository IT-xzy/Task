package task05.dao;

import org.springframework.stereotype.Repository;
import task05.pojo.Students;

import java.util.List;
@Repository
public interface StuDao {

     int querySum();

     int queryWorkSum();

     List<Students> queryFrontList();

     int queryWorkSum1(String s);



}
