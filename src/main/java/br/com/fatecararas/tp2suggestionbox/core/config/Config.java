package br.com.fatecararas.tp2suggestionbox.core.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private final ApiConfigurationProperties properties;

    public Config(@Qualifier("apiConfigurationProperties") ApiConfigurationProperties properties) {
        this.properties = properties;
    }

    @Bean
    public OpenAPI getOpenApiDocumentation() {
        ApiConfigurationProperties.Contact c = properties.getContact();

        return new OpenAPI()
                .info(new Info()
                        .title(properties.getTitle())
                        .description(properties.getDescription())
                        .version(properties.getVersion())
                        .termsOfService(properties.getTermsOfService())
                        .contact(new Contact()
                                .name(c.getName())
                                .url(c.getUrl())
                                .email(c.getEmail()))
                        .license(new License()
                                .name(properties.getLicense())
                                .url(properties.getLicenseUrl())))
                .externalDocs(new ExternalDocumentation()
                        .description(properties.getExternalDocDesc())
                        .url(properties.getExternalDocUrl()));
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
