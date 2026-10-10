package cn.XF.client.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

/**
 * swagger配置数据
 *
 * @author zhuwenkai
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger API")
                .description("消息队列接口使用平台")
                .termsOfServiceUrl("")
                .contact(new Contact("localhost", "http://localhost/", ""))
                .version("2.0")
                .build();
    }

    /**
     * 设置授权信息
     */
    private List<ApiKey> securitySchemes() {
        // 在请求头header添加一个名为Authorization的token
        return Collections.singletonList(new ApiKey(HttpHeaders.AUTHORIZATION, HttpHeaders.AUTHORIZATION, "header"));
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(
                                Collections.singletonList(new SecurityReference("Authorization",
                                        new AuthorizationScope[]{new AuthorizationScope("global", "")}
                                )))
                        // 可通过配置正则表达式去排除一些不需要携带token访问的接口 这里不做特殊处理，全部接口访问都需要携带
                        // 比如.forPaths(PathSelectors.regex("^(?!auth).*$"))  对所有包含"auth"的接口不需要使用securitySchemes
                        .forPaths(PathSelectors.any())
                        .build()
        );
    }
}
