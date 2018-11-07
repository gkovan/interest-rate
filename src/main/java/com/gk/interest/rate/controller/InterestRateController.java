package com.gk.interest.rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.interest.rate.domain.InterestRatesResponse;
import com.gk.interest.rate.task.InterestRateTask;

@RestController
public class InterestRateController {
	
	private InterestRateTask interestRateTask;
	
	@Autowired
	public InterestRateController(InterestRateTask interestRateTask) {
		this.interestRateTask = interestRateTask;
	}
	
	@GetMapping("/interest-rates")
	public InterestRatesResponse getRates() {		
		return interestRateTask.getRates();
	}

}
