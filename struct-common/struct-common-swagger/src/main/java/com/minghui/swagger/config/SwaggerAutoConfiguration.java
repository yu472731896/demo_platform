package com.minghui.swagger.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.minghui.swagger.props.SwaggerProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 10:06 2019/3/28
 * @Modified By:
 */
@Import({
        com.ropeok.swagger.config.SwaggerConfig.class
})
public class SwaggerAutoConfiguration implements BeanFactoryAware {

    private static final String AUTH_KEY = "Authorization";

    private BeanFactory beanFactory;

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties(){
        return new SwaggerProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "minghui.swagger.enable",matchIfMissing = true)
    public List<Docket> createRestApi(SwaggerProperties swaggerProperties){
        ConfigurableBeanFactory factory = (ConfigurableBeanFactory) beanFactory;
        List<Docket> dockets = new LinkedList<>();

        if (swaggerProperties.getDocket().size() == 0){
            final Docket docket = createDocket(swaggerProperties);
            factory.registerSingleton("defaultDocket",docket);
            dockets.add(docket);
            return dockets;
        }
        for (String groupName:swaggerProperties.getDocket().keySet()){
            SwaggerProperties.DocketInfo docketInfo = swaggerProperties.getDocket().get(groupName);
            ApiInfo apiInfo = new ApiInfoBuilder()
                    .title(docketInfo.getTitle().isEmpty()?swaggerProperties.getTitle():docketInfo.getTitle())
                    .description(docketInfo.getDescription().isEmpty()?swaggerProperties.getDescription():docketInfo.getDescription())
                    .version(docketInfo.getVersion().isEmpty()?swaggerProperties.getVersion():docketInfo.getVersion())
                    .license(docketInfo.getLicense().isEmpty()?docketInfo.getLicense():docketInfo.getLicense())
                    .licenseUrl(docketInfo.getLicenseUrl().isEmpty()?docketInfo.getLicenseUrl():swaggerProperties.getLicenseUrl())
                    .contact(new Contact(
                            docketInfo.getContact().getName().isEmpty()? swaggerProperties.getContact().getName(): docketInfo.getContact().getName(),
                            docketInfo.getContact().getUrl().isEmpty()?swaggerProperties.getContact().getUrl():docketInfo.getContact().getUrl(),
                            docketInfo.getContact().getEmail().isEmpty()?docketInfo.getContact().getEmail():docketInfo.getContact().getEmail()))
                    .build();
            // base-path 处理
            if (docketInfo.getBasePath().isEmpty()){
                docketInfo.getBasePath().add("/**");
            }

            List<Predicate<String>> basePath = new ArrayList<>(docketInfo.getBasePath().size());
            for (String path:docketInfo.getBasePath()){
                basePath.add(PathSelectors.ant(path));
            }

            //exclude-path
            List<Predicate<String>> excludePath = new ArrayList<>(docketInfo.getExecludePath().size());
            for (String path:docketInfo.getExecludePath()){
                excludePath.add(PathSelectors.ant(path));
            }

            Docket docket = new Docket(DocumentationType.SWAGGER_2)
                    .host(swaggerProperties.getHost())
                    .apiInfo(apiInfo)
                    .globalOperationParameters(assemblyGlobalOperationParameters(swaggerProperties.getGlobalOperationParameters(),
                            docketInfo.getGlobalOperationParameters()))
                    .groupName(groupName)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(docketInfo.getBasePackage()))
                    .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)),Predicates.or(basePath)))
                    .build()
                    .securitySchemes(securitySchemes())
                    .securityContexts(securityContexts());
            factory.registerSingleton(groupName,docket);
            dockets.add(docket);
        }
        return dockets;
    }

    /**
     *
     * @param swaggerProperties
     * @return
     */
    private Docket createDocket(SwaggerProperties swaggerProperties) {
        ApiInfo apiInfo = new ApiInfoBuilder().title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(),swaggerProperties.getContact().getUrl(),
                        swaggerProperties.getContact().getEmail()))
                .build();
        // base-path 处理
        if (swaggerProperties.getBasePath().isEmpty()){
            swaggerProperties.getBasePath().add("/**");
        }

        List<Predicate<String>> basePath = new ArrayList<>(swaggerProperties.getBasePath().size());
        for (String path:swaggerProperties.getBasePath()){
            basePath.add(PathSelectors.ant(path));
        }

        //exclude-path
        List<Predicate<String>> excludePath = new ArrayList<>(swaggerProperties.getExecludePath().size());
        for (String path:swaggerProperties.getExecludePath()){
            excludePath.add(PathSelectors.ant(path));
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerProperties.getHost())
                .apiInfo(apiInfo)
                .globalOperationParameters(assemblyGlobalOperationParameters(swaggerProperties.getGlobalOperationParameters(),
                        swaggerProperties.getGlobalOperationParameters()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)),Predicates.or(basePath)))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeys = new ArrayList<>(1);
        ApiKey apiKey = new ApiKey(AUTH_KEY,AUTH_KEY,"header");
        apiKeys.add(apiKey);
        return apiKeys;
    }

    private List<SecurityContext> securityContexts(){
        List<SecurityContext> contexts = new ArrayList<>(1);
        SecurityContext context = SecurityContext.builder().securityReferences(defaultAuth())
                .build();
        contexts.add(context);
        return contexts;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope scope = new AuthorizationScope("gloabl","accessEverything");
        AuthorizationScope[] scopes = new AuthorizationScope[1];
        scopes[0] = scope;
        List<SecurityReference> references = new ArrayList<>(1);
        references.add(new SecurityReference(AUTH_KEY,scopes));
        return references;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }




    private List<Parameter> assemblyGlobalOperationParameters(
            List<SwaggerProperties.GlobalOperationParameter> globalOperationParameters,
            List<SwaggerProperties.GlobalOperationParameter> docketOperationParameters){
        if (Objects.isNull(docketOperationParameters) || docketOperationParameters.isEmpty()){
            return buildGlobalOperationParametersFormSwaggerProperties(globalOperationParameters);
        }
        Set<String> docketNames = docketOperationParameters.stream()
                .map(SwaggerProperties.GlobalOperationParameter::getName)
                .collect(Collectors.toSet());
        List<SwaggerProperties.GlobalOperationParameter> resultOperationParamters = Lists.newArrayList();
        if (Objects.nonNull(globalOperationParameters)){
            for (SwaggerProperties.GlobalOperationParameter parameter:globalOperationParameters){
                if (!docketNames.contains(parameter.getName())){
                    resultOperationParamters.add(parameter);
                }
            }
        }
        resultOperationParamters.addAll(docketOperationParameters);
        return buildGlobalOperationParametersFormSwaggerProperties(globalOperationParameters);

    }

    private List<Parameter> buildGlobalOperationParametersFormSwaggerProperties(
            List<SwaggerProperties.GlobalOperationParameter> globalOperationParameters) {
        List<Parameter> parameters = Lists.newArrayList();
        if (Objects.isNull(globalOperationParameters)){
            return parameters;
        }

        for (SwaggerProperties.GlobalOperationParameter globalOperationParameter:globalOperationParameters){
            parameters.add(new ParameterBuilder().name(globalOperationParameter.getName())
            .description(globalOperationParameter.getDescription())
            .modelRef(new ModelRef(globalOperationParameter.getModelRef()))
            .parameterType(globalOperationParameter.getParameterType())
            .required(Boolean.parseBoolean(globalOperationParameter.getRequired()))
            .build());
        }
        return parameters;
    }
}
