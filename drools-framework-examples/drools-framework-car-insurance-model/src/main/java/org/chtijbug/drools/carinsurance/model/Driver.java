package org.chtijbug.drools.carinsurance.model;

import java.util.Date;

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
}
