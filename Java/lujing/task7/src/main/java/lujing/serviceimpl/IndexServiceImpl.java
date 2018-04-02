package lujing.serviceimpl;


import lujing.mapper.LearnMapper;
import lujing.pojo.Learn;
import lujing.service.IndexService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    RedisTemplate redisTemplate;
    
    /**
     * @return 返回所有的学习路径信息。
     */
    @Override
    public List<Learn> selectLearnALL() {
        //先在缓存中查找数据
      if( redisTemplate.opsForHash().hasKey("index","learnlist")){
          List<Learn> all =
                  (List<Learn>) redisTemplate.opsForHash().get("index","learnlist");
          return all;
      }
        List<Learn> all1 = learnMapper.selectAll();
        redisTemplate.opsForHash().put("index","learnlist",all1);
        return all1;
        
    }
    
}
