package task04tiles.dao;

import org.springframework.stereotype.Repository;
import task04tiles.pojo.Students;

import java.util.List;
@Repository
public interface StuDao {

    public int querySum();

    public int queryWorkSum();

    public List<Students> queryFrontList();

}
