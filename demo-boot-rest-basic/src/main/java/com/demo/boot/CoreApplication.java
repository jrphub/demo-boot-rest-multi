package com.demo.boot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CoreApplication implements ApplicationRunner {
	private static final Logger logger = LogManager.getLogger(CoreApplication.class);

	//@Value("${module.name}")
    //private String appName;
	
	@Value("${log.dir}")
	private String logDir;
	
	@Value("${profile}")
	private String profile;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*Accessing arguments passed to the application*/
		//boolean debug = args.containsOption("debug");
		//List<String> files = args.getNonOptionArgs();
		// if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
		
		/*
		 * Accessing properties from application.properties file
		 */
		//logger.info("Reading from Module specific properties file");
		//logger.info(appName + " : Core Application Started!!!");
		//logger.info("log directory : " + logDir);
		
		logger.info("Reading Profile specific properties file");
		logger.info("Profile Name : " + profile);
		
	}
}
