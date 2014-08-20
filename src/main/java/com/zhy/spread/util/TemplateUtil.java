package com.zhy.spread.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 模板工具类
 * 
 * @author zhy
 * 
 */
public class TemplateUtil {

    public static Logger logger = Logger.getLogger(TemplateUtil.class);

    /**
     * 模板
     */
    private static Properties properties;

    static {
        init();
    }

    private synchronized static void init() {
        if (properties == null) {
            try {
                logger.info("[TemplateService]: Loading template.properties....");
                properties = new Properties();
                InputStream inputStream = TemplateUtil.class.getClassLoader()
                        .getResourceAsStream("template.properties");
                properties.load(new InputStreamReader(inputStream, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 返回模板信息
     * 
     * @param key
     * @param args
     * @return
     */
    public static String getMessage(String key, String... args) {
        String result = "";
        if (properties.containsKey(key)) {
            result = properties.getProperty(key);
        }
        if (args != null && args.length > 0) {
            return MessageFormat.format(result, args);
        }
        return result;
    }

    public boolean contains(String key) {
        return properties.contains(key);
    }

}
