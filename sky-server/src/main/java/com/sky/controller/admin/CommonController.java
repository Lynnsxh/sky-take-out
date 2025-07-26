package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(tags = "通用接口")
public class CommonController {
    private static final String LOCAL_FILE_PATH = System.getProperty("user.dir") + File.separator + "uploads";

    private static final String accessUrl = "http://localhost:8080/uploads";
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file){
        //获取文件的原始文件名，通过原始文件名获取文件后缀
        String originalFilename = file.getOriginalFilename();  // 文件的原始名称    aaa.png
        log.info("文件的原始名称：{}", originalFilename);
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        log.info("文件的类型：{}", fileType);

        //使用UUID重新生成文件名，防止文件名称重复造成文件覆盖
        String newFileName = UUID.randomUUID().toString() + fileType;
        System.out.println("新的文件名为：" + newFileName);

        // 如果当前文件的父级目录不存在，就创建
        File filePath = new File(LOCAL_FILE_PATH);
        if(!filePath.exists()){
            filePath.mkdirs();
        }


        File saveFile = new File(LOCAL_FILE_PATH + File.separator + newFileName);   // 要保存的文件地址/目录
        try {
            file.transferTo(saveFile);  // 存储文件到本地的磁盘里面去
            // 返回文件的链接，这个链接就是文件的下载地址，这个下载地址就是我的后台提供出来的
            String url = accessUrl + "/" + newFileName;
            log.info("文件的下载地址：{}", url);
            return Result.success(url);

        } catch (IOException e) {
           log.error("文件上传失败：{}", e);
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);

    }
}
