package com.printert.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import javax.print.PrintService;
import java.awt.print.PrinterJob;
import java.io.File;

public class PDFPrintUtil {

    public static String print(File file,String printerName ) {
        // 文件路径
//        String pdfFile =  "D:\\迅雷下载\\A.pdf";
//        // 打印机名称
//        String printerName = "P1505n";
        try {
            // 加载PDF文档
            PDDocument document = PDDocument.load(file);
            // 创建打印任务
            PrinterJob job = PrinterJob.getPrinterJob();
            // 定位打印服务
            PrintService printService = null;
            // 获取本地所有打印服务
            PrintService[] printServices = PrinterJob.lookupPrintServices();
            if (printServices == null || printServices.length == 0) {
                return "打印失败，未找到可用打印机，请检查。";
            }
            // 匹配指定打印机
            for (int i = 0; i < printServices.length; i++) {
                System.out.println(printServices[i].getName());
                if (printServices[i].getName().contains(printerName)) {
                    printService = printServices[i];
                    break;
                }
            }
            if (printService == null) {
                return("打印失败，未找到名称为" + printerName + "的打印机，请检查。");
            }
            // 设置打印格式
            job.setPageable(new PDFPageable(document));
            // 设置打印机
            job.setPrintService(printService);
            // 打印文档
            job.print();
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return "打印成功";
    }
}
