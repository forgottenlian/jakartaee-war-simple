package com.forgottenlian.test.jakartaee_war1.view;

import java.io.Serializable;
import java.math.BigDecimal;

import com.forgottenlian.test.jakartaee_war1.common.ViewUtil;
import com.forgottenlian.test.jakartaee_war1.ejb.TemperatureConverterEJB;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ConverterRequestBean implements Serializable {

    @Inject
    private TemperatureConverterEJB temperatureConverterEJB;

    @Inject
    private ConverterViewBean converterViewBean;

    public void convert() {
        if (!validate()) {
            converterViewBean.setResult(null);
            return;
        }

        BigDecimal from = converterViewBean.getFrom();
        BigDecimal result = null;
        switch (converterViewBean.getTypeOperation()) {
            case CELSIUS_TO_KELVIN:
                result = temperatureConverterEJB.convertCelsiusToKelvin(from);
                break;
            case KELVIN_TO_CELSIUS:
                result = temperatureConverterEJB.convertKelvinToCelsius(from);
                break;
            default:
                ViewUtil.error("TypeOperation %s is not configured", converterViewBean.getTypeOperation());
        }
        converterViewBean.setResult(result);
    }

    private boolean validate() {
        switch (converterViewBean.getTypeOperation()) {
            case CELSIUS_TO_KELVIN:
                break;

            case KELVIN_TO_CELSIUS:
                if (converterViewBean.getFrom() != null &&
                        converterViewBean.getFrom().compareTo(BigDecimal.ZERO) < 0) {
                    ViewUtil.error_with_detail("Invalid Kelvin value.", "Kelvin temperature cannot be less than 0");
                    return false;
                }
        }

        return true;
    }

}
