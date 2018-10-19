package mybatis_spring.service;

import mybatis_spring.POJO.Trainee;

import java.util.List;

public interface TraineeServiceInter {
    void addTn(Trainee trainee);
    int deleteById(int id);
    int updateByNo(Trainee trainee);
    Trainee getInfoByNo(String No);
    Trainee getInfoByName(String name);
    List<Trainee> getRecentInfo();
}
