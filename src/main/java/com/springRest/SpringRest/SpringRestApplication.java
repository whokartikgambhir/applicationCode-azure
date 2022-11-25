package com.springRest.SpringRest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringRestApplication.class).registerShutdownHook(true).run(args);
	}

}
