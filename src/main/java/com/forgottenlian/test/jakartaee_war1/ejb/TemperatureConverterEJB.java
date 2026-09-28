package com.forgottenlian.test.jakartaee_war1.ejb;

import java.math.BigDecimal;

import jakarta.ejb.Stateless;

@Stateless
public class TemperatureConverterEJB {

    private static final BigDecimal CELSIUS_KELVIN = new BigDecimal("273.15");

    public BigDecimal convertCelsiusToKelvin(BigDecimal celsius) {
        return celsius.add(CELSIUS_KELVIN);
    }

    public BigDecimal convertKelvinToCelsius(BigDecimal kelvin) {
        return kelvin.subtract(CELSIUS_KELVIN);
    }

}
