package com.gk.interest.rate.task;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gk.interest.rate.domain.InterestRatesResponse;

public class InterestRateTaskTests {

	@Test
	public void getRatesTestShouldReturnTwoRatesFor30and15Year() {
		// given
		
		// when invoking task to get rates
		InterestRateTask intRates = new InterestRateTaskImpl();
		InterestRatesResponse intRatesResponse = intRates.getRates();
		
		// then expect two items in the list representing 30 year and 15 year rates
		assertEquals(2, intRatesResponse.getInterestRates().size());		
	}

}
