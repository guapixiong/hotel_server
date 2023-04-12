package com.ncu.hotel_server.controller;

import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传类
 *
 * @author : guaPi
 * @date : 2023-04-04 13:38
 **/
@Api("文件上传")
@RestController
@RequestMapping("/common")
public class FileController {
    @Value("${file.images.path}")
    private String imagesPath;
    @PostMapping("/images/upload")
    public String imagesUpload(@Param("file")MultipartFile file){
        //原始文件名
        String originalFilename = file.getOriginalFilename();//xxx.png
        //对原始名进行截取"."后面的字符
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));//.png
        //使用UUID重新生成文件名，防止文件名称重复造成文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;
        //创建一个目录对象
        File dir = new File(imagesPath);
        //判断当前目录是否存在：目录不存在，需要创建
        if(!dir.exists()) dir.mkdirs();
        try {
            //将临时文件转存到指定位置
            file.transferTo(new File(imagesPath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/images/"+fileName;
    }

    @GetMapping("/images/download")
    public void download(String name, HttpServletResponse response) throws IOException {
        //输入流，通过输入流读取文件内容
        FileInputStream fileInputStream = new FileInputStream(new File(imagesPath + name));
        //输出流，通过输出流将文件写回浏览器
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("image/png");
        int len = 0;
        byte[] bytes = new byte[1024];
        try {
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
