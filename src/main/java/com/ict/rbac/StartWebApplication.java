package com.ict.rbac;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @see https://howtodoinjava.com/spring-boot/spring-boot-tutorial-with-hello-world-example/
 *
 */
@Configuration
@ComponentScan(value = { "com.ict.rbac" })
@EnableAutoConfiguration
@ServletComponentScan
public class StartWebApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(StartWebApplication.class);
	

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(StartWebApplication.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Hello World Command Line");
	}
}
