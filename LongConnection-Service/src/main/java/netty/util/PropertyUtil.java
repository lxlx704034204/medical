package netty.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 * Desc:properties文件获取工具类
 */
public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static Properties props;

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
//        logger.info("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
            //通过类加载器进行获取properties文件流
            in = PropertyUtil.class.getClassLoader().getResourceAsStream("application.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("application.properties file not found");
        } catch (IOException e) {
            logger.error("error IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("application.properties close error");
            }
        }
//        logger.info("加载properties文件内容完成...........");
        logger.info("properties file context:" + props);
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }

    public static void main(String[] args) {
        String properties_1 = PropertyUtil.getProperty("HOST");
        System.out.println("HOST = " + properties_1);

        String properties_2 = PropertyUtil.getProperty("PORT");
        System.out.println("PORT = " + properties_2);
    }
}