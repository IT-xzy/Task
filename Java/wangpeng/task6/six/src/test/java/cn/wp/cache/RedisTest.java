package cn.wp.cache;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/5 19:14 @Version: 1.0 */
public class RedisTest {
  private static Logger logger = Logger.getLogger(RedisTest.class);

  public static void main(String[] args) {
    // 连接本地redis
    Jedis jedis = new Jedis("127.0.0.1");
    logger.info("连接成功");
    // 插入一条数据
    jedis.set("name", "hello");
    logger.info("插入的数据是==========" + jedis.get("name"));
  }

}
