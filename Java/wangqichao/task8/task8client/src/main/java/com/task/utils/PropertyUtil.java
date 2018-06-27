package com.task.utils;


import org.apache.log4j.Logger;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载properties文件，并可以通过静态方法调用
 */
public class PropertyUtil {

        private static final Logger logger = Logger.getLogger(PropertyUtil.class);
        private static Properties props;
        static{
            loadProps();
        }

    /**
     * 加载配置文件
     */
        synchronized static private void loadProps(){
            //想要更换配置文件只需要在这里修改proname就可以了
            String proName="telcode.properties";
            logger.info("开始加载properties文件内容.......");
            props = new Properties();
            InputStream in = null;
            try {
//　　　　　　　<!--第一种，通过类加载器进行获取properties文件流-->
//                      in = PropertyUtil.class.getClassLoader().getResourceAsStream(proName);
//　　　　　　  <!--第二种，通过类进行获取properties文件流-->
                        in = PropertyUtil.class.getResourceAsStream("/"+proName+"");
                        props.load(in);
            } catch (FileNotFoundException e) {
                logger.error(proName+"文件未找到");
            } catch (IOException e) {
                logger.error("出现IOException");
            } finally {
                try {
                    if(null != in) {
                        in.close();
                    }
                } catch (IOException e) {
                    logger.error(proName+"文件流关闭出现异常");
                }
            }
            logger.info("加载properties文件内容完成...........");
            logger.info("properties文件内容：" + props);
        }

    /**
     * 获取配置文件中的键值对
     * @param key 键名
     * @return 值
     */
        public static String getProperty(String key){
            if(null == props) {
                loadProps();
            }
            return props.getProperty(key);
        }

    /**
     * 获取键值对，如果没有找到需要的键，就使用默认值
     * @param key 键
     * @param defaultValue 默认值
     * @return 值
     */
        public static String getProperty(String key, String defaultValue) {
            if(null == props) {
                loadProps();
            }
            return props.getProperty(key, defaultValue);
        }
    }

