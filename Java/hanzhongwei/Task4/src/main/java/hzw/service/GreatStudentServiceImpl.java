package hzw.service;

import hzw.DAO.GreatStudentMapper;
import hzw.model.Cooperation;
import hzw.model.GreatStudent;
import hzw.model.HowToStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("GreatStudentService")
public class GreatStudentServiceImpl implements GreatStudentService {

    @Autowired
    private GreatStudentMapper greatStudentMapper;

    public List<GreatStudent> findUserByName() throws IOException {
        return greatStudentMapper.findUserByName();
    }
    public List<Cooperation> findCooperation() throws IOException {
        return greatStudentMapper.findCooperation();
    }
    public List<HowToStudy> findStudy() throws IOException {
        return greatStudentMapper.findStudy();
    }
}
