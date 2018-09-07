package mybatis_spring.dao;

import mybatis_spring.POJO.Trainee;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TraineeMapper {
    void addTn(Trainee trainee);
    int deleteById(int id);
    int updateByNo(Trainee trainee);
    Trainee getInfoByNo(String No);
    Trainee getInfoByName(String name);
    Trainee getLink(@Param("t_name") String t_name,@Param("t_No")String t_No);
    List<Trainee> getRecentInfo();
}
