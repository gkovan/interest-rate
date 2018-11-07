package com.gk.interest.rate.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.gk.interest.rate.domain.InterestRate;
import com.gk.interest.rate.domain.InterestRatesResponse;
import com.gk.interest.rate.task.InterestRateTask;

@RunWith(MockitoJUnitRunner.class)
public class InterestRateControllerTest {
	@Mock
	InterestRateTask interestRateTask;
	
	@InjectMocks
	InterestRateController interestRateController;
	
	@Test
	public void getInterestRates() {
		// setup mock interest rate task
		InterestRatesResponse mockResponse = new InterestRatesResponse();
		
		InterestRate rate = new InterestRate();
		rate.setRate(5.0);
		List<InterestRate> ratesList = new ArrayList<InterestRate>();
		ratesList.add(rate);
		mockResponse.setInterestRates(ratesList);	
		when(interestRateTask.getRates()).thenReturn(mockResponse);
		
		// given
		
		// when invoking get int rates controller
		InterestRatesResponse intRatesResponse = interestRateController.getRates();
		
		// then
		
		assertThat(intRatesResponse, instanceOf(InterestRatesResponse.class) );
		assertNotNull(intRatesResponse.getInterestRates());
		assertNotEquals(intRatesResponse.getInterestRates().size(), 0);
		
	}

}
