package org.chtijbug.drools.carinsurance.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nheron on 01/09/2016.
 */
public class Driver {

    private String name;
    private String surname;
    private Date birthDate;
    private Date graduationDrivingLicenceDate;
    private Long numberAccidentLast2Years;
    private Long numberAccidentLast5Years;

    private Cost cost;

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    private List<CalculatedElement> calculatedElements = new ArrayList<>();

    public void addCalculatedElement(CalculatedElement calculatedElement){
        this.calculatedElements.add(calculatedElement);
    }

    public List<CalculatedElement> getCalculatedElements() {
        return calculatedElements;
    }

    public void setCalculatedElements(List<CalculatedElement> calculatedElements) {
        this.calculatedElements = calculatedElements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getGraduationDrivingLicenceDate() {
        return graduationDrivingLicenceDate;
    }

    public void setGraduationDrivingLicenceDate(Date graduationDrivingLicenceDate) {
        this.graduationDrivingLicenceDate = graduationDrivingLicenceDate;
    }

    public Long getNumberAccidentLast2Years() {
        return numberAccidentLast2Years;
    }

    public void setNumberAccidentLast2Years(Long numberAccidentLast2Years) {
        this.numberAccidentLast2Years = numberAccidentLast2Years;
    }

    public Long getNumberAccidentLast5Years() {
        return numberAccidentLast5Years;
    }

    public void setNumberAccidentLast5Years(Long numberAccidentLast5Years) {
        this.numberAccidentLast5Years = numberAccidentLast5Years;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Driver{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", graduationDrivingLicenceDate=").append(graduationDrivingLicenceDate);
        sb.append(", numberAccidentLast2Years=").append(numberAccidentLast2Years);
        sb.append(", numberAccidentLast5Years=").append(numberAccidentLast5Years);
        sb.append(", cost=").append(cost);
        sb.append(", calculatedElements=").append(calculatedElements);
        sb.append('}');
        return sb.toString();
    }
}
