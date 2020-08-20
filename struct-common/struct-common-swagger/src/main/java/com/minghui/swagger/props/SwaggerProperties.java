package com.minghui.swagger.props;

import io.swagger.models.Contact;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 9:32 2019/3/28
 * @Modified By:
 */
@Data
@ConfigurationProperties(prefix = "mh.swagger")
public class SwaggerProperties {

    /**
     * 是否开启swagger
     */
    private boolean enable;

    /**
     * 标题
     */
    private String title = "";

    /**
     * 描述
     */
    private String description = "";

    /**
     * 版本
     */
    private String version = "";

    /**
     * 许可证
     */
    private String license = "";

    /**
     * 许可证url
     */
    private String licenseUrl = "";

    /**
     * 人员属性
     */
    private Contact contact = new Contact();

    /**
     * swagger 解析的包路径
     */
    private String basePackage = "";

    /**
     * swagger 解析的url规则
     */
    private List<String> basePath = new ArrayList<>();

    /**
     * swagger 需要排除的url规则
     */
    private List<String> execludePath = new ArrayList<>();

    /**
     * 分组文档
     */
    private Map<String,DocketInfo> docket = new LinkedHashMap<>();

    /**
     * host 信息
     */
    private String host = "";

    private List<GlobalOperationParameter> globalOperationParameters;

    @Data
    public static class GlobalOperationParameter{

        /**
         * 参数名称
         */
        private String name;

        /**
         * 描述
         */
        private String description;

        /**
         * 指定参数类型
         */
        private String modelRef;

        /**
         * 参数放在哪个地方:header,query,path,body,form
         */
        private String parameterType;

        /**
         * 参数是否必须传
         */
        private String required;
    }

    @Data
    public static class DocketInfo{

        /**
         * 标题
         */
        private String title = "";

        /**
         * 描述
         */
        private String description = "";

        /**
         * 版本
         */
        private String version = "";

        /**
         * 许可证
         */
        private String license = "";

        /**
         * 许可证url
         */
        private String licenseUrl = "";

        /**
         * 人员属性
         */
        private Contact contact = new Contact();

        /**
         * swagger 解析的包路径
         */
        private String basePackage = "";

        /**
         * swagger 解析的url规则
         */
        private List<String> basePath = new ArrayList<>();

        /**
         * swagger 需要排除的url规则
         */
        private List<String> execludePath = new ArrayList<>();

        /**
         * 分组文档
         */
        private Map<String,DocketInfo> docket = new LinkedHashMap<>();

        /**
         * host 信息
         */
        private String host = "";

        private List<GlobalOperationParameter> globalOperationParameters;
    }
}
