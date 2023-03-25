package com.clinicaOdontologica.main.entity;


public class Odontologo {
    private Long id;
    private String name;
    private String lastName;
    private int enrolment;

    public Odontologo() {
    }

    public Odontologo(Long id, String name, String lastName, int enrolment) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.enrolment = enrolment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrolment=" + enrolment +
                '}';
    }
}
