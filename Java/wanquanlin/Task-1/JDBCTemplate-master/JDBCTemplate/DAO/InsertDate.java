package JDBCTemplate.DAO;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsertDate {
    private static long current_time;
    private static String update_at;
    private static String c;
    private String u;
  /*  public String getTime(){*/
  public String getCurrent_time(){
//      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      current_time=System.currentTimeMillis();
//      System.out.println(current_time);
      c=Long.toString(current_time);
      return c;
    }

}
