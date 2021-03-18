package com.hdtec.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdtec.microservices.limitsservice.bean.Limits;
import com.hdtec.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;
	
	/**
	 * Step 03
	 * Limits service respond with the values in application.properties through Configuration component 
	 * @return
	 */
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		
		return new Limits(configuration.getMinimum(), 
				configuration.getMaximum());
//		return new Limits(1,1000);
	}
}