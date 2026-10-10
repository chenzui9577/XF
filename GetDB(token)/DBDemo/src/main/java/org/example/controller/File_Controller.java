package org.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Dict;
import org.example.common.HoneyLogs;
import org.example.common.LogType;
import org.example.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.example.common.AuthAccess;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class File_Controller {

    @Value("${ip:localhost}")
    String ip;
    @Value("${server.port}")
    String port;
    private static final String ROOT_PATH =  System.getProperty("user.dir") + File.separator + "files";

    @HoneyLogs(operation = "文件", type = LogType.ADD)
    @PostMapping("/upload")
        public Result upload(MultipartFile file) throws IOException {
            String originalFilename = file.getOriginalFilename();  // 文件的原始名称
        String mainName = FileUtil.mainName(originalFilename);
        String extName = FileUtil.extName(originalFilename);
        if (!FileUtil.exist(ROOT_PATH)) {
            FileUtil.mkdir(ROOT_PATH);  // 如果当前文件的父级目录不存在，就创建
        }
        if (FileUtil.exist(ROOT_PATH + File.separator + originalFilename)) {  // 如果当前上传的文件已经存在了，那么这个时候我就要重名一个文件名称
            originalFilename = System.currentTimeMillis() + "_" + mainName + "." + extName;
        }
        File saveFile = new File(ROOT_PATH + File.separator + originalFilename);
        file.transferTo(saveFile);  // 存储文件到本地的磁盘里面去
        String url = "http://" + ip + ":" + port + "/file/download/" + originalFilename;
        return Result.succeed(url);  //返回文件的链接，这个链接就是文件的下载地址，这个下载地址就是我的后台提供出来的
    }

    @AuthAccess
    @GetMapping("/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        response.addHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(fileName, "UTF-8"));  // 预览
        String filePath = ROOT_PATH  + File.separator + fileName;
        //String filePath = "src/main/resources/files/消防部件明细模板.xlsx";
        if (!FileUtil.exist(filePath)) {
            return;
        }
        byte[] bytes = FileUtil.readBytes(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);  // 数组是一个字节数组，也就是文件的字节流数组
        outputStream.flush();
        outputStream.close();
    }

    @HoneyLogs(operation = "文件", type = LogType.ADD)
    @PostMapping("/editor/upload")
    public Dict editorUpload(@RequestParam MultipartFile file, @RequestParam String type) throws IOException {
        String originalFilename = file.getOriginalFilename();  // 文件的原始名称
        // aaa.png
        String mainName = FileUtil.mainName(originalFilename);  // aaa
        String extName = FileUtil.extName(originalFilename);// png
        if (!FileUtil.exist(ROOT_PATH)) {
            FileUtil.mkdir(ROOT_PATH);  // 如果当前文件的父级目录不存在，就创建
        }
        if (FileUtil.exist(ROOT_PATH + File.separator + originalFilename)) {  // 如果当前上传的文件已经存在了，那么这个时候我就要重名一个文件名称
            originalFilename = System.currentTimeMillis() + "_" + mainName + "." + extName;
        }
        File saveFile = new File(ROOT_PATH + File.separator + originalFilename);
        file.transferTo(saveFile);  // 存储文件到本地的磁盘里面去
        String url = "http://" + ip + ":" + port + "/file/download/" + originalFilename;
        if ("img".equals(type)) {  // 上传图片
            return Dict.create().set("errno", 0).set("data", CollUtil.newArrayList(Dict.create().set("url", url)));
        } else if ("video".equals(type)) {
            return Dict.create().set("errno", 0).set("data", Dict.create().set("url", url));
        }
        return Dict.create().set("errno", 0);
    }

}
