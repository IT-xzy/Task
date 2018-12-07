package jnshu.tool.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

//@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
@Component
public class RedisTakesImpl implements RedisTakes,Serializable {
    private static Logger logger = Logger.getLogger (String.valueOf (RedisTakesImpl.class));//引入日志配置

    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     *     新增一个字符串类型的值,key是键，value是值。
     * @param key key的名字
     * @param value
     */
    @Override
    public void add(Object key, Object value) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            //opsForValue()操作字符串
//            redisTemplate.opsForValue().set (key,value ,1800 );
            redisTemplate.opsForValue().set (key,value );
        }

    }

    /**
     *     新增一个Obj类型的值
     * @param objectKey hashMap的名字
     * @param key 存入map中key的名字
     * @param object map中key的值
     */
    @Override
    public void addObj(Object objectKey, Object key, Object object) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            //opsForHash()操作hash
            redisTemplate.opsForHash().put(objectKey,key,object);
        }
    }

    @Override
    public void delete(Object key) {
        redisTemplate.delete (key);

    }

    @Override
    public void delete(List listKeys) {

    }

    @Override
    public void deletObj(Object objecyKey, Object key) {

    }

    @Override
    public void update(Object key, String value) {

    }

    @Override
    public void updateObj(Object objectKey, Object key, Object object) {

    }

    /**
     *     获取key的值，返回string类型的值
     * @param key key的名字
     * @return
     */
    @Override
    public Object get(Object key) {
        Object value =  redisTemplate.opsForValue().get(key);
        return value;
    }


    /**
     *    获取集合中的一个值,返回object类型的值
     * @param hash hashMap的名字
     * @param hashKey hashMap中的key
     * @return key对应的值
     */
    @Override
    public Object getObj(Object hash, Object hashKey) {
        return redisTemplate.opsForHash ().get (hash, hashKey);
    }

//    @Override
//    public Object getObj(Object objectKey, String key) {
//        return redisTemplate.opsForHash().get(objectKey,key);
//    }
}
