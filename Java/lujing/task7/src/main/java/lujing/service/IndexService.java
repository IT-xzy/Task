package lujing.service;

import lujing.pojo.Learn;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LUJING
 * Create_at 2017/12/28 10:39
 */
@Service
public interface IndexService {
    //查询所有学习方法
    public List<Learn> selectLearnALL();
    
    //查询在学人数
   
    
}
