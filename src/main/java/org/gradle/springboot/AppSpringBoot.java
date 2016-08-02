package org.gradle.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.spring.config.EnableRatpack;

@SpringBootApplication
@EnableRatpack
public class AppSpringBoot {

	@Bean
	public Action<Chain> home() {
		return chain -> chain.get(ctx -> ctx.render("Hello " + service().message()));
	}

	@Bean
	public Service service() {
		return () -> "World!";
	}

	public static void main(String... args) throws Exception {
		SpringApplication.run(AppSpringBoot.class, args);
	}

}


