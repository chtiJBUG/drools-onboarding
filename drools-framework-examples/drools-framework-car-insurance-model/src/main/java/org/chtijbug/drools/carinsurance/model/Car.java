package org.chtijbug.drools.carinsurance.model;

import java.util.Date;

/**
 * Created by nheron on 01/09/2016.
 */
public class Car {

    private String registrationNumber;
    private Long fiscalPower;
    private String brandName;
    private String modelName;
    private Date firstRegistrationDate;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Long getFiscalPower() {
        return fiscalPower;
    }

    public void setFiscalPower(Long fiscalPower) {
        this.fiscalPower = fiscalPower;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Date firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }
}
