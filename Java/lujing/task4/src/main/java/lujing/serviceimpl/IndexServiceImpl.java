package lujing.serviceimpl;


import lujing.mapper.LearnMapper;
import lujing.pojo.Learn;
import lujing.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LUJING
 * Create_at 2017/12/28 10:41
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private LearnMapper learnMapper;
    
    
    /**
     * @return 返回所有的学习路径信息。
     */
    @Override
    public List<Learn> selectLearnALL() {
        List<Learn> all = learnMapper.selectAll();
        
        return all;
    }
    
    /**
     *
     * @return 返回在学总人数
     */
 
}
