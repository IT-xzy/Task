package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @Description: 读取properties文件工具类
 */
public class PropertyUtil {
    private static final Logger logger = LogManager.getLogger(PropertyUtil.class);
    private static Properties props;

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
        String filename = "aliyunEmail.properties";
        logger.info("开始加载properties文件内容......");
        props = new Properties();
        InputStream in = null;

        try {
            //<!--第一种，通过类加载器进行获取properties文件流-->
            in = PropertyUtil.class.getClassLoader().getResourceAsStream(filename);
            //<!--第二种，通过类进行获取properties文件流-->
//            in = PropertyUtil.class.getResourceAsStream("/"+filename);
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException!");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("关闭文件流出现异常！");
            }
        }
        logger.info("加载properties文件内容完成......");
        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key){
        if(null == props){
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue){
        if(null == props){
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}
