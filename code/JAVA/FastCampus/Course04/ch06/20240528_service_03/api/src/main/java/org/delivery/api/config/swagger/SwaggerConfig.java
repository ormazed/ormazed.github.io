package org.delivery.api.config.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.core.jackson.ModelResolver;
@Configuration
public class SwaggerConfig {

    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper){ // objectmapper.ObjectMapperConfig 에 작성한 objectMapper 를 의미
        return new ModelResolver(objectMapper);
    }
}
