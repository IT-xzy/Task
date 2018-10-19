package task06.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class SerializeUtil {
	//序列化对象
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			oos.close();
			baos.close();
			return bytes;
		} catch (Exception e) {

		}
		return null;
	}
	//序列化list对象
	public static byte[] serializeList(List<?> list){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			for(Object object : list){
				oos.writeObject(object);
			}
			oos.writeObject(null);
			oos.close();
			bos.close();
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	//反序列化对象
	public static Object unserialize( byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			ois.close();
			bais.close();
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//反序列化list对象
	public static List<Object> unserializeList(byte[] bytes){
		List<Object> list = new ArrayList<Object>();
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			if(bytes != null) {
				bais = new ByteArrayInputStream(bytes);
				ois = new ObjectInputStream(bais);
				while (true) {
					Object object = (Object) ois.readObject();
					if (object == null) {
						break;
					} else {
						list.add(object);
					}
				}
			}
			ois.close();
			bais.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
