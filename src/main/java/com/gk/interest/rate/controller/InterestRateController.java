package com.gk.interest.rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.interest.rate.domain.InterestRatesResponse;
import com.gk.interest.rate.task.InterestRateTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InterestRateController {
	
	private InterestRateTask interestRateTask;
	
	@Autowired
	public InterestRateController(InterestRateTask interestRateTask) {
		this.interestRateTask = interestRateTask;
	}
	
	@GetMapping("/interest-rates")
	public InterestRatesResponse getRates() {	
		log.info("In controller of /interest-rates");
		return interestRateTask.getRates();
	}

}
