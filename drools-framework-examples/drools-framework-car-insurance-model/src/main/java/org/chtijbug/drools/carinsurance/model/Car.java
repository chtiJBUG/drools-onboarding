package org.chtijbug.drools.carinsurance.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nheron on 01/09/2016.
 */
public class Car {

    private String registrationNumber;
    private Long fiscalPower;
    private String brandName;
    private String modelName;
    private Date firstRegistrationDate;

    private Cost cost;

    public List<CalculatedElement> calculatedElements = new ArrayList<>();

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    private void addCalculatedElement(CalculatedElement calculatedElement){
        this.calculatedElements.add(calculatedElement);
    }

    public List<CalculatedElement> getCalculatedElements() {
        return calculatedElements;
    }

    public void setCalculatedElements(List<CalculatedElement> calculatedElements) {
        this.calculatedElements = calculatedElements;
    }
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("registrationNumber='").append(registrationNumber).append('\'');
        sb.append(", fiscalPower=").append(fiscalPower);
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", modelName='").append(modelName).append('\'');
        sb.append(", firstRegistrationDate=").append(firstRegistrationDate);
        sb.append(", cost=").append(cost);
        sb.append(", calculatedElements=").append(calculatedElements);
        sb.append('}');
        return sb.toString();
    }
}
