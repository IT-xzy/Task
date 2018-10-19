package mybatis_spring.service;

import mybatis_spring.POJO.Trainee;
import mybatis_spring.dao.TraineeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="serviceImpl")
public class ServiceImpl implements TraineeServiceInter {

    @Resource
    private TraineeMapper traineeMapper;

    @Override
    public void addTn(Trainee trainee) {
        traineeMapper.addTn(trainee);
    }

    @Override
    public int deleteById(int id) {
        return traineeMapper.deleteById(id);
    }

    @Override
    public int updateByNo(Trainee trainee) {
        return traineeMapper.updateByNo(trainee);
    }

    @Override
    public Trainee getInfoByNo(String No) {
        traineeMapper.getInfoByNo(No);
        return null;
    }

    @Override
    public Trainee getInfoByName(String name) {
        return traineeMapper.getInfoByName(name);
    }

    @Override
    public List<Trainee> getRecentInfo() {
        return traineeMapper.getRecentInfo();
    }
}
