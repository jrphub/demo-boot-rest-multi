package com.demo.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="app")
public class ApplicationConfigUsingPrefix {
	
	private List<String> appProps = new ArrayList<String>();
	
	public List<String> getAppProps() {
		return this.appProps;
	}
}
