package com.printert.util;

import cn.hutool.extra.spring.SpringUtil;

import java.io.File;
import java.io.IOException;

public class OutPrintUtil {

    public static String print(String filePath,String wordApp ) {
        // 打印参数
        String wordParam = "/mFilePrintDefault"; // 使用默认打印机和设置
        //String wordParam = "/mFilePrint"; // 显示打印对话框
        try {
            // 构造命令
            String wordCmd = wordApp + " " + wordParam + " " + filePath;
            // 执行命令
            Process wordProcess = Runtime.getRuntime().exec(wordCmd);
            // 等待命令执行完成
            wordProcess.waitFor();
        } catch (Exception e) {
            return "打印失败";
        }
        return "打印完成";
    }
}
