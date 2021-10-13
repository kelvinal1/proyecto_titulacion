package com.user.login.modelo.fenix;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import net.jcip.annotations.Immutable;

@Entity
@Table(name="estudiantesVM4A")
@Immutable
public class estudiantesVM4A {

    
    @Id
    private Integer ida;

    private Integer idp;

    private String cedula;
    private String apellido;
    private String apellido1;
    private String nombre;
    private String nombre1;
    private String correo;
    private String telefono;
    
    private boolean activo;

    public estudiantesVM4A() {
    }

    public estudiantesVM4A(Integer ida, Integer idp, String cedula, String apellido, String apellido1, String nombre,
            String nombre1, String correo, String telefono, boolean activo) {
        this.ida = ida;
        this.idp = idp;
        this.cedula = cedula;
        this.apellido = apellido;
        this.apellido1 = apellido1;
        this.nombre = nombre;
        this.nombre1 = nombre1;
        this.correo = correo;
        this.telefono = telefono;
        this.activo = activo;
    }

   
    public Integer getIda() {
        return ida;
    }

    public void setIda(Integer ida) {
        this.ida = ida;
    }

    public Integer getIdp() {
        return idp;
    }

    public void setIdp(Integer idp) {
        this.idp = idp;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
    


    



}