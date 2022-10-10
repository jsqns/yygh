package com.atguigu.yygh.common.utils;


import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WordToPDF {
    private static boolean license = false;

    public static void main(String[] args) throws Exception {
        wordToPdf();
    }
    public static String wordToPdf() throws Exception {
        FileOutputStream os = null;
        try {
            //凭证 不然切换后有水印
            InputStream is = new ClassPathResource("/license.xml").getInputStream();
            License aposeLic = new License();
            aposeLic.setLicense(is);
            license = true;
            if (!license) {
                System.out.println("License验证不通过...");
                return null;
            }
            //生成一个空的PDF文件
            File file = new File("D:\\大数据授权协议模板.pdf");
            os = new FileOutputStream(file);
            //要转换的word文件
            Document doc = new Document("C:\\Users\\PC\\Desktop\\大数据授权协议.docx");
            doc.save(os, SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
return null;
    }

}