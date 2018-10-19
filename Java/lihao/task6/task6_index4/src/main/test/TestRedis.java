import redis.clients.jedis.Jedis;

/**
 * #Title: TestRedis
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/17-10:54
 */


public class TestRedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "yeahhhh");
        String value = jedis.get("foo");
        System.out.println(value);
    }
}
