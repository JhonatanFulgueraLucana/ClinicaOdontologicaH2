package com.clinicaOdontologica.main.entity;


import java.sql.Date;

public class Paciente {
    private Long id;
    private String nome;
    private String lastName;
    private String home;
    private Domicilio domicilio;
    private int dni;
    private Date date;

    public Paciente() {
    }

    public Paciente(Long id, String nome, String lastName, String home, int dni, Date date) {
        this.id = id;
        this.nome = nome;
        this.lastName = lastName;
        this.home = home;
        this.dni = dni;
        this.date = date;
    }

    public Paciente(Long id, String nome, String lastName, String home, Domicilio domicilio, int dni, Date date) {
        this.id = id;
        this.nome = nome;
        this.lastName = lastName;
        this.home = home;
        this.domicilio = domicilio;
        this.dni = dni;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", lastName='" + lastName + '\'' +
                ", home='" + home + '\'' +
                ", domicilio=" + domicilio +
                ", dni=" + dni +
                ", date=" + date +
                '}';
    }
}
