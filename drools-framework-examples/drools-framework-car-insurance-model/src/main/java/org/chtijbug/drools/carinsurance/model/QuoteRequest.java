package org.chtijbug.drools.carinsurance.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nheron on 01/09/2016.
 */
@XmlRootElement
public class QuoteRequest {

    private List<Driver> drivers = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private Date quoteDate;
    private Date desiredInsuranceStartDate;
    private List<Rule> ruleLists = new ArrayList<>();

    private List<CalculatedElement> calculatedElements = new ArrayList<>();

    private void addCalculatedElement(CalculatedElement calculatedElement){
        this.calculatedElements.add(calculatedElement);
    }

    public List<CalculatedElement> getCalculatedElements() {
        return calculatedElements;
    }

    public void setCalculatedElements(List<CalculatedElement> calculatedElements) {
        this.calculatedElements = calculatedElements;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
    }

    public Date getDesiredInsuranceStartDate() {
        return desiredInsuranceStartDate;
    }

    public void setDesiredInsuranceStartDate(Date desiredInsuranceStartDate) {
        this.desiredInsuranceStartDate = desiredInsuranceStartDate;
    }

    public List<Rule> getRuleLists() {
        return ruleLists;
    }

    public void setRuleLists(List<Rule> ruleLists) {
        this.ruleLists = ruleLists;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuoteRequest{");
        sb.append("drivers=").append(drivers);
        sb.append(", cars=").append(cars);
        sb.append(", quoteDate=").append(quoteDate);
        sb.append(", desiredInsuranceStartDate=").append(desiredInsuranceStartDate);
        sb.append(", ruleLists=").append(ruleLists);
        sb.append(", calculatedElements=").append(calculatedElements);
        sb.append('}');
        return sb.toString();
    }
}
