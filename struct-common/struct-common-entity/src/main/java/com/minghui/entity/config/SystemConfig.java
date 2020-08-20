package com.minghui.entity.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:chenql
 * @Description: 系统配置项
 * @Date:Created in 16:34 2019/4/25
 * @Modified By:
 */
@Configuration
@Data
public class SystemConfig {

    @Value("${save.single.engine.history:false}")
    private boolean saveSingleEngineHistory;

    //底库图片地址
    @Value("${static.image.address:http://127.0.0.1:8090/staticImage/getFile?wjbs=}")
    private String staticImageAddress;

    //抓拍人脸图片地址
    @Value("${capture.face.image.address:http://127.0.0.1:8090/captureImage/getFaceImage?captureId=}")
    private String captureFaceImageAddress;

    //抓拍场景图片地址
    @Value("${capture.scene.image.address:http://127.0.0.1:8090/captureImage/getPanoramaImage?captureId=}")
    private String captureSceneImageAddress;
}
