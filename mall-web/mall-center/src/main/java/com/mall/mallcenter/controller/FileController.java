package com.mall.mallcenter.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.mall.commons.pojo.ResultBean;
import com.mall.mallcenter.pojo.WangEditorResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author peace
 * 处理文件的相关操作
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FastFileStorageClient client;

    @Value("${file.server}")
    private String fileServer;

    @PostMapping("upload")
    public ResultBean<String> uploadFile(MultipartFile file){
        //1.获取到文件名后缀
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //2.上传图片到fastdfs
        try {
            StorePath storePath = client.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), extName, null);
            String fullPath = storePath.getFullPath();
            StringBuilder stringBuilder = new StringBuilder(fileServer).append(fullPath);
            return new ResultBean<>("200","success",stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultBean<>("500","系统繁忙",null);
        }
    }

    /**
     * 富文本框上传文件
     * @return
     */
    @PostMapping("batchUpload")
    public WangEditorResultBean batchUpload(MultipartFile[] files){
        String[] data = new String[files.length];
        try {
            for (int i = 0; i < files.length; i++) {
                String originalFilename = files[i].getOriginalFilename();
                String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                StorePath storePath = client.uploadImageAndCrtThumbImage(files[i].getInputStream(), files[i].getSize(), extName, null);
                String fullPath = storePath.getFullPath();
                StringBuilder stringBuilder = new StringBuilder(fileServer).append(fullPath);
                data[i] = stringBuilder.toString();
            }
            return  new WangEditorResultBean("0",data);
        } catch (IOException e) {
            e.printStackTrace();
            return new WangEditorResultBean("-1",null);
        }


    }
}
