package com.mvc.memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class MemcachedJava {
	/*public static void main(String[] args) {
		try{
			// 本地连接 Memcached 服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("Connection to server sucessful.");

			// 关闭连接
			mcc.shutdown();

		}catch(Exception ex){
			System.out.println( ex.getMessage() );
		}
	}*/

	public static void main(String[] args) {

		try{
			// 连接本地的 Memcached 服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("Connection to server sucessful.");

			// 存储数据
			Future fo = mcc.set("runoob", 900, "Free Education");

			// 查看存储状态
			System.out.println("set status:" + fo.get());

			// 输出值
			System.out.println("runoob value in cache - " + mcc.get("runoob"));

			// 关闭连接
			mcc.shutdown();

		}catch(Exception ex){
			System.out.println( ex.getMessage() );
		}
	}

	/*public static void main(String[] args) {

		try{

			// 连接本地的 Memcached 服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("Connection to server sucessful.");

			// 添加数据
			Future fo = mcc.set("runoob", 900, "Free Education");

			// 打印状态
			System.out.println("set status:" + fo.get());

			// 输出
			System.out.println("runoob value in cache - " + mcc.get("runoob"));

			// 添加
			fo = mcc.add("runoob", 900, "memcached");

			// 打印状态
			System.out.println("add status:" + fo.get());

			// 添加新key
			fo = mcc.add("codingBigPig", 900, "All Free Compilers");

			// 打印状态
			System.out.println("add status:" + fo.get());

			// 输出
			System.out.println("codingground value in cache - " + mcc.get("codingBigPig"));

			// 关闭连接
			mcc.shutdown();

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}*/

	/*public static void main(String[] args) {

		try{

			// 连接本地的 Memcached 服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("Connection to server sucessful.");

			// 添加数据
			Future fo = mcc.set("runoob", 900, "Free Education");

			// 输出执行 set 方法后的状态
			System.out.println("set status:" + fo.get());

			// 使用 get 方法获取数据
			System.out.println("runoob value in cache - " + mcc.get("runoob"));

			// 关闭连接
			mcc.shutdown();

		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}*/
}
