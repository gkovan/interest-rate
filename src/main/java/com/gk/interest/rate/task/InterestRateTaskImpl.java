package com.gk.interest.rate.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gk.interest.rate.domain.InterestRate;
import com.gk.interest.rate.domain.InterestRatesResponse;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class InterestRateTaskImpl implements InterestRateTask {

	@Override
	public InterestRatesResponse getRates() {
		log.info("Getting latest interest rates");
		InterestRatesResponse response = new InterestRatesResponse();
		List<InterestRate> rateList = new ArrayList<InterestRate>();
		InterestRate rate30Year = new InterestRate();
		rate30Year.setRate(5.0);
		rate30Year.setType("30");
		rateList.add(rate30Year);
		InterestRate rate15Year = new InterestRate();
		rate15Year.setRate(3.5);
		rate15Year.setType("15");
		rateList.add(rate15Year);
		response.setInterestRates(rateList);
		log.info("The interest rates are: {}", response.toString());
		return response;
	}
}
