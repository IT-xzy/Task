package ServiceImpl;

import dao.Online_studentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Online_studentService;

@Service
public class Online_studentServiceImpl implements Online_studentService{
    @Autowired
    Online_studentMapper online_studentMapper;
    public int gtotal(){
        return online_studentMapper.gtotal();

    }
}
