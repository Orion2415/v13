package com.orion.v13centreweb.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.orion.v13.common.pojo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Orion
 */
@Controller
@RequestMapping("file")
public class FileController {

    @Autowired
    private FastFileStorageClient client;

    @Value("${image.server}")
    private String imageServer;

    @RequestMapping("upload")
    @ResponseBody
    public ResultBean upload(MultipartFile file){
        //将文件上传到DFS
        String originalFilename = file.getOriginalFilename();
        String extName =originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        try {
            StorePath storePath = client.uploadFile(file.getInputStream(), file.getSize(),extName,null);
            String path = new StringBuilder(imageServer).append(storePath.getFullPath()).toString();
            return new ResultBean("200",path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultBean("404","网络不稳定，上传失败");

    }
}
