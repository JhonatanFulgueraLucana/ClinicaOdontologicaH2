package com.clinicaOdontologica.main.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDto implements Serializable {
    private String name;
    private String lastName;
    private int enrolment;

    public OdontologoDto() {
    }

    public OdontologoDto(String name, String lastName, int enrolment) {
        this.name = name;
        this.lastName = lastName;
        this.enrolment = enrolment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }
}
