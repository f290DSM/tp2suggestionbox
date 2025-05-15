package br.com.fatecararas.tp2suggestionbox;

import br.com.fatecararas.tp2suggestionbox.core.config.ApiCommonProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ApiCommonProperties.class)
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
