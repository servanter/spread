package com.zhy.spread.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class DownloadUtils {

    public static final String FILE_FOLDER = "d:/test/";
    
    public static String downloadPath(String url){
        String webPath = "";
        try {
            GetMethod method = new GetMethod(url);
            // method.setRequestHeader("User-Agent:", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36");
            HttpClient client = new HttpClient();
            client.getParams().setIntParameter("http.socket.timeout", 10000);
            client.executeMethod(method);
            
            // 取图片
            webPath= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + RandomUtils.generateNumberString(6) + url.substring(url.lastIndexOf("."),url.length());
            String filePath = FILE_FOLDER + webPath;
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            fos.write(method.getResponseBody());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return webPath;
    }
    
    public static void main(String[] args) throws IOException {
        List<String> errorLinks = new ArrayList<String>();
        errorLinks.add("www.baidu.com/w1212");
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("d:\\errors\\link.txt"), true));
        for(String error : errorLinks){
            outputStream.write(error.getBytes());
            outputStream.write("\r\n".getBytes());
        }
        outputStream.flush();
        outputStream.close();
        
    }
}
