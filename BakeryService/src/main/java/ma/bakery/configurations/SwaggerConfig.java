package ma.bakery.configurations;


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
// to transalate validation annotation (@NotNull,@Size ...) in the documentation of the API
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {


    // default of what generated as documentation

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any(  ))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    // customize API LEVEL using APIInfo object
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Bakery API")
                .version("1.0")
                .description("API docs for exposing Bakery Microservice")
                .contact(new Contact("Mounir El Bakkali","https://mounirelbakkali.ma",
                        "M.ELBAKKALI@STUDENT.YOUCODE.MA"))
                .license("No License")
                .build();
    }
}
