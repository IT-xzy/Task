package lujing.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author lujing
 * Create_at 2018/1/2 19:39
 */
@Component
public class CustomDateLongConverter implements Converter<String,Long> {
    
    @Override
    public Long convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(source).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null ;
    }
    
//    public Long convert(Date source) {
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        return source.getTime();
//
    
//    }
    
}
