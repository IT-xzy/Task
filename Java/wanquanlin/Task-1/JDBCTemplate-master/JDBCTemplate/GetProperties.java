package JDBCTemplate;



import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class GetProperties {
        Reader r;
        public Properties GetProp(){
           Properties prop=new Properties();
            try {
              r=new FileReader("E:\\Mypractice\\src\\main\\resources\\db.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                prop.load(r);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prop;
        }
  /*  public static void main(String[] args) {
            GetProperties p=new GetProperties();
       Properties prop=p.GetProp();
        prop.getProperty("name");
        System.out.println(prop.getProperty("name"));
    }*/
    }


