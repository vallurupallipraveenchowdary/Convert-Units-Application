package com.praveen.service;

import com.praveen.domain.ConversionBean;

public interface ConversionService {

	ConversionBean convertDistance(ConversionBean conversionBean);

    ConversionBean convertTemperature(ConversionBean conversionBean);
	
}
