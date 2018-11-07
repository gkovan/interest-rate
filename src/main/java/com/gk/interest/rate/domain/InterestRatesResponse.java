package com.gk.interest.rate.domain;

import java.util.List;

import lombok.Data;

@Data
public class InterestRatesResponse {
   List<InterestRate> interestRates;
}
