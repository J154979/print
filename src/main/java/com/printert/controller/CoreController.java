package com.printert.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.poi.word.Word07Writer;
import cn.hutool.poi.word.WordUtil;
import com.printert.util.OutPrintUtil;
import com.printert.util.PrintImageUtil;
import com.printert.util.PDFPrintUtil;
import com.printert.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/core")
public class CoreController {
    @Value("${config.officePath}")
    String wordApp;
    @Value("${config.prints}")
    String prints;

    List<String> fileTypes = List.of(new String[]{ "doc", "docx", "DOC", "DOCX","xls","xlsx"});
    @GetMapping("/startPrint")
    public Result<?> startPrint(@RequestParam("uuid") String flag, @RequestParam("printerName") String printerName) {
        OutputStream os;  // 新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/files/";  // 定于文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);  // 获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");  // 找到跟参数一致的文件
        if (StrUtil.isBlank(fileName)) {
            return Result.error("500", "未找到文件");
        }
        String[] split = fileName.split("\\.");
        String fileType = split[1].toLowerCase();
        if (fileType.equals("pdf")) {
            return Result.success(PDFPrintUtil.print(FileUtil.file(basePath + fileName), printerName));
        } else if (fileTypes.contains(fileType)){
            return Result.success(OutPrintUtil.print(basePath + fileName, wordApp));
        }else {
            return Result.success(PrintImageUtil.print(basePath + fileName, 1));
        }
    }
    @GetMapping("/config")
    public Result<?> config(){
        return Result.success(prints.split(","));
    }
}
