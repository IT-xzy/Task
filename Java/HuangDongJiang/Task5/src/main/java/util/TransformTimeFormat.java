package util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransformTimeFormat {
	//方法必须为静态
	public static String  transformTimeFormat(Long time,String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = new Date(time);
		String formatTime = simpleDateFormat.format(date);
		return formatTime;
	}
}
