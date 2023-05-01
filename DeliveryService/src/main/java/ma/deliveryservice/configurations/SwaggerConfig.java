package ma.deliveryservice.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket apiv1(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("delivery-api-v1")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/v1/**"))
                .build()
                .apiInfo(getApiInfo("1.0.0"));
    }

    private ApiInfo getApiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Delivery API")
                .version(version)
                .description("API docs for exposing Delivery Microservice")
                .contact(new Contact("Mounir El Bakkali","https://mounirelbakkali.ma",
                        "M.ELBAKKALI@STUDENT.YOUCODE.MA"))
                .license("No License")
                .build();
    }
}
