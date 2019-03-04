package com.jnshu.task5.test;

public class TestMemcacahed {
//    public static void main(String[] args) {
//
//        try {
//            MemcachedClient client = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
//            System.out.println("connection to server successful.");
//
//            /**
//             * set
//             */
//            //set 练习
//            Future fo = client.set("runoob",900,"Free Education");
//            System.out.println("set status : " + fo.get());
//            //输出值
//            System.out.println("runoob value in cache - " + client.get("runoob"));
//
//
//
//            /**
//             * add
//             */
//            //add练习
//            fo = client.add("runoob", 900, "memcached");
//            //状态
//            System.out.println("add status : " + fo.get());
//            //添加新的key
//            fo = client.add("codeingground", 900 , "All Free Compilers");
//            System.out.println("add status = " + fo.get());
//
//            System.out.println("codeingground value in cache = " + client.get("codeingground"));
//
//
//            /**
//             * replace
//             */
//            fo = client.replace("runoob",900, "Largest Tutorials Library");
//
//            System.out.println("replace status : " + fo.get());
//
//            System.out.println("runoob value in cache = " + client.get("runoob"));
//
//
//            /**
//             * cas
//             */
//            CASValue casValue = client.gets("runoob");
//            System.out.println("cas value in cache = " + casValue);
//
//
//            CASResponse casResponse = client.cas("runoob",casValue.getCas(),"Largest Tutorials Library");
//
//            System.out.println("cas response = " + casResponse);
//            System.out.println("runoob value in cache = " + client.get("runoob"));
//
//            /**
//             * append
//             */
//            fo = client.append(casValue.getCas(),"runoob"," test append");
//            System.out.println("fo = " + fo);
//            System.out.println("runoob " + fo.get());
//            System.out.println(client.get("runoob"));
//
//            /**
//             * prepend
//             */
//            fo = client.prepend(casValue.getCas(),"runoob","-test prepend - ");
//            System.out.println("runoob " + fo.get());
//            System.out.println(client.get("runoob"));
//            //关闭连接
//            client.shutdown();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//    }


//    public static void main(String[] args) {
//
//        String[] servers = {"localhost:11211"};
//        SockIOPool pool = SockIOPool.getInstance();
//        pool.setServers(servers);
//        pool.setFailover(true);
//        pool.setInitConn(10);
//        pool.setMinConn(5);
//        pool.setMaxConn(250);
//        pool.setMaintSleep(30);
//        pool.setNagle(false);
//        pool.setSocketTO(3000);
//        pool.setAliveCheck(true);
//        pool.initialize();
//
//        MemCachedClient client = new MemCachedClient();
//
//        client.set("test","123321");
//        System.out.println(client.get("test"));
//
//
//    }


//    public static void main(String[] args) {
//        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"));
//        MemcachedClient client = null;
//        try {
//            client = builder.build();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            client.set("test",90,"test xMemcached");
//            String value = client.get("test");
//            System.out.println("test in cache" + value);
//
//
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MemcachedException e) {
//            e.printStackTrace();
//        }
//        try {
//            client.shutdown();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }




}
