package com.ethanzyc.allinone.testClasspath;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import static org.springframework.core.io.ResourceLoader.CLASSPATH_URL_PREFIX;

/**
 * @author ethan
 * @date 2019/6/25 22:27
 */
@RestController
public class Classpath {

    @RequestMapping("txt")
    public File getTxt() {
        File file = null;
        try {
            file = ResourceUtils.getFile(CLASSPATH_URL_PREFIX + "123");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        String path = this.getClass().getResource("/").getPath();
//        File file = new File(path + "123");
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
