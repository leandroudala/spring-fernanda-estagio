package app.udala.fernanda.projeto.tecnoestagio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration
public class TecnoestagioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecnoestagioApplication.class, args);
	}

}
