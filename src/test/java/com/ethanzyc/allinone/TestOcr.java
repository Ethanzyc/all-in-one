package com.ethanzyc.allinone;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;

import java.io.File;

/**
 * @author ethan
 * @date 2019/9/26 15:16
 */
public class TestOcr {

    @Test
    public void testOcr() {
        ITesseract instance = new Tesseract();
        instance.setDatapath("/Users/ethan/Learning/Code/all-in-one/src/main/resources/tessdata");
        instance.setLanguage("chi_sim");

        File file = new File("/Users/ethan/Pictures/testocr.png");
        try {
            String result = instance.doOCR(file);
            System.out.printf(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
