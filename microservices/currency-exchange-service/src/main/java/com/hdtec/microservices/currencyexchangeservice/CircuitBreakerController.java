package com.hdtec.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CircuitBreakerController {

	private Logger logger = 
			LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//	@RateLimiter(name="default")
	@Bulkhead(name="sample-api")
	public String sampleApi() {
		logger.info("Sample api call received");
		return "Sample API";
//	Este trecho de código foi usado para simular um erro na página		
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
//				String.class);
//		return forEntity.getBody();
	}
	
	public String hardcodedResponse(Exception ex) {
		return "Fallback-response execution exchange!!!";
	}
}