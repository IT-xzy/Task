package cached;
 import redis.clients.jedis.Jedis;
 import redis.clients.jedis.JedisPool;
 import redis.clients.jedis.JedisPoolConfig;
 import redis.clients.jedis.ScanResult;

 import java.util.List;


public class RedisTool {
    private static JedisPool pool = null;
    public static JedisPool getPool() {
           if (pool == null) {
        JedisPoolConfig config = new JedisPoolConfig();
        //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxIdle(-1);
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(5);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000 * 100);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "127.0.0.1", 6379);
    }
        return pool;
}

    /**
     * 返还到连接池
     *
     * @param pool
     * @param redis
     */
    public static void returnResource(JedisPool pool, Jedis redis) {
        if (redis != null) {
            pool.close();
        }
    }

    /**
     * 获取数据
     *
     * @param
     * @return
     */
    public static Jedis getConn(){
        return getPool().getResource();
    }

    public static void main(String[] args) {
        try {
            getConn().set("jobList", "qweqweqweqwe");
        } catch (Exception e) {
            System.out.println("123123123123");
        }
    }
    }

