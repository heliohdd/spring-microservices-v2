package com.hdtec.microservices.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdtec.microservices.limitsservice.bean.Limits;

@RestController
public class LimitsController {

	/**
	 * This Hardcoded Limits service respond with the values in parenthesis 
	 * @return
	 */
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(1,1000);
	}
}