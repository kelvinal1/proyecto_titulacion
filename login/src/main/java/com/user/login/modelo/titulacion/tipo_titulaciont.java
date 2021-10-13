package com.user.login.modelo.titulacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_titulaciont")
public class tipo_titulaciont {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_titulacion;

    private String nombre;

    public tipo_titulaciont() {
    }

    public tipo_titulaciont(Integer id_tipo_titulacion, String nombre) {
        this.id_tipo_titulacion = id_tipo_titulacion;
        this.nombre = nombre;
    }

    public Integer getId_tipo_titulacion() {
        return id_tipo_titulacion;
    }

    public void setId_tipo_titulacion(Integer id_tipo_titulacion) {
        this.id_tipo_titulacion = id_tipo_titulacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
