package com.mall.mallcenter;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class MallCenterApplicationTests {
    @Autowired
    private FastFileStorageClient client;

    @Test
    void uploadTest() throws FileNotFoundException {
        //上传
        File file = new File("H:\\peace\\zoro1.jpeg");
        FileInputStream fileInputStream = new FileInputStream(file);
        StorePath path = client.uploadImageAndCrtThumbImage(fileInputStream, file.length(), "jpeg", null);
        System.out.println(path.getFullPath());
        System.out.println(path.getGroup());
        System.out.println(path.getPath());
    }
    @Test
    void deleteTest() throws FileNotFoundException {
        client.deleteFile("group1/M00/00/00/wKhtb2DUQ_qAbPumAAIZZWo9TqU84.jpeg");
    }
}
