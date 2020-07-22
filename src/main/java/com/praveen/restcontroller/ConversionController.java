package com.praveen.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.domain.ConversionBean;
import com.praveen.service.ConversionService;

@RestController
public class ConversionController {
	
	@Autowired
    private ConversionService conversionService;

    @PostMapping("/ktom")
    public ResponseEntity<ConversionBean> convertKilometers(@Valid @RequestBody ConversionBean conversionBean){
        return getDistanceConversionBeanResponseEntity(conversionBean);
    }


    @PostMapping("/mtok")
    public ResponseEntity<ConversionBean> convertMiles(@Valid @RequestBody ConversionBean conversionBean){
        return getDistanceConversionBeanResponseEntity(conversionBean);
    }

    private ResponseEntity<ConversionBean> getDistanceConversionBeanResponseEntity(@RequestBody @Valid ConversionBean conversionBean) {
        StringBuffer stringBuffer = new StringBuffer();

        if(conversionBean.getConvertFrom().equalsIgnoreCase("celcius") || conversionBean.getConvertFrom().equalsIgnoreCase("celcius")){
            conversionBean.setMessage("Bad request please try temperature requests");
            return ResponseEntity.status(400)
                    .body(conversionBean);
        }
        conversionBean = conversionService.convertDistance(conversionBean);

        stringBuffer.append(conversionBean.getConvertValue() + " " + conversionBean.getConvertFrom() + " = " + conversionBean.getConvertedValue() + " " + conversionBean.getConvertTo());

        

        conversionBean.setMessage(stringBuffer.toString());
        return ResponseEntity.status(200)
                .body(conversionBean);
    }

    @PostMapping("/ktoc")
    public ResponseEntity<ConversionBean> convertKelvins(@Valid @RequestBody ConversionBean conversionBean){
        return getTemperatureConversionBeanResponseEntity(conversionBean);
    }

    private ResponseEntity<ConversionBean> getTemperatureConversionBeanResponseEntity(@RequestBody @Valid ConversionBean conversionBean) {
        StringBuffer stringBuffer = new StringBuffer();

        if(conversionBean.getConvertFrom().equalsIgnoreCase("KM") || conversionBean.getConvertFrom().equalsIgnoreCase("MI")){
            conversionBean.setMessage("Bad request please try temperature requests");
            return ResponseEntity.status(400)
                    .body(conversionBean);
        }
        conversionBean = conversionService.convertTemperature(conversionBean);

        stringBuffer.append(conversionBean.getConvertValue() + " degrees " + conversionBean.getConvertFrom() + " = " + conversionBean.getConvertedValue() +  " degrees " + conversionBean.getConvertTo());

        conversionBean.setMessage(stringBuffer.toString());

        return ResponseEntity.status(200)
                .body(conversionBean);
    }


    @PostMapping("/ctok")
    public ResponseEntity<ConversionBean> convertCelcius(@Valid @RequestBody ConversionBean conversionBean){
        return getTemperatureConversionBeanResponseEntity(conversionBean);
    }




}
