package com.user.login.modelo.titulacion;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;




@Entity
@Table(name = "estudiantet")

public class estudiantet {

    @Id
    private String cedula;

    private String nombre;

    private String correo;

    public estudiantet() {
    }


    public estudiantet(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}   
