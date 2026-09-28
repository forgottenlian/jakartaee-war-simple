package com.forgottenlian.test.jakartaee_war1.view;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ConverterViewBean implements Serializable {

    private TypeOperation typeOperation = TypeOperation.CELSIUS_TO_KELVIN;
    private BigDecimal from;
    private BigDecimal result;

    public ConverterViewBean() {
        this.from = new BigDecimal("0.0");
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public BigDecimal getFrom() {
        return from;
    }

    public void setFrom(BigDecimal from) {
        this.from = from;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

}
