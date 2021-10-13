package com.user.login.modelo.fenix;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.jcip.annotations.Immutable;

@Entity
@Table(name = "estudianteSolicitudVM4A")
@Immutable
public class estudianteSolicitudVM4A {
 
    
    @Id
    private String eidentificacion;

    private String titulo;
    private String nombre;
    private String apellido;
    private String c_nombre;
    private String enombre;
    private String enombre1;
    private String eapellido;
    private String eapellido1;
    private String etelef;
    private String ecorreo;
    
    public estudianteSolicitudVM4A() {
    }

    public estudianteSolicitudVM4A(String titulo, String nombre, String apellido, String c_nombre, String enombre,
            String enombre1, String eapellido, String eapellido1, String etelef, String ecorreo) {
        this.titulo = titulo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.c_nombre = c_nombre;
        this.enombre = enombre;
        this.enombre1 = enombre1;
        this.eapellido = eapellido;
        this.eapellido1 = eapellido1;
        this.etelef = etelef;
        this.ecorreo = ecorreo;
    }

    public String getEidentificacion() {
        return eidentificacion;
    }

    public void setEidentificacion(String eidentificacion) {
        this.eidentificacion = eidentificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getC_nombre() {
        return c_nombre;
    }

    public void setC_nombre(String c_nombre) {
        this.c_nombre = c_nombre;
    }

    public String getEnombre() {
        return enombre;
    }

    public void setEnombre(String enombre) {
        this.enombre = enombre;
    }

    public String getEnombre1() {
        return enombre1;
    }

    public void setEnombre1(String enombre1) {
        this.enombre1 = enombre1;
    }

    public String getEapellido() {
        return eapellido;
    }

    public void setEapellido(String eapellido) {
        this.eapellido = eapellido;
    }

    public String getEapellido1() {
        return eapellido1;
    }

    public void setEapellido1(String eapellido1) {
        this.eapellido1 = eapellido1;
    }

    public String getEtelef() {
        return etelef;
    }

    public void setEtelef(String etelef) {
        this.etelef = etelef;
    }

    public String getEcorreo() {
        return ecorreo;
    }

    public void setEcorreo(String ecorreo) {
        this.ecorreo = ecorreo;
    }

    
    
}
