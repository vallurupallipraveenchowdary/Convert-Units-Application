package com.praveen.service;

import org.springframework.stereotype.Service;

import com.praveen.domain.ConversionBean;

@Service
public class ConversionServiceImpl implements ConversionService{
	
	private static Double DISTANCE_RATIO = 0.621371;
    private static Double TEMPERATURE_FACTOR = 273.15;

    @Override
    public ConversionBean convertDistance(ConversionBean conversionBean) {
        if(conversionBean.getConvertFrom().equalsIgnoreCase("KM")){
        	
        	
            conversionBean.setConvertedValue(DISTANCE_RATIO * conversionBean.getConvertValue());
        }else if(conversionBean.getConvertFrom().equalsIgnoreCase("MI")){
            conversionBean.setConvertedValue(conversionBean.getConvertValue() / DISTANCE_RATIO);
        }

        return conversionBean;
    }

    @Override
    public ConversionBean convertTemperature(ConversionBean conversionBean) {
        if(conversionBean.getConvertTo().equalsIgnoreCase("CELCIUS")){
            conversionBean.setConvertedValue(conversionBean.getConvertValue() - TEMPERATURE_FACTOR);
        }else if(conversionBean.getConvertTo().equalsIgnoreCase("KELVIN")){
            conversionBean.setConvertedValue(conversionBean.getConvertValue() + TEMPERATURE_FACTOR);
        }
        return conversionBean;
    }

}
