package lujing.service;

import lujing.pojo.GoodStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/28 15:16
 */
@Service
public interface GoodStudentService {
    int countStudying();
    
    int countWorking();
 
    //查询所有优秀学员
    List<GoodStudent> getGoodStudents();
}
