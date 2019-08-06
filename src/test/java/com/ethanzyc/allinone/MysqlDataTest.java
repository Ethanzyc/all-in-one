package com.ethanzyc.allinone;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ethan
 * @date 2019/8/6 08:55
 */
public class MysqlDataTest {

    @Test
    public void generateData() {
        try {
            FileWriter writer = new FileWriter("./1.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            for (int i = 0; i < 10000000; i++) {
                String s = UUID.randomUUID().toString();
                bw.write(i + "," + s + "\n");
            }
            bw.close();
            writer.close();
            System.out.println("end");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
