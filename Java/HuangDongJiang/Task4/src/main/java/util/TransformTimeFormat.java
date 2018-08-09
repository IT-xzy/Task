package util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TransformTimeFormat {
	//方法必须为静态
	public static String transformTimeFormat(String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = new Date(System.currentTimeMillis());
		return simpleDateFormat.format(date);
	}
}
