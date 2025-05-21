package br.com.fatecararas.tp2suggestionbox.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api.common")
public class ApiConfigurationProperties {
    private String version;
    private String title;
    private String description;
    private String termsOfService;
    private String license;
    private String licenseUrl;
    private String externalDocDesc;
    private String externalDocUrl;

    private Contact contact;

    @Data
    public static class Contact {
        private String name;
        private String url;
        private String email;
    }
}