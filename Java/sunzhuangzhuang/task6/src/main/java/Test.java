import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test {
    public static void main(String[] args){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(50);//最大空闲数
        poolConfig.setMaxTotal(100); //最大连接数
        poolConfig.setMaxWaitMillis(20000);//最大等待毫秒数
        //使用配置创建连接池
        JedisPool jedisPool = new JedisPool(poolConfig,"localhost");
        //从连接池获得单个连接
        Jedis jedis = jedisPool.getResource();
        //如果需要密码
        //jedis.auth("password");

        jedis = new Jedis("localhost",6379);
        int i = 0;
        try {
            long start = System.currentTimeMillis();
            while (true){
                long end = System.currentTimeMillis();
                if(end-start>= 1000){
                    break;
                }
                i++;
                jedis.set("test"+i,i+"");
            }
        }finally {
            jedis.close();
        }
        System.out.println("redis每秒操作："+i+"次");
        //可以看一下每秒对数据写入多少次
    }
}
