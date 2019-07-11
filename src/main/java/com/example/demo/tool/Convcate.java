package com.example.demo.tool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

public class Convcate {
	/**
     * doc转pdf
     * @param sourceFileName doc文档的路径 如：C:\Users\weipc\Desktop\html\询问笔录.doc
     * @param newFileName 将要生成的pdf路径 如：C:\Users\weipc\Desktop\html\询问笔录.pdf
     * @throws Exception
     */
    public static void docTurnPdf(String sourceFileName,String newFileName) throws Exception {
        if (!getLicense()) {// 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        File file = new File(newFileName);  //新建一个空白pdf文档
        FileOutputStream os = new FileOutputStream(file);
        Document doc = new Document(sourceFileName);//Address是将要被转化的word文档
        doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
        os.close();
        //删除doc文件，用不到就删掉
        File f = new File(sourceFileName);
        if(f.exists()){
          //  f.delete();
        }
    }

    public static boolean getLicense(){
        boolean result = false;
        try {
        	 
           InputStream is = Convcate.class.getClassLoader().getResourceAsStream("license.xml"); //Test要替换成当前类名  license.xml应放在..\WebRoot\WEB-INF\classes路径下
              
             License aposeLic = new License();
             aposeLic.setLicense(is);
             is.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
		try {
			docTurnPdf("C:\\Users\\Admin\\Desktop\\我的简历.doc", "C:\\Users\\Admin\\Desktop\\我的简历.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

