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
}
