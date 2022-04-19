package cccc.vlm;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.PathMatcher;

@SpringBootApplication
public class CccEquipmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CccEquipmentManagementApplication.class, args);
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("")
                .pathsToMatch("/v1/**")
                .build();
    }

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(
                        new Info().title("뷀렙 장비 반출/반입 기록부")
                                .description("장비를 잘 관리하기 위함")
                                .version("v0.0.1-beta")
                                .license(new License()
                                        .name("Philips-413")
                                        .url(""))
                                )
                                .externalDocs(new ExternalDocumentation()
                                        .description("뷀렙 장비 반출/반입 기록부")
                                        .url("")
                                );
    }

}
