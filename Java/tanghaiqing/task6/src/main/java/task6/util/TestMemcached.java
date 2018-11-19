package task6.util;


import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class TestMemcached {
    private static MemCachedClient cachedClient;

    public static void main(String[] args) {
        cachedClient = new MemCachedClient();
        //使用的服务器，由于是在本地测试，只有一个服务器地址。默认端口是11211
        //格式为 服务器IP:端口号
        String[] addr = {"127.0.0.1:11211"};
        /**
         * 设置权重，与设定的服务器一一对应
         */
        Integer[] weight = {3};
        //建立通信的连接池
        SockIOPool pool = SockIOPool.getInstance();
        //设置连接池可用cache服务器列表，服务器构成形式：ip地址+端口号
        pool.setServers(addr);
        //设置连接池可用cache服务器的权重，和server数组的位置一一对应
        pool.setWeights(weight);
        //设置初始连接数
        pool.setInitConn(5);
        //设置最小连接数
        pool.setMinConn(5);
        //设置最大连接数
        pool.setMaxConn(200);
        //设置可用连接的最长等待时间
        pool.setMaxIdle(1000 * 30 * 30);
        //设置连接池维护线程的睡眠时间，设置为0，维护线程不启动
        pool.setMaintSleep(30);
        //设置Nagle算法，设置为false，因为通讯数据量比较大要求相应及时
        pool.setNagle(false);
        //设置socket读取等待超时时间
        pool.setSocketTO(30);
        //设置连接等待超时值
        pool.setSocketConnectTO(0);
        //设置完参数后，启动pool
        pool.initialize();

        System.out.println(cachedClient.set("111", "haqing"));
        System.out.println(cachedClient.get("111"));


    }
}
