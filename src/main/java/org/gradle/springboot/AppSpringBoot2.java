package org.gradle.springboot;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.thymeleaf.ThymeleafModule;
import ratpack.spring.config.EnableRatpack;

import static ratpack.thymeleaf.Template.thymeleafTemplate;

@SpringBootApplication
@EnableRatpack
public class AppSpringBoot2 {

	@Bean
	public Action<Chain> home(Service service) {
		return chain -> chain.get(
				ctx -> ctx.render(thymeleafTemplate("myTemplate", m -> m.put("key", "Hello " + service.message()))));
	}

	@Bean
	public ThymeleafModule thymeleafModule() {
		return new ThymeleafModule();
	}

	@Bean
	public Service service() {
		return () -> "World!";
	}

	public static void main(String... args) throws Exception {
		SpringApplication.run(AppSpringBoot2.class, args);
	}

}
