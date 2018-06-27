package com.ev.cache;

import com.ev.DAO.GoodOneDAO;
import com.ev.entity.GoodOne;
import com.ev.entity.User;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeoutException;

@Component
public class GoodOneCache extends MemcachedBasis {

    private Logger log = Logger.getLogger(GoodOneCache.class);

    private final GoodOneDAO goodOneDAO;

    @Autowired
    public GoodOneCache(MemcachedClient memcachedClient, GoodOneDAO goodOneDAO) {
        super(memcachedClient);
        this.goodOneDAO = goodOneDAO;
    }

    /**
     * 设置缓存
     *
     * @param goodOne 优秀学生
     * @return
     */
    public Boolean set(GoodOne goodOne) {
        Boolean result = false;
        try {
            result = memcachedClient.set(getCacheKey(goodOne.getId()), super.Exptime, goodOne);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            log.error("set_error", e);
        }
        return result;
    }

    /**
     * 获取缓存
     *
     * @param id 学员ID
     * @return
     */
    public GoodOne get(Long id) throws Exception {
        GoodOne goodOne;
        try {
            goodOne = memcachedClient.get(getCacheKey(id));
            if (goodOne == null || goodOne.getId() <= 0) {
                goodOne = goodOneDAO.findById(id);
                this.set(goodOne);
            }
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            log.error("get_error", e);
            goodOne = goodOneDAO.findById(id);
        }
        return goodOne;
    }

    /**
     * 删除缓存
     *
     * @param id 用户ID
     * @return
     */
    public Boolean delete(long id) {
        try {
            return memcachedClient.delete(getCacheKey(id));
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            log.error("111", e);
        }
        return false;
    }

    /**
     * 获取缓存 Key
     *
     * @param id 用户ID
     * @return
     */
    private String getCacheKey(long id) {
        return super.Prefix + "GoodOne:" + id;
    }
}
