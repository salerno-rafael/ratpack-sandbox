package org.gradle.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	@Bean
	public Service service() {
		return () -> "World!";
	}
}
