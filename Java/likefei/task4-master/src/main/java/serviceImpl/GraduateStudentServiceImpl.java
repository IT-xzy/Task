package serviceImpl;

import mapper.GraduateStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GraduateStudentService;

@Service
public class GraduateStudentServiceImpl implements GraduateStudentService{
@Autowired
    GraduateStudentMapper graduateStudentMapper;
    @Override
    public int gettotal() {
        return graduateStudentMapper.gettotal();
    }
}
