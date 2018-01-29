package com.demo.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.demo.boot.CoreApplication;

@SpringBootApplication
@ControllerAdvice("com.demo.boot")
public class WebApplication {
	private static final Logger logger = LogManager
			.getLogger(WebApplication.class);

	public static void main(String[] args) {
		logger.info("Web Application Started !!!");

		SpringApplicationBuilder springAppBuilder = new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.CONSOLE)
				.sources(CoreApplication.class, WebApplication.class);

		springAppBuilder.run(args); // delegating to run()
	}

}